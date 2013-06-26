import java.awt.*;
import java.awt.event.*;

class MyCan extends Canvas{
    Image OI;
    Graphics OG;
    MouseEvent me;

    MyCan(){
        super();
        setSize(600,400);
        addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                me = e;
                repaint();
            }
            public void mouseMoved(MouseEvent e) {
                me = e;
                repaint();
            }
        });
    }

    public void update(Graphics g){
        OG=(OI=createImage(600,400)).getGraphics();
        paint(OG);
        g.drawImage(OI,0,0,this);
    }

    public void paint(Graphics g){
        g.drawLine(300,200,me.getX(),me.getY());
    }
}

class CanTes extends Frame{
    class MW extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }
    CanTes(){
        super("");
        this.addWindowListener(new MW());
        add(new MyCan());
        setSize(getPreferredSize());
        setVisible(true);
    }

    static{
        new CanTes();
    }
}
