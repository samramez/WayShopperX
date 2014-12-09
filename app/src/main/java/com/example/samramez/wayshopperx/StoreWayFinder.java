package com.example.samramez.wayshopperx;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;


public class StoreWayFinder extends Activity {

    ImageButton zipCodeImageButton;
    private Spinner shopSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_way_finder);

        // Fills the spinner with the unit options
        addItemsToUnitTypeSpinner();
        // Add listener to the Spinner
        addListenerToUnitTypeSpinner();

        zipCodeImageButton = (ImageButton) findViewById(R.id.zipCodeButton);
        zipCodeImageButton.setBackgroundResource(R.drawable.arrow_right);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_store_way_finder, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void addItemsToUnitTypeSpinner(){

        // Get a reference to the spinner
        shopSpinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> unitTypeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.shops, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        unitTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        shopSpinner.setAdapter(unitTypeSpinnerAdapter);

        }

        public void addListenerToUnitTypeSpinner() {

            shopSpinner = (Spinner) findViewById(R.id.spinner);

            shopSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int pos, long arg3) {

                    // Get the item selected in the Spinner
                    String itemSelectedInSpinner = parent.getItemAtPosition(pos).toString();

                    //TODO: tell what is suppose to happen
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        }

    // The code that says what happens when Zip Code is entered
    public void zipCodeClicked(View view) {

        //zipCodeImageButton.setBackgroundResource(R.drawable.ic_label_black_48dp);

        findViewById(R.id.zipCodeButton).setVisibility(View.INVISIBLE);
        findViewById(R.id.zipCodeButtonChecked).setVisibility(View.VISIBLE);


        //findViewById(R.id.coffee_list).setVisibility(View.GONE);
        findViewById(R.id.storeLinearLayout).setVisibility(View.VISIBLE);

        //zipCodeButtonChecked

    }


    public void goToChoosingList(View view) {

        zipCodeImageButton.setBackgroundResource(R.drawable.tick);

        Toast.makeText(this, "Prepare The Shopping List!",
                Toast.LENGTH_LONG).show();

        Intent intent = new Intent(StoreWayFinder.this, ChooseList.class);
        startActivity(intent);

    }

    public void dontSaveAndGoToMainPage(View view) {
        Toast.makeText(this, "Nothing was saved",
                Toast.LENGTH_SHORT).show();

        //TODO : make the list save

        Intent intent = new Intent(StoreWayFinder.this, MainActivity.class);
        startActivity(intent);

    }

    public void TextFieldClicked(View view){
        ((EditText) findViewById(R.id.zipCodeEditText)).setText("");
    }
}
