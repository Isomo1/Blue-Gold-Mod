package net.isomo.bluegoldmod.item.custom;


import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EnderPearlEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TeleportationDevice extends Item {
    public TeleportationDevice(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_ENDER_EYE_DEATH, SoundCategory.NEUTRAL, 0.6F, 1.0F);
        user.getItemCooldownManager().set(this, 100);
        if (!world.isClient) {
            TeleportationEntity teleport = new TeleportationEntity(world, user);
            teleport.setItem(itemStack);
            teleport.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 5.0F, 0.0F);
            world.spawnEntity(teleport);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.bluegoldmod.teleportation_device.tooltip.shift"));
        }else{
            tooltip.add(new TranslatableText("item.bluegoldmod.teleportation_device.tooltip"));
        }
    }
}
