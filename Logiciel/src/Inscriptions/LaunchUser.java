package Inscriptions;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 
 * @author Lionnel MOFFO
 * Interface affiché quand l'user est connecte sur son compte..................
 */
public class LaunchUser extends JPanel {
	JButton exitUser ;
	JLabel pseudoUser, credit , solde, benefice, montant; 
	JPanel head, milieu, bottom ;
	String title[] = {"Id_transaction", "N° Compte", "Motif", "Montant","Dépot", "Retrait", "Date", };
	Object[][] data = {} ;
	JTable tableau = new JTable(data, title);
	
	public LaunchUser() {
		// TODO Auto-generated constructor stub
		pseudoUser  = new JLabel("Un exemple : @Ulrich") ; 
		exitUser = new JButton("Deconnexion") ;
		credit = new JLabel("Crédits (FCFA) : 0") ;
		solde = new JLabel("Solde (FCFA) : 0") ;
		montant = new JLabel("Montant (FCFA)  0") ;
		benefice = new JLabel("Interet (FCFA) : 0") ;
		
		head = new JPanel() ; head.setBackground(Color.cyan);
		milieu = new JPanel() ; milieu.setBackground(Color.white);
		bottom = new JPanel() ; //bottom.setBackground(Color.green);
		
		exitUser.setPreferredSize(new Dimension(150,40));
		exitUser.setBackground(Color.white);
		solde.setForeground(Color.black.brighter());
		credit.setForeground(Color.red);
		head.setLayout(new FlowLayout(FlowLayout.RIGHT));
		bottom.setLayout(new FlowLayout(FlowLayout.RIGHT));
		milieu.setLayout(new BorderLayout());
		
		head.add(pseudoUser);
		head.add(exitUser) ;
		milieu.add(new JScrollPane(tableau)) ;
		bottom.add(credit); 
		bottom.add(solde) ;
		
		setLayout(new BorderLayout()) ;
		this.add(head, BorderLayout.NORTH) ;
		this.add(milieu, BorderLayout.CENTER) ;
		this.add(bottom, BorderLayout.SOUTH) ;
	}

}
