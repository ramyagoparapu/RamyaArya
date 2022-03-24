package stepdefinition;

import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import database.Databasepage;
import database.Loginpage;
import database.Testbase;
import junit.framework.Assert;

public class Stepdefntion extends Testbase {
	Loginpage lp;
	Databasepage dbp;

	@Before
	public void Beforerun() {
		init();
		lp = PageFactory.initElements(driver, Loginpage.class);
		dbp = new Databasepage();

	}

	// Given user should land on techfios page
	@Given("^user should land on techfios page$")
	public void user_should_land_on_techfios_page() {
		// driver.get("https://techfios.com/billing/?ng=login/");
		System.out.println("user should land on techfios page");
	}

	@When("^user should enter \"([^\"]*)\" from september2021 database$")
	public void user_should_enter_from_september2021_database(String Logindata) throws Throwable {
		switch (Logindata) {
		case "username":
			lp.enterUsername(dbp.takedatafromDB("username"));
			System.out.println("username from DB:" + dbp.takedatafromDB("username"));
			break;

		case "password":
			lp.enterPassword(dbp.takedatafromDB("password"));
			System.out.println("password from DB:" + dbp.takedatafromDB("password"));
			break;
		default:
//			System.out.println("unable to pull data from DB");
		}

	}

	// When user should click signin button
	@When("^user should click signin button$")
	public void user_should_click_signin_button() {
		lp.clickSignInButton();

	}

	// Then user should land on dashboard page
	@Then("^user should land on dashboard page$")
	public void user_should_land_on_dashboard_page() {
		String expectedval = "Dashboard- iBilling";
		String actualval = lp.getPageTitle();
		Assert.assertEquals(expectedval, actualval);
		System.out.println("expectedval and actualval both are same ,page matched");

	}


}
