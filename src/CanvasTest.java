// applet��Ȥ�����
import java.applet.*;
// AWT��Ȥ����ᡤ
import java.awt.*;
// ���٥�ȶ�ư�ط��Υ��饹���Ѥ��뤿��
import java.awt.event.*;
// Vector���饹���Ѥ��뤿��
import java.util.*;

// ��¦��Frame��ľ�� paint����ΤǤϤʤ�, �������ΰ���롥
class MyCanvas extends Canvas{
    int start_x,start_y,end_x,end_y;
	// Line��������ݻ�����Vector���饹���ѿ� lineArray�����
	// �ޥ�����ɥ�å��椫�ɤ����򼨤� boolean��(������)���ѿ�dragging�����
	boolean dragging;
	// ɽ�����뿧���ݻ������ѿ�
	Color lineColor;
	// ���󥹥ȥ饯�������
	public MyCanvas(){
		super();
		// �ɥ�å���ǤϤʤ�
		dragging=false;
		// ���ο��Ϲ���
		lineColor=Color.black;
		// GUI���ʤȡ�Event Listener���Ϣ�Ť���
		setSize(600,400);
		addMouseMotionListener(new MML());
	}

	Image offScreenImage;
	Graphics offScreenGraphics;

    public void update(Graphics g){
		if(offScreenImage==null){
			offScreenImage=createImage(600,400); // ���ե����꡼�󥤥᡼����600x400�Υ������Ǻ���
			offScreenGraphics=offScreenImage.getGraphics(); // ���ե����꡼�󥤥᡼�������褹�뤿��� Graphics ���֥�������
		}
		paint(offScreenGraphics); // ���β��̤Υ��᡼�����롥
		g.drawImage(offScreenImage,0,0,this); // ���᡼������ʪ�Υ����꡼��˽񤭹���
	}
	// offScreenImage�ν�ľ���򤹤�ݤ˸ƤФ��
	public void paint(Graphics g){
		int i;
		// ���(0,0)-(600,400)���ɤ��٤�
		g.setColor(Color.white);
		g.fillRect(0,0,600,400);
		// ��������
		g.setColor(lineColor);

			// �֤�����
			g.setColor(Color.red);
			// lines[lineCount] �����褹�롥
			g.drawLine(300,200,end_x,end_y);
	}


	class MML extends MouseMotionAdapter{
		// MouseMotionListener��������뤿��Υ᥽�å�
		public void mouseDragged(MouseEvent e){
			// �ޥ�����������ΰ��֤�����
			int mx=e.getX(),my=e.getY();
			end_x=mx;
			end_y=my;
			// ��ɽ���򤪤��ʤ�
			repaint();
		}

        public void mouseMoved(MouseEvent e){
            end_x = e.getX();
            end_y = e.getY();
            repaint();
        }
	}
}

class CanvasTest extends Frame{
	MyCanvas myCanvas;

	class MyWindow extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}

	CanvasTest(){
		super("CanvasTest");
		this.addWindowListener(new MyWindow());
		// ������ MyCanbas�����֤��롥
		add(myCanvas=new MyCanvas(),"South");
		// ���ʤ򤪤����Τ�Ŭ���Ȼפ��륵�����ˤ��롥
		setSize(getPreferredSize());
		setVisible(true);
	}

	public static void main(String args[]) {
		new CanvasTest();
	}
}
