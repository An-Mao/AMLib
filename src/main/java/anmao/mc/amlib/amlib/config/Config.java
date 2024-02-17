package anmao.mc.amlib.amlib.config;

import anmao.mc.amlib.CDT;
import com.google.gson.Gson;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import java.io.*;

public class Config {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final String configFile = CDT.ConfigDir +"config.json";

    public static ConfigData config;

    static {
        init();
    }
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
                      "mixinAttributes": true
                    }""");
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
    private static void load(){
        Gson gson = new Gson();
        try (Reader reader = new FileReader(configFile)) {
            config = gson.fromJson(reader, ConfigData.class);
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
    }
}
