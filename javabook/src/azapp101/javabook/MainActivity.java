package azapp101.javabook;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;

public class MainActivity extends Activity {

	WebView myWebView; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// after setContentView we've told android 'please create all of those components you find inside 
		// activity main layout file
		setContentView(R.layout.activity_main);
		
		// find the webview we created
		// the id is automatically added to the R file 
		
		// note this is a local variable and can only be used in onCreate
		// note that findViewById returns a generic view
		myWebView = (WebView)findViewById(R.id.webView1); 
		
		// add ability to zoom in text
		// from myWebView we get settings object
		// from settings 
		myWebView.getSettings().setBuiltInZoomControls(true);
		// enable javascript
		myWebView.getSettings().setJavaScriptEnabled(true);
		
		// .loadUrl is the method for opening html assets from asset directory
		myWebView.loadUrl("file:///android_asset/index.html");
		
		// Open the asset/index.html
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){ 
		// Check if the key event was the Back button and if there's a history
		if((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack() ){ 
			myWebView.goBack(); 
			return true; 
		}
		// If it wasn't the Back key or there's no web page history, bubble up to the default
		// system behavior (probably the exit activity)
		return super.onKeyDown(keyCode, event);
	}

}
