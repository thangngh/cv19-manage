package Models.PatientHome;

import Models.Employee.EmployeeModel;
import Models.Patient.PatientModel;
import Models.PatientReport.PatientReport;

public class PatientHomeModel extends PatientModel {

    protected String _employeeModel;
    protected String _location;
    protected String _timeBegin;
    protected String _timeEnd;
    protected PatientReport _patientReport;
    protected String _note;

    public  PatientHomeModel() {}

    public String get_employeeModel() {
        return _employeeModel;
    }

    public void set_employeeModel(String _employeeModel) {
        this._employeeModel = _employeeModel;
    }

    public String get_location() {
        return _location;
    }

    public void set_location(String _location) {
        this._location = _location;
    }

    public String get_timeBegin() {
        return _timeBegin;
    }

    public void set_timeBegin(String _timeBegin) {
        this._timeBegin = _timeBegin;
    }

    public String get_timeEnd() {
        return _timeEnd;
    }

    public void set_timeEnd(String _timeEnd) {
        this._timeEnd = _timeEnd;
    }

    public PatientReport get_patientReport() {
        return _patientReport;
    }

    public void set_patientReport(PatientReport _patientReport) {
        this._patientReport = _patientReport;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public PatientHomeModel(String _passportIdPatient,
                            String _namePatient,
                            String _sexPatient,
                            String _datePatient,
                            String _addressPatient,
                            String _phonePatient,
                            String _insuranceCardPatient,
                            String _employeeModel,
                            String _location,
                            String _timeBegin,
                            String _timeEnd,
                            PatientReport _patientReport,
                            String _note) {
        super(_passportIdPatient,
                _namePatient,
                _sexPatient,
                _datePatient,
                _addressPatient,
                _phonePatient,
                _insuranceCardPatient);
        this._employeeModel = _employeeModel;
        this._location = _location;
        this._timeBegin = _timeBegin;
        this._timeEnd = _timeEnd;
        this._patientReport = _patientReport;
        this._note = _note;
    }

    @Override
    public String toString() {
        return "PatientHomeModel{" +
                "_passportIdPatient='" + _passportIdPatient + '\'' +
                ", _namePatient='" + _namePatient + '\'' +
                ", _sexPatient='" + _sexPatient + '\'' +
                ", _datePatient='" + _datePatient + '\'' +
                ", _addressPatient='" + _addressPatient + '\'' +
                ", _phonePatient='" + _phonePatient + '\'' +
                ", _insuranceCardPatient='" + _insuranceCardPatient + '\'' +
                ", _employeeModel=" + _employeeModel +
                ", _location='" + _location + '\'' +
                ", _timeBegin='" + _timeBegin + '\'' +
                ", _timeEnd='" + _timeEnd + '\'' +
                ", _patientReport=" + _patientReport +
                ", _note='" + _note + '\'' +
                '}';
    }

//    protected EmployeeModel _employeeModel;
//    protected PatientReport _patientReport;
//      protected PatientModel _patientModel;

    public static void main(String[] args) {
        EmployeeModel employeeModel = new EmployeeModel("em01", "thang", "nam", "2000", "dien chau", "0123","0123","thang@gmail.com","dai hoc", "dai hoc", 1,"dai hoc", "rhm", "1234");
        PatientModel patientModel = new PatientModel("bn01", "Nhung", "nu", "2003-04-04", "dien phong", "123456", "sv001");
        PatientReport patientReport = new PatientReport("rp01", patientModel.get_passportIdPatient(), employeeModel.get_nameEmployee(), "dau hong, sot", "nhej", "khong co y kien");
        PatientHomeModel patientHomeModel = new PatientHomeModel("bn01", "Nhung", "nu", "2003-04-04", "dien phong", "123456", "sv001", employeeModel.get_nameEmployee(), "benh vien da khoa", "11-2", " ", patientReport, " khong co gi het");
        System.out.println(patientHomeModel.toString());
    }
}
