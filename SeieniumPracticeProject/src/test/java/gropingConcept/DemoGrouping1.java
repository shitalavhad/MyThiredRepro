package gropingConcept;

import org.testng.annotations.Test;

public class DemoGrouping1 {
	@Test(groups= {"sanity","functional"})
	public void Test5()
	{
		System.out.println("Test5");
	}
	@Test(groups= {"sanity"})
	public void Test6()
	{
		System.out.println("Test6");
	}
	@Test(groups= {"sanity","regression"})
	public void Test7()
	{
		System.out.println("Test 7");
	}
	public void Test8()
	{
		System.out.println("Test 8");
	}

}
