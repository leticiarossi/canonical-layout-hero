package com.example.herocanonicallayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.res.Configuration;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigationrail.NavigationRailView;

/** An Activity which hosts the Adaptive feed flow. */
public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private NavigationView modalNavDrawer;
    private BottomNavigationView bottomNav;
    private NavigationRailView navRail;
    private NavigationView navDrawer;
    private ExtendedFloatingActionButton navFab;

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        modalNavDrawer = findViewById(R.id.modal_nav_drawer);
        bottomNav = findViewById(R.id.bottom_nav);
        navRail = findViewById(R.id.nav_rail);
        navDrawer = findViewById(R.id.nav_drawer);
        navFab = findViewById(R.id.nav_fab);
        Configuration configuration = getResources().getConfiguration();

        // Update navigation views according to screen width size.
        int screenWidth = configuration.screenWidthDp;
        AdaptiveUtils.updateNavigationViewLayout(
                screenWidth,
                drawerLayout,
                modalNavDrawer,
                /* fab= */ null,
                bottomNav,
                navRail,
                navDrawer,
                navFab);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new AdaptiveHeroFragment())
                .commit();
    }

}