import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;


public class odabirTezineCheckBox extends Canvas implements ActionListener{
	JLabel titleLabel = new JLabel();
	JLabel glavaLabel = new JLabel();
	JLabel tijeloLabel = new JLabel();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JFrame frame = new JFrame();
	JCheckBox border = new JCheckBox();
	JCheckBox contact = new JCheckBox();
	JButton submitButton = new JButton();
	JButton refreshButton = new JButton();
	
	JButton glava = new JButton();
	JLabel rGlava = new JLabel();
	JLabel gGlava = new JLabel();
	JLabel bGlava = new JLabel();
	
	JButton tijelo = new JButton();
	JLabel rTijelo = new JLabel();
	JLabel gTijelo = new JLabel();
	JLabel bTijelo = new JLabel();
	
	JSlider sliderRGlava = new JSlider();  
	JSlider sliderGGlava = new JSlider();  
	JSlider sliderBGlava = new JSlider();  
	
	JSlider sliderRTijelo = new JSlider();  
	JSlider sliderGTijelo = new JSlider();  
	JSlider sliderBTijelo = new JSlider();
	
	int rGlavaBoja,gGlavaBoja,bGlavaBoja;
	int rTijeloBoja,gTijeloBoja,bTijeloBoja;
	
	int borderStatus = 0;
	int contactStatus = 0;
	
