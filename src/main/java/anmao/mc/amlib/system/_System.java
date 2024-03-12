package anmao.mc.amlib.system;

public class _System {
    public static boolean isModLoaded(String modId) {
        try {
            Class.forName(modId);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
