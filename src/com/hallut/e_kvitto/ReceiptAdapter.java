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
    
    private Context context;
    private LinkedList<Receipt> rec;
    
    public ReceiptAdapter(Context context,LinkedList<Receipt> list) 
    {
            super();
            this.context=context;
            rec = list;
           
    }
       
    public int getCount() 
    {
        return rec.size();
    }


    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return rec.get(position);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return rec.get(position).getID();
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View rowView = convertView;
		
		LayoutInflater inflater = (LayoutInflater) context
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		rowView = inflater.inflate(R.layout.list_view, parent, false);
	    TextView textView = (TextView) rowView.findViewById(R.id.companyName);
	    TextView date = (TextView) rowView.findViewById(R.id.date);
	    textView.setText(rec.get(position).getCompany());
	    date.setText(rec.get(position).getDate());
		return rowView;
	}
}
