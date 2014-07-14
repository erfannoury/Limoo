package org.limoo.limoo;

import java.util.ArrayList;
import java.util.List;

import view.TestMeals;
import model.ActivityType;
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
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
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
//		if (savedInstanceState == null) {
//			getSupportFragmentManager().beginTransaction()
//					.add(R.id.container, new PlaceholderFragment()).commit();
//		}
		

/*
 * Progressbar		
 */
		ProgressBar pb = (ProgressBar)findViewById(R.id.progressBar);
		pb.setProgress(76);
/*
 * Expandable list
 */
		// get the listview
		expListView = (ExpandableListView) findViewById(R.id.lvExp); 
		prepareListData();
		listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
		// setting list adapter
		expListView.setAdapter(listAdapter);
		
/*
 *  Spinner
 */
		Spinner act_type = (Spinner) findViewById(R.id.activity_type);
		List<String> actypes = prepareActtypes();
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
         (this, android.R.layout.simple_spinner_item,actypes);
		dataAdapter.setDropDownViewResource
		         (android.R.layout.simple_spinner_dropdown_item);          
		act_type.setAdapter(dataAdapter);

	}

	private List<String> prepareActtypes() {
		// TODO Auto-generated method stub
		List<String> actypes = new ArrayList<>();
		actypes.add(ActivityType.HEAVY.toString());
		actypes.add(ActivityType.NORMAL.toString());
		actypes.add(ActivityType.LIGHT.toString());
		actypes.add(ActivityType.UNKNOWN.toString());
		
		return actypes;
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
		 MenuInflater inflater = getMenuInflater();
	     inflater.inflate(R.menu.activity_main_actions, menu);
	 
	     return super.onCreateOptionsMenu(menu);
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
