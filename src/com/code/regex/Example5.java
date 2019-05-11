package com.code.regex;

import java.util.regex.Pattern;

/*Create a regular expression that accepts alphanumeric characters only.  
Its length must be six characters long only.*/
public class Example5 {
	public static void main(String[] args) {
		System.out.println(Pattern.matches("[0-9a-zA-Z]{6}", "Srila1"));//true
		System.out.println(Pattern.matches("[0-9a-zA-Z]{6}", "123456"));//true
		System.out.println(Pattern.matches("[0-9a-zA-Z]{6}", "ghhddh"));//true
		System.out.println(Pattern.matches("[0-9a-zA-Z]{6}", "12365ghg456"));//false
		System.out.println(Pattern.matches("[0-9a-zA-Z]{6}", "%^"));//false
	}
}
