package panels;

import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class PlanListPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPanel;
	private JTable table;
	private DefaultTableModel model;
	
//	private static String[] headers = {""};
	
	public PlanListPanel() {
		init();
	}
	private class TableStyle extends DefaultTableCellRenderer{
		private static final long serialVersionUID = 1L;

		TableStyle(){
			setHorizontalAlignment(CENTER);
		}
	}
	private void init() {
		model = new DefaultTableModel(20,1);
		table = new JTable(model);
		table.getTableHeader().setVisible(false);
		scrollPanel = new JScrollPane(table);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.setDefaultRenderer(Object.class, new TableStyle());
		this.add(scrollPanel);
	}

	public void refreshDatas(List<String> datas) {
		model.getDataVector().clear();
		int i = 0;
		for (String string : datas) {
			Vector<String> row = new Vector<>();
			row.add(string);
			model.addRow(row);
			i++;
		}
		for (int j = i; j < 20; j++) {
			Vector<String> row = new Vector<>();
			row.add("");
			model.addRow(row);
		}
		
	}

}
