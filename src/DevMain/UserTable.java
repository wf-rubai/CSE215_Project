package DevMain;

import java.awt.Color;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserTable {
	 
	private JPanel pTableMain = new JPanel();
	private JPanel pTableUser = new JPanel();
	private JPanel pTableDev = new JPanel();
	private String[] userCollumn = {"SL",
									"Name",
									"Email",
									"Phone",
									"NID No.",
									"Status"
									};
	private String[] devCollumn = {"SL",
								   "User ID",
							       "Name",
							       "Email",
							       "Phone",
							       "NID No.",
							       "Position"
								    };
	private DefaultTableModel modelUser = new DefaultTableModel(userCollumn,0);
	private DefaultTableModel modelDev = new DefaultTableModel(devCollumn,0);
	private JTable userTable = new JTable(modelUser);
	private JTable devTable = new JTable(modelDev);
	private JButton add = new JButton("Add");
	private JButton update = new JButton("Update");
	private JButton cancel = new JButton("Cancel");
	private JComboBox<String> mode = new JComboBox<>();
	
	public JPanel panel() {
		pTableMain.setBounds(70, 0, 1180, 850);
		pTableMain.setLayout(null);
		pTableMain.setBackground(new Color(55, 160, 255, 100));
		
		mode.setBounds(100, 150, 150, 40);
		mode.addItem("User");
		mode.addItem("Developer");
		
		JScrollPane spUser = new JScrollPane(userTable,
											 JScrollPane.VERTICAL_SCROLLBAR_NEVER,
											 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spUser.setBounds(100, 200, 980, 300);
		
		JScrollPane spDev = new JScrollPane(devTable,
											JScrollPane.VERTICAL_SCROLLBAR_NEVER,
											JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spDev.setBounds(100, 200, 980, 300);
		
		mode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mode.getSelectedIndex() == 0) {
					pTableMain.remove(spDev);
					pTableMain.add(spUser);
				}else {
					pTableMain.remove(spUser);
					pTableMain.add(spDev);
				}
				
			}
		});
		
		pTableMain.add(mode);
		pTableMain.add(spUser);
		
		return pTableMain;
	}
	

}
