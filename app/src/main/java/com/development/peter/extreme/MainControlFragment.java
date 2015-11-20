package com.development.peter.extreme;

//import android.annotation.SuppressLint;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.development.peter.extreme.FanService;
//import com.development.peter.extreme.IOIOBinder;

//import android.media.Ringtone;
//import android.media.RingtoneManager;
//import android.net.Uri;

public class MainControlFragment extends Fragment {
	protected TextView service_Message;
	protected FanService mService;
    protected boolean mBound = false;
	private Button button_1;
	private Button button_2;
	private Button button_3;
	private Button button_4;
	private Button button_5;
	private Button button_6;
	private Button button_7;
	private Button button_8;
	private ToggleButton button_9;
	private ToggleButton button_10;
	private ToggleButton button_11;
	private ToggleButton button_12;
	private ToggleButton button_13;
	private ToggleButton button_14;
	private ToggleButton button_15;
	private ToggleButton button_16;
	
	private ToneGenerator tga = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
	
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className,
                IBinder service) {
            FanService.IOIOBinder binder = (FanService.IOIOBinder) service;
            mService = binder.getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            mBound = false;
        }
    };
	
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
               
    }
    
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.main_control, container, false);
		service_Message = (TextView) v.findViewById(R.id.tvMessage);
		button_1 = (Button) v.findViewById(R.id.Button1);
		button_2 = (Button) v.findViewById(R.id.Button2);
		button_3 = (Button) v.findViewById(R.id.Button3);
		button_4 = (Button) v.findViewById(R.id.Button4);
		button_5 = (Button) v.findViewById(R.id.Button5);
		button_6 = (Button) v.findViewById(R.id.Button6);
		button_7 = (Button) v.findViewById(R.id.Button7);
		button_8 = (Button) v.findViewById(R.id.Button8);
		button_9 = (ToggleButton) v.findViewById(R.id.Button9);
		button_10 = (ToggleButton) v.findViewById(R.id.Button10);
		button_11 = (ToggleButton) v.findViewById(R.id.Button11);
		button_12 = (ToggleButton) v.findViewById(R.id.Button12);
		button_13 = (ToggleButton) v.findViewById(R.id.Button13);
		button_14 = (ToggleButton) v.findViewById(R.id.Button14);
		button_15 = (ToggleButton) v.findViewById(R.id.Button15);
		button_16 = (ToggleButton) v.findViewById(R.id.Button16);
		
		//start
		
		  button_1.setVisibility(View.GONE);
		  button_9.setVisibility(View.VISIBLE);
		  button_2.setVisibility(View.GONE);
		  button_10.setVisibility(View.VISIBLE);
		  button_3.setVisibility(View.GONE);
		  button_11.setVisibility(View.VISIBLE);
		  button_4.setVisibility(View.GONE);
		  button_12.setVisibility(View.VISIBLE);
		  button_5.setVisibility(View.GONE);
		  button_13.setVisibility(View.VISIBLE);
		  button_6.setVisibility(View.GONE);
		  button_14.setVisibility(View.VISIBLE);
		  button_7.setVisibility(View.GONE);
		  button_15.setVisibility(View.VISIBLE);
		  button_8.setVisibility(View.GONE);
		  button_16.setVisibility(View.VISIBLE);
		  button_1.setTextColor(Color.parseColor("White")); 
		  button_9.setTextColor(Color.parseColor("White")); 
		  button_2.setTextColor(Color.parseColor("White")); 
		  button_10.setTextColor(Color.parseColor("White")); 
		  button_3.setTextColor(Color.parseColor("White")); 
		  button_11.setTextColor(Color.parseColor("White")); 
		  button_4.setTextColor(Color.parseColor("White")); 
		  button_12.setTextColor(Color.parseColor("White")); 
		  button_5.setTextColor(Color.parseColor("White")); 
		  button_13.setTextColor(Color.parseColor("White")); 
		  button_6.setTextColor(Color.parseColor("White")); 
		  button_14.setTextColor(Color.parseColor("White")); 
		  button_7.setTextColor(Color.parseColor("White")); 
		  button_15.setTextColor(Color.parseColor("White")); 
		  button_8.setTextColor(Color.parseColor("White")); 
		  button_16.setTextColor(Color.parseColor("White")); 
		
		//end
		
		Context applicationContext = getActivity().getApplicationContext();
		Intent intent = new Intent(applicationContext, FanService.class);
		PendingIntent pi = PendingIntent.getService(applicationContext, 0, intent, 0);
		
		try {
			Notification notification = new NotificationCompat.Builder(applicationContext)
			.setSmallIcon(R.drawable.ic_launcher)
			.setContentTitle("Controller")
			.setContentText("Tap to open")
			.setContentIntent(pi)
			.build();
			notification.flags |= Notification.FLAG_ONGOING_EVENT;
			applicationContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
			applicationContext.startService(intent);
			
		}
		catch(Exception ex) {
		}
		
		
  	    final String b1 = ((MainActivity) getActivity()).readFileFromInternalStorage("button1");
		final String b2 = ((MainActivity) getActivity()).readFileFromInternalStorage("button2");
		final String b3 = ((MainActivity) getActivity()).readFileFromInternalStorage("button3");
		final String b4 = ((MainActivity) getActivity()).readFileFromInternalStorage("button4");
		final String b5 = ((MainActivity) getActivity()).readFileFromInternalStorage("button5");
		final String b6 = ((MainActivity) getActivity()).readFileFromInternalStorage("button6");
		final String b7 = ((MainActivity) getActivity()).readFileFromInternalStorage("button7");		
		final String b8 = ((MainActivity) getActivity()).readFileFromInternalStorage("button8");
		
		final Handler handler = new Handler();
