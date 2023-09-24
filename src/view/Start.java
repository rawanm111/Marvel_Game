package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Start extends JFrame implements ActionListener {
	//private Main Main;
    private JButton button= new JButton(" ASSEMBLE ");
    private JLabel label= new JLabel();
    private JLabel back= new JLabel();
    private Font pixelMplus;
    
    
	public Start (){
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
		
		 ImageIcon image= new ImageIcon("Uni.png");
		 label.setText("WELCOME TO THE");
		 label.setIcon(image);
		 label.setBounds(0,10,1400,500);
         label.setHorizontalTextPosition(JLabel.CENTER);
    	 label.setVerticalTextPosition(JLabel.TOP );
    	 label.setForeground(Color.WHITE);
    	 label.setFont(pixelMplus);
    	 label.setHorizontalAlignment(JLabel.CENTER);
		 button.setBounds(300,800,500,100);
		 button.setFocusable(false);
		 button.addActionListener(this);
		 button.setBackground(Color.white);
		 button.setForeground(Color.red);
		 button.setFont(pixelMplus);
		 button.setBounds(500, 500, 400, 70);
		 button.setFocusable(false);
		 button.setForeground(Color.RED);
		
		 this.setIconImage(new ImageIcon("Marvel_Logo.svg.png").getImage());
		 this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 this.setSize(1700,1700);
		 this.setLayout(null);
		 this.setTitle("THE MARVEL WORLD");
		 this.getContentPane().setBackground(new Color(0x1234));
         back.add(label);
        
    	 back.add(button);
    	 this.add(back);
    	 this.setVisible(true);
    	
    	 
             	}
 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			//Main.Switch();
			this.dispose();
			players players= new players();
			} 
		 
	}
}
     