package panels;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class BoxCell extends AbstractCellEditor implements TableCellEditor{
	
	private static final long serialVersionUID = 1L;

	private String[] options;
	
	private JComboBox<String> jbox;
	
	
	public BoxCell(String[] options) {
		this.options = options;
		jbox = new JComboBox<>(this.options);
		jbox.setSelectedIndex(0);
	}
	
	
	@Override
	public Object getCellEditorValue() {
		String v1 = jbox.getSelectedItem().toString();
		return v1;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return jbox;
	}

}
