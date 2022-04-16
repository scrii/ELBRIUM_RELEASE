package com.teamname.game.Actor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.lang.reflect.Array;

import Buffs.Buff;
import Tools.BulletGenerator;
import Tools.Circle;
import Tools.Point2D;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class Enemy extends Actor {
    private Point2D playerPos;
    public int damage;

    public int getHealth() {
        return health;
    }

    public boolean isSeeingPlayer;
    public boolean isSeeingBuff;
    public boolean isGoingToBuff;
    public boolean isBuffNearerThanPlayer;

    public BulletGenerator bullgen;
    private int health;
    private boolean stayingOnCircle;

    @Override
    public void collision(Actor other, float offset) {
        super.collision(other, offset);
        Tools.Circle dCircle = new Circle(other.bounds);
        dCircle.addR(offset);
        stayingOnCircle= bounds.Overlaps(dCircle) && other.direction.getY() == 0 && other.direction.getX() == 0;
    }

    public Point2D playerDirection;

    public Enemy(Texture img, Point2D position, float speed, float R, int damage, int health) {
        super(img, position, speed, R);
        this.damage = damage;
        bullgen = new BulletGenerator(3);
        this.health=health;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, position.getX()-R,position.getY()-R,R*2,R*2);
        bounds.debug(batch);
        position.debug(batch);
    }

    @Override
    public void update() {
        playerPos = GameSc.player.send_in_ONLINE;

        /*
        float dX = playerPos.getX() - position.getX() - GameSc.player.R;
        float dY = playerPos.getY() - position.getY() - GameSc.player.R;
        float length = (float)Math.sqrt(dX* dX + dY*dY);
        direction = new Point2D(dX / length, dY / length);*/

        /*
        if(!circleBounds.isContains(stickBounds.pos)){
            stickBounds.pos.setX(-rcircle/ length * dx +circleBounds.pos.getX());
            stickBounds.pos.setY(-rcircle/ length * dy +circleBounds.pos.getY());
        */



        //collision(GameSc.player, 0);
        float dX = GameSc.player.position.getX() - position.getX() - GameSc.player.R;
        float dY = GameSc.player.position.getY() - position.getY() - GameSc.player.R;
        float length = (float)Math.sqrt(dX* dX + dY*dY);
        playerDirection = new Point2D(dX / length, dY / length);

        //position.add(direction.getX()*speed,direction.getY()*speed);
        bounds.pos.setPoint(position.getX(),position.getY());

        float cX = playerPos.getX();
        float cY = playerPos.getY();

        isSeeingPlayer = ((position.getX() > cX - Main.WIDTH/2f && position.getX() < cX + Main.WIDTH/2f)
                && (position.getY() > cY - Main.HEIGHT/2f && position.getY() < cY + Main.HEIGHT/2f));

        float dx=0, dy=0, lengthToBuff = -1;

        for(Buff buff : GameSc.buffs){
            dx = buff.position.getX() - position.getX();
            dy = buff.position.getY() - position.getY();
            lengthToBuff = (float)Math.sqrt(dx*dx+dy*dy);

            isSeeingBuff = dx < Main.WIDTH / 2f && dy < Main.HEIGHT;
            isBuffNearerThanPlayer = lengthToBuff < length;
            if(isSeeingBuff)break;


        }

        countDirection(dx, dy, lengthToBuff);
        position.add(direction.getX()*speed,direction.getY()*speed);
        //Gdx.app.log("isSeeingPlayer", isSeeingPlayer+"");

       // for(Enemy enemy : GameSc.enemies){
           // if(enemy!=this)collision(enemy,-enemy.R+R);
        //}
        Gdx.app.log("enemy",direction.getX()+" "+direction.getY());

    }

    public void damaged(Bullet b){
        health-=b.damage;

        if(health<=0)GameSc.enemies.removeValue(this, true);
        GameSc.bullets.removeValue(b,true);
    }

    public void countDirection(float dx, float dy, float lengthToBuff){
        if((isSeeingBuff && !isGoingToBuff && isBuffNearerThanPlayer)||isGoingToBuff){
            // если расстояние до игрока больше, чем расстояние до бафа, то враг начинает движение к бафу
            isGoingToBuff = true;
            direction = new Point2D(dx / lengthToBuff, dy / lengthToBuff);
        }
        else if (!stayingOnCircle)direction = playerDirection;
        else direction = new Point2D(0,0);
    }

    public void changeHealth(float h){
        health+=h;
    }

    /*@Override
    public void collision(Actor other, float offset) {
        super.collision(other, offset);
        if(bounds.Overlaps(other.bounds))direction = new Point2D(0,0);
    }*/
    public void merge(Enemy e){
        damage+=e.damage;
        health+=e.health;
        speed=(speed+e.speed)/2f;
        R+=e.R/2.5f;
        bounds.R=R;
        GameSc.enemyPLayerLength -= e.R/2.5f;
    }
}
