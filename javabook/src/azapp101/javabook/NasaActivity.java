package azapp101.javabook;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;

public class NasaActivity extends Activity {

	WebView myWebView; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// it only makes sense to look for an id / myWebView after setContentView has
		// initialized the page (i.e. after the webView has been created
		
		
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
		myWebView.loadUrl("file:///android_asset/nasa.html");
				
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.nasa, menu);
		return true;
	}

}
