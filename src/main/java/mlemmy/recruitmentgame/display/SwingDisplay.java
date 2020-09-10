package mlemmy.recruitmentgame.display;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class SwingDisplay implements Display {

    private final JTextPane textPane;

    public SwingDisplay(KeyListener keyListener) {
        textPane = new JTextPane();
        textPane.setPreferredSize(new Dimension(49 * 16, 23 * 16));
        textPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        textPane.setBackground(Color.BLACK);
        textPane.setForeground(Color.LIGHT_GRAY);
        textPane.setFocusable(false);

        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            }

            JFrame frame = new JFrame("recruitment game");
            frame.addKeyListener(keyListener);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.add(textPane);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    @Override
    public void write(String value) {
        textPane.setText(value);
    }

    @Override
    public void clear() {
        textPane.setText(null);
    }
}
