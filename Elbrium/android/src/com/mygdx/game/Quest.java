package com.mygdx.game;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import static com.mygdx.game.UserBase.bm;

public class Quest extends AppCompatActivity{
    public int kolvo_symbols = 0,k1,k2,m=0,ra1=0,ra2=0,ra3=0,ra4=0,ra5=0,ra6=0,v=0,st=0,n=0,c=1,player1=0,player2=0,z=0,money=0,pl1=0,pl2=0,pl=0,ra8=0;
    public int[]k = new int[70];
    public CountDownTimer countDownTimer;
    public boolean parametr=true;
    public int pro_result=0;
    public static TextView npc_tv,description,crossbar;
    public static Button btn_next,btn_exit,first,second,third;
    public static EditText input;
    public static ImageView img;
    public boolean u;
    public float vip=2;

    @Override
    protected void onStart(){
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        if(getterANDSetterFile.get_SoundMusic()==1)bm.start();
        super.onStart();
    }
    @Override
    protected void onPause(){
        if (bm.isPlaying())bm.pause();
        exit(false);
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        if(!parametr){
            if(pro_result==1)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
            if(pro_result==2)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
            if(pro_result==3)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
            if(pro_result==6){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-4);
                getterANDSetterFile.set_Church(-1);
            }
            if(pro_result==7)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
            if(pro_result==8)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
            if(pro_result==9)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
            if(pro_result==10)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
            if(pro_result==11)getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-5);
            if(pro_result==32)getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-3);
            if(pro_result==41)getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-2);
            if(pro_result==42)getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-4);
            if(pro_result==46){
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-7);
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
            }
            if(pro_result==47)getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-3);
            if(pro_result==51)getterANDSetterFile.set_Guardian_Money(0.0);
        }
        super.onPause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        getSupportActionBar().hide();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        //ID2();
        vip++;
        npc_tv = findViewById(R.id.nps_tv);
        description = findViewById(R.id.description);
        btn_next = findViewById(R.id.btn_next);
        btn_exit = findViewById(R.id.btn_exit);
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        input = findViewById(R.id.input);
        img = findViewById(R.id.nps_img);
        crossbar = findViewById(R.id.crossbar);
        start();
        exit(true);
        for (int i = 0; i < 70; i++) {
            k[i] = 0;
        }
        countDownTimer = new CountDownTimer(c*100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                c--;
                crossbar.setText("Монеты: " + getterANDSetterFile.get_Guardian_Money() + " " + "Руда: " + getterANDSetterFile.get_Ore_Elbrium());
                comments(npc_tv);
                comments(description);
            }
            @Override
            public void onFinish() {
                if (countDownTimer != null){
                    c = 1;
                    countDownTimer.start();
                }
            }
        };
        if (countDownTimer != null){
            c = 1;
            countDownTimer.start();
        }
        random();
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                random();
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Quest.this,ScrollingActivity.class));
            }
        });
    }
