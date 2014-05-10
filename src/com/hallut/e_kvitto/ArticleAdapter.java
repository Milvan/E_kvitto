package com.hallut.e_kvitto;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ArticleAdapter extends BaseAdapter
{
    
    private Context mContext;
    private Article[] articles;
    private LayoutInflater inflater;
	
    
    public ArticleAdapter(Context context,Article[] articles) 
    {
            super();
            mContext = context;
            this.articles = articles;
            inflater = (LayoutInflater) mContext
    		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
      
    @Override
    public int getCount() 
    {
        return articles.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return articles[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View rowView = convertView;

		if (rowView == null) {
            rowView = inflater.inflate(R.layout.receiptlist_view, parent, false);
        } 
		
		TextView articleName = (TextView) rowView.findViewById(R.id.articleName);
	    TextView tax = (TextView) rowView.findViewById(R.id.tax);
	    TextView price = (TextView) rowView.findViewById(R.id.price);
	    
	    articleName.setText(articles[position].getName());
	    tax.setText(String.valueOf(articles[position].getTax()));
	    price.setText(String.valueOf(articles[position].getPrice()));
	    
		return rowView;
	}
}

