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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView modalNavDrawer = findViewById(R.id.modal_nav_drawer);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav);
        NavigationRailView navRail = findViewById(R.id.nav_rail);
        NavigationView navDrawer = findViewById(R.id.nav_drawer);
        ExtendedFloatingActionButton navFab = findViewById(R.id.nav_fab);
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