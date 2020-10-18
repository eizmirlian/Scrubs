import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RequestDisplay extends JPanel{

    private Request request;
    
    public RequestDisplay(Request r) {
        request = r;
        
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(layout);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        JLabel nameLabel = new JLabel(request.getPatientName());
        add(nameLabel,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Responder:"),gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(new JLabel(request.getResponder()),gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(new JLabel("Description:"),gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        String descStr = request.getDesc();
        if(descStr.length() > 20) {
            descStr = descStr.substring(0,17) + "...";
        }
        add(new JLabel(request.getDesc()),gbc);
        setSize(400,100);
    }
}
