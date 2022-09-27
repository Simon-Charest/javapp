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
        jLayeredPane.add(jLabel);

        // Frame
        setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 480);
        setTitle("JavApp");
        setLocationRelativeTo(null);
        setVisible(true);
        add(jLayeredPane);
    }

    private static JLabel createJLabel(String filename)
    {
        ImageIcon imageIcon = new ImageIcon(filename);
        JLabel jLabel = new JLabel(imageIcon, JLabel.LEFT);
        jLabel.setBackground(Color.RED);
        jLabel.setVerticalAlignment(JLabel.TOP);
        jLabel.setVisible(true);

        return jLabel;
    }

    private static JLayeredPane createJLayeredPane()
    {
        JLayeredPane jLayeredPane = new JLayeredPane();
        jLayeredPane.setBackground(Color.BLUE);
        jLayeredPane.setVisible(true);
        MouseListener mouseListener = new MouseAdapter()
        {
            public void mousePressed(MouseEvent mouseEvent)
            {
                JComponent jComponent = (JComponent)mouseEvent.getSource();
                TransferHandler transferHandler = jComponent.getTransferHandler();
                transferHandler.exportAsDrag(jComponent, mouseEvent, TransferHandler.COPY);
            }
        };
        jLayeredPane.addMouseListener(mouseListener);

        return jLayeredPane;
    }

    public static void main(String[] args)
    {
        System.out.println("** BEGIN **");

        Main app = new Main();
        app.setVisible(true);
    }
}
