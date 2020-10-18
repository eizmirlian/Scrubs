import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class MainQueue extends JPanel{
    
    private RequestQueue queue;
    private ArrayList<RequestDisplay> queueDisplay;
    private BoxLayout layout;
    private MainWindow container;
    
    public MainQueue(MainWindow inContainer) {
        container = inContainer;
        
        layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);
        queue = new RequestQueue();
        queueDisplay = new ArrayList<RequestDisplay>();
        setSize(400,500);
    }
    
    public void addRequest(Request r) {
        queue.addRequest(r);
        RequestDisplay display = new RequestDisplay(r);
        queueDisplay.add(display);
        add(display);
        revalidate();
        Client.send(r.toString());
    }
    
    public void acceptAcknowledge(Acknowledge a) {
        int index = queue.acceptAcknowledge(a);
        if(index != -1) {
            layout.removeLayoutComponent(queueDisplay.get(index));
            queueDisplay.remove(index);
            System.out.println(a.getId());
            revalidate();
        }
    }
}
