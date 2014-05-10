package com.hallut.e_kvitto;

import java.util.LinkedList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CardAdapter extends BaseAdapter{
	
	private Context mContext;
    private LinkedList<CreditCard> cards;
    private LayoutInflater inflater;
    
    public CardAdapter(Context context,LinkedList<CreditCard> cards){
    	super();
    	mContext = context;
        this.cards = cards;
        inflater = (LayoutInflater) mContext
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

	@Override
	public int getCount() {
		return cards.size();
	}

	@Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return cards.get(position).getCvv();
    }


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View rowView = convertView;

		if (rowView == null) {
            rowView = inflater.inflate(R.layout.list_view, parent, false);

        } 
		
		//rowView = inflater.inflate(R.layout.list_view, parent, false);
	    TextView textView = (TextView) rowView.findViewById(R.id.companyName);
	    TextView date = (TextView) rowView.findViewById(R.id.date);
	    textView.setText(cards.get(position).getType());
	    date.setText(cards.get(position).getCardNumber());
		return rowView;
	}

}
