package systemanalysis;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class imglog extends JPanel {
  
    
    private ImageIcon i;

    public imglog() {
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        i = new ImageIcon(getClass().getResource("login-a.jpg"));
        i.paintIcon(this, g, 0, 0);
    }

}
