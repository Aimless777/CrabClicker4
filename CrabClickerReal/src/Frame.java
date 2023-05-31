import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.geom.AffineTransform;
import java.util.concurrent.TimeUnit;

public class Frame extends JPanel implements ActionListener, MouseListener {
	 int screen_width = 800;
	 int screen_height = 800;
	 Crab crab;
	 Background bg;
	 private static int crabs;
	 Font font = new Font("Courier New", 1, 100);
	 Font font2 = new Font("Courier New", 1, 20);
	 Font font3 = new Font("Goudy Old Style", 1, 30);
	 public int numSeconds = 59;
	 public static int numClicks = 0;
	 public static int numCrabs = -1;
	 
	public void countDown(Graphics g) throws InterruptedException {
		crab.move();
		TimeUnit.SECONDS.sleep(1);
		if (numSeconds >= 10) {
			g.drawString("0:" + Integer.toString(numSeconds), 270, 100);
		} else if(numSeconds < 10) {
			g.drawString("0:0" + Integer.toString(numSeconds), 270, 100);
		}
		numSeconds--;
	}
	 
	public void paint(Graphics g) {
		super.paintComponents(g);
		bg.paint(g);
		if (numSeconds >= 0) {
			crab.paint(g);
		}
		g.setColor(Color.white);
		if (numClicks == 0) {
			AffineTransform affineTransform = new AffineTransform();
			affineTransform.rotate(Math.toRadians(10), 0, 0);
			Font rotatedFont = font2.deriveFont(affineTransform);
			g.setFont(rotatedFont);
			g.drawString("Click the crab", 500, 640);
		}
		g.setFont(font);
		if (numClicks == 0 && numSeconds == 59) {
			g.drawString("1:00", 270, 100);	
		}
		if (numClicks > 0) {	
			try {
				if (numSeconds >= 0) {
					countDown(g);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		if (numClicks == 1 && numSeconds == -1) {
			g.drawString("1:00", 270, 100);
		}
		g.setFont(font3);
		if (numCrabs == -1) {
			g.drawString("Crab Count: " + Integer.toString(numCrabs + 1), 20, 740);
		} else {
			g.drawString("Crab Count: " + Integer.toString(numCrabs), 20, 740);
		}
	}
	
	public Frame() {
		JFrame f = new JFrame();
		f.setTitle("Crab Clicker");
		f.setSize(screen_width, screen_height);
		f.setResizable(false);
		f.addMouseListener(this);
		
		crab = new Crab("Better_Crab.png");
		bg = new Background("ccbg.png");	
		
		f.add(this);
		t = new Timer(1, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
        
        
	}
	
	Timer t;
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
        if (e.getX() >= crab.getX() && e.getX() <= (crab.getX() + crab.getSize()) && e.getY() >= crab.getY() && e.getY() <= (crab.getY() + crab.getSize()))
        {
        	numCrabs++;
        	if (numClicks == 0) {
        		numClicks++;
        	}
        }
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
	}
}
