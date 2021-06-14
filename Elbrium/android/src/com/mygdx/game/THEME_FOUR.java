package com.mygdx.game;

import android.widget.Toast;

public class THEME_FOUR extends Quest{
    GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
    public String d1 = "Нужно построить церковь! Люди становятся счастливыми, когда ходят туда. А нужно всего лишь " + (75 + getterANDSetterFile.get_House()*75) + " монет, что скажите?";
    public String d2 = "Через неделю к нам прилетает патриарх марсианской церкви. Нужно встретить его подобающе!";
    public String d2_c_1 = "*Священник, поклонившись, улыбнулся вам. Однако через неделю никакой патриарх не прилетел, а священник избегал вас, а при редких встречах не понимал о каких деньгах вы говорили*";
    public String d2_c_2 = "*Священник грозно посмотрел на вас, но так ничего и не сказал. Поползли слухи, что вы безбожник*";
    public String d3 = "*Вы узнаёте, что церковь признаёт вас безбожником и сыном дьявола, объявляя на вас охоту. Разъярённая толпа несётся к вашим дверям*";
    public String d3_c_1 = "*Толпа недоумённо смотрит на то, как вы приветствуете их, ожидая продолжения, однако вы стоите не в силах придумать что-то ещё. Люди начинают думать, что вы сумасшедший*";
    public String d3_c_2 = "*Ворвавшиеся толпа видит вас молящимся и мало-помалу успокаивается*";
    public String d3_c_3 = "*Испугавшись толпы вы прячетесь, забаррикадировав свою комнату, стража безуспешно пытается вас убедить в том, что толпа не сможет пройти сквозь закрытые стальные ворота. Это продолжается до тех пор, пока вы не проголодаетесь. Люди начинают называть вас трусом*";
    public String d4 = "За вашу помощь церкви мы добавили " + getterANDSetterFile.get_NameBase() + " в список обязательных для паломничества. Встречайте первых гостей!";
    public String d4_c_1 = "*Вы встречаете гостей, позднее они скажут, что хотят работать под вашим началом*";
    public String d4_c_2 = "*Священник странно смотрит на вас и со вздохом уходит. Такой жест он не забудет*";
    public String d5 = "Знаете, за ваши заслуги перед церковью у меня есть для вас подарок: эта старинная статуэтка летающей тарелки, забирающей корову.";
    public String d5_c_1 = "*Священник спешно уходит. Перевернув фигурку, вы замечаете торчащий из неё ключ, который не замечали ранее. * Это ключ от подземелья, - *проносится у вас в голове*";
    public String d5_c_2 = "Действительно, - *говорит священник*, - у вас же даже полок нет. В раздумьях он уходит";
    public String d6 = "Церкви не хватает монет, пожертвуете нам сколько не жалко?";
    public String d6_c_1 = "Маловато…";
    public String d6_c_2 = "Я знал, что на вас можно положиться!";
    public String d6_c_3 = "Не могу принять эти деньги.";
    public String d7 = "Не могли бы вы прийти на церемонию принятия Красного Песка? Я добился того, чтобы его привезли.";
    public String d7_c_1 = "Песок, как песок, просто красный. *Представление вас не впечатлило*";
    public String d7_c_2 = "Но это важно! – *заявил священник, но вы продолжали стоять на своём. Он это запомнит*";
    public String d8 = "Vade diaboli, - *вопит священник, увидевший ваши красные рога*";
    public String d8_c_1 = "*В ужасе священник бежит прочь*";
    public String d8_c_2 = "*Перекрестившись, священник уходит от вас быстрым шагом, то и дело оборачиваясь*";
    public String d9 = "Diabolus negant, et paenitentia, - sacerdos qui loquitur in venas susurri eius.";
    public String d9_c_1 = "Слава богу, - *со вздохом говорит священник. Он простил вам все ваши грехи*";
    public String d10_1 = "Вы читали библию?";
    public String d10_1_c_1 = "О! Тогда процитируйте мне строчку оттуда.";
    public String d10_1_c_2 = "Тогда давайте я вам прочту.";
    public String d10_1_c_3 = "Тогда, как вы… *священник в смятении уходит*";
    public String d10_2_c_1 = "…";
    public String d10_2_c_2 = "Ну что-то вроде…";
    public String d10_2_c_3 = "Этого нет в библии!";
    public String d10_3 = "*Не дожидаясь вашего ответа он начинает читать: о сьцмулкуй пцм фкш щбшотцуу, эвщсюпйэю тжйигщ, 666 ючнтд по «марсианская церковь» года ROT0. Ничего не поняв, вы одобрительно киваете*";

