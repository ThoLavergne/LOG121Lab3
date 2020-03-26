package view;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel(){

        setBackground(Color.GREEN);
        setLayout(new BorderLayout());

        ImagePanel panel1 = new ImagePanel();
        ImagePanel panel2 = new ImagePanel();
        ImagePanel panel3 = new ImagePanel();

        panel1.setSize(new Dimension(100, 100));
        panel2.setSize(new Dimension(100, 100));
        panel3.setSize(new Dimension(100, 100));
        panel1.setBackground(Color.BLUE);
        panel2.setBackground(Color.RED);
        panel3.setBackground(Color.GREEN);
        panel1.setVisible(true);
        panel2.setVisible(true);
        panel3.setVisible(true);

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);

        setVisible(true);

    }
}
