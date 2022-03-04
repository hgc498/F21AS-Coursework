package panels;

import java.awt.Dimension;

import javax.swing.JPanel;

import base.Flight;
import base.Manager;

public class PlanPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private TitlePanel titlePanel;
	private PlanListPanel tablePanel;
	private Manager manager;
	
	public PlanPanel(Manager manager) {
		this.manager = manager;
		init();
		setStyle();
//		refreshTable();
	}
	
	private void init() {
		titlePanel = new TitlePanel("Flight plan");
		tablePanel = new PlanListPanel();
	}
	
	private void setStyle() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(100,300));
		titlePanel.setBounds(0,0,100,50);
		tablePanel.setBounds(0,50,100,300);
		this.add(titlePanel);
		this.add(tablePanel);
	}
	
	public void refreshTable(String code) {
		Flight findByCode = manager.findFlightByCode(code);
		tablePanel.refreshDatas(findByCode.getTowers());
	}

}
