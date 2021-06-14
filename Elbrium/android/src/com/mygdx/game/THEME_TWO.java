package com.mygdx.game;

import android.widget.Toast;

public class THEME_TWO extends Quest{
    public String m1 = "Меня ограбили! Сделайте же что-нибудь!";
    public String m1_c_1 = "*Стража не находит следов ограбления*";
    public String m1_c_2 = "Не знаю, но это точно произошло!";
    public String m2 = "Банк! Людям нужен банк! Можете ли вы выделить мне деньги на его постройку?";
    public String m2_c = "Кажется, он скрылся с деньгами и не будет ничего делать";
    public String m3 = "Банковское дело! Вот, что я хочу построить, на ваши деньги, конечно же, но поверьте мне: я в долгу не останусь.";
    public String m3_c = "Следующей ночью кто-то оставляет у вас под дверью чемодан с деньгами";
    public String m4 = "Здравствуйте, я занимаюсь продажей матрасов, не желаете ли приобрести 1? Это будет стоить 1000 монет, но уверяю вы не пожалеете.";
    public String m4_c_1 = "Внутри оказалось 200 монет";
    public String m4_c_2 = "Сколько бы вы не рвали матрас, но кажется, внутрь ничего не положили…";
    public String m5 = "Здравствуйте, буду честен я – вожак банды у меня к вам дело. Не желаете ли вы заняться продажей матрасов? Не лично вы, конечно, просто выделите нам точку в центре, в долгу не останемся.";
    public String m5_c = "Пока вы задавались этим не хитрым вопросом от говорящего уже след простыл";
    public String m6 = "На нас летит большой метеорит! Сделайте же что-нибудь или кто-то точно умрёт!";
    public String m7 = "Срочно! Мне нужны деньги! Позже объясню зачем.";
    public String m7_c_1 = "Вы просто не знаете, что теряете!";
    public String m7_c_2 = "Я хотел купить жвачку, спасибо вам.";
    public String m7_c_3 = "Так хотелось выпить, спасибо!";
    public String m7_c_4 = "Да за такую сумму я, наконец, оплачу задолженность по квартплате, спасибо вам большое!";
    public String m7_c_5 = "Я не могу взять так много, простите…";
    public String m7_c_6 = "Diabolus responderit quo vocas.";
    public String m8 = "Мне кажется, нашу казну грабят!";
    public String m8_c_1 = "*Казну не грабят, однако, когда вы вошли внутрь тяжелая дверь с грохотом закрылась. Кто-то решил подшутить над вами, но он не учёл, что вам было не до смеха, выйдя через 3 часа, вы выгнали этого шутника со своей базы*";
    public String m8_c_2 = "*Оказывается вас действительно грабили, вы теряете 50 монет*";
    public String m9 = "Не желаете ли купить этот портрет? *Портрет выглядел не законченным, однако глаза на нём выглядели как-то особенно пугающе*";
    public String m9_c_1 = "*Ночью вам снится кошмар, человек из портрета, выходя из рамы, подходит к вам и начинает душить. Однако, проснувшись, вы замечаете, как из картины падает свёрток монет, пересчитав их, вы понимаете, что их ровно 100, но выглядят они не как обычные, успокоив себя, вы прячете их и возвращаетесь в ратушу*";
    public String m9_c_2 = "Ладно, продам её какому-нибудь бедному художнику";
    public String m10 = "Алчность.";
    public String m10_c_1 = "*Вы чувствуйте лёгкий холодок, так будто бы в комнате с вами находится кто-то ещё*";
    public String m10_c_2 = "Ложь, – доносится до вас";

    public void two(){
        vip++;
        //ID2();
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_TWO theme_two = new THEME_TWO();
        ra2 = 1 + (int) (Math.random() * 10);
        if (ra2==1){
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
        if (ra2==2){
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
        if (ra2==3){
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
        if (ra2==4 && getterANDSetterFile.get_Band()==1){
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
        if (ra2==6 && getterANDSetterFile.get_Villagers()>0){
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
        if (ra2==7){
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
        if (ra2==8 && getterANDSetterFile.get_Villagers()>0){
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
        if (ra2==9){
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
        if (ra2==10){
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
}