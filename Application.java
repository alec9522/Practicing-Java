package two;

public class Application {

	public static void main(String[] args) {
		PrivatePerson pp = new PrivatePerson();
		pp.setAge(20);
		pp.setName("Firstname");
		
		System.out.println("Name: " + pp.getName() + ", Age: " + pp.getAge());
	}
}
