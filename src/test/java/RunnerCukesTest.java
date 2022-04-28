import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false    //Does not run any code content in the step definition when it is true
        , monochrome = true    //Make text on the console readable
        , snippets = SnippetType.CAMELCASE        //Used to determine what the method of the Step Def would be
        , strict = false     //Skip execution of pending and undefined steps if true
        , plugin = {"pretty",
        "html:target/test-report/cucumber-html-report",
        "json:target/test-report/CucumberTestReport.json",
        "rerun:target/test-report/rerun.txt"
}

        , features = ("src/test/resources/features")
        , tags = {"@wip"}

)

public class RunnerCukesTest {
}
