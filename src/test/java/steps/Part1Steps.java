package steps;


import POM.Part1POM;
import cucumber.api.java.en.And;
        import cucumber.api.java.en.Given;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import org.openqa.selenium.WebElement;
        import org.testng.Assert;


        import java.util.List;

public class Part1Steps extends BaseDriver {

    private Part1POM pom = new Part1POM(driver);


    @Given("^I navigate to \"([^\"]*)\"$")
    public void i_navigate_to(String URL) {

        driver.get(URL);
        driver.manage().window().maximize();

    }

    @When("^I try to login in by username and password\\.$")
    public void iTryToLoginInByUsernameAndPassword() {

        pom.usernameTextBox.sendKeys(username);
        pom.passwordTextBox.sendKeys(password);
        pom.loginButton.click();

    }

    @And("^I verify \"([^\"]*)\" items are displayed in the view all orders page$")
    public void iVerifyItemsAreDisplayedInTheViewAllOrdersPage(String strItemCount){

        int itemCount = Integer.parseInt(strItemCount);

        List<WebElement> items = pom.orderList;

        Assert.assertEquals(itemCount, items.size());

    }

    @Then("^I delete all items in the table$")
    public void iDeleteAllItemsInTheTable() {

        pom.checkAllButton.click();
        pom.deleteSelectedButton.click();

    }

    @And("^I verify item count is \"([^\"]*)\"$")
    public void iVerifyItemCountIs(String strItemCount) {

        int itemCount = Integer.parseInt(strItemCount);
        if(itemCount!=0){

            List<WebElement> items = pom.orderList;

            Assert.assertEquals(itemCount, items.size());

        } else {

            String listOfOrderText = pom.emptyListWarningText.getText();

            Assert.assertTrue(listOfOrderText.contains("empty"));

        }

    }

}