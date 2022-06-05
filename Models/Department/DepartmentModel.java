package Models.Department;

public class DepartmentModel {
    protected  String id_department;
    protected  String name_department;

    public String getId_department() {
        return id_department;
    }

    public void setId_department(String id_department) {
        this.id_department = id_department;
    }

    public String getName_department() {
        return name_department;
    }

    public void setName_department(String name_department) {
        this.name_department = name_department;
    }

    public  DepartmentModel(){}

    public DepartmentModel(String id_department, String name_department) {
        this.id_department = id_department;
        this.name_department = name_department;
    }

    public DepartmentModel(String id_department) {
        this.id_department = id_department;
    }

    @Override
    public String toString() {
        return "DepartmentModel{" +
                "id_department='" + id_department + '\'' +
                ", name_department='" + name_department + '\'' +
                '}';
    }
}
