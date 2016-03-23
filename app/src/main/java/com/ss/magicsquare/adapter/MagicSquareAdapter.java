package com.ss.magicsquare.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ss.magicsquare.R;

/**
 * The extension of BaseAdapter for the GridView of MagicSquare.
 */
public class MagicSquareAdapter extends BaseAdapter{

    private int[] mData;
    private static LayoutInflater mInflater = null;
    private Context mContext;

    public MagicSquareAdapter(Context context, int[] data) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        this.mData = data;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCount() {
        return mData.length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object getItem(int position) {
        return mData[position];
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View newView = convertView;
        ViewHolder holder;

        int curr = mData[position];

        if (null == convertView) {
            holder = new ViewHolder();
            newView = mInflater.inflate(R.layout.magic_square_item, parent, false);
            holder.digit = (TextView) newView.findViewById(R.id.tv_magic_square_item);
            newView.setTag(holder);

        } else {
            holder = (ViewHolder) newView.getTag();
        }

        holder.digit.setText(Integer.toString(mData[position]));

        return newView;
    }

    static class ViewHolder {

        TextView digit;

    }
}
