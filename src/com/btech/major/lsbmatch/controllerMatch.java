package com.btech.major.lsbmatch;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class controllerMatch {
	// Program Variables
	private MatchStego_View view;
	private MatchStego model;

	// Panel Displays
	private JPanel decode_panel;
	private JPanel encode_panel;
	// Panel Variables
	private JTextArea input;
	private JButton encodeButton, decodeButton;
	private JLabel image_input;
	// Menu Variables
	private JMenuItem encode;
	private JMenuItem decode;
	private JMenuItem exit;

	// action event classes
	private Encode enc;
	private Decode dec;
	private EncodeButton encButton;
	private DecodeButton decButton;

	// decode variable
	private String stat_path = "";
	private String stat_name = "";


	public controllerMatch(MatchStego_View aView,
			MatchStego aModel) {
		// program variables
		view = aView;
		model = aModel;

		// assign View Variables
		// 2 views
		encode_panel = view.getTextPanel();
		decode_panel = view.getImagePanel();
		// 2 data options
		input = view.getText();
		image_input = view.getImageInput();
		// 2 buttons
		encodeButton = view.getEButton();
		decodeButton = view.getDButton();
		// menu
		encode = view.getEncode();
		decode = view.getDecode();
		exit = view.getExit();

		// assign action events
		enc = new Encode();
		encode.addActionListener(enc);
		dec = new Decode();
		decode.addActionListener(dec);
		exit.addActionListener(new Exit());
		encButton = new EncodeButton();
		encodeButton.addActionListener(encButton);
		decButton = new DecodeButton();
		decodeButton.addActionListener(decButton);

		// encode view as default
		encode_view();
	}

	private void encode_view() {
		update();
		view.setContentPane(encode_panel);
		view.setVisible(true);
	}

	private void decode_view() {
		update();
		view.setContentPane(decode_panel);
		view.setVisible(true);
	}

	private class Encode implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			encode_view(); // show the encode view
		}
	}

	private class Decode implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			decode_view(); // show the decode view

			// start path of displayed File Chooser
			JFileChooser chooser = new JFileChooser("./");
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooser.setFileFilter(new Image_FilterMatch());
			int returnVal = chooser.showOpenDialog(view);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File directory = chooser.getSelectedFile();
				try {
					String image = directory.getPath();
					stat_name = directory.getName();
					stat_path = directory.getPath();
					stat_path = stat_path.substring(0, stat_path.length()
							- stat_name.length() - 1);
					stat_name = stat_name.substring(0, stat_name.length() - 4);
					image_input.setIcon(new ImageIcon(ImageIO.read(new File(
							image))));
				} catch (Exception except) {
					// msg if opening fails
					JOptionPane.showMessageDialog(view,
							"The File cannot be opened!", "Error!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	private class Exit implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			System.exit(0); // exit the program
		}
	}

	private class EncodeButton implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			// start path of displayed File Chooser
			JFileChooser chooser = new JFileChooser("./");
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooser.setFileFilter(new Image_FilterMatch());
			int returnVal = chooser.showOpenDialog(view);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File directory = chooser.getSelectedFile();
				try {
					String text = input.getText();
					String ext = Image_FilterMatch.getExtension(directory);
					String name = directory.getName();
					String path = directory.getPath();
					path = path.substring(0, path.length() - name.length() - 1);
					name = name.substring(0, name.length() - 4);

					String stegan = JOptionPane.showInputDialog(view,
							"Enter output file name:", "File name",
							JOptionPane.PLAIN_MESSAGE);

					if (model.encode(path, name, ext, stegan, text)) {
						JOptionPane.showMessageDialog(view,
								"The Image was encoded Successfully!",
								"Success!", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(view,
								"The Image could not be encoded!", "Error!",
								JOptionPane.INFORMATION_MESSAGE);
					}
					// display the new image
					decode_view();
					image_input.setIcon(new ImageIcon(ImageIO.read(new File(
							path + "/" + stegan + ".png"))));
				} catch (Exception except) {
					// msg if opening fails
					JOptionPane.showMessageDialog(view,
							"The File cannot be opened!", "Error!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

	}
	private class DecodeButton implements ActionListener {
		/*
		 * handles the click event
		 * 
		 * @param e The ActionEvent Object
		 */
		public void actionPerformed(ActionEvent e) {
			String message = model.decode(stat_path, stat_name);
			System.out.println(stat_path + ", " + stat_name);
			if (message != "") {
				encode_view();
				JOptionPane.showMessageDialog(view,
						"The Image was decoded Successfully!", "Success!",
						JOptionPane.INFORMATION_MESSAGE);
				input.setText(message);
			} else {
				JOptionPane.showMessageDialog(view,
						"The Image could not be decoded!", "Error!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public void update() {
		input.setText(""); // clear textarea
		image_input.setIcon(null); // clear image
		stat_path = ""; // clear path
		stat_name = ""; // clear name
	}

	public static void main(String args[]) {
		new controllerMatch(new MatchStego_View("LSB MATCH Steganography"),
				new MatchStego());
	}
}
