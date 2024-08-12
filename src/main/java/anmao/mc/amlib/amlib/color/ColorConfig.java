package anmao.mc.amlib.amlib.color;

import anmao.dev.core.json.JsonConfig;
import anmao.mc.amlib.CDT;
import com.google.gson.reflect.TypeToken;

public class ColorConfig extends JsonConfig<ColorConfigData> {
    public static String filePath = CDT.ConfigDir +"color.json";
    public static ColorConfig instance = new ColorConfig();
    public ColorConfig() {
        super(filePath, """
                {
                  "colorScheme": "amlib:default"
                }
                """, new TypeToken<>() {});
    }
}
