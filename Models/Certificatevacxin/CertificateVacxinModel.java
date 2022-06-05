package Models.Certificatevacxin;

import Models.Patient.PatientModel;
import Models.Vaccine.Vaccine;

public class CertificateVacxinModel {
    //    id auto ++
    protected PatientModel _patientModel;
    protected Vaccine _vaccine;
    protected int _total;
    protected String _note;

    public CertificateVacxinModel() {
    }

    public CertificateVacxinModel(PatientModel _patientModel, Vaccine _vaccine, int _total, String _note) {
        this._patientModel = _patientModel;
        this._vaccine = _vaccine;
        this._total = _total;
        this._note = _note;
    }

    public PatientModel get_patientModel() {
        return _patientModel;
    }

    public void set_patientModel(PatientModel _patientModel) {
        this._patientModel = _patientModel;
    }

    public Vaccine get_vaccine() {
        return _vaccine;
    }

    public void set_vaccine(Vaccine _vaccine) {
        this._vaccine = _vaccine;
    }

    public int get_total() {
        return _total;
    }

    public void set_total(int _total) {
        this._total = _total;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    @Override
    public String toString() {
        return "CertificateVacxinModel{" +
                "_patientModel=" + _patientModel +
                ", _vaccine=" + _vaccine +
                ", _total=" + _total +
                ", _note='" + _note + '\'' +
                '}';
    }

}
