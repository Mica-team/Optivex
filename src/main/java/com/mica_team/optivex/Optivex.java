package com.mica_team.optivex;

import com.mica_team.optivex.client.PerformanceScreen;
import com.mica_team.optivex.config.OptivexConfig;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(Optivex.MOD_ID)
public class Optivex {

    public static final String MOD_ID = "optivex";

    public Optivex() {
        OptivexConfig.load();

        ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        (minecraft, parent) -> new PerformanceScreen(parent)
                )
        );

        MinecraftForge.EVENT_BUS.register(this);
    }
          }
