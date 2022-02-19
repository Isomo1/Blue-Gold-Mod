package net.isomo.bluegoldmod.item.custom;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class test extends Item {
    public test(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        player.setVelocity(player.getVelocity().x, 2, player.getVelocity().z);
        player.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 1.0f, 1.0f);
        player.getItemCooldownManager().set(this, 50);
        return TypedActionResult.success(player.getStackInHand(hand));
    }


}
