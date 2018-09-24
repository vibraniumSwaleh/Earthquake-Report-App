package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<EarthquakeClass> {

    private static final String LOG_TAG = EarthquakeAdapter.class.getSimpleName();
    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Context context, ArrayList<EarthquakeClass> earthquakes) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);

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

        String toSplit = currentPosition.getLocation();
        String textProximity;
        String textLocation;

        if (toSplit.contains(LOCATION_SEPARATOR)) {
            String[] parts = toSplit.split(LOCATION_SEPARATOR);
            textProximity = parts[0] + LOCATION_SEPARATOR;
            textLocation = parts[1];
        } else {
            textProximity = getContext().getString(R.string.near_the);
            textLocation = toSplit;
        }

        TextView magnitudeText = (TextView) listItemView.findViewById(R.id.text_magnitude);
        magnitudeText.setText(currentPosition.getMagnitude());

        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.text_proximity);
        primaryLocationView.setText(textProximity);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.text_location);
        locationOffsetView.setText(textLocation);

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentPosition.getTime());

        // Find the TextView with view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.text_date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) listItemView.findViewById(R.id.text_time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        return listItemView;

    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}