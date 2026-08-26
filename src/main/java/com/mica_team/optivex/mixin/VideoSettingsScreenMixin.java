package com.mica_team.optivex.mixin;

import com.mica_team.optivex.client.PerformanceScreen;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.VideoSettingsScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VideoSettingsScreen.class)
public class VideoSettingsScreenMixin {

    @Shadow
    protected abstract <T extends net.minecraft.client.gui.components.events.GuiEventListener & net.minecraft.client.gui.components.Renderable & net.minecraft.client.gui.narration.NarratableEntry> T addRenderableWidget(T widget);

    @Inject(method = "init", at = @At("TAIL"))
    private void optivex$addPerformanceButton(CallbackInfo ci) {
        VideoSettingsScreen screen = (VideoSettingsScreen) (Object) this;

        System.out.println("[Optivex] Adding Performance button");

        addRenderableWidget(
            Button.builder(
                Component.literal("Performance"),
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
