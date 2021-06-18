package Messages;

public class ElbriumMessage {
    public float x;
    public float y;
    public float dir_x;
    public float dir_y;
    public float hp;
    public int rank;


    public ElbriumMessage(float x, float y, float dir_x, float dir_y, float hp, int rank) {
        this.x = x;
        this.y = y;
        this.dir_x = dir_x;
        this.dir_y = dir_y;
        this.hp = hp;
        this.rank = rank;
    }

    public ElbriumMessage(ElbriumMessage em){
        x=em.x;
        y=em.y;
        dir_x=em.dir_x;
        dir_y=em.dir_y;
        hp=em.hp;
        rank=em.rank;
    }



    @Override
    public String toString() {
        return "\"x\":" + x  + "," +
                "\"y\":" + y  + "," +
                "\"dir_x\":\"" + dir_x + "\"," +
                "\"dir_y\":" + dir_y  + "," +
                "\"hp\":" + hp  + "," +
                "\"rank\":" + rank  + "}";
    }
}
