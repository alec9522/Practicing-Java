package three;

public class TalkablePerson {

	String name;
	int age;
	
	public TalkablePerson(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	
	public void talk(){
		System.out.println("Hello my name is " + this.name );
	}
}
