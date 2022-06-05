package Models.PatientReport;

import Models.Employee.EmployeeModel;
import Models.Patient.PatientModel;

public class PatientReport {
    protected String _id;
    protected String _patientModel;
    protected String _employeeModel;
    protected String _symptom;
    protected String _state;
    protected String _note;


    public  PatientReport() {

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_patientModel() {
        return _patientModel;
    }

    public void set_patientModel(String _patientModel) {
        this._patientModel = _patientModel;
    }

    public String get_employeeModel() {
        return _employeeModel;
    }

    public void set_employeeModel(String _employeeModel) {
        this._employeeModel = _employeeModel;
    }

    public String get_symptom() {
        return _symptom;
    }

    public void set_symptom(String _symptom) {
        this._symptom = _symptom;
    }

    public String get_state() {
        return _state;
    }

    public void set_state(String _state) {
        this._state = _state;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public PatientReport(String _id, String _patientModel, String _employeeModel, String _symptom, String _state, String _note) {
        this._id = _id;
        this._patientModel = _patientModel;
        this._employeeModel = _employeeModel;
        this._symptom = _symptom;
        this._state = _state;
        this._note = _note;
    }

    @Override
    public String toString() {
        return "PatientReport{" +
                "_id='" + _id + '\'' +
                ", _patientModel=" + _patientModel +
                ", _employeeModel=" + _employeeModel +
                ", _symptom='" + _symptom + '\'' +
                ", _state='" + _state + '\'' +
                ", _note='" + _note + '\'' +
                '}';
    }
}