//		String b1;
		handler.post(new Runnable(){
		   @Override
		   public void run() {
			   if(mService != null) {

				   final String serv_var = mService.getMessage();
				   service_Message.setText(mService.getMessage());
				   
				   if (serv_var == "connection lost") {
				   }
				   
				   if (serv_var == "IOIO connection established") {
						   
				   //TODO if connected continue
				 //start button 1 setting
					String[] c1 = b1.split("\n");		
					button_1.setText(c1[0]);
//					button_9.setText(c1[0]);
					boolean b_1 = Boolean.valueOf(c1[2]);
					
					if (b_1){
						  button_1.setVisibility(View.GONE);
						  button_9.setVisibility(View.VISIBLE);
						}else{
						  button_1.setVisibility(View.VISIBLE);
						  button_9.setVisibility(View.GONE);
						}
//start				   
				    boolean on = ((Button) button_1).isPressed();
				    if (on) {
					    button_1.setBackgroundColor(Color.RED);
				    } else {

				     	button_1.setBackgroundColor(Color.parseColor("#19A6E3"));
				    }
			     	button_9.setBackgroundColor(Color.parseColor("#19A6E3"));
					//button_9.setEnabled(true);

					boolean press = ((ToggleButton) button_9).isChecked();
				    
				    if (press) {
					    button_9.setBackgroundColor(Color.RED);
				    } else {
//						button_9.setEnabled(true);
				    }
			    
					button_9.setTextOff(c1[0]);
					button_9.setTextOn(c1[0]);
					button_9.setText(c1[0]);
//end					
					//end button 1 setting
				
					//start button 2 setting
							String[] c2 = b2.split("\n");		
							button_2.setText(c2[0]);
					//		int foo2 = Integer.parseInt(c2[1]);
					//		button_10.setTextOff(c2[0]);
					//		button_10.setTextOn(c2[0]);
							boolean b_2 = Boolean.valueOf(c2[2]);
							
							if (b_2){
								  button_2.setVisibility(View.GONE);
								  button_10.setVisibility(View.VISIBLE);
								}else{
								  button_2.setVisibility(View.VISIBLE);
								  button_10.setVisibility(View.GONE);
								}
							
						    boolean on2 = ((Button) button_2).isPressed();
						    
						    if (on2) {
							    button_2.setBackgroundColor(Color.RED);
						    } else {

						     	button_2.setBackgroundColor(Color.parseColor("#19A6E3"));
						    }
					     	button_10.setBackgroundColor(Color.parseColor("#19A6E3"));
//							button_10.setEnabled(true);

							boolean press2 = ((ToggleButton) button_10).isChecked();
						    
						    if (press2) {
						   // 	button_10.setClickable(false);
							    button_10.setBackgroundColor(Color.RED);
						    } else {
						 //   	button_10.setClickable(true);
						    }
					    
							button_10.setTextOff(c2[0]);
							button_10.setTextOn(c2[0]);
							button_10.setText(c2[0]);
							
							
							//end button 2 setting
							
							//start button 3 setting
							String[] c3 = b3.split("\n");		
							button_3.setText(c3[0]);
//							int foo3 = Integer.parseInt(c3[1]);
//							button_11.setTextOff(c3[0]);
//							button_11.setTextOn(c3[0]);
							boolean b_3 = Boolean.valueOf(c3[2]);
							
							if (b_3){
								  button_3.setVisibility(View.GONE);
								  button_11.setVisibility(View.VISIBLE);
								}else{
								  button_3.setVisibility(View.VISIBLE);
								  button_11.setVisibility(View.GONE);
								}
						
							//start				   
						    boolean on3 = ((Button) button_3).isPressed();
						    if (on3) {
							    button_3.setBackgroundColor(Color.RED);
						    } else {

						     	button_3.setBackgroundColor(Color.parseColor("#19A6E3"));
						    }
					     	button_11.setBackgroundColor(Color.parseColor("#19A6E3"));
						//	button_11.setEnabled(true);

							boolean press3 = ((ToggleButton) button_11).isChecked();
						    
						    if (press3) {
							    button_11.setBackgroundColor(Color.RED);
					//    	button_11.setClickable(false);
						    } else {
					//	    	button_11.setClickable(true);
						    }
					    
							button_11.setTextOff(c3[0]);
							button_11.setTextOn(c3[0]);
							button_11.setText(c3[0]);
		//end					
							
							//end button 3 setting
					
							//start button 4 setting
							String[] c4 = b4.split("\n");		
							button_4.setText(c4[0]);
	//						int foo4 = Integer.parseInt(c4[1]);
	//						button_12.setTextOff(c4[0]);
	//						button_12.setTextOn(c4[0]);
							boolean b_4 = Boolean.valueOf(c4[2]);
							
							if (b_4){
								  button_4.setVisibility(View.GONE);
								  button_12.setVisibility(View.VISIBLE);
								}else{
								  button_4.setVisibility(View.VISIBLE);
								  button_12.setVisibility(View.GONE);
								}
							
							//start				   
						    boolean on4 = ((Button) button_4).isPressed();
						    if (on4) {
							    button_4.setBackgroundColor(Color.RED);
						    } else {

						     	button_4.setBackgroundColor(Color.parseColor("#19A6E3"));
						    }
					     	button_12.setBackgroundColor(Color.parseColor("#19A6E3"));
					//		button_12.setEnabled(true);

							boolean press4 = ((ToggleButton) button_12).isChecked();
						    
						    if (press4) {
							    button_12.setBackgroundColor(Color.RED);
					//	    	button_12.setClickable(false);
						    } else {
					//	    	button_12.setClickable(false);
						    }
					    
							button_12.setTextOff(c4[0]);
							button_12.setTextOn(c4[0]);
							button_12.setText(c4[0]);
		//end					
							
							
							//end button 4 setting
							
							//start button 5 setting

							String[] c5 = b5.split("\n");		
							button_5.setText(c5[0]);
		//					int foo5 = Integer.parseInt(c5[1]);
		//					button_13.setTextOff(c5[0]);
		//					button_13.setTextOn(c5[0]);
							boolean b_5 = Boolean.valueOf(c5[2]);
							
							if (b_5){
								  button_5.setVisibility(View.GONE);
								  button_13.setVisibility(View.VISIBLE);
								}else{
								  button_5.setVisibility(View.VISIBLE);
								  button_13.setVisibility(View.GONE);
								}
							
							//start				   
						    boolean on5 = ((Button) button_5).isPressed();
						    if (on5) {
							    button_5.setBackgroundColor(Color.RED);
						    } else {

						     	button_5.setBackgroundColor(Color.parseColor("#19A6E3"));
						    }
					     	button_13.setBackgroundColor(Color.parseColor("#19A6E3"));
						//	button_13.setEnabled(true);

							boolean press5 = ((ToggleButton) button_13).isChecked();
						    
						    if (press5) {
					//	    	button_13.setClickable(false);
							    button_13.setBackgroundColor(Color.RED);
						    } else {
					//	    	button_13.setClickable(true);
//								button_13.setEnabled(true);
						    }
					    
							button_13.setTextOff(c5[0]);
							button_13.setTextOn(c5[0]);
							button_13.setText(c5[0]);
		//end					
							
							//end button 5 setting
							
							//start button 6 setting
							String[] c6 = b6.split("\n");		
							button_6.setText(c6[0]);
			//				int foo6 = Integer.parseInt(c6[1]);
			//				button_14.setTextOff(c6[0]);
			//				button_14.setTextOn(c6[0]);
							boolean b_6 = Boolean.valueOf(c6[2]);
							
							if (b_6){
								  button_6.setVisibility(View.GONE);
								  button_14.setVisibility(View.VISIBLE);
								}else{
								  button_6.setVisibility(View.VISIBLE);
								  button_14.setVisibility(View.GONE);
								}
							
							//start				   
						    boolean on6 = ((Button) button_6).isPressed();
						    if (on6) {
							    button_6.setBackgroundColor(Color.RED);
						    } else {

						     	button_6.setBackgroundColor(Color.parseColor("#19A6E3"));
						    }
					     	button_14.setBackgroundColor(Color.parseColor("#19A6E3"));
				//			button_14.setEnabled(true);

							boolean press6 = ((ToggleButton) button_14).isChecked();
						    
						    if (press6) {
							    button_14.setBackgroundColor(Color.RED);
				//		    	button_14.setClickable(false);
						    } else {
				//		    	button_14.setClickable(true);
						    }
					    
							button_14.setTextOff(c6[0]);
							button_14.setTextOn(c6[0]);
							button_14.setText(c6[0]);
		//end					
							
							//end button 6 setting
							
							//start button 7 setting

							String[] c7 = b7.split("\n");		
							button_7.setText(c7[0]);
					//		int foo7 = Integer.parseInt(c7[1]);
					//		button_15.setTextOff(c7[0]);
					//		button_15.setTextOn(c7[0]);
							boolean b_7 = Boolean.valueOf(c7[2]);
							
							if (b_7){
								  button_7.setVisibility(View.GONE);
								  button_15.setVisibility(View.VISIBLE);
								}else{
								  button_7.setVisibility(View.VISIBLE);
								  button_15.setVisibility(View.GONE);
								}
							
							//start				   
						    boolean on7 = ((Button) button_7).isPressed();
						    if (on7) {
							    button_7.setBackgroundColor(Color.RED);
						    } else {

						     	button_7.setBackgroundColor(Color.parseColor("#19A6E3"));
						    }
					     	button_15.setBackgroundColor(Color.parseColor("#19A6E3"));
						//	button_15.setEnabled(true);

							boolean press7 = ((ToggleButton) button_15).isChecked();
						    
						    if (press7) {
					//	    	button_15.setClickable(false);
							    button_15.setBackgroundColor(Color.RED);
						    } else {
					//	    	button_15.setClickable(true);
						    }
					    
							button_15.setTextOff(c7[0]);
							button_15.setTextOn(c7[0]);
							button_15.setText(c7[0]);
		//end					
							
							//end button 7 setting
							
							//start button 8 setting
							String[] c8 = b8.split("\n");		
							button_8.setText(c8[0]);
					//		int foo8 = Integer.parseInt(c8[1]);
					//		button_16.setTextOff(c8[0]);
					//		button_16.setTextOn(c8[0]);
							boolean b_8 = Boolean.valueOf(c8[2]);
							
							if (b_8){
								  button_8.setVisibility(View.GONE);
								  button_16.setVisibility(View.VISIBLE);
								}else{
								  button_8.setVisibility(View.VISIBLE);
								  button_16.setVisibility(View.GONE);
								}
			
							//start				   
						    boolean on8 = ((Button) button_8).isPressed();
						    if (on8) {
							    button_8.setBackgroundColor(Color.RED);
						    } else {

						     	button_8.setBackgroundColor(Color.parseColor("#19A6E3"));
						    }
					     	button_16.setBackgroundColor(Color.parseColor("#19A6E3"));
							//button_16.setEnabled(true);

							boolean press8 = ((ToggleButton) button_16).isChecked();
						    
						    if (press8) {
						    //	button_16.setClickable(false);
							    button_16.setBackgroundColor(Color.RED);
						    } else {
						   // 	button_16.setClickable(true);
						    }
					    
							button_16.setTextOff(c8[0]);
							button_16.setTextOn(c8[0]);
							button_16.setText(c8[0]);
		//end					
							
							//end button 8 setting

				   }//end if
							
				   
			   }
		       handler.postDelayed(this, 100);
		   }
		});
		
		//START THE PRESS BUTTON HANDLER		TODO 1 Change colour on down
		
				 	 
		for(int button_number = 0; button_number < 9; button_number = button_number+1) {
			 switch (button_number) {
	         case 1:  
	        	 button_1.setOnTouchListener( new OnTouchListener() {
					@Override 
	                 public boolean onTouch(View v, MotionEvent event) {
	                     switch (event.getAction()) {
	                     case MotionEvent.ACTION_UP:
	                     	mService.setService(false,1);
	  //                   	button_1.setBackgroundColor(Color.parseColor("#19A6E3"));
	                   //  	button_1.setBackgroundColor(Color.RED);
	                         break;
	                     case MotionEvent.ACTION_DOWN:
	                     	mService.setService(true,1);
	               //      	button_1.setBackgroundColor(Color.GREEN);
	                        final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
	                        tg.startTone(ToneGenerator.TONE_PROP_BEEP);            	
	                     	break;
	                     default:
	                         break;
	                     }

	                     return false;
	                 }
	             });
	            break;
	         case 2:  
	        	 button_2.setOnTouchListener( new OnTouchListener() {
	                 @Override 
	                 public boolean onTouch(View v, MotionEvent event) {
	                     switch (event.getAction()) {
	                     case MotionEvent.ACTION_UP:
	//	                   	button_2.setBackgroundColor(Color.GREEN);
	                     	mService.setService(false,2);
	                         break;
	                     case MotionEvent.ACTION_DOWN:
		                     	mService.setService(true,2);
		     	               //      	button_1.setBackgroundColor(Color.GREEN);
     	                        final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
     	                        tg.startTone(ToneGenerator.TONE_PROP_BEEP);            	
     	                     	break;
	                     default:
	                         break;
	                     }

	                     return false;
	                 }
	             });
	            break;
	         case 3:  
	        	 button_3.setOnTouchListener( new OnTouchListener() {
	                 @Override 
	                 public boolean onTouch(View v, MotionEvent event) {
	                     switch (event.getAction()) {
	                     case MotionEvent.ACTION_UP:
	                     	mService.setService(false,3);
	                     //	button_3.setBackgroundColor(Color.parseColor("#19A6E3"));
	                         break;
	                     case MotionEvent.ACTION_DOWN:
	                     	mService.setService(true,3);
//	                     	button_3.setBackgroundColor(Color.parseColor("#19A6E3"));
	                        final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
	                        tg.startTone(ToneGenerator.TONE_PROP_BEEP);            	
	                     	break;
	                     default:
	                         break;
	                     }

	                     return false;
	                 }
	             });
	            break;
	         case 4:  
	        	 button_4.setOnTouchListener( new OnTouchListener() {
	                 @Override 
	                 public boolean onTouch(View v, MotionEvent event) {
	                     switch (event.getAction()) {
	                     case MotionEvent.ACTION_UP:
	                     	mService.setService(false,4);
	                     //	button_4.setBackgroundColor(Color.parseColor("#474c4f"));
	                         break;
	                     case MotionEvent.ACTION_DOWN:
	                     	mService.setService(true,4);
	              //       	button_4.setBackgroundColor(Color.parseColor("#19A6E3"));
	                        final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
	                        tg.startTone(ToneGenerator.TONE_PROP_BEEP);            	  
	                     	
	                     	break;
	                     default:
	                         break;
	                     }

	                     return false;
	                 }
	             });
	            break;
	         case 5:  
	        	 button_5.setOnTouchListener( new OnTouchListener() {
	                 @Override 
	                 public boolean onTouch(View v, MotionEvent event) {
	                     switch (event.getAction()) {
	                     case MotionEvent.ACTION_UP:
	                     	mService.setService(false,5);
	                     //	button_5.setBackgroundColor(Color.parseColor("#474c4f"));
	                         break;
	                     case MotionEvent.ACTION_DOWN:
	                     	mService.setService(true,5);
//	                     	button_5.setBackgroundColor(Color.parseColor("#19A6E3"));
	                        final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
	                        tg.startTone(ToneGenerator.TONE_PROP_BEEP);            	
	                     	break;
	                     default:
	                         break;
	                     }

	                     return false;
	                 }
	             });
	            break;
	         case 6:  
	        	 button_6.setOnTouchListener( new OnTouchListener() {
	                 @Override 
	                 public boolean onTouch(View v, MotionEvent event) {
	                     switch (event.getAction()) {
	                     case MotionEvent.ACTION_UP:
	                     	mService.setService(false,6);
//	                     	button_6.setBackgroundColor(Color.parseColor("#474c4f"));
	                         break;
	                     case MotionEvent.ACTION_DOWN:
	                     	mService.setService(true,6);
//	                     	button_6.setBackgroundColor(Color.parseColor("#19A6E3"));
	                        final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
	                        tg.startTone(ToneGenerator.TONE_PROP_BEEP);            	
	                     	break;
	                     default:
	                         break;
	                     }

	                     return false;
	                 }
	             });
	            break;
	         case 7:  
	        	 button_7.setOnTouchListener( new OnTouchListener() {
	                 @Override 
	                 public boolean onTouch(View v, MotionEvent event) {
	                     switch (event.getAction()) {
	                     case MotionEvent.ACTION_UP:
	                     	mService.setService(false,7);
//	                     	button_7.setBackgroundColor(Color.parseColor("#474c4f"));
	                         break;
	                     case MotionEvent.ACTION_DOWN:
	                     	mService.setService(true,7);
//	                     	button_7.setBackgroundColor(Color.parseColor("#19A6E3"));
	                        final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
	                        tg.startTone(ToneGenerator.TONE_PROP_BEEP);            	
	                     	break;
	                     default:
	                         break;
	                     }

	                     return false;
	                 }
	             });
	            break;
	            
	         case 8:  
	        	 button_8.setOnTouchListener( new OnTouchListener() {
	                 @Override 
	                 public boolean onTouch(View v, MotionEvent event) {
	                     switch (event.getAction()) {
	                     case MotionEvent.ACTION_UP:
	                     	mService.setService(false,8);
//	                     	button_8.setBackgroundColor(Color.parseColor("#474c4f"));
	                         break;
	                     case MotionEvent.ACTION_DOWN:
	                     	mService.setService(true,8);
//	                     	button_8.setBackgroundColor(Color.parseColor("#19A6E3"));
	                        final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
	                        tg.startTone(ToneGenerator.TONE_PROP_BEEP);            	
	                     	break;
	                     default:
	                         break;
	                     }

	                     return false;
	                 }
	             });
	            break;
		}
			 //end push buttons
			
            String str;   
      		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button1");
    		String[] data = str.split("\n");
    		int val1 = Integer.parseInt(data[1]);
    
    		
    		//if time > 0 		
        	if (val1 > 1){
    	   	button_9.setOnClickListener(new OnClickListener() {
           		public void onClick(View v) {
                    tga.startTone(ToneGenerator.TONE_PROP_BEEP);
                    String str;   
              		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button1");
            		String[] data = str.split("\n");
            		int foo = Integer.parseInt(data[1]);
           			
           			if (button_9.isChecked()){
    					mService.setService(true, 1);
                    	button_9.postDelayed(new Runnable() {

                            public void run() {
                            	button_9.setChecked(false);
              					mService.setService(false,1);
                            }
                        }, foo);
                    }
                    else {
                       // Toast.makeText(this, "Uncheck", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        	
        	}else{
    	   	//START THE TOGGLE HANDLER
        		button_9.setOnClickListener(new OnClickListener() {
    			@Override
    			public void onClick(View arg0) {
                    tga.startTone(ToneGenerator.TONE_PROP_BEEP);
    				if(button_9.isChecked()){
    					mService.setService(true,1);
    				}else{
    					mService.setService(false,1);		
    				}
    			}
    		});
        	
       	}
        
        	//END BUTTON 9	
        	
        	
      		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button2");
    		String[] data2 = str.split("\n");
    		int val2 = Integer.parseInt(data2[1]);
        	
        	//START BUTTON 10	
         	if (val2 > 1){
            	//START THE TIMER HANDLER
            	//START BUTTON 12	
        	   	button_10.setOnClickListener(new OnClickListener() {
               		public void onClick(View v) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
                        String str;   
                  		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button2");
                		String[] data = str.split("\n");
                		int foo = Integer.parseInt(data[1]);
               			
               			if (button_10.isChecked()){
        					mService.setService(true, 2);
                        	button_10.postDelayed(new Runnable() {

                                public void run() {
                                	button_10.setChecked(false);
                  					mService.setService(false,2);
                                }
                            }, foo);
                        }
                        else {
                        }

                    }
                });
            	
            	}else{
            		button_10.setOnClickListener(new OnClickListener() {
        			@Override
        			public void onClick(View arg0) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
        				if(button_10.isChecked()){
        					mService.setService(true,2);
        				}else{
        					mService.setService(false,2);		
        				}
        			}
        		});
            	
           	}
            //END BUTTON 10
        	
      		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button3");
    		String[] data3 = str.split("\n");
    		int val3 = Integer.parseInt(data3[1]);
         	
        	//START BUTTON 11	
         	if (val3 > 1){
            	//START THE TIMER HANDLER
        	   	button_11.setOnClickListener(new OnClickListener() {
               		public void onClick(View v) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
                        String str;   
                  		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button3");
                		String[] data = str.split("\n");
                		int foo = Integer.parseInt(data[1]);
               			
               			if (button_11.isChecked()){
        					mService.setService(true, 3);
                        	button_11.postDelayed(new Runnable() {

                                public void run() {
                                	button_11.setChecked(false);
                  					mService.setService(false,3);
                                }
                            }, foo);
                        }
                        else {
                        }

                    }
                });
            	
            	}else{
            		button_11.setOnClickListener(new OnClickListener() {
        			@Override
        			public void onClick(View arg0) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
        				if(button_11.isChecked()){
        					mService.setService(true,3);
        				}else{
        					mService.setService(false,3);		
        				}
        			}
        		});
            	
           	}
            
            	//END BUTTON 11
        	//CARRY ON FROM HERE TO
         	
      		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button4");
    		String[] data4 = str.split("\n");
    		int val4 = Integer.parseInt(data4[1]);
         	
        	//START BUTTON 12	
         	if (val4 > 1){
            	//START THE TIMER HANDLER
            	//START BUTTON 12	
        	   	button_12.setOnClickListener(new OnClickListener() {
               		public void onClick(View v) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
                        String str;   
                  		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button4");
                		String[] data = str.split("\n");
                		int foo = Integer.parseInt(data[1]);
               			
               			if (button_12.isChecked()){
        					mService.setService(true, 4);
                        	button_12.postDelayed(new Runnable() {

                                public void run() {
                                	button_12.setChecked(false);
                  					mService.setService(false,4);
                                }
                            }, foo);
                        }
                        else {
                        }

                    }
                });
            	
            	}else{
            		button_12.setOnClickListener(new OnClickListener() {
        			@Override
        			public void onClick(View arg0) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
        				if(button_12.isChecked()){
        					mService.setService(true,4);
        				}else{
        					mService.setService(false,4);		
        				}
        			}
        		});
            	
           	}
            //END BUTTON 12
         	
     		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button5");
    		String[] data5 = str.split("\n");
    		int val5 = Integer.parseInt(data5[1]);

         	
        	//START BUTTON 13	
         	if (val5 > 1){
            	//START THE TIMER HANDLER
        	   	button_13.setOnClickListener(new OnClickListener() {
               		public void onClick(View v) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
                        String str;   
                  		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button5");
                		String[] data = str.split("\n");
                		int foo = Integer.parseInt(data[1]);
               			
               			if (button_13.isChecked()){
        					mService.setService(true, 5);
                        	button_13.postDelayed(new Runnable() {

                                public void run() {
                                	button_13.setChecked(false);
                  					mService.setService(false,5);
                                }
                            }, foo);
                        }
                        else {
                        }

                    }
                });
            	
            	}else{
            		button_13.setOnClickListener(new OnClickListener() {
        			@Override
        			public void onClick(View arg0) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
        				if(button_13.isChecked()){
        					mService.setService(true,5);
        				}else{
        					mService.setService(false,5);		
        				}
        			}
        		});
            	
           	}
            //END BUTTON 13
         	
     		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button6");
    		String[] data6 = str.split("\n");
    		int val6 = Integer.parseInt(data6[1]);

         	
        	//START BUTTON 14	
         	if (val6 > 1){
            	//START THE TIMER HANDLER
        	   	button_14.setOnClickListener(new OnClickListener() {
               		public void onClick(View v) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
                        String str;   
                  		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button6");
                		String[] data = str.split("\n");
                		int foo = Integer.parseInt(data[1]);
               			
               			if (button_14.isChecked()){
        					mService.setService(true, 6);
                        	button_14.postDelayed(new Runnable() {

                                public void run() {
                                	button_14.setChecked(false);
                  					mService.setService(false,6);
                                }
                            }, foo);
                        }
                        else {
                        }

                    }
                });
            	
            	}else{
            		button_14.setOnClickListener(new OnClickListener() {
        			@Override
        			public void onClick(View arg0) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
        				if(button_14.isChecked()){
        					mService.setService(true,6);
        				}else{
        					mService.setService(false,6);		
        				}
        			}
        		});
            	
           	}
            //END BUTTON 14
         	
     		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button7");
    		String[] data7 = str.split("\n");
    		int val7 = Integer.parseInt(data7[1]);

         	
        	//START BUTTON 15	
         	if (val7 > 1){
            	//START THE TIMER HANDLER
        	   	button_15.setOnClickListener(new OnClickListener() {
               		public void onClick(View v) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
                        String str;   
                  		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button7");
                		String[] data = str.split("\n");
                		int foo = Integer.parseInt(data[1]);
               			
               			if (button_15.isChecked()){
        					mService.setService(true, 7);
                        	button_15.postDelayed(new Runnable() {

                                public void run() {
                                	button_15.setChecked(false);
                  					mService.setService(false,7);
                                }
                            }, foo);
                        }
                        else {
                        }

                    }
                });
            	
            	}else{
            		button_15.setOnClickListener(new OnClickListener() {
        			@Override
        			public void onClick(View arg0) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
        				if(button_15.isChecked()){
        					mService.setService(true,7);
        				}else{
        					mService.setService(false,7);		
        				}
        			}
        		});
            	
           	}
            //END BUTTON 15
         	
     		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button8");
    		String[] data8 = str.split("\n");
    		int val8 = Integer.parseInt(data8[1]);

         	
        	//START BUTTON 16	
         	if (val8 > 1){
            	//START THE TIMER HANDLER
        	   	button_16.setOnClickListener(new OnClickListener() {
               		public void onClick(View v) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
                        String str;   
                  		str = ((MainActivity) getActivity()).readFileFromInternalStorage("button8");
                		String[] data = str.split("\n");
                		int foo = Integer.parseInt(data[1]);
               			
               			if (button_16.isChecked()){
        					mService.setService(true, 8);
                        	button_16.postDelayed(new Runnable() {

                                public void run() {
                                	button_16.setChecked(false);
                  					mService.setService(false,8);
                                }
                            }, foo);
                        }
                        else {
                        }

                    }
                });
            	
            	}else{
            		button_16.setOnClickListener(new OnClickListener() {
        			@Override
        			public void onClick(View arg0) {
                        tga.startTone(ToneGenerator.TONE_PROP_BEEP);
        				if(button_16.isChecked()){
        					mService.setService(true,8);
        				}else{
        					mService.setService(false,8);		
        				}
        			}
        		});
            	
           	}
            //END BUTTON 16
         	
	}
		return v;

}
		
	
}