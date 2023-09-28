package seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;



public class test {

	public static void main(String[] args)
	{
		try {
				System.setProperty("webdriver.edge.driver","src//msedgedriver.exe");
				WebDriver driver = new EdgeDriver();
				driver.manage().window().maximize();
				String baseUrl="http://live.techpanda.org/index.php/";
				driver.get(baseUrl);
				String checkTitle = driver.getTitle();
				if(checkTitle.contentEquals("Home page"))
				{
					System.out.println("Title varified");
				}
				else {
					System.out.println("wrong Home Page Title");
				}
				driver.findElement(By.linkText("MOBILE")).click();
				String checkNextTitle = driver.getTitle();
				if(checkNextTitle.contentEquals("Mobile"))
				{
					System.out.println("mobile title varified");
				}
				else {
					System.out.println("wrong Title");
				}
				WebElement Dropdown = driver.findElement(By.xpath("//select[@title='Sort By']"));
				Select options = new Select(Dropdown);
				options.selectByVisibleText("Name");
				Thread.sleep(5000);
				driver.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
