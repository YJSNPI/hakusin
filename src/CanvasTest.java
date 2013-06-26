import java.awt.*;
import java.awt.event.*;

class MyCan extends Canvas{
    int end_x,end_y;
    public MyCan(){
        super();
        setSize(600,400);
        addMouseMotionListener(new MML());
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
        g.drawLine(300,200,end_x,end_y);
    }

    class MML extends MouseMotionAdapter{
        public void mouseMoved(MouseEvent e){
            end_x = e.getX();
            end_y = e.getY();
            repaint();
        }
    }
}

class CanvasTest extends Frame{
    MyCan myCan;
    class MyWin extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }

    CanvasTest(){
        super(" ");
        this.addWindowListener(new MyWin());
        add(myCan=new MyCan(),"South");
        setSize(getPreferredSize());
        setVisible(true);
    }

    public static void main(String args[]) {
        new CanvasTest();
    }
}
