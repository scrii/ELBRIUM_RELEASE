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
import Tools.Joysticks.Joystick;
import Tools.Point2D;

public class DeathSc implements Screen {

    Main main;
    OrthographicCamera camera;
    static final float SIZE_COEF=1;
    Point2D cameraPos,direction;



    public DeathSc(Main main){
        this.main=main;



        direction=new Point2D(0,0);
        cameraPos = new Point2D(Main.BACKGROUND_WIDTH/2f,Main.BACKGROUND_HEIGHT/2f);





        camera=new OrthographicCamera(Main.BACKGROUND_WIDTH,Main.BACKGROUND_HEIGHT/2f);
        camera.position.set(cameraPos.getX(),cameraPos.getY(),0);
    }



    @Override
    public void render(float delta) {
        //logicUpdate();

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Main.deathBatch.setProjectionMatrix(camera.combined);
        camera.update();
        Main.deathBatch.begin();

        Main.deathBatch.draw(Main.background,0,0);

        Main.deathBatch.end();
    }



    public void multitouch(float x,float y,boolean isDownTouch, int pointer){
        for(int i=0;i<5;i++){

        }
    }





    private void cameraCheck(){

    }

    private void buttonsLogic(SpriteBatch batch) {
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
