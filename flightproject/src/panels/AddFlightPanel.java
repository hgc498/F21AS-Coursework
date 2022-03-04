package panels;

import java.awt.Dimension;

import javax.swing.JPanel;

import base.Flight;
import base.Manager;

public class AddFlightPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TitlePanel titlePanel;
	private AddFlightTablePanel tablePanel;
	private Manager manager;
	
	public AddFlightPanel(Manager manager) {
		this.manager = manager;
		init();
		setStyle();
	}
	
	private void init() {
		titlePanel = new TitlePanel("Add Flight");
		tablePanel = new AddFlightTablePanel(manager);
	}
	
	private void setStyle() {
		this.setLayout(null);
		this.setPreferredSize(new Dimension(460,100));
		titlePanel.setBounds(0,0,460,50);
		tablePanel.setBounds(0,50,460,50);
		this.add(titlePanel);
		this.add(tablePanel);
	}
	
	public void reset() {
		tablePanel.reset();
	}
	
	public Flight getFlight() {
		return tablePanel.getFlight();
	}

}
