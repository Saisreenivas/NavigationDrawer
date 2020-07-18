package com.saisreenivas.test.navigationdrawer;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

/*Components: Navigation View view, TextInputLayout for floating labels for editing text,
a floating action button, Snack Bar, Tabs, CoordinatorLayout, AppbarLayout & Collapsing Toolbars.*/

// Toolbar is taken from android support library

/*CoordinatorLayout provides additional level of control over touch events between child views.*/
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    FloatingActionButton fab;
    TabLayout tabLayout;

    CollapsingToolbarLayout collapsingToolbarLayout;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpFab();
        setUpTablayout();
        setUpToolbar();

        setUpNavigationView();
    }

    private void setUpNavigationView() {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //show menu icon
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    private void setUpFab(){
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(this);
    }

    private void setUpTablayout(){
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.SCROLL_AXIS_HORIZONTAL);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 5"));
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.fab){
            Snackbar.make(findViewById(R.id.rootLayout), "This is SnackBar", Snackbar.LENGTH_SHORT)
                    .setAction("Action", this).show();
        }
    }
}
