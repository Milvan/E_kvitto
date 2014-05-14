package com.hallut.e_kvitto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Creates a view for each specific item in a ListView, ViewReceipt ListView in this case.
 *
 */
public class ArticleAdapter extends BaseAdapter {
    
    private Context mContext;
    private Article[] articles;
    private LayoutInflater inflater; //used to set the layout of each row in the ListView.
	
    /**
     * Set information about the items that are going to be shown in the ListView.
     * @param context
     * @param articles
     */
    public ArticleAdapter(Context context,Article[] articles) 
    {
            super();
            mContext = context;
            this.articles = articles;
            inflater = (LayoutInflater) mContext
    		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
      
    @Override
    public int getCount() {
        return articles.length;
    }

    @Override
    public Object getItem(int position) {
        return articles[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;

		if (rowView == null) {
			//get the custom created row view from receiptlist_view.xml file.
            rowView = inflater.inflate(R.layout.receiptlist_view, parent, false);
        } 
		// Set information in the layout.
		TextView articleName = (TextView) rowView.findViewById(R.id.articleName);
	    TextView tax = (TextView) rowView.findViewById(R.id.tax);
	    TextView price = (TextView) rowView.findViewById(R.id.price);
	    articleName.setText(articles[position].getName());
	    tax.setText(String.valueOf(articles[position].getTax()));
	    price.setText(String.valueOf(articles[position].getPrice() + " kr"));
	    
		return rowView;
	}
}

