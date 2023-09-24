package view;
import javax.swing.*;

import engine.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
public class players extends JFrame implements ActionListener {
	private JLabel label1= new JLabel("Player 1 Name");
	private JLabel label2= new JLabel("Player 2 Name");
	private JLabel label3= new JLabel();
	private JLabel back= new JLabel();
	public static JTextField name1;
	public static JTextField name2;
	private JButton ok=new JButton(" Come on already ");
	//private Main Main;
	private Font pixelMplus;

    players(){
     //this.Main=Main;
     try{
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("aven.ttf")).deriveFont(30f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("aven.ttf")));			
		}
		catch(IOException | FontFormatException e){
			
		}
     ImageIcon imageb= new ImageIcon("space.jpg");
	 back.setIcon(imageb);
	 back.setBounds(0,0,1700,1700);
     ImageIcon image1= new ImageIcon("coveer.JPG");
     label1.setText("Player 1 Name");
	 label1.setBounds(150,200,600,600);
     label1.setHorizontalTextPosition(JLabel.CENTER);
	 label1.setVerticalTextPosition(JLabel.TOP );
	 label1.setForeground(Color.WHITE);
	 label1.setFont(pixelMplus);
	 label1.setHorizontalAlignment(JLabel.CENTER);
	 name1= new JTextField();
	 name1.setBounds(350, 400, 200, 50);
	 label2.setText("Player 2 Name");
	 label2.setBounds(650,200,600,600);
     label2.setHorizontalTextPosition(JLabel.CENTER);
	 label2.setVerticalTextPosition(JLabel.TOP );
	 label2.setForeground(Color.WHITE);
	 label2.setFont(pixelMplus);
	 label2.setHorizontalAlignment(JLabel.CENTER);
	 label3.setBounds(330,-300,1000,1000);
	 label3.setIcon(image1);
	 name2= new JTextField();
	 name2.setBounds(850, 400, 200, 50);
	 ok.setFocusable(false);
	 ok.setBackground(Color.white);
	 ok.setForeground(new Color(0*15300));
	 ok.setFont(pixelMplus);
	 ok.setBounds(500, 600, 400, 70);
	 ok.setFocusable(false);
	 ok.addActionListener(this);
	 ok.setForeground(Color.RED);
	 this.setIconImage(new ImageIcon("Marvel_Logo.svg.png").getImage());
	 this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 this.setSize(1700,1700);
	 this.setLayout(null);
	 this.setTitle("THE MARVEL WORLD");
	 this.getContentPane().setBackground(new Color(0x1234));
	 back.add(ok);
	 back.add(name2);
	 back.add(label2);
	 back.add(name1);
	 back.add(label1);
	 back.add(label3);
	 this.add(back);
	 this.setVisible(true);
    }

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ok) {
			if(name1.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"Please Enter Player 1's Name","Error",JOptionPane.ERROR_MESSAGE);}
			
			    if(name2.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"Please Enter Player 2's Name","Error",JOptionPane.ERROR_MESSAGE);
			}
		   if(!(name1.getText().equals("") ) && !(name2.getText().equals(""))) {
				this.dispose();
				Team Team= new Team(name1.getText(), name2.getText());
			}
		}
	}
   

}
