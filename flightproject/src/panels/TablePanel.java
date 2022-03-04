package panels;

import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import base.Flight;

public class TablePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private FlightsPanel parent;
	
	private static String[] titles = {
			"Flight",
			"Plane",
			"Departure",
			"Destination",
			"Date",
			"Time"
	};
	
	public TablePanel(FlightsPanel parent) {
		this.parent = parent;
		init();
		addEventHandler();
	}
	
	private void init() {
		model = new DefaultTableModel(titles,0);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		this.add(scrollPane);
	}
	
	private void addEventHandler() {
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					@SuppressWarnings("unchecked")
					Vector<String> vector = model.getDataVector().get(row);
					if(vector.get(0).trim().equals("")) {
						return;
					}
					parent.changePlans(vector.get(0));
					
				}
				
			}
		});
	}
	
	public void refreshDatas(List<Flight> flights) {
		model.getDataVector().clear();
		for (Flight flight : flights) {
			Vector<String> vector = new Vector<>();
			vector.add(flight.getCode());
			vector.add(flight.getPlanCode());
			vector.add(flight.getDeparture());
			vector.add(flight.getDestination());
			vector.add(flight.getDateStr());
			vector.add(flight.getTimeStr());
			model.addRow(vector);;
		}
	}
	
	
	
	

}
