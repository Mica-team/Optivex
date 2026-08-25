package com.mica_team.optivex;

import com.mica_team.optivex.config.OptivexConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(Optivex.MOD_ID)
public class Optivex {

    public static final String MOD_ID = "optivex";

    public Optivex() {
        ModLoadingContext.get().registerConfig(
                ModConfig.Type.CLIENT,
                OptivexConfig.SPEC,
                "optivex-client.toml"
        );
    }
}
