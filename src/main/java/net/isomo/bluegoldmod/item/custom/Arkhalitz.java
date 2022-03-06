//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package net.isomo.bluegoldmod.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.ImmutableMultimap.Builder;
import net.isomo.bluegoldmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.attribute.EntityAttributeModifier.Operation;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Arkhalitz extends ToolItem {
    private final Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers;

    public Arkhalitz(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, settings);
        float attackDamage1 = (float) attackDamage + toolMaterial.getAttackDamage();
        Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Weapon modifier", (double) attackDamage1, Operation.ADDITION));
        builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_ID, "Weapon modifier", (double)attackSpeed, Operation.ADDITION));
        this.attributeModifiers = builder.build();
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
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()){
            tooltip.add(new TranslatableText("item.bluegoldmod.arkhalitz.tooltip.shift"));
        }else{
            tooltip.add(new TranslatableText("item.bluegoldmod.arkhalitz.tooltip"));
        }
    }

    public boolean canMine(BlockState state, World world, BlockPos pos, PlayerEntity miner) {
        return !miner.isCreative();
    }

    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        if (state.isOf(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            Material material = state.getMaterial();
            return material != Material.PLANT && material != Material.REPLACEABLE_PLANT && !state.isIn(BlockTags.LEAVES) && material != Material.GOURD ? 1.0F : 1.5F;
        }
    }

    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, (e) -> {
            e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
        });
        return true;
    }

    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0F) {
            stack.damage(2, miner, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    public boolean isSuitableFor(BlockState state) {
        return state.isOf(Blocks.COBWEB);
    }

    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        return slot == EquipmentSlot.MAINHAND ? this.attributeModifiers : super.getAttributeModifiers(slot);
    }
}
