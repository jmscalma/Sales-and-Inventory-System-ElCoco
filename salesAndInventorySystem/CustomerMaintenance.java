/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesAndInventorySystem;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author james
 */
public class CustomerMaintenance extends javax.swing.JFrame {

    /**
     * Creates new form CustomerMaintenance
     */
    public CustomerMaintenance() {
        initComponents();
        setRecordsToTable();
        showIcon();
    }
    
    private void showIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("wine__.png")));
    }
    
    public void setRecordsToTable(){
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/el_coco_db","root","root");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM customer_maintenance");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                int customer_id = rs.getInt("customer_id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String address = rs.getString("address");
                String contactNumber = rs.getString("contactnumber");
                
                Object[] obj = {customer_id, firstname, lastname, address, contactNumber };
                
                DefaultTableModel model = (DefaultTableModel)customerMaintenanceTable.getModel();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        customerIdTf = new javax.swing.JTextField();
        addressTf = new javax.swing.JTextField();
        contactNumberTf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        addNewProductBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        searchTf = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerMaintenanceTable = new javax.swing.JTable();
        firstNameTf = new javax.swing.JTextField();
        lastNameTf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 224, 145));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Customer Maintenance");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 480, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        customerIdTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        customerIdTf.setToolTipText("");
        customerIdTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        customerIdTf.setEnabled(false);
        customerIdTf.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jPanel2.add(customerIdTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 250, 40));

        addressTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        addressTf.setToolTipText("");
        addressTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        addressTf.setEnabled(false);
        jPanel2.add(addressTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 250, 40));

        contactNumberTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        contactNumberTf.setToolTipText("");
        contactNumberTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        contactNumberTf.setEnabled(false);
        jPanel2.add(contactNumberTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 250, 40));

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        jLabel8.setText("Search customer name");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, -1, 30));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel9.setText("First Name");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 40));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel10.setText("Address");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 40));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel11.setText("Contact Number");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 40));

        updateBtn.setBackground(new java.awt.Color(44, 119, 33));
        updateBtn.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/updated.png"))); // NOI18N
        updateBtn.setText("UPDATE");
        updateBtn.setEnabled(false);
        updateBtn.setFocusable(false);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel2.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 140, 50));

        addNewProductBtn.setBackground(new java.awt.Color(44, 119, 33));
        addNewProductBtn.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        addNewProductBtn.setForeground(new java.awt.Color(255, 255, 255));
        addNewProductBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add.png"))); // NOI18N
        addNewProductBtn.setText("ADD NEW CUSTOMER");
        addNewProductBtn.setFocusable(false);
        addNewProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewProductBtnActionPerformed(evt);
            }
        });
        jPanel2.add(addNewProductBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 60, 250, 50));

        refreshBtn.setBackground(new java.awt.Color(44, 119, 33));
        refreshBtn.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        refreshBtn.setForeground(new java.awt.Color(255, 255, 255));
        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/refresh (1).png"))); // NOI18N
        refreshBtn.setText("Refresh");
        refreshBtn.setFocusable(false);
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        jPanel2.add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1260, 30, 120, 40));

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel13.setText("Customer ID");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 40));

        searchTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        searchTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTfKeyReleased(evt);
            }
        });
        jPanel2.add(searchTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 180, 30));

        editBtn.setBackground(new java.awt.Color(44, 119, 33));
        editBtn.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        editBtn.setText("EDIT");
        editBtn.setFocusable(false);
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });
        jPanel2.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 110, 50));

        customerMaintenanceTable.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        customerMaintenanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "First Name", "Last Name", "Address", "Contact Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        customerMaintenanceTable.getTableHeader().setReorderingAllowed(false);
        customerMaintenanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMaintenanceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(customerMaintenanceTable);
        if (customerMaintenanceTable.getColumnModel().getColumnCount() > 0) {
            customerMaintenanceTable.getColumnModel().getColumn(0).setResizable(false);
            customerMaintenanceTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            customerMaintenanceTable.getColumnModel().getColumn(1).setResizable(false);
            customerMaintenanceTable.getColumnModel().getColumn(2).setResizable(false);
            customerMaintenanceTable.getColumnModel().getColumn(3).setResizable(false);
            customerMaintenanceTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 920, 350));

        firstNameTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        firstNameTf.setToolTipText("");
        firstNameTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        firstNameTf.setEnabled(false);
        jPanel2.add(firstNameTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 250, 40));

        lastNameTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        lastNameTf.setToolTipText("");
        lastNameTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        lastNameTf.setEnabled(false);
        jPanel2.add(lastNameTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 250, 40));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel12.setText("Last Name");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1400, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String firstname = firstNameTf.getText();
        String lastname = lastNameTf.getText();
        String address = addressTf.getText();
        String contactNumber = contactNumberTf.getText();
        String name = firstname + " " + lastname;

        if(addressTf.getText().equals("") || contactNumberTf.getText().equals("") ){
            JOptionPane.showMessageDialog(this, "Please enter all data needed!");

        }else if(!contactNumber.matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "Incorrect Contact Number Input!", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(!firstname.matches("^[ A-Za-z]+$") || !lastname.matches("^[ A-Za-z]+$")){
            JOptionPane.showMessageDialog(this, "Incorrect Name Input!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{

            try{
                Statement s = DBConnector.mycon().createStatement();
                int row = customerMaintenanceTable.getSelectedRow();
                String id = (customerMaintenanceTable.getModel().getValueAt(row, 0).toString());
                String query = "UPDATE customer_maintenance SET firstname='"+firstname+"', lastname='"+lastname+"', customername='"+name+"', address='"+address+"', contactNumber='"+contactNumber+"' where customer_id=" + id;

                s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Updated Successfully!");

                customerMaintenanceTable.setModel(new DefaultTableModel(null, new String[]{"Custoemr ID", "First Name", "Last Name", "Address", "Contact Number"}));
                setRecordsToTable();
                
                lastNameTf.setEnabled(false);
                addressTf.setEnabled(false);
                contactNumberTf.setEnabled(false);
                firstNameTf.setEnabled(false);

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void addNewProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewProductBtnActionPerformed
        AddCustomer a = new AddCustomer();
        a.setVisible(true);
    }//GEN-LAST:event_addNewProductBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
       customerMaintenanceTable.setModel(new DefaultTableModel(null, new String[]{"Customer ID", "First Name", "Last Name", "Address", "Contact Number"}));
        setRecordsToTable();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void searchTfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTfKeyReleased
        String name = searchTf.getText();
        String searchQuery = "SELECT * FROM customer_maintenance WHERE firstname ='"+name+"' OR lastname = '"+name+"' ";
        try {
            PreparedStatement pst = DBConnector.mycon().prepareStatement(searchQuery);
            ResultSet rs = pst.executeQuery();
            customerMaintenanceTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_searchTfKeyReleased

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        updateBtn.setEnabled(true);
        firstNameTf.setEnabled(true);
        lastNameTf.setEnabled(true);
        addressTf.setEnabled(true);
        contactNumberTf.setEnabled(true);
        
    }//GEN-LAST:event_editBtnActionPerformed

    private void customerMaintenanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMaintenanceTableMouseClicked
        updateBtn.setEnabled(false);
        customerIdTf.setEnabled(false);
        firstNameTf.setEnabled(false);
        lastNameTf.setEnabled(false);
        addressTf.setEnabled(false);
        contactNumberTf.setEnabled(false);

        int i = customerMaintenanceTable.getSelectedRow();
        TableModel model = customerMaintenanceTable.getModel();
        customerIdTf.setText(model.getValueAt(i, 0).toString());
        firstNameTf.setText(model.getValueAt(i, 1).toString());
        lastNameTf.setText(model.getValueAt(i, 2).toString());
        addressTf.setText(model.getValueAt(i, 3).toString());
        contactNumberTf.setText(model.getValueAt(i, 4).toString());

    }//GEN-LAST:event_customerMaintenanceTableMouseClicked

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
            java.util.logging.Logger.getLogger(CustomerMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerMaintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerMaintenance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewProductBtn;
    private javax.swing.JTextField addressTf;
    private javax.swing.JTextField contactNumberTf;
    private javax.swing.JTextField customerIdTf;
    public javax.swing.JTable customerMaintenanceTable;
    private javax.swing.JButton editBtn;
    private javax.swing.JTextField firstNameTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameTf;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JTextField searchTf;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
