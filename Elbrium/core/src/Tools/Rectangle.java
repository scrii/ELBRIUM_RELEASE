package Tools;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;

public class Rectangle {
    private Point2D pos;
    private float width, height;

    public boolean OverlapsX(Circle c){
        return c.pos.getX() + c.R >= pos.getX();
    }

    public boolean OverlapsY(Circle c){
        return c.pos.getY() + c.R >= pos.getY();
    }

    public void add(float x, float y){
        pos.add(x,y);
    }

    public void debug(SpriteBatch batch){
        batch.setColor(1,1,1,1);
        batch.draw(Main.rectangle,pos.getX(),pos.getY(),width,height);
    }
}
