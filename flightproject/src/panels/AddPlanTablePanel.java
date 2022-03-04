package panels;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import base.Airport;
import base.Manager;
import exception.MyException;

public class AddPlanTablePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private Manager manager;
	public AddPlanTablePanel(Manager manager) {
		this.manager = manager;
		init();
	}
	private String[] parseAirport(){
		List<Airport> airports = manager.getAirports();
		String[] result = new String[airports.size()];
		for (int i = 0; i < airports.size(); i++) {
			Airport item = airports.get(i);
			result[i] = item.getCode();
			
		}
		return result;
	}
	private class TableStyle extends DefaultTableCellRenderer{
		private static final long serialVersionUID = 1L;

		TableStyle(){
			setHorizontalAlignment(RIGHT);
		}
	}
	private void init() {
		String[][] strs = {{"▼","▼","▼","▼","▼","▼","▼","▼"}};
		String[] headler = {"","","","","","","",""};
		
		model = new DefaultTableModel(strs, headler);
		table = new JTable(model);
		TableColumnModel columnModel = table.getColumnModel();
		
		for (int i = 0; i <headler.length; i++) {
			columnModel.getColumn(i).setCellEditor(new BoxCell(parseAirport()));
		}
		table.getTableHeader().setVisible(false);
		table.setDefaultRenderer(Object.class, new TableStyle());
		
		this.add(table);
		
	}
	
	public void reset() {
		String[][] datas = {{"▼","▼","▼","▼","▼","▼","▼","▼"}};
		model.getDataVector().clear();
		model.addRow(datas[0]);
	}
	
	public List<String> getFlightPlan() {
		List<String> plans = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Vector<String> vector = model.getDataVector().get(0);
		for (int i = 0; i < 8; i++) {
			if (vector.get(i).trim().equals("▼")) {
				continue;
			}
			plans.add(vector.get(i));
		}
		if (plans.size() == 0) {
			throw new MyException("plans at least one ");
		}
		
		return plans;
	}
	
	
	
	

}
