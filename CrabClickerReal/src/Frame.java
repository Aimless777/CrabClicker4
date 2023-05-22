import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Frame extends JFrame implements ActionListener {
	JFrame frme = new JFrame("lol");
	Container contentPane = frme.getContentPane();
	private static long crabs;
	private static long crabsPerSecond;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Frame();
			}});
		}
	
	public Frame() {
		super("Cookie Clicker");
		int l = 100;
		int w = 100;
        crabs = 0;

        int lx = 300;
        int ly = 50;
        int sx = 140;
        int sy = 50;
        
        
        JLabel scoreLabel = new JLabel("Score: " + crabs);
        JButton cookieButton = new JButton("Click Me!");
        cookieButton.setPreferredSize(new Dimension(w, l));
        cookieButton.setBounds(100, 100, 50, 50);
        JButton cursorButton = new JButton("Buy Cursor!");
        cookieButton.setBounds(lx, ly, sx, sy);
        frme.add(cookieButton);
        cookieButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                crabs++;
                scoreLabel.setText("Score: " + crabs);
            }
        });

        setLayout(new FlowLayout());
        add(scoreLabel);
        add(cookieButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setVisible(true);
	

//		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
