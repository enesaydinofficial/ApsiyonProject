package BasePackage;

import static BasePackage.BaseClass.config;

public class ConfigFileReader {

    static String getReportConfigPath() {
        return System.getProperty("user.dir") + config.getProperty("reportConfigPath");
    }
}
