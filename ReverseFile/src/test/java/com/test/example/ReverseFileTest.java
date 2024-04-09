package com.test.example;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class ReverseFileTest {
	 private BufferedReader readerMock;
	 private PrintWriter printWriter;

	    @BeforeEach
	    public void setUp() throws IOException {
	        readerMock = mock(BufferedReader.class);
	        printWriter = mock(PrintWriter.class);
	    }

	    @Test
	    public void testReverseFileContents() throws IOException {
	        when(readerMock.readLine()).thenReturn("This is line 1.", "This is line 2.", "This is line 3.", null);
	        ReverseFile.reverseFileContents(readerMock, printWriter );
	        
      // Verify that what is being written to the printWriter from within the tested method is what we expect 
	        verify(printWriter).write(".1 enil si sihT\n.2 enil si sihT\n.3 enil si sihT\n");

	    }

	    @Test
	    public void testEmptyFile() throws IOException {	  
	        when(readerMock.readLine()).thenReturn(null);
	        ReverseFile.reverseFileContents(readerMock, printWriter);
	        verify(printWriter, never()).write(anyString());
	    }

	    @Test
	    public void testSingleLineFile() throws IOException {
	        when(readerMock.readLine()).thenReturn("This is a single line with 5pec!@l chars.", null);
	        ReverseFile.reverseFileContents(readerMock, printWriter);
	        verify(printWriter).write(".srahc l@!cep5 htiw enil elgnis a si sihT\n");
	    }


	    @AfterEach
	    public void tearDown() {
	        try {
	            readerMock.close();
	            printWriter.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}


