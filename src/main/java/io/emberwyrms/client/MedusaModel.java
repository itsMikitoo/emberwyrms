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
 * GENERADO por tools/rig_emit.py a partir de un modelo de Blockbench (Gorgon (Sketchfab, CC BY)).
 * Geometria y textura convertidas; los movimientos (cuello, cola, alas, patas...) son propios del mod.
 */
public class MedusaModel extends EntityModel<MedusaRenderState> {
    private final ModelPart[] bones;
    private static final float[][] REST = {{0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {-0.1353f, 0f, 0f}};
    private static final int HEAD = 0, JAW = -1;
    private static final int[] NECK = {}, TAIL = {1, 2, 3, 4, 5, 6, 7}, HAIR = {8, 9};
    private static final int[][] WING = {};
    private static final float[] WSIGN = {};
    private static final int[][] LEG = {};
    private static final float[] LPHASE = {};
    private static final float FOLD = 0.9f, FOLD_YAW = 0.8f, FOLD_TIP = 1.2f, FOLD_ROLL = 0.3f, FLAP = 0.75f, TAIL_AMP = 1.6f, LEG_AMP = 0.6f;

    public MedusaModel(ModelPart root) {
        super(root);
        this.bones = new ModelPart[] {
            root.getChild("n0_x").getChild("n9_Body").getChild("n13_Head"),
            root.getChild("n0_x").getChild("n1_Tail").getChild("slice91_Tail"),
            root.getChild("n0_x").getChild("n1_Tail").getChild("slice91_Tail").getChild("slice92_Tail"),
            root.getChild("n0_x").getChild("n1_Tail").getChild("slice91_Tail").getChild("slice92_Tail").getChild("slice93_Tail"),
            root.getChild("n0_x").getChild("n1_Tail").getChild("slice91_Tail").getChild("slice92_Tail").getChild("slice93_Tail").getChild("slice94_Tail"),
            root.getChild("n0_x").getChild("n1_Tail").getChild("slice91_Tail").getChild("slice92_Tail").getChild("slice93_Tail").getChild("slice94_Tail").getChild("slice95_Tail"),
            root.getChild("n0_x").getChild("n1_Tail").getChild("slice91_Tail").getChild("slice92_Tail").getChild("slice93_Tail").getChild("slice94_Tail").getChild("slice95_Tail").getChild("slice96_Tail"),
            root.getChild("n0_x").getChild("n1_Tail").getChild("slice91_Tail").getChild("slice92_Tail").getChild("slice93_Tail").getChild("slice94_Tail").getChild("slice95_Tail").getChild("slice96_Tail").getChild("slice97_Tail"),
            root.getChild("n0_x").getChild("n9_Body").getChild("n13_Head").getChild("n14_SnakeHead").getChild("n15_R"),
            root.getChild("n0_x").getChild("n9_Body").getChild("n13_Head").getChild("n14_SnakeHead").getChild("n51_L")
        };
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        Map<String, ModelPartData> m = new HashMap<>();
        m.put("", data.getRoot());
        p0(m);
        p1(m);
        return TexturedModelData.of(data, 128, 128);
    }

    private static void add(Map<String, ModelPartData> m, String parent, String name, ModelPartBuilder b, ModelTransform t) {
        m.put(name, m.get(parent).addChild(name, b, t));
    }

    private static void p0(Map<String, ModelPartData> m) {
        add(m, "", "n0_x", ModelPartBuilder.create(), ModelTransform.of(0f, 22.5f, 0f, 0f, -1.5708f, 0f));
        add(m, "n0_x", "n1_Tail", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "n1_Tail", "slice91_Tail", ModelPartBuilder.create(), ModelTransform.of(-9.6f, 0f, 0f, 0f, 0f, 0f));
        add(m, "slice91_Tail", "slice92_Tail", ModelPartBuilder.create(), ModelTransform.of(7.4429f, 0f, 0f, 0f, 0f, 0f));
        add(m, "slice92_Tail", "slice93_Tail", ModelPartBuilder.create(), ModelTransform.of(7.4429f, 0f, 0f, 0f, 0f, 0f));
        add(m, "slice93_Tail", "slice94_Tail", ModelPartBuilder.create(), ModelTransform.of(7.4429f, 0f, 0f, 0f, 0f, 0f));
        add(m, "slice94_Tail", "slice95_Tail", ModelPartBuilder.create(), ModelTransform.of(7.4429f, 0f, 0f, 0f, 0f, 0f));
        add(m, "slice95_Tail", "slice96_Tail", ModelPartBuilder.create(), ModelTransform.of(7.4429f, 0f, 0f, 0f, 0f, 0f));
        add(m, "slice96_Tail", "slice97_Tail", ModelPartBuilder.create(), ModelTransform.of(7.4429f, 0f, 0f, 0f, 0f, 0f));
        add(m, "slice97_Tail", "n2_cube", ModelPartBuilder.create().uv(60, 42).cuboid(-2f, -3.6f, -2f, 8, 3, 3, new Dilation(0.25f, 0.05f, 0f)), ModelTransform.of(7.4429f, 0f, 0f, 0f, 0f, -0.0873f));
        add(m, "slice96_Tail", "n3_cube", ModelPartBuilder.create().uv(100, 30).cuboid(-1.55f, -3.6f, -2.5f, 8, 4, 4, new Dilation(0.025f, 0.05f, 0f)), ModelTransform.of(6.3857f, -0.5f, 0f, 0f, 0f, 0f));
        add(m, "slice95_Tail", "n4_cube", ModelPartBuilder.create().uv(72, 30).cuboid(-2.1f, -4.1f, -3.3f, 9, 5, 5, new Dilation(-0.2f, 0.05f, 0.15f)), ModelTransform.of(5.7286f, -0.5f, 0f, 0f, 0f, 0f));
        add(m, "slice94_Tail", "n5_cube", ModelPartBuilder.create().uv(38, 30).cuboid(-4.7f, -4.6f, -3.8f, 11, 6, 6, new Dilation(0.1f, 0.05f, 0.05f)), ModelTransform.of(4.7714f, -0.5f, 0f, 0f, 0f, 0f));
        add(m, "slice93_Tail", "n6_cube", ModelPartBuilder.create().uv(0, 16).cuboid(-5.5f, -5.1f, -4.4f, 12, 7, 7, new Dilation(0f, 0.05f, 0.125f)), ModelTransform.of(0.9143f, -0.5f, 0f, 0f, 0f, 0f));
        add(m, "slice91_Tail", "n7_cube", ModelPartBuilder.create().uv(38, 16).cuboid(-0.75f, -5.1f, -4.4f, 7, 7, 7, new Dilation(0.125f, 0.05f, 0.125f)), ModelTransform.of(5.75f, -2.1f, 0f, 0f, 0f, 0.2443f));
        add(m, "slice91_Tail", "n8_cube", ModelPartBuilder.create().uv(32, 0).cuboid(-2f, -5.1f, -4.5f, 8, 7, 8, new Dilation(0.25f, 0.05f, -0.25f)), ModelTransform.of(0f, -5.95f, 0f, 0f, 0f, 0.5716f));
        add(m, "n0_x", "n9_Body", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "n9_Body", "n10_Poor", ModelPartBuilder.create(), ModelTransform.of(17.4f, 1.3f, 0f, 0f, 0f, 0f));
        add(m, "n10_Poor", "n11_LPoor", ModelPartBuilder.create().uv(0, 42).cuboid(-4.3f, -2.5f, 0f, 12, 4, 3, new Dilation(-0.1f, -0.05f, 0f)), ModelTransform.of(-28.25f, -26.65f, 3.7f, 0f, -0.2182f, 1.5708f));
        add(m, "n10_Poor", "n12_LPoor", ModelPartBuilder.create().uv(30, 42).cuboid(-4.3f, -2.5f, 0f, 12, 4, 3, new Dilation(-0.1f, -0.05f, 0f)), ModelTransform.of(-28.3f, -27.25f, -8.1f, 0f, 0.288f, 1.5708f));
        add(m, "n9_Body", "n13_Head", ModelPartBuilder.create(), ModelTransform.of(17.4f, 1.3f, 0f, 0f, 0f, 0f));
        add(m, "n13_Head", "n14_SnakeHead", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "n14_SnakeHead", "n15_R", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "n15_R", "n16_1R", ModelPartBuilder.create(), ModelTransform.of(2f, 4f, 0f, 0f, 0f, 0f));
        add(m, "n16_1R", "n17_cube", ModelPartBuilder.create().uv(84, 49).cuboid(-0.1f, -0.9966f, -4.2774f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(-29.2f, -37.2f, -3.6f, 0.3229f, 0f, 0f));
        add(m, "n16_1R", "n18_cube", ModelPartBuilder.create().uv(60, 55).cuboid(3.3742f, -0.6439f, -6.8043f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-28.5f, -37.6f, -3.8f, 1.415f, 1.2451f, 1.4341f));
        add(m, "n16_1R", "n19_cube", ModelPartBuilder.create().uv(70, 55).cuboid(3.4561f, -0.9893f, -6.7713f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-28.5f, -37f, -3.6f, 1.5284f, 1.2451f, 1.4341f));
        add(m, "n16_1R", "n20_plane", ModelPartBuilder.create().uv(20, 64).cuboid(-0.4f, 0f, -0.1f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-34.5f, -35.8f, -9.25f, -1.4137f, 0f, 0f));
        add(m, "n16_1R", "n21_plane", ModelPartBuilder.create().uv(24, 64).cuboid(-0.4f, 0f, -0.1f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-34.5f, -36.4f, -7.35f, -1.4137f, 0f, 0f));
        add(m, "n16_1R", "n22_cube", ModelPartBuilder.create().uv(82, 42).cuboid(4.1661f, -0.9542f, -4.0921f, 1, 1, 5, new Dilation(0f, 0f, -0.15f)), ModelTransform.of(-29.2f, -37.2f, -3.6f, 1.4412f, 1.2451f, 1.4341f));
        add(m, "n15_R", "n23_2R", ModelPartBuilder.create(), ModelTransform.of(-13.6f, -38.75f, -3.85f, -0.2662f, 0f, 0f));
        add(m, "n23_2R", "n24_cube", ModelPartBuilder.create().uv(94, 49).cuboid(-14.9f, -0.9966f, -4.2774f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.05f, 0.55f, 0.4f, 1.0559f, 0f, 0f));
        add(m, "n23_2R", "n25_cube", ModelPartBuilder.create().uv(94, 42).cuboid(3.5205f, -0.9542f, -18.878f, 1, 1, 5, new Dilation(0f, 0f, -0.15f)), ModelTransform.of(-0.15f, 2.45f, 2.55f, 1.4412f, 1.2451f, 1.4341f));
        add(m, "n23_2R", "n26_cube", ModelPartBuilder.create().uv(80, 55).cuboid(3.0122f, -0.4269f, -15.0936f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-5.6f, 2.05f, 2.35f, 1.415f, 1.2451f, 1.4341f));
        add(m, "n23_2R", "n27_cube", ModelPartBuilder.create().uv(90, 55).cuboid(3.0941f, -1.712f, -15.0319f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-5.6f, 2.65f, 2.55f, 1.5284f, 1.2451f, 1.4341f));
        add(m, "n23_2R", "n28_plane", ModelPartBuilder.create().uv(28, 64).cuboid(-0.4f, 0f, -0.1f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-19.9f, 3.85f, -3.1f, -1.4137f, 0f, 0f));
        add(m, "n23_2R", "n29_plane", ModelPartBuilder.create().uv(32, 64).cuboid(-0.4f, 0f, -0.1f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-19.9f, 3.25f, -1.2f, -1.4137f, 0f, 0f));
        add(m, "n15_R", "n30_3R", ModelPartBuilder.create(), ModelTransform.of(4.5f, 0f, 0f, 0f, 0f, 0f));
        add(m, "n30_3R", "n31_cube", ModelPartBuilder.create().uv(104, 49).cuboid(-0.1f, -0.9966f, -4.2774f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(-29.2f, -37.2f, -3.6f, 0.3229f, 0f, 0f));
        add(m, "n30_3R", "n32_cube", ModelPartBuilder.create().uv(106, 42).cuboid(4.1661f, -0.9542f, -4.0921f, 1, 1, 5, new Dilation(0f, 0f, -0.15f)), ModelTransform.of(-30.15f, -37.2f, -3.25f, 0.6502f, 1.1947f, 1.0108f));
        add(m, "n30_3R", "n33_cube", ModelPartBuilder.create().uv(100, 55).cuboid(3.3742f, -0.6439f, -6.8043f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-28.05f, -39f, -4.3f, 1.415f, 1.2451f, 1.4341f));
        add(m, "n30_3R", "n34_cube", ModelPartBuilder.create().uv(110, 55).cuboid(3.4561f, -0.9893f, -6.7713f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-28.05f, -38.4f, -4.1f, 1.5284f, 1.2451f, 1.4341f));
        add(m, "n30_3R", "n35_plane", ModelPartBuilder.create().uv(36, 64).cuboid(-0.4f, 0f, -0.1f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-34.05f, -37.2f, -9.75f, -1.4137f, 0f, 0f));
        add(m, "n30_3R", "n36_plane", ModelPartBuilder.create().uv(40, 64).cuboid(-0.4f, 0f, -0.1f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-34.05f, -37.8f, -7.85f, -1.4137f, 0f, 0f));
        add(m, "n15_R", "n37_4R", ModelPartBuilder.create(), ModelTransform.of(-10.5f, -36f, -2.5f, 0f, 0f, 0f));
        add(m, "n37_4R", "n38_cube", ModelPartBuilder.create().uv(114, 49).cuboid(-0.1f, -0.9966f, -4.2774f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(-13.2f, 1.3f, 0.9f, 0.4562f, -0.7647f, -0.3926f));
        add(m, "n37_4R", "n39_cube", ModelPartBuilder.create().uv(0, 49).cuboid(4.1661f, -0.9542f, -4.0921f, 1, 1, 5, new Dilation(0f, 0f, -0.15f)), ModelTransform.of(-14.75f, 1.5f, -0.85f, 0.0582f, 0.2439f, 0.0833f));
        add(m, "n37_4R", "n40_cube", ModelPartBuilder.create().uv(0, 60).cuboid(3.3742f, -0.6439f, -6.8043f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-6.85f, -0.35f, -1.05f, 1.415f, 1.2451f, 1.4341f));
        add(m, "n37_4R", "n41_cube", ModelPartBuilder.create().uv(10, 60).cuboid(3.4561f, -0.9893f, -6.7713f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-6.85f, 0.25f, -0.85f, 1.5284f, 1.2451f, 1.4341f));
        add(m, "n37_4R", "n42_plane", ModelPartBuilder.create().uv(44, 64).cuboid(-0.4f, 0f, -0.1f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-12.85f, 1.45f, -6.5f, -1.4137f, 0f, 0f));
        add(m, "n37_4R", "n43_plane", ModelPartBuilder.create().uv(48, 64).cuboid(-0.4f, 0f, -0.1f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-12.85f, 0.85f, -4.6f, -1.4137f, 0f, 0f));
        add(m, "n15_R", "n44_5R", ModelPartBuilder.create(), ModelTransform.of(-10.5f, -39f, -3.5f, -0.1614f, 0f, 0f));
        add(m, "n44_5R", "n45_cube", ModelPartBuilder.create().uv(0, 55).cuboid(-14.7387f, 0.2601f, -2.497f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(1.6f, 2.15f, 0.9f, -1.1568f, 0.0297f, 0.1448f));
        add(m, "n44_5R", "n46_cube", ModelPartBuilder.create().uv(12, 49).cuboid(-0.7809f, 5.2307f, -16.6774f, 1, 1, 5, new Dilation(0f, 0f, -0.15f)), ModelTransform.of(0.75f, -2.3f, -0.3f, 1.0293f, 1.3443f, 1.4274f));
        add(m, "n44_5R", "n47_cube", ModelPartBuilder.create().uv(20, 60).cuboid(-1.3538f, 0.4119f, -16.1325f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-3.35f, -4.2f, -0.7f, 1.3961f, 1.2839f, 1.416f));
        add(m, "n44_5R", "n48_cube", ModelPartBuilder.create().uv(30, 60).cuboid(-1.2712f, -0.3662f, -16.2143f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-3.35f, -4.2f, -0.7f, 1.5095f, 1.2839f, 1.416f));
        add(m, "n44_5R", "n49_plane", ModelPartBuilder.create().uv(52, 64).cuboid(-1.15f, 1.2742f, 0.9131f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-18.05f, -4.2f, -0.7f, -1.453f, 0f, 0f));
        add(m, "n44_5R", "n50_plane", ModelPartBuilder.create().uv(56, 64).cuboid(-1.15f, -0.6963f, 0.6178f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-18.05f, -4.2f, -0.7f, -1.453f, 0f, 0f));
        add(m, "n14_SnakeHead", "n51_L", ModelPartBuilder.create(), ModelTransform.of(-9f, -37.55f, 1.75f, -0.1353f, 0f, 0f));
        add(m, "n51_L", "n52_1L", ModelPartBuilder.create(), ModelTransform.of(0f, 0.45f, 0.25f, -0.2967f, 0f, 0f));
    }

    private static void p1(Map<String, ModelPartData> m) {
        add(m, "n52_1L", "n53_cube", ModelPartBuilder.create().uv(10, 55).cuboid(-14.7387f, 0.2601f, -2.4971f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.1f, 0.3915f, -1.0367f, -1.1568f, 0.0297f, 0.1448f));
        add(m, "n52_1L", "n54_cube", ModelPartBuilder.create().uv(24, 49).cuboid(-0.7809f, 5.2307f, -16.6775f, 1, 1, 5, new Dilation(0f, 0f, -0.15f)), ModelTransform.of(-0.75f, -4.0585f, -2.2367f, 1.0293f, 1.3443f, 1.4274f));
        add(m, "n52_1L", "n55_cube", ModelPartBuilder.create().uv(40, 60).cuboid(-1.3538f, 0.4119f, -16.1326f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-4.85f, -5.9585f, -2.6367f, 1.3961f, 1.2839f, 1.416f));
        add(m, "n52_1L", "n56_cube", ModelPartBuilder.create().uv(50, 60).cuboid(-1.2712f, -0.3662f, -16.2143f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-4.85f, -5.9585f, -2.6367f, 1.5095f, 1.2839f, 1.416f));
        add(m, "n52_1L", "n57_plane", ModelPartBuilder.create().uv(60, 64).cuboid(-1.15f, 1.2742f, 0.9131f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-19.65f, -5.9585f, -2.6367f, -1.453f, 0f, 0f));
        add(m, "n52_1L", "n58_plane", ModelPartBuilder.create().uv(64, 64).cuboid(-1.15f, -0.6963f, 0.6178f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-19.65f, -5.9585f, -2.6367f, -1.453f, 0f, 0f));
        add(m, "n51_L", "n59_2L", ModelPartBuilder.create(), ModelTransform.of(-2.75f, 3.7f, 4.25f, 0.2574f, 0f, 0f));
        add(m, "n59_2L", "n60_cube", ModelPartBuilder.create().uv(20, 55).cuboid(-14.9f, -0.9966f, 0.2774f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.4f, -0.7f, -4.4f, -0.3229f, 0f, 0f));
        add(m, "n59_2L", "n61_cube", ModelPartBuilder.create().uv(36, 49).cuboid(3.5205f, -0.9542f, 14.178f, 1, 1, 5, new Dilation(0f, 0f, -0.15f)), ModelTransform.of(-0.4f, -0.7f, -4.4f, -1.4412f, -1.2451f, 1.4341f));
        add(m, "n59_2L", "n62_cube", ModelPartBuilder.create().uv(60, 60).cuboid(2.7286f, -0.2569f, 18.6852f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-0.4f, -1.1f, -4.2f, -1.415f, -1.2451f, 1.4341f));
        add(m, "n59_2L", "n63_cube", ModelPartBuilder.create().uv(70, 60).cuboid(2.8106f, -2.278f, 18.601f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-0.4f, -0.5f, -4.4f, -1.5284f, -1.2451f, 1.4341f));
        add(m, "n59_2L", "n64_plane", ModelPartBuilder.create().uv(68, 64).cuboid(-0.4f, 0f, -0.3f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-21.2f, 0.7f, 1.25f, 1.4137f, 0f, 0f));
        add(m, "n59_2L", "n65_plane", ModelPartBuilder.create().uv(72, 64).cuboid(-0.4f, 0f, -0.3f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-21.2f, 0.1f, -0.65f, 1.4137f, 0f, 0f));
        add(m, "n51_L", "n66_3L", ModelPartBuilder.create(), ModelTransform.of(-0.7f, 0f, 4.35f, 0.2356f, 0f, 0f));
        add(m, "n66_3L", "n67_cube", ModelPartBuilder.create().uv(30, 55).cuboid(-14.9f, -0.9966f, 0.2774f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.2f, -0.6f, -4.15f, -0.3229f, 0f, 0f));
        add(m, "n66_3L", "n68_cube", ModelPartBuilder.create().uv(48, 49).cuboid(1.2787f, 4.6007f, 12.8028f, 1, 1, 5, new Dilation(0f, 0f, -0.15f)), ModelTransform.of(-1.15f, -0.6f, -4.5f, -0.6502f, -1.1947f, 1.0108f));
        add(m, "n66_3L", "n69_cube", ModelPartBuilder.create().uv(80, 60).cuboid(2.7286f, -0.2569f, 18.6852f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(0.8f, -2.4f, -3.45f, -1.415f, -1.2451f, 1.4341f));
        add(m, "n66_3L", "n70_cube", ModelPartBuilder.create().uv(90, 60).cuboid(2.8106f, -2.278f, 18.601f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(0.8f, -1.8f, -3.65f, -1.5284f, -1.2451f, 1.4341f));
        add(m, "n66_3L", "n71_plane", ModelPartBuilder.create().uv(76, 64).cuboid(-0.4f, 0f, -0.3f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-20f, -0.6f, 2f, 1.4137f, 0f, 0f));
        add(m, "n66_3L", "n72_plane", ModelPartBuilder.create().uv(80, 64).cuboid(-0.4f, 0f, -0.3f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-20f, -1.2f, 0.1f, 1.4137f, 0f, 0f));
        add(m, "n51_L", "n73_4L", ModelPartBuilder.create(), ModelTransform.of(-4.6f, -1.2f, 0.5f, 0.2662f, 0f, 0f));
        add(m, "n73_4L", "n74_cube", ModelPartBuilder.create().uv(40, 55).cuboid(-14.9f, -0.9966f, 0.2774f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.05f, 0.55f, -0.25f, -1.0559f, 0f, 0f));
        add(m, "n73_4L", "n75_cube", ModelPartBuilder.create().uv(60, 49).cuboid(3.5205f, -0.9542f, 14.178f, 1, 1, 5, new Dilation(0f, 0f, -0.15f)), ModelTransform.of(-0.15f, 2.45f, -2.55f, -1.4412f, -1.2451f, 1.4341f));
        add(m, "n73_4L", "n76_cube", ModelPartBuilder.create().uv(100, 60).cuboid(2.7286f, -0.2569f, 18.6852f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-0.15f, 2.05f, -2.35f, -1.415f, -1.2451f, 1.4341f));
        add(m, "n73_4L", "n77_cube", ModelPartBuilder.create().uv(110, 60).cuboid(2.8106f, -2.278f, 18.601f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(-0.15f, 2.65f, -2.55f, -1.5284f, -1.2451f, 1.4341f));
        add(m, "n73_4L", "n78_plane", ModelPartBuilder.create().uv(84, 64).cuboid(-0.4f, 0f, -0.3f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-20.95f, 3.85f, 3.1f, 1.4137f, 0f, 0f));
        add(m, "n73_4L", "n79_plane", ModelPartBuilder.create().uv(88, 64).cuboid(-0.4f, 0f, -0.3f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-20.9f, 3.25f, 1.2f, 1.4137f, 0f, 0f));
        add(m, "n51_L", "n80_5L", ModelPartBuilder.create(), ModelTransform.of(-2f, 1.85f, -0.25f, 0f, 0f, 0f));
        add(m, "n80_5L", "n81_cube", ModelPartBuilder.create().uv(50, 55).cuboid(-9.9666f, -1.91f, -10.716f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(1.6f, 1.3f, -0.9f, -0.4562f, 0.7647f, -0.3926f));
        add(m, "n80_5L", "n82_cube", ModelPartBuilder.create().uv(72, 49).cuboid(-10.1462f, 0.0686f, 3.0187f, 1, 1, 5, new Dilation(0f, 0f, -0.15f)), ModelTransform.of(0.05f, 1.5f, 0.85f, -0.0582f, -0.2439f, 0.0833f));
        add(m, "n80_5L", "n83_cube", ModelPartBuilder.create().uv(0, 64).cuboid(2.7286f, -0.2569f, 18.6852f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(7.95f, -0.35f, 1.05f, -1.415f, -1.2451f, 1.4341f));
        add(m, "n80_5L", "n84_cube", ModelPartBuilder.create().uv(10, 64).cuboid(2.8106f, -2.278f, 18.601f, 2, 1, 3, new Dilation(0.1f, -0.1f, -0.05f)), ModelTransform.of(7.95f, 0.25f, 0.85f, -1.5284f, -1.2451f, 1.4341f));
        add(m, "n80_5L", "n85_plane", ModelPartBuilder.create().uv(92, 64).cuboid(-0.4f, 0f, -0.3f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-12.85f, 1.45f, 6.5f, 1.4137f, 0f, 0f));
        add(m, "n80_5L", "n86_plane", ModelPartBuilder.create().uv(96, 64).cuboid(-0.4f, 0f, -0.3f, 1, 1, 1, new Dilation(-0.2f, -0.5f, -0.3f)), ModelTransform.of(-12.85f, 0.85f, 4.6f, 1.4137f, 0f, 0f));
        add(m, "n13_Head", "n87_Headd", ModelPartBuilder.create().uv(0, 0).cuboid(-1.75f, -4f, -4.5f, 8, 8, 8, new Dilation(0.125f, -0.25f, -0.25f)), ModelTransform.of(-27.6f, -37.4f, -0.05f, 0f, 0f, 1.5708f));
        add(m, "n9_Body", "n88_cube", ModelPartBuilder.create().uv(64, 0).cuboid(0.4f, -5.1f, -4.5f, 6, 7, 8, new Dilation(0.05f, 0.05f, -0.25f)), ModelTransform.of(-10.8f, -13.85f, -0.05f, 0f, 0f, 1.4094f));
        add(m, "n9_Body", "n89_cube", ModelPartBuilder.create().uv(66, 16).cuboid(0.4f, -3.3f, -4.5f, 6, 5, 8, new Dilation(0.05f, 0.15f, -0.25f)), ModelTransform.of(-10.2f, -19.6f, -0.05f, 0f, 0f, 1.5708f));
        add(m, "n9_Body", "n90_Body", ModelPartBuilder.create().uv(0, 30).cuboid(-4.3f, -2.25f, -4.5f, 11, 4, 8, new Dilation(-0.1f, 0.125f, -0.25f)), ModelTransform.of(-10.2f, -25.6f, -0.05f, 0f, 0f, 1.5708f));
    }

    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

    @Override
    public void setAngles(MedusaRenderState s) {
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
        boolean fly = false;
        boolean breath = false;
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
