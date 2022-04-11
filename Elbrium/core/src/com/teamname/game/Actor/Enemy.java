package com.teamname.game.Actor;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Screens.GameSc;

import Tools.Point2D;

public class Enemy extends Actor {
    private Point2D playerPos;
    private int damage;

    public Enemy(Texture img, Point2D position, float speed, float R, int damage) {
        super(img, position, speed, R);
        this.damage = damage;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, position.getX()-R,position.getY()-R,R*2,R*2);
    }

    @Override
    public void update() {
        playerPos = GameSc.player.send_in_ONLINE;

        float dX = playerPos.getX() - position.getX() - GameSc.player.R;
        float dY = playerPos.getY() - position.getY() - GameSc.player.R;
        float length = (float)Math.sqrt(dX* dX + dY*dY);
        direction = new Point2D(dX / length, dY / length);

        /*
        if(!circleBounds.isContains(stickBounds.pos)){
            stickBounds.pos.setX(-rcircle/ length * dx +circleBounds.pos.getX());
            stickBounds.pos.setY(-rcircle/ length * dy +circleBounds.pos.getY());
        */

        if(bounds.Overlaps(GameSc.player.bounds)){
            position.setX(position.getX() + R / length *dX - GameSc.player.R);
            position.setY(position.getY() + R / length *dY- GameSc.player.R);
        }

        position.add(direction.getX()*speed,direction.getY()*speed);
        bounds.pos.setPoint(position.getX()-R,position.getY()-R);
        Gdx.app.log("enemy", position.getX()+" "+position.getY());

    }


}
