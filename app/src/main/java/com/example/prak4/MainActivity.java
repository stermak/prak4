package com.example.prak4;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"Activity создано");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"Activity станговится видимым");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Activity в состоянии Resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Activity приостановлено (Paused)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Activity остановлено (Stopped)");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Back) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent);
            finish();
        }
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                //Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                setUpActionBar();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setUpActionBar() {
        int api = Build.VERSION.SDK_INT;
        if (api >= Build.VERSION_CODES.HONEYCOMB) {
            String API = String.valueOf(api);
            Toast.makeText(this, API, Toast.LENGTH_SHORT).show();
        }
    }
}