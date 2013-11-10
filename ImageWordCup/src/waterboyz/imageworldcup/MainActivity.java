package waterboyz.imageworldcup;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.*;
import com.facebook.model.*;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "hello";
	private String ACCESS_TOKEN = "";
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	  super.onActivityResult(requestCode, resultCode, data);
	  Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Session.openActiveSession(this, true, new Session.StatusCallback(){
			
			// callback when session changes state
		    @Override
		    public void call(Session session, SessionState state, Exception exception) {
		    	
		    	if (session.isOpened()){
		    		loginSuccess(session);
		    	}
		    	
		    }
		});
	}
	
	private void loginSuccess(Session session){
		// make request to the /me API
		ACCESS_TOKEN = session.getAccessToken();
		
		Request.newMeRequest(session, new Request.GraphUserCallback() {
        	
          // callback after Graph API response with user object
          @Override
          public void onCompleted(GraphUser user, Response response) {
            if (user != null) {
            	getAccessToFriendsList(user);
            }
          }
        }).executeAsync();
	}
	
	private void getAccessToFriendsList(GraphUser user){
		TextView welcome = (TextView) findViewById(R.id.welcome);
        welcome.setText("Hello " + user.getName() + "!");
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.action_search:
	            openSearch();
	            return true;
	        case R.id.action_settings:
	            openSettings();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
		Intent intent = new Intent(this, Testing.class);
		EditText editText = (EditText) findViewById(R.id.edit_message);
		String message = editText.getText().toString();
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}
	
	private void openSearch(){
		System.out.println("Stop Searching for me");
	}
	
	private void openSettings(){
		
	}
}
