import java.awt.BorderLayout;
import java.awt.Color;

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
        side.setSize(200,1000);
        this.add(side, BorderLayout.WEST);
        queue.setSize(800,1000);
        
        this.add(queue, BorderLayout.CENTER);
        
        this.setSize(1000,1000);
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
