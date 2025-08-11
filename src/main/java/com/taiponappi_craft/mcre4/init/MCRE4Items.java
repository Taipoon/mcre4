package com.taiponappi_craft.mcre4.init;

import com.taiponappi_craft.mcre4.MCRE4;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
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

    // ランカーバス
    public static final DeferredItem<Item> LUNKER_BASS = ITEMS.registerSimpleItem(
        "lunker_bass",
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

    // 緑+緑ハーブ
    private static final int mixedHerbsGG = 10;
    public static final DeferredItem<Item> MIXED_HERBS_GG = ITEMS.registerSimpleItem(
        "mixed_herbs_gg",
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(mixedHerbsGG).saturationModifier(2f).build()
            ).stacksTo(1).fireResistant()
    );

    // 緑+赤ハーブ
    private static final int mixedHerbsGR = 20;
    public static final DeferredItem<Item> MIXED_HERBS_GR = ITEMS.registerSimpleItem(
        "mixed_herbs_gr",
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(mixedHerbsGR).saturationModifier(2f).build()
            ).stacksTo(1).fireResistant()
    );

    // 緑+黄ハーブ
    private static final int mixedHerbsGY = greenHerbNutrition;
    public static final DeferredItem<Item> MIXED_HERBS_GY = ITEMS.registerSimpleItem(
        "mixed_herbs_gy",
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(mixedHerbsGY).saturationModifier(2f).build()
        )
    );

    // 赤+黄ハーブ
    public static final DeferredItem<Item> MIXED_HERBS_RY = ITEMS.registerSimpleItem(
        "mixed_herbs_ry",
        new Item.Properties().stacksTo(1).fireResistant()
    );

    // 緑+緑+緑ハーブ
    private static final int mixedHerbsGGG = mixedHerbsGR;
    public static final DeferredItem<Item> MIXED_HERBS_GGG = ITEMS.registerSimpleItem(
        "mixed_herbs_ggg",
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(mixedHerbsGGG).saturationModifier(2f).build()
        ).stacksTo(1).fireResistant()
    );

    // 緑+赤+黄ハーブ
    private static final int mixedHerbsGRY = mixedHerbsGR;
    public static final DeferredItem<Item> MIXED_HERBS_GRY = ITEMS.registerSimpleItem(
        "mixed_herbs_gry",
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(mixedHerbsGRY).saturationModifier(2f).build()
        ).stacksTo(1).fireResistant()
    );

    // 救急スプレー
    private static final int firstAidSpray = mixedHerbsGR;
    public static final DeferredItem<Item> FIRST_AID_SPRAY = ITEMS.registerSimpleItem(
        "first_aid_spray",
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(firstAidSpray).saturationModifier(2f).build()
        ).stacksTo(1).fireResistant()
    );

    // 卵
    private static final int chickenEgg = 5;
    public static final DeferredItem<Item> CHICKEN_EGG = ITEMS.registerSimpleItem(
        "chicken_egg",
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(chickenEgg).saturationModifier(2f).build()
        ).stacksTo(1).fireResistant()
    );

    // 卵(茶)
    private static final int brownChickenEgg = 15;
    public static final DeferredItem<Item> BROWN_CHICKEN_EGG = ITEMS.registerSimpleItem(
        "brown_chicken_egg",
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(brownChickenEgg).saturationModifier(2f).build()
        ).stacksTo(1).fireResistant()
    );

    // 卵(金)
    private static final int goldChickenEgg = mixedHerbsGR;
    public static final DeferredItem<Item> GOLD_CHICKEN_EGG = ITEMS.registerSimpleItem(
        "gold_chicken_egg",
        new Item.Properties().food(
            new FoodProperties.Builder()
                .nutrition(goldChickenEgg).saturationModifier(2f).build()
        ).stacksTo(1).fireResistant()
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> RECOVERY_ITEMS_TAB = CREATE_MODE_TABS.register(
        "recovery_items",
        () -> CreativeModeTab.builder()
        .title(Component.translatable("itemGroup.mcre4.recovery_items"))
        .icon(() -> GREEN_HERB.get().getDefaultInstance())
        .displayItems((parameters, output) -> {
            // ハーブ
            output.accept(GREEN_HERB.get());
            output.accept(YELLOW_HERB.get());
            output.accept(RED_HERB.get());

            // ハーブ2種類組み合わせ
            output.accept(MIXED_HERBS_GG.get());
            output.accept(MIXED_HERBS_GR.get());
            output.accept(MIXED_HERBS_GY.get());
            output.accept(MIXED_HERBS_RY.get());

            // ハーブ3種類組み合わせ
            output.accept(MIXED_HERBS_GGG.get());
            output.accept(MIXED_HERBS_GRY.get());

            // 救急スプレー
            output.accept(FIRST_AID_SPRAY.get());

            // ブラックバス/ランカーバス
            output.accept(BLACK_BASS.get());
            output.accept(LUNKER_BASS.get());

            // 卵
            output.accept(CHICKEN_EGG.get());
            output.accept(BROWN_CHICKEN_EGG.get());
            output.accept(GOLD_CHICKEN_EGG.get());
        }).build());


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        CREATE_MODE_TABS.register(eventBus);
    }
}
