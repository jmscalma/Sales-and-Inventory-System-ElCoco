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
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
import static salesAndInventorySystem.SalesTransaction.customerid;

/**
 *
 * @author james
 */
public class AddNewReturnedProduct extends javax.swing.JFrame {

    /**
     * Creates new form AddNewReturnedProduct
     */
    public static String customerid;
    public static int presentStock;
    public static String invoiceId;
    public static double cprice;
    public static double ctotal;
    public static int presentQuantityBought;
    
    public AddNewReturnedProduct() {
        initComponents();
        customerSelect();
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
            PreparedStatement pst = con.prepareStatement("SELECT * FROM product_maintenance");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                int product_id = rs.getInt("product_id");
                String flavor = rs.getString("flavor");
                String size = rs.getString("size");
                double price = rs.getDouble("price");
                int stocks = rs.getInt("stocks");
                String status = rs.getString("Status");
                
                Object[] obj = {product_id, flavor, size, price };
                
                DefaultTableModel model = (DefaultTableModel)productMaintenanceTable1.getModel();
                model.addRow(obj);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void customerSelect(){
        
        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM customer_maintenance");
            Vector v = new Vector();
            
            while(rs.next()){
                v.add(rs.getString("customername"));
                
                DefaultComboBoxModel com = new DefaultComboBoxModel(v);
                customerSelect.setModel(com);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }
    
    public void showData(){
        String cusname = customerSelect.getSelectedItem().toString();
        
        ArrayList ar = new ArrayList();
        
        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT invoice_id FROM sales_transactions WHERE customername ='"+cusname+"' ");
            while(rs.next()){
                
                ar.add(rs.getString("invoice_id"));
                
            }
            
            System.out.println(ar);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
        String newline = "";
        String line = "SELECT product_id, flavor, size, quantity FROM cart WHERE invoice_id = " + ar.get(0);
        for(int i = 1; i < ar.size();  i++){
            newline = newline + " OR invoice_id = " + ar.get(i) + " ";
        }
        
        
        try
        {
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT cart_id, product_id, flavor, size, price, quantity FROM cart WHERE invoice_id = " + ar.get(0) + newline);
            
            while(rs.next()){
                
                String cart_id = rs.getString("cart_id");
                String product_id = rs.getString("product_id");
                String flavor = rs.getString("flavor");
                String size = rs.getString("size");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                
                Object[] obj = {cart_id, product_id, flavor, size, price, quantity };
                
                DefaultTableModel model = (DefaultTableModel)productMaintenanceTable1.getModel();
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
        jLabel11 = new javax.swing.JLabel();
        productIdTf = new javax.swing.JTextField();
        stocksTf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        customerSelect = new javax.swing.JComboBox<>();
        reasonTf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        productMaintenanceTable1 = new javax.swing.JTable();
        moneyReturnedTf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

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
        jPanel2.add(productIdTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 230, 40));

        stocksTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        stocksTf.setToolTipText("");
        stocksTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        stocksTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                stocksTfKeyReleased(evt);
            }
        });
        jPanel2.add(stocksTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 230, 40));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel12.setText("Stocks Returned");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 40));

        jButton5.setBackground(new java.awt.Color(44, 119, 33));
        jButton5.setFont(new java.awt.Font("Franklin Gothic Book", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        jButton5.setText("SAVE AND PRINT");
        jButton5.setFocusable(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 280, 50));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel9.setText("Customer Name");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 40));

        customerSelect.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        customerSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSelectActionPerformed(evt);
            }
        });
        jPanel2.add(customerSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 230, 40));

        reasonTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        reasonTf.setToolTipText("");
        reasonTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.add(reasonTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 230, 40));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel10.setText("Reason");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, 40));

        productMaintenanceTable1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        productMaintenanceTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cart ID", "Product ID", "Flavor", "Size", "Price", "Quantity Bought"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        productMaintenanceTable1.getTableHeader().setReorderingAllowed(false);
        productMaintenanceTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productMaintenanceTable1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productMaintenanceTable1MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(productMaintenanceTable1);
        if (productMaintenanceTable1.getColumnModel().getColumnCount() > 0) {
            productMaintenanceTable1.getColumnModel().getColumn(0).setResizable(false);
            productMaintenanceTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            productMaintenanceTable1.getColumnModel().getColumn(1).setResizable(false);
            productMaintenanceTable1.getColumnModel().getColumn(2).setResizable(false);
            productMaintenanceTable1.getColumnModel().getColumn(3).setResizable(false);
            productMaintenanceTable1.getColumnModel().getColumn(4).setResizable(false);
            productMaintenanceTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 610, 320));

        moneyReturnedTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        moneyReturnedTf.setToolTipText("");
        moneyReturnedTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        moneyReturnedTf.setEnabled(false);
        jPanel2.add(moneyReturnedTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 230, 40));

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel13.setText("Money to Return");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1130, 380));

        jPanel1.setBackground(new java.awt.Color(0, 224, 145));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("ADD NEW TRANSACTION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 380, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 60));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String rstock = stocksTf.getText();
        int rstocks = Integer.valueOf(rstock);
        int i = productMaintenanceTable1.getSelectedRow();
        TableModel model = productMaintenanceTable1.getModel();
        String bstock = model.getValueAt(i, 5).toString();
        int bstocks = Integer.valueOf(bstock);
        
        //if there is a field left blank
        if(reasonTf.getText().equals("") ||  productIdTf.getText().equals("") || stocksTf.getText().equals("") ){
            JOptionPane.showMessageDialog(this, "Please enter all data needed!");
        }else if(stocksTf.getText().matches(".*[a-zA-Z]+.*") || productIdTf.getText().matches(".*[a-zA-Z]+.*")){
             JOptionPane.showMessageDialog(this, "Invalid Input!", "Error", JOptionPane.ERROR_MESSAGE);
        }else if(rstocks > bstocks){
            JOptionPane.showMessageDialog(this, "You cannot return more than you bought! Hmmm Fishy!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{

            String reason = reasonTf.getText();
            String customername = customerSelect.getSelectedItem().toString();
            String productid = productIdTf.getText();
            String stocksreturned = stocksTf.getText();
            
            //get current price and quantity
            String cart_id = model.getValueAt(i, 0).toString();
            
            try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT quantity, price, total FROM cart WHERE cart_id ='"+cart_id+"' ");
            if(rs.next()){
                
                presentQuantityBought = (rs.getInt("quantity"));
                cprice = (rs.getDouble("price"));
                ctotal = (rs.getDouble("total"));
            }

            }catch(SQLException e){
                JOptionPane.showMessageDialog(this, e);
            }
            
           //saving 
            try{
                
                //# customer_id, customername, product_id, stocksreturned, reason, date
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf.format(d);
                
                //money returned
                Double moneyRet = Double.valueOf(moneyReturnedTf.getText());
                
                Statement s = DBConnector.mycon().createStatement();
                s.executeUpdate("INSERT INTO returned_products (customer_id, customername, product_id, stocksreturned, moneyreturned, reason, date) "
                    + "VALUES ('"+customerid+"','"+customername+"','"+productid+"','"+stocksreturned+"','"+moneyRet+"','"+reason+"','"+date+"')");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
            
            
            
            //update quantity and total amount bought of the customer
            try{
                double priceOfReturnedTotal = rstocks * cprice;
                int newQuantity = presentQuantityBought - rstocks;
                double newTotal = ctotal - priceOfReturnedTotal;
                
                Statement s = DBConnector.mycon().createStatement();
                String query = "UPDATE cart SET quantity='"+newQuantity+"', total='"+newTotal+"' where cart_id=" + cart_id;

                s.executeUpdate(query);
                JOptionPane.showMessageDialog(rootPane, "Updated quantity and total Successfully!");
                
            }catch(SQLException e){
            
                JOptionPane.showMessageDialog(this, e);
                
            }
            
            //getting current stock
            try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT stocks FROM product_maintenance WHERE product_id ='"+productid+"' ");
            if(rs.next()){

                presentStock = (rs.getInt("stocks"));

            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
            
            //for updating stock
            try{
                int stocksReturnedint = Integer.valueOf(stocksreturned);
                int updatedStock = presentStock + stocksReturnedint;
                
                Statement s = DBConnector.mycon().createStatement();
                String query = "UPDATE product_maintenance SET stocks='"+updatedStock+"' where product_id=" + productid;

                s.executeUpdate(query);
                
            }catch(SQLException e){
            
                JOptionPane.showMessageDialog(this, e);
                
            }
            
            JOptionPane.showMessageDialog(rootPane, "Added and Stock Updated Successfully!");

                
                
                productMaintenanceTable1.setModel(new DefaultTableModel(null, new String[]{"Cart ID","Product ID", "Flavor", "Size", "Price", "Quantity Bought"}));
                showData();
        }
        
        //for printing invoice
        try{
            
            JRTableModelDataSource ds = new JRTableModelDataSource(model);
            String r = "C:\\Users\\james\\Documents\\2y1 Activities\\OOP Projects\\ElCoco\\src\\reports\\ReturnedProductInvoice.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(r);
            
            //get product info
            String customername = customerSelect.getSelectedItem().toString();
            String productId = productIdTf.getText();
            String flavor = model.getValueAt(i, 2).toString();
            String size = model.getValueAt(i, 3).toString();
            String price = model.getValueAt(i, 4).toString();
            Double moneyRet = Double.valueOf(moneyReturnedTf.getText());
            
            HashMap<String, Object> p = new HashMap<String, Object>();
            p.put("CUSNAME", customername);
            p.put("PRODUCT_ID", productId);
            p.put("FLAVOR", flavor);
            p.put("SIZE", size);
            p.put("QUANTITY_RETURNED", rstock);
            p.put("PRICE", price);
            p.put("AMOUNT_RETURNED", moneyRet);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, p, ds);
            
            JasperViewer.viewReport(jp, false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        reasonTf.setText("");
        productIdTf.setText("");
        stocksTf.setText("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void customerSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSelectActionPerformed

        String name = customerSelect.getSelectedItem().toString();

        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT customer_id FROM customer_maintenance WHERE customername ='"+name+"' ");
            if(rs.next()){

                customerid = (rs.getString("customer_id"));

            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        productMaintenanceTable1.setModel(new DefaultTableModel(null, new String[]{"Cart ID","Product ID", "Flavor", "Size", "Price", "Quantity Bought"}));
        showData();
    }//GEN-LAST:event_customerSelectActionPerformed

    private void productMaintenanceTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMaintenanceTable1MouseClicked
        int i = productMaintenanceTable1.getSelectedRow();
        int modelRow = productMaintenanceTable1.convertRowIndexToModel(i);
        TableModel model = productMaintenanceTable1.getModel();
        productIdTf.setText(model.getValueAt(i, 1).toString());
        //int id = Integer.parseInt((String)(this.productMaintenanceTable.getModel()).getValueAt(modelRow, 0));
        //productIdTf.setText(String.valueOf(id));
        //String a = String.valueOf(id);
        //stocksTf.setText(a);
    }//GEN-LAST:event_productMaintenanceTable1MouseClicked

    private void productMaintenanceTable1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMaintenanceTable1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_productMaintenanceTable1MouseEntered

    private void stocksTfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_stocksTfKeyReleased
        TableModel model = productMaintenanceTable1.getModel();
        int i = productMaintenanceTable1.getSelectedRow();
        int rstocks = Integer.valueOf(stocksTf.getText());
        String ccprice = model.getValueAt(i, 4).toString();
        double cpricee = Double.valueOf(ccprice);
        int quanBought = Integer.valueOf(model.getValueAt(i, 5).toString());
        
        if(rstocks > quanBought){
            JOptionPane.showMessageDialog(this, "You cannot return more than you bought! Hmmm Fishy!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            double moneyRet = rstocks * cpricee;
            moneyReturnedTf.setText(String.valueOf(moneyRet));
            System.out.println(moneyRet);
        }
    }//GEN-LAST:event_stocksTfKeyReleased

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
            java.util.logging.Logger.getLogger(AddNewReturnedProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNewReturnedProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNewReturnedProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNewReturnedProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewReturnedProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> customerSelect;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField moneyReturnedTf;
    public javax.swing.JTextField productIdTf;
    public javax.swing.JTable productMaintenanceTable1;
    private javax.swing.JTextField reasonTf;
    private javax.swing.JTextField stocksTf;
    // End of variables declaration//GEN-END:variables
}