//    public void ID2(){
//        npc_tv = findViewById(R.id.nps_tv);
//        description = findViewById(R.id.description);
//        btn_next = findViewById(R.id.btn_next);
//        btn_exit = findViewById(R.id.btn_exit);
//        first = findViewById(R.id.first);
//        second = findViewById(R.id.second);
//        third = findViewById(R.id.third);
//        input = findViewById(R.id.input);
//        img = findViewById(R.id.nps_img);
//        crossbar = findViewById(R.id.crossbar);
//    }
    public int h_random(){
        int h = 3;
        h = 1 + (int)(Math.random()*15);
        if (h<3 || h>15)h_random();
        return h;
    }
    public int g_random(){
        int f=3;
        f = 1 + (int)(Math.random()*18);
        if (f<3 || f>18)g_random();
        return f;
    }
    public int f_random(){
        int r = 13;
        r = 1 + (int)(Math.random()*22);
        if(r<13 || r>22){
            r_random();
        }
        return r;
    }
    public int r_random(){
        int r = 15;
        r = 1 + (int)(Math.random()*24);
        if(r<15 || r>24){
            r_random();
        }
        return r;
    }
    public int k_random(){
        int random=6;
        random = 1 + (int) (Math.random() * 11);
        if (random<6)k_random();
        return random;
    }
    public void exit(boolean tf){
        parametr = tf;
    }

    public void random(){
        vip = 2+(float)(Math.random()*9);
        Log.d("VIP",vip+"");
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_ONE theme_one = new THEME_ONE();
        THEME_TWO theme_two = new THEME_TWO();
        THEME_THREE theme_three = new THEME_THREE();
        THEME_FOUR theme_four = new THEME_FOUR();
        THEME_FIVE theme_five = new THEME_FIVE();
        THEME_SIX theme_six = new THEME_SIX();
        THEME_EIGHT theme_eight = new THEME_EIGHT();
        THEME_SEVEN theme_seven = new THEME_SEVEN();
        //if(vip%4.5==0 && getterANDSetterFile.get_Band()==1)theme_three.three();
        //else random();
        //if(vip%5==0 && getterANDSetterFile.get_Church()!=0)theme_four.four();
        //else random();
        //if(vip%6==0 && getterANDSetterFile.get_Devil()!=0)theme_five.five();
        //else random();
        //if(vip%7==0)theme_six.six();
        //if(vip%8.5==0 && getterANDSetterFile.get_Dungeon()==1)theme_seven.seven();
        //else random();
        //if(vip%9.5==0)theme_eight.eight();
        //if(vip%2==0)theme_one.one();
        //if(vip%3==0)theme_two.two();
        theme_six.six();
    }
    public void start(){
        //ID2();
        npc_tv.setVisibility(View.VISIBLE);
        description.setVisibility(View.VISIBLE);
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.VISIBLE);
        third.setVisibility(View.VISIBLE);
        input.setVisibility(View.INVISIBLE);
        img.setVisibility(View.VISIBLE);
        btn_next.setVisibility(View.INVISIBLE);
        btn_exit.setVisibility(View.INVISIBLE);
    }
    public void start_plus(){
        //ID2();
        npc_tv.setVisibility(View.VISIBLE);
        description.setVisibility(View.VISIBLE);
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.INVISIBLE);
        third.setVisibility(View.INVISIBLE);
        input.setVisibility(View.INVISIBLE);
        img.setVisibility(View.VISIBLE);
        btn_next.setVisibility(View.VISIBLE);
        btn_exit.setVisibility(View.VISIBLE);
    }
//    public void hide(){
//        ID2();
//        npc_tv.setVisibility(View.INVISIBLE);
//        description.setVisibility(View.INVISIBLE);
//        first.setVisibility(View.INVISIBLE);
//        second.setVisibility(View.INVISIBLE);
//        third.setVisibility(View.INVISIBLE);
//        input.setVisibility(View.INVISIBLE);
//        img.setVisibility(View.INVISIBLE);
//        btn_next.setVisibility(View.VISIBLE);
//        btn_exit.setVisibility(View.VISIBLE);
//    }
    public void d_button(){
        //ID2();
        first.setVisibility(View.VISIBLE);
    }
    public void d_input(){
        //ID2();
        input.setVisibility(View.VISIBLE);
    }
    public void o_button(){
        //ID2();
        first.setVisibility(View.INVISIBLE);
    }
    public void o_input(){
        //ID2();
        input.setVisibility(View.INVISIBLE);
    }
    public boolean button(Button b){
        u = false;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u=true;
            }
        });
        return u;
    }
    public void comments(TextView textMessage){
        String s = textMessage.getText().toString();
        String comment = textMessage.getText().toString();
        if(s.contains("*") && textMessage.getText().toString().contains("*") && !s.contains("#")) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '*' && s.contains("*")) {
                    kolvo_symbols++;
                    if (kolvo_symbols == 2 && s.contains("*")) {
                        k1 = comment.indexOf("*");
                        k2 = comment.lastIndexOf("*");
                        SpannableStringBuilder builder = new SpannableStringBuilder();
                        SpannableString colorSpannable= new SpannableString(s);
                        colorSpannable.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.comment)),k1,k2+1,0);
                        builder.append(colorSpannable);
                        textMessage.setText(builder, TextView.BufferType.SPANNABLE);
                        kolvo_symbols = 0;
                        s = "";
                    }
                    else textMessage.setTextColor(getResources().getColor(R.color.white));
                }
            }
        }
    }
}