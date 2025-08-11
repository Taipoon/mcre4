package com.taiponappi_craft.mcre4.init;

import com.taiponappi_craft.mcre4.MCRE4;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MCRE4Items {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MCRE4.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MCRE4.MOD_ID);

    // ブラックバス
    public static final DeferredItem<Item> BLACK_BASS = ITEMS.registerSimpleItem(
        "black_bass",
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(1).saturationModifier(2f).build()
        ).stacksTo(1)
    );

    // 緑ハーブ
    private static final int greenHerbNutrition = 5;
    public static final DeferredItem<Item> GREEN_HERB = ITEMS.registerSimpleItem(
        "green_herb",
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(greenHerbNutrition).saturationModifier(2f).build()
        ).stacksTo(1).fireResistant()
    );

    // 赤ハーブ
    public static final DeferredItem<Item> RED_HERB = ITEMS.registerSimpleItem(
        "red_herb",
        new Item.Properties().stacksTo(1).fireResistant()
    );

    // 黄ハーブ
    public static final DeferredItem<Item> YELLOW_HERB = ITEMS.registerSimpleItem(
        "yellow_herb",
        new Item.Properties().stacksTo(1).fireResistant()
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RECOVERY_ITEMS_TAB = CREATE_MODE_TABS.register(
        "recovery_items",
        () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup.mcre4.recovery_items")) //The language key for the title of your CreativeModeTab
        .icon(() -> GREEN_HERB.get().getDefaultInstance())
        .displayItems((parameters, output) -> {
            output.accept(GREEN_HERB.get());
            output.accept(YELLOW_HERB.get());
            output.accept(RED_HERB.get());
            output.accept(BLACK_BASS.get());
        }).build());


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        CREATE_MODE_TABS.register(eventBus);
    }
}
