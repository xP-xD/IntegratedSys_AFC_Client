package presentation;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LFileMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	
	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	
	public LFileMenu() {
		super("File");
		
		this.newItem = new JMenuItem("new");
		this.add(this.newItem);
		
		this.openItem = new JMenuItem("open");
		this.add(this.openItem);
		
		this.saveItem = new JMenuItem("save");
		this.add(this.saveItem);
	}
	
}
