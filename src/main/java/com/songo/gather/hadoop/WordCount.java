/**
 * 
 */
package com.songo.gather.hadoop;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;
import org.apache.hadoop.mapred.jobcontrol.Job;

/**
 * <p>decription:</p>
 * <p>date:2015年7月28日 上午9:29:05</p>
 * @author gsu·napoleon
 */
public class WordCount {

	private static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {

		private static final IntWritable writable = new IntWritable(1);
		private Text word = new Text();
		
		/* (non-Javadoc)
		 * @see org.apache.hadoop.mapred.Mapper#map(java.lang.Object, java.lang.Object, org.apache.hadoop.mapred.OutputCollector, org.apache.hadoop.mapred.Reporter)
		 */
		@Override
		public void map(LongWritable key, Text value,
				OutputCollector<Text, IntWritable> output, Reporter reporter)
				throws IOException {
			
			String line = value.toString();
			StringTokenizer token = new StringTokenizer(line);
			while (token.hasMoreTokens()) {
				word.set(token.nextToken());
				output.collect(word, writable);
			}
			
		}
		
	}
	
	private static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable> {

		/* (non-Javadoc)
		 * @see org.apache.hadoop.mapred.Reducer#reduce(java.lang.Object, java.util.Iterator, org.apache.hadoop.mapred.OutputCollector, org.apache.hadoop.mapred.Reporter)
		 */
		@Override
		public void reduce(Text key, Iterator<IntWritable> values,
				OutputCollector<Text, IntWritable> output, Reporter reporter)
				throws IOException {
			int sum = 0;
			while (values.hasNext()) {
				sum += values.next().get();
			}
			output.collect(key, new IntWritable(sum));			
		}

	}
	
	/**
	 * <p>decription:</p>
	 * <p>date:2015年7月28日 上午9:29:06</p>
	 * @author gsu·napoleon
	 * @param args
	 */
	public static void main(String[] args) {
		JobConf job = new JobConf(WordCount.class);
		
		job.setJobName("Word Count");

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setMapperClass(Map.class);
		job.setCombinerClass(Reduce.class);
		job.setReducerClass(Reduce.class);
		
		job.setInputFormat(TextInputFormat.class);
		job.setOutputFormat(TextOutputFormat.class);

		job.set("hadoop.tmp.dir", "D:\\tmp\\gsu-chenbiao\\");
		job.setWorkingDirectory(new Path("D:\\data\\hadoop\\"));
		
		FileInputFormat.setInputPaths(job, "D:\\data\\hadoop\\input\\");
		FileOutputFormat.setOutputPath(job, new Path("D:\\data\\hadoop\\output\\"));
		
		try {
			JobClient client = new JobClient();
		
//			Configuration conf = new Configuration();
//			conf.setBoolean("dfs.permissions", false);
//			client.getFs().setConf(conf);
			client.runJob(job);
//			JobClient.runJob(job);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
