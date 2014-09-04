package jframe_no_decoration;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;

import javax.swing.*;


public class Jframe_no_decoration {
	
	public static void main(String[] args) {
		
		
		//looking into swingutilities and canvas to make sure both methods work together.
		SwingUtilities.invokeLater(new Runnable(){
			public void run() {
		
		JFrame frame = new JFrame ();
		JPanel panel = (JPanel)frame.getContentPane();
		
		addKeyBindToComponent(panel, "ESCAPE", "random");
		
		
		int FrameWidth = 400;
		int FrameHeight = 350;
		// setBounds() allowed me to set frame in the center of the screen and decided not to use .setSize()
		frame.setBounds(0,0, FrameWidth, FrameHeight);
		
		
		// frame.setLayout(new GridBagLayout()); optional will be using Canvas
        // frame.add(new JLabel("Type Esc to exit")); Timer, FadingLabel, Fader.FadeMode(jmonkeyengine).
		
		
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		
		// setLocationRelativeTo() gets x y coordinate from setBounds() to center frame on screen.
		frame.setLocationRelativeTo(null);
		
		frame.setUndecorated(true);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.black);
		
		
		
		
		}	
	});
	
}	// keyBinding information listed in the comments. 
	
	private static void addKeyBindToComponent( JComponent component, String key, String identifier) {
			
			InputMap keyboardmap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			keyboardmap.put(KeyStroke.getKeyStroke(key), identifier);
			
			ActionMap framemap = component.getActionMap();
			framemap.put(identifier, new AbstractAction(){
				
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
			
		});
	
	}
		

	
}
