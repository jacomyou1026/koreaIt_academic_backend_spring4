package vo;

public class PersonVO {
	private String name,tel;
	private int age;
	
	public PersonVO() {
		System.out.println("---PersonVO의 생성자---");
	}
	
	public PersonVO(String name, int age, String tel) {
		System.out.println("---파라미터 (오버로딩)생성자---");
		this.name=name;
		this.age=age;
		this.tel=tel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		System.out.println("setNAme() :"+name);
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
