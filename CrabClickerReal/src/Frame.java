import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Frame extends JFrame implements ActionListener {

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

        crabs = 0;

        JLabel scoreLabel = new JLabel("Score: " + crabs);
        JButton cookieButton = new JButton("Click Me!");
        cookieButton.setBounds(100, 100, 400, 400);
        JButton cursorButton = new JButton("Buy Cursor!");

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
