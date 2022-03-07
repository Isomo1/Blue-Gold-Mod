//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.isomo.bluegoldmod.item.custom;

import net.isomo.bluegoldmod.item.ModItems;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Arkhalitz extends SwordItem {
    public Arkhalitz(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (entity instanceof PlayerEntity player) {
            if(!player.isCreative()) {
                if (player.getMainHandStack() != null && player.getMainHandStack().getItem() == ModItems.ARKHALITZ) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 100,0,false,false));
                    player.getAbilities().allowFlying = true;
                } else if (player.getOffHandStack() != null && player.getOffHandStack().getItem() == ModItems.ARKHALITZ) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 100,0,false,false));
                    player.getAbilities().allowFlying = true;
                } else if (!player.isOnGround() && player.getMainHandStack().getItem() != ModItems.ARKHALITZ) {
                    player.getAbilities().flying = false;
                } else if (!player.isOnGround() && player.getOffHandStack().getItem() != ModItems.ARKHALITZ) {
                    player.getAbilities().flying = false;
                }else{
                    player.getAbilities().allowFlying = false;
                }
            }else {
                if (player.getMainHandStack() != null && player.getMainHandStack().getItem() == ModItems.ARKHALITZ) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 100,0,false,false));
                } else if (player.getOffHandStack() != null && player.getOffHandStack().getItem() == ModItems.ARKHALITZ) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 100,0,false,false));
                }
            }
        }
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        if(player.isSneaking()){
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 60,99999,false,false));
            player.getStackInHand(hand).damage(1,player,p->p.sendToolBreakStatus(hand));
            player.playSound(SoundEvents.BLOCK_AMETHYST_BLOCK_BREAK, 1.0f, 1.0f);
            player.getItemCooldownManager().set(this, 1200);
            return TypedActionResult.success(player.getStackInHand(hand));
        }else{
            ItemStack itemStack = player.getStackInHand(hand);
            player.getStackInHand(hand).damage(1,player,p->p.sendToolBreakStatus(hand));
            world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_ENDER_EYE_DEATH, SoundCategory.NEUTRAL, 0.6F, 1.0F);
            player.getItemCooldownManager().set(this, 100);
            if (!world.isClient) {
                TeleportationEntity teleport = new TeleportationEntity(world, player);
                teleport.setItem(itemStack);
                teleport.setVelocity(player, player.getPitch(), player.getYaw(), 0.0F, 4.0F, 0.0F);
                world.spawnEntity(teleport);
                return TypedActionResult.success(itemStack, world.isClient());
            }
        }
        return TypedActionResult.success(player.getStackInHand(hand));
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return !super.isEnchantable(stack);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return !super.canRepair(stack, ingredient);
    }

    @Override
    public boolean isFireproof() {
        return !super.isFireproof();
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.bluegoldmod.arkhalitz.tooltip.shift"));
        }else{
            tooltip.add(new TranslatableText("item.bluegoldmod.arkhalitz.tooltip"));
        }
    }

}
