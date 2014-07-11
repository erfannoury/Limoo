

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.FoodItem;
import model.Meal;

import org.limoo.limoo.R;

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
		itemEnergy.setText(foodItem.getEnergy()+"");
		itemUnit.setText(foodItem.getUnit().getUnitName()+"");
		itemAmout.setText(foodItem.getEnergy()+"");
//		itemFood.setText(foodItem.+"");

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
		String headerTitle = (String) getGroup(groupPosition);
		if (convertView == null) {
			LayoutInflater infalInflater = (LayoutInflater) this._context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = infalInflater.inflate(R.layout.list_group, null);
		}

		TextView lblListHeader = (TextView) convertView
				.findViewById(R.id.lblListHeader);
		lblListHeader.setTypeface(null, Typeface.BOLD);
		lblListHeader.setText(headerTitle);

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