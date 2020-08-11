package Runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {".//Feature_Files_Folder/Addingnew_product.feature",".//Feature_Files_Folder/Login_file.feature"},
                 glue= {"StepDefinition","hooks"},
                 dryRun=false,
                 monochrome=true,
                 plugin= {"json:target/addprocutreport.json","html:target/addproduct","pretty"}
                 )
public class Adding_Product_runner {

}
