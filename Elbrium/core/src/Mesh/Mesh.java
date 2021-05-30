package Mesh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.teamname.game.GraphicsObj.GraphicsObj;
import com.teamname.game.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Tools.Point2D;

public class Mesh {
    private Square modelSquare;
    private Point2D touch;
    private ArrayList<Square> squares;
    private final Square square;
    Square tmp[][];

    public Mesh(Square square) {
        this.square = square;
        squares = new ArrayList<>();
        tmp = new Square[Main.BACKGROUND_HEIGHT/square.a][Main.BACKGROUND_WIDTH/square.a];
        for(int i=0;i<Main.BACKGROUND_HEIGHT/square.a;i++)
            for(int j=0;j<Main.BACKGROUND_WIDTH/square.a;j++)
                tmp[i][j]=new Square(square.a);
        setSquaresPoints();
    }


    public void draw(SpriteBatch batch) {
        for (Square sq : squares) {
            batch.draw(sq.getImg(), sq.pos.getX(), sq.pos.getY(), sq.a, sq.a);
        }
    }


    public void update(float x, float y, boolean isDownTouch, int pointer) {
        for (Square sq : squares) {
            if (sq.isInside(new Point2D(x, y)) && isDownTouch)
                if (sq.textureCount == 1) {
                    sq.setImg(Main.square2);
                    sq.textureCount = 2;
                } else {
                    sq.setImg(Main.square1);
                    sq.textureCount = 1;
                }
        }
    }

    public void setSquaresPoints() {
        for(int i=0;i<Main.BACKGROUND_HEIGHT/square.a;i++)
            for(int j=0;j<Main.BACKGROUND_WIDTH/square.a;j++) {
                tmp[i][j].pos.setX(j* square.a);
                tmp[i][j].pos.setY(i* square.a);
                squares.add(tmp[i][j]);
            }
        for(Square sq : squares)
            Gdx.app.log("sq "+ squares.indexOf(sq),sq.pos.getX()+ " : "+sq.pos.getY());
    }
}
