package edu.upc.eetac.dsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LandPageActivity extends AppCompatActivity {
    private Button loginButton;
    private Button registerButton, faq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        loginButton = (Button) findViewById(R.id.loginBtn);
        registerButton = (Button) findViewById(R.id.registerBtn);
        faq = (Button) findViewById(R.id.btnFAQ);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLoginActivity();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegisterActivity();
            }
        });

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFAQActivity();
            }
        });
    }

    private void openLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void openFAQActivity(){
        Intent intent = new Intent(this, FAQActivity.class);
        startActivity(intent);
    }
    private void openRegisterActivity(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}