package steps;


import POM.Part2POM;
import cucumber.api.DataTable;
        import cucumber.api.java.en.And;
        import cucumber.api.java.en.Then;
        import cucumber.api.java.en.When;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.Select;
        import org.testng.Assert;


        import java.util.List;
        import java.util.Map;

public class Part2Steps extends BaseDriver {

    private Part2POM pom = new Part2POM(driver);


    @Then("^I fill the order form and confirm$")
    public void iFillTheOrderForm(DataTable table) {
        List<Map<String, String>> mapList = table.asMaps(String.class, String.class);
        int numNewOrders = mapList.size();
        for ( Map<String, String> row: mapList) {
            for (String key: row.keySet()) {
                runOrderFieldProcess( key, row.get(key) );
            }
            pom.orderProcessButton.click();
        }
    }

    public void selectProductType(String product) {
        Select select = new Select(pom.productDropDawn);
        switch (product) {
            case "MyMoney":
                select.selectByVisibleText("MyMoney");
                break;
            case "FamilyAlbum":
                select.selectByVisibleText("FamilyAlbum");
                break;
            case "ScreenSaver":
                select.selectByVisibleText("ScreenSaver");
                break;
            default:
                Assert.fail(product + " not implemented for search fields");
        }
    }

    public void selectCardType(String product) {
        List<WebElement> cardTypes = pom.cardTypeRadio;
        switch (product.toLowerCase()) {
            case "visa":
                cardTypes.get(0).click();
                break;
            case "mastercard":
                cardTypes.get(1).click();
                break;
            case "american express":
                cardTypes.get(2).click();
                break;
            case "americanexpress":
                cardTypes.get(2).click();
                break;
            default:
                Assert.fail(product + " not implemented for search fields");
        }
    }

    public void runOrderFieldProcess(String key, String value) {

        switch (key) {
            case "Product":
                selectProductType(value);
                break;
            case "Quantity":
                pom.quantityTextBox.sendKeys(value);
                break;
            case "CostumerName":
                pom.costumerNameTextBox.sendKeys(value);
                break;
            case "Street":
                pom.streetTextBox.sendKeys(value);
                break;
            case "City":
                pom.cityTextBox.sendKeys(value);
                break;
            case "State":
                pom.stateTextBox.sendKeys(value);
                break;
            case "Zip":
                pom.zipTextBox.sendKeys(value);
                break;
            case "CardType":
                selectCardType(value);
                break;
            case "CardNo":
                pom.cardNoTextBox.sendKeys(value);
                break;
            case "Exp.Date":
                pom.expeiredDateTextBox.sendKeys(value);
                break;
            default:
                Assert.fail(key + " not implemented for search fields");
        }

    }

    @When("^I click on Order$")
    public void iClickOnOrder() {
        int numberOrder = pom.orderList.size();


        pom.orderButton.click();
    }

    @And("^I click on View All Order button$")
    public void iClickOnViewAllOrderButton() {

        pom.viewAllOrdersButton.click();

    }

    @Then("^I verify my orders\\.$")
    public void iVerifyMyOrders(DataTable table) {
        List<Map<String, String>> mapList = table.asMaps(String.class, String.class);
        for ( Map<String, String> row: mapList) {
            for (String key: row.keySet()) {
                checkOrder( key, row.get(key) );
            }
            pom.orderProcessButton.click();
        }
    }

    public void checkOrder(String key, String value) {
        for (WebElement element:pom.orderList){

            String text=null;
            switch (key) {
                case "Product":
                    text = element.findElement(pom.productColumn).getText();
                    break;
                case "Quantity":
                    text = element.findElement(pom.quantityColumn).getText();
                    break;
                case "CostumerName":
                    text = element.findElement(pom.costumerNameColumn).getText();
                    break;
                case "Street":
                    text = element.findElement(pom.streetColumn).getText();
                    break;
                case "City":
                    text = element.findElement(pom.cityColumn).getText();
                    break;
                case "State":
                    text = element.findElement(pom.stateColumn).getText();
                    break;
                case "Zip":
                    text = element.findElement(pom.zipColumn).getText();
                    break;
                case "CardType":
                    text = element.findElement(pom.cardTypeColumn).getText();
                    break;
                case "CardNo":
                    text = element.findElement(pom.cardNoColumn).getText();
                    break;
                case "Exp.Date":
                    text = element.findElement(pom.expiredDateColumn).getText();
                    break;
                default:
                    Assert.fail(key + " not implemented for search fields");
            }
            Assert.assertEquals(value, text);


        }

    }

}