	odabirTezineCheckBox(){
		
		rGlavaBoja = (int) (sliderRGlava.getValue() * 2.55);
		gGlavaBoja = (int) (sliderGGlava.getValue() * 2.55);
		bGlavaBoja = (int) (sliderBGlava.getValue() * 2.55);
		
		rTijeloBoja = (int) (sliderRTijelo.getValue() * 2.55);
		gTijeloBoja = (int) (sliderGTijelo.getValue() * 2.55);
		bTijeloBoja = (int) (sliderBTijelo.getValue() * 2.55);
		 
			sliderRGlava.setBounds(350, 120, 100, 10);
			sliderGGlava.setBounds(350, 150, 100, 10);
			sliderBGlava.setBounds(350, 180, 100, 10);
			
			rGlava.setText("CRVENA");
			rGlava.setBounds(375, 100, 100, 20);
			
			gGlava.setText("ZELENA");
			gGlava.setBounds(375, 130, 100, 20);
			
			bGlava.setText("PLAVA");
			bGlava.setBounds(375, 160, 100, 20);
			
			
			sliderRTijelo.setBounds(350, 220, 100, 10);
			sliderGTijelo.setBounds(350, 250, 100, 10);
			sliderBTijelo.setBounds(350, 280, 100, 10);
			
			rTijelo.setText("CRVENA");
			rTijelo.setBounds(375, 200, 100, 20);
			
			gTijelo.setText("ZELENA");
			gTijelo.setBounds(375, 230, 100, 20);
			
			bTijelo.setText("PLAVA");
			bTijelo.setBounds(375, 260, 100, 20);
			
			
			
			
			titleLabel.setText("Odabir tezinu");
			titleLabel.setFont(new Font(null,Font.BOLD,35));
			titleLabel.setForeground(Color.red);
			titleLabel.setBounds(120,35,250,30);
			
			glavaLabel.setText("Boja glave: ");
			glavaLabel.setFont(new Font(null, Font.BOLD,15));
			glavaLabel.setBounds(180, 137, 100, 35);
			glavaLabel.setFocusable(false);
			glavaLabel.setBackground(Color.gray);
			
			tijeloLabel.setText("Boja tijela: ");
			tijeloLabel.setFont(new Font(null, Font.BOLD,15));
			tijeloLabel.setBounds(180, 237, 100, 35);
			tijeloLabel.setFocusable(false);
			tijeloLabel.setBackground(Color.gray);
			
			glava.setEnabled(false);
			glava.setBackground(new Color(rGlavaBoja,gGlavaBoja,bGlavaBoja));
			glava.setBounds(270,120,70,70);
			
			tijelo.setEnabled(false);
			tijelo.setBackground(new Color(rTijeloBoja,gTijeloBoja,bTijeloBoja));
			tijelo.setBounds(270,220,70,70);

//			rPlusGlava.setText("+");
//			rPlusGlava.setFont(new Font(null, null,5));
//			rPlusGlava.setBounds(350, 120, 25, 25);
//			rPlusGlava.addActionListener(this);
//			rPlusGlava.setFocusable(false);
//			rPlusGlava.setBackground(Color.gray);
			
			border.setText("Border");
			border.setFont(new Font(null, Font.BOLD,15));
			border.setBounds(20, 120, 75, 35);
			border.addActionListener(this);
			border.setFocusable(false);
			border.setBackground(Color.gray);
			
			contact.setText("Contact");
			contact.setFont(new Font(null, Font.BOLD,15));
			contact.setBounds(20, 170, 80, 50);
			contact.addActionListener(this);
			contact.setFocusable(false);
			contact.setBackground(Color.gray);
			
			submitButton.setText("SUMBIT");
			submitButton.setFont(new Font(null,Font.BOLD,15));
			submitButton.setBounds(50, 400, 150, 50);
			submitButton.setFocusable(false);
			submitButton.addActionListener(this);
			submitButton.setOpaque(true);
			
			refreshButton.setText("REFRESH");
			refreshButton.setFont(new Font(null,Font.BOLD,15));
			refreshButton.setBounds(300, 400, 150, 50);
			refreshButton.setFocusable(false);
			refreshButton.addActionListener(this);
			
			
			
			titlePanel.add(titleLabel);
			titlePanel.setBounds(0, 0, 500, 100);
			titlePanel.setBackground(new Color(25,25,25));
			titlePanel.setLayout(null);
			
			buttonPanel.setBounds(0,100,250,200);
			buttonPanel.setBackground(Color.gray);
			buttonPanel.add(border);
			buttonPanel.add(contact);
			buttonPanel.add(submitButton);
			buttonPanel.add(refreshButton);
			buttonPanel.add(glavaLabel);
			buttonPanel.add(glava);
			buttonPanel.add(rGlava);
			buttonPanel.add(gGlava);
			buttonPanel.add(bGlava);
			buttonPanel.add(sliderRGlava);
			buttonPanel.add(sliderGGlava);
			buttonPanel.add(sliderBGlava);	
			buttonPanel.add(tijeloLabel);
			buttonPanel.add(tijelo);
			buttonPanel.add(rTijelo);
			buttonPanel.add(gTijelo);
			buttonPanel.add(bTijelo);
			buttonPanel.add(sliderRTijelo);
			buttonPanel.add(sliderGTijelo);
			buttonPanel.add(sliderBTijelo);	
			buttonPanel.setLayout(null);
			
			
			frame.add(titlePanel);
			frame.add(buttonPanel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(500,500);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setLayout(null);
		
			
			
			//new GameFrame();
			
			
			
	}


	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		rGlavaBoja = (int) (sliderRGlava.getValue() * 2.55);
		gGlavaBoja = (int) (sliderGGlava.getValue() * 2.55);
		bGlavaBoja = (int) (sliderBGlava.getValue() * 2.55);
		
		rTijeloBoja = (int) (sliderRTijelo.getValue() * 2.55);
		gTijeloBoja = (int) (sliderGTijelo.getValue() * 2.55);
		bTijeloBoja = (int) (sliderBTijelo.getValue() * 2.55);
		
		glava.setBackground(new Color(rGlavaBoja,gGlavaBoja,bGlavaBoja));
		tijelo.setBackground(new Color(rTijeloBoja,gTijeloBoja,bTijeloBoja));
		
		if(e.getSource()==submitButton) {
			if(border.isSelected()) borderStatus = 1;
			if(contact.isSelected()) contactStatus = 1;
			frame.dispose();
			new GameFrame(borderStatus,contactStatus,rGlavaBoja,gGlavaBoja,bGlavaBoja,rTijeloBoja,gTijeloBoja,bTijeloBoja);
		}
}
	
	
	


	

}