package com.meisa.intromod.events;

import com.meisa.intromod.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModEvents {

    // Invisibility with void essence
    @SubscribeEvent
    public void onVoidedEntity(AttackEntityEvent event) {
        if (event.getPlayer().getMainHandItem().getItem() == ModItems.VOID_ESSENCE.get()) {
            if (event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity) event.getTarget();

                PlayerEntity player = event.getPlayer();

                // Remove held item
                player.getMainHandItem().shrink(1);

                target.addEffect(new EffectInstance(Effects.INVISIBILITY, 10));



            }
        }
    }
}
