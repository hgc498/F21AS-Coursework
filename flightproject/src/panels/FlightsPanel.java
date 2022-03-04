package panels;

import java.awt.Dimension;

import javax.swing.JPanel;

import base.Manager;
import window.MainWindow;

public class FlightsPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private TitlePanel titlePanel;
	private TablePanel tablePanel;
	private Manager manager;
	private MainWindow parent;
	
	public FlightsPanel(Manager manager,MainWindow parent) {
		this.manager = manager;
		this.parent = parent;
		init();
		setStyle();
		refreshTable();
	}
	
	private void init() {
		titlePanel = new TitlePanel("Flights");
		tablePanel = new TablePanel(this);
	}
	
	private void setStyle() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(460,300));
		titlePanel.setBounds(0,0,460,50);
		tablePanel.setBounds(0,50,460,300);
		this.add(titlePanel);
		this.add(tablePanel);
	}
	
	public void refreshTable() {
		tablePanel.refreshDatas(manager.getFlights());
	}
	
	public void changePlans(String code) {
		parent.refreshPlan(code);
	}

}
