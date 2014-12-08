package com.example.samramez.wayshopperx;

import java.util.HashSet;

/**
 * Created by samramez on 12/7/14.
 */
public class ItemList {

    static HashSet<String> listHashSet = new HashSet<String>();



    protected void addToHashSet(HashSet hSet, String item){

//        if(hset.hasHashSetItem(item) == false){
//
//        }

    }

    protected boolean hasHashSetItem(String item){
        if (listHashSet.contains(new String(item)) == true )
            return true;
        else
            return false;
    }
}
