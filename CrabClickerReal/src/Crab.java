import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;


public class Crab {
	private double scale = 1;
	private double size = 600;
	private int x, y;
	private String fileName;
	private Image img;


	public Crab(String fileName) {
		x = 63;
		y = 200;
		img = getImage(fileName);
		init(x, y);
	}
	
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Crab.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	public void move() {
		x = (int)(Math.random() * 500); 
		y = (int)(Math.random() * 500);
		scale = (Math.random() * .4) + .2; 
		size = 700 * scale;
		tx.setToTranslation(x, y);
		tx.scale(scale, scale);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
		tx.setToTranslation(x, y);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
		tx.setToTranslation(x, y);
	}
	
	public double getSize() {
		return size;
	}
}
