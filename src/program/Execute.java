package program;

import view.MainWindow;

import javax.swing.*;
import java.awt.*;

public class Execute {

    public static void main(String[] args) {
        new Execute();
    }

    public Execute() {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            }

            MainWindow window = new MainWindow();
        });
    }
}
