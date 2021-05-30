package Mesh;

import com.badlogic.gdx.graphics.Texture;
import com.teamname.game.Main;

import Tools.Point2D;

public class Square {
    private Texture img;
    public int a;
    public Point2D pos;
    public int textureCount; // от 1 до 2 //

    public Square(int a) {
        this.a = a;
        pos = new Point2D(0,0);
        img = Main.square1;
    }

    public Point2D getCenter(){
        return new Point2D((float)a/2,(float)a/2);
    }

    public void updateOX(){
        pos.add(new Point2D(a,0));
    }

    public void updatePOS(){
        pos.add(new Point2D(a,a));
    }

    public boolean isInside(Point2D pos){
        return (pos.getX()<this.pos.getX()+a &&
                pos.getX() > this.pos.getX() &&
                pos.getY() < this.pos.getY()+a &&
                pos.getY() > this.pos.getY());
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public void setPos(Point2D point){

    }
}
