import org.openqa.selenium.firefox.FirefoxDriver


driver = {
    new FirefoxDriver()
}

//waiting {
//    timeout = 5
//    slow { timeout = 100 }
//}

environments {

    // run as “mvn -Dgeb.env.env=chrome integration-test”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
    chrome {
//        driver = { new ChromeDriver() }
    }

    // run as “mvn -Dgeb.env.env=firefox integration-test”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }

}

