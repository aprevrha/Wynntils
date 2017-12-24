package com.wynndevs.modules.market.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

import java.util.ArrayList;
import java.util.List;

public class MarketUtils {

    /**
     * Get the lore from an item
     *
     * @param item
     *
     * @return an {@link List} containing all item lore
     */
    public static List<String> getLore(ItemStack item) {
        List<String> lore = new ArrayList<>();
        if(item == null || !item.hasTagCompound()) {
            return lore;
        }
        if (item.getTagCompound().hasKey("display", 10)) {
            NBTTagCompound nbttagcompound = item.getTagCompound().getCompoundTag("display");

            if (nbttagcompound.getTagId("Lore") == 9) {
                NBTTagList nbttaglist3 = nbttagcompound.getTagList("Lore", 8);

                if (!nbttaglist3.hasNoTags()) {
                    for (int l1 = 0; l1 < nbttaglist3.tagCount(); ++l1) {
                        lore.add(nbttaglist3.getStringTagAt(l1));
                    }
                }
            }
        }
        return lore;
    }

}