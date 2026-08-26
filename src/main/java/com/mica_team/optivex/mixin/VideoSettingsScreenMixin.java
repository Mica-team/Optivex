package com.mica_team.optivex.mixin;

import com.mica_team.optivex.client.PerformanceScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.VideoSettingsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VideoSettingsScreen.class)
public class VideoSettingsScreenMixin {

    @Inject(method = "init", at = @At("TAIL"))
    private void optivex$addPerformanceButton(CallbackInfo ci) {
        VideoSettingsScreen screen = (VideoSettingsScreen) (Object) this;

        System.out.println("[Optivex] Adding Performance button");

        this.addRenderableWidget(
            Button.builder(
                net.minecraft.network.chat.Component.literal("Performance"),
                button -> screen.getMinecraft().setScreen(
                    new PerformanceScreen(screen)
                )
            )
            .bounds(
                screen.width / 2 - 100,
                screen.height - 70,
                200,
                20
            )
            .build()
        );
    }
            }
