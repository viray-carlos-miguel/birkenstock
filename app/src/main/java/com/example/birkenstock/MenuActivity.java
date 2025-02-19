package com.example.birkenstock;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MenuActivity extends AppCompatActivity {

    private static final String TAG = "MenuActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu); // Ensure this is the correct layout file

        Log.d(TAG, "MenuActivity Loaded Successfully");

        // Profile Card Click -> Open ProfileActivity
        CardView profileCard = findViewById(R.id.profileCard);
        profileCard.setOnClickListener(v -> startActivity(new Intent(MenuActivity.this, ProfileActivity.class)));

        // Products Card Click -> Open ProductsActivity
        CardView productsCard = findViewById(R.id.productsCard);
        productsCard.setOnClickListener(v -> startActivity(new Intent(MenuActivity.this, ProductsActivity.class)));

        // Orders Card Click -> Open OrdersActivity (Fixed issue)
        CardView ordersCard = findViewById(R.id.ordersCard);
        ordersCard.setOnClickListener(v -> {
            Log.d(TAG, "Opening OrdersActivity...");
            Intent intent = new Intent(MenuActivity.this, OrdersActivity.class);
            startActivity(intent);
        });

        // Cart Card Click -> Open CartActivity
        CardView cartCard = findViewById(R.id.cartCard);
        cartCard.setOnClickListener(v -> startActivity(new Intent(MenuActivity.this, CartActivity.class)));

        // Settings Card Click -> Open SettingsActivity
        CardView settingsCard = findViewById(R.id.settingsCard);
        settingsCard.setOnClickListener(v -> startActivity(new Intent(MenuActivity.this, SettingsActivity.class)));

        // Logout Card Click -> Back to LoginActivity
        CardView logoutCard = findViewById(R.id.logoutCard);
        logoutCard.setOnClickListener(v -> {
            Log.d(TAG, "User logged out. Redirecting to LoginActivity...");
            Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clears activity stack
            startActivity(intent);
            finish(); // Close MenuActivity
        });
    }
}
