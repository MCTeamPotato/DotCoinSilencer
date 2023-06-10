package com.teampotato.dotcoinsilencer;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(DotCoinSilencer.ID)
public class DotCoinSilencer {
    public static final String ID = "dotcoinsilencer";

    public static ForgeConfigSpec configSpec;
    public static ForgeConfigSpec.BooleanValue sendMessage;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.push("DotCoinSilencer");
        sendMessage = builder.define("sendMessage", false);
        builder.pop();
        configSpec = builder.build();
    }

    public DotCoinSilencer() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, configSpec);
    }
}
