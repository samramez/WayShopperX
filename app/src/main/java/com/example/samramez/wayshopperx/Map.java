package com.example.samramez.wayshopperx;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.util.Arrays;


public class Map extends Activity {

    private WebView myWebView;
    private WebSettings webSettings;

    private String url = "";

    private String[] list = ShoppingListFromStore.listArray;

    String apple = "apple";
    String juice = "juice";
    String eggs = "eggs";
    String meat = "meat";
    String nuts = "nuts";
    String[] case1 = {apple , eggs};
    String[] case2 = {apple, juice};
    String[] case3 = {apple, meat};
    String[] case4 = {apple ,nuts};
    String[] case5 = {eggs, juice};
    String[] case6 = {eggs, meat};
    String[] case7 = {eggs, nuts};
    String[] case8 = {juice, meat};
    String[] case9 = {juice, nuts};
    String[] case10 = {meat, nuts};
    String[] case11 = {apple, eggs, juice};
    String[] case12 = {apple, eggs, meat};
    String[] case13 = {apple, eggs, nuts};
    String[] case14 = {apple, eggs, juice, meat};
    String[] case15 = {apple, eggs, juice, nuts};
    String[] case16 = {apple, eggs, juice, meat, nuts};
    String[] case17 = {apple, juice, meat};
    String[] case18 = {apple, juice, nuts};
    String[] case19 = {apple, meat, nuts};
    String[] case20 = {eggs ,juice, meat};
    String[] case21 = {eggs, juice, nuts};
    String[] case22 = {eggs, juice, meat, nuts};
    String[] case23= {eggs, meat, nuts};
    String[] case24= {juice, meat, nuts};

    String m = arrayToString(list);
    String n = arrayToString(case1);

    String sam = "sam";
    String tan = "tan";

    private String webUrl(String[] list){

        if(Arrays.equals(list,case1))
            url = "";
        if(Arrays.equals(list,case2))
            url = "";
        if(Arrays.equals(list,case3))
            url = "";
        if(Arrays.equals(list,case4))
            url = "";
        if(Arrays.equals(list,case5))
            url = "";
        if(Arrays.equals(list,case6))
            url = "";
        if(Arrays.equals(list,case7))
            url = "";
        if(Arrays.equals(list,case8))
            url = "";
        if(Arrays.equals(list,case9))
            url = "";
        if(Arrays.equals(list,case10))
            url = "";
        if(Arrays.equals(list,case11))
            url = "";
        if(Arrays.equals(list,case12))
            url = "";
        if(Arrays.equals(list,case13))
            url = "";
        if(Arrays.equals(list,case14))
            url = "";
        if(Arrays.equals(list,case15))
            url = "";
        if(Arrays.equals(list,case16))
            url = "";
        if(Arrays.equals(list,case17))
            url = "";
        if(Arrays.equals(list,case18))
            url = "";
        if(Arrays.equals(list,case19))
            url = "";
        if(Arrays.equals(list,case20))
            url = "";
        if(Arrays.equals(list,case21))
            url = "";
        if(Arrays.equals(list,case22))
            url = "";
        if(Arrays.equals(list,case23))
            url = "";
        if(Arrays.equals(list,case24))
            url = "";

        return url;
    }





    //Getting the url from the link
    String webUrl = ShoppingListFromStore.url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl(url);

        //Enabling user to zoom in the page.
        webSettings = myWebView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);

        //enabling JavaScript in the app
        webSettings.setJavaScriptEnabled(true);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
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

    private String arrayToString(String[] stringArray){
        String result = "";
        for(int i=0; i < stringArray.length; i++){
            result += stringArray[i];
        }
        return result;
    }
}
