package Tools;

import com.badlogic.gdx.Gdx;
import com.teamname.game.Actor.Bullet;
import com.teamname.game.Actor.Enemy;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.util.Timer;
import java.util.TimerTask;

import Tools.Joysticks.Joystick;

public class BulletGenerator {
    boolean isFire;
    boolean isTime=true;
    Timer timer;
    private static int Sec=1;
    private float counter=Sec;
    private TimerTask task;

    public BulletGenerator(int secInterval){
        timer=new Timer();
        task = new TimerTask() {
            @Override
            public void run() {
                if(counter==0){
                    isTime=true;
                }
                else counter--;
            }
        };
        timer.scheduleAtFixedRate(task,0,250);
        Sec=secInterval;
    }

    public void update(Joystick joy){
        isFire= joy.getDir().getX() != 0 || joy.getDir().getY() != 0;
        if(isFire && isTime) {
            Point2D pos = new Point2D(GameSc.player.bounds.pos);
            pos.add(GameSc.player.R*joy.getDir().getX(), GameSc.player.R*joy.getDir().getY());
            GameSc.bullets.add(new Bullet(Main.bullet, pos, 18, GameSc.player.R/5, joy.getDir(),GameSc.player.damage,true));
            isTime=false;
            counter=Sec;
            //Gdx.app.error("isTime",isTime+"");
        }
    }

    public void enemyUpdate(Enemy enemy){
        if(enemy.isSeeingPlayer && isTime){
            Point2D pos = new Point2D(enemy.position);
            pos.add(enemy.R*enemy.playerDirection.getX(), enemy.R*enemy.playerDirection.getY());
            GameSc.bullets.add(new Bullet(Main.bullet, pos, 18, GameSc.player.R/5, enemy.playerDirection, enemy.damage,false));
            //Gdx.app.log("playerdir ", enemy.playerDirection.getX() +" "+enemy.playerDirection.getY());
            isTime=false;
            counter=Sec;
        }
    }
}
