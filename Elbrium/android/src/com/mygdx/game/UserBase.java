package com.mygdx.game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import static com.mygdx.game.ScrollingActivity.mediaPlayer;

public class UserBase extends AppCompatActivity {
Button newBase,confirm;
TextView whatAboutLevel,infohealth,realhealth,villagers,int_villagers,happiness,int_happiness;
EditText namebase;
CountDownTimer countDownTimer;
int seconds=1;
GetterANDSetterFile getterANDSetterFile;
    @Override
    protected void onStart(){
        happiness = findViewById(R.id.happiness);
        int_happiness = findViewById(R.id.int_happiness);
        villagers = findViewById(R.id.villagers);
        int_villagers = findViewById(R.id.int_villagers);
        infohealth = findViewById(R.id.infohealth);
        realhealth = findViewById(R.id.realhealth);
        namebase = findViewById(R.id.infobase);
        confirm = findViewById(R.id.infobasebutton);
        newBase = findViewById(R.id.newbase);
        whatAboutLevel = findViewById(R.id.whataboutlevel);
        if(getterANDSetterFile.get_BaseLevel()==0){
            newBase.setVisibility(View.VISIBLE);
            whatAboutLevel.setVisibility(View.VISIBLE);
            //===============================
            namebase.setVisibility(View.INVISIBLE);
            confirm.setVisibility(View.INVISIBLE);
            infohealth.setVisibility(View.INVISIBLE);
            realhealth.setVisibility(View.INVISIBLE);
            villagers.setVisibility(View.INVISIBLE);
            int_villagers.setVisibility(View.INVISIBLE);
            int_happiness.setVisibility(View.INVISIBLE);
            happiness.setVisibility(View.INVISIBLE);
        }
        else {
            newBase.setVisibility(View.INVISIBLE);
            whatAboutLevel.setVisibility(View.INVISIBLE);
            //====================================
            namebase.setVisibility(View.VISIBLE);
            confirm.setVisibility(View.VISIBLE);
            infohealth.setVisibility(View.VISIBLE);
            realhealth.setVisibility(View.VISIBLE);
            villagers.setVisibility(View.VISIBLE);
            int_villagers.setVisibility(View.VISIBLE);
            int_happiness.setVisibility(View.VISIBLE);
            happiness.setVisibility(View.VISIBLE);
        }
        if(namebase.getVisibility()==View.VISIBLE)namebase.setText(getterANDSetterFile.get_NameBase());
        if(realhealth.getVisibility()==View.VISIBLE)realhealth.setText(getterANDSetterFile.get_HealthBase());
        if(int_villagers.getVisibility()==View.VISIBLE)int_villagers.setText(getterANDSetterFile.get_Villagers());
        if(int_happiness.getVisibility()==View.VISIBLE)int_happiness.setText(getterANDSetterFile.get_Happiness());
        if(getterANDSetterFile.get_SoundMusic()==1)mediaPlayer.start();
        super.onStart();
    }
    @Override
    protected void onPause(){
        if(mediaPlayer.isPlaying())mediaPlayer.pause();
        super.onPause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_base);
        getterANDSetterFile = new GetterANDSetterFile();
        countDownTimer = new CountDownTimer(seconds*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                seconds--;
                if(namebase.getText().toString()!=getterANDSetterFile.get_NameBase())getterANDSetterFile.set_NameBase(namebase.getText()+"");
                if(realhealth.getText().toString()!=(getterANDSetterFile.get_HealthBase()+""))realhealth.setText(getterANDSetterFile.get_HealthBase()+"");
                if(int_villagers.getText().toString()!=(getterANDSetterFile.get_Villagers()+""))realhealth.setText(getterANDSetterFile.get_Villagers()+"");
                if(int_happiness.getText().toString()!=(getterANDSetterFile.get_Happiness()+""))realhealth.setText(getterANDSetterFile.get_Happiness()+"");

            }
            @Override
            public void onFinish() {
                if (countDownTimer != null){
                    seconds = 1;
                    countDownTimer.start();
                }
            }
        };
        if (countDownTimer != null){
            seconds = 1;
            countDownTimer.start();
        }
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getterANDSetterFile.set_NameBase(namebase.getText()+"");
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.AUB, new ShopActivity.SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            //setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}