package com.example.samramez.wayshopperx;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ShoppingList extends ActionBarActivity {

    private Button addButton;
    public EditText addItemEditText;
    private ViewGroup mContainerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        //initiating page elements
        addButton = (Button) findViewById(R.id.addButton);
        addItemEditText = (EditText) findViewById(R.id.addItemEditText);
        mContainerView = (ViewGroup) findViewById(R.id.container);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(android.R.id.empty).setVisibility(View.GONE);
                addItem();
            }
        });
    }

    // a method to inflate item to the main activity.
    private void addItem() {

        // Instantiate a new "row" view.
        final ViewGroup newView = (ViewGroup) LayoutInflater.from(this).inflate(
                R.layout.list_item_inflate, mContainerView, false);



        //getting the entered value from EditText
        //String item = addItemEditText.getText().toString();

        // Set the text in the new row to a random item.
//        ((TextView) newView.findViewById(android.R.id.text1)).setText(
//                ITEMS[(int) (Math.random() * ITEMS.length)]);

        String item;
        item = addItemEditText.getText().toString();
        ((TextView) newView.findViewById(android.R.id.text1)).setText(item);


        // Set a click listener for the "X" button in the row that will remove the row.
        newView.findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Remove the row from its parent (the container view).
                // Because mContainerView has android:animateLayoutChanges set to true,
                // this removal is automatically animated.
                mContainerView.removeView(newView);

                // If there are no rows remaining, show the empty view.
                if (mContainerView.getChildCount() == 0) {
                    findViewById(android.R.id.empty).setVisibility(View.VISIBLE);
                }
            }
        });

        // Because mContainerView has android:animateLayoutChanges set to true,
        // adding this view is automatically animated.
        mContainerView.addView(newView, 0);

        //clear the EditText for the next thing
        addItemEditText.setText("");
    }


    /**
     * A static list of item names.
     */
    private static final String[] ITEMS = new String[]{
            "Apple", "Orange", "Juice", "Meat", "Water",
            "Cheese", "Eggs", "Ice Cream", "Butter", "Bread",
            "Nutella",
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_shopping_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}