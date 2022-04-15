package Hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.GraphicsObj.GraphicsObj;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;
import java.util.ArrayList;
import Tools.Circle;
import Tools.Point2D;

public class HealthBar extends GraphicsObj {

    // объект этого класса объявляется после создания игрока
    // здоровье игрока растет за счет роста уровня

    private int health;
    private final int primaryHealth = GameSc.player.getPrimaryHealth();
    private ArrayList<Circle> slots;
    private ArrayList<Texture> slotsColor;
    private final Point2D firstSlotPosition;
    private final float slotR;
    private final int size = 7;
    private final int healthPart = primaryHealth / size;

    public HealthBar() {
        slotR = GameSc.player.R/1.8f;
        firstSlotPosition = new Point2D(Main.WIDTH - slotR*2, Main.HEIGHT - slotR*3);
        slots = new ArrayList<>();
        slotsColor = new ArrayList<>();
        for(int i=0;i<size;i++){
            Point2D temp = new Point2D(firstSlotPosition);
            temp.add(-slotR*2.5f*i,0);
            slots.add(new Circle(temp, slotR));
            slotsColor.add(Main.greenCircle);

        }
        health = GameSc.player.getHealth();
        Gdx.app.log("healthbar",healthPart+"");
    }

    @Override
    public void draw(SpriteBatch batch) {
        for(int i=0;i<slots.size();i++){
            Point2D thisPos = slots.get(i).pos;
            batch.draw(slotsColor.get(i),thisPos.getX()-slotR,thisPos.getY()-slotR,slotR*2, slotR*2);
            slots.get(i).debug(batch);
        }
    }

    @Override
    public void update() {
        health = GameSc.player.getHealth();
        for(int i=1;i<size+1;i++){
            if(health >= primaryHealth - healthPart * (i+1) && health < primaryHealth - healthPart * i){
                changeColor(i-1);
            }
        }
    }

    private void changeColor(int i){
        //Gdx.app.log("index, health ", i + GameSc.player.getHealth() + "");
        if(slotsColor.get(i) == Main.greenCircle){
            slotsColor.set(i, Main.redCircle);
        }
        for(int j=size-1;j>i;j--){
            slotsColor.set(j, Main.greenCircle);
        }

        //else slotsColor.set(i, Main.greenCircle);
    }
}
