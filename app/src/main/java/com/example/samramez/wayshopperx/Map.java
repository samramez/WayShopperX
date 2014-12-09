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

    //Getting the url from the link
    String webUrl = ShoppingListFromStore.url;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        //
        String blah = arrayToString(list);

        // getting the web url from the list
        url = getWebUrl(list);

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

    private String urlGenerator(String[] array){
        String webUrl = "http://hapoojoon.com/subMap/storeMap/";
        for(int i=0; i<array.length; i++){
            if(i == array.length -1)
                webUrl += array[i];
            else
                webUrl += array[i] + "-";
        }
        webUrl += ".html";

        return webUrl;
    }

    private String urlGeneratorFromStart(String[] array){
        String webUrl = "http://hapoojoon.com/subMap/storeMap/start-";
        for(int i=0; i<array.length; i++){
            if(i == array.length -1)
                webUrl += array[i];
            else
                webUrl += array[i] + "-";
        }
        webUrl += ".html";

        return webUrl;
    }



    private String getWebUrl(String[] list){
        if(Arrays.equals(list, case1))
            url = urlGenerator(case1);
        else if(Arrays.equals(list,case2))
            url = urlGenerator(case2);
        else if(Arrays.equals(list,case3))
            url = urlGenerator(case3);
        else if(Arrays.equals(list,case4))
            url = urlGenerator(case4);
        else if(Arrays.equals(list,case5))
            url = urlGenerator(case5);
        else if(Arrays.equals(list,case6))
            url = urlGenerator(case6);
        else if(Arrays.equals(list,case7))
            url = urlGenerator(case7);
        else if(Arrays.equals(list,case8))
            url = urlGenerator(case8);
        else if(Arrays.equals(list,case9))
            url = urlGenerator(case9);
        else if(Arrays.equals(list,case10))
            url = urlGenerator(case10);
        else  if(Arrays.equals(list,case11))
            url = urlGeneratorFromStart(case11);
        else if(Arrays.equals(list,case12))
            url = urlGeneratorFromStart(case12);
        else if(Arrays.equals(list,case13))
            url = urlGeneratorFromStart(case13);
        else if(Arrays.equals(list,case14))
            url = urlGeneratorFromStart(case14);
        else if(Arrays.equals(list,case15))
            url = urlGeneratorFromStart(case15);
        else if(Arrays.equals(list,case16))
            url = urlGeneratorFromStart(case16);
        else if(Arrays.equals(list,case17))
            url = urlGeneratorFromStart(case17);
        else if(Arrays.equals(list,case18))
            url = urlGeneratorFromStart(case18);
        else if(Arrays.equals(list,case19))
            url = urlGeneratorFromStart(case19);
        else if(Arrays.equals(list,case20))
            url = urlGeneratorFromStart(case20);
        else if(Arrays.equals(list,case21))
            url = urlGeneratorFromStart(case21);
        else if(Arrays.equals(list,case22))
            url = urlGenerator(case22);
        else if(Arrays.equals(list,case23))
            url = urlGenerator(case23);
        else if(Arrays.equals(list,case24))
            url = urlGenerator(case24);
        else
            url = "http://hapoojoon.com/subMap/storeMap/start-eggs-juice-meat-nuts.html";
        return url;
    }

}
