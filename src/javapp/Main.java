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
        add(jLayeredPane);
        add(jLabel);
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

        return jLabel;
    }

    private JLayeredPane createJLayeredPane()
    {
        JLayeredPane jLayeredPane = new JLayeredPane();
        jLayeredPane.setBackground(Color.BLUE);
        jLayeredPane.setVisible(true);
        MouseListener mouseListener = createMouseListener();
        jLayeredPane.addMouseListener(mouseListener);

        return jLayeredPane;
    }

    private MouseListener createMouseListener()
    {
        MouseListener mouseListener = new MouseAdapter()
        {
            public void mousePressed(MouseEvent mouseEvent)
            {
                JComponent jComponent = (JComponent)mouseEvent.getSource();
                TransferHandler transferHandler = jComponent.getTransferHandler();
                transferHandler.exportAsDrag(jComponent, mouseEvent, TransferHandler.COPY);
            }
        };

        return mouseListener;
    }

    public static void main(String[] args)
    {
        System.out.println("** BEGIN **");

        Main main = new Main();
        main.setVisible(true);
    }
}
