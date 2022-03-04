package panels;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import base.Flight;
import base.FlightPlan;
import base.GPScoordlinate;
import base.Manager;

public class InfosPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel lable1;
	private JLabel lable2;
	private JLabel lable3;
	private JLabel lable4;
	private JTextField field1;
	private JTextField field2;
	private JTextField field3;
	private JTextField field4;
	
	private JLabel cell1;
	private JLabel cell2;
	private JLabel cell3;
	
	private Manager manager;
	
	public InfosPanel(Manager manager) {
		this.manager = manager;
		init();
		setStyle();
	}
	
	private void init() {
		lable1 = new JLabel("Distance");
		lable2 = new JLabel("Time");
		lable3 = new JLabel("Fuel consumption");
		lable4 = new JLabel("CO2");
		cell1 = new JLabel("km");
		cell2 = new JLabel("litre");
		cell3 = new JLabel("kg");
		field1 = new JTextField(5);
		field2 = new JTextField(5);
		field3 = new JTextField(5);
		field4 = new JTextField(5);
	}
	private void setStyle() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(130,300));
		lable1.setBounds(10, 0, 80, 30);
		field1.setBounds(0, 32, 80, 30);
		cell1.setBounds(81	, 32, 18, 30);
		lable2.setBounds(10, 64, 80, 30);
		field2.setBounds(0,  96,80, 30);
		lable3.setBounds(0, 128, 100, 30);
		field3.setBounds(0, 160, 80, 30);
		cell2.setBounds(81, 160, 30, 30);
		lable4.setBounds(10, 192, 80, 30);
		field4.setBounds(0, 224, 80, 30);
		cell3.setBounds(81, 224, 18, 30);
		this.add(lable1);
		this.add(lable2);
		this.add(lable3);
		this.add(lable4);
		this.add(field1);
		this.add(field2);
		this.add(field3);
		this.add(field4);
		this.add(cell1);
		this.add(cell2);
		this.add(cell3);
	}
	
	public void setInfos(String code) {
		Flight flight = manager.findFlightByCode(code);
		GPScoordlinate gps = new GPScoordlinate();
		Double distance = gps.getDistance(manager.findPortByCode(flight.getDeparture()), manager.findPortByCode(flight.getDestination()));
		FlightPlan plan = manager.findPlanByCode(flight.getPlanCode());
		Double total = distance/plan.getSpeed();
		int hour = total.intValue();
		int time = ((Double)((total-total.intValue())*60)).intValue();
		field1.setText(distance.intValue()+"");
		field2.setText(hour+":"+time);
		field3.setText(plan.getSpeed().intValue()+"");
		Double t = (distance/100)*plan.getConsumption();
		field4.setText(t.intValue()+"");
		
	}

}
