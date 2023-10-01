/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesAndInventorySystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author james
 */
public class SupplierProducts extends javax.swing.JFrame {

    /**
     * Creates new form SupplierProducts
     */
    public static String suppname;
    
    public SupplierProducts() {
        initComponents();
        suppSelect();
        setRecordsToTable();
    }
    
    public void setRecordsToTable(){
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/el_coco_db","root","root");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM supplier_products");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                int supplier_cart_id = rs.getInt("supplier_product_id");
                String suppliername = rs.getString("suppliername");
                String product = rs.getString("product");
                double price = rs.getDouble("price");
                
                Object[] obj = {supplier_cart_id, suppliername, product, price };
                
                DefaultTableModel model = (DefaultTableModel)supplierProductsTable.getModel();
                model.addRow(obj);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void showData(){
        String suppname = customerSelect.getSelectedItem().toString();
        
        ArrayList ar = new ArrayList();
        
        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM supplier_products WHERE suppliername ='"+suppname+"' ");
            while(rs.next()){
                
                ar.add(rs.getString("supplier_product_id"));
                
            }
            
            System.out.println(ar);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        String newline = "";
        String line = "SELECT product, price FROM supplier_products WHERE supplier_product_id = " + ar.get(0);
        for(int i = 1; i < ar.size();  i++){
            newline = newline + " OR supplier_product_id = " + ar.get(i) + " ";
        }
        
        try
        {
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT supplier_product_id, product, price FROM supplier_products WHERE supplier_product_id = " + ar.get(0) + newline);
            
            while(rs.next()){
                
                String supplierproductid = rs.getString("supplier_product_id");
                String product = rs.getString("product");
                Double price = rs.getDouble("price");
                
                Object[] obj = {supplierproductid, product, price };
                
                DefaultTableModel model = (DefaultTableModel)supplierProductsTable.getModel();
                model.addRow(obj);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    } 
    
    public void suppSelect
        (){
        
        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM supplier_maintenance");
            Vector v = new Vector();
            
            while(rs.next()){ 
                v.add(rs.getString("suppliername"));
                
                DefaultComboBoxModel com = new DefaultComboBoxModel(v);
                customerSelect.setModel(com);
                suppSelect.setModel(com);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
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

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        productIdTf = new javax.swing.JTextField();
        productTf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        customerSelect = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        supplierProductsTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        newProductTf = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        suppSelect = new javax.swing.JComboBox<>();
        priceTf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        editBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        newProductPriceTf = new javax.swing.JTextField();
        refreshBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(0, 224, 145));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("SUPPLIER PRODUCTS");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 340, 60));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel11.setText("Product ID");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 40));

        productIdTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        productIdTf.setToolTipText("");
        productIdTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        productIdTf.setEnabled(false);
        productIdTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productIdTfActionPerformed(evt);
            }
        });
        jPanel2.add(productIdTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 230, 40));

        productTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        productTf.setToolTipText("");
        productTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        productTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productTfKeyReleased(evt);
            }
        });
        jPanel2.add(productTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 230, 40));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel12.setText("Product");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 40));

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
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 530, 230, 50));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel9.setText("Supplier Name");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 40));

        customerSelect.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        customerSelect.setFocusable(false);
        customerSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSelectActionPerformed(evt);
            }
        });
        jPanel2.add(customerSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 230, 40));

        supplierProductsTable.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        supplierProductsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Supplier Product ID", "Supplier Name", "Product ", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        supplierProductsTable.getTableHeader().setReorderingAllowed(false);
        supplierProductsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierProductsTableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                supplierProductsTableMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(supplierProductsTable);
        if (supplierProductsTable.getColumnModel().getColumnCount() > 0) {
            supplierProductsTable.getColumnModel().getColumn(0).setResizable(false);
            supplierProductsTable.getColumnModel().getColumn(1).setResizable(false);
            supplierProductsTable.getColumnModel().getColumn(2).setResizable(false);
            supplierProductsTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 550, 260));

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel14.setText("New Product");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, -1, 40));

        newProductTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        newProductTf.setToolTipText("");
        newProductTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        newProductTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProductTfActionPerformed(evt);
            }
        });
        newProductTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newProductTfKeyReleased(evt);
            }
        });
        jPanel2.add(newProductTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 230, 40));

        jPanel4.setBackground(new java.awt.Color(0, 224, 145));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Book", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("ADD NEW PRODUCT");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 420, 50));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 540, 50));

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel15.setText("Supplier Name");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, -1, 40));

        suppSelect.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        suppSelect.setFocusable(false);
        suppSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppSelectActionPerformed(evt);
            }
        });
        jPanel2.add(suppSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 230, 40));

        priceTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        priceTf.setToolTipText("");
        priceTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        priceTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priceTfKeyReleased(evt);
            }
        });
        jPanel2.add(priceTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 230, 40));

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel13.setText("Price");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 40));

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
        jPanel2.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 110, 50));

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
        jPanel2.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 140, 50));

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel16.setText("Price");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 470, -1, 40));

        newProductPriceTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        newProductPriceTf.setToolTipText("");
        newProductPriceTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        newProductPriceTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProductPriceTfActionPerformed(evt);
            }
        });
        newProductPriceTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newProductPriceTfKeyReleased(evt);
            }
        });
        jPanel2.add(newProductPriceTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 230, 40));

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
        jPanel2.add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 120, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1080, 610));

        jPanel1.setBackground(new java.awt.Color(0, 224, 145));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("SUPPLIER PRODUCTS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 340, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void productTfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productTfKeyReleased
        

    }//GEN-LAST:event_productTfKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        

        //if there is a field left blank
        if(newProductTf.getText().equals("") ){
            JOptionPane.showMessageDialog(this, "Please enter the data needed!");
        }else if(!newProductPriceTf.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "Incorrect Name Input!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{

            String suppName = suppSelect.getSelectedItem().toString();
            String newProduct = newProductTf.getText();
            String newProdPrice = newProductPriceTf.getText();

            //saving
            try{

                Statement s = DBConnector.mycon().createStatement();
                s.executeUpdate("INSERT INTO supplier_products (suppliername, product, price) "
                    + "VALUES ('"+suppName+"','"+newProduct+"','"+newProdPrice+"')");
                
                JOptionPane.showMessageDialog(this, "Added Successfully!");
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            
            newProductTf.setText("");
            newProductPriceTf.setText("");

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void customerSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSelectActionPerformed

        String name = customerSelect.getSelectedItem().toString();

        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT suppliername FROM supplier_products WHERE suppliername ='"+name+"' ");
            if(rs.next()){

                suppname = (rs.getString("suppliername"));

            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }

        supplierProductsTable.setModel(new DefaultTableModel(null, new String[]{"Supplier Product ID","Product", "Price"}));
        showData();
    }//GEN-LAST:event_customerSelectActionPerformed

    private void supplierProductsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierProductsTableMouseClicked
        updateBtn.setEnabled(false);
        
        int i = supplierProductsTable.getSelectedRow();
        int modelRow = supplierProductsTable.convertRowIndexToModel(i);
        TableModel model = supplierProductsTable.getModel();
        productIdTf.setText(model.getValueAt(i, 0).toString());
        productTf.setText(model.getValueAt(i, 1).toString());
        priceTf.setText(model.getValueAt(i, 2).toString());
        //int id = Integer.parseInt((String)(this.productMaintenanceTable.getModel()).getValueAt(modelRow, 0));
        //productIdTf.setText(String.valueOf(id));
        //String a = String.valueOf(id);
        //stocksTf.setText(a);
    }//GEN-LAST:event_supplierProductsTableMouseClicked

    private void supplierProductsTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierProductsTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierProductsTableMouseEntered

    private void newProductTfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newProductTfKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_newProductTfKeyReleased

    private void suppSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suppSelectActionPerformed

    private void productIdTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productIdTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productIdTfActionPerformed

    private void priceTfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceTfKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_priceTfKeyReleased

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
       
        productTf.setEnabled(true);
        priceTf.setEnabled(true);
        updateBtn.setEnabled(true);
    }//GEN-LAST:event_editBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        String product = productTf.getText();
        String price = priceTf.getText();

        if(productTf.getText().equals("") || priceTf.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter all data needed!");
        }else if(!priceTf.getText().matches("[0-9]+")){
            JOptionPane.showMessageDialog(this, "Incorrect Price Input!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{

            try{
                Statement s = DBConnector.mycon().createStatement();
                int row = supplierProductsTable.getSelectedRow();
                String id = (supplierProductsTable.getModel().getValueAt(row, 0).toString());
                String query = "UPDATE supplier_products SET product='"+product+"', price='"+price+"' where supplier_product_id =" + id;

                s.executeUpdate(query);

                DefaultTableModel model = (DefaultTableModel)supplierProductsTable.getModel();
                model.setRowCount(0);

                JOptionPane.showMessageDialog(null, "Updated Successfully!");
                supplierProductsTable.setModel(new DefaultTableModel(null, new String[]{"Supplier Product ID","Product", "Price"}));
                setRecordsToTable();

                productTf.setEnabled(false);
                priceTf.setEnabled(false);

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void newProductTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProductTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newProductTfActionPerformed

    private void newProductPriceTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProductPriceTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newProductPriceTfActionPerformed

    private void newProductPriceTfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newProductPriceTfKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_newProductPriceTfKeyReleased

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        supplierProductsTable.setModel(new DefaultTableModel(null, new String[]{"Supplier Product ID","Supplier Name", "Product", "Price"}));
        setRecordsToTable();
        productIdTf.setText("");
        priceTf.setText("");
        productTf.setText("");
    }//GEN-LAST:event_refreshBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SupplierProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SupplierProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SupplierProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SupplierProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SupplierProducts().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> customerSelect;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField newProductPriceTf;
    private javax.swing.JTextField newProductTf;
    private javax.swing.JTextField priceTf;
    public javax.swing.JTextField productIdTf;
    private javax.swing.JTextField productTf;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JComboBox<String> suppSelect;
    public javax.swing.JTable supplierProductsTable;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
