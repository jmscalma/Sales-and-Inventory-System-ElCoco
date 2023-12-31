/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ee
 */
package salesAndInventorySystem;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class InventoryReport extends javax.swing.JFrame {

    /**
     * Creates new form InventoryReport
     */
    public InventoryReport() {
        initComponents();
        setRecordsToTable();
        showIcon();
        flavorSelect_();
    }
    
    private void showIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("wine__.png")));
    }
    
    public void flavorSelect_(){
        
        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM product_flavor");
            Vector v = new Vector();
            
            while(rs.next()){
                v.add(rs.getString("flavor"));
                
                DefaultComboBoxModel com = new DefaultComboBoxModel(v);
                searchFlavorCombobox.setModel(com);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    public void setRecordsToTable(){
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/el_coco_db","root","root");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM product_maintenance");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                int product_id = rs.getInt("product_id");
                String flavor = rs.getString("flavor");
                String size = rs.getString("size");
                double price = rs.getDouble("price");
                int stocks = rs.getInt("stocks");
                String status = rs.getString("Status");
                
                Object[] obj = {product_id, flavor, size, price, stocks, status };
                
                DefaultTableModel model = (DefaultTableModel)productMaintenanceTable.getModel();
                model.addRow(obj);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        editBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productMaintenanceTable = new javax.swing.JTable();
        searchFlavorCombobox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        statusSearch = new javax.swing.JComboBox<>();
        refreshBtn1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editBtn.setBackground(new java.awt.Color(44, 119, 33));
        editBtn.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/print.png"))); // NOI18N
        editBtn.setText("PRINT");
        editBtn.setFocusable(false);
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        jPanel2.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 450, 130, 40));

        productMaintenanceTable.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        productMaintenanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Flavor", "Size", "Price", "Stocks", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productMaintenanceTable.getTableHeader().setReorderingAllowed(false);
        productMaintenanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productMaintenanceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productMaintenanceTable);
        if (productMaintenanceTable.getColumnModel().getColumnCount() > 0) {
            productMaintenanceTable.getColumnModel().getColumn(0).setResizable(false);
            productMaintenanceTable.getColumnModel().getColumn(1).setResizable(false);
            productMaintenanceTable.getColumnModel().getColumn(2).setResizable(false);
            productMaintenanceTable.getColumnModel().getColumn(3).setResizable(false);
            productMaintenanceTable.getColumnModel().getColumn(4).setResizable(false);
            productMaintenanceTable.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 920, 360));

        searchFlavorCombobox.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        searchFlavorCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500 mL", "1 Liter", "4 Liters", "6 Liters", "32 Liters", "36 Liters" }));
        searchFlavorCombobox.setFocusable(false);
        searchFlavorCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFlavorComboboxActionPerformed(evt);
            }
        });
        jPanel2.add(searchFlavorCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 150, 40));

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        jLabel8.setText("Select flavor:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 40));

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        jLabel15.setText("Select Status :");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, 120, 40));

        statusSearch.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        statusSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Obsolete" }));
        statusSearch.setFocusable(false);
        statusSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusSearchActionPerformed(evt);
            }
        });
        jPanel2.add(statusSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 150, 40));

        refreshBtn1.setBackground(new java.awt.Color(44, 119, 33));
        refreshBtn1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        refreshBtn1.setForeground(new java.awt.Color(255, 255, 255));
        refreshBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh (1).png"))); // NOI18N
        refreshBtn1.setText("Refresh");
        refreshBtn1.setFocusable(false);
        refreshBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(refreshBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 30, 110, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 980, 510));

        jPanel1.setBackground(new java.awt.Color(0, 224, 145));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Inventory Report");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 350, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        try{
            ReportView r = new ReportView("C:\\Users\\james\\Documents\\2y1 Activities\\OOP Projects\\ElCoco\\src\\reports\\InventoryReport.jasper");
            r.setVisible(true);
            r.setLocationRelativeTo(null);
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_editBtnActionPerformed

    private void productMaintenanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMaintenanceTableMouseClicked
        
    }//GEN-LAST:event_productMaintenanceTableMouseClicked

    private void searchFlavorComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFlavorComboboxActionPerformed
        String flavor = searchFlavorCombobox.getSelectedItem().toString();
        String searchQuery = "SELECT * FROM product_maintenance WHERE flavor ='"+flavor+"'";
        try {
            PreparedStatement pst = DBConnector.mycon().prepareStatement(searchQuery);
            ResultSet rs = pst.executeQuery();
            productMaintenanceTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_searchFlavorComboboxActionPerformed

    private void statusSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusSearchActionPerformed
        String status = statusSearch.getSelectedItem().toString();
        String searchQuery = "SELECT * FROM product_maintenance WHERE status ='"+status+"'";
        try {
            PreparedStatement pst = DBConnector.mycon().prepareStatement(searchQuery);
            ResultSet rs = pst.executeQuery();
            productMaintenanceTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_statusSearchActionPerformed

    private void refreshBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtn1ActionPerformed
        productMaintenanceTable.setModel(new DefaultTableModel(null, new String[]{"Product ID", "Flavor", "Size",  "Price", "Stocks", "Status"}));
        setRecordsToTable();
    }//GEN-LAST:event_refreshBtn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable productMaintenanceTable;
    private javax.swing.JButton refreshBtn1;
    public javax.swing.JComboBox<String> searchFlavorCombobox;
    public javax.swing.JComboBox<String> statusSearch;
    // End of variables declaration//GEN-END:variables
}
