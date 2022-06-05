/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ViewFrame;

import com.Controllers.DepartmentControllers.DepartmentController;
import com.Controllers.EmployeeControllers.EmployeeController;
import com.Models.DepartmentModels.DepartmentModel;
import com.Models.EmployeeModels.EmployeeModel;
import java.awt.Dimension;
import java.awt.Toolkit;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


//import java.awt.print.PrinterAbortException;
import java.awt.print.PrinterException;
/**
 *
 * @author pv
 */
public class AdminDetailFrame extends javax.swing.JFrame {

    /**
     * Creates new form AdminDetailFrame
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public AdminDetailFrame() throws SQLException, ClassNotFoundException {
        super("Admin detail");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        this.setSize(width, height);
        initComponents();

        //show department id
        detailDepartment();
        loadData();
        
        this.pack();
        this.setVisible(true);
    }
    private void detailDepartment() throws SQLException, ClassNotFoundException {
        DepartmentController department = new DepartmentController();
        for (DepartmentModel dpmodel : department.loadData()) {
            cBDepartmentid.addItem(dpmodel.getId_department());
        }
    }
    

    private void loadData() throws SQLException, ClassNotFoundException {
        EmployeeController employee = new EmployeeController();
        DefaultTableModel TableModel = (DefaultTableModel) tbEmployee.getModel();
        for(EmployeeModel employees : employee.detailEmployee()){
             String[] row = new String[]{
                    String.valueOf(TableModel.getRowCount() + 1),
                    employees.get_idEmployee(),
                    employees.get_nameEmployee(),
                    employees.get_sexEmployee(),
                    employees.get_dateEmployee(),                 
                    employees.get_addressEmployee(),
                    employees.get_phoneEmployee(),
                    employees.get_passportIdEmployee(),
                    employees.get_emailEmployee(),
                    employees.get_positionEmployee(),
                    employees.get_degreeEmployee(),
                    String.valueOf(employees.get_rolesEmployee()),
                    employees.get_specializedEmployee(),
                    //  get Name department into department ID using JOIN operator
                    employees.get_departmentIdEmployee(),
                    employees.get_passwordEmployee()
            };
             TableModel.addRow(row);
        }
    }
    
    public void insertData() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeModel> employeeModelList = new ArrayList<>();

        String id, name, sex, date, address, phone, passport, email, position, degree, specialize, department, password;
        int roles;
        
        id = "emp" + jTFId.getText().trim();
        name = String.valueOf(jTFName.getText().trim());
        sex = String.valueOf(jSex.getSelectedItem());
        date = String.valueOf(cBYear.getSelectedItem() + "-" + cBMonth.getSelectedItem() + "-" + cBDay.getSelectedItem());
        address = jTALocation.getText().trim();
        phone = jTFPhone.getText().trim();
        passport = jTFPassport.getText().trim();
        email = jTFEmail.getText().trim();
        position = String.valueOf(jTFPosition.getText().trim());
        degree = String.valueOf(jTFDegree.getText().trim());
        specialize = String.valueOf(jTFSpecialized.getText().trim());
        roles = Integer.parseInt(String.valueOf(cBRoles.getSelectedItem()));
        department = (String) cBDepartmentid.getSelectedItem();
        password = jPs.getText().trim();

        EmployeeModel insert = new EmployeeModel(
                id,
                name,
                sex,
                date,
                address,
                phone,
                passport,
                email,
                position,
                degree,
                roles,
                specialize,
                department,
                password);

        employeeModelList.add(insert);
        EmployeeController insertDB = new EmployeeController();

        insertDB.insertEmployee(employeeModelList);
        loadData();
    }
    
     public void UpdateData() throws SQLException, ClassNotFoundException{
         ArrayList<EmployeeModel> employeeModelList = new ArrayList<>();
         
        String id, name, sex, date, address, phone, passport, email, position, degree, specialize, department, password;
        int roles;
        
        id = jTFId.getText().trim();
        name = String.valueOf(jTFName.getText().trim());
        sex = String.valueOf(jSex.getSelectedItem());
        date = String.valueOf(cBYear.getSelectedItem() + "-" + cBMonth.getSelectedItem() + "-" + cBDay.getSelectedItem());
        address = jTALocation.getText().trim();
        phone = jTFPhone.getText().trim();
        passport = jTFPassport.getText().trim();
        email = jTFEmail.getText().trim();
        position = String.valueOf(jTFPosition.getText().trim());
        degree = String.valueOf(jTFDegree.getText().trim());
        specialize = String.valueOf(jTFSpecialized.getText().trim());
        roles = Integer.parseInt(String.valueOf(cBRoles.getSelectedItem()));
        department = (String.valueOf(cBDepartmentid.getSelectedItem()));
        password = jPs.getText().trim();
        
        EmployeeModel update = new EmployeeModel(
                id,
                name,
                sex,
                date,
                address,
                phone,
                passport,
                email,
                position,
                degree,
                roles,
                specialize,
                department,
                password);

        employeeModelList.add(update);
        
        EmployeeController UpdateDB = new EmployeeController();

        UpdateDB.updateEmployee(employeeModelList);
        loadData();
     }
    
    public void searchEmployees(String searchEmp) throws SQLException, ClassNotFoundException {

        EmployeeController employeeController = new EmployeeController();
        ArrayList<EmployeeModel> employeeModel = employeeController.searchEmployee(searchEmp);
        
        DefaultTableModel TableModel = (DefaultTableModel) tbEmployee.getModel();
        
        for (EmployeeModel employeeModels : employeeModel) {
            String[] row = new String[]{
                    String.valueOf(TableModel.getRowCount() + 1),
                    employeeModels.get_idEmployee(),
                    employeeModels.get_nameEmployee(),
                    employeeModels.get_sexEmployee(),
                    employeeModels.get_dateEmployee(),                 
                    employeeModels.get_addressEmployee(),
                    employeeModels.get_phoneEmployee(),
                    employeeModels.get_passportIdEmployee(),
                    employeeModels.get_emailEmployee(),
                    employeeModels.get_positionEmployee(),
                    employeeModels.get_degreeEmployee(),
                    String.valueOf(employeeModels.get_rolesEmployee()),
                    employeeModels.get_specializedEmployee(),
                    //  get Name department into department ID using JOIN operator
                    employeeModels.get_departmentIdEmployee(),
                    employeeModels.get_passwordEmployee()
            };
            TableModel.addRow(row);
        }
    }

    public void deleteEmployee() throws SQLException, ClassNotFoundException {
        
        String idDeleted = jTFId.getText();
        
        EmployeeController delete = new EmployeeController();
        delete.deleteEmployee(idDeleted);
        loadData();
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPanel = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jtFSearch = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        DetailPanel = new javax.swing.JPanel();
        AccountPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFId = new javax.swing.JTextField();
        jTFName = new javax.swing.JTextField();
        jSex = new javax.swing.JComboBox<>();
        cBDay = new javax.swing.JComboBox<>();
        cBMonth = new javax.swing.JComboBox<>();
        cBYear = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTALocation = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jTFPhone = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTFPassport = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTFPosition = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTFDegree = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTFSpecialized = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cBRoles = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jPs = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cBDepartmentid = new javax.swing.JComboBox<>();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmployee = new javax.swing.JTable();
        PanelPre = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTDetail = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btnInsert.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnInsert.setForeground(new java.awt.Color(0, 0, 0));
        btnInsert.setIcon(new javax.swing.ImageIcon("E:\\hi2nam4\\công nghệ phần mềm\\plus\\1x\\baseline_add_black_24dp.png")); // NOI18N
        btnInsert.setText("Thêm");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(0, 0, 0));
        btnBack.setIcon(new javax.swing.ImageIcon("E:\\hi2nam4\\công nghệ phần mềm\\black-24dp\\1x\\baseline_keyboard_return_black_24dp.png")); // NOI18N
        btnBack.setText("Trở về");
        btnBack.setActionCommand("");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon("E:\\hi2nam4\\công nghệ phần mềm\\print\\1x\\baseline_print_black_24dp.png")); // NOI18N
        jButton3.setText("In");
        jButton3.setActionCommand("");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(0, 0, 0));
        btnReset.setText("Làm mới");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jtFSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtFSearchKeyReleased(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(0, 0, 0));
        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tìm kiếm");

        btnDelete.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(0, 0, 0));
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(43, 43, 43)
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(btnPanelLayout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtFSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(btnPanelLayout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtFSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("Xin chào");

        javax.swing.GroupLayout AccountPanelLayout = new javax.swing.GroupLayout(AccountPanel);
        AccountPanel.setLayout(AccountPanelLayout);
        AccountPanelLayout.setHorizontalGroup(
            AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AccountPanelLayout.setVerticalGroup(
            AccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AccountPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        cBDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cBDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBDayActionPerformed(evt);
            }
        });

        cBMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cBMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBMonthActionPerformed(evt);
            }
        });

        cBYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022" }));
        cBYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBYearActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tên");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Giới tính");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Ngày sinh");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Địa chỉ");

        jTALocation.setColumns(20);
        jTALocation.setRows(5);
        jScrollPane2.setViewportView(jTALocation);

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Điện thoại");

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Cmnd");

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Email");

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Chức vụ");

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Trình độ");

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Chuyên ngành");

        jLabel15.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Roles");

        cBRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        cBRoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBRolesActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Password");

        jPs.setEditable(false);

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Id khoa");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cBDay, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cBMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cBYear, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSex, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFName)
                    .addComponent(jTFId)))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFPhone))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFPassport))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFEmail))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFPosition))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFDegree))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cBRoles, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFSpecialized)
                    .addComponent(jPs)
                    .addComponent(cBDepartmentid, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFId, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSex, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBDay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBYear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFPassport, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFDegree, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFSpecialized, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBDepartmentid, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout DetailPanelLayout = new javax.swing.GroupLayout(DetailPanel);
        DetailPanel.setLayout(DetailPanelLayout);
        DetailPanelLayout.setHorizontalGroup(
            DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AccountPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DetailPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DetailPanelLayout.setVerticalGroup(
            DetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DetailPanelLayout.createSequentialGroup()
                .addComponent(AccountPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Id", "Tên", "Giới tính", "Ngày sinh", "Địa chỉ", "Điện thoại", "Cmnd", "Email", "Chức vụ", "Trình độ", "Roles", "Chuyên ngành", "Tên khoa", "Password"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmployee);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );

        jTDetail.setEditable(false);
        jTDetail.setColumns(20);
        jTDetail.setRows(5);
        jScrollPane3.setViewportView(jTDetail);

        javax.swing.GroupLayout PanelPreLayout = new javax.swing.GroupLayout(PanelPre);
        PanelPre.setLayout(PanelPreLayout);
        PanelPreLayout.setHorizontalGroup(
            PanelPreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPreLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelPreLayout.setVerticalGroup(
            PanelPreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(DetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelPre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelPre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cBYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBYearActionPerformed
            // TODO add your handling code here:
        System.out.println("Select Year| " + cBYear.getSelectedItem());
    }//GEN-LAST:event_cBYearActionPerformed

    private void cBMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBMonthActionPerformed
        // TODO add your handling code here:
        System.out.println("Select Month| " + cBMonth.getSelectedItem());
    }//GEN-LAST:event_cBMonthActionPerformed

    private void cBRolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBRolesActionPerformed
        // TODO add your handling code here:
//        System.out.println("Select roles: " + cBRoles.getSelectedItem());
        java.util.Random random = new java.util.Random();
        if(cBRoles.getSelectedItem()== "1"){
            String randomPass = String.valueOf(random.nextInt(9999));
             jPs.setText(randomPass);
        }else{
            jPs.setText(" ");
        }
    }//GEN-LAST:event_cBRolesActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            DefaultTableModel TableModel = (DefaultTableModel) tbEmployee.getModel();
            int r = tbEmployee.getRowCount();
            while (r-- > 0) {            
                TableModel.removeRow(r);
            }         
            if(
                    jTFId.getText().equals("") || 
                    jTFName.getText().equals("") ||
                    jTFDegree.getText().equals("") ||
                    jTFEmail.getText().equals("") ||
                    jTFPassport.getText().equals("") ||
                    jTFPosition.getText().equals("") ||
                    jTFSpecialized.getText().equals("") ||
                    jTFPhone.getText().equals("") ||
                    jTALocation.getText().equals("")
                    ){
                javax.swing.JOptionPane.showMessageDialog(null, "Yêu cầu");
            }
            else{
                insertData();
                javax.swing.JOptionPane.showMessageDialog(null, "Thêm thành công");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        if(javax.swing.JOptionPane.showConfirmDialog(null, "Đăng xuất tài khoản", "Đăng xuất", javax.swing.JOptionPane.YES_NO_OPTION) == 0){
                new LoginFrame().setVisible(true);
                AdminDetailFrame.this.dispose();
        }
                
    }//GEN-LAST:event_btnBackActionPerformed
    // In danh sách
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            jTDetail.print();
        } catch (PrinterException ex) {
            Logger.getLogger(AdminDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        jTFId.setText(" ");
        jTFName.setText(" ");
        jTALocation.setText(" ");
        jTFPhone.setText(" ");
        jTFPassport.setText(" ");
        jTFEmail.setText(" ");
        jTFPosition.setText(" ");
        jTFDegree.setText(" ");
        jTFSpecialized.setText(" ");
        jPs.setText(" ");
        cBDay.setSelectedItem(String.valueOf(1));
        cBMonth.setSelectedItem(String.valueOf(1));
        cBYear.setSelectedItem(String.valueOf(2022));
        
    }//GEN-LAST:event_btnResetActionPerformed

    private void cBDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBDayActionPerformed
        // TODO add your handling code here:
        System.out.println("Select day|" + cBDay.getSelectedItem());
    }//GEN-LAST:event_cBDayActionPerformed

    private void tbEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmployeeMouseClicked
        // TODO add your handling code here:
        int index = tbEmployee.getSelectedRow();
//        System.out.println("id: " + tbEmployee.getValueAt(index, 1));
//        System.out.println("name: " + tbEmployee.getValueAt(index, 2));
//        System.out.println("giới tính: " + tbEmployee.getValueAt(index, 3));
//        System.out.println("ngày sinh: " + tbEmployee.getValueAt(index, 4));
//        System.out.println("địa chỉ: " + tbEmployee.getValueAt(index, 5));
//        System.out.println("số điện thoại: " + tbEmployee.getValueAt(index, 6));
//        System.out.println("cmnd: " + tbEmployee.getValueAt(index, 7));
//        System.out.println("emal: " + tbEmployee.getValueAt(index, 8));
//        System.out.println("chức vụ: " + tbEmployee.getValueAt(index, 9));
//        System.out.println("trình độ: " + tbEmployee.getValueAt(index, 10));
//        System.out.println("roles: " + tbEmployee.getValueAt(index, 11));
//        System.out.println("chuyên ngành: " + tbEmployee.getValueAt(index, 12));
//        System.out.println("mã khoa: " + tbEmployee.getValueAt(index, 13));
//        System.out.println("mật khẩu: " + tbEmployee.getValueAt(index, 14));
//        
//        
        jTDetail.setEditable(false);
        jTDetail.setText(" ");
        
        jTDetail.append(
               "\t\n\t THÔNG TIN NHÂN VIÊN \n"+
               "\nHỌ TÊN:\t\t" + tbEmployee.getValueAt(index, 2)+
               "\nGIỚI TÍNH:\t\t" + tbEmployee.getValueAt(index, 3)+
               "\nNGÀY SINH\t\t" + tbEmployee.getValueAt(index, 4)+
               "\nĐỊA CHỈ:\t\t" + tbEmployee.getValueAt(index, 5)+
               "\nSỐ ĐIỆN THOẠI:\t\t" + tbEmployee.getValueAt(index, 6)+
               "\nCMND\t\t" + tbEmployee.getValueAt(index, 7)+
               "\nEMAIL:\t\t" + tbEmployee.getValueAt(index, 8)+
               "\nCHỨC VỤ::\t\t" + tbEmployee.getValueAt(index, 9)+
               "\nTRÌNH ĐỘ:\t\t" + tbEmployee.getValueAt(index, 10)+
               "\nCHUYÊN NGÀNH:\t\t" + tbEmployee.getValueAt(index, 12)+
               "\nTÊN KHOA:\t\t" + tbEmployee.getValueAt(index, 13)
        );
        //spit date
        String date = String.valueOf(tbEmployee.getValueAt(index, 4));
        String[] dates = date.split("-");
        int[] dateInt = new int[dates.length];
        
        for(int i = 0; i < dates.length; i ++){
            dateInt[i] = Integer.parseInt(dates[i]);
        }
        
        String year = String.valueOf(dateInt[0]);
        String month = String.valueOf(dateInt[1]);
        String day = String.valueOf(dateInt[2]);
        //----------------
        System.out.println("year "+ year +" |month "+ month +" |day "+ day);

        // add into form
        
        jTFId.setText(String.valueOf(tbEmployee.getValueAt(index, 1)));
        jTFId.setEnabled(false);
        jTFName.setText(String.valueOf(tbEmployee.getValueAt(index, 2)));
        jTALocation.setText(String.valueOf(tbEmployee.getValueAt(index, 5)));
        jTFPhone.setText(String.valueOf(tbEmployee.getValueAt(index, 6)));
        jTFPassport.setText(String.valueOf(tbEmployee.getValueAt(index, 7)));
        jTFEmail.setText(String.valueOf(tbEmployee.getValueAt(index, 8)));
        //Chức vụ
        jTFPosition.setText(String.valueOf(tbEmployee.getValueAt(index, 9)));
        //Trình độ
        jTFDegree.setText(String.valueOf(tbEmployee.getValueAt(index, 10)));
        //Chuyên ngành
        jTFSpecialized.setText(String.valueOf(tbEmployee.getValueAt(index, 12)));
        jPs.setText(String.valueOf(tbEmployee.getValueAt(index, 14)));
        cBRoles.setSelectedItem(String.valueOf(tbEmployee.getValueAt(index, 11)));
        jSex.setSelectedItem(String.valueOf(tbEmployee.getValueAt(index, 3)));
        cBDay.setSelectedItem(day);
        cBMonth.setSelectedItem(month);
        cBYear.setSelectedItem(year);
        
    }//GEN-LAST:event_tbEmployeeMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        try {
            DefaultTableModel TableModel = (DefaultTableModel) tbEmployee.getModel();
            int r = tbEmployee.getRowCount();
            while (r-- > 0) {            
                TableModel.removeRow(r);
            }
            // TODO add your handling code here:
            if(javax.swing.JOptionPane.showConfirmDialog(null, "Bạn muốn thay đổi", "Cập nhập", javax.swing.JOptionPane.YES_NO_OPTION) == 0){           
                    UpdateData();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void jtFSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtFSearchKeyReleased
        // TODO add your handling code here:
        String searchTxt = jtFSearch.getText();
        DefaultTableModel TableModel = (DefaultTableModel) tbEmployee.getModel();
        int r = tbEmployee.getRowCount();
        while (r-- > 0) {            
            TableModel.removeRow(r);
        }
                if (searchTxt.isEmpty()) {
                    try {
                        loadData();
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        searchEmployees(searchTxt);
                    } catch (SQLException | ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
    }//GEN-LAST:event_jtFSearchKeyReleased

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            DefaultTableModel TableModel = (DefaultTableModel) tbEmployee.getModel();
            int r = tbEmployee.getRowCount();
            while (r-- > 0) {            
                TableModel.removeRow(r);
            }
            if(javax.swing.JOptionPane.showConfirmDialog(null, "Bạn muốn xóa", "Xoá", javax.swing.JOptionPane.YES_NO_OPTION) == 0){                
                deleteEmployee();

            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdminDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDetailFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new AdminDetailFrame().setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(AdminDetailFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AccountPanel;
    private javax.swing.JPanel DetailPanel;
    private javax.swing.JPanel PanelPre;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cBDay;
    private javax.swing.JComboBox<String> cBDepartmentid;
    private javax.swing.JComboBox<String> cBMonth;
    private javax.swing.JComboBox<String> cBRoles;
    private javax.swing.JComboBox<String> cBYear;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jPs;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> jSex;
    private javax.swing.JTextArea jTALocation;
    private javax.swing.JTextArea jTDetail;
    private javax.swing.JTextField jTFDegree;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFId;
    private javax.swing.JTextField jTFName;
    private javax.swing.JTextField jTFPassport;
    private javax.swing.JTextField jTFPhone;
    private javax.swing.JTextField jTFPosition;
    private javax.swing.JTextField jTFSpecialized;
    private javax.swing.JTextField jtFSearch;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTable tbEmployee;
    // End of variables declaration//GEN-END:variables
}
