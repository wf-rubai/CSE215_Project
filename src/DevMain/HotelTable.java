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
import java.util.Vector;

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

import Common.CPanel;
import Common.Hotels;
import Common.fileReader;

public class HotelTable implements CPanel {

    private JPanel pHotTable = new JPanel(){
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
    private HashMap<String, LinkedList<Hotels>> hotelsList = new fileReader().hotelHashMap();
    private Vector<String> vector = new Vector<>(hotelsList.keySet());
    private JPopupMenu option = new JPopupMenu();
    private JMenuItem remove = new JMenuItem("Remove");
    private JMenuItem update = new JMenuItem("Update");
    private int i = 1;
    private String[] columnNames = {"SL",
                                    "Hotel Name",
                                    "City", 
                                    "Longitude",
                                    "Latitude",
                                    "5",
                                    "4",
                                    "3",
                                    "2",
                                    "1",
                                    "Price",
                                    "Phone"
                                    };
    private DefaultTableModel model = new DefaultTableModel(columnNames, 0);
    private JTable table = new JTable(model);
    private JTableHeader tableHeader = table.getTableHeader();
    private JComboBox<String> cityName;
    private JTextField tfName;
    private JTextField tfPhone;
    private JTextField tfX;
    private JTextField tfY;
    private JTextField tfPrice;
    private JLabel lName = new JLabel("Hotel name :");
    private JLabel lPhone = new JLabel("Phone :");
    private JLabel lX = new JLabel("Longitude :");
    private JLabel lY = new JLabel("Latitude :");
    private JLabel lPrice = new JLabel("Price :");
    private JButton save = new JButton("Update");

    @Override
    public JPanel panel(){
        pHotTable.setBounds(70, 0, 1180, 850);
        pHotTable.setLayout(null);

        table.setRowHeight(30);
        table.setFont(new Font(null, Font.PLAIN, 13));
        tableHeader.setPreferredSize(new Dimension(100, 30));
        tableHeader.setFont(new Font(null, Font.BOLD, 13));

	    table.getColumnModel().getColumn(0).setPreferredWidth(40);
	    table.getColumnModel().getColumn(1).setPreferredWidth(170);
	    table.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table.getColumnModel().getColumn(3).setPreferredWidth(70);	    
	    table.getColumnModel().getColumn(4).setPreferredWidth(70);
	    table.getColumnModel().getColumn(5).setPreferredWidth(50);
	    table.getColumnModel().getColumn(6).setPreferredWidth(50);
	    table.getColumnModel().getColumn(7).setPreferredWidth(50);
	    table.getColumnModel().getColumn(8).setPreferredWidth(50);
	    table.getColumnModel().getColumn(9).setPreferredWidth(50);
	    table.getColumnModel().getColumn(10).setPreferredWidth(70);
	    table.getColumnModel().getColumn(11).setPreferredWidth(100);

        JScrollPane spTable = new JScrollPane(table,
                                              JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                                              JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        spTable.setBounds(100, 200, 980, 300);

        for(LinkedList<Hotels> ll: hotelsList.values()){
            for(Hotels h: ll){
                int[] r = h.ratings;
                Object[] o = {i, h.hotName, h.cityName, h.x, h.y, r[0], r[1], r[2], r[3], r[4], h.price, h.phone};
                i++;
                model.addRow(o);
            }
        }

        option.add(remove);
        option.add(update);
        option.add(new JMenuItem("Close"));
        table.addMouseListener(new MouseListener() {

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

        vector.add(0, "All Hotels");
        cityName = new JComboBox<>(vector);
        cityName.setBounds(100, 150, 200, 40);
        cityName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTable();
            }
        });

        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove((String)(table.getValueAt(table.getSelectedRow(), 1)), 
                       (String)(table.getValueAt(table.getSelectedRow(), 2)));
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSetUp((String)(table.getValueAt(table.getSelectedRow(), 1)), 
                           (String)(table.getValueAt(table.getSelectedRow(), 2)), 
                           (int)(table.getValueAt(table.getSelectedRow(), 3)), 
                           (int)(table.getValueAt(table.getSelectedRow(), 4)), 
                           (double)(table.getValueAt(table.getSelectedRow(), 10)), 
                           (String)(table.getValueAt(table.getSelectedRow(), 11)));
            }
        });

        pHotTable.add(cityName);
        pHotTable.add(spTable);
        return pHotTable;
    }

    private void updateSetUp(String name, String city, int x, int y, double price, String phone){
        tfName = new JTextField();
        tfPhone = new JTextField();
        tfPrice = new JTextField();
        tfX = new JTextField();
        tfY = new JTextField();

        save.setBounds(980, 650, 100, 40);
        lName.setBounds(100, 550, 150, 40);
        lPhone.setBounds(100, 600, 150, 40);
        lPrice.setBounds(100, 650, 150, 40);
        lX.setBounds(640, 550, 150, 40);
        lY.setBounds(640, 600, 150, 40);

        tfName.setText(name);
        tfPhone.setText(phone);
        tfPrice.setText(price + "");
        tfX.setText(x + "");
        tfY.setText(y + "");

        lName.setFont(new Font(null, Font.PLAIN, 14));
        lPhone.setFont(new Font(null, Font.PLAIN, 14));
        lPrice.setFont(new Font(null, Font.PLAIN, 14));
        lX.setFont(new Font(null, Font.PLAIN, 14));
        lY.setFont(new Font(null, Font.PLAIN, 14));

        tfName.setBounds(250, 550, 290, 40);
        tfPhone.setBounds(250, 600, 290, 40);
        tfPrice.setBounds(250, 650, 290, 40);
        tfX.setBounds(790, 550, 290, 40);
        tfY.setBounds(790, 600, 290, 40);

        save.addActionListener(new ActionListener() {
            private int i = 0;

            @Override
            public void actionPerformed(ActionEvent e) {

                int ans = 1;
                if(i == 0){
                    ans = JOptionPane.showConfirmDialog(pHotTable, "Are you sure you want to update this hotel info?", "Update request confirmation", JOptionPane.YES_NO_OPTION);
                    i++;
                }

                if(ans == 0){
                    update((String)(table.getValueAt(table.getSelectedRow(), 1)), 
                           (String)(table.getValueAt(table.getSelectedRow(), 2)), 
                           (int)(table.getValueAt(table.getSelectedRow(), 3)), 
                           (int)(table.getValueAt(table.getSelectedRow(), 4)), 
                           (double)(table.getValueAt(table.getSelectedRow(), 10)), 
                           (String)(table.getValueAt(table.getSelectedRow(), 11)));
                    setTable();
                    resetFile();
                }
                pHotTable.remove(lName);
                pHotTable.remove(lPhone);
                pHotTable.remove(lPrice);
                pHotTable.remove(lX);
                pHotTable.remove(lY);
                pHotTable.remove(save);
                pHotTable.remove(tfName);
                pHotTable.remove(tfPhone);
                pHotTable.remove(tfPrice); 
                pHotTable.remove(tfX);
                pHotTable.remove(tfY);
                
            }
        });

        pHotTable.add(lName);
        pHotTable.add(lPhone);
        pHotTable.add(lPrice);
        pHotTable.add(lX);
        pHotTable.add(lY);
        pHotTable.add(save);
        pHotTable.add(tfName);
        pHotTable.add(tfPhone);
        pHotTable.add(tfPrice); 
        pHotTable.add(tfX);
        pHotTable.add(tfY);
        SwingUtilities.updateComponentTreeUI(pHotTable);
    }

    private void remove(String hotelName, String cityName){
        LinkedList<Hotels> ll = hotelsList.get(cityName);
        int ans = JOptionPane.showConfirmDialog(pHotTable, "Are you sure you want to remove this hotel from site?", "Remove request confirmation", JOptionPane.YES_NO_OPTION);
        if(ans == 0){
            for(Hotels h: ll){
                if(h.hotName.equals(hotelName)){
                    ll.remove(h);
                    break;
                }
            }
            setTable();
            resetFile();
        }
    }

    private void update(String name, String city, int x, int y, double price, String phone){
        LinkedList<Hotels> ll = hotelsList.get(city);
        for(Hotels h: ll){
            if(h.hotName.equals(name)){
                ll.remove(h);
                h.hotName = tfName.getText();
                h.x = Integer.parseInt(tfX.getText());
                h.y = Integer.parseInt(tfY.getText());
                h.price = Double.parseDouble(tfPrice.getText());
                h.phone = tfPhone.getText();
                ll.add(h);
                break;
            }
        }
        SwingUtilities.updateComponentTreeUI(pHotTable);
        setTable();
    }

    private void setTable(){
        model.setRowCount(0);
        i = 1;
        if(cityName.getSelectedItem().equals("All Hotels")){
            for(LinkedList<Hotels> ll: hotelsList.values()){
                for(Hotels h: ll){
                    int[] r = h.ratings;
                    Object[] o = {i, h.hotName, h.cityName, h.x, h.y, r[0], r[1], r[2], r[3], r[4], h.price, h.phone};
                    i++;
                    model.addRow(o);
                }
            }
        }else{
            LinkedList<Hotels> ll = hotelsList.get(cityName.getSelectedItem() + "");
            for(Hotels h: ll){
                int[] r = h.ratings;
                Object[] o = {i, h.hotName, h.cityName, h.x, h.y, r[0], r[1], r[2], r[3], r[4], h.price, h.phone};
                i++;
                model.addRow(o);
            }
        }
    }

    private void resetFile(){
        File file = new File("Files/hotels.txt");
        file.delete();
        for(LinkedList<Hotels> ll: hotelsList.values()){
            for(Hotels h: ll){
                try{
                    FileWriter fw = new FileWriter(file, true);
                    fw.write("\n" + 
                            h.cityName.replace(" ", "_") + "\t" +
                            h.hotName.replace(" ", "_") + "\t" + 
                            h.x + "\t" + 
                            h.y + "\t" + 
                            h.ratings[0] + "\t" + 
                            h.ratings[1] + "\t" + 
                            h.ratings[2] + "\t" + 
                            h.ratings[3] + "\t" + 
                            h.ratings[4] + "\t" + 
                            h.price + "\t" +
                            h.phone
                            );
                    fw.close();
                }catch(Exception ex){
                    JOptionPane.showMessageDialog(pHotTable, "Something Went Wrong Adding Hotel Information", "ADDING ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private static Color randomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b, 100);
    }
}
