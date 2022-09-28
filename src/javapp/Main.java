package javapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame
{
    public Main()
    {
        JLabel jLabel = createJLabel("src/javapp/smiley.png");
        JLayeredPane jLayeredPane = createJLayeredPane();

        // Frame
        setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 480);
        setTitle("JavApp");
        setLocationRelativeTo(null);
        setVisible(true);

        // Grid
        setLayout(new GridLayout(3,3));
        add(jLabel);
        add(new JButton("2"));
        add(new JButton("3"));
        add(new JButton("4"));
        add(new JButton("5"));
        add(new JButton("6"));
        add(new JButton("7"));
        add(new JButton("8"));
        add(jLayeredPane);
    }

    private JLabel createJLabel(String filename)
    {
        ImageIcon imageIcon = new ImageIcon(filename);
        JLabel jLabel = new JLabel(imageIcon, JLabel.LEFT);
        jLabel.setBackground(Color.RED);
        jLabel.setVerticalAlignment(JLabel.TOP);
        jLabel.setVisible(true);
        MouseListener mouseListener = createMouseListener();
        jLabel.addMouseListener(mouseListener);
        jLabel.setTransferHandler(new TransferHandler("foreground"));

        return jLabel;
    }

    private JLayeredPane createJLayeredPane()
    {
        JLayeredPane jLayeredPane = new JLayeredPane();
        jLayeredPane.setBackground(Color.BLUE);
        jLayeredPane.setVisible(true);
        MouseListener mouseListener = createMouseListener();
        jLayeredPane.addMouseListener(mouseListener);
        jLayeredPane.setTransferHandler(new TransferHandler("foreground"));

        return jLayeredPane;
    }

    private MouseListener createMouseListener()
    {
        return new MouseAdapter()
        {
            public void mousePressed(MouseEvent mouseEvent)
            {
                JComponent jComponent = (JComponent)mouseEvent.getSource();
                TransferHandler transferHandler = jComponent.getTransferHandler();
                transferHandler.exportAsDrag(jComponent, mouseEvent, TransferHandler.COPY);
            }
        };
    }

    public static void main(String[] args)
    {
        System.out.println("** BEGIN **");

        Main main = new Main();
        main.setVisible(true);
    }
}
