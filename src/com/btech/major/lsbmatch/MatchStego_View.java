package com.btech.major.lsbmatch;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
//import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MatchStego_View extends JFrame {
	private static final long serialVersionUID = 1L;
	
	// variables for window
	private static int WIDTH = 500;
	private static int HEIGHT = 400;

	// elements for JPanel
	private JTextArea input;
	private JLabel message;
//	private JScrollBar scroll, scroll2;
	private JButton encodeButton, decodeButton;
	private JLabel image_input;

	// elements for Menu
//	private JMenu file;
	private JMenuItem encode;
	private JMenuItem decode;
	private JMenuItem exit;

	public MatchStego_View(String name) {
		// set the title of the JFrame
		super(name);

		// Menubar
		JMenuBar menu = new JMenuBar();

		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		encode = new JMenuItem("Encode");
		encode.setMnemonic('E');
		file.add(encode);
		decode = new JMenuItem("Decode");
		decode.setMnemonic('D');
		file.add(decode);
		file.addSeparator();
		exit = new JMenuItem("Exit");
		exit.setMnemonic('x');
		file.add(exit);

		menu.add(file);
		setJMenuBar(menu);

		// display rules
		setResizable(true); 
		setBackground(Color.lightGray); 
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}

	
	public JMenuItem getEncode() {
		return encode;
	}
	
	public JMenuItem getDecode() {
		return decode;
	}

	public JMenuItem getExit() {
		return exit;
	}

	public JTextArea getText() {
		return input;
	}

	public JLabel getImageInput() {
		return image_input;
	}

	public JPanel getTextPanel() {
		return new Text_Panel();
	}

	public JPanel getImagePanel() {
		return new Image_Panel();
	}

	public JButton getEButton() {
		return encodeButton;
	}

	public JButton getDButton() {
		return decodeButton;
	}

	private class Text_Panel extends JPanel {
		private static final long serialVersionUID = 1L;

	public Text_Panel() {
			GridBagLayout layout = new GridBagLayout();
			GridBagConstraints layoutConstraints = new GridBagConstraints();
			setLayout(layout);
			
			message = new JLabel("Enter Your Message below first");
			layoutConstraints.gridx = 0;
			layoutConstraints.gridy = 0;
			layoutConstraints.gridwidth = 1;
			layoutConstraints.gridheight = 1;
			layoutConstraints.fill = GridBagConstraints.BOTH;
			layoutConstraints.insets = new Insets(0, -5, -5, -5);
			layoutConstraints.anchor = GridBagConstraints.CENTER;
			layoutConstraints.weightx = 1.0;
			layoutConstraints.weighty = 1.0;
			layout.setConstraints(message, layoutConstraints);
			add(message);

			input = new JTextArea();
			layoutConstraints.gridx = 0;
			layoutConstraints.gridy = 1;
			layoutConstraints.gridwidth = 1;
			layoutConstraints.gridheight = 1;
			layoutConstraints.fill = GridBagConstraints.BOTH;
			layoutConstraints.insets = new Insets(0, 0, 0, 0);
			layoutConstraints.anchor = GridBagConstraints.CENTER;
			layoutConstraints.weightx = 1.0;
			layoutConstraints.weighty = 25.0;
			JScrollPane scroll = new JScrollPane(input,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			layout.setConstraints(scroll, layoutConstraints);
			scroll.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			add(scroll);

			encodeButton = new JButton("Encode Now");
			layoutConstraints.gridx = 0;
			layoutConstraints.gridy = 2;
			layoutConstraints.gridwidth = 1;
			layoutConstraints.gridheight = 1;
			layoutConstraints.fill = GridBagConstraints.BOTH;
			layoutConstraints.insets = new Insets(0, -5, -5, -5);
			layoutConstraints.anchor = GridBagConstraints.CENTER;
			layoutConstraints.weightx = 1.0;
			layoutConstraints.weighty = 1.0;
			layout.setConstraints(encodeButton, layoutConstraints);
			add(encodeButton);

			// set basic display
			setBackground(Color.lightGray);
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		}
	}

	/*
	 * Class Image_Panel
	 */
	private class Image_Panel extends JPanel {
		private static final long serialVersionUID = 1L;

		
		public Image_Panel() {
			GridBagLayout layout = new GridBagLayout();
			GridBagConstraints layoutConstraints = new GridBagConstraints();
			setLayout(layout);

			image_input = new JLabel();
			layoutConstraints.gridx = 0;
			layoutConstraints.gridy = 0;
			layoutConstraints.gridwidth = 1;
			layoutConstraints.gridheight = 1;
			layoutConstraints.fill = GridBagConstraints.BOTH;
			layoutConstraints.insets = new Insets(0, 0, 0, 0);
			layoutConstraints.anchor = GridBagConstraints.CENTER;
			layoutConstraints.weightx = 1.0;
			layoutConstraints.weighty = 50.0;
			JScrollPane scroll2 = new JScrollPane(image_input,
					JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			layout.setConstraints(scroll2, layoutConstraints);
			scroll2.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			image_input.setHorizontalAlignment(JLabel.CENTER);
			add(scroll2);

			decodeButton = new JButton("Decode Now");
			layoutConstraints.gridx = 0;
			layoutConstraints.gridy = 1;
			layoutConstraints.gridwidth = 1;
			layoutConstraints.gridheight = 1;
			layoutConstraints.fill = GridBagConstraints.BOTH;
			layoutConstraints.insets = new Insets(0, -5, -5, -5);
			layoutConstraints.anchor = GridBagConstraints.CENTER;
			layoutConstraints.weightx = 1.0;
			layoutConstraints.weighty = 1.0;
			layout.setConstraints(decodeButton, layoutConstraints);
			add(decodeButton);

			// set basic display
			setBackground(Color.lightGray);
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		}
	}

	
	public static void main(String args[]) {
		new MatchStego_View("LSB MATCH Steganography");
	}
}