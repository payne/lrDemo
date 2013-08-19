import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver


def macPath ="/Applications/Google Chrome.app/Contents/MacOS/Google Chrome"

driver = {
    //new FirefoxDriver()
    System.setProperty("webdriver.chrome.driver", macPath)

    new ChromeDriver()
}

//waiting {
//    timeout = 5
//    slow { timeout = 100 }
//}

environments {

    // run as “mvn -Dgeb.env.env=chrome integration-test”
    // See: http://code.google.com/p/selenium/wiki/ChromeDriver
chrome {
//        def cmPath="exe/win32/chromedriver.exe"
//        osArch = System.getProperty("os.arch")
//        is64Bit = osArch.contains("64")
//        if(is64Bit){
//            cmPath="exe/win64/chromedriver.exe"
//        }
//        else{
//            cmPath="exe/win32/chromedriver.exe"
//        }


        System.setProperty("webdriver.chrome.driver", macPath)

        driver = { 
            new ChromeDriver()
        }
    }


    // run as “mvn -Dgeb.env.env=firefox integration-test”
    // See: http://code.google.com/p/selenium/wiki/FirefoxDriver
    firefox {
        driver = { new FirefoxDriver() }
    }

}

