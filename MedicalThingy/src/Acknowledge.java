import java.time.LocalTime;

public class Acknowledge {

    private int id;
    private String time;
    
    public Acknowledge(Request r) {
        id = r.getId();
        time = java.time.LocalTime.now().toString();
    }
    
    public String getTime() {
        return time;
    }
    
    public int getId() {
        return id;
    }
    
}
