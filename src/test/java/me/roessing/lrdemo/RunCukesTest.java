package me.roessing.lrdemo;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
/**
 * @author Rolf Roessing
 * @version $Revision: $:
 * @since 16.07.13
 */
@RunWith(Cucumber.class)
@Cucumber.Options(format = {"html:build/reports/tests/cucumber-report"},
                  features = "src/test/cucumber",
                  glue ={"src/test/cucumber"} ,tags = "@improove")
public class RunCukesTest {


}
