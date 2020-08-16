package POM;


import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;

        import java.util.List;

public class Part1POM {
    public Part1POM(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".login [type=\"text\"]")
    public WebElement usernameTextBox;

    @FindBy(css = ".login [type=\"password\"]")
    public WebElement passwordTextBox;

    @FindBy(className = "button")
    public WebElement loginButton;

    @FindBy(css = ".SampleTable tbody tr~tr")
    public List<WebElement> orderList;

    @FindBy(css = ".CheckUncheck a:first-child")
    public WebElement checkAllButton;

    @FindBy(css = ".btnDeleteSelected")
    public WebElement deleteSelectedButton;

    @FindBy(css = ".content div:nth-child(3)")
    public WebElement emptyListWarningText;






}