/**
 * 
 */
package com.songo.gather.io.console.table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * decription:
 * </p>
 * <p>
 * date:2015年9月2日 下午3:25:31
 * </p>
 * 
 * @author gsu·napoleon
 */
public final class AnsiUtils {

	// Color code strings from:
	// http://www.topmudsites.com/forums/mud-coding/413-java-ansi.html
	public static final String SANE = "\u001B[0m";

	public static final String HIGH_INTENSITY = "\u001B[1m";
	public static final String LOW_INTENSITY = "\u001B[2m";

	public static final String ITALIC = "\u001B[3m";
	public static final String UNDERLINE = "\u001B[4m";
	public static final String BLINK = "\u001B[5m";
	public static final String RAPID_BLINK = "\u001B[6m";
	public static final String REVERSE_VIDEO = "\u001B[7m";
	public static final String INVISIBLE_TEXT = "\u001B[8m";

	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String MAGENTA = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";

	public static final String BACKGROUND_BLACK = "\u001B[40m";
	public static final String BACKGROUND_RED = "\u001B[41m";
	public static final String BACKGROUND_GREEN = "\u001B[42m";
	public static final String BACKGROUND_YELLOW = "\u001B[43m";
	public static final String BACKGROUND_BLUE = "\u001B[44m";
	public static final String BACKGROUND_MAGENTA = "\u001B[45m";
	public static final String BACKGROUND_CYAN = "\u001B[46m";
	public static final String BACKGROUND_WHITE = "\u001B[47m";

	public static final AnsiUtils HighIntensity = new AnsiUtils(HIGH_INTENSITY);
	public static final AnsiUtils Bold = HighIntensity;
	public static final AnsiUtils LowIntensity = new AnsiUtils(LOW_INTENSITY);
	public static final AnsiUtils Normal = LowIntensity;

	public static final AnsiUtils Italic = new AnsiUtils(ITALIC);
	public static final AnsiUtils Underline = new AnsiUtils(UNDERLINE);
	public static final AnsiUtils Blink = new AnsiUtils(BLINK);
	public static final AnsiUtils RapidBlink = new AnsiUtils(RAPID_BLINK);

	public static final AnsiUtils Black = new AnsiUtils(BLACK);
	public static final AnsiUtils Red = new AnsiUtils(RED);
	public static final AnsiUtils Green = new AnsiUtils(GREEN);
	public static final AnsiUtils Yellow = new AnsiUtils(YELLOW);
	public static final AnsiUtils Blue = new AnsiUtils(BLUE);
	public static final AnsiUtils Magenta = new AnsiUtils(MAGENTA);
	public static final AnsiUtils Cyan = new AnsiUtils(CYAN);
	public static final AnsiUtils White = new AnsiUtils(WHITE);

	public static final AnsiUtils BgBlack = new AnsiUtils(BACKGROUND_BLACK);
	public static final AnsiUtils BgRed = new AnsiUtils(BACKGROUND_RED);
	public static final AnsiUtils BgGreen = new AnsiUtils(BACKGROUND_GREEN);
	public static final AnsiUtils BgYellow = new AnsiUtils(BACKGROUND_YELLOW);
	public static final AnsiUtils BgBlue = new AnsiUtils(BACKGROUND_BLUE);
	public static final AnsiUtils BgMagenta = new AnsiUtils(BACKGROUND_MAGENTA);
	public static final AnsiUtils BgCyan = new AnsiUtils(BACKGROUND_CYAN);
	public static final AnsiUtils BgWhite = new AnsiUtils(BACKGROUND_WHITE);

	final private String[] codes;
	final private String codes_str;

	public AnsiUtils(String... codes) {
		this.codes = codes;
		String _codes_str = "";
		for (String code : codes) {
			_codes_str += code;
		}
		codes_str = _codes_str;
	}

	public AnsiUtils and(AnsiUtils other) {
		List<String> both = new ArrayList<String>();
		Collections.addAll(both, codes);
		Collections.addAll(both, other.codes);
		return new AnsiUtils(both.toArray(new String[] {}));
	}

	public String colorize(String original) {
		return codes_str + original + SANE;
	}

	public String format(String template, Object... args) {
		return colorize(String.format(template, args));
	}

	/**
	 * @return the codes_str
	 */
	public String getCodes_str() {
		return codes_str;
	}

	public static void main(String[] args) {
		System.out.println(AnsiUtils.Red.format("Hello, %s", "Napoleon"));
		System.out.println(AnsiUtils.Red.colorize("Napoleon"));
	}
	
}
