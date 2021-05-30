package Messages;

import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;

import FirebaseHelper.DatabaseHelper;


public class Message {
    public String texture;
    public float x;
    public float y;
    public float attack;
    public float health;
    public float protect;
    public String nick;


   // private Gson gson;

    private DatabaseHelper databaseHelper;
  //  private final Gson gson;


    public Message(String texture, float x, float y, float attack, float health, float protect, String nick) {
        this.texture = texture;
        this.x = x;
        this.y = y;
        this.attack = attack;
        this.health = health;
        this.protect = protect;
        this.nick=nick;
        //gson=new Gson();
    }





    public void setAttack(float attack) {
        this.attack = attack;
    }



    public void setProtect(float protect) {
        this.protect = protect;
    }

    @Override
    public String toString() {
        return
                "\"texture\":" + texture  + "," +
                "\"x\":" + x  + "," +
                "\"y\":" + y  + "," +
                "\"attack\":\"" + attack + "\"," +
                "\"health\":" + health  + "," +
                "\"protect\":" + protect  + "," +
                        "\"nick\":" + nick  +

                        "}";
    }

  //  public Message getData(String metadata){
 //       return gson.fromJson(metadata, Message.class);
  //  }

    public void logIt(String tag, String log){
        Gdx.app.log(tag, log);
    }

    public void deleteMessage(String ref){
        databaseHelper.removeFromFirebase(ref);
    }

    //{"attack":0.0,"author":"author",
    // "color_background":"back","color_front":"front","elbrium":0.0,"gold":0.0,"health":0.0,"protect":0.0,"speed":0.0,"x":0.0,"y":0.0}//{"attack":0.0,"author":"author",
    // "color_background":"back","color_front":"front","elbrium":0.0,"gold":0.0,"health":0.0,"protect":0.0,"speed":0.0,"x":0.0,"y":0.0}
}
