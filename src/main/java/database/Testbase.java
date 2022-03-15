package database;



	
	import java.util.concurrent.TimeUnit;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;


	public class Testbase {
	      public WebDriver driver;
		public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vanga\\eclipse-workspace\\cucumberproject\\driver\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=login/");
		}

	}

