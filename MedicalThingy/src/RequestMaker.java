import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class RequestMaker extends JFrame implements ActionListener{

    String patient;
    String desc;
    String responder;
    JTextField patientName;
    JTextField descName;
    JTextField responderName;
    MainWindow container;
    
    public RequestMaker(MainWindow inContainer) {
        container = inContainer;
        patient = "";
        desc = "";
        responder = "";
        patientName = new JTextField();
        descName = new JTextField();
        responderName = new JTextField();
        JPanel panel = new JPanel();
        
        panel.add(new JLabel("Patient Name:"));
        patientName = new JTextField();
        panel.add(patientName);
        
        panel.add(new JLabel("Task Description:"));
        descName = new JTextField();
        panel.add(descName);
        
        panel.add(new JLabel("Responder Name:"));
        responderName = new JTextField();
        panel.add(responderName);
        
        JButton requestButton = new JButton("Make Request");
        requestButton.addActionListener(this);
        panel.add(requestButton);
        
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setVisible(true);
        add(panel);
        pack();
        setSize(500,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(patientName.getText().equals("") || responderName.getText().equals("")) {
            System.out.println(responderName.getText());
            System.out.println("Not Working");
            return;
        }
        container.addRequest(new Request(patientName.getText(), descName.getText(), responderName.getText()));
        System.out.println("Sent Request");
        JComponent comp = (JComponent) e.getSource();
        Window win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }
    
}
