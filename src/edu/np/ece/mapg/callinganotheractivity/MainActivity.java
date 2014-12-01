package edu.np.ece.mapg.callinganotheractivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	Button btCallActivity;
	TextView tvStudentName;
	TextView tvStudentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        tvStudentName = (TextView)this.findViewById(R.id.tvStudentName);
        tvStudentNumber = (TextView)this.findViewById(R.id.tvStudentNumber);
        btCallActivity = (Button)this.findViewById(R.id.button1);
        btCallActivity.setOnClickListener(listener);
    }
    
    int REQUEST_CODE = 1;
    
    View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent I = new Intent("edu.np.ece.mapg.callinganotheractivity.s10146925");
			startActivityForResult(I, REQUEST_CODE);
			
		}
	};
	
	@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(requestCode == REQUEST_CODE) {
			if(resultCode == RESULT_OK){
				Toast.makeText(this, "Result returned from SecondActivity.",
				Toast.LENGTH_LONG).show();
				String studName = data.getStringExtra("Student_Name");
				String studNum = data.getStringExtra("Student_Number");
				tvStudentName.setText(studName);
				tvStudentNumber.setText(studNum);
			}else if (resultCode == RESULT_CANCELED){
				Toast.makeText(this, "SecondActivity refuses to provide data",
				Toast.LENGTH_LONG).show();
				tvStudentName.setText("No Student Name");
				tvStudentNumber.setText("No Student Number");
			}
		}
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
