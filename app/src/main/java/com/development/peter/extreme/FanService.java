package com.development.peter.extreme;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
//import android.support.v4.app.NotificationCompat;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import ioio.lib.api.DigitalOutput;
import ioio.lib.api.IOIO;
import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOService;


public class FanService extends IOIOService {
		
	private final IBinder mBinder = new IOIOBinder();
	private String mMessage = "WAITING";	
	//private com.siren.fan.LoopMode mLoopMode;
	private DigitalOutput
        	led_ ,
			led_1,
			led_2,
			led_3,
			led_4,
			led_5,
			led_6,
			led_7,
			led_8;
	
	
		private boolean 
		    mMode1=false, 
		    mMode2=false, 
		    mMode3=false, 
    	    mMode4=false, 
		    mMode5=false, 					    
		    mMode6=false, 
		    mMode7=false, 
		    mMode8=false;
	
		
		
	@Override
	protected IOIOLooper createIOIOLooper() {
		return new BaseIOIOLooper() {
	
			@Override
			protected void setup() throws ConnectionLostException, InterruptedException {
				
				led_ = ioio_.openDigitalOutput(IOIO.LED_PIN);
				
				led_1 = ioio_.openDigitalOutput(33);
				led_2 = ioio_.openDigitalOutput(34);
				led_3 = ioio_.openDigitalOutput(35);
				led_4 = ioio_.openDigitalOutput(36);
				led_5 = ioio_.openDigitalOutput(37);
				led_6 = ioio_.openDigitalOutput(38);
				led_7 = ioio_.openDigitalOutput(39);
				led_8 = ioio_.openDigitalOutput(40);
				mMessage = "IOIO connection established";
				
			}
			
			@Override
			public void loop() throws ConnectionLostException, InterruptedException {
		try{		
			led_1.write(getService(1));
			led_2.write(getService(2));
			led_3.write(getService(3));
			led_4.write(getService(4));
			led_5.write(getService(5));
			led_6.write(getService(6));
			led_7.write(getService(7));
			led_8.write(getService(8));
		} catch (ConnectionLostException e) {
			e.printStackTrace();
			mMessage = e.getMessage();
		};


		}
	};
			
		
		};
		
	
	
	public void setService(boolean PressMode, Integer button_value) {
	 switch (button_value) {
         case 1:  
        	 mMode1 = PressMode;
                break;
         case 2:
        	 mMode2 = PressMode;
        	 	break;
         case 3:
        	 mMode3 = PressMode;
                break;
         case 4:
        	 mMode4 = PressMode;
        	 	break;
         case 5:
        	 mMode5 = PressMode;
                break;
         case 6:
        	 mMode6 = PressMode;
                break;
         case 7:
        	 mMode7 = PressMode;
                break;
         case 8:
        	 mMode8 = PressMode;
                break;
                
          default:
        //	  mMode1 = PressMode;
                break;
     }
	 
	 
	}
	
	public boolean getService(Integer button_value) {
	 boolean tempval = false;
		switch (button_value) {
        case 1:  
        	tempval = mMode1;
               break;
        case 2:
         	tempval = mMode2;
       	 	break;
        case 3:
         	tempval = mMode3;
               break;
        case 4:
         	tempval = mMode4;
       	 	break;
        case 5:
         	tempval = mMode5;
               break;
        case 6:
         	tempval = mMode6;
               break;
        case 7:
         	tempval = mMode7;
               break;
        case 8:
         	tempval = mMode8;
               break;
	}
		
		return tempval;       
               
    }
		
	
	public void stop() {
		mMessage = "IOIO connection stopped";
		stopForeground(true);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStart(intent, startId);
		handleStartup(intent);
		return START_STICKY;
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		handleStartup(intent);
		mMessage = "IOIO connection started";
	}	

	@Override
	public void onDestroy() {
		Toast.makeText(this, R.string.service_stopped_text, Toast.LENGTH_SHORT).show();
		mMessage = "IOIO connection destroyed";
	}

	
	public String getMessage() {
		return mMessage;
	}

	private void handleStartup(Intent intent) {
		NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		if (intent != null && intent.getAction() != null
				&& intent.getAction().equals("stop")) {
			// User clicked the notification. Need to stop the service.
			nm.cancel(0);
			stopSelf();
		} 
		else {
			// Service starting. Create a notification.
			Intent i = new Intent(this, com.development.peter.extreme.MainActivity.class);
			PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
			Notification notification = new NotificationCompat.Builder(this)
				.setSmallIcon(R.drawable.ic_launcher)
				.setContentTitle("IOIOSiren")
				.setContentText("Tap to open")
				.setContentIntent(pi)
				.build();
			notification.flags |= Notification.FLAG_ONGOING_EVENT;
			startForeground(1, notification);
		}		
	}
	
	
    public class IOIOBinder extends Binder {
        FanService getService() {
            return FanService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
   
	
}