package com.hallut.e_kvitto;

import java.util.LinkedList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ReceiptAdapter extends BaseAdapter
{
    
    private Context mContext;
    private LinkedList<Receipt> rec;
    private LayoutInflater inflater;
	
    
    public ReceiptAdapter(Context context,LinkedList<Receipt> receipts) 
    {
            super();
            mContext = context;
            rec = receipts;
            inflater = (LayoutInflater) mContext
    		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
      
    @Override
    public int getCount() 
    {
        return rec.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return rec.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return rec.get(position).getID();
    }


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View rowView = convertView;

		if (rowView == null) {
            rowView = inflater.inflate(R.layout.list_view, parent, false);
        } 
		
	    TextView company = (TextView) rowView.findViewById(R.id.companyName);
	    TextView date = (TextView) rowView.findViewById(R.id.date);
	    company.setText(rec.get(position).getCompany());
	    date.setText(rec.get(position).getDate());
		return rowView;
	}
}
