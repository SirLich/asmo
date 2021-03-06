package me.sirlich.AsmodeusRpg.mobs.monsters;

import me.sirlich.AsmodeusRpg.mobs.pathfinders.PFGMeleeAttack;
import me.sirlich.AsmodeusRpg.mobs.pathfinders.PFGSpawnChildren;
import net.minecraft.server.v1_12_R1.*;
import org.bukkit.craftbukkit.v1_12_R1.CraftServer;
import org.bukkit.craftbukkit.v1_12_R1.entity.*;

public class RpgLich extends EntitySkeleton
{

    public RpgLich(World world)
    {
        super(world);
        this.bukkitEntity = new CraftRpgLich(this.world.getServer(),this);
    }

    @Override
    public void r(){
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PFGMeleeAttack(this));
        this.goalSelector.a(2,new PFGSpawnChildren(this));
        this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
        this.goalSelector.a(7, new PathfinderGoalRandomStrollLand(this, 1.0D));
        this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
        this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
        this.targetSelector.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
    }

    private static class CraftRpgLich extends CraftSkeleton
    {
        private CraftRpgLich(CraftServer server, EntitySkeleton parent)
        {
            super(server, parent);
        }

    }
}
