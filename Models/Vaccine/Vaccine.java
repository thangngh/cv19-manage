package Models.Vaccine;

public class Vaccine {
    protected String _idVaccine;
    protected String _nameVaccine;
    protected String _madeVaccine;
    protected String note;

    public String get_idVaccine() {
        return _idVaccine;
    }

    public void set_idVaccine(String _idVaccine) {
        this._idVaccine = _idVaccine;
    }

    public String get_nameVaccine() {
        return _nameVaccine;
    }

    public void set_nameVaccine(String _nameVaccine) {
        this._nameVaccine = _nameVaccine;
    }

    public String get_madeVaccine() {
        return _madeVaccine;
    }

    public void set_madeVaccine(String _madeVaccine) {
        this._madeVaccine = _madeVaccine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Vaccine() {}

    public Vaccine(String _idVaccine, String _nameVaccine, String _madeVaccine, String note) {
        this._idVaccine = _idVaccine;
        this._nameVaccine = _nameVaccine;
        this._madeVaccine = _madeVaccine;
        this.note = note;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "_idVaccine='" + _idVaccine + '\'' +
                ", _nameVaccine='" + _nameVaccine + '\'' +
                ", _madeVaccine='" + _madeVaccine + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
