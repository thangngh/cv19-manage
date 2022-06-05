package Controllers.Admin;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Db.Db;
import Models.Admin.AdminModel;

public class AdminController {

    public AdminModel ValidateAccount() throws ClassNotFoundException, SQLException {
        Db _db = new Db();
        AdminModel _adminModel = new AdminModel();

        _db.getConnection();

        String query = "SELECT user_admin, password_admin FROM account_admin";
        Statement state = _db.getSqlConnection().createStatement();

        ResultSet result = state.executeQuery(query);

        String useName;
        String passWord;

        while (result.next()) {
            useName = result.getString(1);
            passWord = result.getString(2);

            _adminModel.set_useName(useName);
            _adminModel.set_passWord(passWord);
        }
        _db.getSqlConnection().close();

        return _adminModel;

    }

}
