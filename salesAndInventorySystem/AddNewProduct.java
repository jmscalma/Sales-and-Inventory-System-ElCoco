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
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author james
 */
public class AddNewProduct extends javax.swing.JFrame {

    /**
     * Creates new form AddNewProduct
     */
    public AddNewProduct() {
        initComponents();
        showIcon();
        flavorSelect();
        sizeSelect();
    }
    
     public void sizeSelect(){
        
        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM product_size");
            Vector v = new Vector();
            
            while(rs.next()){
                v.add(rs.getString("productsize"));
                
                DefaultComboBoxModel com = new DefaultComboBoxModel(v);
                sizeSelect.setModel(com);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    public void flavorSelect(){
        
        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM product_flavor");
            Vector v = new Vector();
            
            while(rs.next()){
                v.add(rs.getString("flavor"));
                
                DefaultComboBoxModel com = new DefaultComboBoxModel(v);
                flavorSelect.setModel(com);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
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

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        priceTf = new javax.swing.JTextField();
        stocksTf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        sizeSelect = new javax.swing.JComboBox<>();
        flavorSelect = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel9.setText("Flavor");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 40));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel11.setText("Price");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, 40));

        priceTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        priceTf.setToolTipText("");
        priceTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(priceTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 230, 40));

        stocksTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        stocksTf.setToolTipText("");
        stocksTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(stocksTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 230, 40));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel12.setText("Stocks");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, 40));

        jButton5.setBackground(new java.awt.Color(44, 119, 33));
        jButton5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        jButton5.setText("SAVE");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 230, 50));

        sizeSelect.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        sizeSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500 mL", "1 Liter", "4 Liters", "6 Liters", "32 Liters", "36 Liters" }));
        sizeSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeSelectActionPerformed(evt);
            }
        });
        jPanel2.add(sizeSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 230, 40));

        flavorSelect.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        flavorSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "500 mL", "1 Liter", "4 Liters", "6 Liters", "32 Liters", "36 Liters" }));
        flavorSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flavorSelectActionPerformed(evt);
            }
        });
        jPanel2.add(flavorSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 230, 40));

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel13.setText("Size");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 450, 360));

        jPanel1.setBackground(new java.awt.Color(0, 224, 145));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ADD PRODUCT");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 230, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        //if there is a field left blank
        if(priceTf.getText().equals("") || stocksTf.getText().equals("") ){
            JOptionPane.showMessageDialog(this, "Please enter all data needed!");
        }else if(priceTf.getText().matches(".*[a-zA-Z]+.*") || stocksTf.getText().matches(".*[a-zA-Z]+.*")){
            JOptionPane.showMessageDialog(this, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{

            String flavor = flavorSelect.getSelectedItem().toString();
            String size = sizeSelect.getSelectedItem().toString();
            String price = priceTf.getText();
            String stocks = stocksTf.getText();
            String status = "Active";
            
            try{
                   Statement s = DBConnector.mycon().createStatement();
                   String query = "SELECT flavor,size FROM product_maintenance WHERE flavor='"+flavor+"' AND size='"+size+"' ";
                   
                   ResultSet rs1 = s.executeQuery(query);
                   if(!rs1.next()){
            
            try{

                Statement s1 = DBConnector.mycon().createStatement();
                s1.executeUpdate("INSERT INTO product_maintenance (flavor, size, price, stocks, status) "
                    + "VALUES ('"+flavor+"','"+size+"','"+price+"','"+stocks+"','"+status+"')");

                JOptionPane.showMessageDialog(rootPane, "Added Successfully!");
                

                priceTf.setText("");
                stocksTf.setText("");
                flavorSelect.setSelectedIndex(0);
                sizeSelect.setSelectedIndex(0);

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }

        }else{
             JOptionPane.showMessageDialog(this, "Product Flavor and Size combination already exists!");  
            }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void sizeSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeSelectActionPerformed

    private void flavorSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flavorSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flavorSelectActionPerformed

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
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> flavorSelect;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField priceTf;
    private javax.swing.JComboBox<String> sizeSelect;
    private javax.swing.JTextField stocksTf;
    // End of variables declaration//GEN-END:variables
}
