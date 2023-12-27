package presentation;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import service.SDirectory;

public class LDirectory extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private SDirectory sDirectory;
	private JTree tree;

	public LDirectory() {
		sDirectory = new SDirectory();
	}

	public void initialize(LMainFrame.ActionHandler actionHandler) {
		DefaultMutableTreeNode rootNode = sDirectory.getDirectoryTree();
		this.tree = new JTree(rootNode);
		this.tree.addTreeSelectionListener(actionHandler);
		this.add(tree);
	}

	public void clearSelection() {
		this.tree.clearSelection();
	}

	public Vector<String> getLectures() {
		Vector<String> lectureVector = new Vector<String>();

		if (!(this.tree.getSelectionPath() == null)) {
			for (TreePath treePath : this.tree.getSelectionPaths()) {
				if (Character.isDigit(treePath.getLastPathComponent().toString().charAt(0))) {
					if (!lectureVector.contains(treePath.getLastPathComponent().toString())) {
						lectureVector.add(treePath.getLastPathComponent().toString());
					}
				}

			}
		}
		return lectureVector;
	}

}
