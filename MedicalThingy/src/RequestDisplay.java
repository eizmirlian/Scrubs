import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class RequestDisplay extends JPanel{

    private Request request;
    
    public RequestDisplay(Request r) {
        request = r;
        
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(layout);
        setBorder(new LineBorder(Color.BLACK,1,true));
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 50;
        gbc.ipady = 50;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel nameLabel = new JLabel(request.getPatientName());
        add(nameLabel,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 5;
        gbc.ipady = 50;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Responder:"),gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.ipadx = 25;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel(request.getResponder()),gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.ipadx = 5;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Description:"),gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.ipadx = 25;
        gbc.anchor = GridBagConstraints.EAST;
        String descStr = request.getDesc();
        if(descStr.length() > 20) {
            descStr = descStr.substring(0,17) + "...";
        }
        add(new JLabel(descStr),gbc);
        setPreferredSize(new Dimension(9*MainWindow.SIZE/10,MainWindow.SIZE/10));
        setMaximumSize(new Dimension(9*MainWindow.SIZE/10,MainWindow.SIZE/5));
        setBackground(Color.LIGHT_GRAY);
    }
}
