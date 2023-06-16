package com.jetpacker06.codysmod.events;

import com.jetpacker06.codysmod.CodysMod;
import com.jetpacker06.codysmod.enchant.AllEnchantments;
import com.jetpacker06.codysmod.item.DyeColorUtil;
import com.jetpacker06.codysmod.math.Weight;
import com.jetpacker06.codysmod.tag.AllTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.animal.Sheep;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CodysMod.MOD_ID)
public class GameEvents {
    //@SubscribeEvent
    public static void handleShear(PlayerInteractEvent.EntityInteract event) {
        if (!(event.getEntity().getItemInHand(event.getHand()).is(AllTags.SHEARS)
            & event.getTarget() instanceof Sheep)) {
            return;
        }

        int enchantLevel = event.getEntity().getItemInHand(event.getHand()).getEnchantmentLevel(AllEnchantments.WOOL_FORTUNE.get());
        BlockPos eventPos = event.getTarget().getOnPos().above();

        int weighted1 = 2;
        int weighted2 = 2;
        int weighted3 = 1;
        switch (enchantLevel) {
            case 1 -> {
                weighted2 = 1;
            }
            case 2 -> {
                weighted2 = 3;
                weighted3 = 2;
            }
            case 3 -> {
                weighted1 = 1;
                weighted2 = 3;
                weighted3 = 3;
            }
        }
        int amount = Weight.weighInts(
                new Weight.Pair(weighted1, 1),
                new Weight.Pair(weighted2, 2),
                new Weight.Pair(weighted3, 3)
        );
        //System.out.println("Bonus wool drop: " + amount);
        Containers.dropItemStack(
                event.getLevel(),
                eventPos.getX(),
                eventPos.getY(),
                eventPos.getZ(),
                new ItemStack(
                        DyeColorUtil.getWoolItemByDyeColor(
                            ((Sheep) event.getTarget()).getColor()
                        ),
                        amount
                )
        );
    }
}
