package com.code.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

//? quantifier  
public class Example3 {
	@Test
	public void test1() {
		String str = "has";
		Pattern p=Pattern.compile(".a.");
		Matcher m=p.matcher(str);
		System.out.println(m.matches());//true
		
		System.out.println("1--->"+Pattern.compile(".a.").matcher(str).matches());//true
		
		System.out.println("2--->"+Pattern.matches(".a.", str));//true
		
		System.out.println("3--->"+Pattern.matches("..s","mas"));//2nd character is 's'
		
		System.out.println("4--->"+Pattern.matches("[amn]", "ajhfd"));//false since string must contains either 'a' or 'm' or 'n'
		System.out.println("5--->"+Pattern.matches("[amn]?", ""));//true 'a','m','n' occurs once or not at all
		System.out.println("6--->"+Pattern.matches("[amn]?", "aaa"));//false 'a' is displaying more than once
		
		System.out.println("7--->"+Pattern.matches("[amn]", "a"));//true string contains a
		System.out.println("8--->"+Pattern.matches("[amn]", "amna"));//false string contains 'a' two times.
		
		
		System.out.println("9--->"+Pattern.matches("[amn]?", "mna"));//false (a or m or n must come one time or not)  
		System.out.println("10--->"+Pattern.matches("[amn]?", "sfrym"));//false (a or m or n must come one time or not)"  here other letters are there with a or m or n
		System.out.println("11--->"+Pattern.matches("[amn]?", "am"));//false (a or m or n must come one time)  
		
	
		
	}
	
	@Test
	public void test2(){
		System.out.println("+ quantifier ....");  //occurs once or more times
		System.out.println(Pattern.matches("[amn]+","aaa"));//true a comes more than once
		System.out.println(Pattern.matches("[amn]+","aaammmnnn"));//true (a or m or n comes more than once)
		System.out.println(Pattern.matches("[amn]+", "aazzta"));//false (z and t are not matching pattern) 
		System.out.println(Pattern.matches("[amn]+", ""));//false (a or m or n must comes atleast once) 
	}
	
	@Test
	public void test3(){
		System.out.println("* quantifier ....");  //  occurs zero or more times
		System.out.println(Pattern.matches("[amn]*", "ammmna"));//true (a or m or n may come zero or more times)
	}
}
