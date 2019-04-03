import javafx.beans.property.SimpleStringProperty;

/*
This is similar to the Employee class used in other examples, but the fields
have been changed to be of type SimpleStringProperty to allow editing via the TableView
*/

public class Employee {
	private SimpleStringProperty ID;
	private SimpleStringProperty firstname;
	private SimpleStringProperty surname;
	private SimpleStringProperty department;

	public Employee(){
		ID = new SimpleStringProperty();
		firstname = new SimpleStringProperty();
		surname = new SimpleStringProperty();
		department = new SimpleStringProperty();
	}

	public Employee(String id, String fn, String sn, String dept){
		ID = new SimpleStringProperty(id);
		firstname = new SimpleStringProperty(fn);
		surname = new SimpleStringProperty(sn);
		department = new SimpleStringProperty(dept);
	}

	public String getID(){
		return ID.get();
	}

	public void setID(String id){
	    this.ID.set(id);
    }

	public String getFirstname(){
		return firstname.get();
	}

	public void setFirstname(String firstname){
		this.firstname.set(firstname);
	}

	public String getSurname(){
		return surname.get();
	}

	public void setSurname(String surname){
		this.surname.set(surname);
	}

	public String getDepartment(){
		return department.get();
	}

	public void setDepartment(String department){
		this.department.set(department);
	}

	public String toString(){
		return ID + ": " + surname + ", " + firstname;
	}
}
