package com.code.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


//validating Ip Address
public class Example10 {
	public static void main(String[] args) {
		String str = "1.1.1.123";
		Pattern p = Pattern.compile("^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$");
		Matcher m = p.matcher(str);
		System.out.println(m.find());
	}

	// replacing multiple spaces into single space. It covers tab, new line, any
	// kind of spaces replaces with single space.
	@Test
	public void test1() {
		String str = "Hi   Hello How 			R u?";
		Pattern p = Pattern.compile("\\s+");
		Matcher m = p.matcher(str);
		str = m.replaceAll(" ");
		System.out.println(str);

	}

	@Test
	public void test2() {
		Pattern p = Pattern.compile("^[a-zA-Z0-9 ,_]*$");
		Matcher m = p.matcher("Srilatha 34");
		System.out.println(m.matches());
	}
}
