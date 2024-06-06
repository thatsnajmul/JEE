package entity;

public class jdbc {

    private int id;
    private String msg;

    public jdbc() {
    }

    public jdbc(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public jdbc(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "jdbc{" + "id=" + id + ", msg=" + msg + '}';
    }

}
