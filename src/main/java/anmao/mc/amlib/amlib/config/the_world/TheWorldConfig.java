package anmao.mc.amlib.amlib.config.the_world;


import anmao.dev.core.json.JsonConfig;
import anmao.mc.amlib.CDT;
import com.google.gson.reflect.TypeToken;

public class TheWorldConfig extends JsonConfig<TheWorldConfigData> {
    public TheWorldConfig() {
        super(CDT.ConfigDir +"TheWorld.json", """
                {
                  "enable": true,
                  "type": 1,
                  "stopTime": 600
                }""", new TypeToken<>() {
        });
    }
}
