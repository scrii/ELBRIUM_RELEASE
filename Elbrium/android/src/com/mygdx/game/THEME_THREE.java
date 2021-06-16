package com.mygdx.game;

import android.os.CountDownTimer;
import android.view.View;

public class THEME_THREE extends Quest{
    int ra3=0;
    int s3=1;
    CountDownTimer countDownTimer3;
    GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
    public String v1 = "@" + getterANDSetterFile.get_Nickname() + "! Мы узнали, что на месте, где стоит ваша база зарыт клад! Но по нашим данным он находится прямо под местом, где вы сейчас сидите. Если хотите, то мы прямо сейчас начнём здесь копать.";
    public String v1_c_1 = "*На месте, где вы обычно сидите, принимая гостей, кучка грузных, подозрительных людей начинает ломать дорогущий мрамор в поисках клада.";
    public String v1_c_2 = "И они его находят! Бесчисленное количество золото предстаёт перед вами. Однако вам протягивают жалкую горстку монет со словами: нам и самим на что-то жить надо*";
    public String v1_c_3 = "Однако, они ничего не находят. Как и ожидалось. Извиняясь, группа людей уходит, пол, конечно, они чинить не будут. Ваш день испорчен*";
    public String v1_c_4 = "*Пожав плечами, главарь банды уходит со словами: рано или поздно, рано или поздно…*";
    public String v2_1 = "Я слышал, что вы в сотрудничестве с бандой «Копатели жизни» не медленно прекратите! Это безбожно!";
    public String v2_2 = "Это правда? Вы хотите от нас избавиться?";
    public String v2_2_c = "Вы точно передумаете, - доносится до вас";
    public String v2_3 = "Если хотите мы можем сделать так, чтобы этот надоедливый священник навсегда исчез из вашей жизни.";
    public String v3 = "У нас появилась конкурирующая банда и она набирает обороты. Помогите нам разобраться с ней.";
    public String v3_c_1 = "Ваша помощь не возымела эффекта, вместо этого вызвала народные волнения, осуждение со стороны церкви и потерю одного из солдат";
    public String v3_c_2 = "*Цокая, главарь банды уходит*";
    public String v4_1 = "Мы хотим открыть бизнес по продаже табака заграницей, как вы на это смотрите? Вам нужно лишь подписать одну бумажку, мы в долгу не останемся. *главарь банды дрожащими руками протягивает вам потёртую бумагу*";
    public String v4_1_c_1 = "*Не взглянув на содержимое, вы сразу же подписываете. Радостный главарь выхватывает бумагу из ваших рук, боясь, что вы передумаете. Позднее вы узнаёте, что разрешили банде бесплатно пить в любом баре своей базы. Приходится покрывать расходы из своего кармана и признавать бумагу не действительной. Вы теряете 150 монет*";
    public String v4_1_c_2 = "*Раздосадованный главарь уходит*";
    public String v4_2 = "*Пока вы читаете бумагу, ваши глаза расширяются от удивления и внутри вас возрастает гнев. В бумаге пишется, что вы разрешаете банде пить в любом подвластном вам баре, да ещё и за ваш счёт. Это не то, чем кажется, - мямлит главарь, опустив голову. Вы рвёте бумагу и зовёте стражу, пока та идёт, от бандита и след простыл*";
    public String v5 = "Мне кажется, что вашим владениям не хватает бандитского района? Что скажите? Нужно всего лишь 400 монет и к завтрашнему утру он будет готов.";
    public String v5_c_1 = "*Радостный главарь уходит. К утру вы узнаёте, что один из самых богатых районов был превращён в трущобы. Люди недовольны, и чтобы вернуть всё как было требуется ещё столько же, но осадочек всё равно остается. Вы без раздумий отдаёте деньги, но это не слишком спасает положение*";
    public String v5_c_2 = "*Говорите вы, наблюдая, как уходит опечаленный вашим решением главарь*";
    public String v6 = "Вот ваша доля за этот месяц. *главарь протягивает вам мешочек, звенящий от монет внутри*";
    public String v6_c_1 = "*Вероятно, приняв это решение вы думаете, что о взятке никто не узнает, но вы ошиблись. Об этом узнали всё*";
    public String v6_c_2 = "*Вы не берёте коррупционные деньги, считая себя героем, но о вашем поступке никто не узнаёт*";
    public String v7 = "Наш новый бизнес – продажа баз. Поддержите нас, в долгу не останемся.";
    public String v7_c_1 = "Всего ничего, - *отвечает главарь*, - ваша база. *Услышав это вы расхохотались и, безудержно смеясь, выгнали бандита*";
    public String v7_c_2 = "Как кто, - *удивился главарь*, - Вы. *Услышав это, вы кинули в того бокалом, из которого пили. Бандит обиженно ушёл*";
    public String v7_c_3 = "Вы не понимаете, что теряете! – *завопил главарь*, - тогда я разбогатею в одиночку и с вами делиться не стану!";

