package commandercortex.candy2.Files;

import java.io.File;

public class PluginFiles {
    public void Path_to_Candy(){
        File _Candy = new File("plugins/candy/");
        if(!_Candy.exists())
            _Candy.mkdir();
        System.out.println("Verifying integrity of: " + _Candy);
    }
    public void Path_to_Players(){
        File _Players = new File("plugins/candy/players/");
        if(!_Players.exists())
            _Players.mkdir();
        System.out.println("Verifying integrity of: " + _Players);
    }

    public void Path_to_Config() {
        File _Config = new File("plugins/candy/config/");
        if (!_Config.exists())
            _Config.mkdir();
        System.out.println("Verifying integrity of: " + _Config);
    }
}
