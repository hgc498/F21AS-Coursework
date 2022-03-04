package panels;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JPanel;

import base.Manager;

public class AddPlanPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private TitlePanel titlePanel;
	private AddPlanTablePanel tablePanel;
	private Manager manager;
	
	public AddPlanPanel(Manager manager) {
		this.manager = manager;
		init();
		setStyle();
	}
	
	private void init() {
		titlePanel = new TitlePanel("Flight plan");
		tablePanel = new AddPlanTablePanel(manager);
	}
	
	private void setStyle() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(600,100));
		titlePanel.setBounds(0,0,460,50);
		tablePanel.setBounds(0,60,600,50);
		this.add(titlePanel);
		this.add(tablePanel);
	}
	
	public void reset() {
		tablePanel.reset();
	}
	
	public List<String> getTowers() {
		return tablePanel.getFlightPlan();
	}

}
