package service;

import java.rmi.RemoteException;

import javax.swing.tree.DefaultMutableTreeNode;

public class SDirectory extends Stub {

	public DefaultMutableTreeNode getDirectoryTree() {
		
		DefaultMutableTreeNode node = null;
		
		// TODO Auto-generated method stub
		try {
			node = remoteObject.getDirectoryTree();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return node;
	}

}
