package com.hession.podge.listwithcustomrows;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create a variable called myListView which links to the listView in the Activity
        ListView myListView = (ListView)findViewById(R.id.listViewId);

        final ArrayList<String> myCountries = new ArrayList<String>();

        myCountries.add("Ireland");
        myCountries.add("Japan");
        myCountries.add("UK");
        myCountries.add("US");
        myCountries.add("Australia");

        //put the above items in the listview by using an ArrayAdapter
        //ArrayAdapter converts arraylist format into a listview format
        //I'm gonna give it the array list i'm creating it from, format, and context that i'm creating it in
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.listviewrow, R.id.textViewId, myCountries);
        myListView.setAdapter(arrayAdapter);


        //add onClickListener
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //AdapterView is the listView that has been tapped
                //view represents that thing that was actually tapped. i.e. in my case the row
                //poition: the number of the row that was tapped
                //id is the same as position

                Toast.makeText(getApplicationContext(), "Hello " + myCountries.get(position), Toast.LENGTH_LONG).show();


            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
