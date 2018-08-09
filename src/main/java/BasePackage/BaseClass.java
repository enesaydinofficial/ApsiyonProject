package BasePackage;

import SetPropertiesFile.SetProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.FileReaderManager;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static KeywordLayer.Command.ImplicitlyWait;
import static KeywordLayer.Command.PageLoad;

public class BaseClass {

    public static WebDriver driver;
    public static Properties config = null;
    public static String BaseURL = "https://www.apsiyon.com/";
    public static String BrowserType = "Chrome";
    private static String OS = System.getProperty("os.name").toUpperCase();


    public static void LoadConfigProperty() throws IOException {
        config = new Properties();
        FileInputStream ConfigFile = new FileInputStream(System.getProperty("user.dir") + "//src//main//resources//Config//config.properties");
        config.load(ConfigFile);
    }

    @Before
    public void Init() throws Exception {

        SetProperties.SetValueProperties(); // Set value config.properties file

        LoadConfigProperty();
        if (config.getProperty("browserType").equals("Chrome")) {

            if (OS.contains("MAC OS X")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + config.getProperty("MacOSChromeDriverPath"));
            } else if (OS.contains("WİNDOWS 10") || OS.contains("WINDOWS 10")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + config.getProperty("WindowsChromeDriverPath"));
            }

            driver = new ChromeDriver();
        } else if (config.getProperty("browserType").equals("Firefox")) {

            if (OS.contains("MAC OS X")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + config.getProperty("MacOSFirefoxDriverPath"));
            } else if (OS.contains("WİNDOWS 10") || OS.contains("WINDOWS 10")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + config.getProperty("WindowsFirefoxDriverPath"));
            }

            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        ImplicitlyWait();
        PageLoad();

    }

    @After
    public void Teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass()
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
    }

}

