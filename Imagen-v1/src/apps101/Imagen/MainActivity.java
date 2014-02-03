/*Copyright (c) 2014 Lawrence Angrave
Dual licensed under Apache2.0 and MIT Open Source License (included below): 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.*/

package apps101.Imagen;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	private static final String CLICKED = "clicked";

	private static final String TAG = MainActivity.class.getSimpleName();

	private static final String KEY_COUNT = "count";
	private SharedPreferences mPrefs;  //note this is an instance variable
	private TextView mTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate!");
		
		// references a file installed in the flash memory 
		// default is that 
		// if you really want to share with another app use content provider
		// pointer to a java object
		mPrefs = getPreferences(MODE_PRIVATE);
		
		// the mPrefs acts like a map
		int count = mPrefs.getInt(KEY_COUNT, 0);  //second are is the default if key not found
     
		count = count + 1;
		// we cannot call .putInt on mPrefs directly
		Editor editor = mPrefs.edit();     //get editor to edit mPrefs  
		editor.putInt(KEY_COUNT, count);
		editor.commit();

		// programatically create a textView
		// the TextView constructor takes a context
		// view cannot be seen yet, in memory, 
		mTextView = new TextView(this);
		mTextView.setTextSize(80);                 //bit letters
		mTextView.setText("Count : " + count);     //set the text: int, resource string, java string
		Log.d(TAG, "Count is " + count);
		// setContentView called directly on mTextView
		setContentView(mTextView);  
		
		// to display we need to call setContentView
		// to date we've only called setContentView on the layout. 
		// here we're going to use a different approach
		// can we'll call setContentView on the textView
		// setContentView(R.layout.activity_main);

		// setOnClickListener expects a pointer to something that's 
		// a clickListener
		//  
		// by default our Activity is not an onClickListener
		// we have to have Activity implement onClickListener
		mTextView.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	// implement
	@Override
	public void onClick(View arg0) {
		
		SystemClock.sleep(2000); 
		
		//Todo: Can you refactor these keys into a constants?
		int clickCount = 20 + mPrefs.getInt(CLICKED, 0);                //2nd param is default value
		// chain together method calls
		mPrefs.edit().putInt(CLICKED, clickCount).putBoolean("user", true).commit();
		// The hexadecimal value 0xff00ff00 is
		// opaque green. Why?
		
		// change the color programatically
		mTextView.setTextColor(0xff00ff00);
		mTextView.setText("Click!" + clickCount);
	}
}
