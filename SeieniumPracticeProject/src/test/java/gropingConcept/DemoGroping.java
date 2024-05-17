package gropingConcept;
import org.testng.annotations.Test;

public class DemoGroping {
	@Test(groups= {"sanity","functional"})
	public void Test1()
	{
		System.out.println("Test1");
	}
	@Test(groups= {"sanity"})
	public void Test2()
	{
		System.out.println("Test2");
	}
	@Test(groups= {"sanity","regression"})
	public void Test3()
	{
		System.out.println("Test 3");
	}
	public void Test4()
	{
		System.out.println("Test 4");
	}

}
