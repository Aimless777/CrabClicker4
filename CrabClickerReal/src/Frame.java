import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.geom.AffineTransform;

public class Frame extends JPanel implements ActionListener, MouseListener {
	 int screen_width = 800;
	 int screen_height = 800;
	 Crab crab;
	 Background bg;
	 private static int crabs;
	 Font font = new Font("Courier New", 1, 50);
	 
	public void countDown(Graphics g) {
		if (System.currentTimeMillis() < 1000) {
			g.drawString("1:00", 300, 500);
		}
	}
	 
	public void paint(Graphics g) {
		super.paintComponents(g);
		bg.paint(g);
		crab.paint(g);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("1:00", 325, 100);
	}
	
	public Frame() {
		JFrame f = new JFrame();
		f.setTitle("Crab Clicker");
		f.setSize(screen_width, screen_height);
		f.setResizable(true);
		f.addMouseListener(this);
		
		crab = new Crab("Better_Crab.png");
		bg = new Background("ccbg.png");	
		
		f.add(this);
		t = new Timer(17, this);
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
		System.out.println(e.getPoint());
        if (e.getX() >= crab.getX() && e.getX() <= (crab.getX() + crab.getSize()) && e.getY() >= crab.getY() && e.getY() <= (crab.getY() + crab.getSize()))
        {
        	System.out.println(crab.getSize());
        	crab.move();
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
	}
}
