package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main extends JFrame{
	//private Start Start;
	//private players players;
	//private Team Team;
	//private board board;
	public Main(){

		//this.setIconImage(new ImageIcon("Marvel_Logo.svg.png").getImage());
		 Start Start= new Start();
		 //this.getContentPane().add(Start);
		 //this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
		 //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 //this.setSize(1700,1700);
		 //this.setLayout(null);
		// this.setTitle("THE MARVEL WORLD");
		// this.getContentPane().setBackground(new Color(0x1234));
		 //this.setVisible(true);
	}

public static void main ( String [] args) {
	
	 Main Main= new Main();
 }
//public void Switch() {
  // this.getContentPane().removeAll();
   //players= new players(this);
  // this.getContentPane().add(players);
  // this.validate();
  // this.repaint();
//}
//public void Switch2(String name1, String name2) {
	 //  this.removeAll();
	  // Team= new Team(this, name1, name2);
	  // this.getContentPane().add(Team);
	  // this.validate();
	//   this.repaint();
	//}
}
