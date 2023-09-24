package view;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.*;
import model.effects.Effect;
import model.world.Champion;
import model.world.Condition;
import model.world.Cover;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
public class board extends JFrame implements ActionListener{
	private Player f;
	private Player s;
	private Game game;
	private JLabel first= new JLabel();
	private JLabel second= new JLabel();
	private JLabel back= new JLabel();
	private Font marv;
	private Font pix;

//	private DefaultListModel<String> model= new DefaultListModel<>();
	private JPanel grid= new JPanel(new GridLayout(5,5));
	private Font pixelMplus;
	private JScrollPane sp;
	private JScrollPane sp1;
	private JScrollPane sp2;
	private JScrollPane sp3;
	private JButton endturn= new JButton();
	private JButton ability1= new JButton();
	private JButton ability2= new JButton();
	private JButton ability3= new JButton();
	private JButton leaderability= new JButton();
	private JButton attack= new JButton();
	private JButton up= new JButton();
	private JButton down= new JButton();
	private JButton left= new JButton();
	private JButton right= new JButton();
	private JLabel choose= new JLabel();
	
	private JTextArea middlel;
	private JTextArea ability;
	private JTextArea middler;
	
	private JButton c1;
	private JButton c2;
	private JButton c3;
	private JButton c4;
	private JButton c5;
	private ArrayList<Cover> cover =new ArrayList<Cover>();
	private JButton a;
	private JButton b;
	private JButton c;
	private JButton d;
	private JButton e;
	private JButton g;
	private JButton h;
	private JButton i;
	private JButton j;
	private JButton k;
	private JButton l;
	private JButton m;
	private JButton n;
	private JButton o;
	private JButton p;
	private JButton q;
	private JButton r;
	private JButton t;
	private JButton u;
	private JButton v;
	private JButton w;
	private JButton x;
	private JButton y;
	private JButton z;
	
	private ArrayList<JButton> letters;
	private ArrayList<JButton> lettersc;


	
	private JButton ff= new JButton();
	private JButton fs= new JButton();
	private JButton ft= new JButton();
	private JButton sf= new JButton();
	private JButton ss= new JButton();
	private JButton st= new JButton();
	
	private JTextArea middle;
	private JTextArea Right;
	private JTextArea Left;
	
	private QueueObj obj;
	
