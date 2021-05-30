package com.teamname.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Actor.Base;
import com.teamname.game.Main;

import java.util.ArrayList;

import Mesh.Mesh;
import Mesh.Square;
import Tools.Buttons;
import Tools.Joystick;
import Tools.Point2D;

public class BaseLocationSc implements Screen {

    Main main;
    OrthographicCamera camera;
    static final float SIZE_COEF=1;
    Point2D cameraPos,direction;
    Base base;
    ArrayList<Integer> pointers;
    Joystick joy;
    private static final int entityRad = Main.HEIGHT/15;
    private static final int joyX=(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4;
    private static final int joyY=(Main.HEIGHT/3)/2+(Main.HEIGHT/3)/4;
    private static final int joySize = Main.HEIGHT/3;
    private Mesh mesh;
    private float baseX=Main.BACKGROUND_WIDTH/2f;
    private float baseY=Main.BACKGROUND_HEIGHT/2f;
    private Buttons bLeft,bUp,bRight,bDown,bAccept;
    private Square square;
    public static boolean onesTouched;


    public BaseLocationSc(Main main){
        this.main=main;



        direction=new Point2D(0,0);
        cameraPos = new Point2D(Main.BACKGROUND_WIDTH/2f,Main.BACKGROUND_HEIGHT/2f);
        mesh = new Mesh(new Square(Main.BACKGROUND_HEIGHT/11,25));
        square=new Square(Main.BACKGROUND_HEIGHT/11,25);

        float xCenterButton;
        float a = square.a/2.5f;
        float indent = square.thickness;
        float oy3=square.thickness*3+a+indent;




        bLeft=new Buttons(false,Main.bLeft_un,Main.bLeft,a,a,
                Main.WIDTH-a-square.thickness*3-a-indent-a-indent, oy3);
        bRight=new Buttons(false,Main.bRight_un,Main.bRight,a,a,
                Main.WIDTH-a-square.thickness*3,oy3);
        bUp = new Buttons(false,Main.bUp_un,Main.bUp,a,a,
                Main.WIDTH-a-square.thickness*3-a-indent,oy3+a+indent);
        bDown=new Buttons(false,Main.bDown_un,Main.bDown,a,a,
                Main.WIDTH-a-square.thickness*3-a-indent,square.thickness*3);
        bAccept=new Buttons(false,Main.bDown_un,Main.bDown,a,a,
                Main.WIDTH-a-square.thickness*3-a-indent,oy3);

        //joy = new Joystick(Main.circle,Main.stickImg,new Point2D(joyX,joyY),joySize,0);
        base = new Base(Main.base,new Point2D(Main.WIDTH/2f,Main.HEIGHT/2f),0,(mesh.squares.get(0).a-2*mesh.squares.get(0).thickness)/2f);
        camera=new OrthographicCamera(Main.BACKGROUND_WIDTH,Main.BACKGROUND_HEIGHT/2f);

    }



    @Override
    public void render(float delta) {
        //logicUpdate();
        onesTouched=bLeft.isTouch()||bUp.isTouch()||bRight.isTouch()||bDown.isTouch()||bAccept.isTouch();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cameraCheck();
        Main.baseBatchBackground.setProjectionMatrix(camera.combined);
        camera.update();
        camera.position.set(cameraPos.getX(),cameraPos.getY(),0);



        Main.baseBatchBackground.begin();
        Main.baseBatchBackground.draw(Main.background,0,0);
        mesh.draw(Main.baseBatchBackground);
        base.draw(Main.baseBatchBackground);
        //joy.draw(Main.baseBatchBackground);
        Main.baseBatchBackground.end();

        Main.baseBatch.begin();
        buttonsLogic(Main.baseBatch);
        Main.baseBatch.end();

    }



    public void multitouch(float x,float y,boolean isDownTouch, int pointer){
        for(int i=0;i<5;i++){
            //Gdx.app.log("pos",x+" : "+y);
            //joy.update(x,y,isDownTouch,pointer);

            cameraUpdate(x,y,isDownTouch,pointer);
            mesh.update(x,y,isDownTouch,pointer);
            bLeft.action(x,y,isDownTouch,pointer);
            bUp.action(x,y,isDownTouch,pointer);
            bRight.action(x,y,isDownTouch,pointer);
            bDown.action(x,y,isDownTouch,pointer);
            bAccept.action(x,y,isDownTouch,pointer);
            //Gdx.app.error("mtouch","touch");
        }
    }

    private void cameraUpdate(float x,float y,boolean isDownTouch, int pointer){



        /*if(Main.HEIGHT>Main.BACKGROUND_HEIGHT)direction.setY(Main.BACKGROUND_HEIGHT);
        else if(Main.HEIGHT<0)direction.setY(0);
        if(!isDownTouch){firstTouch=true;cameraPointer=-1;}
        if(firstTouch&&isDownTouch&&pointer==0){
            stX = x;
            stY = y;
            firstTouch=false;
        }
        float dx = stX - x;
        float dy = stY - y;
        float dist = (float) Math.sqrt(dx * dx + dy * dy);
        if(Main.HEIGHT>Main.BACKGROUND_HEIGHT)direction.setY(Main.BACKGROUND_HEIGHT);
        else if(Main.HEIGHT<0)direction.setY(0);
        else if(dist!=0&&pointer==0)direction.setPoint(0, -(dy / dist));
        else{direction.setPoint(0,0);}
        cameraPos.add(direction.getX()*speed,direction.getY()*speed);*/
    }

    public void logicUpdate(){
        for(Square s : mesh.squares){
            if(s.isInside(new Point2D(baseX-base.R,baseY-base.R))){
                base.position.setX(s.pos.getX()+ s.thickness);
                base.position.setY(s.pos.getY()+s.thickness);
                s.imgSwitch(1000,Main.square1,Main.square2);
            }
        }
    }

    private void cameraCheck(){

    }

    private void buttonsLogic(SpriteBatch batch){
        bLeft.draw(batch);
        if(bLeft.isTouch())base.position.add(-mesh.squares.get(0).a,0);
        bRight.draw(batch);

        bUp.draw(batch);
        bDown.draw(batch);
        bAccept.draw(batch);
    }



    @Override
    public void show() {

        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                //screenY=Main.BACKGROUND_HEIGHT-screenY;
                //screenX=Main.BACKGROUND_WIDTH-screenX;
                screenY=Main.HEIGHT-screenY;
                multitouch((int)screenX,(int)screenY,true,pointer);
                Gdx.app.error("pos","");
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                // screenY=Main.HEIGHT-screenY;
                //screenX=Main.WIDTH-screenX;
                screenY=Main.HEIGHT-screenY;
                multitouch((int)screenX,(int)screenY,false,pointer);
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                //screenY=Main.HEIGHT-screenY;
                // screenX=Main.WIDTH-screenX;
                screenY=Main.HEIGHT-screenY;
                multitouch((int)screenX,(int)screenY,true,pointer);
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                return false;
            }
        });
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
