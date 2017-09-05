package me.sirlich.AsmodeusRpg;

import me.sirlich.AsmodeusRpg.customMobs.CustomZombie;
import me.sirlich.AsmodeusRpg.customMobs.ShopKeeper;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AsmodeusRpg extends JavaPlugin {
    @Override
    public void onEnable() {
        NMSUtils.registerEntity("ranged_zombie", NMSUtils.Type.ZOMBIE, CustomZombie.class, false);
        NMSUtils.registerEntity("shop_keeper", NMSUtils.Type.VILLAGER, ShopKeeper.class, false);
        initiateShopKeeper();
        System.out.println("Its working better!");
    }

    @Override
    public void onDisable(){
        System.out.println("Asmodeus disabled");
    }

    private void initiateShopKeeper(){
        System.out.println("Inside!");
        try {
            BufferedReader br = new BufferedReader(new FileReader(getDataFolder()+ "/ArmourSmith.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                List<String> arr = Arrays.asList(line.split(","));
                World world = Bukkit.getServer().getWorld("world");
                Location loc = new Location(world,Double.parseDouble(arr.get(0)),Double.parseDouble(arr.get(1)),Double.parseDouble(arr.get(2)));
                world.spawnEntity(loc, EntityType.VILLAGER);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        }
    }
}
