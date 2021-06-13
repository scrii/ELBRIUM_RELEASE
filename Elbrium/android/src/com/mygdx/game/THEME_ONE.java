package com.mygdx.game;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import static com.mygdx.game.Quest.vip;

public class THEME_ONE extends Quest {
    GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
    public String q1 = "Люди недовольны большим количеством предприятий, загрязняющих атмосферу. Не могли бы вы провести референдум?";
    public String q2 = "*Вы узнаёте, что на вашей базе появилась оппозиционная организация, желающая дискредитировать вас. Ваши действия: *";
    public String q3 = "Наши амбары с запасами зерна сгорели, пожалуйста, выделите нам (от 50 до 300 монет), чтобы мы могли пережить зиму. ";
    public String q4_1 = "На нашей базе появилась банда преступников!";
    public String q4_12_c = "Благодарим вас, мы это не забудем.";
    public String q4_2 = "Я - главарь банды, прошу не уничтожайте нас, мы заплатим за собственное спасение.";
    public String q5_1 = "@" + getterANDSetterFile.get_Nickname() + ",не могли бы вы посмотреть на ангар, который мы отремонтировали?";
    public String q5_2 = "*Заходя внутрь, вы замечаете, как какой-то мальчишка в ангаре по неосторожности роняет коробку с инструментами. Вы подзываете его к себе: *";
    public String q5_3 = "Не ругайте его, он мой сын!";
    public String q6 = "К нам в город прибыл священник из Марсианской церкви!";
    public String q6_c = "Церковь этого не забудет.";
    public String q7 = "Жители изголодались по зрелищу! Давайте проведём цирковое выступление.";
    public String q8 = "Школ! Детям не хватает школ!";
    public String q8_c = "Ну ладно…";
    public String q9 = "Нам негде гулять! Постройте больше парков!";
    public String q9_c = "Извините, ошибся… ";
    public String q10_1 = "Спеть вам песенку?";
    public String q10_2 = "«Жил-был в древности космический король" + "\n" + "Жил-был, как вдруг появился дракон…» *вы жестом останавливаете его и говорите: *";

    public void one(){
        vip++;
        ID2();
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