	private boolean battack=false;
	private boolean bability=false;
	private int indexAbility;
	ArrayList<JButton> btns =new ArrayList<JButton>();
public board ( Player f, Player s)  {
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

lettersc = new ArrayList<JButton>();

letters =new ArrayList<JButton>();

a =new JButton();   
this.f=f;
     this.s=s;
     this.game=new Game(f,s);
 	Player P;
 	if(f.getTeam().contains(game.getCurrentChampion()))
 	    P= game.getFirstPlayer();
 	else
 		 P= game.getSecondPlayer();
 	Queueprep(game.getTurnOrder());
 	 grid.setAlignmentX(CENTER_ALIGNMENT);
     grid.setAlignmentY(CENTER_ALIGNMENT);
     grid.setBackground(Color.white);
     grid.setBounds(370, 90,650,650);
     grid.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
     setButtons(grid);
     grid.setVisible(true);
     first.setText("Team "+f.getName());
 	first.setBounds(40,-220,500,500);
     first.setHorizontalTextPosition(JLabel.CENTER);
 	first.setVerticalTextPosition(JLabel.TOP );
 	first.setForeground(Color.red);
 	first.setFont(pixelMplus);
 	first.setHorizontalAlignment(JLabel.LEFT);
 	back.add(first);
 	second.setText("Team "+s.getName());
 	second.setBounds(1140,-220,500,500);
     second.setHorizontalTextPosition(JLabel.CENTER);
 	second.setVerticalTextPosition(JLabel.TOP );
 	second.setForeground(Color.red);
 	second.setFont(pixelMplus);
 	second.setHorizontalAlignment(JLabel.LEFT);
 	back.add(second);  
 	
 	choose.setText("Choose your next Move");
 	choose.setBounds(450,510,800,500);
 	choose.setHorizontalTextPosition(JLabel.CENTER);
 	choose.setVerticalTextPosition(JLabel.TOP );
 	choose.setForeground(Color.red);
 	choose.setFont(pixelMplus);
 	choose.setHorizontalAlignment(JLabel.LEFT);
 	back.add(choose);  
 	
     middlel=new JTextArea();
     middlel.setBounds(330, 15, 220, 60);
     middlel.setBackground(new Color(0x1234));
 	middlel.setEditable(false);
 	middlel.setForeground(Color.white);
 	middlel.setFont(pix);
 	//JScrollPane sp3= new JScrollPane(middlel);
 	//sp3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
 	//sp3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 	//sp3.setBounds(330,15, 210, 75);
 	back.add(middlel);
 	
 	
 	ability=new JTextArea();
 	ability.setBounds(1150,460,450,340);
 	ability.setBackground(new Color(0x1234));
 	ability.setEditable(false);
 	ability.setForeground(Color.white);
 	ability.setFont(pix);
// 	JScrollPane spm= new JScrollPane(middlem);
// 	spm.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
// 	spm.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
// 	spm.setBounds(550,15, 380, 60);
     back.add(ability);
 	
 	middler=new JTextArea();
 	//middler.setBounds(560, 10, 550, 70);
     middler.setBackground(new Color(0x1234));
 	middler.setEditable(false);
 	middler.setForeground(Color.white);
 	middler.setFont(pix);
 	JScrollPane sprr= new JScrollPane(middler);
 	sprr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
 	sprr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 	sprr.setBounds(560,10, 515, 75);
 	 sprr.getHorizontalScrollBar().setValue(0);
     back.add(sprr);
     
     Right=new JTextArea();
     Right.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.white));
 	Right.setBackground(new Color(0x1234));
 	Right.setEditable(false);
 	Right.setForeground(Color.white);
 	Right.setFont(marv);
 	JScrollPane spr= new JScrollPane(Right);
 	spr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 	spr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 	spr.setBounds(1080, 55, 330, 400);
 	 spr.getVerticalScrollBar().setValue(0);
 	back.add(spr);

 	
 	Left=new JTextArea();
 	Left.setBackground(new Color(0x1234));
 	Left.setEditable(false);
 	Left.setForeground(Color.RED);
 	Left.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.white));
 	Left.setFont(marv);
 	Left.setForeground(Color.white);
 	JScrollPane spl= new JScrollPane(Left);
 	spl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 	spl.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 	spl.setBounds(5, 55, 320, 400);
 	spl.getVerticalScrollBar().setValue(0);
 	Left.requestFocus();
 	back.add(spl);

 	 setLists();
 	 
      this.getContentPane().add(grid);
      this.setIconImage(new ImageIcon("Marvel_Logo.svg.png").getImage());
 	 this.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
 	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 	 this.setSize(1700,1700);
 	 this.setLayout(null);
 	 this.setTitle("THE MARVEL WORLD");
 	 this.getContentPane().setBackground(new Color(0x1234));
 	 
 	
 	 
 	   ImageIcon End= new ImageIcon("End.png");
 		endturn.setIcon(End);
 		endturn.setBounds(1005,730, 140, 40);
 		endturn.setText("end Turn");
 		endturn.setForeground(Color.RED);
 		endturn.addActionListener(this);
 		back.add(endturn);
 		btns.add(endturn);
 		
 		
 		ability1.setBounds(1005, 560, 150, 40);
 		ability1.setText(game.getCurrentChampion().getAbilities().get(0).getName());
 		ability1.setForeground(Color.RED);
 		ability1.addActionListener(this);
 		back.add(ability1);
 		btns.add(ability1);
 		ability1.addMouseListener(new java.awt.event.MouseAdapter(){
 			public void mouseEntered( java.awt.event.MouseEvent evt) {
 				String mm="";
 				Ability a= game.getCurrentChampion().getAbilities().get(0);
 				mm = mm + "Ability: "+ "\n"+a.getName();
 			    mm = mm +"\n"+"Base CoolDown: " + a.getBaseCooldown();
 				mm = mm +"\n"+ "Current CoolDown: " + a.getCurrentCooldown();
 			    mm = mm +"\n"+ "Type: " + abilityT(a)+"\n"+"Area Of Effect: "+"\n"+ a.getCastArea();
 		        mm = mm +"\n"+ "Cast Range: "+ a.getCastRange();
 			    mm = mm +"\n"+"Mana: "+a.getManaCost();
 		        mm = mm +"\n"+"Action Cost: "+a.getRequiredActionPoints()+"\n";
 		        ability.setText(mm);
 				
 			}
 			public void mouseExited( java.awt.event.MouseEvent evt) {
 				ability.setText(" ");;
 			}
 		});
 		
 
 		ability2.setBounds(1005, 600,  150, 40);
 		ability2.setText(game.getCurrentChampion().getAbilities().get(1).getName());
 		ability2.setForeground(Color.RED);
 		ability2.addActionListener(this);
 		back.add(ability2);
 		btns.add(ability2);
 		ability2.addMouseListener(new java.awt.event.MouseAdapter(){
 			public void mouseEntered( java.awt.event.MouseEvent evt) {
 				String mm="";
 				Ability a= game.getCurrentChampion().getAbilities().get(1);
 				mm = mm + "Ability: "+ "\n"+a.getName();
 			    mm = mm +"\n"+"Base CoolDown: " + a.getBaseCooldown();
 				mm = mm +"\n"+ "Current CoolDown: " + a.getCurrentCooldown();
 				 mm = mm +"\n"+ "Type: " + abilityT(a)+"\n"+"Area Of Effect: "+"\n"+ a.getCastArea();
 		        mm = mm +"\n"+ "Cast Range: "+ a.getCastRange();
 			    mm = mm +"\n"+"Mana: "+a.getManaCost();
 		        mm = mm +"\n"+"Action Cost: "+a.getRequiredActionPoints()+"\n";
 		        ability.setText(mm);
 				
 			}
 			public void mouseExited( java.awt.event.MouseEvent evt) {
 				ability.setText(" ");;
 			}
 		});
 		
 		
 		ability3.setBounds(1005, 640, 150, 40);
 		ability3.setText(game.getCurrentChampion().getAbilities().get(2).getName());
 		ability3.setForeground(Color.RED);
 		ability3.addActionListener(this);
 		back.add(ability3);
 		btns.add(ability3);
 		ability3.addMouseListener(new java.awt.event.MouseAdapter(){
 			public void mouseEntered( java.awt.event.MouseEvent evt) {
 				String mm="";
 				Ability a= game.getCurrentChampion().getAbilities().get(2);
 				mm = mm + "Ability: "+ "\n"+a.getName();
 			    mm = mm +"\n"+"Base CoolDown: " + a.getBaseCooldown();
 				mm = mm +"\n"+ "Current CoolDown: " + a.getCurrentCooldown();
 				 mm = mm +"\n"+ "Type: " + abilityT(a)+"\n"+"Area Of Effect: "+"\n"+ a.getCastArea();
 		        mm = mm +"\n"+ "Cast Range: "+ a.getCastRange();
 			    mm = mm +"\n"+"Mana: "+a.getManaCost();
 		        mm = mm +"\n"+"Action Cost: "+a.getRequiredActionPoints()+"\n";
 		        ability.setText(mm);
 				
 			}
 			public void mouseExited( java.awt.event.MouseEvent evt) {
 				ability.setText(" ");;
 			}
 		});
 		
 	
 		leaderability.setBounds(1005, 680, 150, 40);
 		leaderability.setText("Leader ability");
 		leaderability.setForeground(Color.RED);
 		leaderability.addActionListener(this);
 		back.add(leaderability);
 		btns.add(leaderability);
 		
 		ImageIcon AT= new ImageIcon("attack.png");
 		attack.setIcon(AT);
 		attack.setBounds(100,720, 140, 60);
 		attack.setText("attack");
 		attack.setForeground(Color.RED);
 		attack.addActionListener(this);
 		back.add(attack);
 		btns.add(attack);
 		
 		ImageIcon UP= new ImageIcon("up.png");
 		up.setIcon(UP);
 		up.setBounds(120, 520, 80,80);
 		up.setText("/\\");
 		up.setForeground(Color.blue);
 		up.addActionListener(this);
 		back.add(up);
 		btns.add(up);
 		
 		ImageIcon DW= new ImageIcon("down.png");
 		down.setIcon(DW);
 		down.setBounds(120, 617, 80, 80);
 		down.setText("\\/");
 		down.setForeground(Color.blue);
 		down.addActionListener(this);
 		back.add(down);
 		btns.add(down);
 		
 		ImageIcon LEFT= new ImageIcon("left.png");
 		left.setIcon(LEFT);
 		left.setBounds(30, 570, 80, 80);
 		left.setText("<");
 		left.setForeground(Color.blue);
 		left.addActionListener(this);
 		back.add(left);
 		btns.add(left);
 		
 		ImageIcon RIGHT= new ImageIcon("right.png");
 		right.setIcon(RIGHT);
 		right.setBounds(210, 570, 80, 80);
 		right.setText(">");
 		right.setForeground(Color.blue);
 		right.addActionListener(this);
 		back.add(right);
 		btns.add(right);
 		
       this.add(back);
       this.setVisible(true);
		
	
	 
}
public void setButtons(JPanel grid) {
	ImageIcon imagem= new ImageIcon("moonfloor.jpg");
	a=new JButton();
	b=new JButton();
	c=new JButton();
	d=new JButton();
	e=new JButton();
	g=new JButton();
	h=new JButton();
	i=new JButton();
	j=new JButton();
	k=new JButton();
	l=new JButton();
	m=new JButton();
	n=new JButton();
	o=new JButton();
	p=new JButton();
	q=new JButton();
	r=new JButton();
	t=new JButton();
	u=new JButton();
	v=new JButton();
	w=new JButton();
	x=new JButton();
	y=new JButton();
	z=new JButton();
	a.setIcon(imagem);
	b.setIcon(imagem);
	c.setIcon(imagem);
	d.setIcon(imagem);
	e.setIcon(imagem);
	g.setIcon(imagem);
	h.setIcon(imagem);
	i.setIcon(imagem);
	j.setIcon(imagem);
	k.setIcon(imagem);
	l.setIcon(imagem);
	m.setIcon(imagem);
	n.setIcon(imagem);
	o.setIcon(imagem);
	p.setIcon(imagem);
	q.setIcon(imagem);
	r.setIcon(imagem);
	t.setIcon(imagem);
	u.setIcon(imagem);
	v.setIcon(imagem);
	w.setIcon(imagem);
	x.setIcon(imagem);
	y.setIcon(imagem);
	z.setIcon(imagem);
	letters.add(a);
	letters.add(b);
	letters.add(c);
	letters.add(d);
	letters.add(e);
	letters.add(g);
	letters.add(h);
	letters.add(i);
	letters.add(j);
	letters.add(k);
	letters.add(l);
	letters.add(m);
	letters.add(n);
	letters.add(o);
	letters.add(p);
	letters.add(q);
	letters.add(r);
	letters.add(t);
	letters.add(u);
	letters.add(v);
	letters.add(w);
	letters.add(x);
	letters.add(y);
	letters.add(z);
	c1=new JButton();
	c2=new JButton();
	c3=new JButton();
	c4=new JButton();
	c5=new JButton();
	lettersc.add(c1);
	lettersc.add(c2);
	lettersc.add(c3);
	lettersc.add(c4);
	lettersc.add(c5);
	grid.removeAll();
	for (int i=4; i>-1 ; i--) {
		for( int j=0 ; j<5; j++) {
			if(game.getBoard()[i][j]==null) {
				grid.add(letters.get(0));
				letters.remove(0).addActionListener(this);
				grid.repaint();
				grid.revalidate();
			} else if(game.getBoard()[i][j] instanceof Cover) {
				ImageIcon CIm= new ImageIcon("coverrr.png");
				
				Cover c=(Cover) game.getBoard()[i][j];
				cover.add(c);
				lettersc.get(0).setText(" Cover HP :"+c.getCurrentHP());
				lettersc.get(0).setIcon(CIm);
				lettersc.get(0).addActionListener(this);
				lettersc.get(0).setHorizontalTextPosition(JButton.CENTER);
				lettersc.get(0).setVerticalTextPosition(JButton.TOP); 
				grid.add(lettersc.remove(0));
				grid.repaint();
				grid.revalidate();
			} else {
				Player P;
				Champion now= (Champion) game.getBoard()[i][j];
				if(f.getTeam().contains(now))
					P= game.getFirstPlayer();
				else
					P= game.getSecondPlayer();
				
				switch(now.getName() ) {
				case "Captain America": 
					ImageIcon CapIm= new ImageIcon("CapI.png");
					if(f.getTeam().size()!=0)
                    if(f.getTeam().get(0)==now) {
                    	ff= new JButton(P.getName()+" Captain America",CapIm);
    					ff.setHorizontalTextPosition(JButton.CENTER);
    					ff.setVerticalTextPosition(JButton.TOP); 
    					ff.addActionListener(this);
    					grid.add(ff);
                    }
                    if(f.getTeam().size()==3||f.getTeam().size()==2)
                    if(f.getTeam().get(1)==now) {
                    	fs= new JButton(P.getName()+" Captain America",CapIm);
    					fs.setHorizontalTextPosition(JButton.CENTER);
    					fs.setVerticalTextPosition(JButton.TOP); 
    					fs.addActionListener(this);
    					grid.add(fs);
                    }
                    if(f.getTeam().size()==3)
                    if(f.getTeam().get(2)==now) {
                    	ft= new JButton(P.getName()+ " Captain America",CapIm);
    					ft.setHorizontalTextPosition(JButton.CENTER);
    					ft.setVerticalTextPosition(JButton.TOP); 
    					ft.addActionListener(this);
    					grid.add(ft);
                    }
                    if(s.getTeam().size()!=0)
                    if(s.getTeam().get(0)==now) {
                    	sf= new JButton(P.getName()+" Captain America",CapIm);
    					sf.setHorizontalTextPosition(JButton.CENTER);
    					sf.setVerticalTextPosition(JButton.TOP); 
    					sf.addActionListener(this);
    					grid.add(sf);
                    }
                    if(s.getTeam().size()==3||s.getTeam().size()==2)
                    if(s.getTeam().get(1)==now) {
                    	ss= new JButton(P.getName()+" Captain America",CapIm);
    					ss.setHorizontalTextPosition(JButton.CENTER);
    					ss.setVerticalTextPosition(JButton.TOP); 
    					ss.addActionListener(this);
    					grid.add(ss);
                    }
                    if(s.getTeam().size()==3)
                    if(s.getTeam().get(2)==now) {
                    	st= new JButton(P.getName()+" Captain America",CapIm);
    					st.setHorizontalTextPosition(JButton.CENTER);
    					st.setVerticalTextPosition(JButton.TOP); 
    					st.addActionListener(this);
    					grid.add(st);
                    }
                    

					grid.repaint();
					grid.revalidate();break;
				case "Electro":
					ImageIcon ElIm= new ImageIcon("ElectI.png");
					if(f.getTeam().size()!=0)
	                    if(f.getTeam().get(0)==now) {
	                    	ff= new JButton(P.getName()+" Electro",ElIm);
	    					ff.setHorizontalTextPosition(JButton.CENTER);
	    					ff.setVerticalTextPosition(JButton.TOP); 
	    					ff.addActionListener(this);
	    					grid.add(ff);
	                    }
	                    if(f.getTeam().size()==3||f.getTeam().size()==2)
	                    if(f.getTeam().get(1)==now) {
	                    	fs= new JButton(P.getName()+" Electro",ElIm);
	    					fs.setHorizontalTextPosition(JButton.CENTER);
	    					fs.setVerticalTextPosition(JButton.TOP); 
	    					fs.addActionListener(this);
	    					grid.add(fs);
	                    }
	                    if(f.getTeam().size()==3)
	                    if(f.getTeam().get(2)==now) {
	                    	ft= new JButton(P.getName()+" Electro",ElIm);
	    					ft.setHorizontalTextPosition(JButton.CENTER);
	    					ft.setVerticalTextPosition(JButton.TOP); 
	    					ft.addActionListener(this);
	    					grid.add(ft);
	                    }
	                    if(s.getTeam().size()!=0)
	                    if(s.getTeam().get(0)==now) {
	                    	sf= new JButton(P.getName()+" Electro",ElIm);
	    					sf.setHorizontalTextPosition(JButton.CENTER);
	    					sf.setVerticalTextPosition(JButton.TOP); 
	    					sf.addActionListener(this);
	    					grid.add(sf);
	                    }
	                    if(s.getTeam().size()==3||s.getTeam().size()==2)
	                    if(s.getTeam().get(1)==now) {
	                    	ss= new JButton(P.getName()+" Electro",ElIm);
	    					ss.setHorizontalTextPosition(JButton.CENTER);
	    					ss.setVerticalTextPosition(JButton.TOP); 
	    					ss.addActionListener(this);
	    					grid.add(ss);
	                    }
	                    if(s.getTeam().size()==3)
	                    if(s.getTeam().get(2)==now) {
	                    	st= new JButton(P.getName()+" Electro",ElIm);
	    					st.setHorizontalTextPosition(JButton.CENTER);
	    					st.setVerticalTextPosition(JButton.TOP); 
	    					st.addActionListener(this);
	    					grid.add(st);
	                    }
	                    

					grid.repaint();
					grid.revalidate();break;
				case "Hulk":
					ImageIcon HuIm= new ImageIcon("HulkI.png");
					if(f.getTeam().size()!=0)
	                    if(f.getTeam().get(0)==now) {
	                    	ff= new JButton(P.getName()+" "+ now.getName(),HuIm);
	    					ff.setHorizontalTextPosition(JButton.CENTER);
	    					ff.setVerticalTextPosition(JButton.TOP); 
	    					ff.addActionListener(this);
	    					grid.add(ff);
	                    }
	                    if(f.getTeam().size()==3||f.getTeam().size()==2)
	                    if(f.getTeam().get(1)==now) {
	                    	fs= new JButton(P.getName()+" "+ now.getName(),HuIm);
	    					fs.setHorizontalTextPosition(JButton.CENTER);
	    					fs.setVerticalTextPosition(JButton.TOP); 
	    					fs.addActionListener(this);
	    					grid.add(fs);
	                    }
	                    if(f.getTeam().size()==3)
	                    if(f.getTeam().get(2)==now) {
	                    	ft= new JButton(P.getName()+" "+ now.getName(),HuIm);
	    					ft.setHorizontalTextPosition(JButton.CENTER);
	    					ft.setVerticalTextPosition(JButton.TOP); 
	    					ft.addActionListener(this);
	    					grid.add(ft);
	                    }
	                    if(s.getTeam().size()!=0)
	                    if(s.getTeam().get(0)==now) {
	                    	sf= new JButton(P.getName()+" "+ now.getName(),HuIm);
	    					sf.setHorizontalTextPosition(JButton.CENTER);
	    					sf.setVerticalTextPosition(JButton.TOP); 
	    					sf.addActionListener(this);
	    					grid.add(sf);
	                    }
	                    if(s.getTeam().size()==3||s.getTeam().size()==2)
	                    if(s.getTeam().get(1)==now) {
	                    	ss= new JButton(P.getName()+" "+ now.getName(),HuIm);
	    					ss.setHorizontalTextPosition(JButton.CENTER);
	    					ss.setVerticalTextPosition(JButton.TOP); 
	    					ss.addActionListener(this);
	    					grid.add(ss);
	                    }
	                    if(s.getTeam().size()==3)
	                    if(s.getTeam().get(2)==now) {
	                    	st= new JButton(P.getName()+" "+ now.getName(),HuIm);
	    					st.setHorizontalTextPosition(JButton.CENTER);
	    					st.setVerticalTextPosition(JButton.TOP); 
	    					st.addActionListener(this);
	    					grid.add(st);
	                    }
	                    

					grid.repaint();
					grid.revalidate();break;
				case "Venom":
					ImageIcon VIm= new ImageIcon("VenomI.png");
					if(f.getTeam().size()!=0)
	                    if(f.getTeam().get(0)==now) {
	                    	ff= new JButton(P.getName()+" "+ now.getName(),VIm);
	    					ff.setHorizontalTextPosition(JButton.CENTER);
	    					ff.setVerticalTextPosition(JButton.TOP); 
	    					ff.addActionListener(this);
	    					grid.add(ff);
	                    }
	                    if(f.getTeam().size()==3||f.getTeam().size()==2)
	                    if(f.getTeam().get(1)==now) {
	                    	fs= new JButton(P.getName()+" "+ now.getName(),VIm);
	    					fs.setHorizontalTextPosition(JButton.CENTER);
	    					fs.setVerticalTextPosition(JButton.TOP); 
	    					fs.addActionListener(this);
	    					grid.add(fs);
	                    }
	                    if(f.getTeam().size()==3)
	                    if(f.getTeam().get(2)==now) {
	                    	ft= new JButton(P.getName()+" "+ now.getName(),VIm);
	    					ft.setHorizontalTextPosition(JButton.CENTER);
	    					ft.setVerticalTextPosition(JButton.TOP); 
	    					ft.addActionListener(this);
	    					grid.add(ft);
	                    }
	                    if(s.getTeam().size()!=0)
	                    if(s.getTeam().get(0)==now) {
	                    	sf= new JButton(P.getName()+" "+ now.getName(),VIm);
	    					sf.setHorizontalTextPosition(JButton.CENTER);
	    					sf.setVerticalTextPosition(JButton.TOP); 
	    					sf.addActionListener(this);
	    					grid.add(sf);
	                    }
	                    if(s.getTeam().size()==3||s.getTeam().size()==2)
	                    if(s.getTeam().get(1)==now) {
	                    	ss= new JButton(P.getName()+" "+ now.getName(),VIm);
	    					ss.setHorizontalTextPosition(JButton.CENTER);
	    					ss.setVerticalTextPosition(JButton.TOP); 
	    					ss.addActionListener(this);
	    					grid.add(ss);
	                    }
	                    if(s.getTeam().size()==3)
	                    if(s.getTeam().get(2)==now) {
	                    	st= new JButton(P.getName()+" "+ now.getName(),VIm);
	    					st.setHorizontalTextPosition(JButton.CENTER);
	    					st.setVerticalTextPosition(JButton.TOP); 
	    					st.addActionListener(this);
	    					grid.add(st);
	                    }
	                    

					grid.repaint();
					grid.revalidate();break;
				case "Ironman":
					ImageIcon IIm= new ImageIcon("IronI.png");
					if(f.getTeam().size()!=0)
	                    if(f.getTeam().get(0)==now) {
	                    	ff= new JButton(P.getName()+" "+ now.getName(),IIm);
	    					ff.setHorizontalTextPosition(JButton.CENTER);
	    					ff.setVerticalTextPosition(JButton.TOP); 
	    					ff.addActionListener(this);
	    					grid.add(ff);
	                    }
	                    if(f.getTeam().size()==3||f.getTeam().size()==2)
	                    if(f.getTeam().get(1)==now) {
	                    	fs= new JButton(P.getName()+" "+ now.getName(),IIm);
	    					fs.setHorizontalTextPosition(JButton.CENTER);
	    					fs.setVerticalTextPosition(JButton.TOP); 
	    					fs.addActionListener(this);
	    					grid.add(fs);
	                    }
	                    if(f.getTeam().size()==3)
	                    if(f.getTeam().get(2)==now) {
	                    	ft= new JButton(P.getName()+" "+ now.getName(),IIm);
	    					ft.setHorizontalTextPosition(JButton.CENTER);
	    					ft.setVerticalTextPosition(JButton.TOP); 
	    					ft.addActionListener(this);
	    					grid.add(ft);
	                    }
	                    if(s.getTeam().size()!=0)
	                    if(s.getTeam().get(0)==now) {
	                    	sf= new JButton(P.getName()+" "+ now.getName(),IIm);
	    					sf.setHorizontalTextPosition(JButton.CENTER);
	    					sf.setVerticalTextPosition(JButton.TOP); 
	    					sf.addActionListener(this);
	    					grid.add(sf);
	                    }
	                    if(s.getTeam().size()==3||s.getTeam().size()==2)
	                    if(s.getTeam().get(1)==now) {
	                    	ss= new JButton(P.getName()+" "+ now.getName(),IIm);
	    					ss.setHorizontalTextPosition(JButton.CENTER);
	    					ss.setVerticalTextPosition(JButton.TOP); 
	    					ss.addActionListener(this);
	    					grid.add(ss);
	                    }
	                    if(s.getTeam().size()==3)
	                    if(s.getTeam().get(2)==now) {
	                    	st= new JButton(P.getName()+" "+ now.getName(),IIm);
	    					st.setHorizontalTextPosition(JButton.CENTER);
	    					st.setVerticalTextPosition(JButton.TOP); 
	    					st.addActionListener(this);
	    					grid.add(st);
	                    }
	                    

					grid.repaint();
					grid.revalidate();break;
				case "Hela":
					ImageIcon Hm= new ImageIcon("HelaI.png");
					if(f.getTeam().size()!=0)
	                    if(f.getTeam().get(0)==now) {
	                    	ff= new JButton(P.getName()+" "+ now.getName(),Hm);
	    					ff.setHorizontalTextPosition(JButton.CENTER);
	    					ff.setVerticalTextPosition(JButton.TOP); 
	    					ff.addActionListener(this);
	    					grid.add(ff);
	                    }
	                    if(f.getTeam().size()==3||f.getTeam().size()==2)
	                    if(f.getTeam().get(1)==now) {
	                    	fs= new JButton(P.getName()+" "+ now.getName(),Hm);
	    					fs.setHorizontalTextPosition(JButton.CENTER);
	    					fs.setVerticalTextPosition(JButton.TOP); 
	    					fs.addActionListener(this);
	    					grid.add(fs);
	                    }
	                    if(f.getTeam().size()==3)
	                    if(f.getTeam().get(2)==now) {
	                    	ft= new JButton(P.getName()+" "+ now.getName(),Hm);
	    					ft.setHorizontalTextPosition(JButton.CENTER);
	    					ft.setVerticalTextPosition(JButton.TOP); 
	    					ft.addActionListener(this);
	    					grid.add(ft);
	                    }
	                    if(s.getTeam().size()!=0)
	                    if(s.getTeam().get(0)==now) {
	                    	sf= new JButton(P.getName()+" "+ now.getName(),Hm);
	    					sf.setHorizontalTextPosition(JButton.CENTER);
	    					sf.setVerticalTextPosition(JButton.TOP); 
	    					sf.addActionListener(this);
	    					grid.add(sf);
	                    }
	                    if(s.getTeam().size()==3||s.getTeam().size()==2)
	                    if(s.getTeam().get(1)==now) {
	                    	ss= new JButton(P.getName()+" "+ now.getName(),Hm);
	    					ss.setHorizontalTextPosition(JButton.CENTER);
	    					ss.setVerticalTextPosition(JButton.TOP); 
	    					ss.addActionListener(this);
	    					grid.add(ss);
	                    }
	                    if(s.getTeam().size()==3)
	                    if(s.getTeam().get(2)==now) {
	                    	st= new JButton(P.getName()+" "+ now.getName(),Hm);
	    					st.setHorizontalTextPosition(JButton.CENTER);
	    					st.setVerticalTextPosition(JButton.TOP); 
	    					st.addActionListener(this);
	    					grid.add(st);
	                    }
	                    

					grid.repaint();
					grid.revalidate();break;
				case "Iceman":
					ImageIcon Icm= new ImageIcon("IceI.png");
					if(f.getTeam().size()!=0)
	                    if(f.getTeam().get(0)==now) {
	                    	ff= new JButton(P.getName()+" "+ now.getName(),Icm);
	    					ff.setHorizontalTextPosition(JButton.CENTER);
	    					ff.setVerticalTextPosition(JButton.TOP); 
	    					ff.addActionListener(this);
	    					grid.add(ff);
	                    }
	                    if(f.getTeam().size()==3||f.getTeam().size()==2)
	                    if(f.getTeam().get(1)==now) {
	                    	fs= new JButton(P.getName()+" "+ now.getName(),Icm);
	    					fs.setHorizontalTextPosition(JButton.CENTER);
	    					fs.setVerticalTextPosition(JButton.TOP); 
	    					fs.addActionListener(this);
	    					grid.add(fs);
	                    }
	                    if(f.getTeam().size()==3)
	                    if(f.getTeam().get(2)==now) {
	                    	ft= new JButton(P.getName()+" "+ now.getName(),Icm);
	    					ft.setHorizontalTextPosition(JButton.CENTER);
	    					ft.setVerticalTextPosition(JButton.TOP); 
	    					ft.addActionListener(this);
	    					grid.add(ft);
	                    }
	                    if(s.getTeam().size()!=0)
	                    if(s.getTeam().get(0)==now) {
	                    	sf= new JButton(P.getName()+" "+ now.getName(),Icm);
	    					sf.setHorizontalTextPosition(JButton.CENTER);
	    					sf.setVerticalTextPosition(JButton.TOP); 
	    					sf.addActionListener(this);
	    					grid.add(sf);
	                    }
	                    if(s.getTeam().size()==3||s.getTeam().size()==2)
	                    if(s.getTeam().get(1)==now) {
	                    	ss= new JButton(P.getName()+" "+ now.getName(),Icm);
	    					ss.setHorizontalTextPosition(JButton.CENTER);
	    					ss.setVerticalTextPosition(JButton.TOP); 
	    					ss.addActionListener(this);
	    					grid.add(ss);
	                    }
	                    if(s.getTeam().size()==3)
	                    if(s.getTeam().get(2)==now) {
	                    	st= new JButton(P.getName()+" "+ now.getName(),Icm);
	    					st.setHorizontalTextPosition(JButton.CENTER);
	    					st.setVerticalTextPosition(JButton.TOP); 
	    					st.addActionListener(this);
	    					grid.add(st);
	                    }
	                    

					grid.repaint();
					grid.revalidate();break;
				
			case  "Spiderman":
				ImageIcon Sm= new ImageIcon("Spid.png");
				if(f.getTeam().size()!=0)
                    if(f.getTeam().get(0)==now) {
                    	ff= new JButton(P.getName()+" "+ now.getName(),Sm);
    					ff.setHorizontalTextPosition(JButton.CENTER);
    					ff.setVerticalTextPosition(JButton.TOP); 
    					ff.addActionListener(this);
    					grid.add(ff);
                    }
                    if(f.getTeam().size()==3||f.getTeam().size()==2)
                    if(f.getTeam().get(1)==now) {
                    	fs= new JButton(P.getName()+" "+ now.getName(),Sm);
    					fs.setHorizontalTextPosition(JButton.CENTER);
    					fs.setVerticalTextPosition(JButton.TOP); 
    					fs.addActionListener(this);
    					grid.add(fs);
                    }
                    if(f.getTeam().size()==3)
                    if(f.getTeam().get(2)==now) {
                    	ft= new JButton(P.getName()+" "+ now.getName(),Sm);
    					ft.setHorizontalTextPosition(JButton.CENTER);
    					ft.setVerticalTextPosition(JButton.TOP); 
    					ft.addActionListener(this);
    					grid.add(ft);
                    }
                    if(s.getTeam().size()!=0)
                    if(s.getTeam().get(0)==now) {
                    	sf= new JButton(P.getName()+" "+ now.getName(),Sm);
    					sf.setHorizontalTextPosition(JButton.CENTER);
    					sf.setVerticalTextPosition(JButton.TOP); 
    					sf.addActionListener(this);
    					grid.add(sf);
                    }
                    if(s.getTeam().size()==3||s.getTeam().size()==2)
                    if(s.getTeam().get(1)==now) {
                    	ss= new JButton(P.getName()+" "+ now.getName(),Sm);
    					ss.setHorizontalTextPosition(JButton.CENTER);
    					ss.setVerticalTextPosition(JButton.TOP); 
    					ss.addActionListener(this);
    					grid.add(ss);
                    }
                    if(s.getTeam().size()==3)
                    if(s.getTeam().get(2)==now) {
                    	st= new JButton(P.getName()+" "+ now.getName(),Sm);
    					st.setHorizontalTextPosition(JButton.CENTER);
    					st.setVerticalTextPosition(JButton.TOP); 
    					st.addActionListener(this);
    					grid.add(st);
                    }
                    

				grid.repaint();
				grid.revalidate();break;
			case  "Ghost Rider":
				ImageIcon Gm= new ImageIcon("Ghos.png");
//				JButton G= new JButton(P.getName()+" "+ now.getName(),Gm);
				if(f.getTeam().size()!=0)
                    if(f.getTeam().get(0)==now) {
                    	ff= new JButton(P.getName()+" "+ now.getName(),Gm);
    					ff.setHorizontalTextPosition(JButton.CENTER);
    					ff.setVerticalTextPosition(JButton.TOP); 
    					ff.addActionListener(this);
    					grid.add(ff);
                    }
                    if(f.getTeam().size()==3||f.getTeam().size()==2)
                    if(f.getTeam().get(1)==now) {
                    	fs= new JButton(P.getName()+" "+ now.getName(),Gm);
    					fs.setHorizontalTextPosition(JButton.CENTER);
    					fs.setVerticalTextPosition(JButton.TOP); 
    					fs.addActionListener(this);
    					grid.add(fs);
                    }
                    if(f.getTeam().size()==3)
                    if(f.getTeam().get(2)==now) {
                    	ft= new JButton(P.getName()+" "+ now.getName(),Gm);
    					ft.setHorizontalTextPosition(JButton.CENTER);
    					ft.setVerticalTextPosition(JButton.TOP); 
    					ft.addActionListener(this);
    					grid.add(ft);
                    }
                    if(s.getTeam().size()!=0)
                    if(s.getTeam().get(0)==now) {
                    	sf= new JButton(P.getName()+" "+ now.getName(),Gm);
    					sf.setHorizontalTextPosition(JButton.CENTER);
    					sf.setVerticalTextPosition(JButton.TOP); 
    					sf.addActionListener(this);
    					grid.add(sf);
                    }
                    if(s.getTeam().size()==3||s.getTeam().size()==2)
                    if(s.getTeam().get(1)==now) {
                    	ss= new JButton(P.getName()+" "+ now.getName(),Gm);
    					ss.setHorizontalTextPosition(JButton.CENTER);
    					ss.setVerticalTextPosition(JButton.TOP); 
    					ss.addActionListener(this);
    					grid.add(ss);
                    }
                    if(s.getTeam().size()==3)
                    if(s.getTeam().get(2)==now) {
                    	st= new JButton(P.getName()+" "+ now.getName(),Gm);
    					st.setHorizontalTextPosition(JButton.CENTER);
    					st.setVerticalTextPosition(JButton.TOP); 
    					st.addActionListener(this);
    					grid.add(st);
                    }
                    

				grid.repaint();
				grid.revalidate();break;
			case  "Deadpool":
				ImageIcon Dm= new ImageIcon("Deadi.png");
				if(f.getTeam().size()!=0)
                    if(f.getTeam().get(0)==now) {
                    	ff= new JButton(P.getName()+" "+ now.getName(),Dm);
    					ff.setHorizontalTextPosition(JButton.CENTER);
    					ff.setVerticalTextPosition(JButton.TOP); 
    					ff.addActionListener(this);
    					grid.add(ff);
                    }
                    if(f.getTeam().size()==3||f.getTeam().size()==2)
                    if(f.getTeam().get(1)==now) {
                    	fs= new JButton(P.getName()+" "+ now.getName(),Dm);
    					fs.setHorizontalTextPosition(JButton.CENTER);
    					fs.setVerticalTextPosition(JButton.TOP); 
    					fs.addActionListener(this);
    					grid.add(fs);
                    }
                    if(f.getTeam().size()==3)
                    if(f.getTeam().get(2)==now) {
                    	ft= new JButton(P.getName()+" "+ now.getName(),Dm);
    					ft.setHorizontalTextPosition(JButton.CENTER);
    					ft.setVerticalTextPosition(JButton.TOP); 
    					ft.addActionListener(this);
    					grid.add(ft);
                    }
                    if(s.getTeam().size()!=0)
                    if(s.getTeam().get(0)==now) {
                    	sf= new JButton(P.getName()+" "+ now.getName(),Dm);
    					sf.setHorizontalTextPosition(JButton.CENTER);
    					sf.setVerticalTextPosition(JButton.TOP); 
    					sf.addActionListener(this);
    					grid.add(sf);
                    }
                    if(s.getTeam().size()==3||s.getTeam().size()==2)
                    if(s.getTeam().get(1)==now) {
                    	ss= new JButton(P.getName()+" "+ now.getName(),Dm);
    					ss.setHorizontalTextPosition(JButton.CENTER);
    					ss.setVerticalTextPosition(JButton.TOP); 
    					ss.addActionListener(this);
    					grid.add(ss);
                    }
                    if(s.getTeam().size()==3)
                    if(s.getTeam().get(2)==now) {
                    	st= new JButton(P.getName()+" "+ now.getName(),Dm);
    					st.setHorizontalTextPosition(JButton.CENTER);
    					st.setVerticalTextPosition(JButton.TOP); 
    					st.addActionListener(this);
    					grid.add(st);
                    }
                    

				grid.repaint();
				grid.revalidate();break;
			case  "Yellow Jacket":
				ImageIcon Ym= new ImageIcon("YellowI.png");
				if(f.getTeam().size()!=0)
                    if(f.getTeam().get(0)==now) {
                    	ff= new JButton(P.getName()+" "+ now.getName(),Ym);
    					ff.setHorizontalTextPosition(JButton.CENTER);
    					ff.setVerticalTextPosition(JButton.TOP); 
    					ff.addActionListener(this);
    					grid.add(ff);
                    }
                    if(f.getTeam().size()==3||f.getTeam().size()==2)
                    if(f.getTeam().get(1)==now) {
                    	fs= new JButton(P.getName()+" "+ now.getName(),Ym);
    					fs.setHorizontalTextPosition(JButton.CENTER);
    					fs.setVerticalTextPosition(JButton.TOP); 
    					fs.addActionListener(this);
    					grid.add(fs);
                    }
                    if(f.getTeam().size()==3)
                    if(f.getTeam().get(2)==now) {
                    	ft= new JButton(P.getName()+" "+ now.getName(),Ym);
    					ft.setHorizontalTextPosition(JButton.CENTER);
    					ft.setVerticalTextPosition(JButton.TOP); 
    					ft.addActionListener(this);
    					grid.add(ft);
                    }
                    if(s.getTeam().size()!=0)
                    if(s.getTeam().get(0)==now) {
                    	sf= new JButton(P.getName()+" "+ now.getName(),Ym);
    					sf.setHorizontalTextPosition(JButton.CENTER);
    					sf.setVerticalTextPosition(JButton.TOP); 
    					sf.addActionListener(this);
    					grid.add(sf);
                    }
                    if(s.getTeam().size()==3||s.getTeam().size()==2)
                    if(s.getTeam().get(1)==now) {
                    	ss= new JButton(P.getName()+" "+ now.getName(),Ym);
    					ss.setHorizontalTextPosition(JButton.CENTER);
    					ss.setVerticalTextPosition(JButton.TOP); 
    					ss.addActionListener(this);
    					grid.add(ss);
                    }
                    if(s.getTeam().size()==3)
                    if(s.getTeam().get(2)==now) {
                    	st= new JButton(P.getName()+" "+ now.getName(),Ym);
    					st.setHorizontalTextPosition(JButton.CENTER);
    					st.setVerticalTextPosition(JButton.TOP); 
    					st.addActionListener(this);
    					grid.add(st);
                    }
                    

				grid.repaint();
				grid.revalidate();break;
			case  "Thor":
				ImageIcon Tm= new ImageIcon("ThorI.png");
				if(f.getTeam().size()!=0)
                    if(f.getTeam().get(0)==now) {
                    	ff= new JButton(P.getName()+" "+ now.getName(),Tm);
    					ff.setHorizontalTextPosition(JButton.CENTER);
    					ff.setVerticalTextPosition(JButton.TOP); 
    					ff.addActionListener(this);
    					grid.add(ff);
                    }
                    if(f.getTeam().size()==3||f.getTeam().size()==2)
                    if(f.getTeam().get(1)==now) {
                    	fs= new JButton(P.getName()+" "+ now.getName(),Tm);
    					fs.setHorizontalTextPosition(JButton.CENTER);
    					fs.setVerticalTextPosition(JButton.TOP); 
    					fs.addActionListener(this);
    					grid.add(fs);
                    }
                    if(f.getTeam().size()==3)
                    if(f.getTeam().get(2)==now) {
                    	ft= new JButton(P.getName()+" "+ now.getName(),Tm);
    					ft.setHorizontalTextPosition(JButton.CENTER);
    					ft.setVerticalTextPosition(JButton.TOP); 
    					ft.addActionListener(this);
    					grid.add(ft);
                    }
                    if(s.getTeam().size()!=0)
                    if(s.getTeam().get(0)==now) {
                    	sf= new JButton(P.getName()+" "+ now.getName(),Tm);
    					sf.setHorizontalTextPosition(JButton.CENTER);
    					sf.setVerticalTextPosition(JButton.TOP); 
    					sf.addActionListener(this);
    					grid.add(sf);
                    }
                    if(s.getTeam().size()==3||s.getTeam().size()==2)
                    if(s.getTeam().get(1)==now) {
                    	ss= new JButton(P.getName()+" "+ now.getName(),Tm);
    					ss.setHorizontalTextPosition(JButton.CENTER);
    					ss.setVerticalTextPosition(JButton.TOP); 
    					ss.addActionListener(this);
    					grid.add(ss);
                    }
                    if(s.getTeam().size()==3)
                    if(s.getTeam().get(2)==now) {
                    	st= new JButton(P.getName()+" "+ now.getName(),Tm);
    					st.setHorizontalTextPosition(JButton.CENTER);
    					st.setVerticalTextPosition(JButton.TOP); 
    					st.addActionListener(this);
    					grid.add(st);
                    }
                    

				grid.repaint();
				grid.revalidate();break;
			case  "Loki":
				ImageIcon Lm= new ImageIcon("LokiI.png");
				if(f.getTeam().size()!=0)
                    if(f.getTeam().get(0)==now) {
                    	ff= new JButton(P.getName()+" "+ now.getName(),Lm);
    					ff.setHorizontalTextPosition(JButton.CENTER);
    					ff.setVerticalTextPosition(JButton.TOP); 
    					ff.addActionListener(this);
    					grid.add(ff);
                    }
                    if(f.getTeam().size()==3||f.getTeam().size()==2)
                    if(f.getTeam().get(1)==now) {
                    	fs= new JButton(P.getName()+" "+ now.getName(),Lm);
    					fs.setHorizontalTextPosition(JButton.CENTER);
    					fs.setVerticalTextPosition(JButton.TOP); 
    					fs.addActionListener(this);
    					grid.add(fs);
                    }
                    if(f.getTeam().size()==3)
                    if(f.getTeam().get(2)==now) {
                    	ft= new JButton(P.getName()+" "+ now.getName(),Lm);
    					ft.setHorizontalTextPosition(JButton.CENTER);
    					ft.setVerticalTextPosition(JButton.TOP); 
    					ft.addActionListener(this);
    					grid.add(ft);
                    }
                    if(s.getTeam().size()!=0)
                    if(s.getTeam().get(0)==now) {
                    	sf= new JButton(P.getName()+" "+ now.getName(),Lm);
    					sf.setHorizontalTextPosition(JButton.CENTER);
    					sf.setVerticalTextPosition(JButton.TOP); 
    					sf.addActionListener(this);
    					grid.add(sf);
                    }
                    if(s.getTeam().size()==3||s.getTeam().size()==2)
                    if(s.getTeam().get(1)==now) {
                    	ss= new JButton(P.getName()+" "+ now.getName(),Lm);
    					ss.setHorizontalTextPosition(JButton.CENTER);
    					ss.setVerticalTextPosition(JButton.TOP); 
    					ss.addActionListener(this);
    					grid.add(ss);
                    }
                    if(s.getTeam().size()==3)
                    if(s.getTeam().get(2)==now) {
                    	st= new JButton(P.getName()+" "+ now.getName(),Lm);
    					st.setHorizontalTextPosition(JButton.CENTER);
    					st.setVerticalTextPosition(JButton.TOP); 
    					st.addActionListener(this);
    					grid.add(st);
                    }
                    

				grid.repaint();
				grid.revalidate();break;
			case  "Dr Strange":
				ImageIcon Drm= new ImageIcon("DrI.png");
				if(f.getTeam().size()!=0)
                    if(f.getTeam().get(0)==now) {
                    	ff= new JButton(P.getName()+" "+ now.getName(),Drm);
    					ff.setHorizontalTextPosition(JButton.CENTER);
    					ff.setVerticalTextPosition(JButton.TOP); 
    					ff.addActionListener(this);
    					grid.add(ff);
                    }
                    if(f.getTeam().size()==3||f.getTeam().size()==2)
                    if(f.getTeam().get(1)==now) {
                    	fs= new JButton(P.getName()+" "+ now.getName(),Drm);
    					fs.setHorizontalTextPosition(JButton.CENTER);
    					fs.setVerticalTextPosition(JButton.TOP); 
    					fs.addActionListener(this);
    					grid.add(fs);
                    }
                    if(f.getTeam().size()==3)
                    if(f.getTeam().get(2)==now) {
                    	ft= new JButton(P.getName()+" "+ now.getName(),Drm);
    					ft.setHorizontalTextPosition(JButton.CENTER);
    					ft.setVerticalTextPosition(JButton.TOP); 
    					ft.addActionListener(this);
    					grid.add(ft);
                    }
                    if(s.getTeam().size()!=0)
                    if(s.getTeam().get(0)==now) {
                    	sf= new JButton(P.getName()+" "+ now.getName(),Drm);
    					sf.setHorizontalTextPosition(JButton.CENTER);
    					sf.setVerticalTextPosition(JButton.TOP); 
    					sf.addActionListener(this);
    					grid.add(sf);
                    }
                    if(s.getTeam().size()==3||s.getTeam().size()==2)
                    if(s.getTeam().get(1)==now) {
                    	ss= new JButton(P.getName()+" "+ now.getName(),Drm);
    					ss.setHorizontalTextPosition(JButton.CENTER);
    					ss.setVerticalTextPosition(JButton.TOP); 
    					ss.addActionListener(this);
    					grid.add(ss);
                    }
                    if(s.getTeam().size()==3)
                    if(s.getTeam().get(2)==now) {
                    	st= new JButton(P.getName()+" "+ now.getName(),Drm);
    					st.setHorizontalTextPosition(JButton.CENTER);
    					st.setVerticalTextPosition(JButton.TOP); 
    					st.addActionListener(this);
    					grid.add(st);
                    }
                    

				grid.repaint();
				grid.revalidate();break;
			case  "Quicksilver":
				ImageIcon qrm= new ImageIcon("QuickI.png");
				if(f.getTeam().size()!=0)
                    if(f.getTeam().get(0)==now) {
                    	ff= new JButton(P.getName()+" "+ now.getName(),qrm);
    					ff.setHorizontalTextPosition(JButton.CENTER);
    					ff.setVerticalTextPosition(JButton.TOP); 
    					ff.addActionListener(this);
    					grid.add(ff);
                    }
                    if(f.getTeam().size()==3||f.getTeam().size()==2)
                    if(f.getTeam().get(1)==now) {
                    	fs= new JButton(P.getName()+" "+ now.getName(),qrm);
    					fs.setHorizontalTextPosition(JButton.CENTER);
    					fs.setVerticalTextPosition(JButton.TOP); 
    					fs.addActionListener(this);
    					grid.add(fs);
                    }
                    if(f.getTeam().size()==3)
                    if(f.getTeam().get(2)==now) {
                    	ft= new JButton(P.getName()+" "+ now.getName(),qrm);
    					ft.setHorizontalTextPosition(JButton.CENTER);
    					ft.setVerticalTextPosition(JButton.TOP); 
    					ft.addActionListener(this);
    					grid.add(ft);
                    }
                    if(s.getTeam().size()!=0)
                    if(s.getTeam().get(0)==now) {
                    	sf= new JButton(P.getName()+" "+ now.getName(),qrm);
    					sf.setHorizontalTextPosition(JButton.CENTER);
    					sf.setVerticalTextPosition(JButton.TOP); 
    					sf.addActionListener(this);
    					grid.add(sf);
                    }
                    if(s.getTeam().size()==3||s.getTeam().size()==2)
                    if(s.getTeam().get(1)==now) {
                    	ss= new JButton(P.getName()+" "+ now.getName(),qrm);
    					ss.setHorizontalTextPosition(JButton.CENTER);
    					ss.setVerticalTextPosition(JButton.TOP); 
    					ss.addActionListener(this);
    					grid.add(ss);
                    }
                    if(s.getTeam().size()==3)
                    if(s.getTeam().get(2)==now) {
                    	st= new JButton(P.getName()+" "+ now.getName(),qrm);
    					st.setHorizontalTextPosition(JButton.CENTER);
    					st.setVerticalTextPosition(JButton.TOP); 
    					st.addActionListener(this);
    					grid.add(st);
                    }
                    

				grid.repaint();
				grid.revalidate();break;
			
				
				}
				
			}}}
	
			
		
	}
