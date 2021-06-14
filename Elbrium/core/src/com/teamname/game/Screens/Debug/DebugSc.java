package com.teamname.game.Screens.Debug;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.Main;

import java.util.List;

import Tools.Buttons;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.database.OrderByMode;
import pl.mk5.gdx.fireapp.functional.Consumer;

public class DebugSc implements Screen {
    Buttons button;
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

    public DebugSc() {
        button = new Buttons(false,Main.bDown_un,Main.bDown,Main.WIDTH/5f,Main.WIDTH/5f,500, 500);
    }

    @Override
    public void render(float delta) {
        Main.batch.begin();
        Main.batch.draw(Main.debugBG,0,0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        buttonsLogic(Main.batch);
        Main.batch.end();
    }

    public void multitouch(float x,float y,boolean isDownTouch, int pointer){
        for(int i=0;i<5;i++){
            button.action(x,y,isDownTouch,pointer);
        }
    }

    private void buttonsLogic(SpriteBatch btch){
        button.draw(btch);
        if(button.isTouch()&&!button.isActionDone()){
            // //
            //GdxFIRDatabase.inst().inReference("TEST").push().setValue("somevalue"+(int)(Math.random()*100));
            GdxFIRDatabase.inst().inReference("TEST").orderBy(OrderByMode.ORDER_BY_KEY,null).readValue(List.class).then(new Consumer<List>() {
                @Override
                public void accept(List l) {
                    Gdx.app.error("tag",l.size()+"");
                }
            });
            // //
            button.setActionDone(true);
        }
        else button.setActionDone(false);

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
