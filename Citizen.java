
public class citizen {
	
	String name;
	String ic;
	String state;
	int age; 
	String category;
	String firstdose;
	String seconddose;
	String vaccompletion;
	
	//constructor
	public citizen(String name, String ic, String state, int age, String category, String firstdose, String seconddose,
			String vaccompletion) {
		super();
		this.name = name;
		this.ic = ic;
		this.state = state;
		this.age = age;
		this.category = category;
		this.firstdose = firstdose;
		this.seconddose = seconddose;
		this.vaccompletion = vaccompletion;
	}

	//setter
	public void setName(String name) {
		this.name = name;
	}

	public void setIc(String ic) {
		this.ic = ic;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setFirstdose(String firstdose) {
		this.firstdose = firstdose;
	}

	public void setSeconddose(String seconddose) {
		this.seconddose = seconddose;
	}

	public void setVaccompletion(String vaccompletion) {
		this.vaccompletion = vaccompletion;
	}
	
	//getter
	public String getName() {
		return name;
	}
	
	public String getIc() {
		return ic;
	}
	
	public String getState() {
		return state;
	}
	
	public int getAge() {
		return age;
	}

	public String getCategory() {
		return category;
	}
	
	public String getFirstdose() {
		return firstdose;
	}
	
	public String getSeconddose() {
		return seconddose;
	}
	
	public String getVaccompletion() {
		return vaccompletion;
	}

	//tpString
	@Override
	public String toString() {
		return "\n"+"citizen [name=" + name + ", ic=" + ic + ", state=" + state + ", age=" + age + ", category=" + category
				+ ", firstdose=" + firstdose + ", seconddose=" + seconddose + ", vaccompletion=" + vaccompletion + "]";
	}
}
