package course.labs.activitylab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityOne extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityOne";
	
	// Lifecycle counters
	private int mCreate = 0;
	private int mStart = 0;
	private int mResume = 0;
	private int mRestart = 0;
	

	// variables for each of the TextViews
	private TextView mTvCreate;
	private TextView mTvStart;
	private TextView mTvResume;
	private TextView mTvRestart;
     
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one);
		
		// Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);
		mTvCreate = (TextView) findViewById(R.id.create);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);
		mTvRestart = (TextView) findViewById(R.id.restart);


		Button launchActivityTwoButton = (Button) findViewById(R.id.bLaunchActivityTwo); 
		launchActivityTwoButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// Launch Activity Two
				// Hint: use Context's startActivity() method

				// Create an intent stating which Activity you would like to start
				Intent intent = new Intent(v.getContext(),ActivityTwo.class);
				
				// Launch the Activity using the intent
				startActivity(intent);
			
			}
		});
		
		// Check for previously saved state
		if (savedInstanceState != null) {

			// Restore value of counters from saved state
			mCreate = savedInstanceState.getInt("createCount");
			mStart = savedInstanceState.getInt("startCount");
			mResume = savedInstanceState.getInt("resumeCount");
			mRestart = savedInstanceState.getInt("restartCount");
		
		}

		Log.i(TAG, "Entered the onCreate() method");

		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		mCreate++;
		displayCounts();

	}

	// Lifecycle callback overrides

	@Override
	public void onStart() {
		super.onStart();

		Log.i(TAG, "Entered the onStart() method");

		// Update the appropriate count variable
		// Update the user interface
		mStart++;
		displayCounts();

	}

	@Override
	public void onResume() {
		super.onResume();

		Log.i(TAG, "Entered the onResume() method");

		// Update the appropriate count variable
		// Update the user interface
		mResume++;
		displayCounts();

	}

	@Override
	public void onPause() {
		super.onPause();


		Log.i(TAG, "Entered the onPause() method");

	}

	@Override
	public void onStop() {
		super.onStop();


		Log.i(TAG, "Entered the onStop() method");

	}

	@Override
	public void onRestart() {
		super.onRestart();


		Log.i(TAG, "Entered the onRestart() method");


		// Update the appropriate count variable
		// Update the user interface
		mRestart++;
		displayCounts();
		
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		Log.i(TAG, "Entered the onDestroy() method");

	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// Save state information with a collection of key-value pairs
		
		savedInstanceState.putInt("createCount", mCreate);
		savedInstanceState.putInt("startCount", mStart);
		savedInstanceState.putInt("resumeCount", mResume);
		savedInstanceState.putInt("restartCount", mRestart);


	}
	
	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
