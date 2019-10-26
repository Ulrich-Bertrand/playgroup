package Inscriptions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InscriptionClient  implements ActionListener {
	private static Frame fen;
	JLabel  passwd, cfpasswd, login, cni, nom, prenom, datN, lieu, adress, profes, tel, email ;
	JTextField  loginText, label,label1, label2, label3, label4, label5, label6, label7, label8 ;
	JPasswordField  pass1, pass2 ;
	JPanel pan, pan1,pan2 ;
	JButton annuler, suivant, valider, precedent ;
	Container con ;
	Boolean vzl, a=false, b=false,c=false,d=false, ee=false,f=false,g=false,h=false,i=false ;
	JDialog di ;
	JPanel launchClient ;
	
	private Pattern pattern; 
	private Matcher matcher ;
	
/**
 * permet de ferifier le bon formalisme de des champs nom, prenom ....
 * @param obj
 */
	public Boolean verifiedString(JTextField obj) {
		pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]\\w") ;
		matcher = pattern.matcher(obj.getText());
		if(obj.getText()==null) { suivant.setEnabled(false); return false ; }
		if(!matcher.find()) {
			obj.setForeground(Color.RED);
			return false ;
			
		}else {
			obj.setForeground(Color.black);
			return true ;
		}
	}
	
	/**
	 * verifier les champs de texte de type nombre
	 * @param obj
	 */
	public Boolean verifiedNumber(JTextField obj) {
		pattern = Pattern.compile("^[6]{1,1}[0-9]{8,8}") ;
		matcher = pattern.matcher(obj.getText());
		if(obj.getText()==null) { suivant.setEnabled(false); return false ; }
		if(!matcher.find()) {
			obj.setForeground(Color.RED);
			return false ;	
		}else {
			obj.setForeground(Color.black);
			return true ;
		}
	}
	
	public Boolean verifiedNumberCni(JTextField obj) {
		pattern = Pattern.compile("[0-9]{9,9}") ;
		matcher = pattern.matcher(obj.getText());
		if(obj.getText()==null) { suivant.setEnabled(false); return false ; }
		if(!matcher.find()) {
			obj.setForeground(Color.RED);
			return false ;	
		}else {
			obj.setForeground(Color.black);
			return true ;
		}
	}
	
	/**
	 * verifier les champs de textes de types email
	 * @param obj
	 */
	public Boolean verifiedEmail(JTextField obj) {
		pattern = Pattern.compile("^[a-zA-Z][a-z]*[@][a-z]{5}.[a-z]{3,3}") ;
		matcher = pattern.matcher(obj.getText());
		if(obj.getText()==null) { suivant.setEnabled(false); return false ; }
		if(!matcher.find()) {
			obj.setForeground(Color.RED);
			return false ;
		}else {
			obj.setForeground(Color.black);
			return true ;
		}
	}
	
	public InscriptionClient() {
		// TODO Auto-generated constructor stub
		di = new Inscript() ;
		suivant.addActionListener(this);
		precedent.addActionListener(this);
		valider.addActionListener(this) ;
		vzl = false ;
		pass1.setEditable(false);
		pass2.setEditable(false);
		launchClient = new LaunchUser() ;
	}

	public class Inscript extends JDialog implements MouseListener {
		private static final long serialVersionUID = 1L;

		public Inscript() {
			super(fen, "CREATION DE COMPTE", true) ;
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension dimEcran = tk.getScreenSize();
			this.setSize(dimEcran.width-250, dimEcran.height-200) ;
			this.setResizable(false);
			this.setLocationRelativeTo(null) ;
			this.addMouseListener(this);
			con = getContentPane() ;
			con.setLayout(new BorderLayout());
			
			cni = new JLabel("N°CNI ou passPort") ;		datN = new JLabel("Date Naissance") ;
			nom = new JLabel("Nom") ;					lieu = new JLabel("Lieu Naissance") ;
			prenom = new JLabel("Prenom") ;				adress = new JLabel("Adresse") ;
			profes = new JLabel("Profession") ;			email = new JLabel("Email") ;
			tel = new JLabel(" N° Telephone") ;			suivant = new JButton("Suivant") ;
			
			 label = new JTextField(20) ;		label1 = new JTextField(20) ;
			 label2 = new JTextField(20) ;
			 label3 = new JTextField(20) ;				 label4 = new JTextField(20) ;
			 label5 = new JTextField(20) ;				 label6 = new JTextField(20) ;
			 label7 = new JTextField(20) ;				 label8 = new JTextField(20) ;
			 
			 	annuler = new JButton("Annuler") ;			
				login = new JLabel("LOGIN") ; 		loginText = new JTextField("Non modifiable à ce niveau") ;
				precedent = new JButton("Precedent") ;
				valider = new JButton("Valider") ;
				passwd = new JLabel("Password") ;
				cfpasswd = new JLabel("Confirm Password ") ;
				pass1 = new JPasswordField() ;
				pass2 = new JPasswordField() ;
				
				pan = new JPanel() ;
				pan1 = new JPanel() ;
				pan2 = new JPanel() ;
				
				login.setPreferredSize(new Dimension(dimEcran.width-800,40));
				 passwd.setPreferredSize(new Dimension(dimEcran.width-800,40));
				 pass1.setPreferredSize(new Dimension(dimEcran.width-800,40));
				 pass2.setPreferredSize(new Dimension(dimEcran.width-800,40));
				 cfpasswd.setPreferredSize(new Dimension((dimEcran.width-800),40));
				 loginText.setPreferredSize(new Dimension((dimEcran.width-800),40));
				
				 login.setHorizontalAlignment(JLabel.CENTER);
				 loginText.setEnabled(false);
				 loginText.setBorder(null);
				 
				 loginText.setBackground(Color.green.darker());
				 loginText.setHorizontalAlignment(JTextField.CENTER);
				 pass1.setHorizontalAlignment(JTextField.CENTER);
				 pass2.setHorizontalAlignment(JTextField.CENTER);
				 passwd.setHorizontalAlignment(JLabel.CENTER);
				 cfpasswd.setHorizontalAlignment(JLabel.CENTER);
				 precedent.setBackground(Color.white) ;
				 annuler.setBackground(Color.red) ;
				 valider.setBackground(Color.green) ;
				 
				 suivant.setBackground(Color.green.darker()); suivant.setForeground(Color.white.brighter());
				 
				 
				pan.add(new JLabel("VOS INFORMATIONS PERSONNELLES")) ;
			pan1.setLayout(new GridLayout(10,3));
			pan1.add(cni) ;		pan1.add(label) ;
			pan1.add(nom) ;		pan1.add(label1) ;
			pan1.add(prenom) ;	pan1.add(label2) ;
			pan1.add(datN) ;	pan1.add(label3) ;
			pan1.add(lieu) ;	pan1.add(label4) ;
			pan1.add(adress) ;	pan1.add(label5) ;
			pan1.add(profes) ;	pan1.add(label6) ;
			pan1.add(email) ;	pan1.add(label7) ;
			pan1.add(tel) ; 	pan1.add(label8) ;
			pan1.add(suivant) ; 
				
				
				pan2.add(login) ;
				pan2.add(loginText) ;
				pan2.add(passwd) ; 		
				pan2.add(pass1) ; 	
				pan2.add(cfpasswd) ; 	
				pan2.add(pass2) ; JPanel p = new JPanel() ;
				
				p.add(precedent) ;
				p.add(annuler) ;
				p.add(valider) ;	
				pan2.add(p, BorderLayout.SOUTH) ;
				
				
				pan.setBackground(Color.WHITE);
				pan1.setBackground(Color.white);
				pan2.setBackground(Color.white);
				con.add(pan, BorderLayout.NORTH) ;
				con.add(pan1,BorderLayout.WEST) ;
				con.add(pan2) ;
				
				precedent.setEnabled(false);
				valider.setEnabled(false);
				
				label.addMouseListener(this);
				label1.addMouseListener(this);
				label2.addMouseListener(this);
				label3.addMouseListener(this);
				label4.addMouseListener(this);
				label5.addMouseListener(this);
				label6.addMouseListener(this);
				label7.addMouseListener(this);
				label8.addMouseListener(this);
				
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			a= verifiedNumberCni(label);
			b= verifiedString(label1);
			c= verifiedString(label2);
			d= verifiedString(label3);
			ee= verifiedString(label4);
			f= verifiedString(label5);
			g= verifiedString(label6);
			h= verifiedEmail(label7);
			i= verifiedNumber(label8);
			if(!(a&&b &&c &&d &&ee &&f &&g &&h &&i)) {
				suivant.setEnabled(false);
			}else suivant.setEnabled(true);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			a= verifiedNumberCni(label);
			b= verifiedString(label1);
			c= verifiedString(label2);
			d= verifiedString(label3);
			ee= verifiedString(label4);
			f= verifiedString(label5);
			g= verifiedString(label6);
			h= verifiedEmail(label7);
			i= verifiedNumber(label8);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			a= verifiedNumberCni(label);
			b= verifiedString(label1);
			c= verifiedString(label2);
			d= verifiedString(label3);
			ee= verifiedString(label4);
			f= verifiedString(label5);
			g= verifiedString(label6);
			h= verifiedEmail(label7);
			i= verifiedNumber(label8);
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			a= verifiedNumberCni(label);
			b= verifiedString(label1);
			c= verifiedString(label2);
			d= verifiedString(label3);
			ee= verifiedString(label4);
			f= verifiedString(label5);
			g= verifiedString(label6);
			h= verifiedEmail(label7);
			i= verifiedNumber(label8);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			a= verifiedNumberCni(label);
			b= verifiedString(label1);
			c= verifiedString(label2);
			d= verifiedString(label3);
			ee= verifiedString(label4);
			f= verifiedString(label5);
			g= verifiedString(label6);
			h= verifiedEmail(label7);
			i= verifiedNumber(label8);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==suivant) {
			pan2.setVisible(true);
			suivant.setEnabled(false);
			precedent.setEnabled(true);
			valider.setEnabled(true);
			label.setEditable(false);		
			label1.setEditable(false);
			label2.setEditable(false);
			label3.setEditable(false);
			label4.setEditable(false);
			label5.setEditable(false);
			label6.setEditable(false);
			label7.setEditable(false);
			label8.setEditable(false);
			
			pass1.setEditable(true);
			pass2.setEditable(true);
		}
		if(e.getSource()==precedent) {
			suivant.setEnabled(true);
			precedent.setEnabled(false);
			valider.setEnabled(false);
			
			label.setEditable(true); 	
			label1.setEditable(true);
			label2.setEditable(true);
			label3.setEditable(true);
			label4.setEditable(true);
			label5.setEditable(true);
			label6.setEditable(true);
			label7.setEditable(true);
			label8.setEditable(true);
			
			pass1.setEditable(false);
			pass2.setEditable(false);
		}
		if(e.getSource()==valider) {
			vzl = true ;
			di.setVisible(false);
		}
	}
	

	public Boolean Val() {
		return vzl ;
	}
	
	public JDialog getBoite() {
		return this.di ;
 	}
	
	public JPanel interfaceUtilisatur() {
		return this.launchClient ;
	}
	
}	
	

