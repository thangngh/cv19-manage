package Models.Patient;

public class PatientModel {
    protected String _passportIdPatient;
    protected String _namePatient;
    protected String _sexPatient;
    protected String _datePatient;
    protected String _addressPatient;
    protected String _phonePatient;
    protected String _insuranceCardPatient;

    public String get_passportIdPatient() {
        return _passportIdPatient;
    }

    public void set_passportIdPatient(String _passportIdPatient) {
        this._passportIdPatient = _passportIdPatient;
    }

    public String get_namePatient() {
        return _namePatient;
    }

    public void set_namePatient(String _namePatient) {
        this._namePatient = _namePatient;
    }

    public String get_sexPatient() {
        return _sexPatient;
    }

    public void set_sexPatient(String _sexPatient) {
        this._sexPatient = _sexPatient;
    }

    public String get_datePatient() {
        return _datePatient;
    }

    public void set_datePatient(String _datePatient) {
        this._datePatient = _datePatient;
    }

    public String get_addressPatient() {
        return _addressPatient;
    }

    public void set_addressPatient(String _addressPatient) {
        this._addressPatient = _addressPatient;
    }

    public String get_phonePatient() {
        return _phonePatient;
    }

    public void set_phonePatient(String _phonePatient) {
        this._phonePatient = _phonePatient;
    }

    public String get_insuranceCardPatient() {
        return _insuranceCardPatient;
    }

    public void set_insuranceCardPatient(String _insuranceCardPatient) {
        this._insuranceCardPatient = _insuranceCardPatient;
    }

    public  PatientModel(){}

    public PatientModel(String _passportIdPatient, String _namePatient, String _sexPatient, String _datePatient, String _addressPatient, String _phonePatient, String _insuranceCardPatient) {
        this._passportIdPatient = _passportIdPatient;
        this._namePatient = _namePatient;
        this._sexPatient = _sexPatient;
        this._datePatient = _datePatient;
        this._addressPatient = _addressPatient;
        this._phonePatient = _phonePatient;
        this._insuranceCardPatient = _insuranceCardPatient;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "_passportIdPatient='" + _passportIdPatient + '\'' +
                ", _namePatient='" + _namePatient + '\'' +
                ", _sexPatient='" + _sexPatient + '\'' +
                ", _datePatient='" + _datePatient + '\'' +
                ", _addressPatient='" + _addressPatient + '\'' +
                ", _phonePatient='" + _phonePatient + '\'' +
                ", _insuranceCardPatient='" + _insuranceCardPatient + '\'' +
                '}';
    }

}
