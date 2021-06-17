package gui.body;

import javax.swing.*;
import java.awt.*;

public abstract class Tab extends JPanel {

    public Tab() {
        super(new BorderLayout());
    }

    public abstract void display();

}
