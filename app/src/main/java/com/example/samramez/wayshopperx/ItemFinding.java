package com.example.samramez.wayshopperx;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class ItemFinding extends Activity {

    private Spinner fromItemSpinner;
    private Spinner targetItemshopSpinner;

    public static String from = "";
    public static String target = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_finding);

        // Fills the spinner
        addItemsToFromItemSpinner();
        // Add listener to the Spinner
        addListenerToFromItemSpinner();

        // Fills the spinner
        addItemsToTargetItemSpinner();
        // Add listener to the Spinner
        addListenerToTargetItemSpinner();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item_finding, menu);
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

    public void addItemsToFromItemSpinner(){

        // Get a reference to the spinner
        fromItemSpinner = (Spinner) findViewById(R.id.spinner2);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> unitTypeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        unitTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        fromItemSpinner.setAdapter(unitTypeSpinnerAdapter);

    }

    public void addListenerToFromItemSpinner() {

        fromItemSpinner = (Spinner) findViewById(R.id.spinner2);

        from = fromItemSpinner.getSelectedItem().toString();

        fromItemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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


    //=====================


    public void addItemsToTargetItemSpinner(){

        // Get a reference to the spinner
        targetItemshopSpinner = (Spinner) findViewById(R.id.spinner3);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> unitTypeSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.items, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        unitTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        targetItemshopSpinner.setAdapter(unitTypeSpinnerAdapter);

    }

    public void addListenerToTargetItemSpinner() {

        targetItemshopSpinner = (Spinner) findViewById(R.id.spinner3);

        target = targetItemshopSpinner.getSelectedItem().toString();

        targetItemshopSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

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


}
