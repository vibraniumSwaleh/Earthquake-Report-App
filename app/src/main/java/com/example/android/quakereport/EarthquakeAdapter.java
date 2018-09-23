package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeClass> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();

    public EarthquakeAdapter(Activity context, ArrayList<EarthquakeClass> numbersName) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, numbersName);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_layout, parent, false);

        }

        EarthquakeClass currentPosition = getItem(position);

        TextView magnitudeText = (TextView) listItemView.findViewById(R.id.text_magnitude);
        magnitudeText.setText(currentPosition.getmMagnitude());

        TextView locationText = (TextView) listItemView.findViewById(R.id.text_location);
        locationText.setText(currentPosition.getmLocation());

        TextView dateText = (TextView) listItemView.findViewById(R.id.text_date);
        dateText.setText(currentPosition.getmDate());

        return listItemView;

    }
}