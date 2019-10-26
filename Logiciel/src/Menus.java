import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menus extends JPanel{
	/**
	 * @author Lionnel MOFFO 
	 */
	private static final long serialVersionUID = 1L;
	private JButton admin ;
	private JButton client ;
	private JButton documentation ;
	private JButton apropos ; 
	private JButton aide ;
	private JButton cordo ;
	
	public Menus() {
		// TODO Auto-generated constructor stub
		this.setBackground(Color.white);
		Defaults dim = new Defaults() ;
		
		admin = new JButton("Admin") ;   admin.setSize(dim.butWidth(), dim.butheight());
		client = new JButton("Client") ;   client.setSize(dim.butWidth(), dim.butheight());
		documentation = new JButton("Documentation") ;   documentation.setSize(dim.butWidth(), dim.butheight());
		apropos = new JButton("A propos") ;   apropos.setSize(dim.butWidth(), dim.butheight());
		aide = new JButton("Aide") ;   aide.setSize(dim.butWidth(), dim.butheight());
		cordo = new JButton("Coordonnateur & Prof") ;   cordo.setSize(dim.butWidth(), dim.butheight());
		
		JPanel p = new JPanel() ;
				p.setBackground(new Color(22,29,86).darker());
		this.setLayout(new FlowLayout()) ;
		
		this.setPreferredSize(new Dimension(dim.getDim().width/6-30,dim.getDim().height/4));
		admin.setPreferredSize(new Dimension(dim.butWidth(), dim.butheight()));
		client.setPreferredSize(new Dimension(dim.butWidth(), dim.butheight()));
		documentation.setPreferredSize(new Dimension(dim.butWidth(), dim.butheight()));
		apropos.setPreferredSize(new Dimension(dim.butWidth(), dim.butheight()));
		aide.setPreferredSize(new Dimension(dim.butWidth(), dim.butheight()));
		p.setPreferredSize(new Dimension(dim.butWidth(), (dim.getDim().height/3)+100));
		cordo.setPreferredSize(new Dimension(dim.butWidth(), dim.butheight()));
		
		admin.setBackground(new Color(22,29,86).darker());
		client.setBackground(new Color(22,29,86).darker());
		documentation.setBackground(new Color(22,29,86).darker());
		apropos.setBackground(new Color(22,29,86).darker());
		aide.setBackground(new Color(22,29,86).darker());
		cordo.setBackground(new Color(22,29,86).darker());
		
		admin.setForeground(Color.white);
		client.setForeground(Color.white);
		documentation.setForeground(Color.white);
		apropos.setForeground(Color.white);
		aide.setForeground(Color.white);
		cordo.setForeground(Color.white);
		
		this.add(admin) ;
		this.add(client) ;
		this.add(documentation) ;
		this.add(apropos) ;
		this.add(aide) ;
		this.add(p) ;
		this.add(cordo) ;
		
	}
	

	
	public JButton adminBut() { //ceci est un getteur il servira pour travailler sur les ecouteurs d'evenement
		return admin;	
	}
	public JButton clientBut() { //ceci est un getteur il servira pour travailler sur les ecouteurs d'evenement
		return client;	
	}
	public JButton documentationBut() { //ceci est un getteur il servira pour travailler sur les ecouteurs d'evenement
		return documentation;	
	}
	public JButton aproposBut() { //ceci est un getteur il servira pour travailler sur les ecouteurs d'evenement
		return apropos;	
	}
	public JButton aideBut() { //ceci est un getteur il servira pour travailler sur les ecouteurs d'evenement
		return aide;	
	}
	public JButton cordoBut() { //ceci est un getteur il servira pour travailler sur les ecouteurs d'evenement
		return cordo;	
	}
}
