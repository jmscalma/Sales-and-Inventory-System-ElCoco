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
public class AddNewSupplier extends javax.swing.JFrame {

    /**
     * Creates new form AddNewSupplier
     */
    public AddNewSupplier() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        supplierNameTf = new javax.swing.JTextField();
        contactPersonTf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        addressTf = new javax.swing.JTextField();
        contactNumberTf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        emailTf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 224, 145));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ADD SUPPLIER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 240, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 60));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel9.setText("Supplier Name");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 40));

        supplierNameTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        supplierNameTf.setToolTipText("");
        supplierNameTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(supplierNameTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 230, 40));

        contactPersonTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        contactPersonTf.setToolTipText("");
        contactPersonTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(contactPersonTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 230, 40));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel10.setText("Contact Person");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 40));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel11.setText("Address");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 40));

        addressTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        addressTf.setToolTipText("");
        addressTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(addressTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 230, 40));

        contactNumberTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        contactNumberTf.setToolTipText("");
        contactNumberTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(contactNumberTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, 230, 40));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel12.setText("E-mail");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 40));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel3.setText("Contact Number");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 40));

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
        jPanel2.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 230, 50));

        emailTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        emailTf.setToolTipText("");
        emailTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(emailTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 230, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 489, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
            String supplierName = supplierNameTf.getText();
            String contactPerson = contactPersonTf.getText();
            String address = addressTf.getText();
            String email = emailTf.getText();
            String contactNumber = contactNumberTf.getText();
            String status = "Active";
        //if there is a field left blank
        if(supplierNameTf.getText().equals("") || contactPersonTf.getText().equals("") || addressTf.getText().equals("") || emailTf.getText().equals("") || contactNumberTf.getText().equals("") ){
            JOptionPane.showMessageDialog(this, "Please enter all data needed!");
        }else if(!contactNumber.matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "Incorrect Contact Number Input!", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(!contactPerson.matches("^[ A-Za-z]+$")){
            JOptionPane.showMessageDialog(this, "Incorrect Name Input!", "Error", JOptionPane.ERROR_MESSAGE);
            
        }else{
            try{
                   Statement s = DBConnector.mycon().createStatement();
                   String query = "SELECT * FROM supplier_maintenance WHERE suppliername='"+supplierName+"' ";
                   
                   ResultSet rs1 = s.executeQuery(query);
                   if(!rs1.next()){
            

            try{

                Statement s1 = DBConnector.mycon().createStatement();
                s1.executeUpdate("INSERT INTO supplier_maintenance (`suppliername`, `contactperson`, `address`, `email`, `contactnumber`, `status`) "
                    + "VALUES ('"+supplierName+"','"+contactPerson+"','"+address+"','"+email+"','"+contactNumber+"','"+status+"')");

                JOptionPane.showMessageDialog(rootPane, "Added Successfully!");

                supplierNameTf.setText("");
                contactPersonTf.setText("");
                addressTf.setText("");
                emailTf.setText("");
                contactNumberTf.setText("");


            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }

        }else{
                 JOptionPane.showMessageDialog(this, "Supplier already exists!");         
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
            java.util.logging.Logger.getLogger(AddNewSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField addressTf;
    private javax.swing.JTextField contactNumberTf;
    private javax.swing.JTextField contactPersonTf;
    private javax.swing.JTextField emailTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField supplierNameTf;
    // End of variables declaration//GEN-END:variables
}
