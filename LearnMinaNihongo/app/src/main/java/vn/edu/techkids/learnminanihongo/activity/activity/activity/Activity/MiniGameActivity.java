package vn.edu.techkids.learnminanihongo.activity.activity.activity.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import Support.SupportGlobal;
import vn.edu.techkids.learnminanihongo.R;

public class MiniGameActivity extends AppCompatActivity {

    public static final String LOG_TAG = MiniGameActivity.class.getSimpleName();

    private int checking;
    private int checkString;

    Button btnKanji_1_1;
    Button btnKanji_1_2;
    Button btnKanji_1_3;
    Button btnKanji_2_1;
    Button btnKanji_2_2;
    Button btnKanji_2_3;
    Button btnKanji_3_1;
    Button btnKanji_3_2;
    Button btnKanji_3_3;

    ImageButton showAll;
    ImageButton reset;
    TextView tvQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checking = 0;
        checkString = 0;

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

        tvQuestion = (TextView)findViewById(R.id.tvQuestion);
        showAll = (ImageButton)findViewById(R.id.btnShow);
        reset = (ImageButton)findViewById(R.id.btnReset);

        showAllWord();

        tvQuestion.setText("START");
        tvQuestion.setTextSize(20);

    }

    @Override
    protected void onResume() {
        super.onResume();
        for(int i = 0;i < SupportGlobal.buttonKanjiArrayList.size() ; i++){
            final Button newBtn = SupportGlobal.buttonKanjiArrayList.get(i);
            newBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!newBtn.getText().toString().equals(tvQuestion.getText().toString())) {
                        newBtn.setBackgroundResource(R.drawable.custom_button_kanji_checked);
                        newBtn.setTextSize(10);
                        checking=checking+1;
                        if(checking%3==0) {
                            Log.d(LOG_TAG, " Running ");
                            Toast.makeText(MiniGameActivity.this, "YOU LOSE", Toast.LENGTH_SHORT).show();
                            resetGame();
                        }
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                newBtn.setBackgroundResource(R.drawable.custom_button_kanji);
                                newBtn.setTextSize(0);
                            }
                        }, 2000);
                    }else {
                        newBtn.setBackgroundResource(R.drawable.custom_button_kanji_checked);
                        newBtn.setTextSize(10);
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                newBtn.setVisibility(View.GONE);
                                tvQuestion.setText(SupportGlobal.stringKanjiArray[checkString % SupportGlobal.stringKanjiArray.length]);
                            }
                        }, 2000);
                        checkString++;
                    }
                }
            });
        }
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });

        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAllWord();
            }
        });

        tvQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
                tvQuestion.setText(SupportGlobal.stringKanjiArray[checking % SupportGlobal.stringKanjiArray.length]);
            }
        });
    }

    private void resetGame() {
        checkString = 0;
        for (int i = 0; i < SupportGlobal.buttonKanjiArrayList.size(); i++) {
            SupportGlobal.buttonKanjiArrayList.get(i).setVisibility(View.VISIBLE);
            SupportGlobal.buttonKanjiArrayList.get(i).setTextSize(0);
            SupportGlobal.buttonKanjiArrayList.get(i).setBackgroundResource(R.drawable.custom_button_kanji);

        }
    }

    private void showAllWord() {
        for (int i = 0; i < SupportGlobal.buttonKanjiArrayList.size(); i++) {
            SupportGlobal.buttonKanjiArrayList.get(i).setVisibility(View.VISIBLE);
            SupportGlobal.buttonKanjiArrayList.get(i).setTextSize(10);
        }
    }
}
