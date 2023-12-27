package presentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import service.SPreApplicationForClasses;
import valueObject.VPersonalInfo;
import valueObject.VPreApplicationForClasses;

public class LMiridamgi extends JPanel {

	private static final long serialVersionUID = 1L;

	private String[] columnNames = { "과목번호", "강좌이름", "담당교수", "학점", "시간" };

	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;

	private SPreApplicationForClasses sPreApplicationForClasses;
	private VPersonalInfo vPersonalInfo;

	public LMiridamgi(LMainFrame.ActionHandler actionHandler) {
		// TODO Auto-generated constructor stub

		this.model = new DefaultTableModel(columnNames, 0);
		this.table = new JTable(model);
		this.table.getSelectionModel().addListSelectionListener(actionHandler);
		this.scrollPane = new JScrollPane(table);
//		this.scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);

		this.sPreApplicationForClasses = new SPreApplicationForClasses();
	}

	public void initialize(VPersonalInfo vPersonalInfo) {
		this.vPersonalInfo = vPersonalInfo;
		this.loadData();
	}

	public ListSelectionModel getSelectionModel() {
		return this.table.getSelectionModel();
	}

	public void clearSelection() {
		this.table.clearSelection();
	}

	public void addTuple(Vector<String> dataList) {

		for (String data : dataList) {
			boolean duplication = false;

			Vector<String> spliteddDataVector = new Vector<String>();
			for (String spliteddData : Arrays.asList(data.toString().split(" "))) {
				// Check duplication
				for (int i = 0; i < this.model.getRowCount(); i++) {
					if (this.model.getValueAt(i, 0).equals(spliteddData)) {
						duplication = true;
					}
				}
				// duplication == false
				if (duplication == false) {
					spliteddDataVector.add(spliteddData);
				}
			}
			// spliteddDataVector not empty
			if (!spliteddDataVector.isEmpty()) {
				this.model.addRow(spliteddDataVector);
			}
		}

	}

	public Vector<String> getTuples() {

		Vector<String> splitTupleVector = new Vector<String>();
		Vector<String> joinedTupleVector = new Vector<String>();
		for (int selectedRow : this.table.getSelectedRows()) {
			for (int i = 0; i < table.getColumnCount(); i++) {
				splitTupleVector.add((String) this.table.getValueAt(selectedRow, i));
			}
			String tuple = String.join(" ", splitTupleVector);
			joinedTupleVector.add(tuple);
			splitTupleVector.clear();
		}
		return joinedTupleVector;
	}

	public Vector<String> getAllTuples() {

		Vector<String> splitTupleVector = new Vector<String>();
		Vector<String> joinedTupleVector = new Vector<String>();
		for (int i = 0; i < this.table.getRowCount(); i++) {
			for (int j = 0; j < table.getColumnCount(); j++) {
				splitTupleVector.add((String) this.table.getValueAt(i, j));
			}
			String tuple = String.join(" ", splitTupleVector);
			joinedTupleVector.add(tuple);
			splitTupleVector.clear();
		}
		return joinedTupleVector;
	}

	public void removeRows(Vector<String> tableDataList) {

		ArrayList<Integer> removeList = new ArrayList<Integer>();

		for (String data : tableDataList) {
			for (int i = 0; i < this.model.getRowCount(); i++) {
				if (this.model.getValueAt(i, 0).equals(Arrays.asList(data.toString().split(" ")).get(0))) {
					if (!removeList.contains(i)) {
						removeList.add(i);
					}
				}
			}
		}
		removeList.sort(Collections.reverseOrder());
		for (int i = 0; i < removeList.size(); i++) {
			model.removeRow(removeList.get(i));
		}
	}

	public void loadData() {
		Vector<String> joinedTupleVector = new Vector<String>();
		for (VPreApplicationForClasses data : sPreApplicationForClasses.getData(vPersonalInfo.getId())) {
			Vector<String> splitTupleVector = new Vector<String>();
			splitTupleVector.add(data.getLectureId());
			splitTupleVector.add(data.getLecture());
			splitTupleVector.add(data.getProfessor());
			splitTupleVector.add(data.getCredit());
			splitTupleVector.add(data.getTime());

			String tuple = String.join(" ", splitTupleVector);
			joinedTupleVector.add(tuple);
		}

		if (!joinedTupleVector.isEmpty()) {
			addTuple(joinedTupleVector);
		}
	}

	public void storeData() {
		this.sPreApplicationForClasses.store(vPersonalInfo.getId(), getAllTuples());
	}

}
