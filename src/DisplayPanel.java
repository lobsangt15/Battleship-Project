import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayPanel extends JPanel {

    private JButton button;

    public DisplayPanel() {
        button = new JButton("Shop");
        add(button);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // always put this

        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.setColor(Color.RED);


        g.drawString("Welcome to Battleship!", 50, 30);
        button.setLocation(50, 100);
    }

    public void actionPerformed(ActionEvent e) {
        ;
    }
}
