import java.awt.*;
import java.awt.event.*;

class MyCan extends Canvas{
    int x,y;
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
        OI=createImage(600,400);
        OG=OI.getGraphics();
        paint(OG);
        g.drawImage(OI,0,0,this);
    }

    public void paint(Graphics g){
        g.drawLine(300,200,me.getX(),me.getY());
    }
}

class CanTes extends Frame{
    class MyWin extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }
    CanTes(){
        super("");
        this.addWindowListener(new MyWin());
        add(new MyCan());
        setSize(getPreferredSize());
        setVisible(true);
    }

    static{
        new CanTes();
    }
}
