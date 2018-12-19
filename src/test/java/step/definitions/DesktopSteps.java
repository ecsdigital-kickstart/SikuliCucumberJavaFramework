package step.definitions;

import config.SikuliConfiguration;
import step.pageObject.General;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;

import java.util.logging.Logger;

public class DesktopSteps {

    private Screen screen;
    Logger logger = Logger.getLogger(Hooks.class.getName());
    General general = new General();

    @Before
    public void setConfig() throws Exception {
        screen = new Screen();
        SikuliConfiguration.setSikuliSettings();
    }

    @Given("^I click on the lync icon$")
    public void I_am_a_test() throws Throwable {
        screen.click("lyncimage.png", 10);
    }

    @Given("^The mouse moves to the corners of the screen$")
    public void click_system_preferences() throws FindFailed {
        general.cornerMouseMove(screen);
    }

    @Given("^I go crazy with the mouse$")
    public void crazyMouse() throws FindFailed {
        general.crazyMouseMove(screen, logger);
    }

    @When("^I right click \"([^\"]*)\"$")
    public void rightClickButton(String button) throws FindFailed {
        screen.rightClick(screen.find(button));
    }

     @When("^I type \"([^\"]*)\"$")
    public void typeText(String text) throws FindFailed {
        screen.type(text);
    }

    @Then("^I should see \"([^\"]*)\"$")
    public void assertVisible(String image) throws FindFailed {
        assert screen.exists(image,90) != null;
    }

}
