import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private int WIDTH = 1000;
    private int HEIGHT = 800;

    private DrawPanel drawingPanel = new DrawPanel();

    private JTextField x1Input = new JTextField(21);
    private JTextField y1Input = new JTextField(21);
    private JTextField x2Input = new JTextField(21);
    private JTextField y2Input = new JTextField(21);
    private JTextField radiusInput = new JTextField(21);

    private JButton stepByStepButton;
    private JButton DADButton;
    private JButton brezenkhemButton;
    private JButton brezenkhemCircleButton;
    private JButton clearButton;

    private final double PANEL_SCALE_W = 0.7;
    private final double PANEL_SCALE_H = 0.7;

    private Algorithm algorithm = new Algorithm();

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setLayout(null);

        drawingPanel.setBounds((int) ((1 - PANEL_SCALE_W) * WIDTH), 10, (int) (PANEL_SCALE_W * WIDTH), (int) (PANEL_SCALE_H * HEIGHT));
        add(drawingPanel);


        Font labelFont = new Font("Serif", Font.PLAIN, 25);

        JLabel timeLabel = new JLabel("Время:");
        timeLabel.setFont(labelFont);
        timeLabel.setBounds(10, 500, 150, 40);
        add(timeLabel);


        stepByStepButton = new JButton("Шаг за шагом");

        stepByStepButton.setBounds(10, 10, 240, 40);
        stepByStepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
                try {
                    x1 = Integer.parseInt(x1Input.getText());
                    y1 = Integer.parseInt(y1Input.getText());
                    x2 = Integer.parseInt(x2Input.getText());
                    y2 = Integer.parseInt(y2Input.getText());
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                drawingPanel.drawPoints(algorithm.stepByStep(x1, y1, x2, y2));
                timeLabel.setText("Time: " + algorithm.lastTime / 1000 + " ms");
            }
        });
        add(stepByStepButton);

        DADButton = new JButton("ЦДА");
        DADButton.setBounds(10, 60, 240, 40);
        DADButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
                try {
                    x1 = Integer.parseInt(x1Input.getText());
                    y1 = Integer.parseInt(y1Input.getText());
                    x2 = Integer.parseInt(x2Input.getText());
                    y2 = Integer.parseInt(y2Input.getText());
                } catch (Exception ex) {

                }
                drawingPanel.drawPoints(algorithm.cda(x1, y1, x2, y2));
                timeLabel.setText("Time: " + algorithm.lastTime / 1000 + " ms");

            }
        });
        add(DADButton);

        brezenkhemButton = new JButton("Брезенхем");
        brezenkhemButton.setBounds(10, 110, 240, 40);
        brezenkhemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
                try {
                    x1 = Integer.parseInt(x1Input.getText());
                    y1 = Integer.parseInt(y1Input.getText());
                    x2 = Integer.parseInt(x2Input.getText());
                    y2 = Integer.parseInt(y2Input.getText());
                } catch (Exception ex) {

                }
                drawingPanel.drawPoints(algorithm.brezenkhem(x1, y1, x2, y2));
                timeLabel.setText("Time: " + algorithm.lastTime / 1000 + " ms");

            }
        });
        add(brezenkhemButton);

        brezenkhemCircleButton = new JButton("Брезенхем (окружность)");
        brezenkhemCircleButton.setBounds(10, 160, 240, 40);
        brezenkhemCircleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x1 = 0, y1 = 0, r = 0;
                try {
                    x1 = Integer.parseInt(x1Input.getText());
                    y1 = Integer.parseInt(y1Input.getText());
                    r = Integer.parseInt(radiusInput.getText());
                } catch (Exception ex) {

                }
                drawingPanel.drawPoints(algorithm.brezenkhemCircle(x1, y1, r));
                timeLabel.setText("Время: " + algorithm.lastTime / 1000 + " ms");
            }
        });
        add(brezenkhemCircleButton);

        clearButton = new JButton("Очистить");
        clearButton.setBounds(10, 550, 240, 40);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawingPanel.drawPoints(new ArrayList<Point>());
            }
        });

        add(clearButton);

        JLabel x1Label = new JLabel("x 1: ");
        x1Label.setFont(labelFont);
        x1Label.setBounds(10, 250, 50, 40);
        add(x1Label);

        x1Input.setBounds(70, 250, 100, 40);
        x1Input.setFont(labelFont);
        add(x1Input);

        JLabel y1Label = new JLabel("y 1: ");
        y1Label.setFont(labelFont);
        y1Label.setBounds(10, 300, 50, 40);
        add(y1Label);

        y1Input.setBounds(70, 300, 100, 40);
        y1Input.setFont(labelFont);
        add(y1Input);


        JLabel x2Label = new JLabel("x 2: ");
        x2Label.setFont(labelFont);
        x2Label.setBounds(10, 350, 50, 40);
        add(x2Label);

        x2Input.setBounds(70, 350, 100, 40);
        x2Input.setFont(labelFont);
        add(x2Input);


        JLabel y2Label = new JLabel("y 2: ");
        y2Label.setFont(labelFont);
        y2Label.setBounds(10, 400, 50, 40);
        add(y2Label);

        y2Input.setBounds(70, 400, 100, 40);
        y2Input.setFont(labelFont);
        add(y2Input);

        JLabel radiusLabel = new JLabel("радиус: ");
        radiusLabel.setFont(labelFont);
        radiusLabel.setBounds(10, 450, 100, 40);
        add(radiusLabel);

        radiusInput.setBounds(100, 450, 100, 40);
        radiusInput.setFont(labelFont);
        add(radiusInput);


        setResizable(false);
    }


    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.repaint();
    }
}
