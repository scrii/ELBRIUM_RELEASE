package com.teamname.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.GraphicsObj.GraphicsObj;

import Tools.Point2D;

public class Wall extends GraphicsObj
{
    public Point2D position;
    public float height, width;

    public Wall(Texture img, Point2D position) {
        super(img);
        this.position=position;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img,position.getX(),position.getY(),width, height);
    }

    @Override
    public void update() {

    }
}