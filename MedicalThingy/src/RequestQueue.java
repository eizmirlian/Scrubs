import java.util.ArrayList;

public class RequestQueue {

    private ArrayList<Request> list;
    
    public RequestQueue() {
        list = new ArrayList<Request>();
    }
    
    public void addRequest(Request r) {
        list.add(r);
    }
    
    
    public int acceptAcknowledge(Acknowledge a) {
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == a.getId()) {
                list.remove(i);
                return i;
            }
        }
        return -1;
    }
    
    public String toString() {
        String str = "";
        for(int i = 0; i < list.size(); i++) {
            str += list.get(i).getPatientName() + ": " + list.get(i).getId() + "\n";
        }
        return str;
    }
    
    public int size() {
        return list.size();
    }
    
    public Request get(int i) {
        return list.get(i);
    }
}
