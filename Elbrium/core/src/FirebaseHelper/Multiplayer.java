package FirebaseHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.google.gson.Gson;
import com.teamname.game.Actor.Elbrium;
import com.teamname.game.Actor.Player;
import com.teamname.game.Main;
import com.teamname.game.Screens.GameSc;

import java.util.ArrayList;
import java.util.Arrays;

import Messages.BulletMessage;
import Messages.Message;
import Online.PlayerAction;
import Tools.Circle;
import Tools.GetterANDSetterFile;
import Tools.Point2D;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.functional.Consumer;

public class Multiplayer {
    public ArrayList<Message> players;
    DatabaseHelper databaseHelper;
    String valueOf_online;
    static GetterANDSetterFile gs;
    public static ArrayList<String> meta_players;
    public static ArrayList<Player> real_players;
    public Circle bounds, bulletBounds;
    static ArrayList<Elbrium> ore;
    private PlayerAction playerAction;
    private ArrayList<BulletMessage> bullets;
    Gson gson;


    public Multiplayer(){
        meta_players=new ArrayList<>();
        real_players=new ArrayList<>();
        databaseHelper=new DatabaseHelper();
        players=new ArrayList<>();
        bullets=new ArrayList<>();
        gs=new GetterANDSetterFile();
        gson=new Gson();
        ore=new ArrayList<>();
        playerAction=new PlayerAction();
        bounds = new Circle(new Point2D(0,0),GameSc.player.R);
        bulletBounds=new Circle(new Point2D(0,0),GameSc.player.R/5);
        startListener();
    }



    public boolean isSomeoneIN(){
        return !players.isEmpty();
    }

    public Point2D getCoords(String ref){
        if(meta_players.contains(ref)){
            //Gdx.app.debug("MP","index of "+ref+": "+players.get(meta_players.indexOf(ref)));
            return new Point2D(players.get(meta_players.indexOf(ref)).x,players.get(meta_players.indexOf(ref)).y);}
        return new Point2D(-300,-300);
    }

    public Circle getBounds(){
        return bounds;
    }

    public void update(){

    }

    public void draw(SpriteBatch batch){
        for(Message m : players){
            //Gdx.app.log("MP",m.x+"");

            bounds.pos.setPoint(m.x-GameSc.player.R,m.y-GameSc.player.R);
            batch.draw(Main.getPlayer(m.texture),bounds.pos.getX()-GameSc.player.R,bounds.pos.getY()-GameSc.player.R, GameSc.player.R*2,2*GameSc.player.R);
            //bounds.debug(batch,GameSc.player.R);

            if(GameSc.player.bounds.Overlaps(bounds)){
                /*float dx = GameSc.player.send_in_ONLINE.getX()-bounds.pos.getX()-2*GameSc.player.R;
                float dy = GameSc.player.send_in_ONLINE.getY()-bounds.pos.getY()-2*GameSc.player.R;
                float length=(float)Math.sqrt(dx*dx+dy*dy);
                GameSc.player.send_in_ONLINE.setPoint(GameSc.player.R/length*dx+bounds.pos.getX(),GameSc.player.R/length*dy+bounds.pos.getY());*/
                //GameSc.player.send_in_ONLINE.setPoint(GameSc.player.send_in_ONLINE.getX()-dx,GameSc.player.send_in_ONLINE.getY()-dy);
                /*float setY = bounds.pos.getY()+(float)Math.sqrt(GameSc.player.R*GameSc.player.R-
                        (GameSc.player.send_in_ONLINE.getX()-GameSc.player.R-bounds.pos.getX())*(GameSc.player.send_in_ONLINE.getX()-GameSc.player.R-bounds.pos.getX()));
                GameSc.player.send_in_ONLINE.setY(setY);*/
            }
        }
        for(BulletMessage bm : bullets){
            bulletBounds.pos.setPoint(bm.x,bm.y);
            batch.draw(Main.bullet,bm.x-GameSc.player.R/5,bm.y-GameSc.player.R/5,GameSc.player.R/5*2,GameSc.player.R/5*2);
            //bulletBounds.debug(batch,GameSc.player.R/5);
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

        GdxFIRDatabase.inst().inReference("Spawner").setValue(meta_players.get(0));
        /*GameSc.playerIsSpawner= meta_players.get(0).equals(gs.get_Nickname());
        if(GameSc.playerIsSpawner)GameSc.spawnerLogic();
        else GameSc.spawnerSniffer();*/

        playerAction.update(meta_players.get(0).equals(gs.get_Nickname()));
        meta_players.remove(gs.get_Nickname());
        //Gdx.app.debug("MP",meta_players.toString()+"");

        //if(meta_players.isEmpty())GdxFIRDatabase.inst().inReference("Spawner").setValue(gs.get_Nickname());

        for(String ref : meta_players){createPlayers(ref);createBullets(ref);}
        //Gdx.app.log("MP",players.toString());

        }
        Gdx.app.error("spawner",GameSc.playerIsSpawner+"");

    }

    private void createPlayers(final String ref){
        GdxFIRDatabase.instance().inReference(ref).onDataChange(String.class).thenListener(new Consumer<String>() {
            @Override
            public void accept(String s) {
                  tmp2(ref,s);
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

    /*public void oreMonitoring(){
        for(int i=0;i<Integer.MAX_VALUE;i++){
            GdxFIRDatabase.inst().inReference("ore"+i).onDataChange(String.class).thenListener(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    if(!s.equals("")||s!=null)ore.add();
                }
            });
        }
    }*/


    public static boolean condition_spawnerOnDisconnect(){
        if(Main.gameSc!=null)
            return meta_players.isEmpty();
        else return false;
    }

    public static void getBullets(){
        for(String s : meta_players)
            for(int i=0;i<30;i++) {
                GdxFIRDatabase.inst().inReference("bullet_" + s).onDataChange(String.class).thenListener(new Consumer<String>() {
                    @Override
                    public void accept(String s) {

                    }
                });
            }
    }

    private void createBullets(final String ref){
        for(int i=0;i<25;i++){
            GdxFIRDatabase.inst().inReference("bullet_"+ref+i).onDataChange(String.class).thenListener(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    //if(s!=null)tmp3(ref,s);
                }
            });
        }
    }

    private void tmp3(String ref, String s){
        boolean flag=false;
        for(BulletMessage bm : bullets){
            //Gdx.app.error("bullets",bullets.toString());
            if (bm.nick.equals(ref)) {
                flag = true;
               //bm.x=gson.fromJson("{"+s,BulletMessage.class).x;
               //bm.y=gson.fromJson("{"+s,BulletMessage.class).y;
                break;
            }
        }
        //if(!flag)bullets.add(gson.fromJson("{"+s,BulletMessage.class));
    }




}