public String champT (Champion C) {
	if (C instanceof Hero) {
		return " Hero";
		
	}else if( C instanceof Villain) {
		return " Villain";
	}
	else
		return " AntiHero";
}
public String champInfo(Champion C) {

    
	String s= C.getName()+  "\n"+ "Type:" +
			champT(C)+ " \n" + "Health: "+C.getCurrentHP()+"\n"+
			"Speed: "+C.getSpeed()+"\n"+
			"Actions: "+C.getCurrentActionPoints()+" \n"+"Mana: "+
			C.getMana()+ "\n" +"Attack Damage: "+C.getAttackDamage()+
		     "\n"+"Attack Range: "+ C.getAttackRange()+"\n ";
	if(C==f.getLeader()||C== this.s.getLeader())
		s=s+"Leader"+'\n';
	else
		s=s+"Not the Leader"+"\n";
	for(Effect e: C.getAppliedEffects() ) {
		s = s +"Effect Name:"+ e.getName()+"\n"+"Duration: " + e.getDuration()+"\n ";

	}

	
	return s;}

	public String abilityT (Ability A) {
		if (A instanceof DamagingAbility) {
			return "Damaging"+ "\n"+"Damage Amount:" + ((DamagingAbility) A).getDamageAmount();
			
		}else if( A instanceof CrowdControlAbility) {
			return "Crowd Control"+"\n"+ "Effect:" + ((CrowdControlAbility) A).getEffect().getName();}
		
		else
			return " Healing"+"\n"+" Heal Amount:" + ((HealingAbility) A).getHealAmount();
		
	}
	
	
	public void setLists() {
		Left.removeAll();
		Right.removeAll();
		middlel.removeAll();
		Player P;
	 	if(f.getTeam().contains(game.getCurrentChampion()))
	 	    P= game.getFirstPlayer();
	 	else
	 		 P= game.getSecondPlayer();
	Player first=game.getFirstPlayer();
	Player second=game.getSecondPlayer();
	String l=leadA(first)+"\n";
	String r=leadA(second)+"\n";
	String m="";
	String mr="";
	m=m+P.getName()+" is Playing"+"\n";
	m=m+"with " +game.getCurrentChampion().getName();
	//m=m+champInfo(game.getCurrentChampion());
mr= mr + "Turn Orders:" + "\n";
mr=mr+ turns(obj);
//mr=mr+"SCROLL UP FOR"+"\n"+"TURN ORDERS";

	middlel.setText(m);
	
	middler.setText(mr);	
	
	if(first.getTeam().size()!=0) {
		l=l+champInfo(first.getTeam().get(0))+"\n";
	}
	if(first.getTeam().size()==2||first.getTeam().size()==3)
		l=l+champInfo(first.getTeam().get(1))+"\n";
	if(first.getTeam().size()==3)
		l=l+champInfo(first.getTeam().get(2))+"\n";
	//l=l+"SCROLL UP FOR TEAM 1 INFO";
    Left.setText(l);
	if(second.getTeam().size()!=0) {
		r=r+champInfo(second.getTeam().get(0))+"\n";
	}
	if(second.getTeam().size()==2||second.getTeam().size()==3)
		r=r+champInfo(second.getTeam().get(1))+"\n";
	if(second.getTeam().size()==3)
		r=r+champInfo(second.getTeam().get(2))+"\n";
	//r=r+"SCROLL UP FOR TEAM 2 INFO";
    Right.setText(r);
	
	}
		



