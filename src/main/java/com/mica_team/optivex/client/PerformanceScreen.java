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

        addRenderableWidget(fastMathButton);

        addRenderableWidget(
                Button.builder(
                        Component.literal("Done"),
                        button -> onClose()
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
        renderBackground(guiGraphics);

        guiGraphics.drawCenteredString(
                font,
                title,
                width / 2,
                40,
                0xFFFFFF
        );

        guiGraphics.drawCenteredString(
                font,
                Component.literal(
                        "Optivex performance options"
                ),
                width / 2,
                60,
                0xAAAAAA
        );

        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void onClose() {
        minecraft.setScreen(parent);
    }
            }
