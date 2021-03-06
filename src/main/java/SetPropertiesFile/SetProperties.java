package SetPropertiesFile;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

import static BasePackage.BaseClass.BrowserType;

public class SetProperties {

    public static void SetValueProperties() throws Exception {
        Properties prop = new Properties();
        OutputStream output = null;
        output = new FileOutputStream(System.getProperty("user.dir") + "//src//main//resources//Config//config.properties");
        prop.setProperty("browserType", BrowserType);
        prop.setProperty("WindowsChromeDriverPath", "/src/main/resources/Drivers/chromedriver.exe");
        prop.setProperty("MacOSChromeDriverPath", "/src/main/resources/Drivers/chromedriver");
        prop.setProperty("WindowsFirefoxDriverPath", "/src/main/resources/Drivers/geckodriver.exe");
        prop.setProperty("MacOSFirefoxDriverPath", "/src/main/resources/Drivers/geckodriver");
        prop.setProperty("ImplicitlyWait", "25");
        prop.setProperty("WaitTimeOutSeconds", "25");
        prop.setProperty("reportConfigPath", "/extent-config.xml");
        prop.setProperty("PageLoadTimeOut", "25");

        prop.store(output, null);

    }
}
