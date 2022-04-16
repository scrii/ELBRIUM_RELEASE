package Tools;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.teamname.game.Actor.Elbrium;
import com.teamname.game.Actor.Enemy;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.awt.Point;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import Buffs.Buff;
import Messages.ElbriumMessage;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;

public class Spawner extends TimerTask {
    private int rank;
    private ElbriumMessage message;
    private boolean enemyFlag = true;
    private Timer timer;

    public Spawner() {
        // объект вызывается при условии spawner (см PlayerAction)
    }

    @Override
    public void run() {
        if (GameSc.ore.size < 8) spawnOre();
        else Gdx.app.log("Spawner", "ore[] Overflow");

        if(GameSc.buffs.size < 5) spawnBuff();
        else Gdx.app.log("Spawner", "buffs[] Overflow");

        if(enemyFlag){
            if(GameSc.enemies.size < 5)spawnEnemy();
            else Gdx.app.debug("Spawner", "enemies[] Overflow");
            enemyFlag = false;
        }
        else enemyFlag = true;
    }

    public void start() {
        TimerTask timerTask = new Spawner();
        timer = new Timer(true);
        timer.scheduleAtFixedRate(timerTask, 0, 1000 * 1000); // переодичность спавна Эльбриума - 30 секунд
    }

    private void spawnOre() {

        rank = +(int) (Math.random() * 3);
        Elbrium elbrium = new Elbrium(Main.actor, new Point2D((float) Math.random() * Main.BACKGROUND_WIDTH / 1.3f,
                (float) Math.random() * Main.BACKGROUND_HEIGHT / 1.3f), rank);
        GameSc.ore.add(elbrium);

        Gdx.app.log("TIMER", GameSc.ore.size + " ore spawned");
    }

    private void spawnEnemy(){
        int enemyImgCase = (int)( Math.random() * 3); // [0;2]
        Texture selectedImg = Main.enemy0;
        switch (enemyImgCase){
            case 0: {selectedImg = Main.enemy0;break;}
            case 1: {selectedImg = Main.enemy1;break;}
            case 2: {selectedImg = Main.enemy2;break;}
        };

        int characteristicsCase = (int)(Math.random() * 3), health=100;
        float speed=2, r=2, damage = 20;
        int entityRad = GameSc.entityRad;
        switch(characteristicsCase){
            case 0: {
                // player.speed = 6;
                speed = 4;
                r = (float)(entityRad * 0.8);
                damage = 5;
                health=30;
                break;
            }
            case 1: {
                speed = 4.5f;
                r = (float)(entityRad * 1.2);
                damage = 7;
                health=28;
                break;
            }
            case 2: {
                speed = 5;
                r = (float)(entityRad * 0.7);
                damage = 3;
                health=25;
                break;
            }
        }
        Enemy enemy = new Enemy(selectedImg, new Point2D((float) Math.random() * Main.BACKGROUND_WIDTH / 1.3f,
                (float) Math.random() * Main.BACKGROUND_HEIGHT / 1.3f), speed, r, (int)(damage), health);
        /*GameSc.ore.add(elbrium);

        Gdx.app.log("TIMER", "ore spawned");*/
        GameSc.enemies.add(enemy);
        Gdx.app.log("TIMER", GameSc.enemies.size+ " enemy spawned");
        //Gdx.app.log("TIMER", GameSc.enemies.size+"");
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void stop(){
        timer.cancel();
    }



    private void spawnBuff(){
        int choice = (int) (Math.random() * 3);

        Buff buff;
        switch (choice){
            case 1: {buff = new Buff("speed_up", new Point2D((float) Math.random() * Main.BACKGROUND_WIDTH / 1.3f,
                    (float) Math.random() * Main.BACKGROUND_HEIGHT / 1.3f), Main.speedArrow);break;}
            case 2: {buff = new Buff("damage_up",new Point2D((float) Math.random() * Main.BACKGROUND_WIDTH / 1.3f,
                    (float) Math.random() * Main.BACKGROUND_HEIGHT / 1.3f),Main.explosion);break;}
            default: {buff = new Buff("aidkit",new Point2D((float) Math.random() * Main.BACKGROUND_WIDTH / 1.3f,
                    (float) Math.random() * Main.BACKGROUND_HEIGHT / 1.3f),Main.aidkit);break;}
        }


        GameSc.buffs.add(buff);
        Gdx.app.log("TIMER", GameSc.buffs.size + " buff spawned");
    }

}