@Override
public void actionPerformed(ActionEvent e) {


	if(e.getSource()==endturn) {
		choose.setText("Choose your next action");
		game.endTurn();
		ability1.setText(game.getCurrentChampion().getAbilities().get(0).getName());
		ability2.setText(game.getCurrentChampion().getAbilities().get(1).getName());
		ability3.setText(game.getCurrentChampion().getAbilities().get(2).getName());
		obj.enqueue(obj.dequeue());
		setButtons(grid);
		setLists();
	}
	if(e.getSource()==leaderability) {
		try {
			game.useLeaderAbility();
			setButtons(grid);
			setLists();
			if(game.checkGameOver()==f){
				JOptionPane.showMessageDialog(this,f.getName(),"information",JOptionPane.INFORMATION_MESSAGE);
			    endturn.setEnabled(false);
				 ability1.setEnabled(false);
				  ability2.setEnabled(false);
				 ability3.setEnabled(false);
				 leaderability.setEnabled(false);
				 attack.setEnabled(false);
			     up.setEnabled(false);
				 down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
			}
			else if(game.checkGameOver()==s) {
				JOptionPane.showMessageDialog(this,s.getName(),"information",JOptionPane.INFORMATION_MESSAGE);
				  endturn.setEnabled(false);
					 ability1.setEnabled(false);
					  ability2.setEnabled(false);
					 ability3.setEnabled(false);
					 leaderability.setEnabled(false);
					 attack.setEnabled(false);
				
				     up.setEnabled(false);
					 down.setEnabled(false);
					left.setEnabled(false);
					right.setEnabled(false);
			}
		}
		catch(LeaderNotCurrentException x){
			JOptionPane.showMessageDialog(this,x.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
		catch(LeaderAbilityAlreadyUsedException x) {
			JOptionPane.showMessageDialog(this,x.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	if(e.getSource()==ff) {
		choose.setText("Choose your next action");
		try {
		int x=f.getTeam().get(0).getLocation().x;
		int y=f.getTeam().get(0).getLocation().y;
		if(indexAbility==0)
			game.castAbility(game.getCurrentChampion().getAbilities().get(0), x, y);
		if(indexAbility==1)
			game.castAbility(game.getCurrentChampion().getAbilities().get(1), x, y);
		if(indexAbility==2)
			game.castAbility(game.getCurrentChampion().getAbilities().get(2), x, y);
		setButtons(grid);
    	setLists(); 
		if(game.checkGameOver()!=null) {
			JOptionPane.showMessageDialog(this,game.checkGameOver().getName(),"information",JOptionPane.INFORMATION_MESSAGE);
			  endturn.setEnabled(false);
				 ability1.setEnabled(false);
				  ability2.setEnabled(false);
				 ability3.setEnabled(false);
				 leaderability.setEnabled(false);
				 attack.setEnabled(false);
			
			     up.setEnabled(false);
				 down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
		}
		}
        catch(NotEnoughResourcesException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(AbilityUseException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(CloneNotSupportedException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (InvalidTargetException e1) {
        	bability=false;
        	 JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	if(e.getSource()==fs) {
		choose.setText("Choose your next action");
		try {
		int x=f.getTeam().get(1).getLocation().x;
		int y=f.getTeam().get(1).getLocation().y;
		if(indexAbility==0)
			game.castAbility(game.getCurrentChampion().getAbilities().get(0), x, y);
		if(indexAbility==1)
			game.castAbility(game.getCurrentChampion().getAbilities().get(1), x, y);
		if(indexAbility==2)
			game.castAbility(game.getCurrentChampion().getAbilities().get(2), x, y);
		setButtons(grid);
    	setLists();
		
		if(game.checkGameOver()!=null) {
			JOptionPane.showMessageDialog(this,game.checkGameOver().getName(),"information",JOptionPane.INFORMATION_MESSAGE);
			  endturn.setEnabled(false);
				 ability1.setEnabled(false);
				  ability2.setEnabled(false);
				 ability3.setEnabled(false);
				 leaderability.setEnabled(false);
				 attack.setEnabled(false);
			
			     up.setEnabled(false);
				 down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
		}
		}
        catch(NotEnoughResourcesException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(AbilityUseException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(CloneNotSupportedException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (InvalidTargetException e1) {
        	bability=false;
        	 JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	if(e.getSource()==ft) {
		choose.setText("Choose your next action");
		try {
		int x=f.getTeam().get(2).getLocation().x;
		int y=f.getTeam().get(2).getLocation().y;
		if(indexAbility==0)
			game.castAbility(game.getCurrentChampion().getAbilities().get(0), x, y);
		if(indexAbility==1)
			game.castAbility(game.getCurrentChampion().getAbilities().get(1), x, y);
		if(indexAbility==2)
			game.castAbility(game.getCurrentChampion().getAbilities().get(2), x, y);
		setButtons(grid);
    	setLists();
		if(game.checkGameOver()!=null) {
			JOptionPane.showMessageDialog(this,game.checkGameOver().getName(),"information",JOptionPane.INFORMATION_MESSAGE);
			  endturn.setEnabled(false);
				 ability1.setEnabled(false);
				  ability2.setEnabled(false);
				 ability3.setEnabled(false);
				 leaderability.setEnabled(false);
				 attack.setEnabled(false);
			
			     up.setEnabled(false);
				 down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
		}

		}
        catch(NotEnoughResourcesException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(AbilityUseException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(CloneNotSupportedException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (InvalidTargetException e1) {
        	bability=false;
        	 JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	if(e.getSource()==sf) {
		choose.setText("Choose your next action");
		try {
		int x=s.getTeam().get(0).getLocation().x;
		int y=s.getTeam().get(0).getLocation().y;
		if(indexAbility==0)
			game.castAbility(game.getCurrentChampion().getAbilities().get(0), x, y);
		if(indexAbility==1)
			game.castAbility(game.getCurrentChampion().getAbilities().get(1), x, y);
		if(indexAbility==2)
			game.castAbility(game.getCurrentChampion().getAbilities().get(2), x, y);
		setButtons(grid);
    	setLists();
		if(game.checkGameOver()!=null) {
			JOptionPane.showMessageDialog(this,game.checkGameOver().getName(),"information",JOptionPane.INFORMATION_MESSAGE);
			  endturn.setEnabled(false);
				 ability1.setEnabled(false);
				  ability2.setEnabled(false);
				 ability3.setEnabled(false);
				 leaderability.setEnabled(false);
				 attack.setEnabled(false);
			
			     up.setEnabled(false);
				 down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
		}
		}
        catch(NotEnoughResourcesException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(AbilityUseException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(CloneNotSupportedException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (InvalidTargetException e1) {
        	bability=false;
        	 JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	if(e.getSource()==ss) {
		choose.setText("Choose your next action");
		try {
		int x=s.getTeam().get(1).getLocation().x;
		int y=s.getTeam().get(1).getLocation().y;
		if(indexAbility==0)
			game.castAbility(game.getCurrentChampion().getAbilities().get(0), x, y);
		if(indexAbility==1)
			game.castAbility(game.getCurrentChampion().getAbilities().get(1), x, y);
		if(indexAbility==2)
			game.castAbility(game.getCurrentChampion().getAbilities().get(2), x, y);
		setButtons(grid);
    	setLists();
		if(game.checkGameOver()!=null) {
			JOptionPane.showMessageDialog(this,game.checkGameOver().getName(),"information",JOptionPane.INFORMATION_MESSAGE);
			  endturn.setEnabled(false);
				 ability1.setEnabled(false);
				  ability2.setEnabled(false);
				 ability3.setEnabled(false);
				 leaderability.setEnabled(false);
				 attack.setEnabled(false);
			
			     up.setEnabled(false);
				 down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
		}
		}
        catch(NotEnoughResourcesException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(AbilityUseException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(CloneNotSupportedException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (InvalidTargetException e1) {
        	bability=false;
        	 JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	if(e.getSource()==st) {
		choose.setText("Choose your next action");
		try {
		int x=s.getTeam().get(2).getLocation().x;
		int y=s.getTeam().get(2).getLocation().y;
		if(indexAbility==0)
			game.castAbility(game.getCurrentChampion().getAbilities().get(0), x, y);
		if(indexAbility==1)
			game.castAbility(game.getCurrentChampion().getAbilities().get(1), x, y);
		if(indexAbility==2)
			game.castAbility(game.getCurrentChampion().getAbilities().get(2), x, y);
		setButtons(grid);
    	setLists(); 
		if(game.checkGameOver()!=null) {
			JOptionPane.showMessageDialog(this,game.checkGameOver().getName(),"information",JOptionPane.INFORMATION_MESSAGE);
			  endturn.setEnabled(false);
				 ability1.setEnabled(false);
				  ability2.setEnabled(false);
				 ability3.setEnabled(false);
				 leaderability.setEnabled(false);
				 attack.setEnabled(false);
			
			     up.setEnabled(false);
				 down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
		}
		}
        catch(NotEnoughResourcesException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(AbilityUseException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(CloneNotSupportedException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (InvalidTargetException e1) {
        	bability=false;
        	 JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	if(e.getSource()==a||e.getSource()==b||e.getSource()==c||e.getSource()==d||e.getSource()==e||e.getSource()==g||e.getSource()==h
			||e.getSource()==i||e.getSource()==j||e.getSource()==k||e.getSource()==l||e.getSource()==m||e.getSource()==n||e.getSource()==o
			||e.getSource()==p||e.getSource()==q||e.getSource()==r||e.getSource()==t||e.getSource()==u||e.getSource()==v||e.getSource()==w||e.getSource()==x||e.getSource()==y||e.getSource()==z) {
		try {
			int x=0;
			int y=0;
		for(int i=4;i>=0;i--) {
			for(int j=0;j<5;j++) {
				if(game.getBoard()[i][j]==b) {
					 x=i;
				     y=j;
				    break;	
				}
			}
		}
		
		if(indexAbility==0)
			game.castAbility(game.getCurrentChampion().getAbilities().get(0), x, y);
		if(indexAbility==1)
			game.castAbility(game.getCurrentChampion().getAbilities().get(1), x, y);
		if(indexAbility==2)
			game.castAbility(game.getCurrentChampion().getAbilities().get(2), x, y);
		setButtons(grid);
    	setLists(); 
		}
        catch(NotEnoughResourcesException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(AbilityUseException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(CloneNotSupportedException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (InvalidTargetException e1) {
        	bability=false;
        	 JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	if(e.getSource()==c1||e.getSource()==c2||e.getSource()==c3||e.getSource()==c4||e.getSource()==c5) {
      try {  
    	  int x;
    	  int y;
			if(e.getSource()==c1) {
                
				x=cover.get(0).getLocation().x;
				y=cover.get(0).getLocation().y;
	
			}
			else if(e.getSource()==c2){

				x=cover.get(1).getLocation().x;
				y=cover.get(1).getLocation().y;

			}
			else if(e.getSource()==c3){
	
				x=cover.get(2).getLocation().x;
				y=cover.get(2).getLocation().y;
			}
			else if(e.getSource()==c4){
				x=cover.get(3).getLocation().x;
				y=cover.get(3).getLocation().y;
			}
			else{
				x=cover.get(4).getLocation().x;
				y=cover.get(4 ).getLocation().y;
			}

		if(indexAbility==0)
			game.castAbility(game.getCurrentChampion().getAbilities().get(0), x, y);
		if(indexAbility==1)
			game.castAbility(game.getCurrentChampion().getAbilities().get(1), x, y);
		if(indexAbility==2)
			game.castAbility(game.getCurrentChampion().getAbilities().get(2), x, y);
		setButtons(grid);
    	setLists(); 
		}
        catch(NotEnoughResourcesException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(AbilityUseException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(CloneNotSupportedException z) {
        	bability=false;
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        } catch (InvalidTargetException e1) {
        	bability=false;
        	 JOptionPane.showMessageDialog(this,e1.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	if(e.getSource()==ability1) {
         try {
     	    if(game.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.DIRECTIONAL) {
     	   	choose.setText("Choose a direction");
     	    	bability=true;
     	    	indexAbility=0;
     	    }
     	    else if(game.getCurrentChampion().getAbilities().get(0).getCastArea()==AreaOfEffect.SINGLETARGET) {
     	    	choose.setText("Choose a Target");
     	    	indexAbility=0;
     	    	
     	    }
     	    else {
     	    	choose.setText("Choose your next action");
     	    	game.castAbility(game.getCurrentChampion().getAbilities().get(0));
     	    }
    		setButtons(grid);
        	setLists(); 
    		if(game.checkGameOver()==f){
				JOptionPane.showMessageDialog(this,f.getName(),"information",JOptionPane.INFORMATION_MESSAGE);
			    endturn.setEnabled(false);
				 ability1.setEnabled(false);
				  ability2.setEnabled(false);
				 ability3.setEnabled(false);
				 leaderability.setEnabled(false);
				 attack.setEnabled(false);
			     up.setEnabled(false);
				 down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
			}
			else if(game.checkGameOver()==s) {
				JOptionPane.showMessageDialog(this,s.getName(),"information",JOptionPane.INFORMATION_MESSAGE);
				  endturn.setEnabled(false);
					 ability1.setEnabled(false);
					  ability2.setEnabled(false);
					 ability3.setEnabled(false);
					 leaderability.setEnabled(false);
					 attack.setEnabled(false);
					
				     up.setEnabled(false);
					 down.setEnabled(false);
					left.setEnabled(false);
					right.setEnabled(false);
			}
         }
         //NotEnoughResourcesException, AbilityUseException, CloneNotSupportedException
         catch(NotEnoughResourcesException z) {
        	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
         }
         catch(AbilityUseException z) {
        	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
         }
         catch(CloneNotSupportedException z) {
        	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
         }
         
	}
	if(e.getSource()==ability2) {
    		
            try {
         	    if(game.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.DIRECTIONAL) {
         	   	choose.setText("Choose a direction");
         	    	bability=true;
         		indexAbility=1;}
         	    else if(game.getCurrentChampion().getAbilities().get(1).getCastArea()==AreaOfEffect.SINGLETARGET) {
         	    	choose.setText("Choose a Target");
         	    	indexAbility=1;
         	    }
         	    else {
         	    	choose.setText("Choose your next action");
         	    	game.castAbility(game.getCurrentChampion().getAbilities().get(1));
         	    }
        		setButtons(grid);
            	setLists();  	
		if(game.checkGameOver()==f){
			JOptionPane.showMessageDialog(this,f.getName(),"information",JOptionPane.INFORMATION_MESSAGE);
		    endturn.setEnabled(false);
			 ability1.setEnabled(false);
			  ability2.setEnabled(false);
			 ability3.setEnabled(false);
			 leaderability.setEnabled(false);
			 attack.setEnabled(false);
		     up.setEnabled(false);
			 down.setEnabled(false);
			left.setEnabled(false);
			right.setEnabled(false);
		}
		else if(game.checkGameOver()==s) {
			JOptionPane.showMessageDialog(this,s.getName(),"information",JOptionPane.INFORMATION_MESSAGE);
			  endturn.setEnabled(false);
				 ability1.setEnabled(false);
				  ability2.setEnabled(false);
				 ability3.setEnabled(false);
				 leaderability.setEnabled(false);
				 attack.setEnabled(false);
			     up.setEnabled(false);
				 down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
		}
        }
        catch(NotEnoughResourcesException z) {
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(AbilityUseException z) {
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        catch(CloneNotSupportedException z) {
       	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
	}
	if(e.getSource()==ability3) {
		
        try {
     	    if(game.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.DIRECTIONAL) {
     	    	choose.setText("Choose a direction");
     	    	bability=true;
     	   indexAbility=2;
     	   }
     	    else if(game.getCurrentChampion().getAbilities().get(2).getCastArea()==AreaOfEffect.SINGLETARGET) {
     	    	choose.setText("Choose a Target");
     	    	 indexAbility=2;
     	    }
     	    else {
     	    	choose.setText("Choose your next action");
     	    	game.castAbility(game.getCurrentChampion().getAbilities().get(2));
     	    }
    		setButtons(grid);
        	setLists(); 
     	    	
	if(game.checkGameOver()==f){
		JOptionPane.showMessageDialog(this,f.getName(),"information",JOptionPane.INFORMATION_MESSAGE);
	    endturn.setEnabled(false);
		 ability1.setEnabled(false);
		  ability2.setEnabled(false);
		 ability3.setEnabled(false);
		 leaderability.setEnabled(false);
		 attack.setEnabled(false);
	     up.setEnabled(false);
		 down.setEnabled(false);
		left.setEnabled(false);
		right.setEnabled(false);
	}
	else if(game.checkGameOver()==s) {
		JOptionPane.showMessageDialog(this,s.getName(),"information",JOptionPane.INFORMATION_MESSAGE);
		  endturn.setEnabled(false);
			 ability1.setEnabled(false);
			  ability2.setEnabled(false);
			 ability3.setEnabled(false);
			 leaderability.setEnabled(false);
			 attack.setEnabled(false);
		     up.setEnabled(false);
			 down.setEnabled(false);
			left.setEnabled(false);
			right.setEnabled(false);
	}
    }
    catch(NotEnoughResourcesException z) {
   	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
    catch(AbilityUseException z) {
   	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
    catch(CloneNotSupportedException z) {
   	 JOptionPane.showMessageDialog(this,z.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
    }
}
	if(e.getSource()==attack) {
		
		choose.setText("Choose a direction");
		battack =true;
	}
    if(e.getSource()==up) {
    	try {
        	if(battack) {
        		game.attack(Direction.UP);
        		game.getCurrentChampion().setCurrentActionPoints(game.getCurrentChampion().getCurrentActionPoints() - 2);
        		choose.setText("Choose your next action");
        	}
        	else if(bability) {
        		if(indexAbility==0) {
        			choose.setText("Choose your next action");
        		game.castAbility(game.getCurrentChampion().getAbilities().get(0),Direction.UP);}
        		else if(indexAbility==1) {
        			choose.setText("Choose your next action");
        			game.castAbility(game.getCurrentChampion().getAbilities().get(1),Direction.UP);}
        		else {
        			choose.setText("Choose your next action");
        			game.castAbility(game.getCurrentChampion().getAbilities().get(2),Direction.UP);}
        	}
        	else
        		game.move(Direction.UP);
        	battack =false;
        	bability=false;
        	setButtons(grid);
        	setLists();
    		if(game.checkGameOver()!=null) {
    			JOptionPane.showMessageDialog(this,game.checkGameOver().getName(),"information",JOptionPane.INFORMATION_MESSAGE);
    			  endturn.setEnabled(false);
    				 ability1.setEnabled(false);
    				  ability2.setEnabled(false);
    				 ability3.setEnabled(false);
    				 leaderability.setEnabled(false);
    				 attack.setEnabled(false);
    			
    			     up.setEnabled(false);
    				 down.setEnabled(false);
    				left.setEnabled(false);
    				right.setEnabled(false);
    		}
        	}
    	catch(NotEnoughResourcesException z) {
        	battack =false;
        	bability=false;
    		JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(ChampionDisarmedException z) {
    	battack =false;
    	bability=false;
		    JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(InvalidTargetException z) {
    	battack =false;
    	bability=false;
	    	JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(UnallowedMovementException z) {
    	battack =false;
    	bability=false;
		JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	} catch (AbilityUseException e1) {
        	battack =false;
        	bability=false;
    		JOptionPane.showMessageDialog(this,e1.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
	} catch (CloneNotSupportedException e1) {
    	battack =false;
    	bability=false;
		JOptionPane.showMessageDialog(this,e1.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
	}
    	
    	
    }
    if(e.getSource()==down) {
    	try {
        	if(battack) {
        		
        		choose.setText("Choose your next action");
        		game.attack(Direction.DOWN);
        		game.getCurrentChampion().setCurrentActionPoints(game.getCurrentChampion().getCurrentActionPoints() - 2);
        	}
        	else if(bability) {
        		choose.setText("Choose your next action");
        		if(indexAbility==0)
        		game.castAbility(game.getCurrentChampion().getAbilities().get(0),Direction.DOWN);
        		else if(indexAbility==1)
        			game.castAbility(game.getCurrentChampion().getAbilities().get(1),Direction.DOWN);
        		else
        			game.castAbility(game.getCurrentChampion().getAbilities().get(2),Direction.DOWN);
        		choose.setText("Choose your next action");
        		
        	}
        	
        	else
        		game.move(Direction.DOWN);
        	battack =false;
        	bability=false;
        	setButtons(grid);
        	setLists();
    		if(game.checkGameOver()!=null) {
    			JOptionPane.showMessageDialog(this,game.checkGameOver().getName(),"information",JOptionPane.INFORMATION_MESSAGE);
    			  endturn.setEnabled(false);
    				 ability1.setEnabled(false);
    				  ability2.setEnabled(false);
    				 ability3.setEnabled(false);
    				 leaderability.setEnabled(false);
    				 attack.setEnabled(false);
    			
    			     up.setEnabled(false);
    				 down.setEnabled(false);
    				left.setEnabled(false);
    				right.setEnabled(false);
    		}
        	}
    	catch(NotEnoughResourcesException z) {
        	battack =false;
        	bability=false;
    		JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(ChampionDisarmedException z) {
    	battack =false;
    	bability=false;
		    JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(InvalidTargetException z) {
    	battack =false;
    	bability=false;
	    	JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(UnallowedMovementException z) {
    	battack =false;
    	bability=false;
		JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	} catch (AbilityUseException e1) {
        	battack =false;
        	bability=false;
    		JOptionPane.showMessageDialog(this,e1.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
	} catch (CloneNotSupportedException e1) {
    	battack =false;
    	bability=false;
		JOptionPane.showMessageDialog(this,e1.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
	}
    	
    }
    if(e.getSource()==right) {
    	try {
        	if(battack) {
        		
        		choose.setText("Choose your next action");
        		game.attack(Direction.RIGHT);
        		game.getCurrentChampion().setCurrentActionPoints(game.getCurrentChampion().getCurrentActionPoints() - 2);
        	}
    	else if(bability) {
    		choose.setText("Choose your next action");
    		if(indexAbility==0)
    		game.castAbility(game.getCurrentChampion().getAbilities().get(0),Direction.RIGHT);
    		else if(indexAbility==1)
    			game.castAbility(game.getCurrentChampion().getAbilities().get(1),Direction.RIGHT);
    		else
    			game.castAbility(game.getCurrentChampion().getAbilities().get(2),Direction.RIGHT);
    		choose.setText("Choose your next action");
    	}
    	
    	else
    		game.move(Direction.RIGHT);
    	battack =false;
    	bability=false;
    	setButtons(grid);
    	setLists();
		if(game.checkGameOver()!=null) {
			JOptionPane.showMessageDialog(this,game.checkGameOver().getName(),"information",JOptionPane.INFORMATION_MESSAGE);
			  endturn.setEnabled(false);
				 ability1.setEnabled(false);
				  ability2.setEnabled(false);
				 ability3.setEnabled(false);
				 leaderability.setEnabled(false);
				 attack.setEnabled(false);
			
			     up.setEnabled(false);
				 down.setEnabled(false);
				left.setEnabled(false);
				right.setEnabled(false);
		}
    	}
    	catch(NotEnoughResourcesException z) {
        	battack =false;
        	bability=false;
    		JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(ChampionDisarmedException z) {
    	battack =false;
    	bability=false;
		    JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(InvalidTargetException z) {
    	battack =false;
    	bability=false;
	    	JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(UnallowedMovementException z) {
    	battack =false;
    	bability=false;
		JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	} catch (AbilityUseException e1) {
        	battack =false;
        	bability=false;
    		JOptionPane.showMessageDialog(this,e1.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
	} catch (CloneNotSupportedException e1) {
    	battack =false;
    	bability=false;
		JOptionPane.showMessageDialog(this,e1.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
	}
    	
    }
    if(e.getSource()==left) {
    	try {
        	if(battack) {
        		
        		choose.setText("Choose your next action");
        		game.attack(Direction.LEFT);
        		game.getCurrentChampion().setCurrentActionPoints(game.getCurrentChampion().getCurrentActionPoints() - 2);
        	}
        	else if(bability) {
        		choose.setText("Choose your next action");
        		if(indexAbility==0)
        		game.castAbility(game.getCurrentChampion().getAbilities().get(0),Direction.LEFT);
        		else if(indexAbility==1)
        			game.castAbility(game.getCurrentChampion().getAbilities().get(1),Direction.LEFT);
        		else
        			game.castAbility(game.getCurrentChampion().getAbilities().get(2),Direction.LEFT);
        		choose.setText("Choose your next action");
        	}
        	
        	else
        		game.move(Direction.LEFT);
        	battack =false;
        	bability=false;
        	setButtons(grid);
        	setLists();
    		if(game.checkGameOver()!=null) {
    			JOptionPane.showMessageDialog(this,game.checkGameOver().getName(),"information",JOptionPane.INFORMATION_MESSAGE);
    			  endturn.setEnabled(false);
    				 ability1.setEnabled(false);
    				  ability2.setEnabled(false);
    				 ability3.setEnabled(false);
    				 leaderability.setEnabled(false);
    				 attack.setEnabled(false);
    			
    			     up.setEnabled(false);
    				 down.setEnabled(false);
    				left.setEnabled(false);
    				right.setEnabled(false);
    		}
        	}
    	catch(NotEnoughResourcesException z) {
        	battack =false;
        	bability=false;
    		JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(ChampionDisarmedException z) {
    	battack =false;
    	bability=false;
		    JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(InvalidTargetException z) {
    	battack =false;
    	bability=false;
	    	JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	}
	catch(UnallowedMovementException z) {
    	battack =false;
    	bability=false;
		JOptionPane.showMessageDialog(this,z.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
    	} catch (AbilityUseException e1) {
        	battack =false;
        	bability=false;
    		JOptionPane.showMessageDialog(this,e1.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
	} catch (CloneNotSupportedException e1) {
    	battack =false;
    	bability=false;
		JOptionPane.showMessageDialog(this,e1.getMessage(),"information",JOptionPane.INFORMATION_MESSAGE);
	}
    }
}
public ArrayList <Object> effectdisplay(Champion C) {
	ArrayList <Object> s= new ArrayList <Object>();
	for(Effect e: C.getAppliedEffects() ) {
		s.add("Effect:");
		s.add(e.getName());
	    s.add("Duration:");
	    s.add(e.getDuration());
	}
	return s;
}
public void Queueprep(PriorityQueue p) {
	obj= new QueueObj (6);
	
	int l=p.size();
	for(int i=0; i<l; i++) {
		obj.enqueue(p.remove());
	}
	for(int k=0; k<obj.size(); k++) {
		Object objc= obj.dequeue();
		p.insert((Comparable)objc);
		obj.enqueue(objc);
		
	}
	
}
public String turns(QueueObj o ) {
	String s="";
	for(int j=0; j<o.size(); j++) {
		Champion champ= (Champion) o.dequeue();
		if (champ.getCondition() != Condition.KNOCKEDOUT) {
		int z= j;
		z++;
		s=s+z + "-"+champ.getName() + " ";
		o.enqueue(champ);}
	}
	return s;
}

public String leadA(Player P) {
	if(P==f && game.isFirstLeaderAbilityUsed()) {
		return "Leader Ability used";}
		else if (P==s && game.isSecondLeaderAbilityUsed()) {
			return "Leader Ability used";}
	return "";
	}
}

