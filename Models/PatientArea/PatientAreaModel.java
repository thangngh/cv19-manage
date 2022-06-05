package Models.PatientArea;

import Models.Area.Area;
import Models.Patient.PatientModel;
import Models.PatientReport.PatientReport;

public class PatientAreaModel extends PatientModel {
    protected String _employeeModel;
    protected Area _areaModel;
    protected String _timeBegin;
    protected String _timeEnd;
    protected PatientReport _patientReportModel;
    protected String _note;

    public  PatientAreaModel() {}

    public String get_employeeModel() {
        return _employeeModel;
    }

    public void set_employeeModel(String _employeeModel) {
        this._employeeModel = _employeeModel;
    }

    public Area get_areaModel() {
        return _areaModel;
    }

    public void set_areaModel(Area _areaModel) {
        this._areaModel = _areaModel;
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

    public PatientReport get_patientReportModel() {
        return _patientReportModel;
    }

    public void set_patientReportModel(PatientReport _patientReportModel) {
        this._patientReportModel = _patientReportModel;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public PatientAreaModel(String _employeeModel,
                            Area _areaModel,
                            String _timeBegin,
                            String _timeEnd,
                            PatientReport _patientReportModel,
                            String _note) {
        this._employeeModel = _employeeModel;
        this._areaModel = _areaModel;
        this._timeBegin = _timeBegin;
        this._timeEnd = _timeEnd;
        this._patientReportModel = _patientReportModel;
        this._note = _note;
    }

    public PatientAreaModel(
                            String _passportIdPatient,
                            String _namePatient,
                            String _sexPatient,
                            String _datePatient,
                            String _addressPatient,
                            String _phonePatient,
                            String _insuranceCardPatient,
//                            end extends
                            String _employeeModel,
                            Area _areaModel,
                            String _timeBegin,
                            String _timeEnd,
                            PatientReport _patientReportModel,
                            String _note
    ) {
        super(_passportIdPatient,
                _namePatient,
                _sexPatient,
                _datePatient,
                _addressPatient,
                _phonePatient,
                _insuranceCardPatient);
        this._employeeModel = _employeeModel;
        this._areaModel = _areaModel;
        this._timeBegin = _timeBegin;
        this._timeEnd = _timeEnd;
        this._patientReportModel = _patientReportModel;
        this._note = _note;
    }

    @Override
    public String toString() {
        return "PatientAreaModel{" +
                "_passportIdPatient='" + _passportIdPatient + '\'' +
                ", _namePatient='" + _namePatient + '\'' +
                ", _sexPatient='" + _sexPatient + '\'' +
                ", _datePatient='" + _datePatient + '\'' +
                ", _addressPatient='" + _addressPatient + '\'' +
                ", _phonePatient='" + _phonePatient + '\'' +
                ", _insuranceCardPatient='" + _insuranceCardPatient + '\'' +
                ", _employeeModel=" + _employeeModel +
                ", _areaModel=" + _areaModel +
                ", _timeBegin='" + _timeBegin + '\'' +
                ", _timeEnd='" + _timeEnd + '\'' +
                ", _patientReportModel=" + _patientReportModel +
                ", _note='" + _note + '\'' +
                '}';
    }
}
