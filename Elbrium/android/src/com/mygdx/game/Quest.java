package com.mygdx.game;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.Toolbar;

import com.teamname.game.Main;

public class Quest extends AppCompatActivity {
    int kolvo_symbols = 0,k1,k2,m=0,ra1;
    public boolean parametr=true;
    public int pro_result=0;
    TextView npc_tv,description;
    String res="";
    Button btn_next,btn_exit,first,second,third;
    EditText input;
    ImageView img;
    @Override
    protected void onPause(){
        exit(false);
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        if(!parametr){
            if(pro_result==1)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
            if(pro_result==2)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
            if(pro_result==3)getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);

        }
        super.onPause();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);
        getSupportActionBar().hide();
        start();
        exit(true);
        THEME_ONE theme_one = new THEME_ONE();
        THEME_TWO theme_two = new THEME_TWO();
        THEME_THREE theme_three = new THEME_THREE(); //band
        THEME_FOUR theme_four = new THEME_FOUR(); //church
        THEME_FIVE theme_five = new THEME_FIVE(); //devil
        THEME_SIX theme_six = new THEME_SIX();
        THEME_SEVEN theme_seven = new THEME_SEVEN(); //dungeon
        THEME_EIGHT theme_eight = new THEME_EIGHT();
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
    public void one(){
        ID();
        o_button();
        o_input();
        start();
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        THEME_ONE theme_one = new THEME_ONE();
        ra1 = 1 + (int) (Math.random() * 10);
        if(ra1==1 && getterANDSetterFile.get_Guardian_Money()>=50){
            pro_result=1;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(theme_one.q1);
            second.setText("Да");
            third.setText("Нет");
            if(button(second)=="Да"){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-50.0);
                start_plus();
            }
            if(button(third)=="Нет"){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
                start_plus();
            }
            exit(true);
        }
        else random();
        if(ra1==2 && getterANDSetterFile.get_Guardian_Money()>=100.0){
            pro_result=2;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(theme_one.q2);
            second.setText("Оставить всё как есть");
            third.setText("Уничтожить");
            if(button(second)=="Оставить всё как есть"){
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-100.0);
                start_plus();
            }
            if(button(third)=="Уничтожить"){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                start_plus();
            }
            exit(true);
        }
        else random();
        if(ra1==3){
            pro_result=3;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(theme_one.q3);
            second.setText("Выдать");
            third.setText("Отказать");
            d_input();
            if(button(second)=="Выдать"){
                if(Integer.parseInt(input.getText().toString())<50 || Integer.parseInt(input.getText().toString())>300)npc_tv.setText("Но я не просил столько!");
                if(Integer.parseInt(input.getText().toString())>50 || Integer.parseInt(input.getText().toString())<300){
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+1);
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()-Integer.parseInt(input.getText().toString()));
                    start_plus();
                }
            }
            if(button(third)=="Отказать"){
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-3);
                start_plus();
            }
            exit(true);
        }
        if(ra1==4 && getterANDSetterFile.get_Band()!=1){
            pro_result=4;
            img.setImageResource(R.mipmap.base_avatar_1);
            npc_tv.setText(theme_one.q4_1);
            second.setText("Уничтожить");
            third.setText("Оставить");
            if(button(second)=="Уничтожить"){
                img.setImageResource(R.mipmap.bandit);
                npc_tv.setText(theme_one.q4_2);
                second.setText("Оставить");
                third.setText("Убирайтесь");
                if(button(second)=="Оставить"){
                    int a = 1 + (int) (Math.random() * 100);
                    getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+((double)a));
                    description.setText(theme_one.q4_12_c);
                    getterANDSetterFile.set_Band(1);
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
                }
                if(button(third)=="Убирайтесь"){
                    getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()+3);
                }
            }
            if(button(third)=="Оставить"){
                int a = 1 + (int) (Math.random() * 100);
                getterANDSetterFile.set_Guardian_Money(getterANDSetterFile.get_Guardian_Money()+((double)a));
                description.setText(theme_one.q4_12_c);
                getterANDSetterFile.set_Band(1);
                getterANDSetterFile.set_Happiness(getterANDSetterFile.get_Happiness()-7);
            }
        }
        else random();
        if(ra1==5 && getterANDSetterFile.get_Guardian_Money()>=5){

        }
        else random();
    }
    public void two(){
        ID();
        o_button();
        o_input();
    }
    public void three(){
        ID();
        o_button();
        o_input();
    }
    public void four(){
        ID();
        o_button();
        o_input();
    }
    public void five(){
        ID();
        o_button();
        o_input();
    }
    public void six(){
        ID();
        o_button();
        o_input();
    }
    public void seven(){
        ID();
        o_button();
        o_input();
    }
    public void eight(){
        ID();
        o_button();
        o_input();
    }
    public void exit(boolean tf){
        parametr = tf;
    }

    private void ID(){
        npc_tv = findViewById(R.id.nps_tv);
        description = findViewById(R.id.description);
        btn_next = findViewById(R.id.btn_next);
        btn_exit = findViewById(R.id.btn_exit);
        first = findViewById(R.id.first);
        second = findViewById(R.id.second);
        third = findViewById(R.id.third);
        input = findViewById(R.id.input);
        img = findViewById(R.id.nps_img);
    }
    public void random(){
        GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
        m = 1 + (int) (Math.random() * 8);
        if(m==1)one();
        if(m==2)two();
        if(m==3 && getterANDSetterFile.get_Band()==1)three();
        else random();
        if(m==4 && getterANDSetterFile.get_Church()!=0)four();
        else random();
        if(m==5 && getterANDSetterFile.get_Devil()!=0)five();
        else random();
        if(m==6)six();
        if(m==7 && getterANDSetterFile.get_Dungeon()==1)seven();
        else random();
        if(m==8)eight();
    }
    public void start(){
        ID();
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
        npc_tv.setVisibility(View.VISIBLE);
        description.setVisibility(View.VISIBLE);
        first.setVisibility(View.VISIBLE);
        second.setVisibility(View.VISIBLE);
        third.setVisibility(View.VISIBLE);
        input.setVisibility(View.VISIBLE);
        img.setVisibility(View.VISIBLE);
        btn_next.setVisibility(View.VISIBLE);
        btn_exit.setVisibility(View.VISIBLE);
    }
    public void hide(){
        ID();
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
        ID();
        first.setVisibility(View.VISIBLE);
    }
    public void d_input(){
        ID();
        input.setVisibility(View.VISIBLE);
    }
    public void o_button(){
        ID();
        first.setVisibility(View.INVISIBLE);
    }
    public void o_input(){
        ID();
        input.setVisibility(View.INVISIBLE);
    }
    public String button(Button b){
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                res = b.getText().toString();
            }
        });
        return res;
    }
    public void comments(String s, TextView textMessage){
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
class THEME_ONE{
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
}
class THEME_TWO{
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
}
class THEME_THREE{
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
}
class THEME_FOUR{
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
}
class THEME_FIVE{
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
}
class THEME_SIX{
    public String w1_1 = "Не желаете ли вы сыграть в 21?";
    public String w1_2 = "Желаете поставить монеты или elbrium?";
    public String w1_3 = "Хорошо, делайте свою первоначальную ставку.";
    public String w1_4 = "*Крупье даёт вам 2 карты с числами, на них" + ".";                      //WARNING
    public String w1_5_c_1 = "Ваш выигрыш: составляет";                                           //WARNING
    public String w1_5_c_2 = "Желаете ещё?";
    public String w2_1 = "Хотите ли вы сыграть в кости?";
    public String w2_2 = "Сколько желаете поставить? Учтите максимальная ставка - 10 монет.";
    public String w2_3_c = "Желаете продолжить?";
}
class THEME_SEVEN{
    GetterANDSetterFile getterANDSetterFile = new GetterANDSetterFile();
    public String s1 = "*В один из дней вы вспоминаете про ключ, который был передан священником. Покопавшись в груде вещей, вы находите заветную вещь и радостный спускаетесь по ступенькам вниз, веля охране не следовать за собой. Через некоторое время, спускаясь всё глубже и глубже, вы натыкаетесь на старую дубовую дверь, в руках у вас лежит ключ от неё, а в голове мысль: открыть или всё же…*";
    public String s1_c = "*Или всё же… уйти? Именно это решение приходит вам в голову и недолго думая, вы, развернувшись на каблуках уходите обратно в свою комнату, а через время снова забываете про ключ*";
    public String s2 = "*Нет. Только вперёд, раз выдалась такая возможность. Открыв ключом скрипучую дверь, вы входите внутрь, за вами тут же захлопывается дверь. Как и ожидалось внутри было темно, хоть глаз выколи. Вернувшись обратно, вы захватили с собой подожжённый факел и начали спуск вниз. По мере продвижения воздух становился всё тяжелее и тяжелее, а лестница вниз, казалось, не имела ни начала, ни конца. В конце концов вы начали слышать какой-то приглушённый шум* ";
    public String s3 = "*Прислушавшись, вы вдруг различили чьи-то голоса. Они говорили о вас, за вашей спиной. Удивившись подобной наглости и предвкушая, как они будут оправдываться, увидев вас, вы ускорили шаг и напряглись так, чтобы услышать что-то большее, чем просто своё имя. Наконец, чужие голоса стали хоть сколько-нибудь различимыми, вот, что они говорили: Правление " + getterANDSetterFile.get_Nickname() + " очень скоро закончится. Другой голос той же тональности вторил: Да, это абсолютная правда, но что же нам сделать, чтобы ускорить этот процесс? Первый ответил: Давай просто убьём " + getterANDSetterFile.get_Nickname() + " никто нам и слова не скажет, все наоборот будут нам благодарны…*";
    public String s4 = "*Чтобы кто не говорил, но вам было всё равно, наверное, поэтому через некоторое время голоса стихли, как будто-то бы их никогда и не было. Внезапно вы услышали запах мертвеца, да до такой степени, словно он находился прямо перед вашими ногами. Остановившись, как вкопанный вы решили: * ";
    public String s5 = "*Услышав столь неприемлемые слова вы ускорили шаг, желая наказать мерзавцев, однако споткнувшись упали. Голоса тут же стихли. Тот час же прямо за поворотом громко и чётко послышалось: кто здесь? Немедленно представься или мы убьем тебя!* ";
    public String s6 = "*Подумав, что это вероятно какая-нибудь крыса вы продолжили спуск вниз. Однако, запах продолжал преследовать вас, усиливаясь и набирая обороты, такие, что вы уже не могли дышать. Задыхаясь, вы решили: * ";
    public String s7 = "*Отчаянно, но благородно, вы решил подняться наверх и вызвать стражу. Странным образом поднявшись на два пролета вверх вы оказались перед дверью. Открыв её, вы столкнулись со стражником, который хотел открыть эту дверь. Вы с яростью посмотрели на него и начали кричать, звать остальных. Когда пришли другие стражники, вы объяснили им ситуацию, те пришли в недоумение. Один из них сказал: но там всего лишь склад с продуктами, если вы там видели кого-то значит сейчас мы застанем их врасплох. Остальные согласились и открыв дверь, стали спускаться вниз, вы за ними. Однако через 3 пролёта все оказались в погребе с бесчисленном количеством вина, хлеба и прочих продуктов, присутствием кого-то ещё даже не пахло. Обыскав весь погреб, вы ничего не нашли и раздосадованный вернулись к себе*";
    public String s8 = "*В вашу голову не пришло ничего лучше, кроме как спросить: здесь, что кто-то умер? Ваш глупый вопрос оглушительно, отражаясь от бесчисленного количества стен, пронзил тишину. Внезапно, перед вами появился живой труп. Его куски плоти и мяса свисали с тела, глаз не было, а рот был открыт. Да, это я умер, - ответил мертвец, и видя ваш ужас на лице продолжил, - давным-давно мне дали ключ от склада продуктов, недолго думая я стал спускаться вниз, желая хорошенько подкрепиться, желание моё было настолько велико, что меня не остановил бесконечный спуск вниз и в конце концов я свалился без сил и умер. Мне кажется, что прошло достаточно много времени с того момента, как я спустился, как вы считаете? Какой сейчас год? * ";
    public String s8_c = "*Мертвец кричал вам, что не стоит этого делать, но вы его не слушали…*";
    public String s9 = "Я – " + getterANDSetterFile.get_Nickname() + ", а кто вы? – *спрашиваете вы, в надежде, что вас сейчас же не убьют. На ваше несчастье, заговорщики переглянулись и достали кинжалы из-за пазухи. Ситуация принимала отчаянный оборот, в попытке защититься вы достали ключ от двери наверху и на удивление это сработало. Убийцы отступили и пошептавшись предложили: вы нам ключ, мы вам – жизнь*";
    public String s10 = "*Решив, что игра не стоит свеч, вы, развернувшись ушли, поднявшись через 3 пролёта к двери. Открыв её, вы забыли ключ в скважине и, поднявшись к себе, через некоторое время забыли про подземелье*";
    public String s11 = "Я – священник Марсианской Церкви, - *соврали вы. Перед вами появились двое заговорщиков, на ваше удивление они не узнали вас, видимо свет факела мешал им это сделать. Святой отец, - сказал один из них. – Мы хотим сделать одно дело, но для этого нам нужно подняться наверх, благословите наш подъём*. ";
    public String s12 = "*Решив, что лучшим решением будет продолжить путь, вы начали спускаться всё ниже и ниже, однако как бы вы не старались, но достигнуть заветного низа у вас не получалось. Пройдя бесчисленное количество поворотов, ваш факел начал мигать и в конце концов потух. Испугавшись, вы решили: *";
    public String s13 = "Я – главарь банды, - *уверенно сказали вы. Говорившие поднялись и недоумённо посмотрели на вас и спросили: И как в таком случае вас зовут? А, ведь действительно, как зовут главаря банды? Подумав некоторое время, вы ответили: * ";
    public String s14 = "*Запах оказался настолько не выносимым, что вы повернули назад, в надежде, что он прекратится. Так и произошло, через 4 поворота вы оказались у двери и недолго думая открыли её, потеряв ключ где-то по пути. Вернувшись в комнату, вы забыли, что были в подземелье*";
    public String s15 = "*С перепугу вы отдали им ключ, однако, вместо того чтобы сдержать слово и сохранить вам жизнь, убийцы пошли на вас, тыкая кинжалами воздух. На ваше счастье тот, кто принял из ваших рук ключ, внезапно вскрикнул повалившись на ступени, его сообщник обернулся назад и это дало вам шанс: * ";
    public String s16 = "2021? Я спустился в 1041 году. Как же много времени прошло! Давайте же подниматься наверх, я уверен, что с вами у меня получиться! *То ли от омерзения, то ли ещё из-за чего, но вы вместе со своим спутником стали подниматься наверх. Однако мертвец постоянно отставал от вас, складывалось ощущение, что он просто не мог выбраться отсюда. В какой-то момент вы не заметили, как мертвец куда-то пропал и очутились перед дверью. Выждав некоторое время, вы, утомившись, открыли дверь и, оставив ключ в замочной скважине, пошли в столовую есть, по пути забыв про подземелье*";
    public String s17 = "*Испугавшись, вы бросились наверх и через 3 поворота оказались у двери, в ужасе, открыв её вы выбежали в коридор, а после поднялись к себе. И уже в своей комнате, переведя дух, не могли вспомнить чего боялись и почему бежали*";
    public String s18 = "*Ваша упорность не знала границ. Вы продолжали и продолжали спуск. Уже не было ни запахов, ни звуков, ничего. Разве, что громкий стук вашего сердца, как будто отражавшийся от стен. Много прошло времени или мало вы не знали, потому что продолжали спуск, несмотря ни на что, и в конце концов перед вами появилась дверь, безумно напоминающая ту, в которую вы когда-то вошли. Недолго думая, вы открываете дверь и выходите, оставляя ключ в замочной скважине, недоумевая вы разглядываете свои владения и приглядываетесь забываете про подземелье и возвращаетесь к себе *";
    public String s19 = "*Вы начали мямлить какое-то благословление сами не понимая, что говорите, за время, пока вы это делаете убийцы разглядывают вас с головы до ног и в какой-то момент прерывают вас: если ты монах, то, где твоя одежда? Где колпак? Да ты посмотри, у него же ключ! – говорит другой. Отдавай-ка нам ключ. Убийцы достали из-за пазухи кинжалы и пошли на вас*. ";
    public String s20 = "*Даже в полной темноте лучшим решением будет всё равно спускаться дальше. Итак, пройдя бесчисленное расстояние вниз, вы вдруг замечаете какой-то свет. Идя на него, вы натыкаетесь на полки, набитые вином, хлебом и прочей едой. Люди там недоумённо смотрят на вас. Быстро вскочив, вы всматриваетесь внимательней и замечаете, что оказались в собственной кладовой. Извинившись, вы бодро поднимаетесь наверх, но где-то по пути теряете ключ, и вскоре оказываетесь перед дверью, открыв её, вы забываете про подземелье*";
    public String s21 = "*С детства вы были не из робкого десятка, поэтому решили проклясть убийц, говоря всяческие проклятия вы замечаете, как те достают кинжалы из-за пазухи. В ужасе вы прекращаете говорить и, не дав ничего сказать им, бежите наверх, к двери. Молниеносно открыв её, вы тут же захлопываете за собой, а ключ валится из ваших рук. Через мгновение вы забываете про подземелье и со спокойной душой возвращаетесь к себе. *";
    public String s22 = "*Правильным решением, конечно же, будет вернуться назад. Повернув, вы тут же бьётесь головой о нужную вам дверь, в судороге, открыв её, вы не замечаете, как роняете ключ на каменные ступеньки, даже характерный звук не смог сбить вас с этого нехитрого дела, как открытие двери, всё-таки страх темноты берёт над вами вверх. *";
    public String s23 = getterANDSetterFile.get_Nickname() + ", - *не думая отвечаете вы. Убийцы переглянулись и рассмеялись. Конечно, его не так звали. Что за глупость? С чего вы вообще взяли, что его будут звать так же, как и вас? Может кто-то подсказал вам подобную глупость? Или вы сами приняли столь, поистине, странное решение? Как бы то ни было, пока рассказчик недоумевал с вашего решения выбрать именно этот ответ, убийцы, которые также не понимали почему вы выбрали столь неадекватное решение, достали кинжалы и пошли на вас. Естественно вы, сгорая от стыда, что выбрали именно этот ответ, побежали прочь и вскоре наткнулись на дверь, открыв которую вы оставили ключ в замочной скважине и пройдя дальше забыли про подземелье, перед этим запомнив, что не стоит выбирать решения ответы которых известны *";
    public String s25 = "*Недолго думая, вы ответили аббревиатурой: Г.Б.. И этот ответ оказался правдой. Убийцы извинились, что не признали вас раньше и расступились, давая вам пройти. И вы приняли решение: * ";
    public String s25_c = "*Раз уж ниже убийцы и головорезы лучше будет вернуться назад, с этими мыслями вы побежали назад, но где-то по пути обронили ключ, не заметив этого, вскоре перед вами предстала дверь. Вы открыли её и пройдя дальше забыли про подземелье*";
    public String s27 = "*Не зря знаменитая поговорка гласит: Если враг повернулся спиной – бей первым. Или она несколько по-другому звучала… Как бы то ни было, вы толкнули убийцу вниз, от чего тот полетел кубарём вниз, испугавшись, что тот быстро вскочит и ненароком убьёт вас, вы в ужасе побежали наверх и, вскоре, очутились перед дверью. Открыв её и вернувшись к себе, вы забыли про подземелья *";
}
class THEME_EIGHT{
    public String e1 = "К нам прилетели пришельцы!";
    public String e1_c_1 = "*Вы бежите смотреть «пришельцев», но это оказываются обычные грузчики с другой планеты. Вы здороваетесь с ними и делаете вид, что шли не к ним. Сделав большой крюк, вы вернулись*";
    public String e1_c_2 = "Да, что я пришельцев не видел? – *говорите вы уверенно. А ведь и правда не видел, - думаете вы*";
    public String e2 = "Мы бы хотели получить разрешение на организацию бала.";
    public String e3 = "Здравствуйте, МАиЖ (министерство архитектуры и живописи) хотело бы сделать оранжерею на вашей базе. Что скажите?";
    public String e4 = "Здравствуйте, МАиЖ-у не нравится, как выглядят коридоры. Хотите, чтобы мы их улучшили?";
}