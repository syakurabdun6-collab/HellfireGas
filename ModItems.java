
package com.hellfiregas;

import java.util.function.Function;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTabs;

import net.fabricmc.fabric.api.itemgroup.v1.CreativeModeTabEvents;

public class ModItems {

    public static final Item CHAINSAW = register(
        "chainsaw",
        Item::new,
        new Item.Properties()
    );

    private static <T extends Item> T register(
        String name,
        Function<Item.Properties, T> factory,
        Item.Properties properties
    ) {
        ResourceKey<Item> key = ResourceKey.create(
            Registries.ITEM,
            Identifier.fromNamespaceAndPath("hellfiregas", name)
        );

        T item = factory.apply(properties.setId(key));
        Registry.register(BuiltInRegistries.ITEM, key, item);
        return item;
    }

    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT)
            .register(entries -> entries.accept(CHAINSAW));
    }
                          }
