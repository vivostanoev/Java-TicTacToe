package display;

import javax.swing.*;
import java.awt.*;

public class Display {

    private Canvas canvas;
    private JFrame frame;

    public Display(String name, int width, int height) {
        this.frame = new JFrame(name);
        this.frame.setPreferredSize(new Dimension(width, height));
        this.frame.setMaximumSize(new Dimension(width, height));
        this.frame.setMinimumSize(new Dimension(width, height));
        this.frame.setVisible(true);
        this.frame.setFocusable(true);
        this.frame.setResizable(false);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null); // - Set window in center.
        
        this.canvas = new Canvas();
        this.canvas.setPreferredSize(new Dimension(width, height));
        this.canvas.setMaximumSize(new Dimension(width, height));
        this.canvas.setMinimumSize(new Dimension(width, height));
        this.canvas.setFocusable(true);

        this.frame.add(this.canvas);    // - Add the canvas into the frame
        this.frame.pack();  // - Pack the frame to ensure visibility

    }
    public Canvas getCanvas() {
        return canvas;
    }
}
