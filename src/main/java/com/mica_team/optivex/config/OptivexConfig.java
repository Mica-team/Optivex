package com.mica_team.optivex.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;

public final class OptivexConfig {

    private static final ForgeConfigSpec.Builder BUILDER =
            new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue FAST_MATH =
            BUILDER
                    .comment(
                            "Uses optimized trigonometric calculations.",
                            "May slightly change mathematical precision."
                    )
                    .define("fast_math", false);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    private OptivexConfig() {
    }

    public static void load() {
        ModLoadingContext.get().registerConfig(
                ModConfig.Type.CLIENT,
                SPEC,
                "optivex-client.toml"
        );
    }

    public static boolean isFastMathEnabled() {
        return FAST_MATH.get();
    }

    public static void setFastMathEnabled(boolean enabled) {
        FAST_MATH.set(enabled);
    }
}
