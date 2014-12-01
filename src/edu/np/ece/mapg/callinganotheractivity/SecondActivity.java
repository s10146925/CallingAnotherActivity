package edu.np.ece.mapg.callinganotheractivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends Activity {
	
	EditText etStudentName;
	EditText etStudentNumber;
	Button btReturn;;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		etStudentName = (EditText)this.findViewById(R.id.etStudentName);
		etStudentNumber = (EditText)this.findViewById(R.id.etStudentNumber);
		btReturn = (Button)this.findViewById(R.id.btReturn);
		
		btReturn.setOnClickListener(listener);
	}
	
	View.OnClickListener listener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
		// do something when btReturn is clicked
			
			String studName = etStudentName.getText().toString();
			String studNum = etStudentNumber.getText().toString();
			
			Intent data = new Intent();
			data.putExtra("Student_Name", studName);
			data.putExtra("Student_Number", studNum);
			
			setResult(RESULT_OK, data);
			finish();
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
