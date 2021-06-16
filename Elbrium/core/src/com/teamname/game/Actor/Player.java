package com.teamname.game.Actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.util.Timer;
import java.util.TimerTask;

import FirebaseHelper.DatabaseHelper;
//import Online.DatabaseHelper;
import Messages.Message;
import Tools.GetterANDSetterFile;
import Tools.Point2D;

public class Player extends Actor {

    private int Score;
    private float health;
    private float realSpeed=0;
    public float X;
    public float Y;
    public Point2D cameraPoint;

    public float getRealSpeed() {
        return realSpeed;
    }

    public Point2D send_in_ONLINE;
    public boolean isMove;

    private Message player_data;
    public GetterANDSetterFile getter_setter;
    private Timer timer;
    private static final int logOutSec=180;

    public int counter=logOutSec;
    public float damage;





    private DatabaseHelper databaseHelper;

    public Player(Texture img, Point2D position, float Speed, float R, float health) {
        super(img, position, Speed, R);
        this.health=health;
        cameraPoint=new Point2D(position);
        databaseHelper=new DatabaseHelper();

        getter_setter=new GetterANDSetterFile();

        this.health+=getter_setter.get_Health();
        send_in_ONLINE = new Point2D(position.getX()+R,position.getY()+R);
        damage= (float) (getter_setter.get_Attack());
        player_data=new Message(getter_setter.get_Appearance()+"",send_in_ONLINE.getX(),send_in_ONLINE.getY(),
                getter_setter.get_Attack(),getter_setter.get_Health(),
                getter_setter.get_Protection(),getter_setter.get_Nickname());
        databaseHelper.sendToFirebase(getter_setter.get_Nickname(), player_data.toString());

        timeCheck();
    }



    // метод оповещения о движении

    public boolean isMove() {
        return isMove;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(Main.getPlayer(),position.getX()-R*2,position.getY()-R*2,R*2,R*2);
    }

    public void cameraPointUpdate(){
        cameraPoint.setPoint(bounds.pos.getX(),bounds.pos.getY());
        if(bounds.pos.getY()+Main.HEIGHT/2f>Main.BACKGROUND_HEIGHT)cameraPoint.setY(Main.BACKGROUND_HEIGHT-Main.HEIGHT/2f);
        if(bounds.pos.getX()-Main.WIDTH/2f<0)cameraPoint.setX(Main.WIDTH/2f);
        if(bounds.pos.getX()+Main.WIDTH/2f>Main.BACKGROUND_WIDTH)cameraPoint.setX(Main.BACKGROUND_WIDTH-Main.WIDTH/2f);
        if(bounds.pos.getY()-Main.HEIGHT/2f<0)cameraPoint.setY(Main.HEIGHT/2f);
        GameSc.camera.position.set(cameraPoint.getX(),cameraPoint.getY(),0);
    }

    @Override
    public void update() {
        X=direction.getX()*realSpeed;
        Y=direction.getY()*realSpeed;
        position.add(X,Y);
        send_in_ONLINE=position;
        bounds.pos.setPoint(send_in_ONLINE.getX()-R,send_in_ONLINE.getY()-R);
        cameraPointUpdate();
        playerCheck();
        if(isMove){
            counter=logOutSec;
            player_data.x=send_in_ONLINE.getX();
            player_data.y=send_in_ONLINE.getY();
            databaseHelper.sendToFirebase(getter_setter.get_Nickname(),player_data.toString());
            //Gdx.app.log("pos",send_in_ONLINE.getX()+"");
        }

    }

    public float getHealth() {
        return health;
    }

    public void timeCheck(){
        timer=new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if(counter==0){
                    Gdx.app.log("PLayer", "afk for "+logOutSec+" seconds");
                    databaseHelper.logOut();
                    timer.cancel();
                }
                else counter--;
            }
        };
        timer.scheduleAtFixedRate(task,0,1000);
    }

    public Point2D getPosition(){
        return send_in_ONLINE;
    }





    public void playerCheck(){
        // не зашел ли игрок за границу
        if(bounds.pos.getY()+R>Main.BACKGROUND_HEIGHT)send_in_ONLINE.setY(Main.BACKGROUND_HEIGHT);
        if(bounds.pos.getX()-R<0)send_in_ONLINE.setX(2*R);
        if(bounds.pos.getY()-R<0)send_in_ONLINE.setY(2*R);
        if(bounds.pos.getX()+R>Main.BACKGROUND_WIDTH)send_in_ONLINE.setX(Main.BACKGROUND_WIDTH);

    }

    public void setRealSpeed(float realSpeed) {
        this.realSpeed = realSpeed;
    }

    public void changeSpeed(float val){
        realSpeed+=val;
        //Gdx.app.error("REALspeed",realSpeed+"");
    }

    public void changeHealth(float h){
        health+=h;
    }

    public void stopAfkTimer(){
        timer.cancel();
    }


}
