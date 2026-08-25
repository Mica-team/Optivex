package com.mica_team.optivex.mixin;

import com.mica_team.optivex.client.PerformanceScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.OptionsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OptionsScreen.class)
public abstract class OptionsScreenMixin {

    @Inject(method = "init", at = @At("TAIL"))
    private void optivex$addPerformanceButton(CallbackInfo ci) {

        OptionsScreen screen = (OptionsScreen) (Object) this;

        screen.addRenderableWidget(
                Button.builder(
                        net.minecraft.network.chat.Component.literal(
                                "Performance"
                        ),
                        button -> screen.getMinecraft().setScreen(
                                new PerformanceScreen(screen)
                        )
                ).bounds(
                        screen.width / 2 - 100,
                        screen.height - 45,
                        200,
                        20
                ).build()
        );
    }
          }
