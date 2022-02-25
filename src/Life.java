import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Life extends JComponent {

  public static final int GRID_SIZE = 20;
  public static final int CELL_SIZE = 32;

  public static final int WIDTH = GRID_SIZE * CELL_SIZE + 1;
  public static final int HEIGHT = GRID_SIZE * CELL_SIZE + 1;

  public Life() {

    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

    JFrame frame = new JFrame("Conway's Game of Life | Thomas Carsello");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    JPanel controlPanel = new JPanel();
    controlPanel.setPreferredSize(new Dimension(WIDTH, 35));

    frame.add(this, BorderLayout.NORTH);
    frame.add(controlPanel, BorderLayout.SOUTH);
    frame.pack();

    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);

  }

  @Override
  public void paintComponent(Graphics g) {

    g.setColor(Color.BLACK);
    g.fillRect(0, 0, WIDTH, HEIGHT);

    g.dispose();

  }

  public static void main(String[] args) {

    new Life();

  }

}
