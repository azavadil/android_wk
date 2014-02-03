package az101.example.emilysong;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	// declare instance variable
	MediaPlayer songAsset; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("Pickle", "onCreate"); 
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // songAsset.start(); 
    }

    
    // happens when app comes into focus
	@Override
	protected void onResume() {
		Log.e("Pickle", "onResume"); 
		// TODO Auto-generated method stub
        // at this point the media player is in the prepared state
        songAsset = MediaPlayer.create(this, R.raw.live_your_life); 

		songAsset.start(); 
		super.onResume();
	}
    
	@Override
	protected void onPause() {
		Log.e("Pickle", "onPause"); 
		// TODO Auto-generated method stub
		songAsset.stop(); 
		// audio resources are constrained. we should release resources
		songAsset.release(); 
		super.onPause();
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    // View is a pointer to what view we were on when the button was clicked
    // you have to make intent object if you intend to open the web-browser
    public void openPage0(View v) { 
    	String url = "http://www.example.com"; 
    	Intent i = new Intent(Intent.ACTION_VIEW); 
    	i.setData(Uri.parse(url));
    	startActivity(i); 
    }
    
    public void openPage1(View v) { 
    	String url = "http://www.espn.com"; 
    	Intent i = new Intent(Intent.ACTION_VIEW); 
    	i.setData(Uri.parse(url)); 
    	startActivity(i); 
    }
    
}