package Messages;

public class ElbriumMessage {
    public float x;
    public float y;
    public float hp;

    public ElbriumMessage(float x, float y, float hp) {
        this.x = x;
        this.y = y;
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "\"x\":" + x  + "," +
                "\"y\":" + y  + "," +
                "\"hp\":\"" + hp + "}";
    }
}
