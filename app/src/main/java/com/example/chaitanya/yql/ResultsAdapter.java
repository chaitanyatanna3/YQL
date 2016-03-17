package com.example.chaitanya.yql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by chaitanyatanna on 3/16/16.
 */
public class ResultsAdapter extends ArrayAdapter {

    ArrayList<Results> results;
    Context context;

    public ResultsAdapter(Context context, ArrayList<Results> results) {
        super(context, R.layout.single_row, results);
        this.context = context;
        this.results = results;
    }

    public class ResultsViewHolder {
        TextView textViewTitle, textViewAddress, textViewPhone,textViewDistance;

        ResultsViewHolder(View view) {
            textViewTitle = (TextView) view.findViewById(R.id.titleField);
            textViewAddress = (TextView) view.findViewById(R.id.addressField);
            textViewPhone = (TextView) view.findViewById(R.id.phoneField);
            textViewDistance = (TextView) view.findViewById(R.id.distanceField);

        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ResultsViewHolder holder = null;
        if (row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_row, parent, false);
            holder = new ResultsViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (ResultsViewHolder) row.getTag();
        }
        Results result = results.get(position);
        holder.textViewTitle.setText(result.title);
        holder.textViewAddress.setText(result.address + ", " + result.city + " ," + result.state);
        holder.textViewPhone.setText("Phone: " + result.phone);
        holder.textViewDistance.setText("Distance: " + result.distance + " miles");

        return row;
    }
}
