package anmao.mc.amlib.javascript;

import com.mojang.logging.LogUtils;
import org.openjdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.slf4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import java.util.Map;

public class JavaScript {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static Object run(String code, Map<String,Object> map){
        ScriptEngineFactory sef = new NashornScriptEngineFactory();
        ScriptEngine engine = sef.getScriptEngine();
        try {
            map.forEach(engine::put);
            return engine.eval(code);
        } catch (ScriptException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
