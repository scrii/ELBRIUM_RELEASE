package FirebaseHelper;

import com.badlogic.gdx.Gdx;
import com.google.gson.Gson;


import Messages.Message;
import Tools.GetterANDSetterFile;
//<!!!---> import de.tomgrill.gdxfirebase.core.GDXFirebase;
//import de.tomgrill.gdxfirebase.core.database.DatabaseReference;
//<!!!---> import de.tomgrill.gdxfirebase.core.auth.OnCompleteListener;
//<!!!---> import de.tomgrill.gdxfirebase.core.auth.Task;
import pl.mk5.gdx.fireapp.GdxFIRApp;
import pl.mk5.gdx.fireapp.GdxFIRDatabase;
import pl.mk5.gdx.fireapp.functional.Consumer;

public class DatabaseHelper {
    private final Gson gson;
    String s;
    GetterANDSetterFile getter_setter;
    private String valueOf_online = "NONE";
    public boolean bool_tnp_read_online=false;

    public DatabaseHelper() {
        gson = new Gson();
        getter_setter = new GetterANDSetterFile();
    }

    public void sendToFirebase(String heading, String msg) {
        GdxFIRDatabase.instance().inReference(heading).setValue(msg);
    }

    public void removeFromFirebase(String reference) {
        GdxFIRDatabase.instance().inReference(reference).removeValue();
    }

    public void updateValues(String reference, Message msg) {
        GdxFIRDatabase.instance().inReference(reference).setValue(msg);
    }

    public void readString(int case_) {

        // 0 - отправляет никнейм в reference online
        // 1 - удалить из поля online, закрыть приложение
        // 2 - прочитать поле online. требуется вызов метода getvalueOf_online

        switch (case_) {
            case 0:
                GdxFIRDatabase.instance().inReference("online").readValue(String.class).then(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        tmp_online(s);
                        bool_tnp_read_online=true;
                    }
                });
                break;

            case 1:
                GdxFIRDatabase.instance().inReference("online").readValue(String.class).then(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        tmp_delete_from_online(s);
                    }
                });
                break;

            case 2:
                GdxFIRDatabase.instance().inReference("online").readValue(String.class).then(new Consumer<String>() {
                    @Override
                    public void accept(String s) {
                        tmp_read_online(s);
                    }
                });
                break;
        }

    }

   public void getP(){
        readString(2);
        //while(!bool_tnp_read_online)Gdx.app.debug("DBHelper","waiting...");
        Gdx.app.error("DBHelper","accepted");
   }

    private void tmp_read_online(String s) {
        valueOf_online = s;
        bool_tnp_read_online=true;
        Gdx.app.error("DBHelper", "valueOf_online updated");

    }

    public String getValueOf_online() {
        return valueOf_online;
    }

    private void tmp_online(String s) {
        if (s == null) sendToFirebase("online", getter_setter.get_Nickname() + ";");
        else if (!s.contains(getter_setter.get_Nickname()))
            sendToFirebase("online", s + getter_setter.get_Nickname() + ";");
    }

    private void tmp_delete_from_online(String s) {
        if (s != null && s.contains(getter_setter.get_Nickname()))
            sendToFirebase("online", s.replace(getter_setter.get_Nickname() + ";", ""));
        Gdx.app.log("Game_manager", "GAME STOPED");
        Gdx.app.exit();
    }

    public void setMetadata(String s) {
        this.s = s;
    }

    public void logOut() {
        readString(1);
    }
}


