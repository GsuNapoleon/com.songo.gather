/*
 * Copyright (C) 2011 Clearspring Technologies, Inc. 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.songo.gather.algorithm.loglog.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.songo.gather.algorithm.loglog.stream.cardinality.AdaptiveCounting;
import com.songo.gather.algorithm.loglog.stream.cardinality.Cardinality;


/**
 * Simple cardinality estimation command line utility
 * <p/>
 * Usage:
 * > obycount [update-rate]
 * <p/>
 * update-rate: output results after every update-rate elements/lines
 * <p/>
 * Example:
 * > cat elements.txt | obycount
 */
public class ObyCount {

    public static void usage() {
        System.err.println
                (
                        "obycount [update-rate]\n" +
                        "\n" +
                        "update-rate: output results after every update-rate elements/lines" +
                        "\n" +
                        "Example:" +
                        "> cat elements.txt | obycount" +
                        "\n"
                );

        System.exit(-1);
    }

    public static void main(String[] args) throws IOException {
        long updateRate = -1;
        long count = 0;

        if (args.length > 0) {
            try {
                updateRate = Long.parseLong(args[0]);
            } catch (NumberFormatException e) {
                System.err.print("Bad update rate: '" + args[0] + "'  Update rate must be an integer.");
                usage();
            }
        }

        Cardinality card = AdaptiveCounting.Builder.obyCount(Integer.MAX_VALUE).build();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String line = null;
        while ((line = in.readLine()) != null) {
            card.offer(line);
            count++;

            if (updateRate > 0 && count % updateRate == 0) {
                System.out.println(formatSummary(count, card.cardinality()));
            }
        }

        System.out.println(formatSummary(count, card.cardinality()));
    }

    protected static String formatSummary(long count, long cardinality) {
        String cntStr = Long.toString(count);
        int len = cntStr.length();
        int l1 = Math.max(len, 10);
        int l2 = Math.max(len, 20);
        String fmt = "%" + l1 + "s %" + l2 + "s";
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(fmt, "Item Count", "Cardinality Estimate")).append('\n');
        sb.append(String.format(fmt, TopKUtils.string('-', l1), TopKUtils.string('-', l2))).append('\n');
        sb.append(String.format(fmt, count, cardinality)).append('\n');
        return sb.toString();
    }
}
