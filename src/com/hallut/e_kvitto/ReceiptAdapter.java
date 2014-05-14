package com.hallut.e_kvitto;

import java.util.LinkedList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Creates a view for each specific item in a ListView, in this case ReceiptList.
 * 
 * @author Fredrik Norrman
 *
 */
public class ReceiptAdapter extends BaseAdapter {
    
    private Context mContext;
    private LinkedList<Receipt> rec;
    private LayoutInflater inflater; //used to set the layout of each row in the ListView.
	
    /**
     * Set information about the items that are going to be shown in the ListView.
     * @param context
     * @param receipts
     */
    public ReceiptAdapter(Context context,LinkedList<Receipt> receipts) 
    {
            super();
            mContext = context;
            rec = receipts;
            inflater = (LayoutInflater) mContext
    		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
      
    @Override
    public int getCount() {
        return rec.size();
    }

    @Override
    public Object getItem(int position) {
        return rec.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rec.get(position).getID();
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;

		if (rowView == null) {
			//get the custom created row view from list_view.xml file.
            rowView = inflater.inflate(R.layout.list_view, parent, false);
        } 
		// Set information in the layout
	    TextView company = (TextView) rowView.findViewById(R.id.companyName);
	    TextView date = (TextView) rowView.findViewById(R.id.date);
	    company.setText(rec.get(position).getCompany());
	    date.setText(rec.get(position).getDate());
		return rowView;
	}
}
