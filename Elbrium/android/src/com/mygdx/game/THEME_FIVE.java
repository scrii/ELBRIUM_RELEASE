package com.mygdx.game;

import android.os.CountDownTimer;
import android.view.View;

public class THEME_FIVE extends Quest{
    int ra5=0;
    int s5=1;
    CountDownTimer countDownTimer5;
    public String r1 = "Пора платить по счетам. *Все ваши монеты куда-то исчезают, внутри себя чуть выше желудка вы чувствуете пустоту*";
    public String r1_c = "Он тебе не поможет, потому что тоже в моей власти";
    public String r2 = "Тебе не хватает рабочей силы? Я выделю тебе немного.";
    public String r2_c = "Как хочешь, - *доносится до вас*";
    public String r3 = "Продай мне часть своей души. В загробный мир я тебе обеспечу, а здесь и сейчас дам за неё деньги.";
    public String r3_c = "Ладно-ладно успеешь ещё передумать, - *звучит в вашей голове*";
    public String r4 = "Отдай мне ключ от подземелья, я за него заплачу.";
    public String r4_c = "Зря… - *слышите вы*";
    public String r5_1 = "У меня есть для тебя сделка: я дам тебе деньги, а ты взамен будешь носить мою метку в своём имени, но поменять его увы будет нельзя? Что, скажешь, 500 монет?";
    public String r5_2 = "Уверен? 1000 монет.";

    public void five(){
        vip++;
        //ID2();
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_FIVE theme_five = new THEME_FIVE();
        ra5 = 1;
        countDownTimer5 = new CountDownTimer(s5*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                s5--;
                if (getterANDSetterFile.get_Devil()!=0){
                    if(ra5==1){
                        img.setImageResource(R.mipmap.devil);
                        pro_result=51;
                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r1);
                        second.setText("Отдать долг");
                        third.setText("Священник!");
                        second.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getterANDSetterFile.set_Guardian_Money(0.0);
                                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-1000);
                                ra5++;
                                start_plus();
                            }
                        });
                        third.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+100);
                                getterANDSetterFile.set_Guardian_Money(0.0);
                                description.setText(description.getText().toString() + "\n" +theme_five.r1_c);
                                ra5++;
                                start_plus();
                            }
                        });
                    }
                    if(ra5==2 && getterANDSetterFile.get_Villagers()<=3){
                        img.setImageResource(R.mipmap.devil);
                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r2);
                        second.setText("Взять");
                        third.setText("Отказаться");
                        second.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()+3);
                                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-1000);
                                ra5++;
                                start_plus();
                            }
                        });
                        third.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+100);
                                description.setText(description.getText().toString() + "\n" +theme_five.r2_c);
                                ra5++;
                                start_plus();
                            }
                        });
                    }
                    else ra5++;
                    if (ra5==3){
                        img.setImageResource(R.mipmap.devil);
                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r3);
                        second.setText("Забирай");
                        third.setText("Нет, только не моя душа!");
                        second.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+250.0);
                                ra5++;
                                start_plus();
                            }
                        });
                        third.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                description.setText(description.getText().toString() + "\n" +theme_five.r3_c);
                                ra5++;
                                start_plus();
                            }
                        });
                    }
                    if (ra5==4 && getterANDSetterFile.get_Dungeon()==1){
                        img.setImageResource(R.mipmap.devil);
                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r4);
                        second.setText("Отдать");
                        third.setText("Оставить себе");
                        second.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                description.setText(description.getText().toString() + "\n" +theme_five.r4);
                                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+250.0);
                                getterANDSetterFile.set_Dungeon(0);
                                ra5++;
                                start_plus();
                            }
                        });
                        third.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                description.setText(description.getText().toString() + "\n" + theme_five.r4_c);
                                ra5++;
                                start_plus();
                            }
                        });
                    }
                    else ra5++;
                    if(ra5==5 && getterANDSetterFile.get_Block()!=1){
                        img.setImageResource(R.mipmap.devil);
                        npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r5_1);
                        second.setText("Согласиться");
                        third.setText("Отказаться");
                        second.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                getterANDSetterFile.set_Block(1);
                                getterANDSetterFile.set_Nickname(getterANDSetterFile.get_Nickname()+"_Marked_of_curse");
                                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+500.0);
                                THEME_SIX theme_six = new THEME_SIX();
                                theme_six.six();
                                start_plus();
                            }
                        });
                        third.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_five.r5_2);
                                second.setText("Согласиться");
                                third.setText("Отказаться");
                                second.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        getterANDSetterFile.set_Block(1);
                                        getterANDSetterFile.set_Nickname(getterANDSetterFile.get_Nickname()+"_Marked_of_curse");
                                        getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+1000.0);
                                        THEME_SIX theme_six = new THEME_SIX();
                                        theme_six.six();
                                        start_plus();
                                    }
                                });
                                third.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        THEME_SIX theme_six = new THEME_SIX();
                                        theme_six.six();
                                        start_plus();
                                    }
                                });
                            }
                        });
                    }
                    else {
                        THEME_SIX theme_six = new THEME_SIX();
                        theme_six.six();
                    }
                }
                else {
                    THEME_SIX theme_six = new THEME_SIX();
                    theme_six.six();
                }
            }
            @Override
            public void onFinish() {
                if (countDownTimer5 != null) {
                    s5 = 1;
                    countDownTimer5.start();
                }
            }
        };
        if (countDownTimer5 != null) {
            s5 = 1;
            countDownTimer5.start();
        }
    }
}