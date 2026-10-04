package io.emberwyrms.client;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.entity.model.EntityModel;

/**
 * GENERADO por tools/rig_emit.py a partir de un modelo de Blockbench (Netherrack Dragon (Sketchfab)).
 * Geometria y textura convertidas; los movimientos (cuello, cola, alas, patas...) son propios del mod.
 */
public class FireDragonModel extends EntityModel<AshwingRenderState> {
    private final ModelPart[] bones;
    private static final float[][] REST = {{0.0873f, 0f, 0f}, {-0.0873f, 0f, 0f}, {0.0873f, 0f, 0f}, {0.0873f, 0f, 0f}, {0.0873f, 0f, 0f}, {0.0873f, 0f, 0f}, {0f, 0f, 0f}, {0.0175f, 0f, 0f}, {0.0175f, 0f, 0f}, {0.0175f, 0f, 0f}, {0.0349f, 0f, 0f}, {0.0524f, 0f, 0f}, {0f, 0.1745f, 0.1745f}, {0f, 0f, -0.3491f}, {0f, -0.1745f, -0.1745f}, {0f, 0f, 0.3491f}, {1.0472f, 0f, 0f}, {0.4363f, 0f, 0f}, {0.7854f, 0f, 0f}, {1.0472f, 0f, 0f}, {0.4363f, 0f, 0f}, {0.7854f, 0f, 0f}, {1.1345f, 0f, 0f}, {-0.3491f, 0f, 0f}, {0.7854f, 0f, 0f}, {1.1345f, 0f, 0f}, {-0.3491f, 0f, 0f}, {0.7854f, 0f, 0f}};
    private static final int HEAD = 0, JAW = -1;
    private static final int[] NECK = {1, 2, 3, 4, 5}, TAIL = {6, 7, 8, 9, 10, 11}, HAIR = {};
    private static final int[][] WING = {{12, 13}, {14, 15}};
    private static final float[] WSIGN = {-1f, 1f};
    private static final int[][] LEG = {{16, 17, 18}, {19, 20, 21}, {22, 23, 24}, {25, 26, 27}};
    private static final float[] LPHASE = {0f, 1f, 1f, 0f};
    private static final float FOLD = 0.9f, FOLD_YAW = 0.8f, FOLD_TIP = 1.2f, FOLD_ROLL = 0.3f, FLAP = 0.75f, TAIL_AMP = 1f, LEG_AMP = 0.6f;

    public FireDragonModel(ModelPart root) {
        super(root);
        this.bones = new ModelPart[] {
            root.getChild("n0_neck").getChild("n3_neck2").getChild("n6_neck3").getChild("n9_neck4").getChild("n12_neck5").getChild("n15_head"),
            root.getChild("n0_neck"),
            root.getChild("n0_neck").getChild("n3_neck2"),
            root.getChild("n0_neck").getChild("n3_neck2").getChild("n6_neck3"),
            root.getChild("n0_neck").getChild("n3_neck2").getChild("n6_neck3").getChild("n9_neck4"),
            root.getChild("n0_neck").getChild("n3_neck2").getChild("n6_neck3").getChild("n9_neck4").getChild("n12_neck5"),
            root.getChild("n65_tail"),
            root.getChild("n65_tail").getChild("n68_tail2"),
            root.getChild("n65_tail").getChild("n68_tail2").getChild("n71_tail3"),
            root.getChild("n65_tail").getChild("n68_tail2").getChild("n71_tail3").getChild("n74_tail4"),
            root.getChild("n65_tail").getChild("n68_tail2").getChild("n71_tail3").getChild("n74_tail4").getChild("n77_tail5"),
            root.getChild("n65_tail").getChild("n68_tail2").getChild("n71_tail3").getChild("n74_tail4").getChild("n77_tail5").getChild("n80_tail6"),
            root.getChild("n29_wing"),
            root.getChild("n29_wing").getChild("n32_wingtip"),
            root.getChild("n35_wing1"),
            root.getChild("n35_wing1").getChild("n38_wingtip1"),
            root.getChild("n41_rearleg"),
            root.getChild("n41_rearleg").getChild("n43_rearlegtip"),
            root.getChild("n41_rearleg").getChild("n43_rearlegtip").getChild("n45_rearfoot"),
            root.getChild("n47_rearleg1"),
            root.getChild("n47_rearleg1").getChild("n49_rearlegtip1"),
            root.getChild("n47_rearleg1").getChild("n49_rearlegtip1").getChild("n51_rearfoot1"),
            root.getChild("n53_frontleg"),
            root.getChild("n53_frontleg").getChild("n55_frontlegtip"),
            root.getChild("n53_frontleg").getChild("n55_frontlegtip").getChild("n57_frontfoot"),
            root.getChild("n59_frontleg1"),
            root.getChild("n59_frontleg1").getChild("n61_frontlegtip1"),
            root.getChild("n59_frontleg1").getChild("n61_frontlegtip1").getChild("n63_frontfoot1")
        };
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        Map<String, ModelPartData> m = new HashMap<>();
        m.put("", data.getRoot());
        p0(m);
        p1(m);
        return TexturedModelData.of(data, 512, 512);
    }

