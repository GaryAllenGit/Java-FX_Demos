package demo3;

public class Employee {
	private String ID;
	private String firstname;
	private String surname;
	private String department;

	public Employee(){
	}

	public Employee(String id, String fn, String sn, String dept){
		ID = id;
		firstname =fn;
		surname = sn;
		department = dept;
	}

	public String getID(){
		return ID;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getSurname(){
		return surname;
	}

	public void setSurname(String surname){
		this.surname = surname;
	}

	public String getDepartment(){
		return department;
	}

	public void setDepartment(String department){
		this.department = department;
	}

	public String toString(){
		return ID + ": " + surname + ", " + firstname;
	}
}
