package wolking.com.br.templatedrawer;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import wolking.com.br.templatedrawer.fragments.Fragmento01;
import wolking.com.br.templatedrawer.fragments.Fragmento02;
import wolking.com.br.templatedrawer.fragments.Fragmento03;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    protected DrawerLayout mDrawerLayout = null;
    protected Toolbar mToolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getToolbar();

        Fragment fragment = null;
        try {
            fragment = Fragmento01.class.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_layout, fragment).commit();

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        setDrawer();
        setNavigationView();
        setNavigationHeaderView();
    }

    private void getToolbar() {
        if (mToolbar == null) {
            mToolbar = (Toolbar) findViewById(R.id.toolbar);
            if (mToolbar != null) {
                mToolbar.setNavigationContentDescription(getResources().getString(R.string.app_name));
                setSupportActionBar(mToolbar);
            }
        }
    }

    private void setDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);

        toggle.syncState();
    }

    @Override
    public void onResume() {
        super.onResume();
        setNavigationHeaderView();
    }

    private void setNavigationHeaderView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hView = navigationView.getHeaderView(0);
    }

    private void setNavigationView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout != null && mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;

        switch (id) {
            case R.id.fragment_01:
                fragmentClass = Fragmento01.class;
                mToolbar.setTitle("Fragmento 01");
                break;

            case R.id.fragment_02:
                fragmentClass = Fragmento02.class;
                mToolbar.setTitle("Fragmento 02");
                break;

            case R.id.fragment_03:
                fragmentClass = Fragmento03.class;
                mToolbar.setTitle("Fragmento 03");
                break;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_layout, fragment).commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
