package Connections;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Admin extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  JFrame fen= new JFrame() ;
	private static String titre = "CONNEXION EN ADMINISTRATEUR" ;
	JButton okBouton , reset,cancel ; 
	JTextField champTexte ; 
	JPasswordField  champTexte1 ; 
	JLabel login, passwd, labEr, labEr1;
	JDialog d ;
	private Pattern pattern; 
	private Matcher matcher ;
	
	
	public Admin() {
		// TODO Auto-generated constructor stub
		this.setBackground(Color.DARK_GRAY);
		d = new ConnexionAdmin() ;
		
	}
	
	public JDialog getBoite() {
		return this.d ;
	}

	public class ConnexionAdmin extends JDialog implements ActionListener, MouseListener {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ConnexionAdmin(){
			super(fen,titre,true);
			 Toolkit tk = Toolkit.getDefaultToolkit();
			 Dimension dimEcran = tk.getScreenSize();
			this.setSize(dimEcran.width-725, dimEcran.height-480) ;
			this.setResizable(false);
			this.setLocationRelativeTo(null) ;
			 
			 champTexte = new JTextField("");
			 champTexte1 = new JPasswordField();
			 Container contenu = getContentPane() ;
			 FlowLayout gl = new FlowLayout(7) ;
			 contenu.setLayout (gl) ;
			 
			 labEr = new JLabel() ;
			 labEr1 = new JLabel() ;
			 
			 login = new JLabel(" LOGIN "); 
			 passwd = new JLabel(" PASSWORD ");
			 okBouton = new JButton("OK") ;
			 reset = new JButton("RESET") ;
			 cancel = new JButton("Cancel") ;
			 
			 login.setForeground(Color.red);
			 passwd.setForeground(Color.RED);
			 okBouton.setForeground(Color.white);
			 reset.setForeground(Color.white);
			 cancel.setForeground(Color.black);	 
			
			 login.setPreferredSize(new Dimension(dimEcran.width-800,40));
			 passwd.setPreferredSize(new Dimension(dimEcran.width-800,40));
			 champTexte.setPreferredSize(new Dimension(dimEcran.width-800,40));
			 champTexte1.setPreferredSize(new Dimension(dimEcran.width-800,40));
			 okBouton.setPreferredSize(new Dimension((dimEcran.width-1000)/2,40));
			 reset.setPreferredSize(new Dimension((dimEcran.width-1000)/2,40));
			 cancel.setPreferredSize(new Dimension((dimEcran.width-1000)/2,40));
			 
			 champTexte.setHorizontalAlignment(JTextField.CENTER);
			 champTexte1.setHorizontalAlignment(JTextField.CENTER);
			 login.setHorizontalAlignment(JLabel.CENTER);
			 passwd.setHorizontalAlignment(JLabel.CENTER);
			 okBouton.setHorizontalAlignment(JLabel.CENTER);
			 reset.setHorizontalAlignment(JLabel.CENTER);
			 cancel.setHorizontalAlignment(JLabel.CENTER);
			 
			 okBouton.setBackground(new Color(22,29,86).darker());
			 reset.setBackground(new Color(22,29,86).darker());
			 cancel.setBackground(Color.red);
			 contenu.add(login);  
			 contenu.add(champTexte) ;
			 contenu.add(passwd); 
			 contenu.add(champTexte1);
			 contenu.add(okBouton);
			 contenu.add(reset);
			 contenu.add(cancel);
			 contenu.add(labEr);
			 contenu.add(labEr1);
			 
			 contenu.addMouseListener(this);
			 okBouton.addActionListener(this);
		}

		@SuppressWarnings("static-access")
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==okBouton) { //************************************************************************
				String log = champTexte.getText();
				String pass = champTexte1.getText() ;
				if(!log.equals("Ulrich")) {
				JOptionPane jop3 = new JOptionPane();
				jop3.showMessageDialog(null, "Login ou mot de passe incorrecte", "Erreur survenue", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			pattern = Pattern.compile("(?i)^[a-zA-Z][a-zA-Z0-9]{3}\\w") ;
			matcher = pattern.matcher(champTexte.getText()) ;
			if( !matcher.find()) {
				labEr.setText("Format Pseudo Invalide");
				labEr.setForeground(Color.red);
				okBouton.setEnabled(false);
				}
				else { champTexte.setBackground(Color.white);
					labEr.setText(null);
					okBouton.setEnabled(true);
					labEr1.setText(null);
				}
			if(champTexte1.getText().length()<4) {
				labEr1.setText("Au moins 4 caractères pour le mot de passe");
			}else labEr1.setText(null);
		}

		@SuppressWarnings("deprecation")
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			pattern = Pattern.compile("(?i)^[a-zA-Z][a-zA-Z0-9]{3}\\w") ;
			matcher = pattern.matcher(champTexte.getText()) ;
			if( !matcher.find() ) {
				labEr.setText("Format Pseudo Invalide");
				labEr.setForeground(Color.red);
				okBouton.setEnabled(false);
				}
				else { champTexte.setBackground(Color.white);
					labEr.setText(null);
					okBouton.setEnabled(true);
					labEr1.setText(null);
				}
			if(champTexte1.getText().length()<4) {
				labEr1.setText("Au moins 4 caractères pour le mot de passe");
			}else labEr1.setText(null);
		}

		@SuppressWarnings("deprecation")
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			pattern = Pattern.compile("(?i)^[a-zA-Z][a-zA-Z0-9]{3}\\w") ;
			matcher = pattern.matcher(champTexte.getText()) ;
			if( !matcher.find()) {
				labEr.setText("Format Pseudo Invalide");
				labEr.setForeground(Color.red);
				okBouton.setEnabled(false);
				}
				else { champTexte.setBackground(Color.white);
					labEr.setText(null);
					okBouton.setEnabled(true);
					labEr1.setText(null);
				}
			if(champTexte1.getText().length()<4) {
				labEr1.setText("Au moins 4 caractères pour le mot de passe");
			}else labEr1.setText(null);		}

		@SuppressWarnings("deprecation")
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			pattern = Pattern.compile("(?i)^[a-zA-Z][a-zA-Z0-9]{3}\\w") ;
			matcher = pattern.matcher(champTexte.getText()) ;
			if( !matcher.find()) {
				labEr.setText("Format Pseudo Invalide");
				labEr.setForeground(Color.red);
				okBouton.setEnabled(false);
				}
				else { champTexte.setBackground(Color.white);
					labEr.setText(null);
					okBouton.setEnabled(true);
					labEr1.setText(null);
				}
			if(champTexte1.getText().length()<4) {
				labEr1.setText("Au moins 4 caractères pour le mot de passe");
			}else labEr1.setText(null);		}

		@SuppressWarnings("deprecation")
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			pattern = Pattern.compile("(?i)^[a-zA-Z][a-zA-Z0-9]{3}\\w") ;
			matcher = pattern.matcher(champTexte.getText()) ;
			if( !matcher.find()) {
				labEr.setText("Format Pseudo Invalide");
				labEr.setForeground(Color.red);
				okBouton.setEnabled(false);
				}
				else { champTexte.setBackground(Color.white);
					labEr.setText(null);
					okBouton.setEnabled(true);
					labEr1.setText(null);
				}
			if(champTexte1.getText().length()<4) {
				labEr1.setText("Au moins 4 caractères pour le mot de passe");
			}else labEr1.setText(null);
		}
	}

	
}
