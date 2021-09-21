package utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class Generators {
	
	private Faker faker=new Faker();
	
	public String email()
	{
		String email = faker.name().firstName() + "." + faker.name().lastName() +"@fakeEmail.com";
		return email;
	}
	
	public String first_name()
	{
		return faker.name().firstName();
	}
	
	public String last_name()
	{
		return faker.name().lastName();
	}
	
	public String phone()
	{
		return "123456789";
	}
	
	public String country()
	{
		return "Netherlands";
	}
	
	public String postCode()
	{
		return "1181WP";
	}
	
	public String houseNo()
	{
		return "1111";
	}
//	
//	public String city()
//	{
//		return faker.address().city();
//	}
//	
//	public String street()
//	{
//		return faker.address().streetName();
//	}
	

}
