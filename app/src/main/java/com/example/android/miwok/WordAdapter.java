package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * At this moment I have no idea what it does :)
 */

public class WordAdapter extends ArrayAdapter<Word>{

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int backgroundColor;
    MediaPlayer mediaPlayer;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param miwokWords A List of AndroidFlavor objects to display in a list
     */

    public WordAdapter(@NonNull Context context, @NonNull ArrayList<Word> miwokWords, int bc) {
        super(context, 0, miwokWords);
        backgroundColor=bc;

    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
// Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word word = getItem(position);

       //mediaPlayer= MediaPlayer.create( this, R.raw.number_one);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.topWord);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        nameTextView.setText(word.getmMiwokWord());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) listItemView.findViewById(R.id.bottomWord);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(word.getmDefaultWord());


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.picture);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView

        if(word.hasImage()){
            iconView.setImageResource(word.getmResId());
            iconView.setVisibility(View.VISIBLE);
        }else {
            iconView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_background);

        // !!! IMPORTANT !!!

        int color = ContextCompat.getColor(getContext(), backgroundColor);

        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
