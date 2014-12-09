package com.example.samramez.wayshopperx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ShoppingListFromStore extends Activity {

    private Button addButton;
    public EditText addItemEditText;
    private ViewGroup mContainerView;

    //url for the WebView
    public static String url = "";

    //Generating the HashSet
    public static ArrayList<String> hSet = new ArrayList<String>();

    public static String[] listArray;

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

        // This is what has been written in the EditBox
        String item;
        item = addItemEditText.getText().toString();

        if(
                item.equalsIgnoreCase("apple") ||
                        item.equalsIgnoreCase("meat") ||
                        item.equalsIgnoreCase("juice") ||
                        item.equalsIgnoreCase("nuts") ||
                        item.equalsIgnoreCase("eggs"))
            {

            if (  hSet.contains(new String(item)) == false  ){
                //item exist and we want to add it to the list

                //We add the item to the HashSet List
                hSet.add(item);

                //making the Save Button Visible
                findViewById(R.id.shoppingListSaveButton).setVisibility(View.VISIBLE);

                //making the Submit Button InVisible
                findViewById(R.id.shoppingListSubmitButton).setVisibility(View.INVISIBLE);

                // Instantiate a new "row" view.
                final ViewGroup newView = (ViewGroup) LayoutInflater.from(this).inflate(
                        R.layout.list_item_inflate, mContainerView, false);

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
            else{
                Toast.makeText(this, "Item already added",
                        Toast.LENGTH_LONG).show();
            }

        }

        else{
            Toast.makeText(this, "Item doesn't exist in this store",
                    Toast.LENGTH_LONG).show();
        }

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


    public void saveAndGoToMainPage(View view) {

        Toast.makeText(this, "List Saved",
                Toast.LENGTH_SHORT).show();
        //TODO: this Toasting shit is not working!

        //TODO : make the list save

        Intent intent = new Intent(ShoppingListFromStore.this, MainActivity.class);
        startActivity(intent);

    }

    public void dontSaveAndGoToMainPage(View view) {
        Intent intent = new Intent(ShoppingListFromStore.this, MainActivity.class);
        startActivity(intent);
    }

    public void saveAndGoToMap(View view) {

        //converting HashSet to String Array
        java.util.Collections.sort(hSet);
        String [] listArray = hSet.toArray(new String[hSet.size()]);

        Intent intent = new Intent(ShoppingListFromStore.this, Map.class);
        startActivity(intent);
    }


}
