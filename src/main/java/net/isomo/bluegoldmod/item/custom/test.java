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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand){
        ItemStack itemStack = user.getStackInHand(hand);
        SnowballEntity testt = new SnowballEntity(world, user);

        testt.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
        user.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 1.0f, 1.0f);
        user.getItemCooldownManager().set(this, 50);

        return TypedActionResult.success(user.getStackInHand(hand));
    }


}
