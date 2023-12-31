/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesAndInventorySystem;

import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author james
 */
public class AddNewCustomer extends javax.swing.JFrame {

    /**
     * Creates new form AddNewCustomer
     */
    public AddNewCustomer() {
        initComponents();
        showIcon();
    }
    
    private void showIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("wine__.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameTf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lastNameTf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        addressTf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        contactNumberTf = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        firstname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();

        firstNameTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        firstNameTf.setToolTipText("");
        firstNameTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel9.setText("First Name");

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel12.setText("Last Name");

        lastNameTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        lastNameTf.setToolTipText("");
        lastNameTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 224, 145));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ADD CUSTOMER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 250, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addressTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        addressTf.setToolTipText("");
        addressTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(addressTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 230, 40));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel10.setText("Address");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 40));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel11.setText("Contact Number");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 40));

        contactNumberTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        contactNumberTf.setToolTipText("");
        contactNumberTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(contactNumberTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, 230, 40));

        backBtn.setBackground(new java.awt.Color(44, 119, 33));
        backBtn.setFont(new java.awt.Font("Franklin Gothic Book", 0, 24)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        backBtn.setText("BACK");
        backBtn.setFocusable(false);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel2.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 230, 50));

        saveBtn.setBackground(new java.awt.Color(44, 119, 33));
        saveBtn.setFont(new java.awt.Font("Franklin Gothic Book", 0, 24)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        saveBtn.setText("SAVE");
        saveBtn.setFocusable(false);
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel2.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 230, 50));

        firstname.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        firstname.setToolTipText("");
        firstname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 230, 40));

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel13.setText("First Name");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 40));

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel14.setText("Last Name");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, 40));

        lastname.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        lastname.setToolTipText("");
        lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 230, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 489, 380));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        Login l = new Login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        
        //if there is a field left blank
        if(firstname.getText().equals("") || lastname.getText().equals("") || addressTf.getText().equals("") || contactNumberTf.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter all data needed!");
        }else if(!firstname.getText().matches("^[ A-Za-z]+$") || !lastname.getText().matches("^[ A-Za-z]+$") || !contactNumberTf.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            
            String firstnamee = firstname.getText();
            String lastnamee = lastname.getText();
            String name = firstnamee + " " + lastnamee;
            String address = addressTf.getText();
            String contactNumber = contactNumberTf.getText();
            
            try{
                   Statement s = DBConnector.mycon().createStatement();
                   String query = "SELECT * FROM customer_maintenance WHERE customername='"+name+"' ";
                   
                   ResultSet rs1 = s.executeQuery(query);
                   if(!rs1.next()){
            
            try{

                Statement s1 = DBConnector.mycon().createStatement();
                s1.executeUpdate("INSERT INTO customer_maintenance (`firstname`, `lastname`, `customername`, `address`, `contactnumber`) "
                    + "VALUES ('"+firstnamee+"','"+lastnamee+"','"+name+"','"+address+"','"+contactNumber+"')");

                JOptionPane.showMessageDialog(rootPane, "Added Successfully!");
                
                AddCustomerAccount a = new AddCustomerAccount(name, firstnamee, lastnamee);
                firstname.setText("");
                lastname.setText("");
                addressTf.setText("");
                contactNumberTf.setText("");
                a.setVisible(true);
                this.dispose();

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }

        }else{
                JOptionPane.showMessageDialog(this, "Customer Name already exists!");       
                   }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_saveBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTf;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField contactNumberTf;
    private javax.swing.JTextField firstNameTf;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField lastNameTf;
    private javax.swing.JTextField lastname;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
