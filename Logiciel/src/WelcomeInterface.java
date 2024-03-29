import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

//importe mes classes
import Connections.Admin;
import Connections.Aide;
import Connections.Apropos;
import Connections.Client;
import Connections.Cordonateur;
import Connections.Documentation;

public class WelcomeInterface extends JFrame implements ActionListener{

	/**
	 * @author Lionnel MOFFO
	 */
	private static final long serialVersionUID = 1L;
	private JButton adminB,clientB,docB,aproposB, aideB, cordoB ;
	public JPanel connex ;
	public CardLayout cl ;
	public Admin admin ;
	public Client client ;
	public Documentation documentation ;
	public Apropos apropos ;
	public Aide aide ;
	public Cordonateur cordo ;

	/**
	 * cette classe est celle qui permet d'afficher la premiere activit� de notre projet. C'est elle qui contient le main
	 * Elle contient deux panneaux: 
	 * 1-celui du Construsteur de la classe Menus venant du meme repertoire
	 * 2- un definit en tant que variable (connex)  qui va servire de conteneur pour les options du menu apres leurs effectivit�
	 * 
	 */
	public WelcomeInterface() {
		
		/*la class Defaults ne contient que les parametres de l'ecran et deux ou trois fonctions
		*qui definissent juste la taille des composants à la fenetre principale
		*/
		Defaults dim = new Defaults() ;
		Dimension dimEcran = dim.getDim() ;
		this.setSize(dimEcran.width-8, dimEcran.height - 40); // par defaut prend toute la largeur de la fenetre

		// panel c'est le panneau principal de la fenetre: c'est lui qui contient les deux panneaux menu et connex
		Container panel = this.getContentPane() ;
		Menus menu = new Menus() ;
		connex = new JPanel() ;
		cl = new CardLayout(5,0) ;
		connex.setLayout(cl);

		//definitions des panneaux qui correspondent aux differents interfaces.
		
		/**
		 * Admin : class cr�� une boite de dialogue pour demande de connexion en tant qu'administrateur
		 * de ce block il est interdit de penser proceder � l'inscription d'un nouveau administrateur dans la banque.
		 */
		admin = new Admin() ; 
		
		/**
		 * de meme que pour un administrateur � la differnce de prevoir une option inscrivez-vous pour un 
		 * enregistrement effectif dans la banque.
		 * 
		 */
		client = new Client() ; client.setLayout(new BorderLayout());
		
		//donne les details sur la documentation du logiciel
		documentation = new Documentation() ;
		
		//renseigne sur les informations de l'auteur et le motif de creation
		apropos = new Apropos() ;
		
		//une rubrique d'aide (un peu flou pour l'instant
		aide = new Aide() ;
		cordo = new Cordonateur() ;

		// ici on definit juste les boutons des menus se retrouvant au cote gauche de l'�cran
		 adminB = menu.adminBut() ;
		 clientB = menu.clientBut() ;
		 docB = menu.documentationBut() ;
		 aproposB = menu.aproposBut() ;
		 aideB = menu.aideBut() ;
		 cordoB = menu.cordoBut() ;
		 
		 //on definit les ecouteurs d'evenements sur chaque boutons
		adminB.addActionListener(this) ;
		clientB.addActionListener(this) ;
		docB.addActionListener(this) ;
		aproposB.addActionListener(this) ;
		aideB.addActionListener(this) ;
		cordoB.addActionListener(this) ;
		
		connex.add(admin,"p1") ;
		connex.add(client,"p2") ;
		connex.add(documentation, "p3") ;
		connex.add(apropos, "p4") ;
		connex.add(aide, "p5") ;
		connex.add(cordo, "p6") ;

		panel.add(menu, BorderLayout.WEST) ; //OPtions
		panel.add(connex) ;
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setTitle("Account Management"); // donne le titre � la fenetre
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args){
		// TODO Auto-generated method stub
	WelcomeInterface fenetre = new WelcomeInterface() ;
		fenetre.setVisible(true);


	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource()==adminB) {
			JDialog d = admin.getBoite() ;
			d.setVisible(true);
			cl.show(connex,"p1") ;
		}
		if(event.getSource()==clientB) {
			JDialog d = client.getBoite() ;
			d.setVisible(true) ;
			client.userView(client);
			if(client.ValD()) {
				cl.show(connex,"p2") ;
				client.setEnabled(false) ;
			}
			else {

			}
			clientB.setForeground(Color.black);
			clientB.setBackground(Color.white);

			}
		if(event.getSource()==docB) {
			cl.show(connex, "p3") ;
			}
		if(event.getSource()==aproposB) {
			cl.show(connex, "p4") ;
			}
		if(event.getSource()==aideB) {
			cl.show(connex, "p5") ;
			}
		if(event.getSource()==cordoB) {
			cl.show(connex, "p6") ;
			}
	}
}
