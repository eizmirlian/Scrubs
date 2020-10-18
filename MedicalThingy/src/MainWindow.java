import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow extends JFrame{
    
    private MainQueue queue;
    private SideBar side;
    
    public MainWindow() {
        side = new SideBar(this);
        queue = new MainQueue(this);
    }
    
    public void run() {
        side.setSize(100,500);
        this.add(side, BorderLayout.WEST);
        this.add(queue, BorderLayout.CENTER);
        
        this.setSize(500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void acceptAcknowledge(Acknowledge a) {
        queue.acceptAcknowledge(a);
    }
    
    public void addRequest(Request r) {
        queue.addRequest(r);
    }    
}
