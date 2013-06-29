import java.awt.*;
import java.awt.event.*;
class CanTes extends Frame{
  int s,x,y,t;
  class W extends WindowAdapter{
    public void windowClosing(WindowEvent e){System.exit(0);}
  }
  CanTes(){
    setSize(s=2*(x=y=t=300),s);
    addWindowListener(new W());
    add(new C());
    setVisible(1>0);
  }
  class C extends Canvas{
    C(){
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