package com.development.peter.extreme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class SetupActivity extends Activity {
	
	//	String mTestFile = "test";
	EditText mEditLabel;;
	EditText mEditTimer;
	CheckBox mToggle;
	
	static public Integer varb=0;


	
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
		  String abc = null;
		  BufferedReader input = null;
		  try {
		    input = new BufferedReader(new InputStreamReader(openFileInput(fileName)));
		    String line;
		    StringBuffer buffer = new StringBuffer();
		    while ((line = input.readLine()) != null) {
		    buffer.append(line + eol);
		    }
		    abc = buffer.toString();
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
		return abc;
		  
} 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Enter pass key");
        alert.setMessage("Password");

        // Set an EditText view to get user input 
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
          String value = input.getText().toString();
          if (value.equals("123"))
          {
          }else{
        	  System.exit(0);
          }
         }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int whichButton) {
            // Canceled.
           	  System.exit(0);
          }
        });

        alert.show();
	
	
	}
        
 
	public void sendMessage(View view) {
//      	writeFileToInternalStorage("button5","a","a",true);
		
	    switch(varb) {
        case 1:
           	writeFileToInternalStorage("button1", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
           	break;
        case 2:
          	writeFileToInternalStorage("button2", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
          	break;
        case 3:
          	writeFileToInternalStorage("button3", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
          	break;
        case 4:
          	writeFileToInternalStorage("button4", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
          	break;
        case 5:
          	writeFileToInternalStorage("button5", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
          	break;
        case 6:
          	writeFileToInternalStorage("button6", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
          	break;
        case 7:
          	writeFileToInternalStorage("button7", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
          	break;
        case 8:
          	writeFileToInternalStorage("button8", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
          	break;
          	
	    }
    	   	
    	/**
       	writeFileToInternalStorage("button2", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
       	writeFileToInternalStorage("button3", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
       	writeFileToInternalStorage("button4", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
       	writeFileToInternalStorage("button5", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
       	writeFileToInternalStorage("button6", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
       	writeFileToInternalStorage("button7", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
       	writeFileToInternalStorage("button8", mEditLabel.getText().toString(),mEditTimer.getText().toString(),mToggle.isChecked());
       	**/
       	finish();
		
	}
	
	public void onRadioButtonClicked(View view) {
	    // Is the button now checked?
	    boolean checked = ((RadioButton) view).isChecked();
		String tmpvar = null;
		String[] data;

		
	    // Check which button was clicked
	    switch(view.getId()) {
	        case R.id.button1:
			if (checked)
				varb=1;
				tmpvar = readFileFromInternalStorage("button1");
			    data = tmpvar.split("\n");
	    	    mEditLabel   = (EditText)findViewById(R.id.editT1);
	            mEditTimer   = (EditText)findViewById(R.id.editT2);
	            mToggle   = (CheckBox)findViewById(R.id.checkBox1);
	    	
	            mEditLabel.setText(""+data[0]);
	            mEditTimer.setText(""+data[1]);
	            mToggle.setChecked(Boolean.valueOf(data[2]));
	            break;
	        case R.id.button2:
	            if (checked)
				varb=2;
				tmpvar = readFileFromInternalStorage("button2");
			    data = tmpvar.split("\n");
		    	mEditLabel   = (EditText)findViewById(R.id.editT1);
	            mEditTimer   = (EditText)findViewById(R.id.editT2);
	            mToggle   = (CheckBox)findViewById(R.id.checkBox1);
	    	
	            mEditLabel.setText(""+data[0]);
	            mEditTimer.setText(""+data[1]);
	            mToggle.setChecked(Boolean.valueOf(data[2]));
	            break;
	        case R.id.button3:
	            if (checked)
					varb=3;
					tmpvar = readFileFromInternalStorage("button3");
				    data = tmpvar.split("\n");
		    	    mEditLabel   = (EditText)findViewById(R.id.editT1);
		            mEditTimer   = (EditText)findViewById(R.id.editT2);
		            mToggle   = (CheckBox)findViewById(R.id.checkBox1);
		    	
		            mEditLabel.setText(""+data[0]);
		            mEditTimer.setText(""+data[1]);
		            mToggle.setChecked(Boolean.valueOf(data[2]));
	            break;
	        case R.id.button4:
	            if (checked)
					varb=4;
					tmpvar = readFileFromInternalStorage("button4");
				    data = tmpvar.split("\n");
		    	    mEditLabel   = (EditText)findViewById(R.id.editT1);
		            mEditTimer   = (EditText)findViewById(R.id.editT2);
		            mToggle   = (CheckBox)findViewById(R.id.checkBox1);
		    	
		            mEditLabel.setText(""+data[0]);
		            mEditTimer.setText(""+data[1]);
		            mToggle.setChecked(Boolean.valueOf(data[2]));
	            break;
	        case R.id.button5:
	            if (checked)
					varb=5;
					tmpvar = readFileFromInternalStorage("button5");
				    data = tmpvar.split("\n");
		    	    mEditLabel   = (EditText)findViewById(R.id.editT1);
		            mEditTimer   = (EditText)findViewById(R.id.editT2);
		            mToggle   = (CheckBox)findViewById(R.id.checkBox1);
		    	
		            mEditLabel.setText(""+data[0]);
		            mEditTimer.setText(""+data[1]);
		            mToggle.setChecked(Boolean.valueOf(data[2]));
	            break;
	        case R.id.button6:
	            if (checked)
					varb=6;
					tmpvar = readFileFromInternalStorage("button6");
				    data = tmpvar.split("\n");
		    	    mEditLabel   = (EditText)findViewById(R.id.editT1);
		            mEditTimer   = (EditText)findViewById(R.id.editT2);
		            mToggle   = (CheckBox)findViewById(R.id.checkBox1);
		    	
		            mEditLabel.setText(""+data[0]);
		            mEditTimer.setText(""+data[1]);
		            mToggle.setChecked(Boolean.valueOf(data[2]));
	            break;
	        case R.id.button7:
	            if (checked)
					varb=7;
					tmpvar = readFileFromInternalStorage("button7");
				    data = tmpvar.split("\n");
		    	    mEditLabel   = (EditText)findViewById(R.id.editT1);
		            mEditTimer   = (EditText)findViewById(R.id.editT2);
		            mToggle   = (CheckBox)findViewById(R.id.checkBox1);
		    	
		            mEditLabel.setText(""+data[0]);
		            mEditTimer.setText(""+data[1]);
		            mToggle.setChecked(Boolean.valueOf(data[2]));
	            break;
	        case R.id.button8:
	            if (checked)
					varb=8;
					tmpvar = readFileFromInternalStorage("button8");
				    data = tmpvar.split("\n");
		    	    mEditLabel   = (EditText)findViewById(R.id.editT1);
		            mEditTimer   = (EditText)findViewById(R.id.editT2);
		            mToggle   = (CheckBox)findViewById(R.id.checkBox1);
		    	
		            mEditLabel.setText(""+data[0]);
		            mEditTimer.setText(""+data[1]);
		            mToggle.setChecked(Boolean.valueOf(data[2]));
	            break;
	    }
	}
	
}
