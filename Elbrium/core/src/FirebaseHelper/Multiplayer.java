package FirebaseHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.gson.Gson;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.util.ArrayList;
import java.util.Arrays;

import Messages.Message;
import Tools.Circle;
import Tools.GetterANDSetterFile;
import Tools.Point2D;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.functional.Consumer;

public class Multiplayer {
    public ArrayList<Message> players;
    DatabaseHelper databaseHelper;
    String valueOf_online;
    GetterANDSetterFile gs;
    public ArrayList<String> meta_players;
    public Circle bounds;
    Gson gson;

    public Multiplayer(){
        meta_players=new ArrayList<>();
        databaseHelper=new DatabaseHelper();
        players=new ArrayList<>();
        gs=new GetterANDSetterFile();
        gson=new Gson();
        bounds = new Circle(new Point2D(0,0),GameSc.player.R);
        startListener();
    }



    public boolean isSomeoneIN(){
        return !players.isEmpty();
    }

    public Point2D getCoords(String ref){
        if(meta_players.contains(ref)){
            Gdx.app.debug("MP","index of "+ref+": "+players.get(meta_players.indexOf(ref)));
            return new Point2D(players.get(meta_players.indexOf(ref)).x,players.get(meta_players.indexOf(ref)).y);}
        return new Point2D(-300,-300);
    }

    public Circle getBounds(){
        return bounds;
    }

    public void draw(SpriteBatch batch){
        for(Message m : players){
            //Gdx.app.log("MP",m.x+"");

            bounds.pos.setPoint(m.x,m.y);
            batch.draw(Main.getPlayer(m.texture),m.x,m.y, GameSc.player.R*2,2*GameSc.player.R);
        }
    }

    public ArrayList<Message> getPlayers(){
        return players;
    }

    private void startListener(){
        GdxFIRDatabase.instance().inReference("online").onDataChange(String.class).thenListener(new Consumer<String>() {
            @Override
            public void accept(String s) {
                tmp(s);
            }
        });
    }

    private void tmp(String s){
        valueOf_online=s;
        if(!s.replace(gs.get_Nickname(),"").equals("")){
        meta_players.clear();
        players.clear();
        meta_players.addAll(Arrays.asList(valueOf_online.split(";")));
        meta_players.remove(gs.get_Nickname());
        //Gdx.app.error("MP",meta_players.toString()+"");
        for(String ref : meta_players)createPlayers(ref);
        Gdx.app.log("MP",players.toString());}
        else GameSc.startElbriumSpawner();
    }

    private void createPlayers(String ref){
        final String r = ref;
        GdxFIRDatabase.instance().inReference(ref).onDataChange(String.class).thenListener(new Consumer<String>() {
            @Override
            public void accept(String s) {
                  tmp2(r,s);
            }
        });
    }

    private void tmp2(String ref,String s){
        boolean flag=false;
        for(Message m : players){
            if (m.nick.equals(ref)) {
                flag = true;
                m.x=gson.fromJson("{"+s,Message.class).x;
                m.y=gson.fromJson("{"+s,Message.class).y;
                break;
            }
        }
        if(!flag)players.add(gson.fromJson("{"+s,Message.class));

        Gdx.app.log("MP",ref);
    }



}
