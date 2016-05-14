package vn.edu.techkids.learnminanihongo.activity.activity.activity.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import Support.SupportGlobal;
import vn.edu.techkids.learnminanihongo.R;

public class MiniGameActivity extends AppCompatActivity {

    public static final String LOG_TAG = MiniGameActivity.class.getSimpleName();

    Button btnKanji_1_1;
    Button btnKanji_1_2;
    Button btnKanji_1_3;
    Button btnKanji_2_1;
    Button btnKanji_2_2;
    Button btnKanji_2_3;
    Button btnKanji_3_1;
    Button btnKanji_3_2;
    Button btnKanji_3_3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnKanji_1_1 = (Button) findViewById(R.id.button_1_1);
        SupportGlobal.buttonKanjiArrayList.add(btnKanji_1_1);

        btnKanji_1_2 = (Button) findViewById(R.id.button_1_2);
        SupportGlobal.buttonKanjiArrayList.add(btnKanji_1_2);

        btnKanji_1_3 = (Button) findViewById(R.id.button_1_3);
        SupportGlobal.buttonKanjiArrayList.add(btnKanji_1_3);

        btnKanji_2_1 = (Button) findViewById(R.id.button_2_1);
        SupportGlobal.buttonKanjiArrayList.add(btnKanji_2_1);

        btnKanji_2_2 = (Button) findViewById(R.id.button_2_2);
        SupportGlobal.buttonKanjiArrayList.add(btnKanji_2_2);

        btnKanji_2_3 = (Button) findViewById(R.id.button_2_3);
        SupportGlobal.buttonKanjiArrayList.add(btnKanji_2_3);

        btnKanji_3_1 = (Button) findViewById(R.id.button_3_1);
        SupportGlobal.buttonKanjiArrayList.add(btnKanji_3_1);

        btnKanji_3_2 = (Button) findViewById(R.id.button_3_2);
        SupportGlobal.buttonKanjiArrayList.add(btnKanji_3_2);

        btnKanji_3_3 = (Button) findViewById(R.id.button_3_3);
        SupportGlobal.buttonKanjiArrayList.add(btnKanji_3_3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        for(int i = 0;i < SupportGlobal.buttonKanjiArrayList.size() ; i++){
            final Button newBtn = SupportGlobal.buttonKanjiArrayList.get(i);
            newBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!newBtn.getText().toString().equals("日本")) {
                        newBtn.setBackgroundResource(R.drawable.custom_button_kanji_checked);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                newBtn.setBackgroundResource(R.drawable.custom_button_kanji);
                            }
                        }, 2000);
                    }else {
                        newBtn.setBackgroundResource(R.drawable.custom_button_kanji_checked);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                newBtn.setVisibility(View.GONE);
                            }
                        }, 2000);
                    }
                }
            });
        }
    }

}
