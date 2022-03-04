package window;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import base.Flight;
import base.Manager;
import exception.MyException;
import panels.AddFlightPanel;
import panels.AddPlanPanel;
import panels.FlightsPanel;
import panels.InfosPanel;
import panels.PlanPanel;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private FlightsPanel flightsPanel;
	private PlanPanel planPlanel;
	private JPanel mainPane;
	private InfosPanel infosPanel;
	private AddFlightPanel addFlightPanel;
	private AddPlanPanel addPlanPanel;
	private Manager manager;
	
	private JButton addButton;
	private JButton exitButton;
	private JButton cancelButton;
	
	public MainWindow() {
		init();
		setStyle();
		addEventHandler();
		
		
	}
	
	private void init() {
		this.manager = new Manager();
		manager.loadAll();
		flightsPanel = new FlightsPanel(manager,this);
		planPlanel = new PlanPanel(manager);
		infosPanel = new InfosPanel(manager);
		mainPane = new JPanel();
		addFlightPanel = new AddFlightPanel(manager);
		addPlanPanel = new AddPlanPanel(manager);
		addButton = new JButton("Add");
		exitButton = new JButton("Exit");
		cancelButton = new JButton("Cancel");
		this.setContentPane(mainPane);
	}
	
	private void setStyle() {
		this.setSize(800, 800);
		this.mainPane.setLayout(null);
		flightsPanel.setBounds(10, 0, 460, 300);
		mainPane.add(flightsPanel);
		
		planPlanel.setBounds(500, 0, 100, 300);
		infosPanel.setBounds(650, 0, 140, 300);
		addFlightPanel.setBounds(10, 320, 600, 150);
		addPlanPanel.setBounds(10, 500, 800, 150);
		addButton.setBounds(20, 670, 80, 30);
		cancelButton.setBounds(160, 670, 80, 30);
		exitButton.setBounds(260, 670, 80, 30);
		mainPane.add(planPlanel);
		mainPane.add(infosPanel);
		mainPane.add(addFlightPanel);
		mainPane.add(addPlanPanel);
		mainPane.add(addButton);
		mainPane.add(cancelButton);
		mainPane.add(exitButton);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void addEventHandler() {
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Flight flight = addFlightPanel.getFlight();
					List<String> towers = addPlanPanel.getTowers();
					flight.setTowers(towers);
					boolean addFlight = manager.addFlight(flight);
					if (addFlight) {
						flightsPanel.refreshTable();
						reset();
					}
				} catch (MyException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
			}
		});
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
				
			}
		});
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}
	
	public void refreshPlan(String code) {
		
		planPlanel.refreshTable(code);
		infosPanel.setInfos(code);
	}
	
	public void reset() {
		addFlightPanel.reset();
		addPlanPanel.reset();
	}
	
	public static void main(String[] args) {
		new MainWindow()
		;
	}
	

}
