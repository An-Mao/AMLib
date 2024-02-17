package anmao.mc.amlib.amlib.config.attribute;

import anmao.mc.amlib.CDT;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;

public class AttributeConfig {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final String configFile = CDT.ConfigDir +"attribute-config.json";
    static {
        init();
    }


    public static Map<String, AttributeData> config;
    public static void init(){
        File file = new File(configFile);
        if (!file.exists()){
            reset();
        }
        load();
    }
    private static void reset(){
        try (FileWriter writer = new FileWriter(configFile)) {
            writer.write("""
                    {
                      "attribute.name.generic.max_health": {
                        "min": 1.0,
                        "def": 20.0,
                        "max": 999999999999999.0
                      },
                      "attribute.name.generic.attack_damage": {
                        "min": 0.0,
                        "def": 2.0,
                        "max": 999999999999999.0
                      },
                      "attribute.name.generic.armor": {
                        "min": 0.0,
                        "def": 0.0,
                        "max": 999999999999999.0
                      },
                      "attribute.name.generic.armor_toughness": {
                        "min": 0.0,
                        "def": 0.0,
                        "max": 999999999999999.0
                      }
                    }""");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
    private static void load(){
        Gson gson = new Gson();
        try (Reader reader = new FileReader(configFile)) {
            Type type = new TypeToken<Map<String, AttributeData>>() {}.getType();
            config = gson.fromJson(reader, type);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
