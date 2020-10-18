import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

public class MainWindow extends JFrame{
    
    private MainQueue queue;
    private SideBar side;
    public static final int SIZE = 1000;
    
    public MainWindow() {
        side = new SideBar(this);
        queue = new MainQueue(this);
    }
    
    public void run() {
        side.setPreferredSize(new Dimension(SIZE/10,SIZE));
        side.setBorder(new LineBorder(Color.BLACK,1,true));
        this.add(side, BorderLayout.WEST);
        queue.setPreferredSize(new Dimension(9*SIZE/10,SIZE));
        queue.setBorder(new LineBorder(Color.BLACK,1,true));
        this.add(queue, BorderLayout.CENTER);
        
        this.setSize(SIZE,SIZE);
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
