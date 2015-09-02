/**
 * 
 */
package com.songo.gather.io.console.table;

import static org.junit.Assert.*;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.AnsiRenderer;
import org.junit.Before;
import org.junit.Test;

/**
 * <p>decription:</p>
 * <p>date:2015年9月2日 下午3:29:30</p>
 * @author gsu·napoleon
 */
public class AnsiColorTest {

	/**
	 * <p>decription:</p>
	 * <p>date:2015年9月2日 下午3:29:30</p>
	 * @author gsu·napoleon
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
//		System.out.println(AnsiUtils.Red.format("Hello, %s", "Napoleon"));
//		System.out.println(AnsiUtils.Red.colorize("Napoleon"));
//		AnsiConsole.err.println(AnsiUtils.Red.colorize("Napoleon"));
		Ansi ansi = Ansi.ansi().bg(Ansi.Color.RED).a("Napoleon").bg(Ansi.Color.YELLOW).fg(Ansi.Color.BLUE);
		System.out.println(ansi.a("Test").reset().toString());
		String str = AnsiRenderer.render("@|bold foo|@");
        System.out.println(str);
	}

}
