import java.awt.*;
import java.awt.event.*;
class CanTes extends Frame{
    int s=600,x,y,t=300;
    class W extends WindowAdapter{
        public void windowClosing(WindowEvent e){System.exit(0);}
    }
    CanTes(){
        addWindowListener(new W());
        add(new C());
        setSize(s,s);
        setVisible(1>0);
    }
    class C extends Canvas{
        C(){
            x=y=t;
            addMouseMotionListener(new MouseMotionListener(){
                public void mouseDragged(MouseEvent e){
                    x=e.getX();y=e.getY();
                    repaint();
                }
                public void mouseMoved(MouseEvent e){
                    x=y=t;
                    repaint();
                }
            });
        }
        public void paint(Graphics g){
            g.clearRect(0,0,s,s);
            g.drawLine(t,t,x,y);
        }
    }
    public static void main(String[] a){
        new CanTes();
    }
}
