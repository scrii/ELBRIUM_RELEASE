package com.teamname.game.Actor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

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
    public BulletGenerator bullgen;
    private int health;

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
        direction = new Point2D(dX / length, dY / length);

        position.add(direction.getX()*speed,direction.getY()*speed);
        bounds.pos.setPoint(position.getX(),position.getY());

        float cX = playerPos.getX();
        float cY = playerPos.getY();

        isSeeingPlayer = ((position.getX() > cX - Main.WIDTH/2f && position.getX() < cX + Main.WIDTH/2f)
                && (position.getY() > cY - Main.HEIGHT/2f && position.getY() < cY + Main.HEIGHT/2f));

        //Gdx.app.log("isSeeingPlayer", isSeeingPlayer+"");

       // for(Enemy enemy : GameSc.enemies){
           // if(enemy!=this)collision(enemy,-enemy.R+R);
        //}

    }

    public void damaged(Bullet b){
        health-=b.damage;

        if(health<=0)GameSc.enemies.removeValue(this, true);
        GameSc.bullets.removeValue(b,true);
    }



}
