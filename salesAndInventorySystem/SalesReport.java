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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author james
 */
public class SalesReport extends javax.swing.JFrame {

    /**
     * Creates new form SalesReport
     */
    DefaultTableModel dm;
    
    public SalesReport() {
        initComponents();
        setRecordsToTable();
        showIcon();
    }
    
    private void showIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("wine__.png")));
    }
    
    public void createColumns(){
    
    
    }
    
    public void setRecordsToTable(){
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/el_coco_db","root","root");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM sales_transactions");
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
                
                int sales_transactions_id = rs.getInt("salestransaction_id");
                int invoice_id = rs.getInt("invoice_id");
                int customer_id = rs.getInt("customer_id");
                String customerName = rs.getString("customername");
                String totalquantity = rs.getString("totalquantity");
                String amountdue = rs.getString("amountdue");
                String status = rs.getString("status");
                String balance = rs.getString("change_balance");
                String deliverytype = rs.getString("deliverytype");
                String modeofpayment = rs.getString("modeofpayment");
                String date = rs.getString("date");
                
                Object[] obj = {sales_transactions_id, invoice_id, customer_id, customerName, totalquantity, amountdue, status, balance, deliverytype, modeofpayment, date };
                
                DefaultTableModel model = (DefaultTableModel)salesReportTable.getModel();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        salesReportTable = new javax.swing.JTable();
        editBtn1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        allSalesBtn1 = new javax.swing.JButton();
        fromDate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        toDate = new com.toedter.calendar.JDateChooser();
        allSalesBtn2 = new javax.swing.JButton();
        lastWeekSales = new javax.swing.JButton();
        thisMonthSales = new javax.swing.JButton();
        thisYearSales = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        listOfUnpaid = new javax.swing.JButton();
        listOfUnpaid1 = new javax.swing.JButton();
        PreviousMonthSales = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 224, 145)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salesReportTable.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        salesReportTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Invoice ID", "STransactions ID", "Customer ID", "Customer Name", "Total Quantity", "Amount Due", "Status", "Change_Balance", "Delivery Type", "Mode of Payment", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salesReportTable.getTableHeader().setReorderingAllowed(false);
        salesReportTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesReportTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(salesReportTable);
        if (salesReportTable.getColumnModel().getColumnCount() > 0) {
            salesReportTable.getColumnModel().getColumn(0).setResizable(false);
            salesReportTable.getColumnModel().getColumn(0).setPreferredWidth(15);
            salesReportTable.getColumnModel().getColumn(1).setResizable(false);
            salesReportTable.getColumnModel().getColumn(2).setResizable(false);
            salesReportTable.getColumnModel().getColumn(3).setResizable(false);
            salesReportTable.getColumnModel().getColumn(4).setResizable(false);
            salesReportTable.getColumnModel().getColumn(5).setResizable(false);
            salesReportTable.getColumnModel().getColumn(6).setResizable(false);
            salesReportTable.getColumnModel().getColumn(7).setResizable(false);
            salesReportTable.getColumnModel().getColumn(8).setResizable(false);
            salesReportTable.getColumnModel().getColumn(9).setResizable(false);
            salesReportTable.getColumnModel().getColumn(10).setResizable(false);
        }

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 1330, 460));

        editBtn1.setBackground(new java.awt.Color(44, 119, 33));
        editBtn1.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        editBtn1.setForeground(new java.awt.Color(255, 255, 255));
        editBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        editBtn1.setText("EDIT");
        editBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(editBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, 110, 50));

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        jLabel8.setText("From:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, 20));

        allSalesBtn1.setBackground(new java.awt.Color(44, 119, 33));
        allSalesBtn1.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        allSalesBtn1.setForeground(new java.awt.Color(255, 255, 255));
        allSalesBtn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/calendar (1).png"))); // NOI18N
        allSalesBtn1.setText("All Sales");
        allSalesBtn1.setFocusable(false);
        allSalesBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allSalesBtn1ActionPerformed(evt);
            }
        });
        jPanel2.add(allSalesBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 40, 140, 90));

        fromDate.setBackground(new java.awt.Color(255, 255, 255));
        fromDate.setDateFormatString("yyyy-MM-dd");
        fromDate.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jPanel2.add(fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 130, 40));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Book", 0, 18)); // NOI18N
        jLabel10.setText("To:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, -1, 20));

        toDate.setBackground(new java.awt.Color(255, 255, 255));
        toDate.setDateFormatString("yyyy-MM-dd");
        toDate.setFont(new java.awt.Font("Franklin Gothic Book", 0, 14)); // NOI18N
        jPanel2.add(toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 40, 130, 40));

        allSalesBtn2.setBackground(new java.awt.Color(44, 119, 33));
        allSalesBtn2.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        allSalesBtn2.setForeground(new java.awt.Color(255, 255, 255));
        allSalesBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search (1).png"))); // NOI18N
        allSalesBtn2.setText("Search Between Dates");
        allSalesBtn2.setFocusable(false);
        allSalesBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allSalesBtn2ActionPerformed(evt);
            }
        });
        jPanel2.add(allSalesBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 280, 40));

        lastWeekSales.setBackground(new java.awt.Color(44, 119, 33));
        lastWeekSales.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        lastWeekSales.setForeground(new java.awt.Color(255, 255, 255));
        lastWeekSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/week.png"))); // NOI18N
        lastWeekSales.setText("Sales Last Week");
        lastWeekSales.setFocusable(false);
        lastWeekSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastWeekSalesActionPerformed(evt);
            }
        });
        jPanel2.add(lastWeekSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 210, 40));

        thisMonthSales.setBackground(new java.awt.Color(44, 119, 33));
        thisMonthSales.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        thisMonthSales.setForeground(new java.awt.Color(255, 255, 255));
        thisMonthSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/month.png"))); // NOI18N
        thisMonthSales.setText("Sales This Month");
        thisMonthSales.setFocusable(false);
        thisMonthSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thisMonthSalesActionPerformed(evt);
            }
        });
        jPanel2.add(thisMonthSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 210, 40));

        thisYearSales.setBackground(new java.awt.Color(44, 119, 33));
        thisYearSales.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        thisYearSales.setForeground(new java.awt.Color(255, 255, 255));
        thisYearSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/year.png"))); // NOI18N
        thisYearSales.setText("Sales This Year");
        thisYearSales.setFocusable(false);
        thisYearSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thisYearSalesActionPerformed(evt);
            }
        });
        jPanel2.add(thisYearSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 240, 40));

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
        jPanel2.add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 90, 120, 40));

        listOfUnpaid.setBackground(new java.awt.Color(44, 119, 33));
        listOfUnpaid.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        listOfUnpaid.setForeground(new java.awt.Color(255, 255, 255));
        listOfUnpaid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/year.png"))); // NOI18N
        listOfUnpaid.setText("List of Unpaid");
        listOfUnpaid.setFocusable(false);
        listOfUnpaid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOfUnpaidActionPerformed(evt);
            }
        });
        jPanel2.add(listOfUnpaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 40, 230, 40));

        listOfUnpaid1.setBackground(new java.awt.Color(44, 119, 33));
        listOfUnpaid1.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        listOfUnpaid1.setForeground(new java.awt.Color(255, 255, 255));
        listOfUnpaid1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/year.png"))); // NOI18N
        listOfUnpaid1.setText("List of Partially Paid");
        listOfUnpaid1.setFocusable(false);
        listOfUnpaid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOfUnpaid1ActionPerformed(evt);
            }
        });
        jPanel2.add(listOfUnpaid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 90, 230, 40));

        PreviousMonthSales.setBackground(new java.awt.Color(44, 119, 33));
        PreviousMonthSales.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        PreviousMonthSales.setForeground(new java.awt.Color(255, 255, 255));
        PreviousMonthSales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/month.png"))); // NOI18N
        PreviousMonthSales.setText("Previous Month Sales");
        PreviousMonthSales.setFocusable(false);
        PreviousMonthSales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousMonthSalesActionPerformed(evt);
            }
        });
        jPanel2.add(PreviousMonthSales, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 240, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1400, 650));

        jPanel1.setBackground(new java.awt.Color(0, 224, 145));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Book", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Sales Report");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 270, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 70));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void salesReportTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesReportTableMouseClicked
        
    }//GEN-LAST:event_salesReportTableMouseClicked

    private void editBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtn1ActionPerformed
       
    }//GEN-LAST:event_editBtn1ActionPerformed

    private void allSalesBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allSalesBtn1ActionPerformed
            try {
            
            String query = "SELECT * FROM sales_transactions";
            PreparedStatement pst = DBConnector.mycon().prepareStatement(query);
            
            ResultSet rs = pst.executeQuery(query);
            
            salesReportTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            System.out.println(rs);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            
            DefaultTableModel model = (DefaultTableModel) salesReportTable.getModel();
            JRTableModelDataSource ds = new JRTableModelDataSource(model);
            String r = "C:\\Users\\james\\Documents\\2y1 Activities\\OOP Projects\\ElCoco\\src\\reports\\AllTimeSales.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(r);
            
            //get this year
            int year = Calendar.getInstance().get(Calendar.YEAR);
            String curyear = String.valueOf(year);
            
            //get sum of amount due
            double total = 0.0;
            for (int ix = 0; ix < salesReportTable.getRowCount(); ix++){
                double amount = Double.parseDouble(salesReportTable.getValueAt(ix, 5).toString());
                total += amount;
            }
            System.out.println(total);
            
            HashMap<String, Object> p = new HashMap<String, Object>();
            p.put("TOTAL_AMOUNT", total);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, p, ds);
            
            JasperViewer.viewReport(jp, false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_allSalesBtn1ActionPerformed

    private void allSalesBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allSalesBtn2ActionPerformed
 
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String from = sdf.format(fromDate.getDate());
       String to = sdf.format(toDate.getDate());
       
       if(from.equals(" ") || to.equals(" ")){
           JOptionPane.showMessageDialog(this, "Select Dates!", "Error", JOptionPane.ERROR_MESSAGE);
       }else{
       
       try{
           String query = "SELECT * FROM sales_transactions WHERE date >= '"+from+"' AND date <= '"+to+"' ";
           PreparedStatement pst = DBConnector.mycon().prepareStatement(query);
           
           ResultSet rs = pst.executeQuery(query);
           
           salesReportTable.setModel(DbUtils.resultSetToTableModel(rs));
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(this, e);
       }
       
       try{ 
            
            DefaultTableModel model = (DefaultTableModel) salesReportTable.getModel();
            JRTableModelDataSource ds = new JRTableModelDataSource(model);
            String r = "C:\\Users\\james\\Documents\\2y1 Activities\\OOP Projects\\ElCoco\\src\\reports\\BetweenDatesReport.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(r);
            
            //get dates
            
            System.out.println(from);
            System.out.println(to);
            
            //get sum of amount due
            double total = 0.0;
            for (int ix = 0; ix < salesReportTable.getRowCount(); ix++){
                double amount = Double.parseDouble(salesReportTable.getValueAt(ix, 5).toString());
                total += amount;
            }
            System.out.println(total);
            
            HashMap<String, Object> p = new HashMap<String, Object>();
            p.put("FROM_DATE", from);
            p.put("TO_DATE", to);
            p.put("TOTAL_AMOUNT", total);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, p, ds);
            
            JasperViewer.viewReport(jp, false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
       
       }
       
    }//GEN-LAST:event_allSalesBtn2ActionPerformed

    private void lastWeekSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastWeekSalesActionPerformed
        
        try {
            
            String query = "SELECT * FROM sales_transactions WHERE WEEKOFYEAR(date)=WEEKOFYEAR(CURDATE())-1" ;
            PreparedStatement pst = DBConnector.mycon().prepareStatement(query);
            
            ResultSet rs = pst.executeQuery(query);
            
            salesReportTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            System.out.println(rs);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            
            DefaultTableModel model = (DefaultTableModel) salesReportTable.getModel();
            JRTableModelDataSource ds = new JRTableModelDataSource(model);
            String r = "C:\\Users\\james\\Documents\\2y1 Activities\\OOP Projects\\ElCoco\\src\\reports\\LastWeekSales1.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(r);
            
            //last week date
            Date date = new Date();
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
            c.add(Calendar.DATE, -i - 7);
            Date start = c.getTime();
            c.add(Calendar.DATE, 6);
            Date end = c.getTime();
            
            //get sum of amount due
            double total = 0.0;
            for (int ix = 0; ix < salesReportTable.getRowCount(); ix++){
                double amount = Double.parseDouble(salesReportTable.getValueAt(ix, 5).toString());
                total += amount;
            }
            System.out.println(total);
            
            HashMap<String, Object> p = new HashMap<String, Object>();
            p.put("FROM_DATE", start);
            p.put("TO_DATE", end);
            p.put("TOTAL_AMOUNT", total);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, p, ds);
            
            JasperViewer.viewReport(jp, false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
    }//GEN-LAST:event_lastWeekSalesActionPerformed

    private void thisMonthSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thisMonthSalesActionPerformed
        try {
            
            String query = "SELECT * FROM sales_transactions WHERE  date between  DATE_FORMAT(CURDATE() ,'%Y-%m-01') AND CURDATE()" ;
            PreparedStatement pst = DBConnector.mycon().prepareStatement(query);
            
            ResultSet rs = pst.executeQuery(query);
            
            salesReportTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            System.out.println(rs);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            
            DefaultTableModel model = (DefaultTableModel) salesReportTable.getModel();
            JRTableModelDataSource ds = new JRTableModelDataSource(model);
            String r = "C:\\Users\\james\\Documents\\2y1 Activities\\OOP Projects\\ElCoco\\src\\reports\\LastMonthSalesReport.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(r);
            
            //get this month
            YearMonth thisMonth    = YearMonth.now();
            DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            String thisMonth1 = thisMonth.format(monthYearFormatter);
            
            //get sum of amount due
            double total = 0.0;
            for (int ix = 0; ix < salesReportTable.getRowCount(); ix++){
                double amount = Double.parseDouble(salesReportTable.getValueAt(ix, 5).toString());
                total += amount;
            }
            System.out.println(total);
            
            HashMap<String, Object> p = new HashMap<String, Object>();
            p.put("THIS_MONTH", thisMonth1);
            p.put("TOTAL_AMOUNT", total);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, p, ds);
            
            JasperViewer.viewReport(jp, false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_thisMonthSalesActionPerformed

    private void thisYearSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thisYearSalesActionPerformed
         try {
            
            String query = "SELECT * FROM sales_transactions WHERE  date between  DATE_FORMAT(CURDATE() ,'%Y-01-01') AND CURDATE()";
            PreparedStatement pst = DBConnector.mycon().prepareStatement(query);
            
            ResultSet rs = pst.executeQuery(query);
            
            salesReportTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            System.out.println(rs);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            
            DefaultTableModel model = (DefaultTableModel) salesReportTable.getModel();
            JRTableModelDataSource ds = new JRTableModelDataSource(model);
            String r = "C:\\Users\\james\\Documents\\2y1 Activities\\OOP Projects\\ElCoco\\src\\reports\\ThisYearSalesReport.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(r);
            
            //get this year
            int year = Calendar.getInstance().get(Calendar.YEAR);
            String curyear = String.valueOf(year);
            
            //get sum of amount due
            double total = 0.0;
            for (int ix = 0; ix < salesReportTable.getRowCount(); ix++){
                double amount = Double.parseDouble(salesReportTable.getValueAt(ix, 5).toString());
                total += amount;
            }
            System.out.println(total);
            
            HashMap<String, Object> p = new HashMap<String, Object>();
            p.put("THIS_YEAR", curyear);
            p.put("TOTAL_AMOUNT", total);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, p, ds);
            
            JasperViewer.viewReport(jp, false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_thisYearSalesActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        salesReportTable.setModel(new DefaultTableModel(null, new String[]{"Invoice ID", "STransactions ID", "Customer ID", "Customer Name", "Total Quantity", "Amount Due", "Status", "Change_Balance", "Delivery Type", "Mode of Payment", "Date"}));
        setRecordsToTable();
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void listOfUnpaidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOfUnpaidActionPerformed
        try{
           String query = "SELECT * FROM sales_transactions WHERE status = 'Unpaid' ";
           PreparedStatement pst = DBConnector.mycon().prepareStatement(query);
           
           ResultSet rs = pst.executeQuery(query);
           
           salesReportTable.setModel(DbUtils.resultSetToTableModel(rs));
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(this, e);
       }
       
        try{
            
            DefaultTableModel model = (DefaultTableModel) salesReportTable.getModel();
            JRTableModelDataSource ds = new JRTableModelDataSource(model);
            String r = "C:\\Users\\james\\Documents\\2y1 Activities\\OOP Projects\\ElCoco\\src\\reports\\ListOfUnpaidReport.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(r);
            
            //get sum of amount due
            double total = 0.0;
            for (int ix = 0; ix < salesReportTable.getRowCount(); ix++){
                double amount = Double.parseDouble(salesReportTable.getValueAt(ix, 5).toString());
                total += amount;
            }
            System.out.println(total);
            
            HashMap<String, Object> p = new HashMap<String, Object>();
            
            p.put("TOTAL_AMOUNT", total);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, p, ds);
            
            JasperViewer.viewReport(jp, false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_listOfUnpaidActionPerformed

    private void listOfUnpaid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOfUnpaid1ActionPerformed
        try{
           String query = "SELECT * FROM sales_transactions WHERE status = 'Partially Paid' ";
           PreparedStatement pst = DBConnector.mycon().prepareStatement(query);
           
           ResultSet rs = pst.executeQuery(query);
           
           salesReportTable.setModel(DbUtils.resultSetToTableModel(rs));
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(this, e);
       }
       
        try{
            
            DefaultTableModel model = (DefaultTableModel) salesReportTable.getModel();
            JRTableModelDataSource ds = new JRTableModelDataSource(model);
            String r = "C:\\Users\\james\\Documents\\2y1 Activities\\OOP Projects\\ElCoco\\src\\reports\\ListOfPartiallyPaidReport.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(r);
            
            //get this year
            int year = Calendar.getInstance().get(Calendar.YEAR);
            String curyear = String.valueOf(year);
            
            //get sum of amount due
            double total = 0.0;
            for (int ix = 0; ix < salesReportTable.getRowCount(); ix++){
                double amount = Double.parseDouble(salesReportTable.getValueAt(ix, 7).toString());
                total += amount;
            }
            
            double newTotal = total * -1 ;
            System.out.println(newTotal);
            
            HashMap<String, Object> p = new HashMap<String, Object>();
            p.put("TOTAL_AMOUNT", newTotal);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, p, ds);
            
            JasperViewer.viewReport(jp, false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }//GEN-LAST:event_listOfUnpaid1ActionPerformed

    private void PreviousMonthSalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousMonthSalesActionPerformed
        try {
            
            String query = "SELECT * FROM  sales_transactions WHERE MONTH( DATE ) = MONTH( DATE_SUB(CURDATE(),INTERVAL 1 MONTH )) \n" +
                            "AND \n" +
                            "YEAR( DATE ) = YEAR( DATE_SUB(CURDATE( ),INTERVAL 1 MONTH ));" ;
            PreparedStatement pst = DBConnector.mycon().prepareStatement(query);
            
            ResultSet rs = pst.executeQuery(query);
            
            salesReportTable.setModel(DbUtils.resultSetToTableModel(rs));
            
            System.out.println(rs);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            
            DefaultTableModel model = (DefaultTableModel) salesReportTable.getModel();
            JRTableModelDataSource ds = new JRTableModelDataSource(model);
            String r = "C:\\Users\\james\\Documents\\2y1 Activities\\OOP Projects\\ElCoco\\src\\reports\\PreviousMonthSalesReport.jrxml";
            
            JasperReport jr = JasperCompileManager.compileReport(r);
            
            //get last month
            YearMonth thisMonth    = YearMonth.now();
            YearMonth lastMonth    = thisMonth.minusMonths(1);
            DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            String lastMonth1 = lastMonth.format(monthYearFormatter);
            
            //get sum of amount due
            double total = 0.0;
            for (int ix = 0; ix < salesReportTable.getRowCount(); ix++){
                double amount = Double.parseDouble(salesReportTable.getValueAt(ix, 5).toString());
                total += amount;
            }
            System.out.println(total);
            
            HashMap<String, Object> p = new HashMap<String, Object>();
            p.put("LAST_MONTH", lastMonth1);
            p.put("TOTAL_AMOUNT", total);
            
            JasperPrint jp = JasperFillManager.fillReport(jr, p, ds);
            
            JasperViewer.viewReport(jp, false);
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_PreviousMonthSalesActionPerformed

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
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PreviousMonthSales;
    private javax.swing.JButton allSalesBtn1;
    private javax.swing.JButton allSalesBtn2;
    private javax.swing.JButton editBtn1;
    private com.toedter.calendar.JDateChooser fromDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lastWeekSales;
    private javax.swing.JButton listOfUnpaid;
    private javax.swing.JButton listOfUnpaid1;
    private javax.swing.JButton refreshBtn;
    public javax.swing.JTable salesReportTable;
    private javax.swing.JButton thisMonthSales;
    private javax.swing.JButton thisYearSales;
    private com.toedter.calendar.JDateChooser toDate;
    // End of variables declaration//GEN-END:variables
}