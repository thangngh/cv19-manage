package ViewsFrame.Login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controllers.Admin.AdminController;
import Controllers.Employee.EmployeeController;
import Models.Admin.AdminModel;
import Models.Employee.EmployeeModel;
import ViewsFrame.Detail.AdminDetail;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginFrame extends JFrame implements ActionListener {

    protected JLabel JUser;
    protected JLabel JPass;
    protected JTextField JTUser;
    protected JPasswordField JPPass;
    protected JButton JBtn;
    protected Container container;
    public LoginFrame() {

        super("Login");
        this.setVisible(true);
        this.setBounds(500, 250, 600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JUser = new JLabel("Username: ");
        JTUser = new JTextField();

        JPass = new JLabel("Password: ");
        JPPass = new JPasswordField();
        JPPass.setEchoChar('*');

        JBtn = new JButton("Login");

        container = getContentPane();
        container.setLayout(null);

        addBound();
        addFont();
        addColor();
        addComponents();
        addActionListener();
    }

    public void addBound() {
        JUser.setBounds(36, 69, 176, 41);
        JTUser.setBounds(250, 69, 314, 42);

        JPass.setBounds(36, 170, 160, 40);
        JPPass.setBounds(250, 170, 314, 42);

        JBtn.setBounds(199, 304, 119, 43);
    }

    public void addFont() {
        JUser.setFont(new Font("MV Boli", Font.PLAIN, 20));
        JPass.setFont(new Font("MV Boli", Font.PLAIN, 20));

        JBtn.setFont(new Font("MV Boli", Font.PLAIN, 20));
    }

    public void addColor() {
        container.setBackground(Color.WHITE);

        JUser.setForeground(new Color(0x191D1D));
        JPass.setForeground(new Color(0x191D1D));

        JBtn.setForeground(new Color(0x191D1D));
    }

    public void addComponents() {
        container.add(JUser);
        container.add(JTUser);

        container.add(JPass);
        container.add(JPPass);

        container.add(JBtn);
    }

    public void addActionListener() {
        JBtn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        AdminController handlerAdminController = new AdminController();
        AdminModel handlerAdminModel = new AdminModel();

        EmployeeController handlerEmployeeController = new EmployeeController();
        EmployeeModel handlerEmployeeModel = new EmployeeModel();

        try {

            if (JTUser.getText().isEmpty() && (new String(JPPass.getPassword())).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Yêu cầu nhập tài khoản hoặc mặt khẩu");
                return;
            }

            ValidateUser();
            ValidatePass();

            handlerAdminModel = handlerAdminController.ValidateAccount();
            handlerEmployeeModel = handlerEmployeeController.validateEmployee();

            if (e.getSource() == JBtn) {
                // if statement with admin
                if (JTUser.getText().equals(handlerAdminModel.get_useName())
                        && (new String(JPPass.getPassword())).equals(handlerAdminModel.get_passWord())) {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                    JOptionPane.showMessageDialog(null, "Xin chào admin: " + handlerAdminModel.get_useName());
                    /*
                     * @@test
                     * new HomeFrame().setVisible(true);
                     * this.dispose();
                     */
                    new AdminDetail().setVisible(true);
                    this.dispose();
                }
                // if statement with employee
                else if(JTUser.getText().equals(handlerEmployeeModel.get_emailEmployee())
                        && (new String(JPPass.getPassword())).equals(handlerEmployeeModel.get_passwordEmployee())) {

                    System.out.printf("employee user: " + handlerEmployeeModel.get_emailEmployee());
                    System.out.printf("employee pass: " + handlerEmployeeModel.get_passwordEmployee());

                }
                else {
                    JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu");
                }
            }
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        }

    }

    // pretty simple validate xD
    public void ValidateUser() {

        if (JTUser.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập không được để trống");
            return;
        }
    }

    public void ValidatePass() {
        if ((new String(JPPass.getPassword())).isEmpty()) {
            JOptionPane.showMessageDialog(null, "mật khẩu không được để trống");
            return;
        }
    }

}