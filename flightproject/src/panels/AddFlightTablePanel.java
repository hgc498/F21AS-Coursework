package panels;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import base.Airline;
import base.Airport;
import base.Flight;
import base.FlightPlan;
import base.Manager;
import exception.MyException;

public class AddFlightTablePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private Manager manager;
public static String[] columnNames = {
			"Airline",
			"Number",
			"Plane",
			"Departure",
			"Destination",
			"Date",
			"Time"
	};
	
	private String[][] datas = {{
		"��",
		"",
		"��",
		"��",
		"��",
		"",
		""
	}};
	
	public AddFlightTablePanel(Manager manager) {
		this.manager = manager;
		init();
		addEventHandler();
	}
	
	private class TableStyle extends DefaultTableCellRenderer{
		private static final long serialVersionUID = 1L;

		TableStyle(){
			setHorizontalAlignment(RIGHT);
		}
	}
	
	private String[] parseAirline(){
		List<Airline> airlines = manager.getAirlines();
		String[] result = new String[airlines.size()];
		for (int i = 0; i < airlines.size(); i++) {
			Airline item = airlines.get(i);
			result[i] = item.getCode();
			
		}
		return result;
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
	private String[] parseFlightPlan(){
		List<FlightPlan> plans = manager.getPlans();
		String[] result = new String[plans.size()];
		for (int i = 0; i < plans.size(); i++) {
			FlightPlan item = plans.get(i);
			result[i] = item.getModel();
			
		}
		return result;
	}
	
	private void init() {
		model = new DefaultTableModel(datas,columnNames);
		table = new JTable(model);
		scrollPane = new JScrollPane(table);
		table.getTableHeader().setVisible(true);
		table.getColumnModel().getColumn(0).setCellEditor(new BoxCell(parseAirline()));
		table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JTextField(10)));
		table.getColumnModel().getColumn(2).setCellEditor(new BoxCell(parseFlightPlan()));
		table.getColumnModel().getColumn(3).setCellEditor(new BoxCell(parseAirport()));
		table.getColumnModel().getColumn(4).setCellEditor(new BoxCell(parseAirport()));
		table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(new JTextField(10)));
		table.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(new JTextField(10)));
		table.setDefaultRenderer(Object.class, new TableStyle());
		this.add(scrollPane);
	}
	
	public void addEventHandler() {
		table.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				if (e.getType() == TableModelEvent.UPDATE) {
					table.getValueAt(e.getLastRow(), e.getColumn());
				}
				
			}
		});
	}
	
	public void reset() {
		model.getDataVector().clear();
		model.addRow(datas[0]);
	}
	
	public Flight getFlight() {
		@SuppressWarnings("unchecked")
		Vector<String> vector = model.getDataVector().get(0);
		
		String dateFormat = "dd:MM:yyyy";
		String timeFormat = "HH:mm";
		
		String airlineCode = vector.get(0);
		String number = vector.get(1);
		String planCode = vector.get(2);
		String departCode = vector.get(3);
		String destCode = vector.get(4);
		String dateStr = vector.get(5);
		String timeStr = vector.get(6);
		Flight flight = new Flight();
		
		if (airlineCode.trim().equals("��")) {
			throw new MyException("airline is null");
		}
		//flight.setCode(airlineCode.trim());
		if (departCode.trim().equals("��")) {
			throw new MyException("departure is null");
		}
		flight.setDeparture(departCode.trim());
		if (planCode.trim().equals("��")) {
			throw new MyException("flightplan is null");
		}
		flight.setPlanCode(planCode.trim());
		if (destCode.trim().equals("��")) {
			throw new MyException("destination is null");
		}
		flight.setDestination(destCode.trim());
		try {
			int parseInt = Integer.parseInt(number);
			flight.setCode(airlineCode+parseInt);
		}catch (Exception e) {
			throw new MyException("number is not a digist");
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat(dateFormat);
			format.parse(dateStr);
		} catch (Exception e) {
			throw new MyException("Date must be dd:MM:yyyy");
		}
		try {
			SimpleDateFormat format = new SimpleDateFormat(timeFormat);
			SimpleDateFormat format1 = new SimpleDateFormat(dateFormat+" "+timeFormat);
			format.parse(timeStr);
			Date parse2 = format1.parse(dateStr+" "+timeStr);
			flight.setBegin(parse2);
		} catch (Exception e) {
			throw new MyException("Time must be HH:mm");
		}
		return flight;
	}

}
