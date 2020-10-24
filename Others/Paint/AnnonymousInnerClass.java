package Paint;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
//<applet code="AnnonymousInnerClassDemo" width=500 height=500></applet>

public class AnnonymousInnerClass extends Applet {

    int x1, x2, y1, y2;

    public void init() {
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent me) {
                x1 = me.getX();
                y1 = me.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent me) {
                x2 = me.getX();
                y2 = me.getY();
                repaint();
            }
        });

    }

    public void update(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawLine(x1, y1, x2, y2);
        x1 = x2;
        y1 = y2;
        showStatus("" + x1 + "," + y1 + " " + x2 + "," + y2);
    }

    public void paint(Graphics g) {
        update(g);
    }

}