package com.example.ironparadise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import com.google.android.material.navigation.NavigationView;


import java.util.ArrayList;

import static com.example.ironparadise.R.id.menubutton;
import static com.example.ironparadise.R.id.visible;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawer;
    private ImageButton menu;
    private Button button;
    private ImageButton searchbutton;
    private LinearLayout searchLayout;
    private LinearLayout toolbarLayout;
    private LinearLayout layout2;
    private LinearLayout layout3;
    private boolean searchButtonClicked;
    private SearchView mySearchView;
    private ListView myList;
    private AbsoluteLayout mainLayout;
    private ScrollView scroll;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Button aboutusbutton;
    private Button contact;
    private Button membership;
    private Button adminbutton;



    //private ArrayList<String> list;
    //private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        //ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.naviigation_drawer_open,R.string.naviigation_drawer_close);
        //drawer.addDrawerListener(toggle);
        //toggle.syncState();

        button = findViewById(R.id.button);

        menu = (ImageButton) findViewById(menubutton);


        //searchButton
        layout2 = (LinearLayout) findViewById(R.id.layout2);
        layout3 = (LinearLayout) findViewById(R.id.layout3);
        searchLayout = (LinearLayout) findViewById(R.id.searchLayout);
        searchbutton = (ImageButton) findViewById(R.id.searchButton);
        toolbarLayout = (LinearLayout) findViewById(R.id.toolbarLayout);
        mainLayout = (AbsoluteLayout) findViewById(R.id.main_layout);
        scroll = (ScrollView) findViewById(R.id.scrollview);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        aboutusbutton = (Button) findViewById(R.id.aboutUsButton);
        contact = (Button) findViewById(R.id.contact);
        membership = (Button) findViewById(R.id.membership);
        adminbutton = (Button) findViewById(R.id.admin);




        adminbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });

        membership.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,Membership.class);
                startActivity(intent2);
            }
        });











        aboutusbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this,About_Us.class);
                startActivity(intent2);
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Contact_Page.class);
                startActivity(intent);
            }
        });






        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId())
                {
                    case R.id.nav_admin_panel:
                        Intent intent = new Intent(MainActivity.this,Admin.class);
                        startActivity(intent);
                        return true;

                    case R.id.nav_contact:
                        Intent intent4 = new Intent(MainActivity.this,Contact_Page.class);
                        startActivity(intent4);
                        return true;


                    case R.id.nav_member:
                        Intent intent3 = new Intent(MainActivity.this,Membership.class);
                        startActivity(intent3);
                        return true;

                    case R.id.nav_aboutUs:
                        Intent intent2 = new Intent(MainActivity.this,About_Us.class);
                        startActivity(intent2);
                        return true;


                    case R.id.nav_tracker:
                        Intent intent5 = new Intent(MainActivity.this,Tracker_page.class);
                        startActivity(intent5);
                        return true;


                }

                return false;
            }
        });


        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                searchButtonClicked();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChoose_goals();
            }
        });


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        String[] List = {"Choose Goals","Lose weight", "Muscle gain", "Workout", "Diet plan", "Foodlist", "Gain weight", "Fitness myths"};
        //search
        mySearchView = (SearchView) findViewById(R.id.searchView);
        myList = (ListView) findViewById(R.id.listView);


        final ListAdapter myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, List);
        myList.setAdapter(myAdapter);
        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ((ArrayAdapter) myAdapter).getFilter().filter(newText);
                return false;
            }
        });


        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0)
                {
                    openChoose_goals();
                }
                if(position == 1)
                {
                    Intent intent = new Intent(MainActivity.this,lose_fat_page.class);
                    startActivity(intent);
                }
                if(position == 2)
                {
                    Intent intent = new Intent(MainActivity.this,gain_muscle_workout.class);
                    startActivity(intent);
                }
                if(position == 3)
                {
                    Intent intent = new Intent(MainActivity.this,workout_plan_musclegain_page.class);
                    startActivity(intent);
                }
                if(position == 4)
                {
                    Intent intent = new Intent(MainActivity.this,diet_plan_weightloss_page.class);
                    startActivity(intent);
                }
                if(position == 5)
                {
                    Intent intent = new Intent(MainActivity.this,foodlist_page.class);
                    startActivity(intent);
                }
                if(position == 6)
                {
                    Intent intent = new Intent(MainActivity.this,gain_weight_page.class);
                    startActivity(intent);
                }
                if(position == 7)
                {
                    Intent intent = new Intent(MainActivity.this,myths_page.class);
                    startActivity(intent);
                }






            }
        });












    }

    @Override
    public void onBackPressed() {


        if (drawer.isDrawerOpen(GravityCompat.START)) {

            drawer.closeDrawer(GravityCompat.START);

        } else if(searchButtonClicked){
            searchButtonClicked = false;
            searchLayout.setVisibility(View.GONE);
            toolbarLayout.setVisibility(View.VISIBLE);
            layout2.setVisibility(View.VISIBLE);
            layout3.setVisibility(View.VISIBLE);
            scroll.setVisibility(View.VISIBLE);
        }

        else
        {
            super.onBackPressed();
        }




    }

    public void openChoose_goals() {

        Intent intent = new Intent(this, com.example.ironparadise.choose_goals_page.class);
        startActivity(intent);


    }


    public void openMainActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }


    public void searchButtonClicked() {
        searchLayout.setVisibility(View.VISIBLE);
        //mainLayout.setVisibility(View.INVISIBLE);
        toolbarLayout.setVisibility(View.GONE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);
        scroll.setVisibility(View.GONE);
        searchButtonClicked = true;






    }
}

