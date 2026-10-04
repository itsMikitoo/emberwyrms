package io.emberwyrms.client;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.OrderedText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/** Pantalla del bestiario: una pagina por criatura con su foto y su informacion (textos en el archivo de idioma). */
public class BestiaryScreen extends Screen {
    private static final String[] PAGES = {"intro", "fire", "ice", "storm", "tide", "ash", "medusa", "credits"};
    private static final boolean[] HAS_PIC = {false, true, true, true, true, true, true, false};
    private static final int PIC_W = 256;
    private static final int PIC_H = 160;
    private static final int INK = 0xFF3A2410;
    private int page;

    public BestiaryScreen() {
        super(Text.translatable("item.emberwyrms.bestiary"));
    }

    @Override
    protected void init() {
        int cx = this.width / 2;
        int y = this.height - 28;
        this.addDrawableChild(ButtonWidget.builder(Text.literal("<"), b -> { if (this.page > 0) this.page--; })
                .dimensions(cx - 110, y, 40, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.translatable("gui.done"), b -> this.close())
                .dimensions(cx - 40, y, 80, 20).build());
        this.addDrawableChild(ButtonWidget.builder(Text.literal(">"), b -> { if (this.page < PAGES.length - 1) this.page++; })
                .dimensions(cx + 70, y, 40, 20).build());
    }

    @Override
    public void render(DrawContext ctx, int mouseX, int mouseY, float delta) {
        super.render(ctx, mouseX, mouseY, delta);
        String key = PAGES[this.page];
        boolean wide = this.width >= 520 && HAS_PIC[this.page];
        int panelW = wide ? 500 : 300;
        int left = (this.width - panelW) / 2;
        int top = 10;
        int bottom = this.height - 36;
        // pergamino con borde
        ctx.fill(left - 8, top - 8, left + panelW + 8, bottom, 0xFF6E5028);
        ctx.fill(left - 6, top - 6, left + panelW + 6, bottom - 2, 0xFFE2CEA0);
        ctx.drawText(this.textRenderer, Text.translatable("bestiary.emberwyrms." + key + ".title"), left + 2, top, INK, false);
        ctx.drawText(this.textRenderer, Text.literal((this.page + 1) + " / " + PAGES.length), left + panelW - 30, top, INK, false);

        int textX = left + 2;
        int textW = panelW - 6;
        int y = top + 16;
        if (HAS_PIC[this.page]) {
            Identifier pic = Identifier.of("emberwyrms", "textures/gui/bestiary/" + key + ".png");
            if (wide) {
                ctx.drawTexture(RenderPipelines.GUI_TEXTURED, pic, left + 2, y, 0f, 0f, PIC_W, PIC_H, PIC_W, PIC_H);
                textX = left + PIC_W + 12;
                textW = panelW - PIC_W - 16;
            } else {
                ctx.drawTexture(RenderPipelines.GUI_TEXTURED, pic, left + (panelW - PIC_W) / 2, y, 0f, 0f, PIC_W, PIC_H, PIC_W, PIC_H);
                y += PIC_H + 8;
            }
        }
        for (int i = 1; i <= 12; i++) {
            String lk = "bestiary.emberwyrms." + key + ".l" + i;
            if (!I18n.hasTranslation(lk)) break;
            for (OrderedText line : this.textRenderer.wrapLines(Text.translatable(lk), textW)) {
                if (y > bottom - 14) return;
                ctx.drawText(this.textRenderer, line, textX, y, INK, false);
                y += 10;
            }
            y += 3;
        }
    }
}
