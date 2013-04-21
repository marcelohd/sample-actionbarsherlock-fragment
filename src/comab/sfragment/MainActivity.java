package comab.sfragment;


import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;


public class MainActivity extends SherlockFragmentActivity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		StartFragment startFragment = new StartFragment();
		
		fragmentTransaction.add(R.id.palceHolder, startFragment);
		fragmentTransaction.commit();
	}
	public void onSelectedFragment(View view){
		Fragment newFragment;
		
		if(view == findViewById(R.id.btnStartFragments)){
			newFragment = new StartFragment();			
		}else if(view == findViewById(R.id.btnFragments01)){
			newFragment = new Fragments_01();
		}else if(view == findViewById(R.id.btnFragments02)){
			newFragment = new Fragments_02();
		}else {
			newFragment = new StartFragment();
		}
		
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.replace(R.id.palceHolder,newFragment);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	  	MenuInflater inflater = getSupportMenuInflater();
	  	inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	

}
