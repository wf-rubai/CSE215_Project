package DevMain;

import java.awt.Color;
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

import Common.DevInfo;
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
	private JComboBox<String> mode = new JComboBox<>();
	private JComboBox<String> dev = new JComboBox<>();
	private JComboBox<String> position = new JComboBox<>();
	private HashMap<String, LinkedList<DevInfo>> devMap = new HashMap<>();
	private HashMap<String, DevInfo> dhm = new fileReader().devoloperHashMap();
    private JPopupMenu option = new JPopupMenu();
    private JMenuItem remove = new JMenuItem("Remove");
    private JMenuItem update = new JMenuItem("Update");
	private JTextField tfName = new JTextField();
	private JTextField tfMail = new JTextField();
	private JTextField tfPhone = new JTextField();
	private JTextField tfId = new JTextField();
	private JTextField tfNid = new JTextField();
	private JLabel lName = new JLabel("Name :");
	private JLabel lPosition = new JLabel("Position :");
	private JLabel lMail = new JLabel("Email :");
	private JLabel lPhone = new JLabel("Phone :");
	private JLabel lId = new JLabel("ID no. :");
	private JLabel lNid = new JLabel("NID no. :");
	private DevInfo devInfo = DevLogInPanel.logerInfo;
	
	public JPanel panel() {

		setUp();
		
		JScrollPane spUser = new JScrollPane(userTable,
											 JScrollPane.VERTICAL_SCROLLBAR_NEVER,
											 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spUser.setBounds(100, 200, 980, 300);
		setDevTable();
		
		JScrollPane spDev = new JScrollPane(devTable,
											JScrollPane.VERTICAL_SCROLLBAR_NEVER,
											JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		spDev.setBounds(100, 200, 980, 300);
		
		mode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(mode.getSelectedIndex() == 1) {
					pTableMain.remove(spDev);
					pTableMain.remove(bAdd);
					pTableMain.remove(dev);
					pTableMain.add(spUser);
				}else {
					pTableMain.remove(spUser);
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
					pTableDev.remove(lPosition);
					pTableDev.remove(position);
					pTableMain.add(pTableDev);
					dSave.setText("Update");
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
				di.position = (String) position.getSelectedItem();
				if(position.getSelectedItem().equals("Editor")){
					di.imgIndex = 1;
				}else{
					di.imgIndex = 2;
				}
				if(dSave.getText().equals("Add")){
					di.pass = "new" + dhm.size();
					dhm.put(di.pass, di);
				}else{
					for(DevInfo d: dhm.values()){
						if(d.name.equals((String)devTable.getValueAt(devTable.getSelectedRow(), 2))){
							di.pass = d.pass;
							break;
						}
					}
					dhm.replace(di.pass, di);
				}
				fileSaver(1);
				pTableMain.remove(pTableDev);
				setDevTable();
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

	private void fileSaver(int i){
		if(i == 1){
			File file = new File("Files/devInfo.txt");
			file.delete();
			for(DevInfo d: dhm.values()){
				try{
					FileWriter fw = new FileWriter(file, true);
					fw.write("\n" + 
							d.name.replace(" ", "_") + "\t" +
							d.pass.replace(" ", "_") + "\t" +
							d.id.replace(" ", "_") + "\t" +
							d.mail.replace(" ", "_") + "\t" +
							d.phone.replace(" ", "_") + "\t" +
							d.nid.replace(" ", "_") + "\t" +
							d.position.replace(" ", "_") + "\t" +
							d.imgIndex + "\t"
							);
					fw.close();
				}catch(Exception e){
					JOptionPane.showMessageDialog(pTableMain, "Something Went Wrong Adding Hotel Information", "ADDING ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	private void resetAll(){
		tfId.setText("");
		tfName.setText("");
		tfMail.setText("");
		tfNid.setText("");
		tfPhone.setText("");
		position.addItem("null");
		position.setSelectedIndex(0);
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

		bAdd.setBounds(930, 150, 150, 40);
	}

    private static Color randomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b, 100);
    }
}
