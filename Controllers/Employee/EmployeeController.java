package Controllers.Employee;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Db.Db;
import  Models.Employee.EmployeeModel;

public class EmployeeController {

    public EmployeeController(){}

    public  EmployeeModel validateEmployee() throws ClassNotFoundException, SQLException {
        Db _db = new Db();
        EmployeeModel _employeeModel = new EmployeeModel();

        _db.getConnection();

        String query = "SELECT email_employee, password_employee FROM employee WHERE roles_employee = 1";
        Statement stateY = _db.getSqlConnection().createStatement();

        ResultSet result = stateY.executeQuery(query);

        String useName;
        String passWord;

        while (result.next()) {
            useName = result.getString("email_employee");
            passWord = result.getString("password_employee");

            _employeeModel.set_emailEmployee(useName);
            _employeeModel.set_passwordEmployee(passWord);
        }
        _db.getSqlConnection().close();

        return  _employeeModel;
    }

    public  ArrayList<EmployeeModel> detailEmployee() throws SQLException, ClassNotFoundException{
        Db _db = new Db();
        _db.getConnection();

        String query = "SELECT id_employee, " +
                "name_employee, " +
                "sex_employee, " +
                "date_employee, " +
                "address_employee, " +
                "phone_employee,  " +
                "passportid_employee, " +
                "email_employee, " +
                "position_employee, " +
                "degree_employee, " +
                "specialized_employee, " +
                "roles_employee, " +
                "name_department, " +
                "password_employee FROM employee JOIN Departments ON employee.departmentid_employee = Departments.id_department";

        Statement state = _db.getSqlConnection().createStatement();
        ResultSet result = state.executeQuery(query);

        ArrayList<EmployeeModel> employeeModels = new ArrayList<>();

        while (result.next()){
            String id, name, sex, address, phone, passport, email, position, degree, specialized, department, pass;
            String date;
            int roles;

            id = result.getString("id_employee");
            name = result.getString("name_employee");
            sex = result.getString("sex_employee");
            date = result.getString("date_employee");
            address = result.getString("address_employee");
            phone = result.getString("phone_employee");
            passport = result.getString("passportid_employee");
            email = result.getString("email_employee");
            position = result.getString("position_employee");
            degree = result.getString("degree_employee");
            specialized = result.getString("specialized_employee");
            roles = Integer.parseInt(result.getString("roles_employee"));
            department = result.getString("name_department");
            pass = result.getString("password_employee");

            EmployeeModel employee = new EmployeeModel(
                      id
                    , name
                    , sex
                    , date
                    , address
                    , phone
                    , passport
                    , email
                    , position
                    , degree
                    , roles
                    , specialized
                    , department,
                    pass);

            employeeModels.add(employee);
        }

        return  employeeModels;
    }

    public ArrayList<EmployeeModel> showDataTable() throws SQLException, ClassNotFoundException {
        Db _db = new Db();
        _db.getConnection();

        Statement state = _db.getSqlConnection().createStatement();

        ArrayList<EmployeeModel> employeeModels = new ArrayList<>();

        String query = "SELECT id_employee, name_employee, address_employee, position_employee, degree_employee, specialized_employee, name_department FROM employee JOIN Departments ON employee.departmentid_employee = Departments.id_department";

        ResultSet result = state.executeQuery(query);

        while (result.next()) {
            String id, name, address, position, degree, specialized, department;

            id = result.getString("id_employee");
            name = result.getString("name_employee");
            address = result.getString("address_employee");
            position = result.getString("position_employee");
            degree = result.getString("degree_employee");
            specialized = result.getString("specialized_employee");
            department = result.getString("name_department");

            EmployeeModel employee = new EmployeeModel(id, name, address, position, degree, specialized, department);

            employeeModels.add(employee);
        }
        _db.getSqlConnection().close();
        return  employeeModels;
    }

    public  void insertEmployee(ArrayList<EmployeeModel> employeeModelList) throws  SQLException, ClassNotFoundException{
        detailEmployee();

        Db _db = new Db();
        _db.getConnection();
        for(EmployeeModel employeeModel : employeeModelList){

            String query = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preState = _db.getSqlConnection().prepareStatement(query);
            preState.setString(1, employeeModel.get_idEmployee());
            preState.setString(2, employeeModel.get_nameEmployee());
            preState.setString(3, employeeModel.get_sexEmployee());
            preState.setString(4, employeeModel.get_dateEmployee());
            preState.setString(5, employeeModel.get_addressEmployee());
            preState.setString(6, employeeModel.get_phoneEmployee());
            preState.setString(7, employeeModel.get_passportIdEmployee());
            preState.setString(8, employeeModel.get_emailEmployee());
            preState.setString(9, employeeModel.get_positionEmployee());
            preState.setString(10, employeeModel.get_degreeEmployee());
            preState.setString(11, employeeModel.get_specializedEmployee());
            preState.setInt(12, employeeModel.get_rolesEmployee());
            preState.setString(13, employeeModel.get_departmentIdEmployee());
            preState.setString(14, employeeModel.get_passwordEmployee());

            preState.executeUpdate();
        }
        _db.getSqlConnection().close();
    }

    public void updateEmployee(String id) throws  SQLException, ClassNotFoundException{
        detailEmployee();

        Db _db = new Db();
        _db.getConnection();
    }

    public void deleteEmployee(String id) throws  SQLException, ClassNotFoundException {
        detailEmployee();

        Db _db = new Db();
        _db.getConnection();
    }

    public ArrayList<EmployeeModel> searchEmployee(String employee) throws SQLException, ClassNotFoundException {
        Db _db = new Db();
        _db.getConnection();

        String query = "SELECT id_employee,name_employee, address_employee, position_employee,degree_employee, specialized_employee, name_department FROM employee JOIN Departments ON employee.departmentid_employee = Departments.id_department WHERE name_employee LIKE N'%"+ employee + "%' ";

        PreparedStatement preState = _db.getSqlConnection().prepareStatement(query);
        ResultSet result = preState.executeQuery();

        ArrayList<EmployeeModel> employeeModels = new ArrayList<>();

        while (result.next()) {
            String id, name, address, position, degree, specialized, department;

            id = result.getString("id_employee");
            name = result.getString("name_employee");
            address = result.getString("address_employee");
            position = result.getString("position_employee");
            degree = result.getString("degree_employee");
            specialized = result.getString("specialized_employee");
            department = result.getString("name_department");

            EmployeeModel employeeSet = new EmployeeModel(id, name, address, position, degree, specialized, department);
            employeeModels.add(employeeSet);
        }
        _db.getSqlConnection().close();
        return  employeeModels;
    }


}
