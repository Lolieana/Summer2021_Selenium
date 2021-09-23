package SeleniumHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homework2 {
    /**
     * TC-1: Verify error msg for blank username and password
     * 1. Launch facebook.com
     * 2. Click the log in button
     * 3. verify "The email or mobile number you entered isn’t connected to an account."
     * error msg is displayed
     */

    @Test
    public void verifyErrorMessage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        try {
            Thread.sleep(2000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By loginLocator = By.name("login");
        WebElement loginButton = driver.findElement(loginLocator);
        loginButton.click();

        By errorLocator = By.className("_9ay7");
        WebElement errorElement = driver.findElement(errorLocator);
        String actualError = errorElement.getText();
        String expectedError = "The email or mobile number you entered isn’t connected to an account. Find your account and log in.";
        Assert.assertEquals(actualError, expectedError, "Error message is incorrect.");

        try {
            Thread.sleep(5000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();

    }

    /**
     *  TC-2: Verify Gender error msg on Create New Account screen
     *  1. Launch facebook.com
     *  2. Click the Create New Account button
     *  3. Enter firstName
     *  4. Enter lastName
     *  5. Enter mobile number
     *  6. Enter new password
     *  7. Click the "Sign Up" button
     *  8. verify "Please choose a gender. You can change who can see this later."
     *      error msg is displayed
     */

    @Test
    public void verifyGenderErrorMsg() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        try {
            Thread.sleep(2000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By createAcctLocator = By.linkText("Create New Account");
        WebElement createAcctElement = driver.findElement(createAcctLocator);
        createAcctElement.click();

        try {
            Thread.sleep(2000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By firstNameLocator = By.name("firstname");
        WebElement firstNameElement = driver.findElement(firstNameLocator);
        firstNameElement.sendKeys("Test");

        By lastNameLocator = By.name("lastname");
        WebElement lastNameElement = driver.findElement(lastNameLocator);
        lastNameElement.sendKeys("Done");

        By emailPhoneLocator = By.name("reg_email__");
        WebElement emailPhoneElement = driver.findElement(emailPhoneLocator);
        emailPhoneElement.sendKeys("703-555-1212");

        By passwordLocator = By.name("reg_passwd__");
        WebElement passwordElement = driver.findElement(passwordLocator);
        passwordElement.sendKeys("Password1");

        By birthdayYearLocator = By.name("birthday_year");
        WebElement birthdayYearElement = driver.findElement(birthdayYearLocator);
        birthdayYearElement.sendKeys("1990");

        By signUpButtonLocator = By.name("websubmit");
        WebElement signUpButtonElement = driver.findElement(signUpButtonLocator);
        signUpButtonElement.click();

        By errorMessageLocator = By.cssSelector("div[class='_5633 _5634 _53ij']");
        WebElement errorMessageElement = driver.findElement(errorMessageLocator);
        String actualError = errorMessageElement.getText();

        String expectedError = "Please choose a gender. You can change who can see this later.";
        Assert.assertEquals(actualError, expectedError, "Error message is incorrect.");

        try {
            Thread.sleep(5000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    /**
     * TC-3: Verify user lands on correct webpage after click Messenger link
     *  1. Launch facebook.com
     *      found the Messenger webElement
     *      get value of "href" using getAttribute method (String)  [https://messenger.com/]
     *  2. Click "Messenger" link
     *      find the currentUrl using getCurrentUrl (String)  [https://www.messenger.com/]
     *  3. Verify user lands on correct webpage.
     *
     */

    @Test
    public void verifyMessengerLink() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        try {
            Thread.sleep(2000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        By linkLocator = By.linkText("Messenger");
        WebElement linkElement = driver.findElement(linkLocator);
        String expectedURL = linkElement.getAttribute("href");

        linkElement.click();

        try {
            Thread.sleep(2000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String currentURL = driver.getCurrentUrl();
        currentURL = currentURL.replace("www.", "");

        Assert.assertEquals(currentURL, expectedURL, "User is on incorrect page.");

        try {
            Thread.sleep(5000);     // 1 sec = 1000milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }

}
