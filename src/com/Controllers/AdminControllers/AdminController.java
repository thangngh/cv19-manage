/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Controllers.AdminControllers;

import com.Db.Db;
import com.Models.AdminModels.AdminModel;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author pv
 */
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
