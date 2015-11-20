package com.development.peter.extreme;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends FragmentActivity {
	
	public void writeFileToInternalStorage(String fileName, String string, String string2, Boolean string3) {
		  String eol = System.getProperty("line.separator");
		  BufferedWriter writer = null;
		  try {
		    writer = new BufferedWriter(new OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE)));
		    writer.write(string + eol);
		    writer.write(string2 + eol);
		    writer.write(string3 + eol);
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
	
	public String readFileFromInternalStorage(String fileName) {
		  String eol = System.getProperty("line.separator");
		  String data = "";
		  BufferedReader input = null;
		  
		  try {
		    input = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
		    String line;
		    StringBuffer buffer = new StringBuffer();
		    while ((line = input.readLine()) != null) {
				
		    	buffer.append(line + eol);
		    
		    }
		    data = buffer.toString();
		    

		    
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
		return data;
		  
		} 
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch(item.getItemId()) {
	    case R.id.action_settings:
	        Intent intent = new Intent(this, com.development.peter.extreme.SetupActivity.class);
	        this.startActivity(intent);
	        break;
	    default:
	        return super.onOptionsItemSelected(item);
	    }

	    return true;
	}
		
	
	public boolean fileExistance(String fname){
	    File file = getBaseContext().getFileStreamPath(fname);
	//	Toast.makeText(this, "File name "+file, Toast.LENGTH_LONG).show();
	    return file.exists();
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
//create new file when first run
		boolean isf = fileExistance("button1");
		if(!isf){

	       	writeFileToInternalStorage("button1", "CHANGE","2200",false);
	       	writeFileToInternalStorage("button2", "CHANGE","2200",false);
	       	writeFileToInternalStorage("button3", "CHANGE","2200",false);
	      	writeFileToInternalStorage("button4", "CHANGE","2200",false);
	       	writeFileToInternalStorage("button5", "CHANGE","2200",false);
	       	writeFileToInternalStorage("button6", "CHANGE","2200",false);
	       	writeFileToInternalStorage("button7", "CHANGE","2200",false);
	       	writeFileToInternalStorage("button8", "CHANGE","2200",false);

//			Toast.makeText(this, "File name "+isf, Toast.LENGTH_SHORT).show();
		}
		
		MainControlFragment fragment;
		if(savedInstanceState == null) {
			fragment = new MainControlFragment();
			getSupportFragmentManager()
				.beginTransaction()
				.add(android.R.id.content, fragment)
				.commit();
		}
		else {
			fragment = new MainControlFragment();
		}
	}
		
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	
	
}