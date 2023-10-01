/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesAndInventorySystem;

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import static salesAndInventorySystem.AddNewReturnedProduct.customerid;

/**
 *
 * @author james
 */
public class SalesTransaction extends javax.swing.JFrame {

    /**
     * Creates new form SalesTransaction
     */
    
    public static String customerid = "0";
    public static int currentstocks;
    
    public SalesTransaction() {
        initComponents();
        setProductsToTable();
        customerSelect();
        loadInvoiceNo();
        showIcon();
    }
    
    private void showIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("wine__.png")));
    }
    
    public void loadInvoiceNo(){
        
        try{
            
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM invoice WHERE invoice_id =1");
            
            if(rs.next()){
                
                invoiceNo.setText(rs.getString("value"));
            }
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        int i = Integer.valueOf(invoiceNo.getText());
        i++;
        invoiceNo.setText(String.valueOf(i));
        
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
    
    public void setCartToTable(){
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/el_coco_db","root","root");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM cart");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                int invoice_id = rs.getInt("invoice_id");
                String product_id = rs.getString("product_id");
                String flavor = rs.getString("flavor");
                String size = rs.getString("size");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                double total = rs.getDouble("total");
                
                Object[] obj = {invoice_id, product_id, flavor, size, price, quantity, total };
                
                DefaultTableModel model = (DefaultTableModel)productMaintenanceTable.getModel();
                model.addRow(obj);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void setProductsToTable(){
        String statuss = "'Active'";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/el_coco_db","root","root");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM product_maintenance WHERE status=" + statuss);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                int product_id = rs.getInt("product_id");
                String flavor = rs.getString("flavor");
                String size = rs.getString("size");
                double price = rs.getDouble("price");
                int stocks = rs.getInt("stocks");
                
                Object[] obj = {product_id, flavor, size, price, stocks };
                
                DefaultTableModel model = (DefaultTableModel)productMaintenanceTable.getModel();
                model.addRow(obj);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void amountDue(){
        //amount due
        int numofrow = cartTable.getRowCount();
        double total = 0;
        
        for(int i = 0; i < numofrow; i++){
            
            double value = Double.valueOf(cartTable.getValueAt(i, 6).toString());
            total += value;
        }
        
        amountDueTf.setText(Double.toString(total));
        
        //total quantity
        int numofrow1 = cartTable.getRowCount();
        int total1 = 0;
        
        for(int i = 0; i < numofrow1; i++){
            
            int value1 = Integer.valueOf(cartTable.getValueAt(i, 5).toString());
            total1 += value1;
        }
        
        totalQuantity.setText(Integer.toString(total1));
    }
    
    public void amountChange(){
        
        Double paidAmount = Double.valueOf(amountPaidTf.getText());
        Double amountDue = Double.valueOf(amountDueTf.getText());
        Double change;
        
        change = paidAmount - amountDue;
        
        changeTf.setText(String.valueOf(change));
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        productMaintenanceTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        productIdTf = new javax.swing.JTextField();
        invoiceNo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        flavorTf = new javax.swing.JTextField();
        priceTf = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        sizeTf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        quantityTf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        removeToCartBtn = new javax.swing.JButton();
        saveAndPrintBtn = new javax.swing.JButton();
        amountPaidTf = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        changeTf = new javax.swing.JTextField();
        amountDueTf = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        addToCartBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        customerSelect = new javax.swing.JComboBox<>();
        totalTf = new javax.swing.JTextField();
        totalQuantity = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        deliveryTypeSelect = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        paymentModeSelect = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        jToggleButton1.setText("jToggleButton1");

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/minimize__.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sales Transaction");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(44, 119, 33), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 224, 145));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("PRODUCTS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 240, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 750, 51));

        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "Product ID", "Flavor", "Size", "Price", "Quantity", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cartTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(cartTable);
        if (cartTable.getColumnModel().getColumnCount() > 0) {
            cartTable.getColumnModel().getColumn(0).setResizable(false);
            cartTable.getColumnModel().getColumn(1).setResizable(false);
            cartTable.getColumnModel().getColumn(2).setResizable(false);
            cartTable.getColumnModel().getColumn(3).setResizable(false);
            cartTable.getColumnModel().getColumn(4).setResizable(false);
            cartTable.getColumnModel().getColumn(5).setResizable(false);
            cartTable.getColumnModel().getColumn(6).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 1580, 320));

        productMaintenanceTable.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        productMaintenanceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Flavor", "Size", "Price", "Stocks"
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
        productMaintenanceTable.getTableHeader().setReorderingAllowed(false);
        productMaintenanceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productMaintenanceTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(productMaintenanceTable);
        if (productMaintenanceTable.getColumnModel().getColumnCount() > 0) {
            productMaintenanceTable.getColumnModel().getColumn(0).setResizable(false);
            productMaintenanceTable.getColumnModel().getColumn(1).setResizable(false);
            productMaintenanceTable.getColumnModel().getColumn(2).setResizable(false);
            productMaintenanceTable.getColumnModel().getColumn(3).setResizable(false);
            productMaintenanceTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 750, 490));

        jPanel3.setBackground(new java.awt.Color(0, 224, 145));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Book", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("CART");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 100, 50));
        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -50, 140, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1580, 51));

        productIdTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        productIdTf.setToolTipText("");
        productIdTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        productIdTf.setEnabled(false);
        productIdTf.setMargin(new java.awt.Insets(5, 5, 5, 5));
        jPanel1.add(productIdTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 450, 230, 40));

        invoiceNo.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        invoiceNo.setText("01");
        jPanel1.add(invoiceNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 400, -1, 40));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel9.setText("Flavor");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, -1, 40));

        flavorTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        flavorTf.setToolTipText("");
        flavorTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        flavorTf.setEnabled(false);
        jPanel1.add(flavorTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 500, 230, 40));

        priceTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        priceTf.setToolTipText("");
        priceTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        priceTf.setEnabled(false);
        jPanel1.add(priceTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 600, 230, 40));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel11.setText("Price");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 600, -1, 40));

        sizeTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        sizeTf.setToolTipText("");
        sizeTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        sizeTf.setEnabled(false);
        jPanel1.add(sizeTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 550, 230, 40));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel10.setText("Size");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 550, -1, 40));

        quantityTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        quantityTf.setText("0");
        quantityTf.setToolTipText("");
        quantityTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        quantityTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                quantityTfMouseClicked(evt);
            }
        });
        quantityTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityTfKeyReleased(evt);
            }
        });
        jPanel1.add(quantityTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 650, 230, 40));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel12.setText("Quantity");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 650, -1, 40));

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel14.setText("Total");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 700, -1, 40));

        removeToCartBtn.setBackground(new java.awt.Color(44, 119, 33));
        removeToCartBtn.setFont(new java.awt.Font("Franklin Gothic Book", 0, 32)); // NOI18N
        removeToCartBtn.setForeground(new java.awt.Color(255, 255, 255));
        removeToCartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remove to cart.png"))); // NOI18N
        removeToCartBtn.setText("REMOVE TO CART");
        removeToCartBtn.setFocusable(false);
        removeToCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeToCartBtnActionPerformed(evt);
            }
        });
        jPanel1.add(removeToCartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 810, 400, 60));

        saveAndPrintBtn.setBackground(new java.awt.Color(44, 119, 33));
        saveAndPrintBtn.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 24)); // NOI18N
        saveAndPrintBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveAndPrintBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/save.png"))); // NOI18N
        saveAndPrintBtn.setText("PAY AND PRINT");
        saveAndPrintBtn.setFocusable(false);
        saveAndPrintBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveAndPrintBtnMouseClicked(evt);
            }
        });
        saveAndPrintBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAndPrintBtnActionPerformed(evt);
            }
        });
        jPanel1.add(saveAndPrintBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 880, 400, 60));

        amountPaidTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        amountPaidTf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amountPaidTf.setText("0.00");
        amountPaidTf.setToolTipText("");
        amountPaidTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        amountPaidTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amountPaidTfMouseClicked(evt);
            }
        });
        amountPaidTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amountPaidTfKeyReleased(evt);
            }
        });
        jPanel1.add(amountPaidTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 600, 230, 70));

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel15.setText("Amount Paid");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 600, -1, 70));

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel16.setText("Customer Name");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 450, -1, 40));

        jLabel17.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel17.setText("Change");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 680, -1, 40));

        changeTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        changeTf.setText("0.00");
        changeTf.setToolTipText("");
        changeTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        changeTf.setEnabled(false);
        jPanel1.add(changeTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 680, 230, 40));

        amountDueTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 48)); // NOI18N
        amountDueTf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        amountDueTf.setText("0.00");
        amountDueTf.setToolTipText("");
        amountDueTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        amountDueTf.setEnabled(false);
        jPanel1.add(amountDueTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 830, 320, 110));

        jLabel18.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel18.setText("Amount Due");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 790, -1, 40));

        addToCartBtn.setBackground(new java.awt.Color(44, 119, 33));
        addToCartBtn.setFont(new java.awt.Font("Franklin Gothic Book", 0, 32)); // NOI18N
        addToCartBtn.setForeground(new java.awt.Color(255, 255, 255));
        addToCartBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/add to cart.png"))); // NOI18N
        addToCartBtn.setText("ADD TO CART");
        addToCartBtn.setFocusable(false);
        addToCartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addToCartBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 740, 400, 60));

        jLabel19.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel19.setText("Product ID");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, -1, 40));

        jLabel20.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel20.setText("INVOICE NO :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 400, -1, 40));

        customerSelect.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        customerSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerSelectActionPerformed(evt);
            }
        });
        jPanel1.add(customerSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 450, 230, 40));

        totalTf.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        totalTf.setText("0.00");
        totalTf.setToolTipText("");
        totalTf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        totalTf.setEnabled(false);
        jPanel1.add(totalTf, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 700, 230, 40));

        totalQuantity.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        totalQuantity.setText("0");
        jPanel1.add(totalQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 400, 120, 40));

        jLabel21.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel21.setText("TOTAL QUANTITY:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 400, -1, 40));

        deliveryTypeSelect.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        deliveryTypeSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Scheduled Delivery", "Self Pick-up" }));
        deliveryTypeSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryTypeSelectActionPerformed(evt);
            }
        });
        jPanel1.add(deliveryTypeSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 500, 230, 40));

        jLabel22.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel22.setText("Delivery Type");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 500, -1, 40));

        paymentModeSelect.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        paymentModeSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Mobile Payment" }));
        paymentModeSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentModeSelectActionPerformed(evt);
            }
        });
        jPanel1.add(paymentModeSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(1360, 550, 230, 40));

        jLabel23.setFont(new java.awt.Font("Franklin Gothic Book", 1, 22)); // NOI18N
        jLabel23.setText("Payment Mode");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 550, -1, 40));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, -1, -1));
        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 310, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 950));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void productMaintenanceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMaintenanceTableMouseClicked
        int i = productMaintenanceTable.getSelectedRow();
        TableModel model = productMaintenanceTable.getModel();
        productIdTf.setText(model.getValueAt(i, 0).toString());
        flavorTf.setText(model.getValueAt(i, 1).toString());
        sizeTf.setText(model.getValueAt(i, 2).toString());   
        priceTf.setText(model.getValueAt(i, 3).toString());  
        
        
    }//GEN-LAST:event_productMaintenanceTableMouseClicked

    private void removeToCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeToCartBtnActionPerformed
        
        
        int i = cartTable.getSelectedRow();
        TableModel model1 = cartTable.getModel();
        String product_id = model1.getValueAt(i, 1).toString();
        String quantity = model1.getValueAt(i, 5).toString();
        
        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT stocks FROM product_maintenance WHERE product_id ='"+product_id+"' ");
            if(rs.next()){

                currentstocks = (rs.getInt("stocks"));

            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        int stockToMinusa = Integer.valueOf(quantity);
        
        int newstocks = currentstocks + stockToMinusa;
        
        try{
                Statement s = DBConnector.mycon().createStatement();
                String query = "UPDATE product_maintenance SET stocks='"+newstocks+"' where product_id=" + product_id;

                s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Updated Successfully!");

                productMaintenanceTable.setModel(new DefaultTableModel(null, new String[]{"Product ID", "Flavor", "Size", "Price", "Stocks"}));
                setProductsToTable();

        }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
        }
        
        try{
            
            DefaultTableModel dt = (DefaultTableModel)cartTable.getModel();
            int rw = cartTable.getSelectedRow();
            dt.removeRow(rw);
        }catch(Exception e){
            
        }
        
        amountDue();
        amountChange();
    }//GEN-LAST:event_removeToCartBtnActionPerformed

    private void saveAndPrintBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAndPrintBtnActionPerformed
        
            
    }//GEN-LAST:event_saveAndPrintBtnActionPerformed

    private void addToCartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartBtnActionPerformed
            int i = productMaintenanceTable.getSelectedRow();
            TableModel model = productMaintenanceTable.getModel();
            String current = model.getValueAt(i, 4).toString();
            int currents = Integer.valueOf(current);
            
            int quantity = Integer.valueOf(quantityTf.getText());
            int diff = currents - quantity;
            if(diff < 0){
                JOptionPane.showMessageDialog(this, "Insufficient stocks!");
            }else if(quantityTf.getText().equals("0")){
             JOptionPane.showMessageDialog(this, "Enter Quantity!", "Error", JOptionPane.ERROR_MESSAGE);
         }else{
            
         try{   
        DefaultTableModel dt = (DefaultTableModel)cartTable.getModel();
        Vector v = new Vector();
        
        v.add(invoiceNo.getText());
        v.add(productIdTf.getText());
        v.add(flavorTf.getText());
        v.add(sizeTf.getText());
        v.add(priceTf.getText());
        v.add(quantityTf.getText());
        v.add(totalTf.getText());
        
        String a = quantityTf.getText();
        
        if(a.matches(".*[a-zA-Z]+.*")){
                JOptionPane.showMessageDialog(this, "Incorrect Input!", "Error", JOptionPane.ERROR_MESSAGE);
                quantityTf.setText("0");
            }else{
        
        dt.addRow(v);
        
        }
            
        }catch(HeadlessException e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        
        
        amountDue();
        amountChange();
        
        //updating  stock 
        
        String product_id = productIdTf.getText();
        
        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT stocks FROM product_maintenance WHERE product_id ='"+product_id+"' ");
            if(rs.next()){

                currentstocks = (rs.getInt("stocks"));

            }

        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        String stockToMinus = quantityTf.getText();
        int stockToMinusa = Integer.valueOf(stockToMinus);
        
        int newstocks = currentstocks - stockToMinusa;
        
        try{
                Statement s = DBConnector.mycon().createStatement();
                String query = "UPDATE product_maintenance SET stocks='"+newstocks+"' where product_id=" + product_id;

                s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Updated Successfully!");

                productMaintenanceTable.setModel(new DefaultTableModel(null, new String[]{"Product ID", "Flavor", "Size", "Price", "Stocks"}));
                setProductsToTable();
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        productIdTf.setText("");
        flavorTf.setText("");
        sizeTf.setText("");
        priceTf.setText("");
        quantityTf.setText("0");
        totalTf.setText("");
        /*
        if(productIdTf.equals("") || flavorTf.equals("") || sizeTf.equals("") || priceTf.equals("") || quantityTf.equals("") ){
            JOptionPane.showMessageDialog(this, "Incomplete product data!");
        }
        else{
            
            String invoice_id = invoiceNo.getText();
            String product_id = productIdTf.getText();
            String flavor = flavorTf.getText();
            String price = priceTf.getText();
            String quantity = quantityTf.getText();
            String total = totalTf.getText();
            
            try{

                Statement s = DBConnector.mycon().createStatement();
                s.executeUpdate("INSERT INTO cart (`invoice_id`, `product_id`, `flavor`, `size`, `price`, `quantity`, `total`) "
                    + "VALUES ('"+invoice_id+"','"+product_id+"','"+flavor+"','"+price+"','"+quantity+"','"+total+"')");

                JOptionPane.showMessageDialog(rootPane, "Added Successfully!");
                
                int in = Integer.valueOf(invoice_id);
                int newIn = ++in;
                productIdTf.setText("");
                invoiceNo.setText(String.valueOf(newIn));
                flavorTf.setText("");
                priceTf.setText("");
                quantityTf.setText("0");
                totalTf.setText("0.00");

            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        */
            } 
    }//GEN-LAST:event_addToCartBtnActionPerformed

    private void customerSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerSelectActionPerformed
       
        
        String name = customerSelect.getSelectedItem().toString();
        
        try{
            Statement s = DBConnector.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT customer_id,customername FROM customer_maintenance WHERE customername ='"+name+"' ");
            if(rs.next()){
                
                customerid = (rs.getString("customer_id"));
                
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_customerSelectActionPerformed

    private void quantityTfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTfKeyReleased
        
        Double quantity = Double.valueOf(quantityTf.getText().trim());
        double price = Double.valueOf(priceTf.getText());
        
        double total = quantity * price;
        
        totalTf.setText(String.valueOf(total));
        
    }//GEN-LAST:event_quantityTfKeyReleased

    private void amountPaidTfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amountPaidTfKeyReleased
        
        amountChange();
        
    }//GEN-LAST:event_amountPaidTfKeyReleased

    private void amountPaidTfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amountPaidTfMouseClicked
        amountPaidTf.setText("");
    }//GEN-LAST:event_amountPaidTfMouseClicked

    private void quantityTfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_quantityTfMouseClicked
        quantityTf.setText("");
    }//GEN-LAST:event_quantityTfMouseClicked

    private void saveAndPrintBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveAndPrintBtnMouseClicked
        int x = cartTable.getRowCount();
        
        if(amountPaidTf.getText().matches(".*[a-zA-Z]+.*")){
                JOptionPane.showMessageDialog(this, "Incorrect Input!", "Error", JOptionPane.ERROR_MESSAGE);
                amountPaidTf.setText("0.00");
            }else if(x == 0){
                JOptionPane.showMessageDialog(this, "Cart is Empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
        try{
            
            DefaultTableModel dt = (DefaultTableModel)cartTable.getModel();
            int rc = dt.getRowCount();
            
            for(int i = 0; i < rc; i++){
                
                String invoice_id = dt.getValueAt(i, 0).toString();
                String product_id = dt.getValueAt(i, 1).toString();
                String flavor = dt.getValueAt(i, 2).toString();
                String size = dt.getValueAt(i, 3).toString();
                String quantity = dt.getValueAt(i, 5).toString();
                String price = dt.getValueAt(i, 4).toString();
                String total = dt.getValueAt(i, 6).toString();
                
                //cartw
                Statement s = DBConnector.mycon().createStatement();
                s.executeUpdate("INSERT INTO cart (`invoice_id`, `product_id`, `flavor`, `size`, `price`, `quantity`, `total`) "
                    + "VALUES ('"+invoice_id+"','"+product_id+"','"+flavor+"','"+size+"','"+price+"','"+quantity+"','"+total+"')");
            }
            
            JOptionPane.showMessageDialog(rootPane, "Added Successfully!");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        //salestransaction
        
        //`invoice_id`, `cart_id`, `customername`, `totalquantity`, `amountdue`, `status`, `balance` , 'deliverytype', 'paymentmode'
        
        try{
            
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf.format(d);
            
            String customername = customerSelect.getSelectedItem().toString();
            String invoice_id = invoiceNo.getText();
            String totalquantity = totalQuantity.getText();
            String amountdue = amountDueTf.getText();
            String balance = changeTf.getText();
            String deliverytype = deliveryTypeSelect.getSelectedItem().toString();
            String modeofpayment = paymentModeSelect.getSelectedItem().toString();
            
            
            
            //status
            Double tot = Double.valueOf(amountDueTf.getText());
            Double pid = Double.valueOf(amountPaidTf.getText());
            String status = null;
            if(pid.equals(0.00)){
                
                status = "Unpaid";
            
            }else if(tot > pid){
                
                status = "Partially Paid";
            }else if(tot <= pid){
                
                status = "Paid";
            }
            
            Statement s = DBConnector.mycon().createStatement();
            s.executeUpdate("INSERT INTO sales_transactions (`invoice_id`, `customer_id`, `customername`, `totalquantity`, `amountdue`, `status`, `change_balance`,  `deliverytype`, `modeofpayment`, `date`) "
                    + "VALUES ('"+invoice_id+"','"+customerid+"','"+customername+"','"+totalquantity+"','"+amountdue+"','"+status+"','"+balance+"','"+deliverytype+"','"+modeofpayment+"','"+date+"')");
            
              
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        JOptionPane.showMessageDialog(rootPane, "Saved Successfully!");
        
        DefaultTableModel dt = (DefaultTableModel)cartTable.getModel();
        dt.setRowCount(0);
        
        
        
        //print invoice
        String invoice = this.invoiceNo.getText();
        String cusname = customerSelect.getSelectedItem().toString();
        String deliverytype = deliveryTypeSelect.getSelectedItem().toString();
        String paymentmode = paymentModeSelect.getSelectedItem().toString();
        String amountpaid = amountPaidTf.getText();
        String change_balance = changeTf.getText();
        
        System.out.println(amountpaid);
        System.out.println(change_balance);
        
        try{
            
            JasperDesign j = JRXmlLoader.load("C:\\Users\\james\\Documents\\2y1 Activities\\OOP Projects\\ElCoco\\src\\reports\\SalesInvoice3.jrxml");
            String sql = "SELECT\n" +
                    "     cart.`cart_id` AS cart_cart_id,\n" +
                    "     cart.`invoice_id` AS cart_invoice_id,\n" +
                    "     cart.`product_id` AS cart_product_id,\n" +
                    "     cart.`flavor` AS cart_flavor,\n" +
                    "     cart.`size` AS cart_size,\n" +
                    "     cart.`price` AS cart_price,\n" +
                    "     cart.`quantity` AS cart_quantity,\n" +
                    "     cart.`total` AS cart_total\n" +
                    "FROM\n" +
                    "     `cart` WHERE invoice_id = " + invoice;
            
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            
            j.setQuery(newQuery);
            
            HashMap<String, Object> a = new HashMap<>();
            a.put("cart_invoice_id", invoice);
            a.put("cusname", cusname);
            a.put("deliverytype", deliverytype);
            a.put("modeofpayment", paymentmode);
            a.put("amountpaid", amountpaid);
            a.put("change_balance", change_balance);
            
            JasperReport js = JasperCompileManager.compileReport(j);
            JasperPrint jp = JasperFillManager.fillReport(js, a, DBConnector.mycon());
            
            JasperViewer.viewReport(jp, false);
        }catch(JRException e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        productIdTf.setText("");
        flavorTf.setText("");
        sizeTf.setText("");
        priceTf.setText("");
        quantityTf.setText("0");
        totalTf.setText("0.00");
        amountDueTf.setText("0.00");
        amountPaidTf.setText("0.00");
        changeTf.setText("0.00");
        
        try{
            
            String id = invoiceNo.getText();
            Statement s = DBConnector.mycon().createStatement();
            s.executeUpdate("UPDATE invoice SET value='"+id+"' WHERE invoice_id = 1");
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e);
        }
        
        loadInvoiceNo();
        
        }   
    }//GEN-LAST:event_saveAndPrintBtnMouseClicked

    private void deliveryTypeSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryTypeSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deliveryTypeSelectActionPerformed

    private void paymentModeSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentModeSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentModeSelectActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(SalesTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesTransaction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesTransaction().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartBtn;
    private javax.swing.JTextField amountDueTf;
    private javax.swing.JTextField amountPaidTf;
    private javax.swing.JTable cartTable;
    private javax.swing.JTextField changeTf;
    private javax.swing.JComboBox<String> customerSelect;
    private javax.swing.JComboBox<String> deliveryTypeSelect;
    private javax.swing.JTextField flavorTf;
    private javax.swing.JLabel invoiceNo;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JComboBox<String> paymentModeSelect;
    private javax.swing.JTextField priceTf;
    private javax.swing.JTextField productIdTf;
    public javax.swing.JTable productMaintenanceTable;
    private javax.swing.JTextField quantityTf;
    private javax.swing.JButton removeToCartBtn;
    private javax.swing.JButton saveAndPrintBtn;
    private javax.swing.JTextField sizeTf;
    private javax.swing.JLabel totalQuantity;
    private javax.swing.JTextField totalTf;
    // End of variables declaration//GEN-END:variables
}
