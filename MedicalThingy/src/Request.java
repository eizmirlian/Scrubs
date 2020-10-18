import java.time.LocalTime;
import java.util.Random;

public class Request {

    private String patientName;
    private String desc;
    private String responder;
    private String time;
    private int id;
    
    public Request(String inPatientName, String inDesc, String inResponder) {
        patientName = inPatientName;
        desc = inDesc;
        responder = inResponder;
        time = LocalTime.now().toString();
        id = time.hashCode()+ new Random().nextInt(100);
    }
    
    public String getPatientName() {
        return patientName;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public String getResponder() {
        return responder;
    }
    
    public String getTime() {
        return time;
    }
    
    public int getId() {
        return id;
    }
    
    public String toString() {
        return "{\"patientName\":\""+patientName+"\", \"desc\":\""+desc
                +"\", \"responder\":\""+responder+"\", \"time\":\""+time+
                "\", \"id\":"+String.valueOf(id)+"}";
    }
}