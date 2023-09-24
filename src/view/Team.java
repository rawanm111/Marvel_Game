package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import engine.Game;
import engine.Player;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Hero;
import model.world.Villain;

public class Team extends JFrame implements ActionListener{
  private Player FirstPlayer;
  private Player SecondPlayer;
  private Game game;
  private JLabel Player= new JLabel();
  private JLabel PlayerT= new JLabel();
  private JLabel back= new JLabel();
   private JButton Cap= new JButton("Captain America");
   private JButton Elect= new JButton("Electro");
   private JButton Hulk= new JButton("Hulk");
   private JButton Loki= new JButton("Loki");
   private JButton Thor= new JButton("Thor");
   private JButton Dead= new JButton("DeadPool");
   private JButton Ghost= new JButton("Ghost Rider");
   private JButton Ice= new JButton("Iceman");
   private JButton Quick= new JButton("QuickSilver");
   private JButton Venom= new JButton("Venom");
   private JButton Dr= new JButton("Dr Strange");
   private JButton Hela= new JButton("Hela");
   private JButton Iron= new JButton("Ironman");
   private JButton Spider= new JButton("Spiderman");
   private JButton Yellow= new JButton("Yellow Jacket");
   private JLabel CapL= new JLabel();
   private JLabel ElecL=new JLabel();
   private JLabel HulkL=new JLabel();
   private JLabel LokiL=new JLabel();
   private JLabel ThorL=new JLabel();
   private JLabel DeadL=new JLabel();
   private JLabel GhostL=new JLabel();
   private JLabel IceL=new JLabel();
   private JLabel QuickL=new JLabel();
   private JLabel VenomL=new JLabel();
   private JLabel DrL=new JLabel();
   private JLabel HelaL=new JLabel();
   private JLabel IronL=new JLabel();
   private JLabel SpiderL=new JLabel();
   private JLabel YellowL=new JLabel();
   private Font pixelMplus;
   private Font marv;
   private Font pix;
   ArrayList<JButton> buttons= new ArrayList<JButton>();
   Champion c;
   
