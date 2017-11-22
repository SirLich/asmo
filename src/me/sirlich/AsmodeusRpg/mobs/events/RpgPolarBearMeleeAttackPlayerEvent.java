package me.sirlich.AsmodeusRpg.mobs.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RpgPolarBearMeleeAttackPlayerEvent extends Event
{
    private static final HandlerList handlers = new HandlerList();
    public Player getPlayer()
    {
        return player;
    }

    public Entity getEntity(){
        return entity;
    }

    private final Player player;
    private final Entity entity;

    public RpgPolarBearMeleeAttackPlayerEvent(Player player, Entity entity){
        this.player = player;
        this.entity = entity;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}