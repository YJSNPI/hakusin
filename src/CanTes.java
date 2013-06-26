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

    Image offImage;
    Graphics offGraphics;

    public void update(Graphics g){
        if(offImage==null){
            offImage=createImage(600,400);
            offGraphics=offImage.getGraphics();
        }
        paint(offGraphics);
        g.drawImage(offImage,0,0,this);
    }

    public void paint(Graphics g){
        g.clearRect(0,0,600,400);
        g.setColor(Color.red);
        g.drawLine(300,200,x,y);
    }
}

class CanTes extends Frame{
    MyCan Can;
    class MyWin extends WindowAdapter{
        public void windowClosing(WindowEvent e){
            System.exit(0);
        }
    }
    CanTes(){
        super(" ");
        this.addWindowListener(new MyWin());
        add(Can=new MyCan());
        setSize(getPreferredSize());
        setVisible(true);
    }

    static{
        new CanTes();
    }
}
