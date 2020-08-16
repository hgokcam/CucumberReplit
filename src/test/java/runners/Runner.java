package runners;


import cucumber.api.CucumberOptions;
        import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {
        "src\\test\\java\\featureFiles\\AllParts.feature"
},
        glue="steps"
)

public class Runner extends AbstractTestNGCucumberTests {

}