//NOT USED
package com.development.peter.extreme;

import android.app.Activity;
import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//public class DataWrapper {
	public class DataWrapper extends Activity {
		
		
	public void writeFileToInternalStorage(String fileName) {
		  String eol = System.getProperty("line.separator");
		  BufferedWriter writer = null;
		  try {
		    writer = 
		      new BufferedWriter(new OutputStreamWriter(openFileOutput(fileName, 
		        Context.MODE_PRIVATE)));
		    writer.write("This is a test1." + eol);
		    writer.write("This is a test2." + eol);
		  } catch (Exception e) {
		      e.printStackTrace();
		  } finally {
		    if (writer != null) {
		    try {
		      writer.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    }
		  }
		} 
	
	
	public void readFileFromInternalStorage(String fileName) {
		  String eol = System.getProperty("line.separator");
		  BufferedReader input = null;
		  try {
		    input = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
		    String line;
		    StringBuffer buffer = new StringBuffer();
		    while ((line = input.readLine()) != null) {
		    buffer.append(line + eol);
		    }
		  } catch (Exception e) {
		     e.printStackTrace();
		  } finally {
		  if (input != null) {
		    try {
		    input.close();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		    }
		  }
		} 
	}
