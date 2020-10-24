package Paint;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
// <applet code="AdapterDemo" width=500 height=500></applet>

public class Adapter_Class extends Applet {

    int x1, x2, y1, y2;

    public void init() {
        addMouseListener(new MyMouseAdapter(this));
        addMouseMotionListener(new MyMouseMotionAdapter(this));
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

class MyMouseAdapter extends MouseAdapter {
    AdapterDemo d;

    public MyMouseAdapter(AdapterDemo d) {
        this.d = d;
    }

    public void mousePressed(MouseEvent me) {
        d.x1 = me.getX();
        d.y1 = me.getY();
    }

}

class MyMouseMotionAdapter extends MouseMotionAdapter {

    AdapterDemo d;

    public MyMouseMotionAdapter(AdapterDemo d) {
        this.d = d;
    }

    public void mouseDragged(MouseEvent me) {
        d.x2 = me.getX();
        d.y2 = me.getY();
        d.repaint();
    }

}