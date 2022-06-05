package ViewsFrame.Detail;

import Controllers.Department.DepartmentController;
import Controllers.Employee.EmployeeController;
import Models.Department.DepartmentModel;
import Models.Employee.EmployeeModel;
import ViewsFrame.Login.LoginFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;

public class AdminDetail extends JFrame {
    private JPanel contentPane;
    private JTextField jtFId;
    private JComboBox jCBSex;
    private JTextArea tAAddress;
    private JComboBox cBDepartmentid;
    private JComboBox cBRoles;
    private JLabel jRoles;
    private JPanel jPDate;
    private JTable tableEmployee;
    private JTextField jtFSearch;
    private JLabel jId;
    private JLabel jName;
    private JTextField jTFName;
    private JLabel jSex;
    private JLabel jAddress;
    private JLabel jDate;
    private JLabel jPhone;
    private JTextField jTFPhone;
    private JLabel jPassPortId;
    private JTextField jTFPassPortId;
    private JLabel jEmail;
    private JTextField jTFEmail;
    private JLabel jPosition;
    private JTextField jTFPosition;
    private JLabel jDegree;
    private JTextField jTFDegree;
    private JLabel jSpecialized;
    private JTextField jTFSpecialized;
    private JLabel jPassword;
    private JTextField jTFPassword;
    private JPanel jInformation;
    private JButton btnAdd;
    private JButton btnBack;
    private JButton btnPrint;
    private JButton btnReset;
    private JButton btnDetail;
    private JButton btnSearch;
    private JPanel jBtn;
    private JPanel jRe;
    private JPanel jTables;
    private JLabel jUser;
    private JComboBox cBMonth;
    private JComboBox cBYear;
    private JComboBox cBDay;
    private JScrollPane jScroll;
    private JPanel jDetail;
    private JLabel jEmployeeId;
    private DefaultTableModel tableModel;

