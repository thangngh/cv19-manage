package Controllers.Department;

import Db.Db;
import Models.Department.DepartmentModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartmentController {

    public DepartmentController(){}

    public ArrayList<DepartmentModel> loadData() throws SQLException, ClassNotFoundException{
        Db _db = new Db();
        _db.getConnection();

        Statement state = _db.getSqlConnection().createStatement();
        ArrayList<DepartmentModel> department = new ArrayList<>();
        String query = "SELECT id_department FROM Departments";

        ResultSet result = state.executeQuery(query);

        while (result.next()){
            String id;
            id = result.getString("id_department");

            DepartmentModel departmentModel = new DepartmentModel(id);

            department.add(departmentModel);
        }

        return  department;
    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        DepartmentController obj = new DepartmentController();
//        for(DepartmentModel x : obj.loadData()){
//            System.out.println(x.getId_department().toString());
//        }
//    }
}