    public void three(){
        vip++;
        //ID2();
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_THREE theme_three = new THEME_THREE();
        ra3 = 1;
        countDownTimer3 = new CountDownTimer(s3*1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                s3--;
                if (ra3==1){
                    img.setImageResource(R.mipmap.bandit);
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v1);
                    second.setText("Согласиться");
                    third.setText("Отказаться");
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            double ran = 1 + (double) (Math.random() * 10);
                            if (ran<2.25){
                                description.setText(description.getText().toString() + "\n" +theme_three.v1_c_1 + " " + theme_three.v1_c_2);
                                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money() + 25.0);
                                ra3++;
                                start_plus();
                            }
                            else{
                                description.setText(description.getText().toString() + "\n" +theme_three.v1_c_1 + " " + theme_three.v1_c_3);
                                ra3++;
                                start_plus();
                            }
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v1_c_4);
                            ra3++;
                            start_plus();
                        }
                    });
                }
                if (ra3==2){
                    pro_result=32;
                    img.setImageResource(R.mipmap.chur);
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v2_1);
                    second.setText("Согласиться со священником");
                    third.setText("Отказаться");
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v2_2);
                            second.setText("Да, не желаю вас больше видеть");
                            third.setText("Это ложь");
                            second.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    description.setText(description.getText().toString() + "\n" +theme_three.v2_2_c);
                                    getterANDSetterFile.set_Band(0);
                                    ra3++;
                                    start_plus();
                                }
                            });
                            third.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    getterANDSetterFile.set_Church(-3);
                                    ra3++;
                                    start_plus();
                                }
                            });
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            img.setImageResource(R.mipmap.bandit);
                            npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v2_3);
                            second.setText("Согласиться");
                            third.setText("Не стоит");
                            second.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    getterANDSetterFile.set_Church(-1000);
                                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-15);
                                    ra3++;
                                    start_plus();
                                }
                            });
                            third.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    ra3++;
                                    start_plus();
                                }
                            });
                        }
                    });
                }
                if (ra3==3 && getterANDSetterFile.get_Villagers()>=1 && getterANDSetterFile.get_Church()!=0){
                    img.setImageResource(R.mipmap.bandit);
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v3);
                    second.setText("Помочь");
                    third.setText("Конкуренция – это хорошо");
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v3_c_1);
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
                            getterANDSetterFile.set_Church(getterANDSetterFile.get_Church()-3);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-25.0);
                            getterANDSetterFile.set_Villagers(getterANDSetterFile.get_Villagers()-1);
                            ra3++;
                            start_plus();
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v3_c_2);
                            ra3++;
                            start_plus();
                        }
                    });
                }
                else random();
                if (ra3==4){
                    img.setImageResource(R.mipmap.bandit);
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v4_1);
                    d_button();
                    first.setText("Подписать");
                    second.setText("Прочитать");
                    third.setText("Разорвать");
                    first.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v4_1_c_1);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-150.0);
                            ra3++;
                            start_plus();
                        }
                    });
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v4_2);
                            ra3++;
                            start_plus();
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v4_1_c_2);
                            ra3++;
                            start_plus();
                        }
                    });
                }
                if (ra3==5){
                    img.setImageResource(R.mipmap.bandit);
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v5);
                    second.setText("Дать 200 монет");
                    third.setText("Бредовая идея");
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v5_c_1);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-400.0);
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                            ra3++;
                            start_plus();
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v5_c_2);
                            ra3++;
                            start_plus();
                        }
                    });
                }
                if (ra3==6){
                    img.setImageResource(R.mipmap.bandit);
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v6);
                    second.setText("Взять");
                    third.setText("Отказаться");
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v6_c_1);
                            getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                            getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+100.0);
                            ra3++;
                            start_plus();
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v6_c_2);
                            ra3++;
                            start_plus();
                        }
                    });
                }
                if (ra3==7){
                    d_button();
                    img.setImageResource(R.mipmap.bandit);
                    npc_tv.setText(npc_tv.getText().toString() + "\n" + theme_three.v7);
                    first.setText("И сколько вам нужно?");
                    second.setText("И кто тот несчастный, чью базу вы хотите продать?");
                    third.setText("Ну уж нет, звучит глупо");
                    first.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v7_c_1);
                            THEME_FOUR theme_four = new THEME_FOUR();
                            theme_four.four();
                            start_plus();
                        }
                    });
                    second.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v7_c_2);
                            THEME_FOUR theme_four = new THEME_FOUR();
                            theme_four.four();
                            start_plus();
                        }
                    });
                    third.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            description.setText(description.getText().toString() + "\n" +theme_three.v7_c_3);
                            THEME_FOUR theme_four = new THEME_FOUR();
                            theme_four.four();
                            start_plus();
                        }
                    });
                }
            }
            @Override
            public void onFinish() {
                if (countDownTimer3 != null) {
                    s3 = 1;
                    countDownTimer3.start();
                }
            }
        };
        if (countDownTimer3 != null) {
            s3 = 1;
            countDownTimer3.start();
        }
    }
}
