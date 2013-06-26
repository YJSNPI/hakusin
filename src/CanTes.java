import java.awt.*;
import java.awt.event.*;

class MyCan extends Canvas{
    int x,y;
    MyCan(){
        super();
        setSize(600,400);
        addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
            public void mouseMoved(MouseEvent e) {
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });
    }

    Image OI;
    Graphics OG;

    public void update(Graphics g){
        OI=createImage(600,400);
        OG=OI.getGraphics();
        paint(OG);
        g.drawImage(OI,0,0,this);
    }

    public void paint(Graphics g){
        g.drawLine(300,200,x,y);
    }
}

class CanTes extends Frame{
    class MyWin extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }
    CanTes(){
        super(" ");
        this.addWindowListener(new MyWin());
        add(new MyCan());
        setSize(getPreferredSize());
        setVisible(true);
    }

    static{
        new CanTes();
    }
}
