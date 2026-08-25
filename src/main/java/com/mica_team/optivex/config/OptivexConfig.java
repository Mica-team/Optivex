package com.mica_team.optivex.config;

import net.minecraftforge.common.ForgeConfigSpec;

public final class OptivexConfig {

    private static final ForgeConfigSpec.Builder BUILDER =
            new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue FAST_MATH =
            BUILDER
                    .comment(
                            "Enables Optivex Fast Math.",
                            "Uses optimized mathematical calculations.",
                            "This option may slightly change floating-point precision."
                    )
                    .define("fast_math", false);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    private OptivexConfig() {
    }

    public static boolean isFastMathEnabled() {
        return FAST_MATH.get();
    }

    public static void setFastMathEnabled(boolean enabled) {
        FAST_MATH.set(enabled);
    }
}
