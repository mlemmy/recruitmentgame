package mlemmy.recruitmentgame.display;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class SwingDisplay implements Display {

    public static final String TITLE = "recruitment game";

    private final JTextPane textPane;

    public SwingDisplay(KeyListener keyListener) {
        textPane = new JTextPane();
        textPane.setPreferredSize(new Dimension(49 * 16, 35 * 16));
        textPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 16));
        textPane.setBackground(Color.BLACK);
        textPane.setForeground(Color.LIGHT_GRAY);
        textPane.setFocusable(false);

        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame(TITLE);
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
