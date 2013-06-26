import java.awt.*;
import java.awt.event.*;

class MyCan extends Canvas{
    int x,y;
    Image OI;
    Graphics OG;
    MyCan(){
        super();
        setSize(600,400);
        addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                x=e.getX();
                y=e.getY();
                repaint();
            }
            public void mouseMoved(MouseEvent e) {
                x=e.getX();
                y=e.getY();
                repaint();
            }
        });
    }
    public void update(Graphics g){
        paint(OG=(OI=createImage(600,400)).getGraphics());
        g.drawImage(OI,0,0,this);
    }
    public void paint(Graphics g){
        g.drawLine(300,200,x,y);
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
        setVisible(1>0);
    }

    static{
        new CanTes();
    }
}
