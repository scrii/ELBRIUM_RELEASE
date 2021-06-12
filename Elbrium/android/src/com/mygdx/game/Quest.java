package com.mygdx.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import static com.mygdx.game.UserBase.bm;

public class Quest extends AppCompatActivity {
    public int kolvo_symbols = 0,k1,k2,m=0,ra1=0,ra2=0,ra3=0,ra4=0,ra5=0,ra6=0,v=0,st=0,n=0,c=1,player1=0,player2=0,z=0,money=0,pl1=0,pl2=0,pl=0,ra8=0;
    public int[]k = new int[70];
    public CountDownTimer countDownTimer;
    public boolean parametr=true;
    public int pro_result=0;
    public TextView npc_tv,description,crossbar;
    public Button btn_next,btn_exit,first,second,third;
    public EditText input;
    public ImageView img;
    public boolean u;

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
        two();
        //ID2();
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
        //random();
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
    public void stav(){
        //ID2();
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
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_SIX theme_six = new THEME_SIX();
        if (Integer.parseInt(input.getText().toString())<=0)Toast.makeText(getApplicationContext(),"Вы же всерьёз не думаете, что можете ставить отрицательные числа",Toast.LENGTH_SHORT).show();
        if (Integer.parseInt(input.getText().toString())>0 && (getterANDSetterFile.get_Guardian_Money()-(double)Integer.parseInt(input.getText().toString()))>0.0){
            st = st + Integer.parseInt(input.getText().toString());
            k[n] = k_random();
            crossbar.setText(crossbar.getText().toString() + k[n] + " ");
            n++;
            k[n] = k_random();
            crossbar.setText(crossbar.getText().toString() + k[n] + " ");
            n++;
            crossbar.setText(crossbar.getText().toString() + "sum: " + (k[n]+k[n]) +"");
            description.setText(description.getText().toString() + "\n" +theme_six.w1_4);
            d_button();
            first.setText("Повысить ставку и попросить ещё одну карту");
            second.setText("Повысить ставку");
            third.setText("Пас");
            if (button(first)){
                d_input();
                stav();
            }
            if (button(second)){
                d_input();
                int mn = 1 + (int)(Math.random()*10);
                if ((((double)getterANDSetterFile.get_Guardian_Money()*80.0)/100.0)>=Integer.parseInt(input.getText().toString())){
                    if(mn==1){
                        start_plus();
                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + (double)(Integer.parseInt(input.getText().toString())*1.5));
                        Toast.makeText(getApplicationContext(),"Ваш выигрыш: " + ((double)(Integer.parseInt(input.getText().toString())*1.5))+"",Toast.LENGTH_SHORT).show();
                    }
                    else stav();
                }
            }
            if (button(third)){
                player1 = r_random();
                player2 = f_random();
                for (int i = 0; i < 70; i++) {
                    z = z + k[i];
                }
                if(z>21){
                    start_plus();
                    Toast.makeText(getApplicationContext(),"Вы проиграли: " + st + "",Toast.LENGTH_SHORT).show();
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - (double)(st));
                }
                if (player1>z && player2>z){
                    start_plus();
                    Toast.makeText(getApplicationContext(),"Вы проиграли: " + st + "",Toast.LENGTH_SHORT).show();
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - (double)(st));

                }
                else{
                    start_plus();
                    double m=0,y=0;
                    m = (Math.random());
                    String res = "";
                    res = String.format("%.1f",m);
                    y = Double.parseDouble(res.replace(',','.'));
                    Toast.makeText(getApplicationContext(),"Вы выиграли: " + st*y + "",Toast.LENGTH_SHORT).show();
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + (double)(st*y));
                }
            }
        }
        else Toast.makeText(getApplicationContext(),"Недостаточно средств!",Toast.LENGTH_SHORT).show();
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
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        m = 1 + (int) (Math.random() * 8);
        THEME_ONE theme_one = new THEME_ONE();
        THEME_TWO theme_two = new THEME_TWO();
        THEME_THREE theme_three = new THEME_THREE();
        THEME_FOUR theme_four = new THEME_FOUR();
        THEME_FIVE theme_five = new THEME_FIVE();
        THEME_SIX theme_six = new THEME_SIX();
        THEME_SEVEN theme_seven = new THEME_SEVEN();
        THEME_EIGHT theme_eight = new THEME_EIGHT();
        if(m==1)theme_one.one();
        if(m==2)theme_two.two();
        if(m==3 && getterANDSetterFile.get_Band()==1)theme_three.three();
        else random();
        if(m==4 && getterANDSetterFile.get_Church()!=0)theme_four.four();
        else random();
        if(m==5 && getterANDSetterFile.get_Devil()!=0)theme_five.five();
        else random();
        if(m==6)theme_six.six();
        if(m==7 && getterANDSetterFile.get_Dungeon()==1)theme_seven.seven();
        else random();
        if(m==8)theme_eight.eight();
    }
    public void start(){
        //ID2();
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
        npc_tv.setVisibility(View.VISIBLE);
        description.setVisibility(View.VISIBLE);
        first.setVisibility(View.VISIBLE);
        second.setVisibility(View.VISIBLE);
        third.setVisibility(View.VISIBLE);
        input.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);
        btn_next.setVisibility(View.INVISIBLE);
        btn_exit.setVisibility(View.INVISIBLE);
    }
    public void start_plus(){
        //ID2();
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
        npc_tv.setVisibility(View.VISIBLE);
        description.setVisibility(View.VISIBLE);
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.INVISIBLE);
        third.setVisibility(View.INVISIBLE);
        input.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);
        btn_next.setVisibility(View.VISIBLE);
        btn_exit.setVisibility(View.VISIBLE);
    }
    public void hide(){
        //ID2();
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
        npc_tv.setVisibility(View.INVISIBLE);
        description.setVisibility(View.INVISIBLE);
        first.setVisibility(View.INVISIBLE);
        second.setVisibility(View.INVISIBLE);
        third.setVisibility(View.INVISIBLE);
        input.setVisibility(View.INVISIBLE);
        img.setVisibility(View.INVISIBLE);
        btn_next.setVisibility(View.VISIBLE);
        btn_exit.setVisibility(View.VISIBLE);
    }
    public void d_button(){
        //ID2();
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
        first.setVisibility(View.VISIBLE);
    }
    public void d_input(){
        //ID2();
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
        input.setVisibility(View.VISIBLE);
    }
    public void o_button(){
        //ID2();
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
        first.setVisibility(View.INVISIBLE);
    }
    public void o_input(){
        //ID2();
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
    public void eight(){
        //ID2();
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
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_EIGHT theme_eight = new THEME_EIGHT();
        ra8 = 1 + (int) (Math.random() * 10);
        if (ra8>4)random();
        else{
            if (ra8==1){
                img.setImageResource(R.mipmap.base_avatar_1);
                npc_tv.setText(npc_tv.getText().toString() + "\n" +  theme_eight.e1);
                second.setText("Посмотреть");
                third.setText("Игнорировать");
                if (button(second)){
                    description.setText(description.getText().toString() + "\n" + theme_eight.e1_c_1);
                    start_plus();
                }
                if (button(third)){
                    description.setText(description.getText().toString() +"\n"+ theme_eight.e1_c_2);
                    start_plus();
                }
            }
            if (ra8==2){
                img.setImageResource(R.mipmap.base_avatar_1);
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_eight.e2);
                second.setText("Проводите");
                third.setText("Нет");
                if (button(second)){
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                    start_plus();
                }
                if (button(third)){
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                    start_plus();
                }
            }
            if (ra8==3 && getterANDSetterFile.get_Guardian_Money()>=10.0){
                img.setImageResource(R.mipmap.base_avatar_1);
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_eight.e3);
                second.setText("Стройте");
                third.setText("Нет");
                if (button(second)){
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                    start_plus();
                }
                if (button(third)){
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                    start_plus();
                }
            }
            else random();
            if (ra8==4 && getterANDSetterFile.get_Guardian_Money()>=25.0){
                img.setImageResource(R.mipmap.base_avatar_1);
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_eight.e4);
                second.setText("Да");
                third.setText("Нет");
                if (button(second)){
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-25.0);
                    getterANDSetterFile.set_HealthBase(getterANDSetterFile.get_HealthBase()+1);
                    start_plus();
                }
                if (button(third)){
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-2);
                    start_plus();
                }
            }
            else random();
        }
    }
    public void seven(){
        //ID2();
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
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_SEVEN theme_seven = new THEME_SEVEN();
        if (getterANDSetterFile.get_Dungeon()==1 && getterANDSetterFile.get_Church()>0){
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s1);
            img.setImageResource(R.color.black);
            second.setText("Открыть");
            third.setText("Уйти");
            if (button(second)){
                o_button();
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s2);
                second.setText("Прислушаться");
                third.setText("Игнорировать");
                if (button(second)){
                    o_button();
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s3);
                    second.setText("Ускорить шаг");
                    third.setText("Подняться наверх и вызвать стражу");
                    if (button(second)){
                        d_button();
                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s5);
                        first.setText("Представиться" + getterANDSetterFile.get_Nickname());
                        second.setText("Представиться священником");
                        third.setText("Представиться главарём банды");
                        if (button(first)){
                            o_button();
                            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s9);
                            second.setText("Отдать ключ");
                            third.setText("Броситься наверх");
                            if (button(second)){
                                o_button();
                                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s15);
                                second.setText("Толкнуть");
                                third.setText("Побежать наверх");
                                if (button(second)){
                                    o_button();
                                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s27);
                                    getterANDSetterFile.set_Dungeon(0);
                                    start_plus();
                                }
                                if (button(third)){
                                    o_button();
                                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s17);
                                    getterANDSetterFile.set_Dungeon(0);
                                    start_plus();
                                }
                            }
                            if (button(third)){
                                o_button();
                                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s17);
                                getterANDSetterFile.set_Dungeon(0);
                                start_plus();
                            }
                        }
                        if (button(second)){
                            o_button();
                            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s11);
                            second.setText("Благословить");
                            third.setText("Проклясть");
                            if (button(second)){
                                o_button();
                                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s19);
                                second.setText("Отдать ключ");
                                third.setText("Броситься наверх");
                                if (button(second)){
                                    o_button();
                                    second.setText("Толкнуть");
                                    third.setText("Побежать наверх");
                                    if (button(second)){
                                        o_button();
                                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s27);
                                        getterANDSetterFile.set_Dungeon(0);
                                        start_plus();
                                    }
                                    if (button(third)){
                                        o_button();
                                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s17);
                                        getterANDSetterFile.set_Dungeon(0);
                                        start_plus();
                                    }
                                }
                                if (button(third)){
                                    o_button();
                                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s17);
                                    getterANDSetterFile.set_Dungeon(0);
                                    start_plus();
                                }
                            }
                            if (button(third)){
                                o_button();
                                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s21);
                                getterANDSetterFile.set_Dungeon(0);
                                start_plus();
                            }
                        }
                        if (button(third)){
                            o_button();
                            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s13);
                            second.setText(getterANDSetterFile.get_Nickname());
                            third.setText("Г.Б.");
                            if (button(second)){
                                o_button();
                                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s23);
                                getterANDSetterFile.set_Dungeon(0);
                                start_plus();
                            }
                            if (button(third)){
                                o_button();
                                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s25);
                                second.setText("Пойти дальше");
                                third.setText("Вернуться назад");
                                if (button(second)){
                                    o_button();
                                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s12);
                                    second.setText("Продолжить спуск");
                                    third.setText("Вернуться назад");
                                    if (button(second)){
                                        o_button();
                                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s20);
                                        getterANDSetterFile.set_Dungeon(0);
                                        start_plus();
                                    }
                                    if (button(third)){
                                        o_button();
                                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s22);
                                        getterANDSetterFile.set_Dungeon(0);
                                        start_plus();
                                    }
                                }
                                if (button(third)){
                                    o_button();
                                    description.setText(description.getText().toString() + "\n" + theme_seven.s25_c);
                                    getterANDSetterFile.set_Dungeon(0);
                                    start_plus();
                                }
                            }
                        }
                    }
                    if (button(third)){
                        o_button();
                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s7);
                        getterANDSetterFile.set_Dungeon(0);
                        start_plus();
                    }
                }
                if (button(third)){
                    d_button();
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s4);
                    first.setText("Продолжить спуск");
                    second.setText("Спросить кто умер");
                    third.setText("Вернуться назад");
                    if (button(first)){
                        o_button();
                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s6);
                        o_button();
                        second.setText("Продолжить путь");
                        third.setText("Повернуть назад");
                        if (button(second)){
                            o_button();
                            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s12);
                            second.setText("Продолжить спуск");
                            third.setText("Вернуться назад");
                            if (button(second)){
                                o_button();
                                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s20);
                                getterANDSetterFile.set_Dungeon(0);
                                start_plus();
                            }
                            if (button(third)){
                                o_button();
                                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s22);
                                getterANDSetterFile.set_Dungeon(0);
                                start_plus();
                            }
                        }
                        if (button(third)){
                            o_button();
                            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s14);
                            getterANDSetterFile.set_Dungeon(0);
                            start_plus();
                        }
                    }
                    if (button(second)){
                        o_button();
                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s8);
                        second.setText("2021");
                        third.setText("Молча продолжить спуск вниз");
                        if (button(second)){
                            o_button();
                            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s16);
                            getterANDSetterFile.set_Dungeon(0);
                            start_plus();
                        }
                        if (button(third)){
                            o_button();
                            description.setText(description.getText().toString() + "\n" + theme_seven.s8_c);
                            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s18);
                            getterANDSetterFile.set_Dungeon(0);
                            start_plus();
                        }
                    }
                    if (button(third)){
                        o_button();
                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_seven.s10);
                        getterANDSetterFile.set_Dungeon(0);
                        start_plus();
                    }
                }
            }
            if (button(third)){
                o_button();
                description.setText(description.getText().toString() + "\n" + theme_seven.s1_c);
                start_plus();
            }
        }
        else random();
    }
    public void six(){
        //ID2();
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
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_SIX theme_six = new THEME_SIX();
        ra6 = 1 + (int) (Math.random() * 10);
        if (ra6<5 && getterANDSetterFile.get_Guardian_Money()>0.0 && getterANDSetterFile.get_Ore_Elbrium()>0.0){
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_six.w1_1);
            second.setText("Хочу");
            third.setText("Не интересует");
            if (button(second)){
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_six.w1_2);
                d_button();
                first.setText("Монеты");
                second.setText("elbrium");
                third.setText("Я передумал");
                if (button(first)){
                    v=1;
                }
                if (button(second)){
                    v=2;
                }
                if ((button(first) || button(second)) && v!=0){
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_six.w1_3);
                    d_input();
                    o_button();
                    second.setText("*Отдать крупье*");
                    third.setText("Я передумал");
                    if (button(second)){
                        try {
                            stav();
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"Введено не число!",Toast.LENGTH_SHORT).show();
                            e.printStackTrace();
                        }
                    }
                    if (button(third)){
                        start_plus();
                    }
                }
                if (button(third)){
                    start_plus();
                }
            }
            if (button(third)){
                start_plus();
            }
        }
        else if(getterANDSetterFile.get_Guardian_Money()>0){
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_six.w2_1);
            second.setText("Да");
            third.setText("Нет");
            if (button(second)){
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_six.w2_2);
                d_input();
                second.setText("Ввод");
                third.setText("Я передумал");
                if (button(second)){
                    try {
                        if (Integer.parseInt(input.getText().toString())<=0)Toast.makeText(getApplicationContext(),"Вы же всерьёз не думаете, что можете ставить отрицательные числа",Toast.LENGTH_SHORT).show();
                        if (Integer.parseInt(input.getText().toString())>0 && Integer.parseInt(input.getText().toString())<=10 && (getterANDSetterFile.get_Guardian_Money()-(double)Integer.parseInt(input.getText().toString()))>0.0){
                            money = Integer.parseInt(input.getText().toString());
                            pl = g_random();
                            pl1 = h_random();
                            pl2 = g_random();
                            if (pl<pl1 && pl<pl2){
                                start_plus();
                                Toast.makeText(getApplicationContext(),"Вы проиграли: " + Integer.parseInt(input.getText().toString()) + "",Toast.LENGTH_SHORT).show();
                                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - (double)(Integer.parseInt(input.getText().toString())));
                            }
                            else{
                                start_plus();
                                double m=0,y=0;
                                m = (Math.random());
                                String res = "";
                                res = String.format("%.1f",m);
                                y = Double.parseDouble(res.replace(',','.'));
                                Toast.makeText(getApplicationContext(),"Вы выиграли: " + (money + money*y) + "",Toast.LENGTH_SHORT).show();
                                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + (double)(money + money*y));
                            }
                        }
                        else Toast.makeText(getApplicationContext(),"Вы сделали что-то не так!",Toast.LENGTH_SHORT).show();
                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(),"Введено не число!",Toast.LENGTH_SHORT).show();
                        start_plus();
                        e.printStackTrace();
                    }
                }
                if (button(third)){
                    start_plus();
                }
            }
            if (button(third)){
                start_plus();
            }
        }
    }
    public void five(){
        //ID2();
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
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_FIVE theme_five = new THEME_FIVE();
        ra5 = 1 + (int) (Math.random() * 10);
        if(ra5>5)random();
        if(ra5==1 && getterANDSetterFile.get_Guardian_Money()>0){
            img.setImageResource(R.mipmap.devil);
            pro_result=51;
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r1);
            second.setText("Отдать долг");
            third.setText("Священник!");
            if (button(second)){
                getterANDSetterFile.set_Guardian_Money(0.0);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-1000);
                start_plus();
            }
            if (button(third)){
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+100);
                getterANDSetterFile.set_Guardian_Money(0.0);
                description.setText(description.getText().toString() + "\n" +theme_five.r1_c);
                start_plus();
            }
        }
        else random();
        if(ra5==2 && getterANDSetterFile.get_Villagers()<=3){
            img.setImageResource(R.mipmap.devil);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r2);
            second.setText("Взять");
            third.setText("Отказаться");
            if (button(second)){
                getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()+3);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-1000);
                start_plus();
            }
            if (button(third)){
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+100);
                description.setText(description.getText().toString() + "\n" +theme_five.r2_c);
                start_plus();
            }
        }
        else random();
        if (ra5==3){
            img.setImageResource(R.mipmap.devil);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r3);
            second.setText("Забирай");
            third.setText("Нет, только не моя душа!");
            if (button(second)){
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+250.0);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_five.r3_c);
                start_plus();
            }
        }
        if (ra5==4 && getterANDSetterFile.get_Dungeon()==1){
            img.setImageResource(R.mipmap.devil);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r4);
            second.setText("Отдать");
            third.setText("Оставить себе");
            if (button(second)){
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+250.0);
                getterANDSetterFile.set_Dungeon(0);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_five.r4);
                start_plus();
            }
        }
        else random();
        if(ra5==5 && getterANDSetterFile.get_Block()!=1){
            img.setImageResource(R.mipmap.devil);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r5_1);
            second.setText("Согласиться");
            third.setText("Отказаться");
            if (button(second)){
                getterANDSetterFile.set_Block(1);
                getterANDSetterFile.set_Nickname(getterANDSetterFile.get_Nickname()+"_Marked_of_curse");
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+500.0);
                start_plus();
            }
            if (button(third)){
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r5_2);
                second.setText("Согласиться");
                third.setText("Отказаться");
                if (button(second)){
                    getterANDSetterFile.set_Block(1);
                    getterANDSetterFile.set_Nickname(getterANDSetterFile.get_Nickname()+"_Marked_of_curse");
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+1000.0);
                    start_plus();
                }
                if (button(third)){
                    start_plus();
                }
            }
        }
        else random();
    }
    public void four(){
        //ID2();
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
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_FOUR theme_four = new THEME_FOUR();
        ra4 = 1 + (int) (Math.random() * 10);
        if (ra4==1 && getterANDSetterFile.get_Guardian_Money()>=(double)(75 + (getterANDSetterFile.get_House()*75+75)) && getterANDSetterFile.get_Church()>0){
            pro_result=41;
            img.setImageResource(R.mipmap.chur);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d1);
            second.setText("Раз счастливыми, то можно");
            third.setText("Нет, слишком дорого");
            if (button(second)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - (double)(75 + (getterANDSetterFile.get_House()*75+75)));
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+1);
                getterANDSetterFile.set_House(getterANDSetterFile.get_House()+1);
                start_plus();
            }
            if (button(third)){
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-2);
                start_plus();
            }
        }
        else random();
        if (ra4==2 && getterANDSetterFile.get_Guardian_Money()>=400.0 && getterANDSetterFile.get_Church()>0){
            img.setImageResource(R.mipmap.chur);
            pro_result=42;
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d2);
            second.setText("Да, вы правы");
            third.setText("Обойдётся");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_four.d2_c_1);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-400.0);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_four.d2_c_2);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-4);
                start_plus();
            }
        }
        else random();
        if (ra4==3 && getterANDSetterFile.get_Church()<-10 && getterANDSetterFile.get_Church()>-1000){
            d_button();
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d3);
            img.setImageResource(R.mipmap.chur);
            first.setText("Поздороваться");
            second.setText("Помолиться");
            third.setText("Забаррикадироваться");
            if (button(first)){
                description.setText(description.getText().toString() + "\n" +theme_four.d3_c_1);
                start_plus();
            }
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_four.d3_c_2);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+1);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_four.d3_c_3);
                start_plus();
            }
        }
        else random();
        if (ra4==4 && getterANDSetterFile.get_Church()>=10){
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d4);
            img.setImageResource(R.mipmap.chur);
            second.setText("Встретить");
            third.setText("*Закатить глаза*");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_four.d4_c_1);
                getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()+3);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+2);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_four.d4_c_2);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-3);
                start_plus();
            }
        }
        else random();
        if (ra4==5 && getterANDSetterFile.get_Church()>=25 && getterANDSetterFile.get_Dungeon()!=1){
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d5);
            img.setImageResource(R.mipmap.chur);
            second.setText("Взять");
            third.setText("И куда мне её поставить?");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_four.d5_c_1);
                getterANDSetterFile.set_Dungeon(1);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_four.d5_c_2);
                start_plus();
            }
        }
        else random();
        if (ra4==6 && getterANDSetterFile.get_Guardian_Money()>0){
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d6);
            img.setImageResource(R.mipmap.chur);
            pro_result=46;
            d_input();
            second.setText("Конечно");
            third.setText("Конечно, нет");
            if (button(second)){
                try {
                    if (Integer.parseInt(input.getText().toString())>0){
                        if (Integer.parseInt(input.getText().toString())<100 && getterANDSetterFile.get_Guardian_Money()>=Integer.parseInt(input.getText().toString())){
                            description.setText(description.getText().toString() + "\n" +theme_four.d6_c_1);
                            getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+1);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-(double)(Integer.parseInt(input.getText().toString())));
                            start_plus();
                        }
                        if (Integer.parseInt(input.getText().toString())>=100 && Integer.parseInt(input.getText().toString())!=666){
                            description.setText(description.getText().toString() + "\n" +theme_four.d6_c_2);
                            getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+3);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-(double)(Integer.parseInt(input.getText().toString())));
                            start_plus();
                        }
                        if (Integer.parseInt(input.getText().toString())==666){
                            description.setText(description.getText().toString() + "\n" +theme_four.d6_c_3);
                            start_plus();
                        }
                    }
                    else Toast.makeText(getApplicationContext(),"Деньги не могут быть отрицательными",Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    start_plus();
                    Toast.makeText(getApplicationContext(),"Введено не число!",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
            if (button(third)){
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-7);
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
                start_plus();
            }
        }
        else random();
        if(ra4==7 && getterANDSetterFile.get_Church()>0){
            pro_result=47;
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d7);
            img.setImageResource(R.mipmap.chur);
            second.setText("Почему нет?");
            third.setText("Нет, у меня есть дела");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_four.d7_c_1);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_four.d7_c_2);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-3);
                start_plus();
            }
        }
        else random();
        if(ra4==8 && getterANDSetterFile.get_Church()<-1000){
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d8);
            img.setImageResource(R.mipmap.chur);
            second.setText("Рассмеяться");
            third.setText("Промолчать");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_four.d8_c_1);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-100);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_four.d8_c_2);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-50);
                start_plus();
            }
        }
        else random();
        if (ra4==9 && getterANDSetterFile.get_Church()<-1100){
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d9);
            img.setImageResource(R.mipmap.chur);
            second.setText("Non");
            third.setText("Abnegant");
            if (button(second)){
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-1000);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+250.0);
                start_plus();
            }
            if (button(third)){
                getterANDSetterFile.set_Church(1);
                start_plus();
            }
        }
        else random();
        if (ra4==10 && getterANDSetterFile.get_Church()>0){
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d10_1);
            img.setImageResource(R.mipmap.chur);
            d_button();
            first.setText("Да");
            second.setText("Не приходилось");
            third.setText("Не умею читать");
            if (button(first)){
                d_input();
                description.setText(description.getText().toString() + "\n" +theme_four.d10_1_c_1);
                if(input.getText().toString().contains("Дьявол")||input.getText().toString().contains("дьявол")||input.getText().toString().contains("devil")||input.getText().toString().contains("Devil")||input.getText().toString().contains("diabolus")||input.getText().toString().contains("Diabolus")){
                    description.setText(description.getText().toString() + "\n" +theme_four.d10_2_c_1);
                    getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-6);
                    start_plus();
                }
                else if(input.getText().toString().contains("Бог")||input.getText().toString().contains("бог")||input.getText().toString().contains("God")||input.getText().toString().contains("god")||input.getText().toString().contains("Deus")||input.getText().toString().contains("deus")){
                    description.setText(description.getText().toString() + "\n" +theme_four.d10_2_c_2);
                    getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+5);
                    start_plus();
                }
                else{
                    description.setText(description.getText().toString() + "\n" +theme_four.d10_2_c_3);
                    start_plus();
                }
            }
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_four.d10_1_c_2);
                description.setText(description.getText().toString()+"\n"+theme_four.d10_3);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+2);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_four.d10_1_c_3);
                start_plus();
            }
        }
        else random();
    }
    public void three(){
        //ID2();
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
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_THREE theme_three = new THEME_THREE();
        ra3 = 1 + (int) (Math.random() * 10);
        if (ra3==8)random();
        if (ra3==9)random();
        if (ra3==10)random();
        if (ra3==1){
            img.setImageResource(R.mipmap.bandit);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v1);
            second.setText("Согласиться");
            third.setText("Отказаться");
            if (button(second)){
                double ran = 1 + (double) (Math.random() * 10);
                if (ran<2.25){
                    description.setText(description.getText().toString() + "\n" +theme_three.v1_c_1 + " " + theme_three.v1_c_2);
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + 25.0);
                }
                else{
                    description.setText(description.getText().toString() + "\n" +theme_three.v1_c_1 + " " + theme_three.v1_c_3);
                }
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_three.v1_c_4);
            }
        }
        if (ra3==2){
            pro_result=32;
            img.setImageResource(R.mipmap.chur);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v2_1);
            second.setText("Согласиться со священником");
            third.setText("Отказаться");
            if (button(second)){
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v2_2);
                second.setText("Да, не желаю вас больше видеть");
                third.setText("Это ложь");
                if (button(second)){
                    description.setText(description.getText().toString() + "\n" +theme_three.v2_2_c);
                    getterANDSetterFile.set_Band(0);
                    start_plus();
                }
                if (button(third)){
                    getterANDSetterFile.set_Church(-3);
                    start_plus();
                }
            }
            if (button(third)){
                img.setImageResource(R.mipmap.bandit);
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v2_3);
                second.setText("Согласиться");
                third.setText("Не стоит");
                if (button(second)){
                    getterANDSetterFile.set_Church(-1000);
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-15);
                    start_plus();
                }
                if (button(third)){
                    start_plus();
                }
            }
        }
        if (ra3==3 && getterANDSetterFile.get_Guardian_Money()>=25.0 && getterANDSetterFile.get_Villagers()>=1 && getterANDSetterFile.get_Church()!=0){
            img.setImageResource(R.mipmap.bandit);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v3);
            second.setText("Помочь");
            third.setText("Конкуренция – это хорошо");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_three.v3_c_1);
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-3);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-25.0);
                getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()-1);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_three.v3_c_2);
                start_plus();
            }
        }
        else random();
        if (ra3==4 && getterANDSetterFile.get_Guardian_Money()>=150.0){
            img.setImageResource(R.mipmap.bandit);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v4_1);
            d_button();
            first.setText("Подписать");
            second.setText("Прочитать");
            third.setText("Разорвать");
            if (button(first)){
                description.setText(description.getText().toString() + "\n" +theme_three.v4_1_c_1);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-150.0);
                start_plus();
            }
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_three.v4_2);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_three.v4_1_c_2);
                start_plus();
            }
        }
        else random();
        if (ra3==5 && getterANDSetterFile.get_Guardian_Money()>=400){
            img.setImageResource(R.mipmap.bandit);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v5);
            second.setText("Дать 200 монет");
            third.setText("Бредовая идея");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_three.v5_c_1);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-400.0);
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_three.v5_c_2);
                start_plus();
            }
        }
        else random();
        if (ra3==6){
            img.setImageResource(R.mipmap.bandit);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v6);
            second.setText("Взять");
            third.setText("Отказаться");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_three.v6_c_1);
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+100.0);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_three.v6_c_2);
                start_plus();
            }
        }
        if (ra3==7){
            d_button();
            img.setImageResource(R.mipmap.bandit);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v7);
            first.setText("И сколько вам нужно?");
            second.setText("И кто тот несчастный, чью базу вы хотите продать?");
            third.setText("Ну уж нет, звучит глупо");
            if (button(first)){
                description.setText(description.getText().toString() + "\n" +theme_three.v7_c_1);
                start_plus();
            }
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_three.v7_c_2);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_three.v7_c_3);
                start_plus();
            }
        }
    }
    public void two(){
        //ID2();
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
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_TWO theme_two = new THEME_TWO();
        ra2 = 1 + (int) (Math.random() * 10);
        if (ra2==1 && getterANDSetterFile.get_Guardian_Money()>=10){
            pro_result=11;
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_two.m1);
            img.setImageResource(R.mipmap.base_avatar_1);
            d_button();
            first.setText("Дать ограбленные деньги");
            second.setText("Заставить стражу расследовать это дело");
            third.setText("Что например?");
            if (button(first)){
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-5);
                start_plus();
            }
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_two.m1_c_1 + "\n" + theme_two.m1_c_2);
                start_plus();
            }
            if (button(third)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                start_plus();
            }
        }
        else random();
        if (ra2==2 && getterANDSetterFile.get_Guardian_Money()>=150.0){
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_two.m2);
            img.setImageResource(R.mipmap.base_avatar_1);
            second.setText("Конечно!");
            third.setText("Проваливай");
            if (button(second)){
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-150.0);
                description.setText(description.getText().toString() + "\n" +theme_two.m2_c);
                start_plus();
            }
            if (button(third)){
                start_plus();
            }
        }
        else random();
        if (ra2==3 && getterANDSetterFile.get_Guardian_Money()>=500.0){
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_two.m3);
            img.setImageResource(R.mipmap.base_avatar_1);
            second.setText("Хорошо");
            third.setText("Проваливай");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_two.m3_c);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+150.0);
                start_plus();
            }
            if (button(third)){
                start_plus();
            }
        }
        else random();
        if (ra2==4 && getterANDSetterFile.get_Guardian_Money()>=1000.0 && getterANDSetterFile.get_Band()==1){
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_two.m4);
            img.setImageResource(R.mipmap.bandit);
            second.setText("Купить");
            third.setText("Отказаться");
            int ran = 1 + (int)(Math.random()*10);
            if (button(second)){
                if(ran<5) {
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + 200.0);
                    description.setText(description.getText().toString() + "\n" +theme_two.m4_c_1);
                    start_plus();
                }
                else{
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-1000.0);
                    description.setText(description.getText().toString() + "\n" +theme_two.m4_c_2);
                    start_plus();
                }
            }
            if (button(third)){
                start_plus();
            }
        }
        else random();
        if (ra2==5 && getterANDSetterFile.get_Band()!=1){
            img.setImageResource(R.mipmap.bandit);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_two.m5);
            second.setText("Хорошо");
            third.setText("Кто его впустил?");
            if (button(second)){
                getterANDSetterFile.set_Band(1);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_two.m5_c);
                start_plus();
            }
        }
        else random();
        if (ra2==6 && getterANDSetterFile.get_Guardian_Money()>=(double)(getterANDSetterFile.get_Tower()*75+75) && getterANDSetterFile.get_Villagers()>0){
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_two.m6);
            second.setText("Постройте вышку");
            third.setText("Ничего страшного, с нами марсианский бог, выживем");
            if (button(second)){
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-(double)(getterANDSetterFile.get_Tower()*75+75));
                getterANDSetterFile.set_Tower(getterANDSetterFile.get_Tower()+1);
                start_plus();
            }
            if (button(third)){
                int ran = 1 + (int)(Math.random()*10);
                if (ran<5){
                    getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()-1);
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-2);
                }
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+1);
                start_plus();
            }
        }
        else random();
        if (ra2==7 && getterANDSetterFile.get_Guardian_Money()>0.0){
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_two.m7);
            second.setText("Хорошо");
            third.setText("Звучит сомнительно, нет");
            if (button(second)){
                d_input();
                try {
                    if (Integer.parseInt(input.getText().toString())>=0){
                        if (Integer.parseInt(input.getText().toString())==0)description.setText(description.getText().toString() + "\n" +"Но вы же ничего мне не дали!");
                        if (Integer.parseInt(input.getText().toString())<=10 && Integer.parseInt(input.getText().toString())>0){
                            description.setText(description.getText().toString() + "\n" +theme_two.m7_c_2);
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)Integer.parseInt(input.getText().toString())));
                            start_plus();
                        }
                        if (Integer.parseInt(input.getText().toString())>10 && Integer.parseInt(input.getText().toString())<=50){
                            description.setText(description.getText().toString() + "\n" +theme_two.m7_c_3);
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+2);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)Integer.parseInt(input.getText().toString())));
                            start_plus();
                        }
                        if (Integer.parseInt(input.getText().toString())>50 && Integer.parseInt(input.getText().toString())<=200){
                            description.setText(description.getText().toString() + "\n" + theme_two.m7_c_4);
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+3);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)Integer.parseInt(input.getText().toString())));
                            start_plus();
                        }
                        if (Integer.parseInt(input.getText().toString())>200 && Integer.parseInt(input.getText().toString())!=666){
                            description.setText(description.getText().toString() + "\n" +theme_two.m7_c_5);
                            start_plus();
                        }
                        if (Integer.parseInt(input.getText().toString())==666){
                            description.setText(description.getText().toString() + "\n" +theme_two.m7_c_6);
                            getterANDSetterFile.set_Devil(1);
                            getterANDSetterFile.set_Church(-666);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)Integer.parseInt(input.getText().toString())));
                            start_plus();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Сумма не может быть отрицательной!",Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Введено не число!",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_two.m7_c_1);
            }
        }
        else random();
        if (ra2==8 && getterANDSetterFile.get_Villagers()>0 && getterANDSetterFile.get_Guardian_Money()>=50.0){
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_two.m8);
            second.setText("Проверить");
            third.setText("Нет, она надежно защищена");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_two.m8_c_1);
                getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()-1);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_two.m8_c_2);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-50.0);
                start_plus();
            }
        }
        else random();
        if (ra2==9 && getterANDSetterFile.get_Guardian_Money()>=100){
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_two.m9);
            second.setText("Купить");
            third.setText("Отказаться");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_two.m9_c_1);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_two.m9_c_2);
                start_plus();
            }
        }
        else random();
        if (ra2==10 && getterANDSetterFile.get_Guardian_Money()==666.0){
            img.setImageResource(R.mipmap.devil);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_two.m10);
            second.setText("Согласиться");
            third.setText("Отказаться");
            if (button(second)){
                description.setText(description.getText().toString() + "\n" +theme_two.m10_c_1);
                start_plus();
            }
            if (button(third)){
                description.setText(description.getText().toString() + "\n" +theme_two.m10_c_2);
                start_plus();
            }
        }
    }
    public void one(){
        //ID2();
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
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_ONE theme_one = new THEME_ONE();
        ra1 = 1 + (int) (Math.random() * 10);
        if(ra1==1 && getterANDSetterFile.get_Guardian_Money()>=50){
            pro_result=1;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q1);
            second.setText("Да");
            third.setText("Нет");
            if(button(second)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-50.0);
                start_plus();
            }
            if(button(third)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
                start_plus();
            }
            exit(true);
        }
        else random();
        if(ra1==2 && getterANDSetterFile.get_Guardian_Money()>=100.0){
            pro_result=2;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q2);
            second.setText("Оставить всё как есть");
            third.setText("Уничтожить");
            if(button(second)){
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-100.0);
                start_plus();
            }
            if(button(third)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                start_plus();
            }
            exit(true);
        }
        else random();
        if(ra1==3){
            pro_result=3;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q3);
            second.setText("Выдать");
            third.setText("Отказать");
            d_input();
            if(button(second)){
                if(Integer.parseInt(input.getText().toString())<50 || Integer.parseInt(input.getText().toString())>300)npc_tv.setText(npc_tv.getText().toString() + "\n" + "Но я не просил столько!");
                if(Integer.parseInt(input.getText().toString())>50 || Integer.parseInt(input.getText().toString())<300){
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-Integer.parseInt(input.getText().toString()));
                    start_plus();
                }
            }
            if(button(third)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
                start_plus();
            }
            exit(true);
        }
        if(ra1==4 && getterANDSetterFile.get_Band()!=1){
            pro_result=4;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q4_1);
            second.setText("Уничтожить");
            third.setText("Оставить");
            if(button(second)){
                img.setImageResource(R.mipmap.bandit);
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q4_2);
                second.setText("Оставить");
                third.setText("Убирайтесь");
                if(button(second)){
                    int a = 1 + (int) (Math.random() * 100);
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+((double)a));
                    description.setText(description.getText().toString() + "\n" + theme_one.q4_12_c);
                    getterANDSetterFile.set_Band(1);
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                    start_plus();
                }
                if(button(third)){
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+3);
                    start_plus();
                }
            }
            if(button(third)){
                int a = 1 + (int) (Math.random() * 100);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+((double)a));
                description.setText(description.getText().toString() + "\n" +theme_one.q4_12_c);
                getterANDSetterFile.set_Band(1);
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                start_plus();
            }
        }
        else random();
        if(ra1==5 && getterANDSetterFile.get_Guardian_Money()>=5){
            pro_result=5;
            img.setImageResource(R.mipmap.base_avatar_1);
            second.setText("Да");
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q5_1);
            third.setText("Нет");
            if(button(second)){
                d_button();
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q5_2);
                first.setText("Отругать");
                second.setText("Будь осторожнее *дать 5 монет*");
                third.setText("Забудь");
                if(button(first)){
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q5_3);
                    o_button();
                    second.setText("Промолчать");
                    third.setText("Накричать");
                    if(button(second)){
                        start_plus();
                    }
                    if(button(third)){
                        getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                    }
                }
                if(button(second)){
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-5.0);
                    start_plus();
                }
                if(button(third)){
                    start_plus();
                }
            }
            if(button(third)){
                start_plus();
            }
        }
        else random();
        if(ra1==6 && getterANDSetterFile.get_Church()==0){
            pro_result=6;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q6);
            second.setText("Прогнать");
            third.setText("Радушно встретить");
            if(button(second)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-4);
                getterANDSetterFile.set_Church(-1);
                description.setText(description.getText().toString() + "\n" +theme_one.q6_c);
                start_plus();
            }
            if(button(third)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+4);
                getterANDSetterFile.set_Church(1);
                description.setText(description.getText().toString() + "\n" +theme_one.q6_c);
                start_plus();
            }
        }
        else random();
        if(ra1==7 && getterANDSetterFile.get_Guardian_Money()>=50.0){
            pro_result=7;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q7);
            second.setText("Можно");
            third.setText("Нет");
            if(button(second)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+3);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-50.0);
                start_plus();
            }
            if(button(third)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
                start_plus();
            }
        }
        else random();
        if(ra1==8 && getterANDSetterFile.get_Guardian_Money()>=(double)(getterANDSetterFile.get_School()*75+75)){
            pro_result=8;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q8);
            d_button();
            first.setText("Вообще-то их достаточно");
            second.setText("Нет");
            third.setText("Так постройте больше школ!");
            if(button(first)){
                if(getterANDSetterFile.get_Villagers()<getterANDSetterFile.get_School())description.setText(description.getText().toString() + "\n" +theme_one.q8_c);
                else getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                start_plus();
            }
            if(button(second)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                start_plus();
            }
            if(button(third)){
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)(getterANDSetterFile.get_School()*75+75)));
                getterANDSetterFile.set_School(getterANDSetterFile.get_School()+1);
                start_plus();
            }
        }
        else random();
        if(ra1==9 && getterANDSetterFile.get_Guardian_Money()>=(double)((getterANDSetterFile.get_Park()*75+75))){
            pro_result=9;
            img.setImageResource(R.mipmap.base_avatar_1);
            d_button();
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q9);
            first.setText("Но я только в прошлом месяце построил новый!");
            second.setText("Нет");
            third.setText("Так постройте больше парков!");
            if (button(first)){
                if (getterANDSetterFile.get_Park()>getterANDSetterFile.get_Villagers()){
                    description.setText(description.getText().toString() + "\n" + theme_one.q9_c);
                    start_plus();
                }
                else getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
            }
            if(button(second)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                start_plus();
            }
            if (button(third)){
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-((double)(getterANDSetterFile.get_Park()*75+75)));
                getterANDSetterFile.set_Park(getterANDSetterFile.get_Park()+1);
                start_plus();
            }
        }
        else random();
        if(ra1==10){
            pro_result=10;
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q10_1);
            img.setImageResource(R.mipmap.base_avatar_1);
            second.setText("Давай");
            third.setText("Нет");
            if (button(second)){
                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_one.q10_2);
                second.setText("Шедевр, можешь не продолжать");
                third.setText("Ты что пьян?");
                if (button(second)){
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                    start_plus();
                }
                if (button(third)){
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                    start_plus();
                }
            }
            if (button(third)){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                start_plus();
            }
        }
    }

}