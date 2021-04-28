package xyz.jaswanth.bitwall;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("bitwall", 0); // 0 - for private mode
        String token = pref.getString("token", "");

        if(token != null || token != "") {
            this.finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        } else {
            this.finish();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
