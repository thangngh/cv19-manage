/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Models.AdminModels;

/**
 *
 * @author pv
 */
public class AdminModel {
    protected String _useName;
    protected String _passWord;

    public String get_passWord() {
        return _passWord;
    }

    public String get_useName() {
        return _useName;
    }

    public void set_passWord(String _passWord) {
        this._passWord = _passWord;
    }

    public void set_useName(String _useName) {
        this._useName = _useName;
    }

    public AdminModel() {
    }

    public AdminModel(String useName, String passWord) {
        this._useName = useName;
        this._passWord = passWord;
    }

    @Override
    public String toString() {
        return get_useName() + get_passWord();
    }
}
