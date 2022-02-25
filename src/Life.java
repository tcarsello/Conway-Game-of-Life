import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Life extends JComponent implements ActionListener {

  public static final int GRID_SIZE = 20;
  public static final int CELL_SIZE = 32;

  public static final int WIDTH = GRID_SIZE * CELL_SIZE + 1;
  public static final int HEIGHT = GRID_SIZE * CELL_SIZE + 1;

  private boolean cells[][] =  new boolean[GRID_SIZE][GRID_SIZE];

  private JButton step = new JButton("Step");
  private JButton clear = new JButton("Clear");
  private JButton play = new JButton("Play");
  private JButton stop = new JButton("Stop");
  private JLabel timeLabel = new JLabel("Timer (ms):");
  private JTextField timeField = new JTextField(10);

  private int timer = 1000;

  public Life() {

    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {

        int row = e.getY() / CELL_SIZE;
        int col = e.getX() / CELL_SIZE;
        cells[row][col] = !cells[row][col];

        repaint();

      }
    });

    JFrame frame = new JFrame("Conway's Game of Life | Thomas Carsello");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    JPanel controlPanel = new JPanel();
    controlPanel.setPreferredSize(new Dimension(WIDTH, 35));

    timeField.setText("" + timer);
    timeField.addActionListener(this);
    step.addActionListener(this);
    clear.addActionListener(this);
    play.addActionListener(this);
    stop.addActionListener(this);

    controlPanel.add(step);
    controlPanel.add(clear);
    controlPanel.add(play);
    controlPanel.add(stop);
    controlPanel.add(timeLabel);
    controlPanel.add(timeField);

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

    for (int row = 0; row < GRID_SIZE; row++) {

      for (int col = 0; col < GRID_SIZE; col++) {

        g.setColor(Color.GRAY);
        g.drawRect(col * CELL_SIZE, row * CELL_SIZE, CELL_SIZE, CELL_SIZE);

        if (cells[row][col]) {
          g.setColor(Color.GREEN);
          g.fillRect(col * CELL_SIZE + 1, row * CELL_SIZE + 1, CELL_SIZE - 1, CELL_SIZE - 1);
        }

      }

    }

    g.dispose();

  }

  @Override
  public void actionPerformed(ActionEvent e) {

    Object source = e.getSource();
    System.out.println(source);

    if (source == step) {

    } else if (source == clear) {

    } else if (source == play) {

    } else if (source == stop) {

    } else if (source == timeField) {

    }

  }

  public static void main(String[] args) {

    new Life();

  }

}
