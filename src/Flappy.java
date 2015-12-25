import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;


public class Flappy extends Applet implements KeyListener, Runnable {
	
	private Image bird, image, background;
	private URL base;
	private Graphics second;
	private Bird flappybird;
	
	private static background bg1, bg2;
	
	public void init() {
		setSize(800, 480);		//screen size
		setBackground(Color.WHITE);
		setFocusable(true);
		addKeyListener(this);
		Frame frame = (Frame)this.getParent().getParent();
		frame.setTitle("Flappy Bird");
		
		try{
			base = getDocumentBase();
		}catch(Exception e) {
			
		}
		
		bird = getImage(base, "pics/Flappy.PNG");
		background = getImage(base, "pics/background.png");
	}

	public Flappy() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		while (true) {
			flappybird.update();
			bg1.update();
			bg2.update();
			repaint();
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void start() {
		bg1 = new background(0,0);
		bg2 = new background(2160, 0);
		flappybird = new Bird();
		Thread thread = new Thread(this);
		thread.start();
	}
	
	public static background getBg1() {
		return bg1;
	}

	public static void setBg1(background bg1) {
		Flappy.bg1 = bg1;
	}

	public static background getBg2() {
		return bg2;
	}

	public static void setBg2(background bg2) {
		Flappy.bg2 = bg2;
	}

	public void update(Graphics g) {		//implements double buffering system, ignore for now	
		if(image == null) {
			image = createImage(this.getWidth(), this.getHeight());
			second = image.getGraphics();
		}
		
		second.setColor(getBackground());
		second.fillRect(0, 0, getWidth(), getHeight());
		second.setColor(getForeground());
		paint(second);
		
		g.drawImage(image, 0, 0, this);
	}

	public void paint(Graphics g) {
		g.drawImage(background, bg1.getBgX(), bg1.getBgY(), this);
		g.drawImage(background, bg2.getBgX(), bg2.getBgY(), this);
		
		g.drawImage(bird, flappybird.getCenterX(), flappybird.getCenterY(), this);
	}
}
