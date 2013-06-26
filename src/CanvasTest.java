// appletを使うため
import java.applet.*;
// AWTを使うため，
import java.awt.*;
// イベント駆動関係のクラスを用いるため
import java.awt.event.*;
// Vectorクラスを用いるため
import java.util.*;

// 外側のFrameに直接 paintするのではなく, お絵書き領域を作る．
class MyCanvas extends Canvas{
    int start_x,start_y,end_x,end_y;
	// Lineの配列を保持するVectorクラスの変数 lineArrayの宣言
	// マウスをドラッグ中かどうかを示す boolean型(真偽値)の変数draggingの宣言
	boolean dragging;
	// 表示する色を保持する変数
	Color lineColor;
	// コンストラクタの宣言
	public MyCanvas(){
		super();
		// ドラッグ中ではない
		dragging=false;
		// 線の色は黒に
		lineColor=Color.black;
		// GUI部品と，Event Listenerを関連づける
		setSize(600,400);
		addMouseMotionListener(new MML());
	}

	Image offScreenImage;
	Graphics offScreenGraphics;

    public void update(Graphics g){
		if(offScreenImage==null){
			offScreenImage=createImage(600,400); // オフスクリーンイメージを600x400のサイズで作成
			offScreenGraphics=offScreenImage.getGraphics(); // オフスクリーンイメージに描画するための Graphics オブジェクト
		}
		paint(offScreenGraphics); // 次の画面のイメージを作る．
		g.drawImage(offScreenImage,0,0,this); // イメージを本物のスクリーンに書き込む
	}
	// offScreenImageの書き直しをする際に呼ばれる
	public void paint(Graphics g){
		int i;
		// 白で(0,0)-(600,400)を塗り潰す
		g.setColor(Color.white);
		g.fillRect(0,0,600,400);
		// 色を設定
		g.setColor(lineColor);

			// 赤い色で
			g.setColor(Color.red);
			// lines[lineCount] を描画する．
			g.drawLine(300,200,end_x,end_y);
	}


	class MML extends MouseMotionAdapter{
		// MouseMotionListenerを実装するためのメソッド
		public void mouseDragged(MouseEvent e){
			// マウスカーソルの位置を得る
			int mx=e.getX(),my=e.getY();
			end_x=mx;
			end_y=my;
			// 再表示をおこなう
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
		// 下部に MyCanbasを配置する．
		add(myCanvas=new MyCanvas(),"South");
		// 部品をおさめるのに適当と思われるサイズにする．
		setSize(getPreferredSize());
		setVisible(true);
	}

	public static void main(String args[]) {
		new CanvasTest();
	}
}
