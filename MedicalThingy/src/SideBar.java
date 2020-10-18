import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SideBar extends JPanel implements ActionListener{
    
    private MainWindow container;
    private JButton adder;
    private JButton settings;
    
    public SideBar(MainWindow inContainer) {
        
        container = inContainer;
        
        adder = new JButton("+");
        adder.setSize(100,100);
        adder.addActionListener(this);
        
        settings = new JButton("settings");
        settings.setSize(100,100);
        
        add(adder);
        add(settings);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
        setSize(100,500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == adder) {
            new RequestMaker(container);
        }
        
    }
}