	public Team(String name1,String name2) {
		ImageIcon imageb= new ImageIcon("space.jpg");
		 back.setIcon(imageb);
		 back.setBounds(0,0,1700,1700);
		try{
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("aven.ttf")).deriveFont(30f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("aven.ttf")));		
		    marv = Font.createFont(Font.TRUETYPE_FONT, new File("comic.ttf")).deriveFont(30f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("comic.ttf")));	
			 pix = Font.createFont(Font.TRUETYPE_FONT, new File("pixo.ttf")).deriveFont(30f);	
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("pixo.ttf")));	
			
			
		}
		catch(IOException | FontFormatException e){
			
		}
		FirstPlayer = new engine.Player(name1);
		SecondPlayer = new engine.Player(name2);
		game=new Game(FirstPlayer,SecondPlayer);
		
		try{
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File("aven.ttf")).deriveFont(30f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("aven.ttf")));			
		}
		catch(IOException | FontFormatException e){
			
		}
		
		try {
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
		}
		catch(IOException Z) {
			Z.printStackTrace();
		}
		ImageIcon CapIm= new ImageIcon("Cap.png");
		Cap.setIcon(CapIm);
		Cap.setBounds(10,80,140,150);
		Cap.setHorizontalAlignment(JLabel.CENTER);
        CapL.setText("<html>Name: Captain America <br> Attack damage: 100<br>Actions: 6 <br> Attackrange : 1<br>Speed : 80<br>Health : 1500<br> Mana Cost: 1000<br> Abilities: <br>Sheild throw<br> I Can Do this all Day<br> Sheild Up<html>");
        //CapL.setFont(pix);
        CapL.setForeground(Color.white);
		CapL.setBounds(10,-30,500,700);
		Cap.addActionListener(this);
		back.add(CapL);
		ImageIcon EIm= new ImageIcon("Elect.png");
		Elect.setIcon(EIm);
		Elect.setBounds(170,80,140,150);
		Elect.setHorizontalAlignment(JLabel.CENTER);
		ElecL.setText("<html>Name: Electro  <br> Attack damage: 110<br>Actions: 5 <br> Attackrange : 3<br>Speed : 75<br>Health : 1200<br> Mana Cost: 1200<br> Abilities:<br> Fully Charged<br> EMP<br> Lightening Strike<html>");
		//ElecL.setFont(pix);
		ElecL.setForeground(Color.white);
	    ElecL.setBounds(170,-30,500,700);
	    Elect.addActionListener(this);
			back.add(ElecL);
		ImageIcon HIm= new ImageIcon("Hulk.png");
		Hulk.setIcon(HIm);
		Hulk.setBounds(330,80,140,150);
		Hulk.setHorizontalAlignment(JLabel.CENTER);
		HulkL.setText("<html>Name: Hulk  <br> Attack damage: 200<br>Actions: 5 <br> Attackrange : 1<br>Speed : 55<br>Health : 2250<br> Mana Cost: 550<br> Abilities:<br> Rage<br> Hulk Smash!<br> Sun is Getting real Low<html>");
	    HulkL.setForeground(Color.white);
	    HulkL.setBounds(330,-30,500,700);
	    Hulk.addActionListener(this);
			back.add(HulkL);
		ImageIcon LIm= new ImageIcon("Loki.png");
		Loki.setIcon(LIm);
		Loki.setBounds(490,80,140,150);
		Loki.setHorizontalAlignment(JLabel.CENTER);
		LokiL.setText("<html>Name: Loki  <br> Attack damage: 150<br>Actions: 5 <br> Attackrange : 1<br>Speed : 70<br>Health : 1150<br> Mana Cost: 900<br> Abilities: <br>God of Mischief<br> The Hidden Dagger<br> Fake Death<html>");
	    LokiL.setForeground(Color.white);
	    LokiL.setBounds(490,-30,500,700);
	    Loki.addActionListener(this);
			back.add(LokiL);
		ImageIcon TIm= new ImageIcon("Thor.png");
		Thor.setIcon(TIm);
		Thor.setBounds(650,80,140,150);
		Thor.setHorizontalAlignment(JLabel.CENTER);
		ThorL.setText("<html>Name: Thor  <br> Attack damage: 130<br>Actions: 7 <br> Attackrange : 1<br>Speed : 90<br>Health : 1800<br> Mana Cost: 800<br> Abilities: <br>God of Thunder<br> Mjollnir Throw<br> Bring Me Thanos!<html>");
	    ThorL.setForeground(Color.white);
	    ThorL.setBounds(650,-30,500,700);
	    Thor.addActionListener(this);
	    back.add(ThorL);
		ImageIcon DIm= new ImageIcon("Dead.png");
		Dead.setIcon(DIm);
		Dead.setBounds(810,80,140,150);
		Dead.setHorizontalAlignment(JLabel.CENTER);
		DeadL.setText("<html>Name: Deadpool  <br> Attack damage: 90<br>Actions: 6 <br> Attackrange : 3<br>Speed : 80<br>Health : 1350<br> Mana Cost: 700<br> Abilities: <br>Try Harder<br> 8 Bullets Left<br> Can't Catch Me!<html>");
	    DeadL.setForeground(Color.white);
	    DeadL.setBounds(810,-30,500,700);
	    Dead.addActionListener(this);
	    back.add(DeadL);
		ImageIcon GIm= new ImageIcon("ghost.png");
		Ghost.setIcon(GIm);
		Ghost.setBounds(970,80,140,150);
		Ghost.setHorizontalAlignment(JLabel.CENTER);
		GhostL.setText("<html>Name: Ghost Rider <br> Attack damage: 140<br>Actions: 6 <br> Attackrange : 1<br>Speed : 85<br>Health : 1800<br> Mana Cost: 600<br> Abilities:<br> Death Stare<br> Fire Breath<br> Chain Whip<html>");
	    GhostL.setForeground(Color.white);
	    GhostL.setBounds(970,-30,500,700);
	    Ghost.addActionListener(this);
	    back.add(GhostL);
		ImageIcon IIm= new ImageIcon("ice.png");
		Ice.setIcon(IIm);
		Ice.setBounds(1130,80,140,150);
		Ice.setHorizontalAlignment(JLabel.CENTER);
		IceL.setText("<html>Name: Iceman  <br> Attack damage: 120<br>Actions: 5 <br> Attackrange : 2<br>Speed : 65<br>Health : 1000<br> Mana Cost: 900<br> Abilities:<br> FrostBite<br> SubZero<br> Hail Strom<html>");
	    IceL.setForeground(Color.white);
	    IceL.setBounds(1130,-30,500,700);
	    Ice.addActionListener(this);
	    back.add(IceL);
		ImageIcon QIm= new ImageIcon("quick.png");
		Quick.setIcon(QIm);
		Quick.setBounds(1290,80,140,150);
		Quick.setHorizontalAlignment(JLabel.CENTER);
		QuickL.setText("<html>Name: Quicksilver  <br> Attack damage: 70<br>Actions: 8 <br> Attackrange : 1<br>Speed : 99<br>Health : 1200<br> Mana Cost: 650<br> Abilities:<br>Time in a Bottle<br> Good as New<br> 1 sec 100 Punch <html>");
	    QuickL.setForeground(Color.white);
	    QuickL.setBounds(1290,-30,500,700);
	    Quick.addActionListener(this);
	    back.add(QuickL);
	    ImageIcon VIm= new ImageIcon("venom.png");
		Venom.setIcon(VIm);
		Venom.setBounds(240,430,140,150);
		Venom.setHorizontalAlignment(JLabel.CENTER);
		VenomL.setText("<html>Name: Venom  <br> Attack damage: 140<br>Actions: 5 <br> Attackrange : 1<br>Speed : 70<br>Health : 1650<br> Mana Cost: 700<br> Abilities: <br>Head Bite<br> We Are Venom<br> Symbiosis <html>");
	    VenomL.setForeground(Color.white);
	    VenomL.setBounds(240,320,500,700);
	    Venom.addActionListener(this);
	    back.add(VenomL);
	    back.add(Venom);
	    ImageIcon DrIm= new ImageIcon("dr.png");
		Dr.setIcon(DrIm);
		Dr.setBounds(400,430,140,150);
		Dr.setHorizontalAlignment(JLabel.CENTER);
		DrL.setText("<html>Name: Dr Strange  <br> Attack damage: 60<br>Actions: 6 <br> Attackrange : 2<br>Speed : 60<br>Health : 1100<br> Mana Cost: 1500<br> Abilities: <br>The eye of agamotto<br> Thousand Hand<br> Mirror Dimension <html>");
	    DrL.setForeground(Color.white);
	    DrL.setBounds(400,320,500,700);
	    Dr.addActionListener(this);
	    back.add(DrL);
	    back.add(Dr);
	    ImageIcon HlIm= new ImageIcon("hela.png");
		Hela.setIcon(HlIm);
		Hela.setBounds(560,430,140,150);
		Hela.setHorizontalAlignment(JLabel.CENTER);
		HelaL.setText("<html>Name: Hela  <br> Attack damage: 150<br>Actions: 5 <br> Attackrange : 1<br>Speed : 75<br>Health : 1500<br> Mana Cost: 750<br> Abilities: <br>Goddess Of Death<br> Thorn Shield<br> Thorn Shower <html>");
	    HelaL.setForeground(Color.white);
	    HelaL.setBounds(560,320,500,700);
	    Hela.addActionListener(this);
	    back.add(HelaL);
	    back.add(Hela);
	    ImageIcon IrIm= new ImageIcon("iron.png");
		Iron.setIcon(IrIm);
		Iron.setBounds(720,430,140,150);
		Iron.setHorizontalAlignment(JLabel.CENTER);
		IronL.setText("<html>Name: Ironman  <br> Attack damage: 90<br>Actions: 7 <br> Attackrange : 3<br>Speed : 85<br>Health : 1200<br> Mana Cost: 800<br> Abilities: <br>I am Ironman<br> UniBeam <br> 3000<html>");
	    IronL.setForeground(Color.white);
	    IronL.setBounds(720,320,500,700);
	    Iron.addActionListener(this);
	    back.add(IronL);
	    back.add(Iron);
	    ImageIcon SpIm= new ImageIcon("spider.png");
		Spider.setIcon(SpIm);
		Spider.setBounds(880,430,140,150);
		Spider.setHorizontalAlignment(JLabel.CENTER);
		SpiderL.setText("<html>Name: Spiderman  <br> Attack damage: 120<br>Actions: 7 <br> Attackrange : 1<br>Speed : 85<br>Health : 1400<br> Mana Cost: 750<br> Abilities: <br>Give me that!<br> Webtrap <br> SpiderVerse<html>");
	    SpiderL.setForeground(Color.white);
	    SpiderL.setBounds(880,320,500,700);
	    Spider.addActionListener(this);
	    back.add(SpiderL);
	    back.add(Spider);
	    ImageIcon YIm= new ImageIcon("yellow.png");
		Yellow.setIcon(YIm);
		Yellow.setBounds(1040,430,140,150);
		Yellow.setHorizontalAlignment(JLabel.CENTER);
		YellowL.setText("<html>Name: Yellow Jacket  <br> Attack damage: 80<br>Actions: 6 <br> Attackrange : 2<br>Speed : 60<br>Health : 1050<br> Mana Cost: 800<br> Abilities: <br>Laser Sting<br> QuANTaMANia<br>Pym Particle Upsize<html>");
	    YellowL.setForeground(Color.white);
	    YellowL.setBounds(1040,320,500,700);
	    Yellow.addActionListener(this);
	    back.add(YellowL);
	    back.add(Yellow);
		Player.setText("Choose Leader for Team "+ FirstPlayer.getName());
		Player.setBounds(200,-470,1000,1000);
		Player.setForeground(Color.WHITE);
		Player.setFont(pixelMplus);
		Player.setHorizontalAlignment(JLabel.CENTER);
		PlayerT.setText("Choose his Team Mates ");
		PlayerT.setBounds(200,-470,1000,1000);
		PlayerT.setForeground(Color.WHITE);
		PlayerT.setFont(pixelMplus);
		PlayerT.setHorizontalAlignment(JLabel.CENTER);
		this.setIconImage(new ImageIcon("Marvel_Logo.svg.png").getImage());
		this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1700,1700);
		this.setLayout(null);
		this.setTitle("THE MARVEL WORLD");
		this.getContentPane().setBackground(new Color(0x1234));
		back.add(Player);
		back.add(Cap);
		back.add(Elect);
		back.add(Hulk);
		back.add(Loki);
		back.add(Thor);
		back.add(Dead);
		back.add(Ghost);
		back.add(Ice);
		back.add(Quick);
		this.add(back);
		this.setVisible(true);
	}
	
	

	public void actionPerformed(ActionEvent e) {
	    ArrayList <Champion> a=Game.getAvailableChampions();

if(e.getSource()==Cap) {
	Champion s= getCh(a ,"Captain America");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Cap);
	Cap.setEnabled(false);
	
	} 	
	
	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Cap);
		Cap.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			    Team2 board= new Team2(FirstPlayer,SecondPlayer,game);
			}

	}
}
else if(e.getSource()==Elect) {
	Champion s= getCh(a ,"Electro");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Elect);
	Elect.setEnabled(false);
	
	} 	

	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Elect);
		Elect.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			    Team2 board= new Team2(FirstPlayer,SecondPlayer,game);
			}

	}
} else if(e.getSource()==Hulk) {
	Champion s= getCh(a ,"Hulk");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Hulk);
	Hulk.setEnabled(false);
	
	} 	
	
	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Hulk);
		Hulk.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			    Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
			}

	}
}
else if(e.getSource()==Dead) {
	Champion s= getCh(a ,"Deadpool");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Dead);
	Dead.setEnabled(false);
	
	} 	
	
	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Dead);
		Dead.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			   Team2 board= new Team2(FirstPlayer, SecondPlayer,game);}

	}
}
else if(e.getSource()==Dr) {
	Champion s= getCh(a ,"Dr Strange");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Dr);
	Dr.setEnabled(false);
	
	} 	

	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Dr);
		Dr.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			   Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
			}

	}
} else if(e.getSource()==Ghost) {
	Champion s= getCh(a ,"Ghost Rider");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Ghost);
	Ghost.setEnabled(false);
	
	} 	
	
	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Ghost);
		Ghost.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			   Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
			}

	}
} else if(e.getSource()==Hela) {
	Champion s= getCh(a ,"Hela");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Hela);
	Hela.setEnabled(false);
	
	} 	
	
	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Hela);
		Hela.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			   Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
			}

	}
}else if(e.getSource()==Ice) {
	Champion s= getCh(a ,"Iceman");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Ice);
	Ice.setEnabled(false);
	
	} 	
	
	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Ice);
		Ice.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			   Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
			}

	}
}else if(e.getSource()==Iron) {
	Champion s= getCh(a ,"Ironman");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Iron);
	Iron.setEnabled(false);
	
	} 	
	
	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Iron);
		Iron.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			   Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
			}

	}
}else if(e.getSource()==Loki) {
	Champion s= getCh(a ,"Loki");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Loki);
	Loki.setEnabled(false);
	
	} 	
	
	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Loki);
		Loki.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			   Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
			}

	}
}else if(e.getSource()==Quick) {
	Champion s= getCh(a ,"Quicksilver");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Quick);
	Quick.setEnabled(false);
	
	} 	

	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Quick);
		Quick.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			   Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
			}
		
	}
}else if(e.getSource()==Spider) {
	Champion s= getCh(a ,"Spiderman");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Spider);
	Spider.setEnabled(false);
	
	} 	
	
	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Spider);
		Spider.setEnabled(false);
		 if (buttons.size()==3) {
				
			    this.dispose();
			   Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
			}

	}
}else if(e.getSource()==Thor) {
	Champion s= getCh(a ,"Thor");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Thor);
	Thor.setEnabled(false);
	
	} 	

	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Thor);
		Thor.setEnabled(false);
        if (buttons.size()==3) {
			
		    this.dispose();
		   Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
		}
	}
}else if(e.getSource()==Venom) {
	Champion s= getCh(a ,"Venom");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Venom);
	Venom.setEnabled(false);
	
	} 	
	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Venom);
		Venom.setEnabled(false);
        if (buttons.size()==3) {
			
		    this.dispose();
		   Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
		}

	}
}else if(e.getSource()==Yellow) {
	Champion s= getCh(a ,"Yellow Jacket");
	if(buttons.size()==0) {
	Player.setText("Choose his Team Mates ");
	SwingUtilities.updateComponentTreeUI(this);
	FirstPlayer.setLeader(s);
	FirstPlayer.getTeam().add(s);
	buttons.add(Yellow);
	Yellow.setEnabled(false);
	
	} 	
	else {
		FirstPlayer.getTeam().add(s);
		buttons.add(Yellow);
		Yellow.setEnabled(false);
		if (buttons.size()==3) {
			
		    this.dispose();
		    Team2 board= new Team2(FirstPlayer, SecondPlayer,game);
		}

	}
}
}
	public Champion getCh(ArrayList <Champion> L,String s) {
		for(Champion c: L) {
			if(c.getName().equals(s))
				return c;
		}
		return null;
	}


}
