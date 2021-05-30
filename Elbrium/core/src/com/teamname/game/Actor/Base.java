package com.teamname.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import Tools.Point2D;

public class Base extends Actor {
    public Base(Texture img, Point2D position, float Speed, float R) {
        super(img, position, Speed, R);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img,position.getX(),position.getY());
    }

    @Override
    public void update() {
        // границы
        // камера в том числе
        position.add(direction.getX()*Speed,direction.getY()*Speed);
        bounds.pos.setPoint(position);
    }


}
