/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.DbUtil;

/**
 *
 * @author thatsnajmul
 */

    //=====================================================//
    //Here ProductView extends Swing design
    //====================================================//
    
    public class PrductView extends javax.swing.JFrame {
        
    //=====================================================//
    //Db util object
    //====================================================//

    DbUtil db = new DbUtil();

    /**
     * Creates new form PrductView
     */
    
    
    
    
    
    
    //=====================================================//
    //Constractor and declare method start
    //====================================================//
    public PrductView() {
        initComponents();
        showProductOntable();
        showProductToCombo();
        
        comProductName.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                getProdutSalesPrice(e);
            }
        });
        
    }
    //=====================================================//
    //Constractor and declare method end
    //====================================================//
    
    
    
    
    //=====================================================//
    //ADD Product to the sql product table using select 
    //statement and push the user data to the database (start)
    //====================================================//
    //Addproduct with database
    public void addProduct() {

        String sql = "insert into product(name, unitPrice,quantity,totalPrice,salesPrice) values(?,?,?,?,?)";

        PreparedStatement ps;

        try {
            ps = db.getCon().prepareStatement(sql);
            ps.setString(1, txtName.getText().trim());
            ps.setFloat(2, Float.parseFloat(txtUnitPrice.getText().trim()));
            ps.setFloat(3, Float.parseFloat(txtQuantity.getText().trim()));
            ps.setFloat(4, Float.parseFloat(txtTotalPrice.getText().trim()));
            ps.setFloat(5, Float.parseFloat(txtSalesPrice.getText().trim()));

            ps.executeUpdate();
            ps.close();
            db.getCon().close();

            JOptionPane.showMessageDialog(this, "Product added successfully");
            clear(); //
            showProductOntable();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Product is not added successfully");
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Product added successfully");
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //=====================================================//
    //ADD Product to the sql product table using select 
    //statement and push the user data to the database (end)
    //====================================================//
    
    
    
    //=====================================================//
    //When user put the quentity in the box that multiply 
    //and show the total price box (start)
    //====================================================//
    //another method
    //==================
    public void getTotalPrice() {
        float unitPrice = Float.parseFloat(txtUnitPrice.getText().trim());
        float quantity = Float.parseFloat(txtQuantity.getText().trim());

        float totalPrice = unitPrice * quantity;

        txtTotalPrice.setText(totalPrice + ""); //ques
    }
    //=====================================================//
    //When user put the quentity in the box that multiply 
    //and show the total price box (end)
    //====================================================//
    
    
    
    
    //=====================================================//
    //When user save/insert the data automitically blank all box
    //that name is add product (start)
    //====================================================//
    //clear
    public void clear() {
        txtId.setText("");
        txtName.setText("");
        txtUnitPrice.setText("");
        txtQuantity.setText("");
        txtTotalPrice.setText("");
        txtSalesPrice.setText("");

    }
    //=====================================================//
    //When user save/insert the data automitically blank all box
    //that name is add product (end)
    //====================================================//
    
    
    
    
    //=====================================================//
    //Here we change swing GUI table name programitically
    //that already declare on the Swing GUI control interface (start)
    //We can write the line on the specific method
    //====================================================//
    //Table View change
    String[] productViewTableColumn = {"Id", "Name", "Unit Price", "Quantity", "Total Price", "Sales Price"};
    //=====================================================//
    //Here we change swing GUI table name programitically
    //that already declare on the Swing GUI control interface (end)
    //We can write the line on the specific method
    //====================================================//
    
    
    
    //=====================================================//
    //We insert/throw the data to the database from user input
    //We are already create a table and name the name programiticcally
    //Now we show the data on the table (start)
    //====================================================//
    //show product data
    public void showProductOntable() {
        String sql = "select * from product";
        PreparedStatement ps;
        ResultSet rs;

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(productViewTableColumn);

        tblProductView.setModel(model);

        try {
            ps = db.getCon().prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float quantity = rs.getFloat("quantity");
                float unitPrice = rs.getFloat("unitPrice");
                float totalPrice = rs.getFloat("totalPrice");
                float salesPrice = rs.getFloat("salesPrice");

                model.addRow(new Object[]{id, name, quantity, unitPrice, totalPrice, salesPrice});

            }

            ps.close();
            db.getCon().close();
            rs.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //=====================================================//
    //We insert/throw the data to the database from user input
    //We are already create a table and name the name programiticcally
    //Now we show the data on the table (end)
    //====================================================//
    
    
    
    //=====================================================//
    //We insert/throw the data to the database from user input
    //We are already create a table and name the name programiticcally
    //Now we show the data on the table
    //Now we want to delete the row from the database using(sql unique id) 
    //when we clicked the delete button (start)
    //====================================================//
    //Delete product  
    public void deleteProduct(){
        String sql = "delete from product where id=?";
        PreparedStatement ps;
        
        try {
            ps=db.getCon().prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ps.executeUpdate();
            
            ps.close();
            db.getCon().close();
            
            JOptionPane.showMessageDialog(this, "Product deleted successfully");
            clear(); //
            showProductOntable();
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Product is not deleted successfully");
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Product is not deleted successfully");
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    //=====================================================//
    //We insert/throw the data to the database from user input
    //We are already create a table and name the name programiticcally
    //Now we show the data on the table
    //Now we want to delete the row from the database using(sql unique id) 
    //when we clicked the delete button (start)
    //====================================================//
    
    
     //=====================================================//
    //We insert/throw the data to the database from user input
    //We are already create a table and name the name programiticcally
    //Now we show the data on the table
    //Now we want to delete the row from the database using(sql unique id) 
    //when we clicked the delete button
    //now we update/edit the data using update.execute query
    //and then show again to the database (start)
    //====================================================//
    //Edit Product
    public void editProduct(){
        String sql = "update product set name=?, unitPrice=?, quantity=?, totalPrice=?, salesPrice=? where id=?";
        PreparedStatement ps;
        try {
            ps=db.getCon().prepareStatement(sql);
            
            ps.setString(1, txtName.getText().trim());
            ps.setFloat(2, Float.parseFloat(txtUnitPrice.getText().trim()));
            ps.setFloat(3, Float.parseFloat(txtQuantity.getText().trim()));
            ps.setFloat(4, Float.parseFloat(txtTotalPrice.getText().trim()));
            ps.setFloat(5, Float.parseFloat(txtSalesPrice.getText().trim()));
            ps.setInt(6, Integer.parseInt(txtId.getText())); //Ques
            
            ps.executeUpdate();
            
            ps.close();
            db.getCon().close();
            
            JOptionPane.showMessageDialog(this, "Product updated successfully");
            clear(); //
            showProductOntable();
            
            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Product is not updated successfully");
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Product is not updated successfully");
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    //=====================================================//
    //We insert/throw the data to the database from user input
    //We are already create a table and name the name programiticcally
    //Now we show the data on the table
    //Now we want to delete the row from the database using(sql unique id) 
    //when we clicked the delete button
    //now we update/edit the data using update.execute query
    //and then show again to the database (end)
    //====================================================//
    
    
    //=====================================================//
    //We insert/throw the data to the database from user input
    //We are already create a table and name the name programiticcally
    //Now we show the data on the table
    //Now we want to delete the row from the database using(sql unique id) 
    //when we clicked the delete button
    //now we update/edit the data using update.execute query
    //and then show again to the database
    
    //------------------
    //====================================================//
    //Show Product Item    
    public void showProductToCombo() {
        String sql = "select name from product";
        PreparedStatement ps;
        ResultSet rs;
        
        comProductName.removeAllItems();
        
        try {
            ps=db.getCon().prepareStatement(sql);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                String productName=rs.getString("name");
                comProductName.addItem(productName);
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    //=====================================================//
    //We insert/throw the data to the database from user input
    //We are already create a table and name the name programiticcally
    //Now we show the data on the table
    //Now we want to delete the row from the database using(sql unique id) 
    //when we clicked the delete button
    //now we update/edit the data using update.execute query
    //and then show again to the database
    
    //------------------
    //====================================================//


//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//++++++++++++--------------------------------------++++++++++++++++++++++++++++    
    
    //=====================================================//
    //We insert/throw the data to the database from user input
    //We are already create a table and name the name programiticcally
    //Now we show the data on the table
    //Now we want to delete the row from the database using(sql unique id) 
    //when we clicked the delete button
    //now we update/edit the data using update.execute query
    //and then show again to the database
    //when we select any product bellow the method return selected (start)
    //====================================================//
    //Product Sales Price    
    public void getProdutSalesPrice(ItemEvent e){
        String selectedProductName = "";
        if(e.getStateChange() == ItemEvent.SELECTED) {
            selectedProductName = (String) e.getItem();
            
            extractSalesPrice(selectedProductName);
        }
    }
    //=====================================================//
    //We insert/throw the data to the database from user input
    //We are already create a table and name the name programiticcally
    //Now we show the data on the table
    //Now we want to delete the row from the database using(sql unique id) 
    //when we clicked the delete button
    //now we update/edit the data using update.execute query
    //and then show again to the database
    //when we select any product bellow the method return selected (end)
    //====================================================//
    
    
    
    
    
    
    //+++++++++++++++++++++++Need Explain
    //++++++++++++++++++++++++++++++++
    
    //Extract 
    public void extractSalesPrice(String productName){
        String sql="select salesPrice from product where name=?";
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps=db.getCon().prepareStatement(sql);
            
            ps.setString(1, productName);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                String salesPrice=rs.getString("salesPrice");
                txtSalesUnitPrice.setText(salesPrice);
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //Calculate total sales price
    public void getTotalSalesPrice(){
        float quantity=Float.parseFloat(txtSalesQuantity.getText().toString().trim());
        float unitPrice=Float.parseFloat(txtSalesUnitPrice.getText().toString().trim());
        
        float salesTotPrice=quantity*unitPrice;
        
        txtSalesTotalPrice.setText(salesTotPrice+""); //Ques
        
    }
    
    
    //For Date
    public String formatDateToDDMMYYYY(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
        return dateFormat.format(date);
    
    }
    
    //
    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date UtitDate){
        if (UtitDate != null) {
            return new java.sql.Date(UtitDate.getTime());
        }
        
        return null; //Ques for null
    }
    
    
    //AddSales
    public void addSales() {
        
        //Date date = convertUtilDateToSqlDate(salesDate.getDate());
        Date date = convertUtilDateToSqlDate(salesDate.getDate());
        
        PreparedStatement ps;
        String sql ="insert into sales(name,salesUnitPrice, salesQuantity, salesTotalPrice, "
                + "salesDate) values (?,?,?,?,?)";
        
        try {
            ps = db.getCon().prepareStatement(sql);
            
            ps.setString(1, comProductName.getSelectedItem().toString());
            ps.setFloat(2, Float.parseFloat(txtSalesUnitPrice.getText()));
            ps.setFloat(3, Float.parseFloat(txtSalesQuantity.getText()));
            ps.setFloat(4, Float.parseFloat(txtSalesTotalPrice.getText()));
            ps.setDate(5, convertUtilDateToSqlDate(date));
            
            
            ps.executeUpdate();
            db.getCon().close();
            JOptionPane.showMessageDialog(this, "Product sales added successfully");
            
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Product sales is not added successfully");
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Product is not ddded successfully");
            Logger.getLogger(PrductView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
     //+++++++++++++++++++++++Need Explain
    //++++++++++++++++++++++++++++++++

    
    
    
   
    
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++Swing GUI priavte variable that we declare frontend(start)+++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAddPrduct = new javax.swing.JButton();
        btnSalesPrduct = new javax.swing.JButton();
        btnStock = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        mainView = new javax.swing.JTabbedPane();
        add = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtUnitPrice = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSalesPrice = new javax.swing.JTextField();
        btnProductAdd = new javax.swing.JButton();
        btnProductDelete = new javax.swing.JButton();
        btnProductUpdate = new javax.swing.JButton();
        btnProductReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductView = new javax.swing.JTable();
        sales = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        comProductName = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtSalesQuantity = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtSalesUnitPrice = new javax.swing.JTextField();
        txtSalesTotalPrice = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnSalesSave = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        salesDate = new com.toedter.calendar.JDateChooser();
        stock = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        report = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SHOP");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 110));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 110));

        jPanel1.setBackground(new java.awt.Color(255, 204, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAddPrduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAddPrduct.setText("ADD PRODUCT");
        btnAddPrduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddPrductMouseClicked(evt);
            }
        });
        btnAddPrduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPrductActionPerformed(evt);
            }
        });
        jPanel1.add(btnAddPrduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 208, 40));

        btnSalesPrduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalesPrduct.setText("SALES PRODUCT");
        btnSalesPrduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalesPrductMouseClicked(evt);
            }
        });
        btnSalesPrduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesPrductActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalesPrduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 64, 208, 37));

        btnStock.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnStock.setText("STOCK");
        btnStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStockMouseClicked(evt);
            }
        });
        jPanel1.add(btnStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 119, 208, 40));

        btnReport.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnReport.setText("REPORT");
        btnReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportMouseClicked(evt);
            }
        });
        jPanel1.add(btnReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 177, 208, 41));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 220, 490));

        add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(153, 255, 0));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ADD PRODUCT");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 6, 780, 60));

        add.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 70));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("ID: ");
        add.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 20, 30));

        txtId.setEditable(false);
        txtId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        add.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 160, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("NAME:");
        add.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 40, 30));

        txtName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 160, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("UNIT PRICE");
        add.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 70, 30));

        txtUnitPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add.add(txtUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 160, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("QUANTITY:");
        add.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 70, 30));

        txtQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQuantityFocusLost(evt);
            }
        });
        add.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 160, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("TOTAL PRICE:");
        add.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 80, 30));

        txtTotalPrice.setEditable(false);
        txtTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add.add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 160, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("SALES PRICE:");
        add.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 80, 30));

        txtSalesPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add.add(txtSalesPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 160, 30));

        btnProductAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProductAdd.setText("ADD");
        btnProductAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductAddMouseClicked(evt);
            }
        });
        add.add(btnProductAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 110, 50));

        btnProductDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProductDelete.setText("DELETE");
        btnProductDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductDeleteMouseClicked(evt);
            }
        });
        add.add(btnProductDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 110, 50));

        btnProductUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProductUpdate.setText("UPDATE");
        btnProductUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductUpdateMouseClicked(evt);
            }
        });
        add.add(btnProductUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 110, 50));

        btnProductReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnProductReset.setText("RESET");
        btnProductReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductResetMouseClicked(evt);
            }
        });
        add.add(btnProductReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 110, 50));

        tblProductView.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tblProductView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblProductView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductViewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductView);

        add.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 490, 380));

        mainView.addTab("ADD", add);

        sales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(51, 255, 51));

        jLabel3.setBackground(new java.awt.Color(102, 255, 51));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PRODUCT SALES");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        sales.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 60));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("PRODUCT NAME");
        sales.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 20));

        comProductName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comProductName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comProductNameActionPerformed(evt);
            }
        });
        sales.add(comProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 160, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("QUANTITY");
        sales.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, -1, -1));

        txtSalesQuantity.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtSalesQuantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSalesQuantityFocusLost(evt);
            }
        });
        sales.add(txtSalesQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 150, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("DATE");
        sales.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("UNIT PRICE");
        sales.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        txtSalesUnitPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sales.add(txtSalesUnitPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 160, -1));

        txtSalesTotalPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sales.add(txtSalesTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 150, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("TOTAL PRICE");
        sales.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, -1, -1));

        btnSalesSave.setBackground(new java.awt.Color(102, 255, 51));
        btnSalesSave.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSalesSave.setText("SAVE");
        btnSalesSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalesSaveMouseClicked(evt);
            }
        });
        btnSalesSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalesSaveActionPerformed(evt);
            }
        });
        sales.add(btnSalesSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 80, 40));

        jButton2.setBackground(new java.awt.Color(102, 255, 51));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("EDIT");
        sales.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 80, 40));

        jButton3.setBackground(new java.awt.Color(102, 255, 51));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("RESET");
        sales.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 80, 40));

        jButton4.setBackground(new java.awt.Color(102, 255, 51));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("DELETE");
        sales.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 80, 40));
        sales.add(salesDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 150, -1));

        mainView.addTab("SALES", sales);

        stock.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 204, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("STOCK");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                .addContainerGap())
        );

        stock.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblStock);

        stock.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 780, 340));

        mainView.addTab("STOCK", stock);

        jLabel5.setText("report");

        javax.swing.GroupLayout reportLayout = new javax.swing.GroupLayout(report);
        report.setLayout(reportLayout);
        reportLayout.setHorizontalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportLayout.createSequentialGroup()
                .addContainerGap(390, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(357, 357, 357))
        );
        reportLayout.setVerticalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportLayout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(jLabel5)
                .addContainerGap(292, Short.MAX_VALUE))
        );

        mainView.addTab("REPORT", report);

        getContentPane().add(mainView, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 780, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddPrductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPrductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddPrductActionPerformed

    private void btnSalesPrductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesPrductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalesPrductActionPerformed

    //ADD Button
    private void btnAddPrductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddPrductMouseClicked
        // TODO add your handling code here:

        mainView.setSelectedIndex(0);
    }//GEN-LAST:event_btnAddPrductMouseClicked

    //SALES Button
    private void btnSalesPrductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalesPrductMouseClicked
        // TODO add your handling code here:
        mainView.setSelectedIndex(1);
        
        showProductToCombo();
    }//GEN-LAST:event_btnSalesPrductMouseClicked

    //STOCK Button
    private void btnStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStockMouseClicked
        // TODO add your handling code here:
        mainView.setSelectedIndex(2);
    }//GEN-LAST:event_btnStockMouseClicked

    //REPORT Button
    private void btnReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportMouseClicked
        // TODO add your handling code here:
        mainView.setSelectedIndex(3);
    }//GEN-LAST:event_btnReportMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnProductAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductAddMouseClicked
        // TODO add your handling code here:

        addProduct();
    }//GEN-LAST:event_btnProductAddMouseClicked

    private void txtQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantityFocusLost
        // TODO add your handling code here:

        getTotalPrice();
        


    }//GEN-LAST:event_txtQuantityFocusLost

    private void btnProductResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductResetMouseClicked
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnProductResetMouseClicked
    
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++Call the event (start)+++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //Product view before update/edit and save to the database
    private void tblProductViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductViewMouseClicked
        // TODO add your handling code here:

        int rowIndex = tblProductView.getSelectedRow();

        String id = tblProductView.getModel().getValueAt(rowIndex, 0).toString();
        String name = tblProductView.getModel().getValueAt(rowIndex, 1).toString();
        String unitPrice = tblProductView.getModel().getValueAt(rowIndex, 2).toString();
        String quentity = tblProductView.getModel().getValueAt(rowIndex, 3).toString();
        String totalPrice = tblProductView.getModel().getValueAt(rowIndex, 4).toString();
        String salesPrice = tblProductView.getModel().getValueAt(rowIndex, 5).toString();

        txtId.setText(id);
        txtName.setText(name);
        txtUnitPrice.setText(unitPrice);
        txtQuantity.setText(quentity);
        txtTotalPrice.setText(totalPrice);
        txtSalesPrice.setText(salesPrice);
    }//GEN-LAST:event_tblProductViewMouseClicked
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++Call end=nt(end)+++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    
    private void btnProductDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductDeleteMouseClicked
        // TODO add your handling code here:
        deleteProduct();
    }//GEN-LAST:event_btnProductDeleteMouseClicked

    private void btnProductUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductUpdateMouseClicked
        // TODO add your handling code here:
        editProduct();
    }//GEN-LAST:event_btnProductUpdateMouseClicked

    private void comProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comProductNameActionPerformed

    private void btnSalesSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalesSaveActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnSalesSaveActionPerformed

    private void txtSalesQuantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSalesQuantityFocusLost
        // TODO add your handling code here:
        getTotalSalesPrice();
    }//GEN-LAST:event_txtSalesQuantityFocusLost

    private void btnSalesSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalesSaveMouseClicked
        // TODO add your handling code here:
        
        addSales();
    }//GEN-LAST:event_btnSalesSaveMouseClicked
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++Swing GUI priavte variable that we declare frontend(end)+++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//    
    
    
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++Main method(start)++++++++++++++++++++++++++++++//
    //++++++++When we run the class may be it's create runnable++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrductView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrductView().setVisible(true);
            }
        });
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++Main method(end)++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//

    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++All Swing Variable(Start++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel add;
    private javax.swing.JButton btnAddPrduct;
    private javax.swing.JButton btnProductAdd;
    private javax.swing.JButton btnProductDelete;
    private javax.swing.JButton btnProductReset;
    private javax.swing.JButton btnProductUpdate;
    private javax.swing.JButton btnReport;
    private javax.swing.JButton btnSalesPrduct;
    private javax.swing.JButton btnSalesSave;
    private javax.swing.JButton btnStock;
    private javax.swing.JComboBox<String> comProductName;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane mainView;
    private javax.swing.JPanel report;
    private javax.swing.JPanel sales;
    private com.toedter.calendar.JDateChooser salesDate;
    private javax.swing.JPanel stock;
    private javax.swing.JTable tblProductView;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtSalesPrice;
    private javax.swing.JTextField txtSalesQuantity;
    private javax.swing.JTextField txtSalesTotalPrice;
    private javax.swing.JTextField txtSalesUnitPrice;
    private javax.swing.JTextField txtTotalPrice;
    private javax.swing.JTextField txtUnitPrice;
    // End of variables declaration//GEN-END:variables
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++All Swing Variable(End)+++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++//
    
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //unused method
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private String formatDateToDDMMYYYY(JDateChooser salesDate) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private float convertUtilDateToSqlDate(String date) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //unused method
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    
    
    
}
