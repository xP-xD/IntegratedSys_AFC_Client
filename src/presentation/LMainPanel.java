package presentation;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import valueObject.VPersonalInfo;

public class LMainPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private LayoutManager layoutManager;
	
	private LMiridamgi miridamgi;
	private LSugangshincheong sugangshincheong;
	
	public LMainPanel(LMainFrame.ActionHandler actionHandler) {
		
		this.layoutManager = new GridLayout(3,2);
		this.setLayout(layoutManager);
		
		JButton miridamgiMoveButton = new JButton(">>");
		miridamgiMoveButton.addActionListener(actionHandler);
		this.add(miridamgiMoveButton);
		
		this.miridamgi =new LMiridamgi(actionHandler);
		this.add(this.miridamgi);
		
		JPanel emptyPanel = new JPanel();
        emptyPanel.setBackground(this.getBackground());
        this.add(emptyPanel);
		
		JButton sugangshincheongMoveButton = new JButton("V");
		sugangshincheongMoveButton.addActionListener(actionHandler);
		this.add(sugangshincheongMoveButton);
		
		JButton sugangshincheongDeleteButton = new JButton("<<");
		sugangshincheongDeleteButton.addActionListener(actionHandler);
		this.add(sugangshincheongDeleteButton);
		
		this.sugangshincheong = new LSugangshincheong(actionHandler);
		this.add(this.sugangshincheong);

	}
	
	public void initialize(VPersonalInfo vPersonalInfo) {
		this.miridamgi.initialize(vPersonalInfo);
		this.sugangshincheong.initialize(vPersonalInfo);
	}
	
	public ListSelectionModel getMiridamgiSelectionModel() {
		return this.miridamgi.getSelectionModel();
	}
	
	public ListSelectionModel getSugangshincheongSelectionModel() {
		return this.sugangshincheong.getSelectionModel();
	}

	public void addMiridamgiTuple(Vector<String> dataList) {
		this.miridamgi.addTuple(this.sugangshincheong.checkDuplication(dataList));
	}
	
	public void addSugangshincheongTuples(Vector<String> dataList) {
		this.sugangshincheong.addTuples(dataList);
	}
	
	public Vector<String> getMiridamgiTuples() {
		return this.miridamgi.getTuples();
	}
	
	public Vector<String> getSugangshincheongTuples() {
		return this.sugangshincheong.getTuples();
	}
	
	public void removeMiridamgiTuples(Vector<String> tableDataList) {
		this.miridamgi.removeRows(tableDataList);
	}
	
	public void removeSugangshincheongTuples(Vector<String> tableDataList) {
		this.sugangshincheong.removeRows(tableDataList);
	}

	public void clearMiridamgiSelection() {
		this.miridamgi.clearSelection();
	}
	
	public void clearSugangshincheongSelection() {
		this.sugangshincheong.clearSelection();
	}
	
	public void storeMiridamgiData() {
		this.miridamgi.storeData();
	}

	public void storeSugangshincheongData() {
		this.sugangshincheong.storeData();
	}
	
}