package org.limoo.limoo;

import java.util.ArrayList;

import view.TestMeals;
import model.FoodItem;
import model.Meal;
import model.MealType;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.os.Build;


public class MainActivity extends ActionBarActivity {
	
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	ArrayList<Meal> listDataHeader;
	ArrayList<Meal> listDataChild;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
//		FrameLayout fl = (FrameLayout)findViewById(R.id.container);
//		if(fl == null)
//			Log.i("Shit","shit happened");
		Log.i("start","line 34");
//		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
		

		// get the listview
		Log.i("get", "get List View 42");
		expListView = (ExpandableListView) findViewById(R.id.lvExp); 
//		TextView t = (TextView) fl.findViewById(R.id.t);
		Log.i("line", "50");
//		t.setText("Shit");
		Log.i("line", "52");
		// preparing list data
		Log.i("get", "prepare data 46");
		prepareListData();
		
		Log.i("get", "list adapter49");
		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

		// setting list adapter
		Log.i("get", "set list adopter");
		if(listAdapter == null)
			Log.i("get", "list adapter is null!");
		if(expListView == null)
			Log.i("get", "expListView is null!");
		expListView.setAdapter(listAdapter);

	}

	private void prepareListData() {
		// TODO Auto-generated method stub
		ArrayList<Meal> meals = new ArrayList<>();
		
		meals.add(TestMeals.getRandomMeal(MealType.BREAKFAST));
		meals.add(TestMeals.getRandomMeal(MealType.LUNCH));
		meals.add(TestMeals.getRandomMeal(MealType.AFTERNOON));
		
		listDataHeader = meals;
		listDataChild = meals;
		
		
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container,
//				Bundle savedInstanceState) {
//			View rootView = inflater.inflate(R.layout.fragment_main, container,
//					false);
//			return rootView;
//		}
	}

}
