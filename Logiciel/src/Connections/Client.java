package Connections;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Inscriptions.InscriptionClient;

public class Client extends JPanel implements ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
JFrame fen = new JFrame() ;
String titre = new String("CONNEXION EN CLIENT") ;
JLabel login, passwd , phrase;
JTextField champTexte ;
JPasswordField champTexte1 ;
JButton okBouton, cancel,inscription ;
JDialog dial, dial2 ;
Container contenu ;
Container p ;
InscriptionClient c ;
JPanel panne ;

	public Client() {
		// TODO Auto-generated constructor stub
		this.setBackground(Color.red);
		dial= new ConnexionClient() ;
		c = new InscriptionClient() ;
		dial2 = new JDialog() ;
		dial2 = c.getBoite() ;
		okBouton.addActionListener(this) ;
		cancel.addActionListener(this) ;
		inscription.addActionListener(this) ;
		}
	
	public void userView(JPanel pan) {
		panne = new JPanel() ;
		panne= c.interfaceUtilisatur();
		pan.add(panne) ;
	}
	
	public Boolean ValD() {
		return c.Val() ;
	}
	
	public JDialog getBoite() {
		return this.dial ;
	}

public class ConnexionClient extends JDialog {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public  ConnexionClient(){
			super(fen,titre,true);
			 Toolkit tk = Toolkit.getDefaultToolkit();
			 Dimension dimEcran = tk.getScreenSize();
			this.setSize(dimEcran.width-725, dimEcran.height-450) ;
			this.setResizable(false);
			this.setLocationRelativeTo(null) ;
			 
			phrase = new JLabel("Vous n'avez pas de compte ?") ;
			inscription = new JButton("Inscrivez-vous") ;
			inscription.setBackground(new Color(22,29,86).darker().darker()) ;
			inscription.setForeground(Color.white.brighter());
			 champTexte = new JTextField();
			 champTexte1 = new JPasswordField();
			  contenu = getContentPane() ;
			 FlowLayout gl = new FlowLayout(9) ;
			 contenu.setLayout (gl) ;
			 
			 login = new JLabel(" LOGIN "); 
			 passwd = new JLabel(" PASSWORD ");
			 okBouton = new JButton("OK") ;
			 cancel = new JButton("Cancel") ;
			 
			 login.setForeground(Color.red);
			 passwd.setForeground(Color.RED);
			 okBouton.setForeground(Color.white);
			 cancel.setForeground(Color.black);	 
			
			 login.setPreferredSize(new Dimension(dimEcran.width-800,40));
			 phrase.setPreferredSize(new Dimension(dimEcran.width-800,40));
			 passwd.setPreferredSize(new Dimension(dimEcran.width-800,40));
			 champTexte.setPreferredSize(new Dimension(dimEcran.width-800,40));
			 champTexte1.setPreferredSize(new Dimension(dimEcran.width-800,40));
			 okBouton.setPreferredSize(new Dimension((dimEcran.width-1000)/2,40));
			 cancel.setPreferredSize(new Dimension((dimEcran.width-1000)/2,40));
			 
			 champTexte.setHorizontalAlignment(JTextField.CENTER);
			 champTexte1.setHorizontalAlignment(JTextField.CENTER);
			 login.setHorizontalAlignment(JLabel.CENTER);
			 phrase.setHorizontalAlignment(JLabel.CENTER);
			 inscription.setHorizontalAlignment(JLabel.CENTER);
			 passwd.setHorizontalAlignment(JLabel.CENTER);
			 okBouton.setHorizontalAlignment(JButton.CENTER);
			 cancel.setHorizontalAlignment(JButton.CENTER);

			 
			 okBouton.setBackground(new Color(22,29,86).darker());
			 cancel.setBackground(Color.red);
			 contenu.add(login);  
			 contenu.add(champTexte) ;
			 contenu.add(passwd); 
			 contenu.add(champTexte1);
			 contenu.add(okBouton);
			 contenu.add(cancel);
			 contenu.add(phrase) ;
			 contenu.add(inscription) ;
		}
	}


@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==okBouton) {
		this.setBackground(Color.blue) ;
		dial.setVisible(false);
	}
	else if(e.getSource()==cancel) {
		dial.setVisible(false);
	}
	else if(e.getSource()==inscription) {
		dial.setVisible(false);
		dial2.setVisible(true);
		
	}
	
}



}
