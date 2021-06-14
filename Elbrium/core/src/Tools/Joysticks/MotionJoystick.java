package Tools.Joysticks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.teamname.game.Actor.Player;
import com.teamname.game.Screens.GameSc;

import Tools.Point2D;

public class MotionJoystick extends Joystick {
    Player player;

    public MotionJoystick(Texture cimg, Texture simg, Point2D point, float size, Player player) {
        super(cimg, simg, point, size);
        this.player=player;
    }

    @Override
    public void returnStick() {
        super.returnStick();
        GameSc.player.isMove=false;
        player.direction.setPoint(direction);
    }

    @Override
    public void atControl(float x, float y) {
        super.atControl(x, y);
        GameSc.player.isMove=true;
        updateSpeed();
        player.direction.setPoint(direction);
    }

    // услговие ускорения

    public void updateSpeed(){
        if(circleBounds.isContains(stickBounds.pos))player.setRealSpeed(player.Speed*dist/rcircle);
        else player.setRealSpeed(player.Speed);
        ///Gdx.app.error("player realSpeed",player.getRealSpeed()+"");
    }
}
