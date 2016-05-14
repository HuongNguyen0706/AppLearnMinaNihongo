package vn.edu.techkids.learnminanihongo.activity.activity.activity.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import vn.edu.techkids.learnminanihongo.R;

public class TestAlActivity extends AppCompatActivity{
        final CharSequence myList[] = { "05s", "10s", "15s", "20s", "25s", "30s" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_al);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Kiem tra bang chu cai");


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_test_alphabet, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, AlphabetActivity.class);
                //homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
                break;
            case R.id.action_timer:
                final AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setTitle("Chon thoi gian dem lui");
                ad.setSingleChoiceItems(myList, -1, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                        Toast.makeText(getApplicationContext(),
                                "You Choose : " + myList[arg1],
                                Toast.LENGTH_LONG).show();

                        arg0.cancel();
                    }
                });
                ad.create();
                ad.show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
