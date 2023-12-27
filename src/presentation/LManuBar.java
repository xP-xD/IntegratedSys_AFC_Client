package presentation;
import javax.swing.JMenuBar;

public class LManuBar extends JMenuBar{
	private static final long serialVersionUID = 1L;
	
	
	private LFileMenu fileMenu;
	private LEditMenu editMenu;
	
	public LManuBar() {
		this.fileMenu = new LFileMenu();
		this.add(this.fileMenu);
		this.editMenu = new LEditMenu();
		this.add(this.editMenu);
	}

	public void initialize() {
		// TODO Auto-generated method stub
		
	}

}
