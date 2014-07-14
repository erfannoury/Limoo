package org.limoo.limoo;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.FoodItem;
import model.Meal;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

	private Context _context;
	private ArrayList<Meal> _listDataHeader; // Meals
	// child data in format of header title, child title
	private ArrayList<Meal> _listDataChild;

	public ExpandableListAdapter(Context context, ArrayList<Meal> listDataHeader,
			ArrayList<Meal> listChildData) {
		this._context = context;
		this._listDataHeader = listDataHeader;
		this._listDataChild = listChildData;
	}

	@Override
	public Object getChild(int groupPosition, int childPosititon) {
		return this._listDataChild.get(groupPosition).getFoodItems()
				.get(childPosititon);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {

		final FoodItem foodItem = (FoodItem) getChild(groupPosition, childPosition);

		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.list_item, null);
		}

		TextView itemEnergy = (TextView) convertView
				.findViewById(R.id.itemEnergy);
		TextView itemUnit = (TextView) convertView
				.findViewById(R.id.itemUnit);
		TextView itemAmout = (TextView) convertView
				.findViewById(R.id.itemAmount);
		TextView itemFood = (TextView) convertView
				.findViewById(R.id.itemFood);
		
		NumberFormat formatter = new DecimalFormat("#0.00");
		itemEnergy.setText(formatter.format(foodItem.getEnergy())+"");
		itemUnit.setText(foodItem.getUnit().getUnitName()+"");
		itemAmout.setText(formatter.format(foodItem.getAmount())+"");
		itemFood.setText(foodItem.getFoodName()+"");

		return convertView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return this._listDataChild.get(groupPosition).getFoodItems()
				.size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return this._listDataHeader.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		return this._listDataHeader.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		Meal meal = (Meal) getGroup(groupPosition);
		NumberFormat formatter = new DecimalFormat("#0.00");
		String mealType = meal.getMealType().toString();
		String mealEnergy = formatter.format(meal.getMealEnergy())+"کیلوکالری ";
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.list_group, null);
		}

		TextView mealTypeView = (TextView) convertView
				.findViewById(R.id.mealType);
		mealTypeView.setTypeface(null, Typeface.BOLD);
		mealTypeView.setText(mealType);
		
		TextView mealEnergyView = (TextView) convertView
				.findViewById(R.id.mealEnergy);
		mealEnergyView.setTypeface(null, Typeface.BOLD);
		mealEnergyView.setText(mealEnergy);

		return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}
}