    private static void add(Map<String, ModelPartData> m, String parent, String name, ModelPartBuilder b, ModelTransform t) {
        m.put(name, m.get(parent).addChild(name, b, t));
    }

    private static void p0(Map<String, ModelPartData> m) {
        add(m, "", "n0_neck", ModelPartBuilder.create(), ModelTransform.of(0f, -15.0087f, -8f, -0.0873f, 0f, 0f));
        add(m, "n0_neck", "n1_neck", ModelPartBuilder.create().uv(0, 234).cuboid(-5f, -12f, -18f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 8f, 0f, 0f, 0f));
        add(m, "n0_neck", "n2_neck", ModelPartBuilder.create().uv(128, 274).cuboid(-1f, -16f, -16f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 8f, 0f, 0f, 0f));
        add(m, "n0_neck", "n3_neck2", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, -10f, 0.0873f, 0f, 0f));
        add(m, "n3_neck2", "n4_neck", ModelPartBuilder.create().uv(40, 234).cuboid(-5f, -12f, -28f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 18f, 0f, 0f, 0f));
        add(m, "n3_neck2", "n5_neck", ModelPartBuilder.create().uv(144, 274).cuboid(-1f, -16f, -26f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 18f, 0f, 0f, 0f));
        add(m, "n3_neck2", "n6_neck3", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, -10f, 0.0873f, 0f, 0f));
        add(m, "n6_neck3", "n7_neck", ModelPartBuilder.create().uv(80, 234).cuboid(-5f, -12f, -38f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 28f, 0f, 0f, 0f));
        add(m, "n6_neck3", "n8_neck", ModelPartBuilder.create().uv(160, 274).cuboid(-1f, -16f, -36f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 28f, 0f, 0f, 0f));
        add(m, "n6_neck3", "n9_neck4", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, -10f, 0.0873f, 0f, 0f));
        add(m, "n9_neck4", "n10_neck", ModelPartBuilder.create().uv(120, 234).cuboid(-5f, -12f, -48f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 38f, 0f, 0f, 0f));
        add(m, "n9_neck4", "n11_neck", ModelPartBuilder.create().uv(176, 274).cuboid(-1f, -16f, -46f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 38f, 0f, 0f, 0f));
        add(m, "n9_neck4", "n12_neck5", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, -10f, 0.0873f, 0f, 0f));
        add(m, "n12_neck5", "n13_neck", ModelPartBuilder.create().uv(160, 234).cuboid(-5f, -12f, -58f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 48f, 0f, 0f, 0f));
        add(m, "n12_neck5", "n14_neck", ModelPartBuilder.create().uv(192, 274).cuboid(-1f, -16f, -56f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 48f, 0f, 0f, 0f));
        add(m, "n12_neck5", "n15_head", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, -10f, 0.0873f, 0f, 0f));
        add(m, "n15_head", "n16_head", ModelPartBuilder.create().uv(280, 202).cuboid(-6f, -8f, -88f, 12, 5, 16, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 58f, 0f, 0f, 0f));
        add(m, "n15_head", "n17_head", ModelPartBuilder.create().uv(448, 145).cuboid(-8f, -15f, -74f, 16, 16, 16, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 58f, 0f, 0f, 0f));
        add(m, "n15_head", "n18_head", ModelPartBuilder.create().uv(208, 274).cuboid(-5f, -19f, -68f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 58f, 0f, 0f, 0f));
        add(m, "n15_head", "n19_head", ModelPartBuilder.create().uv(240, 290).cuboid(-5f, -10f, -86f, 2, 2, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 58f, 0f, 0f, 0f));
        add(m, "n15_head", "n20_head", ModelPartBuilder.create().uv(224, 274).cuboid(3f, -19f, -68f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 58f, 0f, 0f, 0f));
        add(m, "n15_head", "n21_head", ModelPartBuilder.create().uv(252, 290).cuboid(3f, -10f, -86f, 2, 2, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 7f, 58f, 0f, 0f, 0f));
        add(m, "n15_head", "n22_jaw", ModelPartBuilder.create(), ModelTransform.of(0f, 4f, -13f, 0.2618f, 0f, 0f));
        add(m, "n22_jaw", "n23_jaw", ModelPartBuilder.create().uv(336, 202).cuboid(-6f, -3f, -88f, 12, 4, 16, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 3f, 71f, 0f, 0f, 0f));
        add(m, "", "n24_body", ModelPartBuilder.create(), ModelTransform.of(0f, -28.0087f, 8f, 0f, 0f, 0f));
        add(m, "n24_body", "n25_body", ModelPartBuilder.create().uv(0, 0).cuboid(-12f, -20f, -8f, 24, 24, 64, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 20f, -8f, 0f, 0f, 0f));
        add(m, "n24_body", "n26_body", ModelPartBuilder.create().uv(200, 254).cuboid(-1f, -26f, -2f, 2, 6, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 20f, -8f, 0f, 0f, 0f));
        add(m, "n24_body", "n27_body", ModelPartBuilder.create().uv(228, 254).cuboid(-1f, -26f, 18f, 2, 6, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 20f, -8f, 0f, 0f, 0f));
        add(m, "n24_body", "n28_body", ModelPartBuilder.create().uv(256, 254).cuboid(-1f, -26f, 38f, 2, 6, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 20f, -8f, 0f, 0f, 0f));
        add(m, "", "n29_wing", ModelPartBuilder.create(), ModelTransform.of(-12f, -27.0087f, 2f, 0f, 0.1745f, 0.1745f));
        add(m, "n29_wing", "n30_wing", ModelPartBuilder.create().uv(284, 254).cuboid(-68f, -23f, -2f, 56, 8, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(12f, 19f, -2f, 0f, 0f, 0f));
        add(m, "n29_wing", "n31_wing", ModelPartBuilder.create().uv(176, 0).cuboid(-68.01f, -19.01f, 3.99f, 56, 1, 56, new Dilation(0.01f, -0.49f, 0.01f)), ModelTransform.of(12f, 19f, -2f, 0f, 0f, 0f));
        add(m, "n29_wing", "n32_wingtip", ModelPartBuilder.create(), ModelTransform.of(-56f, 0f, -2f, 0f, 0f, -0.3491f));
        add(m, "n32_wingtip", "n33_wingtip", ModelPartBuilder.create().uv(0, 290).cuboid(-124f, -21f, 0f, 56, 4, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(68f, 19f, 0f, 0f, 0f, 0f));
        add(m, "n32_wingtip", "n34_wingtip", ModelPartBuilder.create().uv(0, 88).cuboid(-124.01f, -19.01f, 3.99f, 56, 1, 56, new Dilation(0.01f, -0.49f, 0.01f)), ModelTransform.of(68f, 19f, 0f, 0f, 0f, 0f));
        add(m, "", "n35_wing1", ModelPartBuilder.create(), ModelTransform.of(12f, -27.0087f, 2f, 0f, -0.1745f, -0.1745f));
        add(m, "n35_wing1", "n36_wing1", ModelPartBuilder.create().uv(0, 274).cuboid(12f, -23f, -2f, 56, 8, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-12f, 19f, -2f, 0f, 0f, 0f));
        add(m, "n35_wing1", "n37_wing1", ModelPartBuilder.create().uv(224, 88).cuboid(11.99f, -19.01f, 3.99f, 56, 1, 56, new Dilation(0.01f, -0.49f, 0.01f)), ModelTransform.of(-12f, 19f, -2f, 0f, 0f, 0f));
        add(m, "n35_wing1", "n38_wingtip1", ModelPartBuilder.create(), ModelTransform.of(56f, 0f, -2f, 0f, 0f, 0.3491f));
        add(m, "n38_wingtip1", "n39_wingtip1", ModelPartBuilder.create().uv(120, 290).cuboid(68f, -21f, 0f, 56, 4, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(-68f, 19f, 0f, 0f, 0f, 0f));
        add(m, "n38_wingtip1", "n40_wingtip1", ModelPartBuilder.create().uv(0, 145).cuboid(67.99f, -19.01f, 3.99f, 56, 1, 56, new Dilation(0.01f, -0.49f, 0.01f)), ModelTransform.of(-68f, 19f, 0f, 0f, 0f, 0f));
        add(m, "", "n41_rearleg", ModelPartBuilder.create(), ModelTransform.of(-16f, -16.0087f, 42f, 1.0472f, 0f, 0f));
        add(m, "n41_rearleg", "n42_rearleg", ModelPartBuilder.create().uv(224, 145).cuboid(-24f, -12f, 34f, 16, 32, 16, new Dilation(0f, 0f, 0f)), ModelTransform.of(16f, 8f, -42f, 0f, 0f, 0f));
        add(m, "n41_rearleg", "n43_rearlegtip", ModelPartBuilder.create(), ModelTransform.of(0f, 28f, 1f, 0.4363f, 0f, 0f));
        add(m, "n43_rearlegtip", "n44_rearlegtip", ModelPartBuilder.create().uv(352, 145).cuboid(-22f, 20f, 36f, 12, 32, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(16f, -20f, -43f, 0f, 0f, 0f));
        add(m, "n43_rearlegtip", "n45_rearfoot", ModelPartBuilder.create(), ModelTransform.of(0f, 32f, -2f, 0.7854f, 0f, 0f));
        add(m, "n45_rearfoot", "n46_rearfoot", ModelPartBuilder.create().uv(64, 202).cuboid(-25f, 52f, 21f, 18, 6, 24, new Dilation(0f, 0f, 0f)), ModelTransform.of(16f, -52f, -41f, 0f, 0f, 0f));
        add(m, "", "n47_rearleg1", ModelPartBuilder.create(), ModelTransform.of(16f, -16.0087f, 42f, 1.0472f, 0f, 0f));
        add(m, "n47_rearleg1", "n48_rearleg1", ModelPartBuilder.create().uv(288, 145).cuboid(8f, -12f, 34f, 16, 32, 16, new Dilation(0f, 0f, 0f)), ModelTransform.of(-16f, 8f, -42f, 0f, 0f, 0f));
        add(m, "n47_rearleg1", "n49_rearlegtip1", ModelPartBuilder.create(), ModelTransform.of(0f, 28f, 1f, 0.4363f, 0f, 0f));
        add(m, "n49_rearlegtip1", "n50_rearlegtip", ModelPartBuilder.create().uv(400, 145).cuboid(10f, 20f, 36f, 12, 32, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-16f, -20f, -43f, 0f, 0f, 0f));
        add(m, "n49_rearlegtip1", "n51_rearfoot1", ModelPartBuilder.create(), ModelTransform.of(0f, 32f, -2f, 0.7854f, 0f, 0f));
        add(m, "n51_rearfoot1", "n52_rearfoot", ModelPartBuilder.create().uv(148, 202).cuboid(7f, 52f, 21f, 18, 6, 24, new Dilation(0f, 0f, 0f)), ModelTransform.of(-16f, -52f, -41f, 0f, 0f, 0f));
        add(m, "", "n53_frontleg", ModelPartBuilder.create(), ModelTransform.of(-12f, -12.0087f, 2f, 1.1345f, 0f, 0f));
        add(m, "n53_frontleg", "n54_frontleg", ModelPartBuilder.create().uv(0, 202).cuboid(-16f, -8f, -2f, 8, 24, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(12f, 4f, -2f, 0f, 0f, 0f));
        add(m, "n53_frontleg", "n55_frontlegtip", ModelPartBuilder.create(), ModelTransform.of(0f, 20f, 0f, -0.3491f, 0f, 0f));
        add(m, "n55_frontlegtip", "n56_frontlegtip", ModelPartBuilder.create().uv(232, 202).cuboid(-15f, 15f, -1f, 6, 24, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(12f, -16f, -2f, 0f, 0f, 0f));
        add(m, "n55_frontlegtip", "n57_frontfoot", ModelPartBuilder.create(), ModelTransform.of(0f, 22f, 0f, 0.7854f, 0f, 0f));
        add(m, "n57_frontfoot", "n58_frontfoot", ModelPartBuilder.create().uv(392, 202).cuboid(-16f, 38f, -10f, 8, 4, 16, new Dilation(0f, 0f, 0f)), ModelTransform.of(12f, -38f, -2f, 0f, 0f, 0f));
        add(m, "", "n59_frontleg1", ModelPartBuilder.create(), ModelTransform.of(12f, -12.0087f, 2f, 1.1345f, 0f, 0f));
    }

    private static void p1(Map<String, ModelPartData> m) {
        add(m, "n59_frontleg1", "n60_frontleg1", ModelPartBuilder.create().uv(32, 202).cuboid(8f, -8f, -2f, 8, 24, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-12f, 4f, -2f, 0f, 0f, 0f));
        add(m, "n59_frontleg1", "n61_frontlegtip1", ModelPartBuilder.create(), ModelTransform.of(0f, 20f, 0f, -0.3491f, 0f, 0f));
        add(m, "n61_frontlegtip1", "n62_frontlegtip", ModelPartBuilder.create().uv(256, 202).cuboid(9f, 15f, -1f, 6, 24, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(-12f, -16f, -2f, 0f, 0f, 0f));
        add(m, "n61_frontlegtip1", "n63_frontfoot1", ModelPartBuilder.create(), ModelTransform.of(0f, 22f, 0f, 0.7854f, 0f, 0f));
        add(m, "n63_frontfoot1", "n64_frontfoot", ModelPartBuilder.create().uv(440, 202).cuboid(8f, 38f, -10f, 8, 4, 16, new Dilation(0f, 0f, 0f)), ModelTransform.of(-12f, -38f, -2f, 0f, 0f, 0f));
        add(m, "", "n65_tail", ModelPartBuilder.create(), ModelTransform.of(0f, -22.0087f, 56f, 0f, 0f, 0f));
        add(m, "n65_tail", "n66_tail", ModelPartBuilder.create().uv(200, 234).cuboid(-5f, -19f, 56f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -56f, 0f, 0f, 0f));
        add(m, "n65_tail", "n67_tail", ModelPartBuilder.create().uv(240, 274).cuboid(-1f, -23f, 58f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -56f, 0f, 0f, 0f));
        add(m, "n65_tail", "n68_tail2", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, 0.0175f, 0f, 0f));
        add(m, "n68_tail2", "n69_tail", ModelPartBuilder.create().uv(240, 234).cuboid(-5f, -19f, 66f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -66f, 0f, 0f, 0f));
        add(m, "n68_tail2", "n70_tail", ModelPartBuilder.create().uv(256, 274).cuboid(-1f, -23f, 68f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -66f, 0f, 0f, 0f));
        add(m, "n68_tail2", "n71_tail3", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, 0.0175f, 0f, 0f));
        add(m, "n71_tail3", "n72_tail", ModelPartBuilder.create().uv(280, 234).cuboid(-5f, -19f, 76f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -76f, 0f, 0f, 0f));
        add(m, "n71_tail3", "n73_tail", ModelPartBuilder.create().uv(272, 274).cuboid(-1f, -23f, 78f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -76f, 0f, 0f, 0f));
        add(m, "n71_tail3", "n74_tail4", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, 0.0175f, 0f, 0f));
        add(m, "n74_tail4", "n75_tail", ModelPartBuilder.create().uv(320, 234).cuboid(-5f, -19f, 86f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -86f, 0f, 0f, 0f));
        add(m, "n74_tail4", "n76_tail", ModelPartBuilder.create().uv(288, 274).cuboid(-1f, -23f, 88f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -86f, 0f, 0f, 0f));
        add(m, "n74_tail4", "n77_tail5", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, 0.0349f, 0f, 0f));
        add(m, "n77_tail5", "n78_tail", ModelPartBuilder.create().uv(360, 234).cuboid(-5f, -19f, 96f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -96f, 0f, 0f, 0f));
        add(m, "n77_tail5", "n79_tail", ModelPartBuilder.create().uv(304, 274).cuboid(-1f, -23f, 98f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -96f, 0f, 0f, 0f));
        add(m, "n77_tail5", "n80_tail6", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, 0.0524f, 0f, 0f));
        add(m, "n80_tail6", "n81_tail", ModelPartBuilder.create().uv(400, 234).cuboid(-5f, -19f, 106f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -106f, 0f, 0f, 0f));
        add(m, "n80_tail6", "n82_tail", ModelPartBuilder.create().uv(320, 274).cuboid(-1f, -23f, 108f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -106f, 0f, 0f, 0f));
        add(m, "n80_tail6", "n83_tail7", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, 0.0524f, 0f, 0f));
        add(m, "n83_tail7", "n84_tail", ModelPartBuilder.create().uv(440, 234).cuboid(-5f, -19f, 116f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -116f, 0f, 0f, 0f));
        add(m, "n83_tail7", "n85_tail", ModelPartBuilder.create().uv(336, 274).cuboid(-1f, -23f, 118f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -116f, 0f, 0f, 0f));
        add(m, "n83_tail7", "n86_tail8", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, 0.0175f, 0f, 0f));
        add(m, "n86_tail8", "n87_tail", ModelPartBuilder.create().uv(0, 254).cuboid(-5f, -19f, 126f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -126f, 0f, 0f, 0f));
        add(m, "n86_tail8", "n88_tail", ModelPartBuilder.create().uv(352, 274).cuboid(-1f, -23f, 128f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -126f, 0f, 0f, 0f));
        add(m, "n86_tail8", "n89_tail9", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, -0.0175f, 0f, 0f));
        add(m, "n89_tail9", "n90_tail", ModelPartBuilder.create().uv(40, 254).cuboid(-5f, -19f, 136f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -136f, 0f, 0f, 0f));
        add(m, "n89_tail9", "n91_tail", ModelPartBuilder.create().uv(368, 274).cuboid(-1f, -23f, 138f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -136f, 0f, 0f, 0f));
        add(m, "n89_tail9", "n92_tail10", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, -0.0349f, 0f, 0f));
        add(m, "n92_tail10", "n93_tail", ModelPartBuilder.create().uv(80, 254).cuboid(-5f, -19f, 146f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -146f, 0f, 0f, 0f));
        add(m, "n92_tail10", "n94_tail", ModelPartBuilder.create().uv(384, 274).cuboid(-1f, -23f, 148f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -146f, 0f, 0f, 0f));
        add(m, "n92_tail10", "n95_tail11", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, -0.0524f, 0f, 0f));
        add(m, "n95_tail11", "n96_tail", ModelPartBuilder.create().uv(120, 254).cuboid(-5f, -19f, 156f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -156f, 0f, 0f, 0f));
        add(m, "n95_tail11", "n97_tail", ModelPartBuilder.create().uv(400, 274).cuboid(-1f, -23f, 158f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -156f, 0f, 0f, 0f));
        add(m, "n95_tail11", "n98_tail12", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, -0.0524f, 0f, 0f));
        add(m, "n98_tail12", "n99_tail", ModelPartBuilder.create().uv(160, 254).cuboid(-5f, -19f, 166f, 10, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -166f, 0f, 0f, 0f));
        add(m, "n98_tail12", "n100_tail", ModelPartBuilder.create().uv(416, 274).cuboid(-1f, -23f, 168f, 2, 4, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 14f, -166f, 0f, 0f, 0f));
    }

    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

    @Override
    public void setAngles(AshwingRenderState s) {
        super.setAngles(s);
        for (int i = 0; i < bones.length; i++) {
            bones[i].pitch = REST[i][0];
            bones[i].yaw = REST[i][1];
            bones[i].roll = REST[i][2];
        }
        float t = s.age;
        float amp = Math.min(1f, s.walkSpeed * 1.6f);
        float f = s.walkPhase * 0.6662f;
        float yawLook = s.relativeHeadYaw * 0.0174533f;
        float pitchLook = s.pitch * 0.0174533f;
        boolean fly = s.flying;
        boolean breath = s.breathing;
        for (int i = 0; i < NECK.length; i++) {
            bones[NECK[i]].pitch += sin(t * 0.05f - i * 0.5f) * 0.03f + (fly ? 0.05f : 0f) + (breath ? -0.05f : 0f);
            bones[NECK[i]].yaw += yawLook * 0.12f;
        }
        if (HEAD >= 0) {
            bones[HEAD].yaw += yawLook * 0.4f;
            bones[HEAD].pitch += pitchLook * 0.5f + sin(t * 0.09f) * 0.02f - (breath ? 0.3f : 0f);
        }
        if (JAW >= 0) bones[JAW].pitch += breath ? 0.8f : 0.05f + (sin(t * 0.09f) + 1f) * 0.03f;
        for (int j = 0; j < TAIL.length; j++) {
            bones[TAIL[j]].yaw += (sin(t * 0.06f - j * 0.55f) * (0.05f + 0.01f * j) + cos(f) * 0.05f * amp) * TAIL_AMP;
        }
        for (int j = 0; j < HAIR.length; j++) {
            bones[HAIR[j]].roll += sin(t * 0.15f + j * 1.7f) * 0.12f;
            bones[HAIR[j]].pitch += cos(t * 0.13f + j) * 0.1f;
        }
        float fold = fly ? 0f : FOLD;
        float flap = fly ? sin(t * 0.3f) : sin(t * 0.1f) * 0.04f;
        for (int w = 0; w < WING.length; w++) {
            float sg = WSIGN[w];
            ModelPart root = bones[WING[w][0]];
            root.roll += -sg * flap * FLAP + sg * FOLD_ROLL * fold;
            root.yaw += -sg * FOLD_YAW * fold;
            for (int k = 1; k < WING[w].length; k++) {
                ModelPart tip = bones[WING[w][k]];
                tip.yaw += -sg * FOLD_TIP * fold;
                tip.roll += -sg * flap * 0.35f;
            }
        }
        for (int l = 0; l < LEG.length; l++) {
            float sw = cos(f + LPHASE[l] * 3.14159f) * amp * LEG_AMP;
            bones[LEG[l][0]].pitch += sw;
            for (int k = 1; k < LEG[l].length; k++) bones[LEG[l][k]].pitch += -sw * 0.5f * k;
        }
    }
}
