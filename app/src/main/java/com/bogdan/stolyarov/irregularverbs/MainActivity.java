package com.bogdan.stolyarov.irregularverbs;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.bogdan.stolyarov.irregularverbs.database.DataBaseHelper;
import com.bogdan.stolyarov.irregularverbs.fragment.AboutFragment;
import com.bogdan.stolyarov.irregularverbs.fragment.ListOfVerbsFragment;
import com.bogdan.stolyarov.irregularverbs.model.Verb;
import com.bogdan.stolyarov.irregularverbs.util.Constants;
import com.support.android.designlibdemo.R;
import com.bogdan.stolyarov.irregularverbs.fragment.LearnFragment;
import com.bogdan.stolyarov.irregularverbs.fragment.TrainingFragment;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;


public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";
    private DrawerLayout mDrawerLayout;

    private Cursor employees;
    private DataBaseHelper db;
    private ArrayList<Verb> verbs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
            navigationView.getMenu().getItem(0).setChecked(true);
            openListOfVerbs();
        }

/*        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        if (viewPager != null) {
            setupViewPager(viewPager);
        }*/
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);
    }

    private void initData() {
        db = new DataBaseHelper(this);
        employees = db.getEmployees();
        verbs = new ArrayList<>();
        Verb verb;
        for (employees.moveToFirst(); !employees.isAfterLast(); employees.moveToNext()) {
            verb = new Verb();
            verb.setInfinitive(employees.getString(employees.getColumnIndex("INFINITIVE")));
            verb.setSecondForm(employees.getString(employees.getColumnIndex("SECOND_FORM")));
            verb.setThirdForm(employees.getString(employees.getColumnIndex("THIRD_FORM")));
            verb.setTranslate(employees.getString(employees.getColumnIndex("TRANSLATE")));
            verbs.add(verb);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sample_actions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("MainActivity", "onOptionsItemSelected");
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.d("MainActivity", "home");
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


 /*   private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new CheeseListFragment(), "Category 1");
        adapter.addFragment(new CheeseListFragment(), "Category 2");
        adapter.addFragment(new CheeseListFragment(), "Category 3");
        viewPager.setAdapter(adapter);
    }*/

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        Log.d(TAG, "onNavigationItemSelected");
                        menuItem.setChecked(true);
                        switch (menuItem.getItemId()) {
                            case R.id.nav_list_of_verbs:
                                Log.d(TAG, "nav_list_of_verbs");
                                openListOfVerbs();
                                break;
                            case R.id.nav_learning:
                                openLearn();
                                break;
                        }
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    private void openListOfVerbs() {
        ListOfVerbsFragment listOfVerbsFragment = new ListOfVerbsFragment();
        listOfVerbsFragment.setVerbs(verbs);
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, listOfVerbsFragment).commit();
    }

    private void openLearn() {
        LearnFragment learnFragment = new LearnFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, learnFragment).commit();
    }

    private void openTraining() {
        TrainingFragment trainingFragment = new TrainingFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, trainingFragment).commit();
    }

    private void openAbout() {
        AboutFragment aboutFragment = new AboutFragment();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, aboutFragment).commit();
    }



    private boolean isFirstRun() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        boolean isFirstRun = prefs.getBoolean(Constants.FIRST_RUN_KEY, true);
        if (isFirstRun) {
            prefs.edit().putBoolean(Constants.FIRST_RUN_KEY, false).apply();
        }
        return isFirstRun;
    }


}
