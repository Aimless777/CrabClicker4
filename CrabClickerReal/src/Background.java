import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.awt.Color;

public class Background {
	private int x, y;
	private int size;
	private String fileName;
	private Image img;// the image of the log

	public Background(String fileName) {
		// assignment statements for attributes
		size = 800;
		x = 0;
		y = 0;
		img = getImage(fileName);
		init(x, y);
	}

	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);
	}

	public void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(7.83, 7.61); //7.83    7.61
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Background.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}