package com.code.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite {
	public static void main(String[] args) throws IOException {
		String str = "Hi Hello How are you";
		FileWriter f = new FileWriter("File_operation/output.txt");
		f.write(str);
		// or
		for (int i = 0; i < str.length(); i++) {
			f.write(str.charAt(i));
		}

		f.close();

		FileReader f1 = new FileReader("File_operation/output.txt");
		int ch;
		while ((ch = f1.read()) != -1) {
			System.out.print((char) ch);
		}
	}
}
