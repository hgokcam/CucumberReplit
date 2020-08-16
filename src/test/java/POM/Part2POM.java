package POM;



import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;

        import java.util.List;

public class Part2POM extends Part1POM {
    public Part2POM(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".menu li:last-child")
    public WebElement orderButton;

    @FindBy(css = "ol select")
    public WebElement productDropDawn;

    @FindBy(css = "input[name*=\"Quantity\"]")
    public WebElement quantityTextBox;

    @FindBy(css = "input[name*=\"Name\"]")
    public WebElement costumerNameTextBox;

    @FindBy(css = "input[name*=\"TextBox2\"]")
    public WebElement streetTextBox;

    @FindBy(css = "input[name*=\"TextBox3\"]")
    public WebElement cityTextBox;

    @FindBy(css = "input[name*=\"TextBox4\"]")
    public WebElement stateTextBox;

    @FindBy(css = "input[name*=\"TextBox5\"]")
    public WebElement zipTextBox;

    @FindBy(css = "[name*=\"cardList\"]")
    public List<WebElement> cardTypeRadio;

    @FindBy(css = "input[name*=\"TextBox6\"]")
    public WebElement cardNoTextBox;

    @FindBy(css = "input[name*=\"TextBox1\"]")
    public WebElement expeiredDateTextBox;

    @FindBy(className = "btn_light")
    public WebElement orderProcessButton;

    @FindBy(css = "[href=\"Default.aspx\"]")
    public WebElement viewAllOrdersButton;

    // column locators for "List Of Orders" table
    public By productColumn = By.cssSelector(".SampleTable tbody tr~tr td:nth-child(3)");
    public By quantityColumn = By.cssSelector(".SampleTable tbody tr~tr td:nth-child(4)");
    public By costumerNameColumn = By.cssSelector(".SampleTable tbody tr~tr td:nth-child(2)");
    public By streetColumn = By.cssSelector(".SampleTable tbody tr~tr td:nth-child(6)");
    public By cityColumn = By.cssSelector(".SampleTable tbody tr~tr td:nth-child(7)");
    public By stateColumn = By.cssSelector(".SampleTable tbody tr~tr td:nth-child(8)");
    public By zipColumn = By.cssSelector(".SampleTable tbody tr~tr td:nth-child(9)");
    public By cardTypeColumn = By.cssSelector(".SampleTable tbody tr~tr td:nth-child(10)");
    public By cardNoColumn = By.cssSelector(".SampleTable tbody tr~tr td:nth-child(11)");
    public By expiredDateColumn = By.cssSelector(".SampleTable tbody tr~tr td:nth-child(12)");
}