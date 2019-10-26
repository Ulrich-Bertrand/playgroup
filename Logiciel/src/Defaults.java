import java.awt.Dimension;
import java.awt.Toolkit;

public class Defaults {
	private Dimension dimEcran;
	private Toolkit tk ;
	
	public Defaults() {
		// TODO Auto-generated constructor stub
		 tk = Toolkit.getDefaultToolkit();
		 dimEcran = tk.getScreenSize();
	}
	public Dimension getDim() {
		return dimEcran ;
	}
	public int butWidth() {
		return dimEcran.width/5 ;
	}
	public int butheight() {
		return dimEcran.height/15 ;
	}
}
