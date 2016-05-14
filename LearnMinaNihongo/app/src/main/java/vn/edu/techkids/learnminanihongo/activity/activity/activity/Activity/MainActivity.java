package vn.edu.techkids.learnminanihongo.activity.activity.activity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import vn.edu.techkids.learnminanihongo.R;

public class MainActivity extends AppCompatActivity {

    ImageButton btnPlayMiniGame;
    ImageButton btnAlphabet;
    ImageButton btnDialogJP;
    ImageButton btnMinna;
    ImageButton btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        btnPlayMiniGame = (ImageButton)findViewById(R.id.btnMiniGame);
        btnAlphabet = (ImageButton)findViewById(R.id.btnAlphabet);
        btnDialogJP = (ImageButton)findViewById(R.id.btnDialogJP);
        btnMinna = (ImageButton)findViewById(R.id.btnMinna);
        btnExit = (ImageButton)findViewById(R.id.btnExit);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mina Nihongo");
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        //hien nut back
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        btnPlayMiniGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MiniGameActivity.class);
                startActivity(intent);
            }
        });
        btnMinna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MinaActivity.class);
                startActivity(intent);
            }
        });
        btnAlphabet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AlphabetActivity.class);
                startActivity(intent);
            }
        });
        btnDialogJP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
