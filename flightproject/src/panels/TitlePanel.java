package panels;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel title;
	
	public TitlePanel(String title) {
		this.title = new JLabel(title,JLabel.CENTER);
		this.add(this.title);
	}
	

}
