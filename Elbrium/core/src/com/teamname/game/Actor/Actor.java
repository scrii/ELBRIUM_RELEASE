package com.teamname.game.Actor;

import com.badlogic.gdx.graphics.Texture;
import com.teamname.game.GraphicsObj.GraphicsObj;
import com.teamname.game.Screens.GameSc;

import Tools.Circle;
import Tools.Point2D;

public abstract class Actor extends GraphicsObj {

    // объекты игры имеют форму круга, пояснять поля, думаю, не стоит

    public Point2D position;
    public float speed,R;
    public Circle bounds;
    public Point2D direction;

    public Actor(Texture img, Point2D position, float speed, float R) {
        super(img);
        this.position=new Point2D(position);
        this.speed =speed;
        this.R=R;
        bounds = new Circle(position,R);
        direction=new Point2D(0,0);
    }

    public Actor(Texture img, Point2D position) {
        super(img);
        this.position=new Point2D(position);
        direction=new Point2D(0,0);
    }

    public void collision(Actor other, float offset){
        float dX = other.position.getX() - position.getX() - other.R;
        float dY = other.position.getY() - position.getY() - other.R;


        Circle dCircle = new Circle(other.bounds);
        dCircle.addR(offset);
        float length = (float)Math.sqrt(dX* dX + dY*dY);

        if(bounds.Overlaps(dCircle)){
            position.setX(other.position.getX()-other.R-(R+ dCircle.R)/length*dX);
            position.setY(other.position.getY()-other.R-(R+ dCircle.R)/length*dY);
        }
    }

    /*
     public void collision(Actor other, float offset){
        /*if(bounds.Overlaps(GameSc.player.bounds)){
            //Gdx.app.log("new_tag", "overlaps");
            position.setX(playerPos.getX()-GameSc.player.R - (R+GameSc.player.R) / length * dX);
            position.setY(playerPos.getY()-GameSc.player.R - (R+GameSc.player.R) / length * dY);


    float dX = other.position.getX() - position.getX() - other.R;
    float dY = other.position.getY() - position.getY() - other.R;


    Circle dCircle = new Circle(other.bounds);
        dCircle.addR(offset);
    float length = (float)Math.sqrt(dX* dX + dY*dY);

        if(bounds.Overlaps(dCircle)){
        position.setX(other.position.getX()-other.R-(R+ dCircle.R)/length*dX);
        position.setY(other.position.getY()-other.R-(R+ dCircle.R)/length*dY);
    }

}*/

    public void setDirection(Point2D dir){
        direction=dir;
    }
}
