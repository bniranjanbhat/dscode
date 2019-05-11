package com.code.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutput {
	public static void main(String[] args) throws IOException {
		String str = "Hi Hello Java";
		FileOutputStream fo = new FileOutputStream("File_Operation/Example.txt");// if
																					// file
																					// is
		// not
		// present
		// it will
		// create
		// the file.
		byte[] b = str.getBytes();
		fo.write(b);// file output will except byte array as input
		fo.close();

		FileInputStream f = new FileInputStream("File_Operation/Example.txt");
		int i = 0;
		while ((i = f.read()) != -1) {
			System.out.print((char) i);
		}
	}
}
