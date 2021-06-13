package com.mygdx.game;

import android.widget.Toast;
import static com.mygdx.game.Quest.vip;
public class THEME_SIX extends Quest{
    public String w1_1 = "Не желаете ли вы сыграть в 21?";
    public String w1_2 = "Желаете поставить монеты или elbrium?";
    public String w1_3 = "Хорошо, делайте свою первоначальную ставку.";
    public String w1_4 = "*Крупье даёт вам 2 карты с числами, на них: ";                          //WARNING
    public String w2_1 = "Хотите ли вы сыграть в кости?";
    public String w2_2 = "Сколько желаете поставить? Учтите максимальная ставка - 10 монет.";

    public void six(){
        vip++;
        ID2();
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
    public void stav(){
        ID2();
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

}
