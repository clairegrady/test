package gui.card;

import controller.CardViewController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DefaultCard extends JPanel implements MouseListener {


    CardViewController cvc;

    public DefaultCard(String text, CardViewController cvc) {
        super();
        this.cvc = cvc;
        JLabel content = new JLabel(text);
        content.setHorizontalAlignment(JLabel.CENTER);
        this.setLayout(new GridLayout(1, 1));
        this.setPreferredSize((new Dimension(700, 100)));
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(8, 8, 8, 8));
        this.add(content);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("You clicked me");
        cvc.openJobManagement();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}