import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SideBar extends JPanel implements ActionListener{
    
    private MainWindow container;
    private JButton adder;
    
    public SideBar(MainWindow inContainer) {
        
        container = inContainer;
        
        adder = new JButton("+");
        adder.setPreferredSize(new Dimension(MainWindow.SIZE/10,MainWindow.SIZE/10));
        adder.setMinimumSize(new Dimension(MainWindow.SIZE/10,MainWindow.SIZE/10));
        adder.setMaximumSize(new Dimension(MainWindow.SIZE/10,MainWindow.SIZE/10));
        adder.addActionListener(this);
        add(adder);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
        this.setBackground(Color.CYAN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == adder) {
            new RequestMaker(container);
        }
        
    }
}
