package com.test.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReverseFile {   

	public static void main(String[] args) {
		String inputFile = "C:\\Users\\suchi\\Coursera-Alg1\\ReverseFile\\src\\main\\resources\\input.txt";
		String outputFile = "C:\\Users\\suchi\\Coursera-Alg1\\ReverseFile\\src\\main\\resources\\output.txt";
		reverseFile(inputFile, outputFile); 

	}



	protected static void reverseFile(String inputFile, String outputFile) {
		try {
			BufferedReader input = new BufferedReader(new FileReader(inputFile));
			BufferedWriter output = new BufferedWriter(new FileWriter(outputFile));
			PrintWriter printWriter = new PrintWriter(output);
			reverseFileContents(input, printWriter);
			printWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	protected static void reverseFileContents(BufferedReader input, PrintWriter printWriter) {		
		StringBuilder reversedContents = new StringBuilder();
		
		String line;
		try {
			while ((line = input.readLine()) != null) {
				StringBuilder sb = new StringBuilder(line);
				reversedContents.append(sb.reverse());
				reversedContents.append("\n");
			}
			if (reversedContents.length()>0){ 
				// do not call for empty source file
				printWriter.write(reversedContents.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
