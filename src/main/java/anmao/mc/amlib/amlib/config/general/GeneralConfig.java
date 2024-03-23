package anmao.mc.amlib.amlib.config.general;

import anmao.mc.amlib.CDT;
import anmao.mc.amlib.json.JsonConfig;
import com.google.gson.reflect.TypeToken;

public class GeneralConfig extends JsonConfig<GeneralConfigData> {
    public GeneralConfig() {
        super(CDT.ConfigDir +"general.json", """
                    {
                      "mixinAttributes": true,
                      "showTipGui": true
                    }""", new TypeToken<>() {
        });
    }
}
