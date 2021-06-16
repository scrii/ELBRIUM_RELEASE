package com.mygdx.game;

import android.os.CountDownTimer;
import android.view.View;

public class THEME_EIGHT extends Quest{
    int ra8=0,s8=1;
    CountDownTimer countDownTimer8;
    public String e1 = "К нам прилетели пришельцы!";
    public String e1_c_1 = "*Вы бежите смотреть «пришельцев», но это оказываются обычные грузчики с другой планеты. Вы здороваетесь с ними и делаете вид, что шли не к ним. Сделав большой крюк, вы вернулись*";
    public String e1_c_2 = "Да, что я пришельцев не видел? – *говорите вы уверенно. А ведь и правда не видел, - думаете вы*";
    public String e2 = "Мы бы хотели получить разрешение на организацию бала.";
    public String e3 = "Здравствуйте, МАиЖ (министерство архитектуры и живописи) хотело бы сделать оранжерею на вашей базе. Что скажите?";
    public String e4 = "Здравствуйте, МАиЖ-у не нравится, как выглядят коридоры. Хотите, чтобы мы их улучшили?";

    public void eight(){
        vip++;
        //ID2();
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_EIGHT theme_eight = new THEME_EIGHT();
        ra8 = 1;
        countDownTimer8 = new CountDownTimer(s8*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                s8--;
                if (ra8==1){
                    img.setImageResource(R.mipmap.base_avatar_1);
                    npc_tv.setText(npc_tv.getText().toString() + "\n" +  theme_eight.e1);
                    second.setText("Посмотреть");
                    third.setText("Игнорировать");
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" + theme_eight.e1_c_1);
                            ra8++;
                            start_plus();
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() +"\n"+ theme_eight.e1_c_2);
                            ra8++;
                            start_plus();
                        }
                    });
                }
                if (ra8==2){
                    img.setImageResource(R.mipmap.base_avatar_1);
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_eight.e2);
                    second.setText("Проводите");
                    third.setText("Нет");
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                            ra8++;
                            start_plus();
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                            ra8++;
                            start_plus();
                        }
                    });
                }
                if (ra8==3){
                    img.setImageResource(R.mipmap.base_avatar_1);
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_eight.e3);
                    second.setText("Стройте");
                    third.setText("Нет");
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                            ra8++;
                            start_plus();
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-1);
                            ra8++;
                            start_plus();
                        }
                    });
                }
                if (ra8==4){
                    img.setImageResource(R.mipmap.base_avatar_1);
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_eight.e4);
                    second.setText("Да");
                    third.setText("Нет");
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-25.0);
                            getterANDSetterFile.set_HealthBase(getterANDSetterFile.get_HealthBase()+1);
                            THEME_ONE theme_one = new THEME_ONE();
                            theme_one.one();
                            start_plus();
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-2);
                            THEME_ONE theme_one = new THEME_ONE();
                            theme_one.one();
                            start_plus();
                        }
                    });
                }
            }
            @Override
            public void onFinish() {
                if (countDownTimer8 != null) {
                    s8 = 1;
                    countDownTimer8.start();
                }
            }
        };
        if (countDownTimer8 != null) {
            s8 = 1;
            countDownTimer8.start();
        }
    }
}