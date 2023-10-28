package DevMain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Common.DevInfo;
import Common.ResaveDev;
import Common.ResaveUser;
import Common.UserInfo;
import Common.fileReader;

public class UserTable {
	 
	private JPanel pTableMain = new JPanel(){
        protected void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for(int i = 0; i<20; i++){
                g2.setColor(randomColor());
                g2.fillRoundRect((int)(Math.random()*1000), (int)(Math.random()*700), (int)(30+Math.random()*300), (int)(30+Math.random()*300), 15, 15);
                g2.drawRoundRect((int)(Math.random()*1000), (int)(Math.random()*700), (int)(30+Math.random()*300), (int)(30+Math.random()*300), 15, 15);
            }
        }
    };
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
	private JButton bAdd = new JButton("Add Employee");
	private JButton reset = new JButton("Reset");
	private JButton cancel = new JButton("Cancel");
	private JButton dSave = new JButton("Save");
	private JButton uSave = new JButton("Update");
	private JComboBox<String> mode = new JComboBox<>();
	private JComboBox<String> dev = new JComboBox<>();
	private JComboBox<String> position = new JComboBox<>();
	private JComboBox<String> state = new JComboBox<>();
	private HashMap<String, LinkedList<DevInfo>> devMap = new HashMap<>();
	private HashMap<String, DevInfo> dhm = new fileReader().devoloperHashMap();
	private HashMap<String,UserInfo> uInfo = new fileReader().userHashMap();
    private JPopupMenu option = new JPopupMenu();
    private JMenuItem remove = new JMenuItem("Remove");
    private JMenuItem update = new JMenuItem("Update");
	private JTextField tfName = new JTextField();
	private JTextField tfMail = new JTextField();
	private JTextField tfPhone = new JTextField();
	private JTextField tfId = new JTextField();
	private JTextField tfNid = new JTextField();
	private JTextField tfUPass = new JTextField();
	private JTextField tfUMail = new JTextField();
	private JTextField tfUphone = new JTextField();
	private JLabel lName = new JLabel("Name :");
	private JLabel lPosition = new JLabel("Position :");
	private JLabel lMail = new JLabel("Email :");
	private JLabel lPhone = new JLabel("Phone :");
	private JLabel lUMail = new JLabel("Email :");
	private JLabel lUPhone = new JLabel("Phone :");
	private JLabel lUPass = new JLabel("Password :");
	private JLabel lUState = new JLabel("State :");
	private JLabel lId = new JLabel("ID no. :");
	private JLabel lNid = new JLabel("NID no. :");
	private JTableHeader DTH = devTable.getTableHeader();
	private JTableHeader UTH = userTable.getTableHeader();
	private DevInfo devInfo = DevLogInPanel.logerInfo;
	
	public JPanel panel() {

		setUp();
		
		userTable.setRowHeight(30);
        userTable.setFont(new Font(null, Font.PLAIN, 13));
        UTH.setPreferredSize(new Dimension(100, 30));
        UTH.setFont(new Font(null, Font.BOLD, 13));

		userTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		userTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		userTable.getColumnModel().getColumn(2).setPreferredWidth(230);
		userTable.getColumnModel().getColumn(3).setPreferredWidth(150);
		userTable.getColumnModel().getColumn(4).setPreferredWidth(170);
		userTable.getColumnModel().getColumn(5).setPreferredWidth(80);
		
		JScrollPane spUser = new JScrollPane(userTable,
											 JScrollPane.VERTICAL_SCROLLBAR_NEVER,
											 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spUser.setBounds(100, 200, 980, 300);

		devTable.setRowHeight(30);
        devTable.setFont(new Font(null, Font.PLAIN, 13));
        DTH.setPreferredSize(new Dimension(100, 30));
        DTH.setFont(new Font(null, Font.BOLD, 13));

		devTable.getColumnModel().getColumn(0).setPreferredWidth(40);
		devTable.getColumnModel().getColumn(1).setPreferredWidth(150);
		devTable.getColumnModel().getColumn(2).setPreferredWidth(170);
		devTable.getColumnModel().getColumn(3).setPreferredWidth(200);
		devTable.getColumnModel().getColumn(4).setPreferredWidth(150);
		devTable.getColumnModel().getColumn(5).setPreferredWidth(200);
		devTable.getColumnModel().getColumn(6).setPreferredWidth(80);

		JScrollPane spDev = new JScrollPane(devTable,
											JScrollPane.VERTICAL_SCROLLBAR_NEVER,
											JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spDev.setBounds(100, 200, 980, 300);
		setDevTable();
		
		mode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mode.getSelectedIndex() == 1) {
					pTableMain.remove(spDev);
					pTableMain.remove(bAdd);
					pTableMain.remove(dev);
					pTableMain.remove(pTableUser);
					pTableMain.remove(pTableDev);
					pTableMain.add(spUser);
					setUserTable();
				}else {
					pTableMain.remove(spUser);
					pTableMain.remove(pTableUser);
					pTableMain.remove(pTableDev);
					pTableMain.add(spDev);
					pTableMain.add(dev);
					if(devInfo.position.equals("CEO")){
						pTableMain.add(bAdd);
					}else if(devInfo.position.equals("Admin")){
						pTableMain.add(bAdd);
					}
					setDevTable();
				}
				SwingUtilities.updateComponentTreeUI(pTableMain);
			}
		});

		dev.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setDevTable();
			}
		});

		bAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetAll();
				position.removeAllItems();
				if(devInfo.position.equals("CEO")){
					position.addItem("Admin");
					position.addItem("Editor");
				}else{
					position.addItem("Editor");
				}
				pTableDev.add(lPosition);
				pTableDev.add(position);
				pTableDev.add(reset);
				pTableDev.add(cancel);
				pTableDev.add(dSave);
				pTableMain.add(pTableDev);
				dSave.setText("Add");
				SwingUtilities.updateComponentTreeUI(pTableMain);
			}
		});

		update.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetAll();
				if(mode.getSelectedItem().equals("Developer")){
					position.removeAllItems();
					if(devInfo.position.equals("CEO")){
						position.addItem("Admin");
						position.addItem("Editor");
					}else{
						position.addItem("Editor");
					}
					pTableDev.add(lPosition);
					pTableDev.add(position);
					pTableDev.add(reset);
					pTableDev.add(cancel);
					pTableDev.add(dSave);
					pTableMain.add(pTableDev);
					dSave.setText("Update");
				}else{
					pTableUser.add(reset);
					pTableUser.add(cancel);
					pTableUser.add(uSave);
					pTableMain.add(pTableUser);
				}
				SwingUtilities.updateComponentTreeUI(pTableMain);
			}
		});

		remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mode.getSelectedItem().equals("Developer")){
					for(DevInfo d: dhm.values()){
						if(d.name.equals((String)devTable.getValueAt(devTable.getSelectedRow(), 2))){
							dhm.remove(d.pass);
							break;
						}
					}
        			new ResaveDev(dhm);
					setDevTable();
				}else{
					for(UserInfo u: uInfo.values()){
						if(u.name.equals((String)userTable.getValueAt(userTable.getSelectedRow(), 1))){
							uInfo.remove(u.pass);
							break;
						}
					}
					new ResaveUser(uInfo);
					setUserTable();
				}
				SwingUtilities.updateComponentTreeUI(pTableMain);
			}
		});

		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetAll();
				SwingUtilities.updateComponentTreeUI(pTableMain);
			}
		});

		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pTableMain.remove(pTableDev);
				pTableMain.remove(pTableUser);
				SwingUtilities.updateComponentTreeUI(pTableMain);
			}
		});

		dSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DevInfo di = new DevInfo();
				di.name = tfName.getText();
				di.mail = tfMail.getText();
				di.id = tfId.getText();
				di.phone = tfPhone.getText();
				di.nid = tfNid.getText();
				if(dSave.getText().equals("Add")){
					di.pass = "new" + dhm.size();
					di.position = (String) position.getSelectedItem();
					if(di.position.equals("Editor")){
						di.imgIndex = 1;
					}else{
						di.imgIndex = 2;
					}
					dhm.put(di.pass, di);
				}else{
					for(DevInfo d: dhm.values()){
						if(d.name.equals((String)devTable.getValueAt(devTable.getSelectedRow(), 2))){
							di.position = d.position;
							di.pass = d.pass;
							break;
						}
					}
					if(di.position.equals("Editor")){
						di.imgIndex = 1;
					}else{
						di.imgIndex = 2;
					}
					dhm.replace(di.pass, di);
				}
				pTableMain.remove(pTableDev);
        		new ResaveDev(dhm);
				setDevTable();
				SwingUtilities.updateComponentTreeUI(pTableMain);
			}
		});

		uSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String n = (String)userTable.getValueAt(userTable.getSelectedRow(), 1);
				for(UserInfo u: uInfo.values()){
					if(u.name.equals(n)){
						uInfo.remove(u.pass);
						u.pass = tfUPass.getText();
						u.mail = tfUMail.getText();
						u.phone = tfUphone.getText();
						u.status = (String) state.getSelectedItem();
						uInfo.put(u.pass, u);
						break;
					}
				}
				pTableMain.remove(pTableUser);
				new ResaveUser(uInfo);
				setUserTable();
				SwingUtilities.updateComponentTreeUI(pTableMain);
			}
		});

        userTable.addMouseListener(new MouseListener() {

            public void doPopup(MouseEvent e) {              
                option.show(e.getComponent(), e.getX(), e.getY());            
            } 

            @Override
            public void mouseClicked(MouseEvent e) {
                doPopup(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        devTable.addMouseListener(new MouseListener() {

            public void doPopup(MouseEvent e) {              
                option.show(e.getComponent(), e.getX(), e.getY());            
            } 


			@Override
			public void mouseClicked(MouseEvent e) {
				doPopup(e);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
        });
		
		pTableMain.add(mode);
		pTableMain.add(spDev);
		pTableMain.add(dev);
		if(devInfo.position.equals("CEO")){
			pTableMain.add(bAdd);
		}else if(devInfo.position.equals("Admin")){
			pTableMain.add(bAdd);
		}
		
		return pTableMain;
	}

	private void resetAll(){
		String s = (String) mode.getSelectedItem();
		if(s.equals("Developer")){
			tfName.setText((String)devTable.getValueAt(devTable.getSelectedRow(), 2));
			tfId.setText((String)devTable.getValueAt(devTable.getSelectedRow(), 1));
			tfMail.setText((String)devTable.getValueAt(devTable.getSelectedRow(), 3));
			tfPhone.setText((String)devTable.getValueAt(devTable.getSelectedRow(), 4));
			tfNid.setText((String)devTable.getValueAt(devTable.getSelectedRow(), 5));
		}else {
			tfUMail.setText((String)userTable.getValueAt(userTable.getSelectedRow(), 2));
			tfUphone.setText((String)userTable.getValueAt(userTable.getSelectedRow(), 3));
			for(UserInfo u: uInfo.values()){
				if(u.name.equals((String)userTable.getValueAt(userTable.getSelectedRow(), 1))){
					tfUPass.setText(u.pass);
				}
			}
		}
	}

	private void setUserTable(){
		modelUser.setRowCount(0);
		int i = 1;
		for(UserInfo u: uInfo.values()){
			Object[] o = {i, u.name, u.mail, u.phone, u.nid, u.status};
			i++;
			modelUser.addRow(o);
		}
	}

	private void setDevTable(){

		devMap.clear();
		for(DevInfo d: new fileReader().devoloperHashMap().values()){
			if(!devMap.containsKey(d.position)){
				LinkedList<DevInfo> ll = new LinkedList<>();
				ll.add(d);
				devMap.put(d.position, ll);
			}else {
				LinkedList<DevInfo> ll = devMap.get(d.position);
				ll.add(d);
				devMap.replace(d.position, ll);
			}
		}

		modelDev.setRowCount(0);
		int i = 1;
		LinkedList<DevInfo> ll = devMap.get(dev.getSelectedItem()+"");
		for(DevInfo d: ll){
			Object[] o = {i, d.id, d.name, d.mail, d.phone, d.nid, d.position};
			i++;
			modelDev.addRow(o);
		}
	}
	
	private void setUp(){

		pTableMain.setBounds(70, 0, 1180, 850);
		pTableMain.setLayout(null);
		pTableMain.setBackground(Color.darkGray);
		
		mode.setBounds(100, 150, 150, 40);
		mode.addItem("Developer");
		mode.addItem("User");

		dev.setBounds(270, 150, 150, 40);
		dev.addItem("CEO");
		dev.addItem("Admin");
		dev.addItem("Editor");

		pTableDev.setBounds(100, 550, 980, 300);
		pTableDev.setOpaque(false);
		pTableDev.setLayout(null);

		lId.setBounds(50, 0, 100, 40);
		lName.setBounds(50, 50, 100, 40);
		lMail.setBounds(50, 100, 100, 40);
		lPhone.setBounds(540, 0, 100, 40);
		lNid.setBounds(540, 50, 100, 40);
		lPosition.setBounds(540, 100, 100, 40);
		
		tfId.setBounds(150, 0, 300, 40);
		tfName.setBounds(150, 50, 300, 40);
		tfMail.setBounds(150, 100, 300, 40);
		tfPhone.setBounds(640, 0, 300, 40);
		tfNid.setBounds(640, 50, 300, 40);
		position.setBounds(640, 100, 300, 40);

		reset.setBounds(640, 150, 90, 40);
		cancel.setBounds(745, 150, 90, 40);
		dSave.setBounds(850, 150, 90, 40);
		uSave.setBounds(850, 150, 90, 40);

		pTableDev.add(lId);
		pTableDev.add(lName);
		pTableDev.add(lMail);
		pTableDev.add(lPhone);
		pTableDev.add(lNid);
		pTableDev.add(tfId);
		pTableDev.add(tfName);
		pTableDev.add(tfMail);
		pTableDev.add(tfPhone);
		pTableDev.add(tfNid);

        option.add(remove);
        option.add(update);
        option.add(new JMenuItem("Close"));

		pTableUser.setBounds(100, 550, 980, 300);
		pTableUser.setOpaque(false);
		pTableUser.setLayout(null);

		lUMail.setBounds(50, 0, 100, 40);
		lUPhone.setBounds(50, 50, 100, 40);
		lUPass.setBounds(50, 100, 100, 40);
		lUState.setBounds(540, 0, 100, 40);

		tfUMail.setBounds(150, 0, 300, 40);
		tfUphone.setBounds(150, 50, 300, 40);
		tfUPass.setBounds(150, 100, 300, 40);
		state.setBounds(640, 0, 300, 40);
		state.addItem("Active");
		state.addItem("Banned");

		pTableUser.add(lUMail);
		pTableUser.add(lUPass);
		pTableUser.add(lUPhone);
		pTableUser.add(lUState);
		pTableUser.add(tfUMail);
		pTableUser.add(tfUphone);
		pTableUser.add(tfUPass);
		pTableUser.add(state);

		bAdd.setBounds(930, 150, 150, 40);
	}

    private static Color randomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b, 100);
    }
}
