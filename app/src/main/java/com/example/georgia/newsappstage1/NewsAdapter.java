package com.example.georgia.newsappstage1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, ArrayList<News> news) {
        super(context, 0, news);



    }



    @SuppressWarnings("unused")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }


        // Get the {@link NewsClass} object located at this position in the list.

        News currentNews = getItem(position);

        // Find the TextView with News Title in the activity_main.xml layout with the ID category
        TextView newsTitleTextView = listItemView.findViewById(R.id.newsTitle);
        // Display the title of the current title in that TextView
        assert currentNews != null;
        newsTitleTextView.setText(currentNews.getmTitle());

        //Find the TextView with category
        TextView categoryTextView = listItemView.findViewById(R.id.newsCategory);
        //Display the category of the current article in that TextView
        categoryTextView.setText(currentNews.getmSection());


        //Find the TextView with author name
        TextView authorTextView = listItemView.findViewById(R.id.newsAuthor);
        //Display the name of the author of the current article in that TextView
        authorTextView.setText(currentNews.getmAuthor());



        //Find the TextView with the date
        TextView dateTextView = listItemView.findViewById(R.id.newsDate);
        //Display the date of the current article in that TextView
        dateTextView.setText(formattedDate);



// Define a SimpleDateFormat object to deconstruct original date.
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'");
        Date date = null;

        try {
            // Convert the date String into a Date object using the SimpleDateFormat.
            date = simpleDateFormat.parse(currentNews.getmDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Define a new SimpleDateFormat object to reconstruct the date into the desired format.
        SimpleDateFormat newDateFormat = new SimpleDateFormat("LLL dd, yyyy");
        // Convert the Date object into a String.
        String formattedDate = newDateFormat.format(date);


        return listItemView;
    }

}
