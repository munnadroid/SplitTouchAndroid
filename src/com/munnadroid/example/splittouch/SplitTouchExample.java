package com.munnadroid.example.splittouch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
 
public class SplitTouchExample extends Activity {
    public static final String[] sMovieStrings = {
        "The Shining", "The Great Silence", "A Perfect World", "The Good, the Bad and the Ugly", "Casablanca"};
    public static final String[] sActorStrings = {
        "Jack Nicholson", "Jean-Louis Trintignant", "Kevin Costner", "Clint Eastwood", "Humphrey Bogart"};
     
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
 
        setContentView(R.layout.activity_split_touch_example);
        ListView list1 = (ListView) findViewById(R.id.list1);
        ListView list2 = (ListView) findViewById(R.id.list2);
        ListAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.simple_list_item_1, sMovieStrings);
        ListAdapter adapter2 = new ArrayAdapter<String>(this,
                R.layout.simple_list_item_1, sActorStrings);
   
        list1.setAdapter(adapter);
        list2.setAdapter(adapter2);
 
        list1.setOnItemClickListener(itemClickListener);
        list2.setOnItemClickListener(itemClickListener2);
         
    }
 
     
    private final OnItemClickListener itemClickListener2 = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String[] responses = getResources().getStringArray(R.array.actor_responses);
            String response = responses[position];
 
 
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(
                    SplitTouchExample.this);
            dlgAlert.setMessage(response);
            dlgAlert.setTitle("Bio");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }
    };
     
    private final OnItemClickListener itemClickListener = new OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String[] responses = getResources().getStringArray(R.array.movie_responses);
            String response = responses[position];
 
 
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(
                    SplitTouchExample.this);
            dlgAlert.setMessage(response);
            dlgAlert.setTitle("MovieDetail");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();
        }
    };
}
