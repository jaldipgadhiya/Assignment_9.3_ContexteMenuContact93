package adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import bean.CustomHandler;
import contextemenucontact93.android.acadgild.com.contextemenucontact93.R;

/**
 * Created by Jal on 20-07-2017.
 */

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<CustomHandler> data;
    LayoutInflater inflater;


    public CustomAdapter(Context context, ArrayList<CustomHandler> data) {
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_row, parent, false);
            holder = new ViewHolder();
            //holder.view = (TextView) convertView.findViewById(R.id.view);
            holder.text = (TextView) convertView.findViewById(R.id.text);
            holder.phoneNo = (TextView) convertView.findViewById(R.id.phoneNo);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //holder.view.setBackgroundColor(ContextCompat.getColor(context, colors[position % 6]));
        holder.text.setText(data.get(position).getName());
        holder.phoneNo.setText(data.get(position).getPhoneNo());
        return convertView;
    }


    public class ViewHolder {
        //TextView view;
        TextView text, phoneNo;
    }


}