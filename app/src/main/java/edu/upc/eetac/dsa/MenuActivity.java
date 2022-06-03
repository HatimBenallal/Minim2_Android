package edu.upc.eetac.dsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private Button profile,stats,shop,logout,faq;
    SharedPreferences sharedPref;
    SharedPreferences.Editor myEdit;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        profile = (Button) findViewById(R.id.button_profile);
        stats = (Button) findViewById(R.id.button_stats);
        shop = (Button) findViewById(R.id.button_shop);
        logout = (Button) findViewById(R.id.button_logout);

        apiInterface = Api.getClient();
        sharedPref = getSharedPreferences("LoginData", Context.MODE_PRIVATE);

//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openProfileActivity();
//            }
//
//        });
//
//        stats.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openStatsActivity();
//            }
//
//        });
//        shop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openShopActivity();
//            }
//
//        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEdit.putString("username", null);
                myEdit.putString("password", null);
                myEdit.putBoolean("isLogged", false);
                myEdit.apply();
                openLandPageActivity();
            }
        });

    }
    private void openLandPageActivity(){
        Intent intent = new Intent(this, LandPageActivity.class);
        startActivity(intent);
    }



//    private void openProfileActivity(){
//        Intent intent = new Intent(this, ProfileActivity.class);
//        startActivity(intent);
//    }
//
//    private void openStatsActivity(){
//        Intent intent = new Intent(this, StatsActivity.class);
//        startActivity(intent);
//    }
//    private void openShopActivity(){
//        Intent intent = new Intent(this, ShopActivity.class);
//        startActivity(intent);
//    }



}