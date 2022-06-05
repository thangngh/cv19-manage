package Models.Area;

public class Area {
    protected String _idArea;
    protected String _nameArea;
    protected String _locationArea;
    protected int _currentStorageArea;
    protected  int _maxStorageArea;
    protected String _note;

    public String get_idArea() {
        return _idArea;
    }

    public void set_idArea(String _idArea) {
        this._idArea = _idArea;
    }

    public String get_nameArea() {
        return _nameArea;
    }

    public void set_nameArea(String _nameArea) {
        this._nameArea = _nameArea;
    }

    public String get_locationArea() {
        return _locationArea;
    }

    public void set_locationArea(String _locationArea) {
        this._locationArea = _locationArea;
    }

    public int get_currentStorageArea() {
        return _currentStorageArea;
    }

    public void set_currentStorageArea(int _currentStorageArea) {
        this._currentStorageArea = _currentStorageArea;
    }

    public int get_maxStorageArea() {
        return _maxStorageArea;
    }

    public void set_maxStorageArea(int _maxStorageArea) {
        this._maxStorageArea = _maxStorageArea;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public Area(){}

    public Area(String _idArea, String _nameArea, String _locationArea, int _currentStorageArea, int _maxStorageArea, String _note) {
        this._idArea = _idArea;
        this._nameArea = _nameArea;
        this._locationArea = _locationArea;
        this._currentStorageArea = _currentStorageArea;
        this._maxStorageArea = _maxStorageArea;
        this._note = _note;
    }

    @Override
    public String toString() {
        return "Area{" +
                "_idArea='" + _idArea + '\'' +
                ", _nameArea='" + _nameArea + '\'' +
                ", _locationArea='" + _locationArea + '\'' +
                ", _currentStorageArea=" + _currentStorageArea +
                ", _maxStorageArea=" + _maxStorageArea +
                ", _note='" + _note + '\'' +
                '}';
    }
}
