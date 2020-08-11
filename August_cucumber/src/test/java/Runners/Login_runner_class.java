package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Feature_Files_Folder/Login_file.feature",
                 glue= {"StepDefinition","hooks"},
                 dryRun=false,
                 monochrome=true,
                 plugin= {"json:target/jsonreport.json","html:target/htmlreport","pretty"}
                 )


public class Login_runner_class {

}
