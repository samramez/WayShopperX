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


public class ShoppingList extends Activity implements DidComeFromHome{

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

        // This is what has been written in the EditBox
        String item;
        item = addItemEditText.getText().toString();

        if(
                item.equalsIgnoreCase("apple") ||
                item.equalsIgnoreCase("meat") ||
                item.equalsIgnoreCase("juice") ||
                item.equalsIgnoreCase("nuts") ||
                item.equalsIgnoreCase("eggs")){


            //item exist and we want to add it to the list

            //making the Save Button Visible
            findViewById(R.id.shoppingListSaveButton).setVisibility(View.VISIBLE);

            //making the Submit Button InVisible
            findViewById(R.id.shoppingListSubmitButton).setVisibility(View.INVISIBLE);


            // Instantiate a new "row" view.
            final ViewGroup newView = (ViewGroup) LayoutInflater.from(this).inflate(
                    R.layout.list_item_inflate, mContainerView, false);


            /*
            // ================================
            //Test

            ArrayList<String> hSet = new ArrayList<String>();
            //LinkedList<String> hSet = new LinkedList<String>()
            //HashSet<String> hSet = new HashSet<String>();
            hSet.add(new String("apple"));
            hSet.add(new String("meat"));
            hSet.add(new String("eggs"));
            hSet.add(new String("juice"));
            hSet.add(new String("nuts"));

            java.util.Collections.sort(hSet);
            String [] listArray = hSet.toArray(new String[hSet.size()]);

            String result = "";
//            for(int i=0; i<hSet.size() ; i++){
//                result += hSet.get(i) + " - ";
//            }
            for(int i=0; i<listArray.length ; i++){
                result += listArray[i] + " - ";
            }


             ((TextView) newView.findViewById(android.R.id.text1)).setText(result);


            // ================================
            //Test

            */

            item.toLowerCase();

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


        } else{
            Toast.makeText(this, "Item doesn't exist in this store",
                Toast.LENGTH_LONG).show();
        }

    }


    /**
     * A static list of item names.
     */
    private static final String[] ITEMS = new String[]{
            "Apple", "Orange", "Juice", "Meat",
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

        Intent intent = new Intent(ShoppingList.this, MainActivity.class);
        startActivity(intent);




    }

    public void dontSaveAndGoToMainPage(View view) {
        Intent intent = new Intent(ShoppingList.this, MainActivity.class);
        startActivity(intent);
    }

    public void saveAndGoToMap(View view) {



        Intent intent = new Intent(ShoppingList.this, MainActivity.class);
        startActivity(intent);
    }


}
