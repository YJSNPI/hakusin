import java.awt.*;
import java.awt.event.*;

class MyCan extends Canvas{
    int ex,ey;
    public MyCan(){
        super();
        setSize(600,400);
        addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                ex = e.getX();
                ey = e.getY();
                repaint();
            }
            public void mouseMoved(MouseEvent e) {
                ex = e.getX();
                ey = e.getY();
                repaint();
            }
        });
    }

    Image offScreenImage;
    Graphics offScreenGraphics;

    public void update(Graphics g){
        if(offScreenImage==null){
            offScreenImage=createImage(600,400);
            offScreenGraphics=offScreenImage.getGraphics();
        }
        paint(offScreenGraphics);
        g.drawImage(offScreenImage,0,0,this);
    }

    public void paint(Graphics g){
        g.clearRect(0,0,600,400);
        g.setColor(Color.black);
        g.drawLine(300,200,ex,ey);
    }
}

class CanvasTest extends Frame{
    MyCan Can;
    class MyWin extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }
    CanvasTest(){
        super(" ");
        this.addWindowListener(new MyWin());
        add(Can=new MyCan(),"South");
        setSize(getPreferredSize());
        setVisible(true);
    }

    static{
        new CanvasTest();
    }
}