    public void four(){
        vip++;
        //ID2();
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_FOUR theme_four = new THEME_FOUR();
        ra4 = 1 + (int) (Math.random() * 10);
        if (ra4==1 && getterANDSetterFile.get_Church()>0){
            pro_result=41;
            img.setImageResource(R.mipmap.chur);
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d1);
            second.setText("Раз счастливыми, то можно");
            third.setText("Нет, слишком дорого");
            if (button(second)==2){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() - (double)(75 + (getterANDSetterFile.get_House()*75+75)));
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+1);
                getterANDSetterFile.set_House(getterANDSetterFile.get_House()+1);
                start_plus();
            }
            if (button(third)==3){
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-2);
                start_plus();
            }
        }
        else random();
        if (ra4==2 && getterANDSetterFile.get_Church()>0){
            img.setImageResource(R.mipmap.chur);
            pro_result=42;
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d2);
            second.setText("Да, вы правы");
            third.setText("Обойдётся");
            if (button(second)==2){
                description.setText(description.getText().toString() + "\n" +theme_four.d2_c_1);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-400.0);
                start_plus();
            }
            if (button(third)==3){
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
            if (button(first)==1){
                description.setText(description.getText().toString() + "\n" +theme_four.d3_c_1);
                start_plus();
            }
            if (button(second)==2){
                description.setText(description.getText().toString() + "\n" +theme_four.d3_c_2);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+1);
                start_plus();
            }
            if (button(third)==3){
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
            if (button(second)==2){
                description.setText(description.getText().toString() + "\n" +theme_four.d4_c_1);
                getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()+3);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+2);
                start_plus();
            }
            if (button(third)==3){
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
            if (button(second)==2){
                description.setText(description.getText().toString() + "\n" +theme_four.d5_c_1);
                getterANDSetterFile.set_Dungeon(1);
                start_plus();
            }
            if (button(third)==3){
                description.setText(description.getText().toString() + "\n" +theme_four.d5_c_2);
                start_plus();
            }
        }
        else random();
        if (ra4==6){
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d6);
            img.setImageResource(R.mipmap.chur);
            pro_result=46;
            d_input();
            second.setText("Конечно");
            third.setText("Конечно, нет");
            if (button(second)==2){
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
            if (button(third)==3){
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-7);
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
                start_plus();
            }
        }
        if(ra4==7 && getterANDSetterFile.get_Church()>0){
            pro_result=47;
            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_four.d7);
            img.setImageResource(R.mipmap.chur);
            second.setText("Почему нет?");
            third.setText("Нет, у меня есть дела");
            if (button(second)==2){
                description.setText(description.getText().toString() + "\n" +theme_four.d7_c_1);
                start_plus();
            }
            if (button(third)==3){
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
            if (button(second)==2){
                description.setText(description.getText().toString() + "\n" +theme_four.d8_c_1);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-100);
                start_plus();
            }
            if (button(third)==3){
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
            if (button(second)==2){
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-1000);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+250.0);
                start_plus();
            }
            if (button(third)==3){
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
            if (button(first)==1){
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
            if (button(second)==2){
                description.setText(description.getText().toString() + "\n" +theme_four.d10_1_c_2);
                description.setText(description.getText().toString()+"\n"+theme_four.d10_3);
                getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()+2);
                start_plus();
            }
            if (button(third)==3){
                description.setText(description.getText().toString() + "\n" +theme_four.d10_1_c_3);
                start_plus();
            }
        }
        else random();
    }
}