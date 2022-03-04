package net.isomo.bluegoldmod.item.custom;


import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
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

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        player.getStackInHand(hand).damage(1,player,p->p.sendToolBreakStatus(hand));
        world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ENDER_EYE_DEATH, SoundCategory.NEUTRAL, 0.6F, 1.0F);
        player.getItemCooldownManager().set(this, 100);
        if (!world.isClient) {
            TeleportationEntity teleport = new TeleportationEntity(world, player);
            teleport.setItem(itemStack);
            teleport.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 4.0F, 0.0F);
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
