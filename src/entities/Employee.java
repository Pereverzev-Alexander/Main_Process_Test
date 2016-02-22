package entities;

/**
 * @author Alexander
 * Класс Сотрудник
 * Представляет всех сотрудников компании
 */
public class Employee {
	//fixed id's in SQL table staff_positions
	public static final int master_id = 2; 
	public static final int operator_id = 1;
	
	// Должность сотрудника (оператор/мастер)
	private String position = null;
	private int position_id = 0;
	// ФИО сотрудника
	private String name = null;
	private String second_name = null;
	private String surname = null;
	
	private int id;
	
		
	public Employee(){
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * Get position id
	 */
	public int getPositionId(){
		return position_id;
	}
	
	public Employee(int _id,
			String _employeePosition,
			String _name,String _sec_name,String _surname){
		id = _id;
		position = _employeePosition;
		name = _name;
		second_name  = _sec_name;
		surname = _surname;
		
	}
	
	/*
	 * Get employee's surname and initials as Ivanov A. A.
	 */
	public String getInitials(){
		if(surname == null)
			return null;
		if(second_name == null){
			if(name != null){
				return surname+" "+name.substring(0,1).toUpperCase()+".";
			}
			return surname;
		}
		String res = surname+" "+name.substring(0,1).toUpperCase()+". "+
					second_name.substring(0,1).toUpperCase()+".";
		return res;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	public void setPosition(int pos_id) {
		if(pos_id == master_id)
			position = "Мастер";
		else if(pos_id == operator_id){
			position = "Менеджер";
		}
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the second_name
	 */
	public String getSecondName() {
		return second_name;
	}

	/**
	 * @param second_name the second_name to set
	 */
	public void setSecondName(String second_name) {
		this.second_name = second_name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}
