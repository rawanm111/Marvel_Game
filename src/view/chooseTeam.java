
	package view;

	import java.awt.BorderLayout;
	import java.awt.FlowLayout;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;

	import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
	import javax.swing.JPanel;
import javax.swing.JTextField;

import engine.Game;
	import model.world.Champion;
	import engine.Player;

	public class chooseTeam extends JFrame implements ActionListener{
		JPanel first;
		JPanel second;
		ArrayList<JButton> btnsfirst;
		ArrayList<JButton> btnssecond;
		Player FirstPlayer;
		Player SecondPlayer;
		int i=0;
		int j=0;
		JLabel text;
		Main Main;
		public chooseTeam(Main Main) {	
			this.add(first,BorderLayout.NORTH);
			this.add(second,BorderLayout.SOUTH);
			first.setLayout(new FlowLayout());
			second.setLayout(new FlowLayout());
			text=new JLabel();
			text.setText(" Choose our leader champion ");
			first.add(text);
			second.add(text);
			for(int i=0;i<Game.getAvailableChampions().size();i++) {
				JButton b=new JButton();	
				b.addActionListener(this);
				Champion c =Game.getAvailableChampions().get(i);
				b.setText("Name :"+ c.getName()+"\n Attack damage"+ c.getAttackDamage() + "\n Attackrange"+ c.getAttackRange()+"\n Speed"+c.getSpeed()+"\n Health"+c.getMaxHP()+"\n");
				first.add(b);
				btnsfirst.add(b);
			}
			for(int i=0;i<Game.getAvailableChampions().size();i++) {
				JButton b=new JButton();
				b.addActionListener(this);
				Champion c =Game.getAvailableChampions().get(i);
				b.setText("Name :"+ c.getName()+"\n Attack damage"+ c.getAttackDamage() + "\n Attackrange"+ c.getAttackRange()+"\n Speed"+c.getSpeed()+"\n Health"+c.getMaxHP()+"\n");
				second.add(b);
				btnssecond.add(b);
			}
			Main.add(first);
			Main.add(second);
			
		}
		
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			int Index = btnsfirst.indexOf(btn);
			Champion champion = (Champion)Game.getAvailableChampions().get(Index);
		  
			FirstPlayer.getTeam().add(champion);
			int Indexsecond = btnssecond.indexOf(btn);
			Champion championsecond = (Champion)Game.getAvailableChampions().get(Indexsecond);

			SecondPlayer.getTeam().add(championsecond);
			
	       if(i==0) {
	    	  first.remove(text);
	    	  text.setText("choose champion");
	       }
	       if(j==0) {
	    	   second.remove(text);
	    	   text.setText("choose champion");
	       }
		   
		   if(i>2) {
			     for(JButton b: btnsfirst) {
			    	 b.setEnabled(false);
			     }
		   }
		   i++;
		 
		   if(j>2) {
			     for(JButton b: btnssecond) {
			    	 b.setEnabled(false);
			     }
		   }
		   if(i==2&&j==2) {
			  ////////////////////////////////////////switch
		   }
		   j++;
		   FirstPlayer.setLeader(FirstPlayer.getTeam().get(0));
		   SecondPlayer.setLeader(SecondPlayer.getTeam().get(0));
		   btn.setEnabled(false);
		}
		

	
}

