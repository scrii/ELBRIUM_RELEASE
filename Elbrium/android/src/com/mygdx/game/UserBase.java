package com.mygdx.game;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.mygdx.game.ScrollingActivity.mediaPlayer;

public class UserBase extends AppCompatActivity {
public Button newBase,confirm;
public TextView whatAboutLevel,infohealth,realhealth,villagers,int_villagers,happiness,int_happiness,TownHall,int_TownHall,WorkShop,int_WorkShop,Kitchen,int_Kitchen,House,int_House,School,int_School,Factory,int_Factory,Tower,int_Tower,Park,int_Park,Mill,int_Mill;
public EditText namebase;
public ImageButton but_TownHall,but_Kitchen,but_WorkShop,but_House,but_School,but_Factory,but_Tower,but_Park,but_Mill;
public CountDownTimer countDownTimer;
public int seconds=1;

int time=0,time1=0;
CountDownTimer countDownTimerQ,countDownTimerX;
public GetterANDSetterFile getterANDSetterFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_base);

        getterANDSetterFile = new GetterANDSetterFile();
        TownHall     = findViewById(R.id.TownHall);
        int_TownHall = findViewById(R.id.int_TownHall);
        WorkShop     = findViewById(R.id.WorkShop);
        int_WorkShop = findViewById(R.id.int_WorkShop);
        Kitchen      = findViewById(R.id.Kitchen);
        int_Kitchen  = findViewById(R.id.int_Kitchen);
        House        = findViewById(R.id.House);
        int_House    = findViewById(R.id.int_House);
        School       = findViewById(R.id.School);
        int_School   = findViewById(R.id.int_School);
        Factory      = findViewById(R.id.Factory);
        int_Factory  = findViewById(R.id.int_Factory);
        Tower        = findViewById(R.id.Tower);
        int_Tower    = findViewById(R.id.int_Tower);
        Park         = findViewById(R.id.Park);
        int_Park     = findViewById(R.id.int_Park);
        Mill         = findViewById(R.id.Mill);
        int_Mill     = findViewById(R.id.int_Mill);

        but_TownHall = findViewById(R.id.but_TownHall);
        but_Kitchen = findViewById(R.id.but_Kitchen);
        but_WorkShop = findViewById(R.id.but_WorkShop);
        but_House = findViewById(R.id.but_House);
        but_School = findViewById(R.id.but_School);
        but_Factory = findViewById(R.id.but_Factory);
        but_Tower = findViewById(R.id.but_Tower);
        but_Park = findViewById(R.id.but_Park);
        but_Mill = findViewById(R.id.but_Mill);

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
        namebase.setText(getterANDSetterFile.get_NameBase()+"");
        updateValues();
        //classUserBase.colors();
        chance_Kitchen();
        chance_WorkShop();
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
            but_TownHall.setVisibility(View.INVISIBLE);
            but_Tower.setVisibility(View.INVISIBLE);
            but_Park.setVisibility(View.INVISIBLE);
            but_Mill.setVisibility(View.INVISIBLE);
            but_Factory.setVisibility(View.INVISIBLE);
            but_School.setVisibility(View.INVISIBLE);
            but_House.setVisibility(View.INVISIBLE);
            but_WorkShop.setVisibility(View.INVISIBLE);
            but_Kitchen.setVisibility(View.INVISIBLE);
            int_TownHall.setVisibility(View.INVISIBLE);
            WorkShop.setVisibility(View.INVISIBLE);
            int_WorkShop.setVisibility(View.INVISIBLE);
            Kitchen.setVisibility(View.INVISIBLE);
            int_Kitchen.setVisibility(View.INVISIBLE);
            House.setVisibility(View.INVISIBLE);
            int_House.setVisibility(View.INVISIBLE);
            School.setVisibility(View.INVISIBLE);
            int_School.setVisibility(View.INVISIBLE);
            Factory.setVisibility(View.INVISIBLE);
            int_Factory.setVisibility(View.INVISIBLE);
            Tower.setVisibility(View.INVISIBLE);
            int_Tower.setVisibility(View.INVISIBLE);
            Park.setVisibility(View.INVISIBLE);
            int_Park.setVisibility(View.INVISIBLE);
            Mill.setVisibility(View.INVISIBLE);
            int_Mill.setVisibility(View.INVISIBLE);
            TownHall.setVisibility(View.INVISIBLE);
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
            but_TownHall.setVisibility(View.VISIBLE);
            but_Tower.setVisibility(View.VISIBLE);
            but_Park.setVisibility(View.VISIBLE);
            but_Mill.setVisibility(View.VISIBLE);
            but_Factory.setVisibility(View.VISIBLE);
            but_School.setVisibility(View.VISIBLE);
            but_House.setVisibility(View.VISIBLE);
            but_WorkShop.setVisibility(View.VISIBLE);
            but_Kitchen.setVisibility(View.VISIBLE);
            int_TownHall.setVisibility(View.VISIBLE);
            WorkShop.setVisibility(View.VISIBLE);
            int_WorkShop.setVisibility(View.VISIBLE);
            Kitchen.setVisibility(View.VISIBLE);
            int_Kitchen.setVisibility(View.VISIBLE);
            House.setVisibility(View.VISIBLE);
            int_House.setVisibility(View.VISIBLE);
            School.setVisibility(View.VISIBLE);
            int_School.setVisibility(View.VISIBLE);
            Factory.setVisibility(View.VISIBLE);
            int_Factory.setVisibility(View.VISIBLE);
            Tower.setVisibility(View.VISIBLE);
            int_Tower.setVisibility(View.VISIBLE);
            Park.setVisibility(View.VISIBLE);
            int_Park.setVisibility(View.VISIBLE);
            Mill.setVisibility(View.VISIBLE);
            int_Mill.setVisibility(View.VISIBLE);
            TownHall.setVisibility(View.VISIBLE);
        }
        Insurrection();
        countDownTimer = new CountDownTimer(seconds*100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                seconds--;
                updateValues();
                void_Insurrection();
                TownHall.setText("Ратуша" + " " + getterANDSetterFile.get_TownHall()*150);
                WorkShop.setText("Мастерская " + (getterANDSetterFile.get_WorkShop()*150+150));
                Kitchen.setText("Столовая " + (getterANDSetterFile.get_Kitchen()*150+150));
                House.setText("Жилой дом " + (getterANDSetterFile.get_House()*75+75));
                School.setText("Школа " + (getterANDSetterFile.get_School()*75+75));
                Factory.setText("Фабрика " + (getterANDSetterFile.get_Factory()*150+150));
                Tower.setText("Вышка " + (getterANDSetterFile.get_Tower()*75+75));
                Park.setText("Парк " + (getterANDSetterFile.get_Park()*75+75));
                Mill.setText("Завод " + (getterANDSetterFile.get_Mill()*150+150));
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
        r_Confirm();
        r_newBase();
        r_TownHall();
        r_Kitchen();
        r_WorkShop();
        r_House();
        r_School();
        Insurrection();
        chance_Factory();
        r_Factory();
        r_Tower();
        r_Park();
        r_Mill();
        chance_Mill();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.AUB, new ShopActivity.SettingsFragment()) //++++++
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    protected void onStart(){
        getterANDSetterFile = new GetterANDSetterFile();
        if(getterANDSetterFile.get_SoundMusic()==1)mediaPlayer.start();
        super.onStart();
    }
    @Override
    protected void onPause(){
        if(mediaPlayer.isPlaying())mediaPlayer.pause();
        super.onPause();
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
    public void updateValues(){
        getterANDSetterFile = new GetterANDSetterFile();
        TownHall     = findViewById(R.id.TownHall);
        int_TownHall = findViewById(R.id.int_TownHall);
        WorkShop     = findViewById(R.id.WorkShop);
        int_WorkShop = findViewById(R.id.int_WorkShop);
        Kitchen      = findViewById(R.id.Kitchen);
        int_Kitchen  = findViewById(R.id.int_Kitchen);
        House        = findViewById(R.id.House);
        int_House    = findViewById(R.id.int_House);
        School       = findViewById(R.id.School);
        int_School   = findViewById(R.id.int_School);
        Factory      = findViewById(R.id.Factory);
        int_Factory  = findViewById(R.id.int_Factory);
        Tower        = findViewById(R.id.Tower);
        int_Tower    = findViewById(R.id.int_Tower);
        Park         = findViewById(R.id.Park);
        int_Park     = findViewById(R.id.int_Park);
        Mill         = findViewById(R.id.Mill);
        int_Mill     = findViewById(R.id.int_Mill);

        but_TownHall = findViewById(R.id.but_TownHall);
        but_Kitchen = findViewById(R.id.but_Kitchen);
        but_WorkShop = findViewById(R.id.but_WorkShop);
        but_House = findViewById(R.id.but_House);
        but_School = findViewById(R.id.but_School);
        but_Factory = findViewById(R.id.but_Factory);
        but_Tower = findViewById(R.id.but_Tower);
        but_Park = findViewById(R.id.but_Park);
        but_Mill = findViewById(R.id.but_Mill);

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

        realhealth.setText(getterANDSetterFile.get_HealthBase()+"");
        int_villagers.setText(getterANDSetterFile.get_Villagers()+"");
        int_happiness.setText(getterANDSetterFile.get_Happiness()+"");
        int_TownHall.setText(getterANDSetterFile.get_TownHall()+"");
        int_Park.setText(getterANDSetterFile.get_Park()+"");
        int_Factory.setText(getterANDSetterFile.get_Factory()+"");
        int_School.setText(getterANDSetterFile.get_School()+"");
        int_Kitchen.setText(getterANDSetterFile.get_Kitchen()+"");
        int_WorkShop.setText(getterANDSetterFile.get_WorkShop()+"");
        int_House.setText(getterANDSetterFile.get_House()+"");
        int_Mill.setText(getterANDSetterFile.get_Mill()+"");
        int_Tower.setText(getterANDSetterFile.get_Tower()+"");
    }
//    public void colors(){
//        getterANDSetterFile = new GetterANDSetterFile();
//        if(getterANDSetterFile.get_Guardian_Money()<=(150.0*getterANDSetterFile.get_TownHall())){
//            RedColor(TownHall);
//            RedColor(int_TownHall);
//        }
//        else{
//            BaseColor(TownHall);
//            BaseColor(int_TownHall);
//        }
//
//    }
//    public void RedColor(TextView textView){
//        textView.setTextColor(Color.RED);
//    }
//    public void BaseColor(TextView textView){
//        textView.setTextColor(Color.GRAY);
//    }

    public void chance_Mill(){
        getterANDSetterFile = new GetterANDSetterFile();
        time1 = (15*60);
        if(getterANDSetterFile.get_Mill()>0){
            countDownTimerX = new CountDownTimer(time1*1000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    time1--;
                }

                @Override
                public void onFinish() {
                    getterANDSetterFile.set_Ore_Elbrium(getterANDSetterFile.get_Ore_Elbrium()+1);
                    if (countDownTimerX != null){
                        time1 = 1;
                        countDownTimerX.start();
                    }
                }
            };
            if (countDownTimerX != null){
                time1 = 1;
                countDownTimerX.start();
            }
        }
    }
    public void r_Mill(){
        getterANDSetterFile = new GetterANDSetterFile();
        but_Mill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insurrection();
                if(getterANDSetterFile.get_TownHall()>=6){
                    if(getterANDSetterFile.get_Guardian_Money()>=((double)(getterANDSetterFile.get_Mill()*150+150))){
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)(getterANDSetterFile.get_Mill()*150+150)));
                        getterANDSetterFile.set_Mill(getterANDSetterFile.get_Mill()+1);
                        getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-15);
                    }
                    else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"Уровень "+"Ратуши" + " слишком низок",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void r_Park(){
        getterANDSetterFile = new GetterANDSetterFile();
        but_Park.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insurrection();
                if(getterANDSetterFile.get_Guardian_Money()>=((double)(getterANDSetterFile.get_Park()*75+75))){
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)(getterANDSetterFile.get_Park()*75+75)));
                    getterANDSetterFile.set_Park(getterANDSetterFile.get_Park()+1);
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                }
                else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void r_Tower(){
        getterANDSetterFile = new GetterANDSetterFile();
        but_Tower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insurrection();
                if(getterANDSetterFile.get_TownHall()>=3){
                    if(getterANDSetterFile.get_Guardian_Money()>=((double)(getterANDSetterFile.get_Tower()*75+75))){
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)(getterANDSetterFile.get_Tower()*75+75)));
                        getterANDSetterFile.set_HealthBase(getterANDSetterFile.get_HealthBase()+3);
                        int c;
                        c = (int)(Math.random()*100000)%100;
                        if(c<=20)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                    }
                    else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"Уровень "+"Ратуши" + " слишком низок",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void r_Factory(){
        getterANDSetterFile = new GetterANDSetterFile();
        but_Factory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insurrection();
                if(getterANDSetterFile.get_Factory()<=7){
                    if(getterANDSetterFile.get_Guardian_Money()>=((double)(getterANDSetterFile.get_Factory()*150+150))){
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)(getterANDSetterFile.get_Factory()*150+150)));
                        getterANDSetterFile.set_Factory(getterANDSetterFile.get_Factory()+1);
                        getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-10);
                    }
                    else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"Вы достигли максимального уровня",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void chance_Factory(){
        getterANDSetterFile = new GetterANDSetterFile();
        if(getterANDSetterFile.get_Factory()==1)time=(11*60);
        if(getterANDSetterFile.get_Factory()==2)time=(10*60);
        if(getterANDSetterFile.get_Factory()==3)time=(9*60);
        if(getterANDSetterFile.get_Factory()==4)time=(8*60);
        if(getterANDSetterFile.get_Factory()==5)time=(7*60);
        if(getterANDSetterFile.get_Factory()==6)time=(6*60);
        if(getterANDSetterFile.get_Factory()==7)time=(5*60);
        if(getterANDSetterFile.get_Factory()>0){
            countDownTimerQ = new CountDownTimer(time*1000,1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    time--;
                }

                @Override
                public void onFinish() {
                    getterANDSetterFile.set_Ore_Elbrium(getterANDSetterFile.get_Ore_Elbrium()+1);
                    if (countDownTimerQ != null){
                        time = 1;
                        countDownTimerQ.start();
                    }
                }
            };
            if (countDownTimerQ != null){
                time = 1;
                countDownTimerQ.start();
            }
        }
    }
    public void Ruin(){
        getterANDSetterFile = new GetterANDSetterFile();
        getterANDSetterFile.set_BaseLevel(0);
        getterANDSetterFile.set_House(0);
        getterANDSetterFile.set_Happiness(25);
        getterANDSetterFile.set_Villagers(3);
        getterANDSetterFile.set_Kitchen(0);
        getterANDSetterFile.set_WorkShop(0);
        getterANDSetterFile.set_TownHall(1);
        getterANDSetterFile.set_Factory(0);
        getterANDSetterFile.set_NameBase("");
        getterANDSetterFile.set_School(0);
        getterANDSetterFile.set_Tower(0);
        getterANDSetterFile.set_Park(0);
        getterANDSetterFile.set_Mill(0);
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
            but_TownHall.setVisibility(View.INVISIBLE);
            but_Tower.setVisibility(View.INVISIBLE);
            but_Park.setVisibility(View.INVISIBLE);
            but_Mill.setVisibility(View.INVISIBLE);
            but_Factory.setVisibility(View.INVISIBLE);
            but_School.setVisibility(View.INVISIBLE);
            but_House.setVisibility(View.INVISIBLE);
            but_WorkShop.setVisibility(View.INVISIBLE);
            but_Kitchen.setVisibility(View.INVISIBLE);
            int_TownHall.setVisibility(View.INVISIBLE);
            WorkShop.setVisibility(View.INVISIBLE);
            int_WorkShop.setVisibility(View.INVISIBLE);
            Kitchen.setVisibility(View.INVISIBLE);
            int_Kitchen.setVisibility(View.INVISIBLE);
            House.setVisibility(View.INVISIBLE);
            int_House.setVisibility(View.INVISIBLE);
            School.setVisibility(View.INVISIBLE);
            int_School.setVisibility(View.INVISIBLE);
            Factory.setVisibility(View.INVISIBLE);
            int_Factory.setVisibility(View.INVISIBLE);
            Tower.setVisibility(View.INVISIBLE);
            int_Tower.setVisibility(View.INVISIBLE);
            Park.setVisibility(View.INVISIBLE);
            int_Park.setVisibility(View.INVISIBLE);
            Mill.setVisibility(View.INVISIBLE);
            int_Mill.setVisibility(View.INVISIBLE);
            TownHall.setVisibility(View.INVISIBLE);
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
            but_TownHall.setVisibility(View.VISIBLE);
            but_Tower.setVisibility(View.VISIBLE);
            but_Park.setVisibility(View.VISIBLE);
            but_Mill.setVisibility(View.VISIBLE);
            but_Factory.setVisibility(View.VISIBLE);
            but_School.setVisibility(View.VISIBLE);
            but_House.setVisibility(View.VISIBLE);
            but_WorkShop.setVisibility(View.VISIBLE);
            but_Kitchen.setVisibility(View.VISIBLE);
            int_TownHall.setVisibility(View.VISIBLE);
            WorkShop.setVisibility(View.VISIBLE);
            int_WorkShop.setVisibility(View.VISIBLE);
            Kitchen.setVisibility(View.VISIBLE);
            int_Kitchen.setVisibility(View.VISIBLE);
            House.setVisibility(View.VISIBLE);
            int_House.setVisibility(View.VISIBLE);
            School.setVisibility(View.VISIBLE);
            int_School.setVisibility(View.VISIBLE);
            Factory.setVisibility(View.VISIBLE);
            int_Factory.setVisibility(View.VISIBLE);
            Tower.setVisibility(View.VISIBLE);
            int_Tower.setVisibility(View.VISIBLE);
            Park.setVisibility(View.VISIBLE);
            int_Park.setVisibility(View.VISIBLE);
            Mill.setVisibility(View.VISIBLE);
            int_Mill.setVisibility(View.VISIBLE);
            TownHall.setVisibility(View.VISIBLE);
        }
    }
    public void Insurrection(){
        getterANDSetterFile = new GetterANDSetterFile();
        if(getterANDSetterFile.get_Happiness()<10){
            Ruin();
            Toast.makeText(getApplicationContext(),"Уровень счастья слишком низок, вашу диктатуру свергли. Вы потеряли всё",Toast.LENGTH_SHORT).show();
        }
        if(getterANDSetterFile.get_Happiness()>=10 && getterANDSetterFile.get_Happiness()<=15)Toast.makeText(getApplicationContext(),"Уровень счастья низкий. Людям это не нравится",Toast.LENGTH_SHORT).show();
        if(getterANDSetterFile.get_Happiness()>55){
            Ruin();
            Toast.makeText(getApplicationContext(),"Уровень счастья на хорошем уровне. Люди считают, что вы им ненужны. Вы потеряли всё",Toast.LENGTH_SHORT).show();
        }
    }
    public void void_Insurrection(){
        getterANDSetterFile = new GetterANDSetterFile();
        if(getterANDSetterFile.get_Happiness()<10)Ruin();
        if(getterANDSetterFile.get_Happiness()>55)Ruin();
    }
    public void r_School(){
        getterANDSetterFile = new GetterANDSetterFile();
        but_School.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insurrection();
                if(getterANDSetterFile.get_Guardian_Money()>=((double)(getterANDSetterFile.get_School()*75+75))){
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)(getterANDSetterFile.get_School()*75+75)));
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+3);
                }
                else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void r_House(){
        getterANDSetterFile = new GetterANDSetterFile();
        but_House.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insurrection();
                if(getterANDSetterFile.get_Guardian_Money()>=((double)(getterANDSetterFile.get_House()*75+75))){
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)(getterANDSetterFile.get_House()*75+75)));
                    getterANDSetterFile.set_House(getterANDSetterFile.get_House()+1);
                    int ch;
                    ch = (int)(Math.random()*100000)%100;
                    if(ch<=50)getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()+1);
                    else Toast.makeText(getApplicationContext(),"В ваш дом никто не заселился",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void r_WorkShop(){
        getterANDSetterFile = new GetterANDSetterFile();
        but_Factory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insurrection();
                if(getterANDSetterFile.get_WorkShop()<=7){
                    if(getterANDSetterFile.get_TownHall()>=5){
                        if(getterANDSetterFile.get_Villagers()>0){
                            if(getterANDSetterFile.get_Guardian_Money()>=((double)(getterANDSetterFile.get_WorkShop()*150+150))){
                                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)(getterANDSetterFile.get_WorkShop()*150+150)));
                                getterANDSetterFile.set_WorkShop(getterANDSetterFile.get_WorkShop()+1);
                                getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()-1);
                            }
                            else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_SHORT).show();
                        }
                        else Toast.makeText(getApplicationContext(),"Недостаточно людей, постройте дома",Toast.LENGTH_SHORT).show();
                    }
                    else Toast.makeText(getApplicationContext(),"Уровень "+"Ратуши" + " слишком низок",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"Вы достигли максимального уровня",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void chance_WorkShop(){
        getterANDSetterFile = new GetterANDSetterFile();
        int chance;
        chance = (int)(Math.random()*100000)%100;
        if(chance<=getterANDSetterFile.get_WorkShop())getterANDSetterFile.set_Speed(getterANDSetterFile.get_Speed()+0.1);
    }
    public void r_Kitchen(){
        getterANDSetterFile = new GetterANDSetterFile();
        but_Kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insurrection();
                if(getterANDSetterFile.get_Kitchen()<=7){
                    if(getterANDSetterFile.get_TownHall()>=4){
                        if(getterANDSetterFile.get_Villagers()>0){
                            if(getterANDSetterFile.get_Guardian_Money()>=((double)((getterANDSetterFile.get_Kitchen()*150+150)))){
                                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double) (getterANDSetterFile.get_Kitchen()*150+150)));
                                getterANDSetterFile.set_Kitchen(getterANDSetterFile.get_Kitchen()+1);
                            }
                            else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_SHORT).show();
                        }
                        else Toast.makeText(getApplicationContext(),"Недостаточно людей, постройте дома",Toast.LENGTH_SHORT).show();
                    }
                    else Toast.makeText(getApplicationContext(),"Уровень "+"Ратуши" + " слишком низок",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"Вы достигли максимального уровня",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void chance_Kitchen(){
        getterANDSetterFile = new GetterANDSetterFile();
        int change;
        change = (int)(Math.random()*100000)%100;
        if(change<=getterANDSetterFile.get_Kitchen())getterANDSetterFile.set_Health(getterANDSetterFile.get_Health()+0.1);
    }
    public void r_TownHall(){
        getterANDSetterFile = new GetterANDSetterFile();
        but_TownHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insurrection();
                if(getterANDSetterFile.get_TownHall()<=7){
                    if(getterANDSetterFile.get_Guardian_Money() >= (150.0*getterANDSetterFile.get_TownHall())){
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-(150.0*getterANDSetterFile.get_TownHall()));
                        if(getterANDSetterFile.get_TownHall()==2)getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()+2);
                        if(getterANDSetterFile.get_TownHall()==7)getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()+7);
                        getterANDSetterFile.set_TownHall(getterANDSetterFile.get_TownHall()+1);
                    }
                    else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(),"Вы достигли максимального уровня",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void r_newBase(){
        getterANDSetterFile = new GetterANDSetterFile();
        newBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getterANDSetterFile.get_Guardian_Money()>=150.0){
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-150.0);
                    getterANDSetterFile.set_BaseLevel(1);
                    getterANDSetterFile.set_TownHall(1);
                    updateValues();
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
                        but_TownHall.setVisibility(View.INVISIBLE);
                        but_Tower.setVisibility(View.INVISIBLE);
                        but_Park.setVisibility(View.INVISIBLE);
                        but_Mill.setVisibility(View.INVISIBLE);
                        but_Factory.setVisibility(View.INVISIBLE);
                        but_School.setVisibility(View.INVISIBLE);
                        but_House.setVisibility(View.INVISIBLE);
                        but_WorkShop.setVisibility(View.INVISIBLE);
                        but_Kitchen.setVisibility(View.INVISIBLE);
                        int_TownHall.setVisibility(View.INVISIBLE);
                        WorkShop.setVisibility(View.INVISIBLE);
                        int_WorkShop.setVisibility(View.INVISIBLE);
                        Kitchen.setVisibility(View.INVISIBLE);
                        int_Kitchen.setVisibility(View.INVISIBLE);
                        House.setVisibility(View.INVISIBLE);
                        int_House.setVisibility(View.INVISIBLE);
                        School.setVisibility(View.INVISIBLE);
                        int_School.setVisibility(View.INVISIBLE);
                        Factory.setVisibility(View.INVISIBLE);
                        int_Factory.setVisibility(View.INVISIBLE);
                        Tower.setVisibility(View.INVISIBLE);
                        int_Tower.setVisibility(View.INVISIBLE);
                        Park.setVisibility(View.INVISIBLE);
                        int_Park.setVisibility(View.INVISIBLE);
                        Mill.setVisibility(View.INVISIBLE);
                        int_Mill.setVisibility(View.INVISIBLE);
                        TownHall.setVisibility(View.INVISIBLE);
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
                        but_TownHall.setVisibility(View.VISIBLE);
                        but_Tower.setVisibility(View.VISIBLE);
                        but_Park.setVisibility(View.VISIBLE);
                        but_Mill.setVisibility(View.VISIBLE);
                        but_Factory.setVisibility(View.VISIBLE);
                        but_School.setVisibility(View.VISIBLE);
                        but_House.setVisibility(View.VISIBLE);
                        but_WorkShop.setVisibility(View.VISIBLE);
                        but_Kitchen.setVisibility(View.VISIBLE);
                        int_TownHall.setVisibility(View.VISIBLE);
                        WorkShop.setVisibility(View.VISIBLE);
                        int_WorkShop.setVisibility(View.VISIBLE);
                        Kitchen.setVisibility(View.VISIBLE);
                        int_Kitchen.setVisibility(View.VISIBLE);
                        House.setVisibility(View.VISIBLE);
                        int_House.setVisibility(View.VISIBLE);
                        School.setVisibility(View.VISIBLE);
                        int_School.setVisibility(View.VISIBLE);
                        Factory.setVisibility(View.VISIBLE);
                        int_Factory.setVisibility(View.VISIBLE);
                        Tower.setVisibility(View.VISIBLE);
                        int_Tower.setVisibility(View.VISIBLE);
                        Park.setVisibility(View.VISIBLE);
                        int_Park.setVisibility(View.VISIBLE);
                        Mill.setVisibility(View.VISIBLE);
                        int_Mill.setVisibility(View.VISIBLE);
                        TownHall.setVisibility(View.VISIBLE);
                    }
                }
                else Toast.makeText(getApplicationContext(),"Недостаточно средств",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void r_Confirm(){
        getterANDSetterFile = new GetterANDSetterFile();
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getterANDSetterFile.set_NameBase(namebase.getText()+"");
            }
        });
    }
}
