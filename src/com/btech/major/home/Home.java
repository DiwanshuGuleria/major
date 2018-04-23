package com.btech.major.home;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.btech.major.eda.controllerEda;
import com.btech.major.lsb.Steganography_View;
import com.btech.major.lsb.controller;
import com.btech.major.lsbmatch.controllerMatch;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Home extends JFrame {

	private JPanel contentPane;
	private ButtonGroup bg=new ButtonGroup();
	private controller lsbView;
	private controllerEda edaView;
	private controllerMatch matchView;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(UIManager.getBorder("InternalFrame.border"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnLsb = new JRadioButton("LSB");
		rdbtnLsb.setFont(new Font("Dialog", Font.BOLD, 16));
		rdbtnLsb.setBounds(237, 97, 187, 23);
		contentPane.add(rdbtnLsb);
		rdbtnLsb.setSelected(false);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("EDGE ADAPTIVE");
		rdbtnNewRadioButton.setFont(new Font("Dialog", Font.BOLD, 16));
		rdbtnNewRadioButton.setBounds(237, 58, 187, 23);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(false);
		
		JRadioButton rdbtnLsbMatch = new JRadioButton("LSB MATCH");
		rdbtnLsbMatch.setFont(new Font("Dialog", Font.BOLD, 16));
		bg.add(rdbtnLsbMatch);
		rdbtnLsbMatch.setBounds(237, 140, 187, 23);
		contentPane.add(rdbtnLsbMatch);
		
		bg.add(rdbtnLsb);
		bg.add(rdbtnNewRadioButton);
		
		JButton btnGo = new JButton("Go");
		btnGo.setFont(new Font("Century Schoolbook L", Font.BOLD, 16));
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnLsb.isSelected()) {
					lsbView.main(null);
					
				}
				else if(rdbtnNewRadioButton.isSelected()) {
						edaView.main(null);
					
				}
				else if(rdbtnLsbMatch.isSelected()) {
					matchView.main(null);
				}
				else
					JOptionPane.showMessageDialog(null, "Please select a algorithm");
				
			}
		});
		btnGo.setBounds(122, 211, 204, 23);
		contentPane.add(btnGo);
		
		JLabel lblSelectTheTechnique = new JLabel("Select the Technique");
		lblSelectTheTechnique.setFont(new Font("Dialog", Font.BOLD, 17));
		lblSelectTheTechnique.setBounds(12, 79, 239, 41);
		contentPane.add(lblSelectTheTechnique);
		
		JLabel lblToImplement = new JLabel("to Implement");
		lblToImplement.setFont(new Font("Dialog", Font.BOLD, 17));
		lblToImplement.setBounds(46, 118, 177, 15);
		contentPane.add(lblToImplement);
		
		
		
	
	}
}
