package Models.Medicine;

public class Medicine {
    protected String _idMedicine;
    protected String _nameMedicine;
    protected String _madeMedicine;
    protected String _weightMedicine;
    protected String _timeUseMedicine;
    protected String _note;

    public String get_idMedicine() {
        return _idMedicine;
    }

    public void set_idMedicine(String _idMedicine) {
        this._idMedicine = _idMedicine;
    }

    public String get_nameMedicine() {
        return _nameMedicine;
    }

    public void set_nameMedicine(String _nameMedicine) {
        this._nameMedicine = _nameMedicine;
    }

    public String get_madeMedicine() {
        return _madeMedicine;
    }

    public void set_madeMedicine(String _madeMedicine) {
        this._madeMedicine = _madeMedicine;
    }

    public String get_weightMedicine() {
        return _weightMedicine;
    }

    public void set_weightMedicine(String _weightMedicine) {
        this._weightMedicine = _weightMedicine;
    }

    public String get_timeUseMedicine() {
        return _timeUseMedicine;
    }

    public void set_timeUseMedicine(String _timeUseMedicine) {
        this._timeUseMedicine = _timeUseMedicine;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public  Medicine() {}

    public Medicine(String _idMedicine, String _nameMedicine, String _madeMedicine, String _weightMedicine, String _timeUseMedicine, String _note) {
        this._idMedicine = _idMedicine;
        this._nameMedicine = _nameMedicine;
        this._madeMedicine = _madeMedicine;
        this._weightMedicine = _weightMedicine;
        this._timeUseMedicine = _timeUseMedicine;
        this._note = _note;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "_idMedicine='" + _idMedicine + '\'' +
                ", _nameMedicine='" + _nameMedicine + '\'' +
                ", _madeMedicine='" + _madeMedicine + '\'' +
                ", _weightMedicine='" + _weightMedicine + '\'' +
                ", _timeUseMedicine='" + _timeUseMedicine + '\'' +
                ", _note='" + _note + '\'' +
                '}';
    }
}
