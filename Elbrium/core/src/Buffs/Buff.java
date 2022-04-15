package Buffs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.teamname.game.Actor.Actor;
import com.teamname.game.Actor.Enemy;
import com.teamname.game.Actor.Player;
import com.teamname.game.GraphicsObj.Animation;
import com.teamname.game.GraphicsObj.GraphicsObj;
import com.teamname.game.Screens.GameSc;

import Tools.Circle;
import Tools.Point2D;

public class Buff extends GraphicsObj {
    public Point2D position;
    private Animation animation;
    public String name;
    public Circle bounds;
    public float R;

    public Buff(String name, Point2D position, Texture img, TextureRegion region, int frameCount, int cycleTime, int scenes) {
        super(img);
        animation = new Animation(region, frameCount, cycleTime, scenes);
        this.position = position;
        this.name = name;
        R = GameSc.player.R * 1.5f;
        bounds = new Circle(new Point2D(position.getX() + R, position.getY() + R),R);
        //bounds.pos.setPoint(position);
    }

    public Buff(String name, Point2D position, Texture img) {
        super(img);
        animation = null;
        this.position = position;
        this.name = name;
        R = GameSc.player.R * 1.5f;
        bounds = new Circle(new Point2D(position.getX() + R, position.getY() + R),R);
        //bounds.pos.setPoint(position);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(img, position.getX(), position.getY(), R*2, R*2);
    }

    @Override
    public void update() {

    }

    public void pickUp(Player player, Buff buff){
        if(buff.name.equals("aidkit")){
            if(GameSc.player.getHealth() + 5 > GameSc.player.getPrimaryHealth())GameSc.player.setHealth(GameSc.player.getPrimaryHealth());
            else player.changeHealth(5);
            Gdx.app.log("aidkit, health",player.getHealth()+"");
        }
        else if(buff.name.equals("damage_up")){
            player.damage += 0.1f;
            Gdx.app.log("damage_up, damage",player.damage+"");
        }
        else if(buff.name.equals("speed_up")){
            player.speed+=0.05f;
            Gdx.app.log("speed_up, speed",player.speed+"");
        }
    }

    public void pickUp(Enemy enemy, Buff buff){
        enemy.isGoingToBuff = false;
        enemy.isSeeingBuff = false;
        if(buff.name.equals("aidkit")){
            enemy.changeHealth(5);
            //Gdx.app.log("aidkit, health",player.getHealth()+"");
        }
        else if(buff.name.equals("damage_up")){
            enemy.damage += 2;
            //Gdx.app.log("damage_up, damage",player.damage+"");
        }
        else if(buff.name.equals("speed_up")){
            enemy.speed+=0.1f;
            //Gdx.app.log("speed_up, speed",player.speed+"");
        }
    }
}
