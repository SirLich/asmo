package me.sirlich.AsmodeusRpg.core;
import java.util.HashMap;

import me.sirlich.AsmodeusRpg.abilities.Ability;
import me.sirlich.AsmodeusRpg.abilities.DoubleJumpAbility;
import org.bukkit.entity.Player;

public class PlayerList {

    public static HashMap <Player,RpgPlayer> rpgPlayerHashMap = new HashMap<>();
    public static HashMap <RpgPlayer,Player> playerHashMap = new HashMap<>();

    public static void addPlayer(Player player){
        RpgPlayer rpgPlayer = new RpgPlayer();
        Ability toggleFlyAbility = new Ability(player);
        Ability switchHandAbility = new DoubleJumpAbility(player);
        Ability dropWeaponAbility = new Ability(player);

        rpgPlayer.setMobilityAbility(toggleFlyAbility);
        rpgPlayer.setCarnageAbility(switchHandAbility);
        rpgPlayer.setMythicalAbility(dropWeaponAbility);

        rpgPlayerHashMap.put(player,rpgPlayer);
        playerHashMap.put(rpgPlayer,player);
    }

    public static void removePlayer(Player player){
        RpgPlayer rpgPlayer = rpgPlayerHashMap.get(player);
        playerHashMap.remove(rpgPlayer);
        rpgPlayerHashMap.remove(player);
    }
    public static RpgPlayer getRpgPlayer(Player player){
        return rpgPlayerHashMap.get(player);
    }

    public static Player getPlayer(RpgPlayer rpgPlayer){
        Player player = playerHashMap.get(rpgPlayer);
        System.out.println(player.getName());
        return player;
    }

    public static boolean isPlayerOnline(Player player){
        return rpgPlayerHashMap.containsKey(player);
    }
}