    public AdminDetail() throws SQLException, ClassNotFoundException {

        super("Admin Detail");
        $$$setupUI$$$();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chooseDate();
        detailDepartment();
        loadData();

        setContentPane(contentPane);
        this.pack();
        this.setVisible(true);

        // Insert
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    insertData();
                    JOptionPane.showMessageDialog(null, "Thêm thành công");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Dữ liệu đã tồn tại");
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Lỗi kết nối");
                }

            }
        });
        //back Login
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                System.out.println("Trở lại giao diện đăng nhập");
                JOptionPane.showMessageDialog(null, "Bạn có muốn thoát tài khoản");
                new LoginFrame().setVisible(true);
                AdminDetail.this.dispose();
            }

        });
        // Print Employee
        btnPrint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("In danh sách nhân viên");
            }
        });
        // Làm mới
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtFId.setText(" ");
                jTFName.setText(" ");
                tAAddress.setText(" ");
                jTFPhone.setText(" ");
                jTFPassPortId.setText(" ");
                jTFEmail.setText(" ");
                jTFPosition.setText("");
                jTFDegree.setText(" ");
                jTFSpecialized.setText(" ");
            }
        });
        // Cập nhập
        btnDetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cập nhập lại dữ liệu ");
            }
        });
        // Tìm kiếm
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchTxt = jtFSearch.getText();
                if (searchTxt.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Bạn chưa nhập từ tìm kiếm");
                } else {
                    try {
                        searchEmployees(searchTxt);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        jCBSex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("select: " + jCBSex.getSelectedItem());
            }
        });
        cBDepartmentid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(cBDepartmentid.getSelectedItem());
            }
        });
        cBRoles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                if (cBRoles.getSelectedItem() == "1") {
                    String randomPass = String.valueOf(random.nextInt(9999));
//                    byte[] randomBytes = new byte[32];
//                    random.nextBytes(randomBytes);
//                    String encoded = Base64.getUrlEncoder().encodeToString(randomBytes);
//                    System.out.println(encoded);
//                    jTFPassword.setText(encoded);
                    jTFPassword.setText(randomPass);
                } else {
                    jTFPassword.setText("");
                }
            }
        });
        tableEmployee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        cBMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Month
                System.out.println(cBMonth.getSelectedItem());
            }
        });
        cBDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Day
                System.out.println(cBDay.getSelectedItem());
            }
        });
        cBYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Year
                System.out.println(cBYear.getSelectedItem());
            }
        });
        jtFSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchTxt = jtFSearch.getText();
                if (searchTxt.isEmpty()) {
                    try {
                        loadData();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        searchEmployees(searchTxt);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        jtFSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });
    }

    public void searchEmployees(String searchEmp) throws SQLException, ClassNotFoundException {
        detailEmployee();
        EmployeeController employeeController = new EmployeeController();
        ArrayList<EmployeeModel> employeeModel = employeeController.searchEmployee(searchEmp);

        for (EmployeeModel employeeModels : employeeModel) {
            String[] row = new String[]{
                    String.valueOf(tableModel.getRowCount() + 1),
                    employeeModels.get_idEmployee(),
                    employeeModels.get_nameEmployee(),
                    employeeModels.get_addressEmployee(),
                    employeeModels.get_positionEmployee(),
                    employeeModels.get_degreeEmployee(),
                    employeeModels.get_specializedEmployee(),
                    //  get Name department into department ID using JOIN operator
                    employeeModels.get_departmentIdEmployee(),
            };
            tableModel.addRow(row);
        }
    }

    public void showMonth() {
        Vector v = new Vector();
        for (int i = 1; i <= 12; i++) {
            v.add(i);
        }
        cBMonth.setModel(new DefaultComboBoxModel(v));
        cBMonth.setSelectedIndex(1);
    }

    public void showDay() {
        Vector v = new Vector();
        for (int i = 1; i <= 31; i++) {
            v.add(i);
        }
        cBDay.setModel(new DefaultComboBoxModel(v));
        cBDay.setSelectedIndex(1);
    }

    public void showYear() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        Vector v = new Vector();
        for (int i = 1930; i <= year; i++) {
            v.add(i);
        }
        cBYear.setModel(new DefaultComboBoxModel(v));
        cBYear.setSelectedIndex(v.size() - 1);
    }

    public void chooseDate() {
        showMonth();
        showDay();
        showYear();
    }

    public void detailDepartment() throws SQLException, ClassNotFoundException {
        DepartmentController department = new DepartmentController();
        for (DepartmentModel dpmodel : department.loadData()) {
            cBDepartmentid.addItem(dpmodel.getId_department());
        }
    }

    public void detailEmployee() {

        tableModel = new DefaultTableModel();

        tableModel.setColumnIdentifiers(new String[]{
                "STT",
                "ID",
                "Tên nhân viên",
                "Địa chỉ",
                "Chức vụ",
                "Trình độ",
                "Chuyên ngành",
                "Tên khoa",
        });

        tableModel.setRowCount(0);
        tableEmployee.setModel(tableModel);
    }

    public void loadData() throws SQLException, ClassNotFoundException {

        detailEmployee();
        EmployeeController employee = new EmployeeController();

        for (EmployeeModel empl : employee.showDataTable()) {
            String[] row = new String[]{
                    String.valueOf(tableModel.getRowCount() + 1),
                    empl.get_idEmployee(),
                    empl.get_nameEmployee(),
                    empl.get_addressEmployee(),
                    empl.get_positionEmployee(),
                    empl.get_degreeEmployee(),
                    empl.get_specializedEmployee(),
                    //  get Name department into department ID using JOIN operator
                    empl.get_departmentIdEmployee(),
            };
            tableModel.addRow(row);
        }
    }

    public void insertData() throws SQLException, ClassNotFoundException {
        ArrayList<EmployeeModel> employeeModelList = new ArrayList<>();

        String id, name, sex, date, address, phone, passport, email, position, degree, specialize, department, password;
        int roles;

        id = jtFId.getText().trim();
        name = jTFName.getText().trim();
        sex = String.valueOf(jCBSex.getSelectedItem());
        date = String.valueOf(cBYear.getSelectedItem() + "-" + cBMonth.getSelectedItem() + "-" + cBDay.getSelectedItem());
        address = tAAddress.getText().trim();
        phone = jTFPhone.getText().trim();
        passport = jTFPassPortId.getText().trim();
        email = jTFEmail.getText().trim();
        position = jTFPosition.getText().trim();
        degree = jTFDegree.getText().trim();
        specialize = jTFSpecialized.getText().trim();
        roles = Integer.parseInt(String.valueOf(cBRoles.getSelectedItem()));
        department = (String) cBDepartmentid.getSelectedItem();
        password = jTFPassword.getText().trim();

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

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new AdminDetail();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        contentPane.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 2, new Insets(5, 5, 5, 5), 0, 0));
        jBtn.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(jBtn, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 4, new Insets(0, 0, 0, 0), -1, -1));
        jBtn.add(panel1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnReset = new JButton();
        btnReset.setText("Làm mới");
        panel1.add(btnReset, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnDetail = new JButton();
        btnDetail.setText("+ Detail:");
        panel1.add(btnDetail, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnAdd = new JButton();
        btnAdd.setText("Thêm");
        panel1.add(btnAdd, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnBack = new JButton();
        btnBack.setText("Trở về");
        panel1.add(btnBack, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnPrint = new JButton();
        btnPrint.setText("In");
        panel1.add(btnPrint, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        btnSearch = new JButton();
        btnSearch.setText("Tìm kiếm");
        panel1.add(btnSearch, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 3, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        jtFSearch = new JTextField();
        panel2.add(jtFSearch, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        jEmployeeId = new JLabel();
        jEmployeeId.setEnabled(false);
        jEmployeeId.setText("");
        panel1.add(jEmployeeId, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JToolBar.Separator toolBar$Separator1 = new JToolBar.Separator();
        jBtn.add(toolBar$Separator1, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JToolBar.Separator toolBar$Separator2 = new JToolBar.Separator();
        jBtn.add(toolBar$Separator2, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jTables.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), 0, 0, false, true));
        contentPane.add(jTables, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 2, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        jScroll = new JScrollPane();
        jTables.add(jScroll, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        tableEmployee.setAutoCreateRowSorter(false);
        Font tableEmployeeFont = this.$$$getFont$$$("SansSerif", -1, -1, tableEmployee.getFont());
        if (tableEmployeeFont != null) tableEmployee.setFont(tableEmployeeFont);
        tableEmployee.setPreferredScrollableViewportSize(new Dimension(500, 450));
        tableEmployee.setShowHorizontalLines(true);
        tableEmployee.setShowVerticalLines(true);
        jScroll.setViewportView(tableEmployee);
        jDetail.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(jDetail, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 4, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        jRe.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        jDetail.add(jRe, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(415, 74), null, 0, false));
        jUser = new JLabel();
        jUser.setHorizontalAlignment(0);
        jUser.setHorizontalTextPosition(0);
        jUser.setText("Xin chào");
        jUser.putClientProperty("html.disable", Boolean.TRUE);
        jRe.add(jUser, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        final JLabel label1 = new JLabel();
        label1.setText("Thông tin");
        jRe.add(label1, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jInformation.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(14, 2, new Insets(0, 0, 0, 0), -1, -1));
        jDetail.add(jInformation, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(415, 513), null, 0, false));
        jId = new JLabel();
        jId.setText("ID");
        jInformation.add(jId, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jtFId = new JTextField();
        jInformation.add(jtFId, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        jName = new JLabel();
        jName.setText("Tên");
        jInformation.add(jName, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jTFName = new JTextField();
        jInformation.add(jTFName, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        jSex = new JLabel();
        jSex.setText("Giới tính");
        jInformation.add(jSex, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jDate = new JLabel();
        jDate.setText("Ngày sinh");
        jInformation.add(jDate, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jAddress = new JLabel();
        jAddress.setText("Địa chỉ");
        jInformation.add(jAddress, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jPhone = new JLabel();
        jPhone.setText("Điện thoại");
        jInformation.add(jPhone, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jTFPhone = new JTextField();
        jInformation.add(jTFPhone, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        jPassPortId = new JLabel();
        jPassPortId.setText("Cmnd");
        jInformation.add(jPassPortId, new com.intellij.uiDesigner.core.GridConstraints(6, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jTFPassPortId = new JTextField();
        jInformation.add(jTFPassPortId, new com.intellij.uiDesigner.core.GridConstraints(6, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("ID khoa");
        jInformation.add(label2, new com.intellij.uiDesigner.core.GridConstraints(13, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jPassword = new JLabel();
        jPassword.setText("Password");
        jInformation.add(jPassword, new com.intellij.uiDesigner.core.GridConstraints(12, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jTFPassword = new JTextField();
        jTFPassword.setEnabled(false);
        jInformation.add(jTFPassword, new com.intellij.uiDesigner.core.GridConstraints(12, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        jRoles = new JLabel();
        jRoles.setText("Roles");
        jInformation.add(jRoles, new com.intellij.uiDesigner.core.GridConstraints(11, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jSpecialized = new JLabel();
        jSpecialized.setText("Chuyên ngành");
        jInformation.add(jSpecialized, new com.intellij.uiDesigner.core.GridConstraints(10, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jTFSpecialized = new JTextField();
        jInformation.add(jTFSpecialized, new com.intellij.uiDesigner.core.GridConstraints(10, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        jDegree = new JLabel();
        jDegree.setText("Trình độ");
        jInformation.add(jDegree, new com.intellij.uiDesigner.core.GridConstraints(9, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jTFDegree = new JTextField();
        jInformation.add(jTFDegree, new com.intellij.uiDesigner.core.GridConstraints(9, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        jPosition = new JLabel();
        jPosition.setText("Chức vụ");
        jInformation.add(jPosition, new com.intellij.uiDesigner.core.GridConstraints(8, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jTFPosition = new JTextField();
        jInformation.add(jTFPosition, new com.intellij.uiDesigner.core.GridConstraints(8, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        jEmail = new JLabel();
        jEmail.setText("Email");
        jInformation.add(jEmail, new com.intellij.uiDesigner.core.GridConstraints(7, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jTFEmail = new JTextField();
        jInformation.add(jTFEmail, new com.intellij.uiDesigner.core.GridConstraints(7, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        jCBSex = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Nam");
        defaultComboBoxModel1.addElement("Nữ");
        jCBSex.setModel(defaultComboBoxModel1);
        jInformation.add(jCBSex, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        jPDate = new JPanel();
        jPDate.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 6, new Insets(0, 0, 0, 0), -1, -1));
        jInformation.add(jPDate, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        cBMonth = new JComboBox();
        jPDate.add(cBMonth, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cBYear = new JComboBox();
        jPDate.add(cBYear, new com.intellij.uiDesigner.core.GridConstraints(0, 5, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cBDay = new JComboBox();
        jPDate.add(cBDay, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Month");
        jPDate.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Day");
        jPDate.add(label4, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Year");
        jPDate.add(label5, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tAAddress = new JTextArea();
        tAAddress.setText("");
        jInformation.add(tAAddress, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        cBDepartmentid = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel2 = new DefaultComboBoxModel();
        cBDepartmentid.setModel(defaultComboBoxModel2);
        jInformation.add(cBDepartmentid, new com.intellij.uiDesigner.core.GridConstraints(13, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cBRoles = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel3 = new DefaultComboBoxModel();
        defaultComboBoxModel3.addElement("0");
        defaultComboBoxModel3.addElement("1");
        cBRoles.setModel(defaultComboBoxModel3);
        jInformation.add(cBRoles, new com.intellij.uiDesigner.core.GridConstraints(11, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        this.contentPane = new JPanel();
        this.jInformation = new JPanel();
        this.tableEmployee = new JTable();
        this.jDetail = new JPanel();
        this.jBtn = new JPanel();
        this.jRe = new JPanel();
        this.jTables = new JPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.contentPane.setSize(screenSize.width, screenSize.height);
        this.jDetail.setSize(300, screenSize.height);
    }
}
