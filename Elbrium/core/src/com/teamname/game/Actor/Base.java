package com.teamname.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Tools.Point2D;

public class Base extends Actor {

    // объект "база". присутствует на экране выбора ее местоположения (BaseLocationSc)

    public Base(Texture img, Point2D position, float Speed, float R) {
        super(img, position, Speed, R);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img,position.getX(),position.getY(),R*2,R*2);
    }

    @Override
    public void update() {
        position.add(direction.getX()* speed,direction.getY()* speed);
        bounds.pos.setPoint(position);
    }

    public void setBounds(float x, float y){
        bounds.pos.setX(x);
        bounds.pos.setY(y);
    }


}
