package presentation;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import valueObject.VPersonalInfo;

public class LMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private LayoutManager layoutManager;

	private ActionHandler actionHandler;

	private LManuBar manuBar;
	private LDirectory directory;
	private JScrollPane scrollpaneOfDirectory;
	private LMainPanel mainPanel;

	public LMainFrame() {
		// set, attribute
		this.setSize(1300, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// component manager
		this.layoutManager = new BorderLayout();
		this.setLayout(layoutManager);

		// eventListner
		this.actionHandler = new ActionHandler();
		this.addWindowListener(actionHandler);

		// components
		this.manuBar = new LManuBar();
		this.add(this.manuBar, BorderLayout.NORTH);

		this.directory = new LDirectory();
		this.scrollpaneOfDirectory = new JScrollPane(this.directory);
		this.scrollpaneOfDirectory.setPreferredSize(new Dimension(this.getWidth() / 4, this.getHeight()));
		this.add(this.scrollpaneOfDirectory, BorderLayout.WEST);

		this.mainPanel = new LMainPanel(actionHandler);
		this.add(this.mainPanel, BorderLayout.CENTER);
	}
	
	public void initialize(VPersonalInfo vPersonalInfo) {
		this.manuBar.initialize();
		this.directory.initialize(actionHandler);
		this.mainPanel.initialize(vPersonalInfo);
		
	}

	class ActionHandler implements ActionListener, TreeSelectionListener, ListSelectionListener, WindowListener {

		private Vector<String> directoryDataList;
		private Vector<String> tableDataList;

		public ActionHandler() {
			this.directoryDataList = new Vector<String>();
			this.tableDataList = new Vector<String>();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getActionCommand().equals(">>")) {
				if (!directoryDataList.isEmpty()) {
					this.tableDataList.clear();
//					System.out.println(dataList);
					mainPanel.addMiridamgiTuple(directoryDataList);
					directory.clearSelection();
					this.directoryDataList.clear();
				}
			} else if (e.getActionCommand().equals("V")) {
				if (!tableDataList.isEmpty()) {
//					System.out.println(tableDataList);
					mainPanel.addSugangshincheongTuples(tableDataList);
					mainPanel.removeMiridamgiTuples(tableDataList);
					mainPanel.clearSugangshincheongSelection();
					this.tableDataList.clear();
				}
			} else if (e.getActionCommand().equals("<<")) {
				if (!tableDataList.isEmpty()) {
					mainPanel.removeSugangshincheongTuples(tableDataList);
					mainPanel.clearMiridamgiSelection();
					this.tableDataList.clear();
				}
			}

		}

		// nodeList
		@Override
		public void valueChanged(TreeSelectionEvent e) {
			
			this.directoryDataList.clear();
			
			mainPanel.clearMiridamgiSelection();
			mainPanel.clearSugangshincheongSelection();
			
			if(!directory.getLectures().isEmpty()) {
				for(String lecture : directory.getLectures()) {
					this.directoryDataList.add(lecture);
				}
			}
		}

		// tableList
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub

			this.tableDataList.clear();
			if (e.getSource().equals(mainPanel.getMiridamgiSelectionModel())) {
				mainPanel.clearSugangshincheongSelection();
				if (!e.getValueIsAdjusting()) {
					for (String tuple : mainPanel.getMiridamgiTuples()) {
						this.tableDataList.add(tuple);
					};
				}
			}else if(e.getSource().equals(mainPanel.getSugangshincheongSelectionModel())){
				mainPanel.clearMiridamgiSelection();
				if (!e.getValueIsAdjusting()) {
					for (String tuple : mainPanel.getSugangshincheongTuples()) {
						this.tableDataList.add(tuple);
					};
				}
			}
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			mainPanel.storeMiridamgiData();
			mainPanel.storeSugangshincheongData();
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

	}

}
