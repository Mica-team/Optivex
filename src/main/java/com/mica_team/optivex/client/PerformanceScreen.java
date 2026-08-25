package com.mica_team.optivex.client;

import com.mica_team.optivex.config.OptivexConfig;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class PerformanceScreen extends Screen {

    private final Screen parent;

    private Button fastMathButton;

    public PerformanceScreen(Screen parent) {
        super(Component.literal("Optivex Performance"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        super.init();

        int centerX = this.width / 2;

        fastMathButton = Button.builder(
                getFastMathText(),
                button -> toggleFastMath()
        ).bounds(
                centerX - 100,
                this.height / 2 - 20,
                200,
                20
        ).build();

        this.addRenderableWidget(fastMathButton);

        this.addRenderableWidget(
                Button.builder(
                        Component.literal("Done"),
                        button -> this.minecraft.setScreen(parent)
                ).bounds(
                        centerX - 100,
                        this.height / 2 + 20,
                        200,
                        20
                ).build()
        );
    }

    private void toggleFastMath() {
        boolean enabled = !OptivexConfig.isFastMathEnabled();

        OptivexConfig.setFastMathEnabled(enabled);

        fastMathButton.setMessage(getFastMathText());
    }

    private Component getFastMathText() {
        return Component.literal(
                "Fast Math: " +
                (OptivexConfig.isFastMathEnabled() ? "ON" : "OFF")
        );
    }

    @Override
    public void render(
            GuiGraphics guiGraphics,
            int mouseX,
            int mouseY,
            float partialTick
    ) {
        this.renderBackground(guiGraphics);

        guiGraphics.drawCenteredString(
                this.font,
                this.title,
                this.width / 2,
                40,
                0xFFFFFF
        );

        guiGraphics.drawCenteredString(
                this.font,
                Component.literal(
                        "Optimizations provided by Optivex"
                ),
                this.width / 2,
                65,
                0xAAAAAA
        );

        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(parent);
    }
                  }
