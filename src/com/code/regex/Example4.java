package com.code.regex;

import java.util.regex.Pattern;

import org.junit.Test;


public class Example4 {
	@Test
	public void test1() {
		System.out.println(Pattern.matches("\\d", "2"));// true (digit and comes once)
		System.out.println(Pattern.matches("\\d", "44"));//false (digit but comes more than once)  
		System.out.println(Pattern.matches("\\d", "abc"));//false (non-digit)  
		System.out.println(Pattern.matches("\\d", "323abc"));//false (digit and char) 
		System.out.println(Pattern.matches("\\d*", "12345679"));//true (digit and may come 0 or more times)
	}
	
	@Test
	public void test2(){
		System.out.println(Pattern.matches("\\D", "abc"));//false (non-digit but comes more than once)  
		System.out.println(Pattern.matches("\\D", "1"));//false (digit)  
		System.out.println(Pattern.matches("\\D", "4443"));//false (digit)  
		System.out.println(Pattern.matches("\\D", "323abc"));//false (digit and char)  
		System.out.println(Pattern.matches("\\D", "m"));//true (non-digit and comes once) 
		System.out.println(Pattern.matches("\\D*", "mak"));//true (non-digit and may come 0 or more times)  
	}
}
