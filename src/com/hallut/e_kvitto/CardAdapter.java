package com.hallut.e_kvitto;

import java.util.LinkedList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Creates a view for each specific item in the ListView that shows credit cards.
 *
 */
public class CardAdapter extends BaseAdapter{
	
	private Context mContext;
    private LinkedList<CreditCard> cards;
    private LayoutInflater inflater; // used to set the layout of each row in the ListView.
    
    /**
     * Set information about the items that are going to be shown in the ListView.
     * @param context
     * @param cards
     */
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
        return cards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return cards.get(position).getCvv();
    }


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;

		if (rowView == null) {
			// get the custom created row view from list_view.xml file.
            rowView = inflater.inflate(R.layout.list_view, parent, false);

        } 
		
		// Set information in the layout
	    TextView textView = (TextView) rowView.findViewById(R.id.companyName);
	    TextView date = (TextView) rowView.findViewById(R.id.date);
	    textView.setText(cards.get(position).getType());
	    date.setText(cards.get(position).getCardNumber());
		return rowView;
	}

}
