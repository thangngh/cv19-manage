package Models.Employee;


public class EmployeeModel {
    /**
     * @_emailEmployee => username
     * @passwordEmployee => password
     */
    protected  String _idEmployee;
    protected  String _nameEmployee;
    protected  String _sexEmployee;
    protected  String _dateEmployee;
    protected  String _addressEmployee;
    protected  String _passportIdEmployee;
    protected  String _emailEmployee;
    protected  String _positionEmployee;
    protected  String _degreeEmployee;
    protected  String _specializedEmployee;
    protected  int    _rolesEmployee;
    protected  String _departmentIdEmployee;
    protected  String _passwordEmployee;
    protected  String _phoneEmployee;

    public String get_passwordEmployee() {
        return _passwordEmployee;
    }

    public void set_passwordEmployee(String _passwordEmployee) {
        this._passwordEmployee = _passwordEmployee;
    }


    public String get_idEmployee() {
        return _idEmployee;
    }

    public String get_nameEmployee() {
        return _nameEmployee;
    }

    public String get_sexEmployee() {
        return _sexEmployee;
    }

    public String get_dateEmployee() {
//        java.sql.Date sqlDate = new java.sql.Date(_dateEmployee.getTime());
        return _dateEmployee;
    }

    public String get_addressEmployee() {
        return _addressEmployee;
    }

    public String get_passportIdEmployee() {
        return _passportIdEmployee;
    }

    public String get_emailEmployee() {
        return _emailEmployee;
    }

    public String get_positionEmployee() {
        return _positionEmployee;
    }

    public String get_degreeEmployee() {
        return _degreeEmployee;
    }

    public String get_specializedEmployee() {
        return _specializedEmployee;
    }

    public int get_rolesEmployee() {
        return _rolesEmployee;
    }

    public String get_departmentIdEmployee() {
        return _departmentIdEmployee;
    }

    public void set_idEmployee(String _idEmployee) {
        this._idEmployee = _idEmployee;
    }

    public void set_nameEmployee(String _nameEmployee) {
        this._nameEmployee = _nameEmployee;
    }

    public void set_sexEmployee(String _sexEmployee) {
        this._sexEmployee = _sexEmployee;
    }

    public void set_dateEmployee(String _dateEmployee) {
        this._dateEmployee = _dateEmployee;
    }

    public void set_addressEmployee(String _addressEmployee) {
        this._addressEmployee = _addressEmployee;
    }

    public void set_passportIdEmployee(String _passportIdEmployee) {
        this._passportIdEmployee = _passportIdEmployee;
    }

    public void set_emailEmployee(String _emailEmployee) {
        this._emailEmployee = _emailEmployee;
    }

    public void set_positionEmployee(String _positionEmployee) {
        this._positionEmployee = _positionEmployee;
    }

    public void set_degreeEmployee(String _degreeEmployee) {
        this._degreeEmployee = _degreeEmployee;
    }

    public void set_specializedEmployee(String _specializedEmployee) {
        this._specializedEmployee = _specializedEmployee;
    }

    public void set_rolesEmployee(int _rolesEmployee) {
        this._rolesEmployee = _rolesEmployee;
    }

    public void set_departmentIdEmployee(String _departmentIdEmployee) {
        this._departmentIdEmployee = _departmentIdEmployee;
    }

    public String get_phoneEmployee() {
        return _phoneEmployee;
    }

    public void set_phoneEmployee(String _phoneEmployee) {
        this._phoneEmployee = _phoneEmployee;
    }

    public  EmployeeModel(){}



    public  EmployeeModel(String _idEmployee, String _nameEmployee, String _addressEmployee,String _positionEmployee, String _degreeEmployee,
                          String _specializedEmployee, String _departmentIdEmployee){
        this._idEmployee = _idEmployee;
        this._nameEmployee = _nameEmployee;
        this._addressEmployee = _addressEmployee;
        this._positionEmployee = _positionEmployee;
        this._degreeEmployee = _degreeEmployee;
        this._specializedEmployee = _specializedEmployee;
        this._departmentIdEmployee = _departmentIdEmployee;
    }

    public EmployeeModel(String id,
                         String name,
                         String sex,
                         String date,
                         String address,
                         String phone,
                         String passport,
                         String email,
                         String position,
                         String degree,
                         int roles,
                         String specialized,
                         String department,
                         String pass) {
        this._idEmployee = id;
        this._nameEmployee = name;
        this._sexEmployee = sex;
        this._dateEmployee = date;
        this._addressEmployee = address;
        this._phoneEmployee = phone;
        this._passportIdEmployee = passport;
        this._emailEmployee = email;
        this._positionEmployee = position;
        this._degreeEmployee = degree;
        this._specializedEmployee = specialized;
        this._rolesEmployee = roles;
        this._departmentIdEmployee = department;
        this._passwordEmployee = pass;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "_idEmployee='" + _idEmployee + '\'' +
                ", _nameEmployee='" + _nameEmployee + '\'' +
                ", _sexEmployee='" + _sexEmployee + '\'' +
                ", _dateEmployee='" + _dateEmployee + '\'' +
                ", _addressEmployee='" + _addressEmployee + '\'' +
                ", _passportIdEmployee='" + _passportIdEmployee + '\'' +
                ", _emailEmployee='" + _emailEmployee + '\'' +
                ", _positionEmployee='" + _positionEmployee + '\'' +
                ", _degreeEmployee='" + _degreeEmployee + '\'' +
                ", _specializedEmployee='" + _specializedEmployee + '\'' +
                ", _rolesEmployee=" + String.valueOf(_rolesEmployee) +
                ", _departmentIdEmployee='" + _departmentIdEmployee + '\'' +
                ", _passwordEmployee='" + _passwordEmployee + '\'' +
                '}';
    }

}
