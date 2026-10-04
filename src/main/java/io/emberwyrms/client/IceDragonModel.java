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
 * GENERADO por tools/rig_emit.py a partir de un modelo de Blockbench (Ice Wyvern (Sketchfab)).
 * Geometria y textura convertidas; los movimientos (cuello, cola, alas, patas...) son propios del mod.
 */
public class IceDragonModel extends EntityModel<AshwingRenderState> {
    private final ModelPart[] bones;
    private final ModelPart[] roots;
    private static final float[][] REST = {{-1.8239f, 0f, 0f}, {-1.6581f, 0f, 0f}, {0.3491f, 0f, 0f}, {-0.1309f, 0.0046f, 0.0077f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {-0.1461f, -0.6859f, 0.0846f}, {-3.0631f, 0.4401f, 0.9573f}, {0f, 0f, 0f}, {-0.3667f, 0.6591f, -0.2224f}, {-3.0631f, -0.4401f, -0.9573f}, {0f, 0f, 0f}, {-1.7463f, 0.1031f, -0.0182f}, {2.3562f, 0f, 0f}, {-1.7463f, -0.1031f, 0.0182f}, {2.3562f, 0f, 0f}};
    private static final int HEAD = 0, JAW = 1;
    private static final int[] NECK = {2}, TAIL = {3, 4, 5, 6, 7}, HAIR = {};
    private static final int[][] WING = {{8, 9, 10}, {11, 12, 13}};
    private static final float[] WSIGN = {1f, -1f};
    private static final int[][] LEG = {{14, 15}, {16, 17}};
    private static final float[] LPHASE = {0f, 1f};
    private static final float[] ROOT_Y = {-32.6794f, -21.227f, -9.227f, -9.227f, -21.227f, -41.2612f};
    private static final float[] SIT_LEG = {1.2f, -1.8f, 0.9f}, FLY_LEG = {0.9f, 0.9f, 0.3f}, DEATH_LEG = {0.9f, -1.4f, 0.4f};
    private static final float LEG_AMP = 1.5f, KNEE = 1.2f, BOB = 4.5f, CROUCH = 18f, FLY_BOB = 2f, DEATH_DY = 12f;
    private static final float FLY_NECK = 0.05f, SIT_NECK = -0.25f, DEATH_NECK = 0.7f, SIT_COIL = 0.3f, DEATH_TAIL = -0.1f, DEATH_WING = 1f;
    private static final float FLAP_SPEED = 0.2f, SNAP = 0f, JITTER = 0f, JAW_CLACK = 0f, WAVE = 0.04f, WAVEP = 0f, HEAD_SWAY = 0.1f;
    private static final float FOLD = 0.9f, FOLD_YAW = 0.8f, FOLD_TIP = 1.2f, FOLD_ROLL = 0.3f, FLAP = 0.8f, TAIL_AMP = 1f, LEG_AMP = 1.5f;

    public IceDragonModel(ModelPart root) {
        super(root);
        this.bones = new ModelPart[] {
            root.getChild("b0_dragon1").getChild("b1_Neckhead").getChild("b7_Main_head"),
            root.getChild("b0_dragon1").getChild("b1_Neckhead").getChild("b7_Main_head").getChild("b11_bone"),
            root.getChild("b0_dragon1").getChild("b1_Neckhead"),
            root.getChild("b0_dragon1").getChild("b49_tail"),
            root.getChild("b0_dragon1").getChild("b49_tail").getChild("b53_tail4"),
            root.getChild("b0_dragon1").getChild("b49_tail").getChild("b53_tail4").getChild("b54_tail5"),
            root.getChild("b0_dragon1").getChild("b49_tail").getChild("b53_tail4").getChild("b54_tail5").getChild("b55_tail6"),
            root.getChild("b0_dragon1").getChild("b49_tail").getChild("b53_tail4").getChild("b54_tail5").getChild("b55_tail6").getChild("b56_tail7"),
            root.getChild("b0_dragon1").getChild("b41_WING").getChild("b42_left_wing"),
            root.getChild("b0_dragon1").getChild("b41_WING").getChild("b42_left_wing").getChild("b44_wing3"),
            root.getChild("b0_dragon1").getChild("b41_WING").getChild("b42_left_wing").getChild("b44_wing3").getChild("b45_bone5"),
            root.getChild("b88_right_wing"),
            root.getChild("b88_right_wing").getChild("b90_wing4"),
            root.getChild("b88_right_wing").getChild("b90_wing4").getChild("b91_bone15"),
            root.getChild("b71_rearleg3"),
            root.getChild("b71_rearleg3").getChild("b72_rearlegtip3"),
            root.getChild("b79_rearleg2"),
            root.getChild("b79_rearleg2").getChild("b80_rearlegtip2")
        };
        this.roots = new ModelPart[] {
            root.getChild("b0_dragon1"),
            root.getChild("b70_Front_leg2"),
            root.getChild("b71_rearleg3"),
            root.getChild("b79_rearleg2"),
            root.getChild("b87_Front_leg3"),
            root.getChild("b88_right_wing")
        };
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        Map<String, ModelPartData> m = new HashMap<>();
        m.put("", data.getRoot());
        p0(m);
        p1(m);
        p2(m);
        p3(m);
        p4(m);
        p5(m);
        return TexturedModelData.of(data, 1024, 1024);
    }

    private static void add(Map<String, ModelPartData> m, String parent, String name, ModelPartBuilder b, ModelTransform t) {
        m.put(name, m.get(parent).addChild(name, b, t));
    }

    private static void p0(Map<String, ModelPartData> m) {
        add(m, "", "b0_dragon1", ModelPartBuilder.create(), ModelTransform.of(-2f, -32.6794f, 60f, -0.3054f, 0f, 0f));
        add(m, "b0_dragon1", "b1_Neckhead", ModelPartBuilder.create(), ModelTransform.of(2f, 3.3524f, -14.2959f, 0.3491f, 0f, 0f));
        add(m, "b1_Neckhead", "b2_4", ModelPartBuilder.create(), ModelTransform.of(0f, -1.2586f, -39.1837f, 0f, 0f, 0f));
        add(m, "b2_4", "c97_4", ModelPartBuilder.create().uv(418, 164).cuboid(-21f, -12.1429f, -10.3381f, 40, 24, 21, new Dilation(0f, 0.05f, 0f)), ModelTransform.of(0f, 0f, 0f, 0.1833f, 0f, 0f));
        add(m, "b1_Neckhead", "b3_3", ModelPartBuilder.create(), ModelTransform.of(0f, 5.3414f, -57.1837f, 0f, 0f, 0f));
        add(m, "b3_3", "c98_3", ModelPartBuilder.create().uv(104, 209).cuboid(-17.2f, -13.0574f, -12.3674f, 33, 21, 21, new Dilation(0.2f, 0.05f, 0f)), ModelTransform.of(0f, 0f, 0f, 0.2182f, 0f, 0f));
        add(m, "b1_Neckhead", "b4_2", ModelPartBuilder.create(), ModelTransform.of(0f, 10.4414f, -78.0837f, 0f, 0f, 0f));
        add(m, "b4_2", "c99_2", ModelPartBuilder.create().uv(0, 209).cuboid(-16f, -14.5677f, -11.5772f, 31, 22, 21, new Dilation(0f, 0.2f, 0f)), ModelTransform.of(0f, 0f, 0f, 0.192f, 0f, 0f));
        add(m, "b1_Neckhead", "b5_1", ModelPartBuilder.create(), ModelTransform.of(0f, 10.4414f, -78.0837f, 0f, 0f, 0f));
        add(m, "b5_1", "c100_1", ModelPartBuilder.create().uv(540, 164).cuboid(-16f, -28.5f, -32f, 31, 21, 24, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -0.4f, 0.0785f, 0f, 0f));
        add(m, "b1_Neckhead", "b6_neck5", ModelPartBuilder.create(), ModelTransform.of(0f, 38.7658f, -101.583f, 1.4399f, 0f, 0f));
        add(m, "b6_neck5", "c101_neck5", ModelPartBuilder.create().uv(280, 312).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 10.774f, 28.8926f, -0.0436f, 0f, 0f));
        add(m, "b6_neck5", "c102_neck5", ModelPartBuilder.create().uv(328, 312).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 4.874f, 25.8926f, -0.0873f, 0f, 0f));
        add(m, "b6_neck5", "c103_neck5", ModelPartBuilder.create().uv(376, 312).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0.674f, 25.2926f, -0.0436f, 0f, 0f));
        add(m, "b6_neck5", "c104_neck5", ModelPartBuilder.create().uv(424, 312).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 54.774f, 46.7926f, -0.0436f, 0f, 0f));
        add(m, "b6_neck5", "c105_neck5", ModelPartBuilder.create().uv(472, 312).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 47.874f, 43.8925f, -0.1745f, 0f, 0f));
        add(m, "b6_neck5", "c106_neck5", ModelPartBuilder.create().uv(520, 312).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 43.974f, 41.7926f, -0.0873f, 0f, 0f));
        add(m, "b6_neck5", "c107_neck5", ModelPartBuilder.create().uv(568, 312).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 39.774f, 39.7926f, -0.0436f, 0f, 0f));
        add(m, "b6_neck5", "c108_neck5", ModelPartBuilder.create().uv(616, 312).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 34.874f, 37.7926f, -0.0436f, 0f, 0f));
        add(m, "b6_neck5", "c109_neck5", ModelPartBuilder.create().uv(664, 312).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 28.974f, 34.7926f, -0.0873f, 0f, 0f));
        add(m, "b6_neck5", "c110_neck5", ModelPartBuilder.create().uv(712, 312).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 24.774f, 34.1925f, -0.0436f, 0f, 0f));
        add(m, "b6_neck5", "c111_neck5", ModelPartBuilder.create().uv(760, 312).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 19.874f, 31.7926f, -0.0436f, 0f, 0f));
        add(m, "b6_neck5", "c112_neck5", ModelPartBuilder.create().uv(808, 312).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 58.974f, 47.3925f, -0.0873f, 0f, 0f));
        add(m, "b6_neck5", "c113_neck5", ModelPartBuilder.create().uv(856, 312).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 62.874f, 49.8925f, -0.1745f, 0f, 0f));
        add(m, "b6_neck5", "c114_neck5", ModelPartBuilder.create().uv(904, 312).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 68.974f, 51.3925f, -0.0873f, 0f, 0f));
        add(m, "b6_neck5", "c115_neck5", ModelPartBuilder.create().uv(952, 312).cuboid(-3f, -4.158f, 1.6704f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 12.974f, 26.8926f, -0.1309f, 0f, 0f));
        add(m, "b6_neck5", "c116_neck5", ModelPartBuilder.create().uv(0, 336).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -4.226f, 22.8925f, -0.0436f, 0f, 0f));
        add(m, "b6_neck5", "c117_neck5", ModelPartBuilder.create().uv(48, 336).cuboid(-3f, -4.158f, 1.6704f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -11.126f, 17.9926f, -0.1309f, 0f, 0f));
        add(m, "b1_Neckhead", "b7_Main_head", ModelPartBuilder.create(), ModelTransform.of(-0.2041f, 16.4701f, -82.7979f, -1.8239f, 0f, 0f));
        add(m, "b7_Main_head", "b8_bone2", ModelPartBuilder.create(), ModelTransform.of(1.3041f, 34.4886f, 14.1231f, 1.8326f, 0f, 0f));
        add(m, "b8_bone2", "b9_bone7", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "b8_bone2", "c118_bone2", ModelPartBuilder.create().uv(212, 209).cuboid(-6f, -13.1359f, -22.6498f, 10, 10, 32, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.4f, -4.7622f, 13.3997f, 0.2793f, 0f, 0f));
        add(m, "b8_bone2", "c119_bone2", ModelPartBuilder.create().uv(320, 107).cuboid(-18f, -18.1359f, -22.6498f, 33, 19, 32, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -6.7622f, 12.8997f, 0.2793f, 0f, 0f));
        add(m, "b7_Main_head", "b10_upper_jaw", ModelPartBuilder.create(), ModelTransform.of(0.3041f, 48.0205f, 4.7117f, 1.8326f, 0f, 0f));
        add(m, "b10_upper_jaw", "c120_upper_jaw", ModelPartBuilder.create().uv(112, 252).cuboid(-13f, -4.4359f, -18.6498f, 23, 10, 20, new Dilation(0f, -0.1f, 0f)), ModelTransform.of(1f, 3.2309f, -18.4654f, 0.1658f, 0f, 0f));
        add(m, "b10_upper_jaw", "c121_upper_jaw", ModelPartBuilder.create().uv(458, 496).cuboid(-13f, -1.1359f, -11.6498f, 23, 1, 3, new Dilation(0f, 0.2f, -0.0534f)), ModelTransform.of(1f, -0.2691f, -25.9654f, 0.1658f, 0f, 0f));
        add(m, "b10_upper_jaw", "c122_upper_jaw", ModelPartBuilder.create().uv(228, 496).cuboid(-13f, -1.1359f, -7.8498f, 23, 1, 5, new Dilation(0f, 0.2f, -0.1f)), ModelTransform.of(1f, -1.2691f, -28.1654f, 0.1658f, 0f, 0f));
        add(m, "b10_upper_jaw", "c123_upper_jaw", ModelPartBuilder.create().uv(896, 485).cuboid(-13f, -1.1359f, -8.6498f, 23, 1, 6, new Dilation(0f, 0.2f, 0f)), ModelTransform.of(1f, -0.4691f, -37.9654f, 1.7366f, 0f, 0f));
        add(m, "b10_upper_jaw", "c124_upper_jaw", ModelPartBuilder.create().uv(198, 252).cuboid(-15f, -4.9359f, -18.6498f, 27, 10, 19, new Dilation(0f, 0.15f, -0.15f)), ModelTransform.of(1f, -1.3691f, 0.4346f, 0.2531f, 0f, 0f));
        add(m, "b10_upper_jaw", "c125_upper_jaw", ModelPartBuilder.create().uv(516, 359).cuboid(-12f, -4.6359f, -17.6498f, 21, 3, 19, new Dilation(0f, 0f, 0.15f)), ModelTransform.of(1f, 12.8309f, -17.5654f, 0.1309f, 0f, 0f));
        add(m, "b10_upper_jaw", "c126_upper_jaw", ModelPartBuilder.create().uv(596, 359).cuboid(-12f, -3.4534f, -9.7376f, 21, 3, 19, new Dilation(0f, 0f, 0.15f)), ModelTransform.of(1f, 9.5309f, -7.9654f, 0.2007f, 0f, 0f));
        add(m, "b10_upper_jaw", "c127_upper_jaw", ModelPartBuilder.create().uv(780, 485).cuboid(-13f, -1.1359f, -7.3565f, 23, 1, 9, new Dilation(0f, 0.2f, -0.1466f)), ModelTransform.of(1f, -0.2691f, -25.9654f, 0.1658f, 0f, 0f));
        add(m, "b10_upper_jaw", "c128_upper_jaw", ModelPartBuilder.create().uv(510, 496).cuboid(-11.8f, -1.1359f, -8.7565f, 21, 1, 1, new Dilation(-0.05f, 0.2f, 0.2f)), ModelTransform.of(1f, -0.2691f, -25.9654f, 0.1658f, 0f, 0f));
        add(m, "b7_Main_head", "b11_bone", ModelPartBuilder.create(), ModelTransform.of(1.3041f, 43.3036f, 18.4474f, -1.6581f, 0f, 0f));
        add(m, "b11_bone", "b12_lowerjaw", ModelPartBuilder.create(), ModelTransform.of(-2f, 4.3282f, -5.3458f, 0f, 0f, 0f));
        add(m, "b12_lowerjaw", "c133_lowerjaw", ModelPartBuilder.create().uv(634, 252).cuboid(-11f, -5.4212f, -17.6784f, 19, 7, 20, new Dilation(0f, 0f, 0f)), ModelTransform.of(2f, -18f, 36f, 0.5585f, 0f, 0f));
        add(m, "b12_lowerjaw", "c134_lowerjaw", ModelPartBuilder.create().uv(342, 471).cuboid(-9f, 0.5788f, -14.6784f, 15, 1, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(2f, -25.8f, 36f, 0.5585f, 0f, 0f));
        add(m, "b12_lowerjaw", "c135_lowerjaw", ModelPartBuilder.create().uv(756, 359).cuboid(-10f, -4.6359f, -17.6498f, 17, 3, 19, new Dilation(0f, 0f, 0.15f)), ModelTransform.of(-0.9f, -3.6053f, 23.5212f, 2.5922f, -0.0057f, 3.1267f));
        add(m, "b12_lowerjaw", "c136_lowerjaw", ModelPartBuilder.create().uv(544, 252).cuboid(-14.1f, -5.4212f, -17.6784f, 25, 7, 20, new Dilation(0.05f, 0f, 0f)), ModelTransform.of(2f, -7.5f, 19.2f, 0.5585f, 0f, 0f));
        add(m, "b12_lowerjaw", "c137_lowerjaw", ModelPartBuilder.create().uv(676, 359).cuboid(-12f, -3.4534f, -9.7376f, 21, 3, 19, new Dilation(0f, 0f, 0.15f)), ModelTransform.of(2f, -0.6053f, 15.2212f, 0.5498f, 0f, 0f));
        add(m, "b12_lowerjaw", "c138_lowerjaw", ModelPartBuilder.create().uv(896, 209).cuboid(-7f, -3.4534f, -9.7376f, 11, 3, 33, new Dilation(0f, 0f, 0.15f)), ModelTransform.of(2.4f, -1.2053f, 14.0212f, 0.5498f, 0f, 0f));
        add(m, "b11_bone", "b13_tooth2", ModelPartBuilder.create(), ModelTransform.of(-3f, 1.8445f, 2.4779f, 2.7053f, 0f, 3.1416f));
        add(m, "b11_bone", "b14_bone9", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "b14_bone9", "b15_kanmuri", ModelPartBuilder.create(), ModelTransform.of(-4.2f, 36.8568f, -5.5625f, -3.0369f, 0f, 0f));
        add(m, "b15_kanmuri", "b16_bone31", ModelPartBuilder.create(), ModelTransform.of(17.8f, 15.453f, -11.0265f, -0.3481f, -0.1579f, 1.4423f));
        add(m, "b16_bone31", "c142_bone31", ModelPartBuilder.create().uv(934, 439).cuboid(-7.6834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(-13.7255f, -19.6689f, 31.5212f, 0.8131f, -0.712f, -0.2155f));
        add(m, "b16_bone31", "c143_bone31", ModelPartBuilder.create().uv(442, 402).cuboid(-8.0834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(-0.6255f, -8.6689f, 15.3212f, 0.566f, -0.5411f, -0.107f));
        add(m, "b16_bone31", "c144_bone31", ModelPartBuilder.create().uv(476, 402).cuboid(-8.0834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(-6.5255f, -13.4689f, 23.7212f, 0.6436f, -0.6194f, -0.153f));
        add(m, "b16_bone31", "c145_bone31", ModelPartBuilder.create().uv(712, 252).cuboid(-8.0834f, -2.6725f, -3.8766f, 5, 5, 22, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(6.1745f, 0.5311f, -1.2788f, 0.4226f, -0.366f, -0.0192f));
        add(m, "b15_kanmuri", "b17_bone34", ModelPartBuilder.create(), ModelTransform.of(-10.9f, 15.453f, -11.0265f, -0.3481f, 0.1579f, -1.4423f));
    }

    private static void p1(Map<String, ModelPartData> m) {
        add(m, "b17_bone34", "c146_bone34", ModelPartBuilder.create().uv(964, 439).cuboid(4.4834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(12.4255f, -20.7689f, 31.5212f, 0.8131f, 0.712f, 0.2155f));
        add(m, "b17_bone34", "c147_bone34", ModelPartBuilder.create().uv(510, 402).cuboid(3.8834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(-0.0745f, -8.6689f, 15.3212f, 0.566f, 0.5411f, 0.107f));
        add(m, "b17_bone34", "c148_bone34", ModelPartBuilder.create().uv(544, 402).cuboid(4.1834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(5.8255f, -13.8689f, 23.7212f, 0.7046f, 0.6194f, 0.153f));
        add(m, "b17_bone34", "c149_bone34", ModelPartBuilder.create().uv(766, 252).cuboid(3.2834f, -2.6725f, -3.8766f, 5, 5, 22, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(-6.8745f, 0.3311f, -1.2788f, 0.4226f, 0.366f, 0.0192f));
        add(m, "b15_kanmuri", "b18_bone35", ModelPartBuilder.create(), ModelTransform.of(-5.9f, 15.453f, -11.0265f, -0.3573f, 0.2726f, -1.4855f));
        add(m, "b18_bone35", "c150_bone35", ModelPartBuilder.create().uv(994, 439).cuboid(4.4834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(12.4255f, -20.7689f, 31.5212f, 0.8131f, 0.712f, 0.2155f));
        add(m, "b18_bone35", "c151_bone35", ModelPartBuilder.create().uv(578, 402).cuboid(3.8834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(-0.0745f, -8.6689f, 15.3212f, 0.566f, 0.5411f, 0.107f));
        add(m, "b18_bone35", "c152_bone35", ModelPartBuilder.create().uv(612, 402).cuboid(4.1834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(5.8255f, -13.8689f, 23.7212f, 0.7046f, 0.6194f, 0.153f));
        add(m, "b18_bone35", "c153_bone35", ModelPartBuilder.create().uv(820, 252).cuboid(3.2834f, -2.6725f, -3.8766f, 5, 5, 22, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(-6.8745f, 0.3311f, -1.2788f, 0.4226f, 0.366f, 0.0192f));
        add(m, "b15_kanmuri", "b19_bone36", ModelPartBuilder.create(), ModelTransform.of(12.6f, 15.453f, -11.0265f, -0.3591f, -0.289f, 1.4919f));
        add(m, "b19_bone36", "c154_bone36", ModelPartBuilder.create().uv(0, 455).cuboid(-7.6834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(-13.7255f, -19.6689f, 31.5212f, 0.8131f, -0.712f, -0.2155f));
        add(m, "b19_bone36", "c155_bone36", ModelPartBuilder.create().uv(646, 402).cuboid(-8.0834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(-0.6255f, -8.6689f, 15.3212f, 0.566f, -0.5411f, -0.107f));
        add(m, "b19_bone36", "c156_bone36", ModelPartBuilder.create().uv(680, 402).cuboid(-8.0834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(-6.5255f, -13.4689f, 23.7212f, 0.6436f, -0.6194f, -0.153f));
        add(m, "b19_bone36", "c157_bone36", ModelPartBuilder.create().uv(874, 252).cuboid(-8.0834f, -2.6725f, -3.8766f, 5, 5, 22, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(6.1745f, 0.5311f, -1.2788f, 0.4226f, -0.366f, -0.0192f));
        add(m, "b15_kanmuri", "b20_bone37", ModelPartBuilder.create(), ModelTransform.of(8.6f, 15.453f, -11.0265f, -0.3339f, -0.4088f, 1.4395f));
        add(m, "b20_bone37", "c158_bone37", ModelPartBuilder.create().uv(30, 455).cuboid(-7.6834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(-13.7255f, -19.6689f, 31.5212f, 0.8131f, -0.712f, -0.2155f));
        add(m, "b20_bone37", "c159_bone37", ModelPartBuilder.create().uv(714, 402).cuboid(-8.0834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(-0.6255f, -8.6689f, 15.3212f, 0.566f, -0.5411f, -0.107f));
        add(m, "b20_bone37", "c160_bone37", ModelPartBuilder.create().uv(748, 402).cuboid(-8.0834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(-6.5255f, -13.4689f, 23.7212f, 0.6436f, -0.6194f, -0.153f));
        add(m, "b20_bone37", "c161_bone37", ModelPartBuilder.create().uv(928, 252).cuboid(-8.0834f, -2.6725f, -3.8766f, 5, 5, 22, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(6.1745f, 0.5311f, -1.2788f, 0.4226f, -0.366f, -0.0192f));
        add(m, "b15_kanmuri", "b21_bone38", ModelPartBuilder.create(), ModelTransform.of(-2.4f, 15.453f, -11.0265f, -0.3339f, 0.4088f, -1.4395f));
        add(m, "b21_bone38", "c162_bone38", ModelPartBuilder.create().uv(60, 455).cuboid(4.4834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(13.7255f, -19.6689f, 31.5212f, 0.8131f, 0.712f, 0.2155f));
        add(m, "b21_bone38", "c163_bone38", ModelPartBuilder.create().uv(782, 402).cuboid(3.8834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(0.6255f, -8.6689f, 15.3212f, 0.566f, 0.5411f, 0.107f));
        add(m, "b21_bone38", "c164_bone38", ModelPartBuilder.create().uv(816, 402).cuboid(4.1834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(6.5255f, -13.4689f, 23.7212f, 0.6436f, 0.6194f, 0.153f));
        add(m, "b21_bone38", "c165_bone38", ModelPartBuilder.create().uv(0, 285).cuboid(3.2834f, -2.6725f, -3.8766f, 5, 5, 22, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(-6.1745f, 0.5311f, -1.2788f, 0.4226f, 0.366f, 0.0192f));
        add(m, "b15_kanmuri", "b22_kanmuri2", ModelPartBuilder.create(), ModelTransform.of(1.9f, 15.453f, -11.0265f, -0.2618f, 0f, 0f));
        add(m, "b22_kanmuri2", "b23_bone30", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, -0.4733f, 0.6459f, -1.5424f));
        add(m, "b23_bone30", "c166_bone30", ModelPartBuilder.create().uv(870, 439).cuboid(3.2834f, -2.6725f, 7.1234f, 5, 5, 11, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(-6.1745f, 0.5311f, -1.2788f, 0.4226f, 0.366f, 0.0192f));
        add(m, "b23_bone30", "c167_bone30", ModelPartBuilder.create().uv(90, 455).cuboid(4.4834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(13.7255f, -19.6689f, 31.5212f, 0.8131f, 0.712f, 0.2155f));
        add(m, "b23_bone30", "c168_bone30", ModelPartBuilder.create().uv(850, 402).cuboid(3.8834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(0.6255f, -8.6689f, 15.3212f, 0.566f, 0.5411f, 0.107f));
        add(m, "b23_bone30", "c169_bone30", ModelPartBuilder.create().uv(884, 402).cuboid(4.1834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(6.5255f, -13.4689f, 23.7212f, 0.6436f, 0.6194f, 0.153f));
        add(m, "b22_kanmuri2", "b24_bone32", ModelPartBuilder.create(), ModelTransform.of(2.4f, 0f, 0f, -0.4733f, -0.6459f, 1.5424f));
        add(m, "b24_bone32", "c170_bone32", ModelPartBuilder.create().uv(120, 455).cuboid(-7.6834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(-13.7255f, -19.6689f, 31.5212f, 0.8131f, -0.712f, -0.2155f));
        add(m, "b24_bone32", "c171_bone32", ModelPartBuilder.create().uv(918, 402).cuboid(-8.0834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(-0.6255f, -8.6689f, 15.3212f, 0.566f, -0.5411f, -0.107f));
        add(m, "b24_bone32", "c172_bone32", ModelPartBuilder.create().uv(952, 402).cuboid(-8.0834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(-6.5255f, -13.4689f, 23.7212f, 0.6436f, -0.6194f, -0.153f));
        add(m, "b24_bone32", "c173_bone32", ModelPartBuilder.create().uv(370, 402).cuboid(-8.0834f, -2.6725f, 5.1234f, 5, 5, 13, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(6.1745f, 0.5311f, -1.2788f, 0.4226f, -0.366f, -0.0192f));
        add(m, "b22_kanmuri2", "b25_bone33", ModelPartBuilder.create(), ModelTransform.of(-4.3f, 0f, 0f, -0.3339f, 0.4088f, -1.4395f));
        add(m, "b25_bone33", "c174_bone33", ModelPartBuilder.create().uv(150, 455).cuboid(4.4834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(13.7255f, -19.6689f, 31.5212f, 0.8131f, 0.712f, 0.2155f));
        add(m, "b25_bone33", "c175_bone33", ModelPartBuilder.create().uv(986, 402).cuboid(3.8834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(0.6255f, -8.6689f, 15.3212f, 0.566f, 0.5411f, 0.107f));
        add(m, "b25_bone33", "c176_bone33", ModelPartBuilder.create().uv(0, 421).cuboid(4.1834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(6.5255f, -13.4689f, 23.7212f, 0.6436f, 0.6194f, 0.153f));
        add(m, "b25_bone33", "c177_bone33", ModelPartBuilder.create().uv(54, 285).cuboid(3.2834f, -2.6725f, -3.8766f, 5, 5, 22, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(-6.1745f, 0.5311f, -1.2788f, 0.4226f, 0.366f, 0.0192f));
        add(m, "b22_kanmuri2", "b26_bone40", ModelPartBuilder.create(), ModelTransform.of(6.7f, 0f, 0f, -0.3339f, -0.4088f, 1.4395f));
        add(m, "b26_bone40", "c178_bone40", ModelPartBuilder.create().uv(180, 455).cuboid(-7.6834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(-13.7255f, -19.6689f, 31.5212f, 0.8131f, -0.712f, -0.2155f));
        add(m, "b26_bone40", "c179_bone40", ModelPartBuilder.create().uv(34, 421).cuboid(-8.0834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(-0.6255f, -8.6689f, 15.3212f, 0.566f, -0.5411f, -0.107f));
        add(m, "b26_bone40", "c180_bone40", ModelPartBuilder.create().uv(68, 421).cuboid(-8.0834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(-6.5255f, -13.4689f, 23.7212f, 0.6436f, -0.6194f, -0.153f));
        add(m, "b26_bone40", "c181_bone40", ModelPartBuilder.create().uv(104, 402).cuboid(-8.0834f, -2.6725f, 4.1234f, 5, 5, 14, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(6.1745f, 0.5311f, -1.2788f, 0.4226f, -0.366f, -0.0192f));
        add(m, "b22_kanmuri2", "b27_bone42", ModelPartBuilder.create(), ModelTransform.of(-7.8f, 0f, 0f, -0.3573f, 0.2726f, -1.4855f));
        add(m, "b27_bone42", "c182_bone42", ModelPartBuilder.create().uv(210, 455).cuboid(4.4834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(12.4255f, -20.7689f, 31.5212f, 0.8131f, 0.712f, 0.2155f));
        add(m, "b27_bone42", "c183_bone42", ModelPartBuilder.create().uv(102, 421).cuboid(3.8834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(-0.0745f, -8.6689f, 15.3212f, 0.566f, 0.5411f, 0.107f));
        add(m, "b27_bone42", "c184_bone42", ModelPartBuilder.create().uv(136, 421).cuboid(4.1834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(5.8255f, -13.8689f, 23.7212f, 0.7046f, 0.6194f, 0.153f));
        add(m, "b27_bone42", "c185_bone42", ModelPartBuilder.create().uv(938, 455).cuboid(3.2834f, -2.6725f, 9.1234f, 5, 5, 9, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(-6.8745f, 0.3311f, -1.2788f, 0.4226f, 0.366f, 0.0192f));
        add(m, "b22_kanmuri2", "b28_bone41", ModelPartBuilder.create(), ModelTransform.of(10.7f, 0f, 0f, -0.3591f, -0.289f, 1.4919f));
        add(m, "b28_bone41", "c186_bone41", ModelPartBuilder.create().uv(240, 455).cuboid(-7.6834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(-13.7255f, -19.6689f, 31.5212f, 0.8131f, -0.712f, -0.2155f));
        add(m, "b28_bone41", "c187_bone41", ModelPartBuilder.create().uv(170, 421).cuboid(-8.0834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(-0.6255f, -8.6689f, 15.3212f, 0.566f, -0.5411f, -0.107f));
        add(m, "b28_bone41", "c188_bone41", ModelPartBuilder.create().uv(204, 421).cuboid(-8.0834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(-6.5255f, -13.4689f, 23.7212f, 0.6436f, -0.6194f, -0.153f));
        add(m, "b28_bone41", "c189_bone41", ModelPartBuilder.create().uv(406, 402).cuboid(-8.0834f, -2.6725f, 5.1234f, 5, 5, 13, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(6.1745f, 0.5311f, -1.2788f, 0.4226f, -0.366f, -0.0192f));
        add(m, "b22_kanmuri2", "b29_bone43", ModelPartBuilder.create(), ModelTransform.of(-4.3f, 0f, 0f, -0.552f, 0.4088f, -1.4395f));
        add(m, "b29_bone43", "c190_bone43", ModelPartBuilder.create().uv(270, 455).cuboid(4.4834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(13.7255f, -19.6689f, 31.5212f, 0.8131f, 0.712f, 0.2155f));
        add(m, "b29_bone43", "c191_bone43", ModelPartBuilder.create().uv(238, 421).cuboid(3.8834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(0.6255f, -8.6689f, 15.3212f, 0.566f, 0.5411f, 0.107f));
        add(m, "b29_bone43", "c192_bone43", ModelPartBuilder.create().uv(272, 421).cuboid(4.1834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(6.5255f, -13.4689f, 23.7212f, 0.6436f, 0.6194f, 0.153f));
        add(m, "b29_bone43", "c193_bone43", ModelPartBuilder.create().uv(966, 455).cuboid(3.2834f, -2.6725f, 9.1234f, 5, 5, 9, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(-6.1745f, 0.5311f, -1.2788f, 0.4226f, 0.366f, 0.0192f));
    }

    private static void p2(Map<String, ModelPartData> m) {
        add(m, "b22_kanmuri2", "b30_bone44", ModelPartBuilder.create(), ModelTransform.of(6.7f, 0f, 0f, -0.552f, -0.4088f, 1.4395f));
        add(m, "b30_bone44", "c194_bone44", ModelPartBuilder.create().uv(300, 455).cuboid(-7.6834f, -2.1725f, -3.8766f, 3, 4, 12, new Dilation(0.1f, 0.05f, 0.25f)), ModelTransform.of(-13.7255f, -19.6689f, 31.5212f, 0.8131f, -0.712f, -0.2155f));
        add(m, "b30_bone44", "c195_bone44", ModelPartBuilder.create().uv(306, 421).cuboid(-8.0834f, -1.3725f, -3.8766f, 4, 5, 13, new Dilation(0.1f, -0.15f, 0f)), ModelTransform.of(-0.6255f, -8.6689f, 15.3212f, 0.566f, -0.5411f, -0.107f));
        add(m, "b30_bone44", "c196_bone44", ModelPartBuilder.create().uv(340, 421).cuboid(-8.0834f, -2.0725f, -3.8766f, 4, 5, 13, new Dilation(-0.05f, -0.15f, 0f)), ModelTransform.of(-6.5255f, -13.4689f, 23.7212f, 0.6436f, -0.6194f, -0.153f));
        add(m, "b30_bone44", "c197_bone44", ModelPartBuilder.create().uv(902, 439).cuboid(-8.0834f, -2.6725f, 7.1234f, 5, 5, 11, new Dilation(-0.1f, 0.1f, 0f)), ModelTransform.of(6.1745f, 0.5311f, -1.2788f, 0.4226f, -0.366f, -0.0192f));
        add(m, "b14_bone9", "b31_bone8", ModelPartBuilder.create(), ModelTransform.of(0f, -26.6798f, -36.3802f, 0f, 0f, 0f));
        add(m, "b14_bone9", "b32_bone11", ModelPartBuilder.create(), ModelTransform.of(0f, -0.3828f, 0.0984f, -0.0349f, 0f, 0f));
        add(m, "b32_bone11", "c198_bone11", ModelPartBuilder.create().uv(48, 496).cuboid(-3f, -1.1212f, -2.6784f, 19, 2, 5, new Dilation(0f, -0.15f, 0f)), ModelTransform.of(15.6f, 31.4282f, -13.8458f, 2.6849f, 0.6827f, 0.8354f));
        add(m, "b32_bone11", "c199_bone11", ModelPartBuilder.create().uv(96, 496).cuboid(-3f, -1.1212f, -3.0784f, 19, 2, 5, new Dilation(0f, -0.15f, 0.2f)), ModelTransform.of(15.4f, 27.3282f, -16.2458f, 2.3663f, 0.9123f, 0.6535f));
        add(m, "b32_bone11", "c200_bone11", ModelPartBuilder.create().uv(186, 496).cuboid(-3f, -1.1212f, -3.0784f, 16, 2, 5, new Dilation(-0.25f, -0.15f, 0.2f)), ModelTransform.of(13.5f, 21.4282f, -15.5458f, 2.3602f, 1.0326f, 0.5833f));
        add(m, "b14_bone9", "c139_bone9", ModelPartBuilder.create().uv(954, 485).cuboid(-16f, -1.1212f, -2.6784f, 19, 2, 5, new Dilation(0f, -0.15f, 0f)), ModelTransform.of(-18.2f, 31.0282f, -15.2458f, 2.6785f, -0.6984f, -0.8254f));
        add(m, "b14_bone9", "c140_bone9", ModelPartBuilder.create().uv(144, 496).cuboid(-12.5f, -1.1212f, -3.0784f, 16, 2, 5, new Dilation(-0.25f, -0.15f, 0.2f)), ModelTransform.of(-15.7f, 18.8282f, -15.8458f, 2.5476f, -0.8698f, -0.8123f));
        add(m, "b14_bone9", "c141_bone9", ModelPartBuilder.create().uv(0, 496).cuboid(-16f, -1.1212f, -3.0784f, 19, 2, 5, new Dilation(0f, -0.15f, 0.2f)), ModelTransform.of(-16.4f, 25.2282f, -15.8458f, 2.5915f, -0.8354f, -0.72f));
        add(m, "b11_bone", "c129_bone", ModelPartBuilder.create().uv(290, 252).cuboid(-14.2f, -2.2212f, -17.6784f, 25, 8, 20, new Dilation(0.15f, -0.15f, 0f)), ModelTransform.of(0f, 3.4282f, -2.2458f, 0.4363f, 0f, 0f));
        add(m, "b11_bone", "c130_bone", ModelPartBuilder.create().uv(284, 496).cuboid(-14.2f, -0.4212f, -1.6784f, 25, 1, 4, new Dilation(-0.1f, -0.1f, 0f)), ModelTransform.of(0f, 1.8282f, -5.1458f, 0.4451f, 0f, 0f));
        add(m, "b11_bone", "c131_bone", ModelPartBuilder.create().uv(342, 496).cuboid(-14.2f, -0.4212f, -1.6784f, 25, 1, 4, new Dilation(-0.1f, -0.1f, 0f)), ModelTransform.of(0f, 3.5282f, -8.6458f, 0.4451f, 0f, 0f));
        add(m, "b11_bone", "c132_bone", ModelPartBuilder.create().uv(400, 496).cuboid(-14f, -0.4212f, -1.6784f, 25, 1, 4, new Dilation(-0.2f, 0.1f, 0f)), ModelTransform.of(0f, 0.6282f, -1.5458f, 0.1396f, 0f, 0f));
        add(m, "b1_Neckhead", "c96_Neckhead", ModelPartBuilder.create().uv(280, 164).cuboid(-26f, -24.7426f, -16.1975f, 50, 26, 19, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 6.9414f, -14.1837f, 0.1745f, 0f, 0f));
        add(m, "b0_dragon1", "b33_body", ModelPartBuilder.create(), ModelTransform.of(2f, 39.8524f, -1.4959f, 0.1745f, 0f, 0f));
        add(m, "b33_body", "b34_bone45", ModelPartBuilder.create(), ModelTransform.of(0f, -52.2524f, 68.4959f, 0f, 0f, 0f));
        add(m, "b34_bone45", "b35_bone47", ModelPartBuilder.create(), ModelTransform.of(0f, -16.3927f, -46.6316f, 1.5708f, 0f, 0f));
        add(m, "b35_bone47", "c202_bone47", ModelPartBuilder.create().uv(96, 336).cuboid(-3f, -2.621f, -14.4919f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -28.763f, -0.6501f, -0.0873f, 0f, 0f));
        add(m, "b35_bone47", "c203_bone47", ModelPartBuilder.create().uv(144, 336).cuboid(-3f, -1.4542f, -14.2332f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -24.863f, 1.8499f, -0.1745f, 0f, 0f));
        add(m, "b35_bone47", "c204_bone47", ModelPartBuilder.create().uv(192, 336).cuboid(-3f, -4.114f, -8.8849f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -17.363f, -2.9501f, -0.0436f, 0f, 0f));
        add(m, "b35_bone47", "c205_bone47", ModelPartBuilder.create().uv(240, 336).cuboid(-3f, -4.5833f, -3.3635f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -13.163f, -6.2501f, -0.0873f, 0f, 0f));
        add(m, "b35_bone47", "c206_bone47", ModelPartBuilder.create().uv(288, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -0.563f, -2.5501f, 0.1222f, 0f, 0f));
        add(m, "b35_bone47", "c207_bone47", ModelPartBuilder.create().uv(336, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 5.437f, -3.8501f, 0.1745f, 0f, 0f));
        add(m, "b35_bone47", "c208_bone47", ModelPartBuilder.create().uv(384, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 9.437f, -1.9501f, 0.0873f, 0f, 0f));
        add(m, "b35_bone47", "c209_bone47", ModelPartBuilder.create().uv(432, 336).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16.237f, 0.5499f, 0.2182f, 0f, 0f));
        add(m, "b35_bone47", "c210_bone47", ModelPartBuilder.create().uv(480, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 25.437f, 0.0499f, 0.1396f, 0f, 0f));
        add(m, "b35_bone47", "c211_bone47", ModelPartBuilder.create().uv(528, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 29.537f, -1.3501f, 0.0873f, 0f, 0f));
        add(m, "b35_bone47", "c212_bone47", ModelPartBuilder.create().uv(576, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 20.837f, 0.0499f, 0.1745f, 0f, 0f));
        add(m, "b35_bone47", "c213_bone47", ModelPartBuilder.create().uv(624, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -6.063f, -6.1501f, 0.0698f, 0f, 0f));
        add(m, "b34_bone45", "c201_bone45", ModelPartBuilder.create().uv(192, 0).cuboid(-34f, -13.243f, -0.4774f, 68, 38, 63, new Dilation(0f, -0.2f, 0f)), ModelTransform.of(0f, -1.9927f, -75.6316f, 0.2269f, 0f, 0f));
        add(m, "b33_body", "b36_bone39", ModelPartBuilder.create(), ModelTransform.of(0f, -37f, -25f, 0f, 0f, 0f));
        add(m, "b36_bone39", "b37_bone48", ModelPartBuilder.create(), ModelTransform.of(0f, -15.2524f, 93.4959f, 0f, 0f, 0f));
        add(m, "b37_bone48", "b38_bone10", ModelPartBuilder.create(), ModelTransform.of(0f, -47.7476f, -173.6959f, 1.5708f, 0f, 0f));
        add(m, "b38_bone10", "c215_bone10", ModelPartBuilder.create().uv(672, 336).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 162.9398f, -33.7905f, 0.0436f, 0f, 0f));
        add(m, "b38_bone10", "c216_bone10", ModelPartBuilder.create().uv(720, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 168.5398f, -35.4905f, 0.0873f, 0f, 0f));
        add(m, "b38_bone10", "c217_bone10", ModelPartBuilder.create().uv(768, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 172.9398f, -35.5905f, 0.0524f, 0f, 0f));
        add(m, "b38_bone10", "c218_bone10", ModelPartBuilder.create().uv(816, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 177.7398f, -35.1905f, 0.0873f, 0f, 0f));
        add(m, "b38_bone10", "c219_bone10", ModelPartBuilder.create().uv(864, 336).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 181.8398f, -33.7905f, 0.0436f, 0f, 0f));
        add(m, "b38_bone10", "c220_bone10", ModelPartBuilder.create().uv(912, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 187.4398f, -34.9905f, 0.0873f, 0f, 0f));
        add(m, "b38_bone10", "c221_bone10", ModelPartBuilder.create().uv(960, 336).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 191.9398f, -35.1905f, 0.0524f, 0f, 0f));
        add(m, "b38_bone10", "c222_bone10", ModelPartBuilder.create().uv(0, 359).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 197.4398f, -34.4905f, 0.0873f, 0f, 0f));
        add(m, "b36_bone39", "c214_bone39", ModelPartBuilder.create().uv(454, 0).cuboid(-31f, -26.6476f, -19.4959f, 62, 32, 43, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -15.2524f, 93.4959f, 0.0785f, 0f, 0f));
        add(m, "b33_body", "b39_bone6", ModelPartBuilder.create(), ModelTransform.of(0f, -37f, -25f, 0f, 0f, 0f));
        add(m, "b39_bone6", "b40_bone46", ModelPartBuilder.create(), ModelTransform.of(0f, -141.7f, -22.7f, 1.6144f, 0f, 0f));
        add(m, "b40_bone46", "c224_bone46", ModelPartBuilder.create().uv(48, 359).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 23.2398f, -135.1905f, -0.0873f, 0f, 0f));
        add(m, "b40_bone46", "c225_bone46", ModelPartBuilder.create().uv(96, 359).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 12.1398f, -139.8905f, -0.1745f, 0f, 0f));
        add(m, "b40_bone46", "c226_bone46", ModelPartBuilder.create().uv(144, 359).cuboid(-3f, -5.0146f, -2.0439f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 19.0398f, -136.7905f, -0.0436f, 0f, 0f));
        add(m, "b40_bone46", "c227_bone46", ModelPartBuilder.create().uv(192, 359).cuboid(-3f, -5f, -1f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 26.3398f, -133.3905f, -0.1745f, 0f, 0f));
        add(m, "b40_bone46", "c228_bone46", ModelPartBuilder.create().uv(240, 359).cuboid(-3f, 28.5398f, -129.1905f, 6, 5, 18, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "b39_bone6", "c223_bone6", ModelPartBuilder.create().uv(664, 0).cuboid(-33f, -11.192f, -29.4804f, 66, 32, 32, new Dilation(0f, -0.2f, 0f)), ModelTransform.of(0f, -15.2451f, 20.8643f, 0.4363f, 0f, 0f));
        add(m, "b0_dragon1", "b41_WING", ModelPartBuilder.create(), ModelTransform.of(6.4f, -34.2125f, -39.3567f, 0.1309f, 0f, 0f));
        add(m, "b41_WING", "b42_left_wing", ModelPartBuilder.create(), ModelTransform.of(25f, 35.1571f, 7.2507f, -0.1461f, -0.6859f, 0.0846f));
        add(m, "b42_left_wing", "b43_wing5", ModelPartBuilder.create(), ModelTransform.of(77.4595f, -22.2198f, -47.1535f, -3.0631f, 0.4401f, 0.9573f));
        add(m, "b43_wing5", "c231_wing5", ModelPartBuilder.create().uv(0, 0).cuboid(-37.3959f, -74.0565f, 1.9159f, 47, 106, 1, new Dilation(0f, 0.25f, -0.5f)), ModelTransform.of(-21.2033f, -6.9899f, -10.75f, 0.4115f, -0.4961f, -0.6336f));
        add(m, "b42_left_wing", "b44_wing3", ModelPartBuilder.create(), ModelTransform.of(77.4595f, -22.2198f, -47.1535f, -3.0631f, 0.4401f, 0.9573f));
        add(m, "b44_wing3", "b45_bone5", ModelPartBuilder.create(), ModelTransform.of(105.0967f, -1.2899f, 0.15f, 0f, 0f, 0f));
    }

    private static void p3(Map<String, ModelPartData> m) {
        add(m, "b45_bone5", "b46_bone13", ModelPartBuilder.create(), ModelTransform.of(0.9f, 0f, 0f, 0f, 0f, 0.7592f));
        add(m, "b46_bone13", "c241_bone13", ModelPartBuilder.create().uv(548, 421).cuboid(-76.3959f, -3.0565f, -4.0841f, 79, 8, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0f, 0f, 0f, 0f, -1.6406f));
        add(m, "b46_bone13", "c242_bone13", ModelPartBuilder.create().uv(0, 485).cuboid(-70.0959f, -1.5565f, -2.0841f, 73, 6, 5, new Dilation(-0.15f, -0.25f, 0f)), ModelTransform.of(5.3f, 74.9f, -0.6f, 0f, -0.0524f, -1.5184f));
        add(m, "b46_bone13", "c243_bone13", ModelPartBuilder.create().uv(650, 164).cuboid(-70.0959f, -43.5565f, -2.0841f, 73, 42, 1, new Dilation(-0.15f, -0.25f, -0.5f)), ModelTransform.of(5.3f, 76.9f, 4.5f, 0.1313f, -0.0956f, -1.5242f));
        add(m, "b45_bone5", "b47_bone12", ModelPartBuilder.create(), ModelTransform.of(0.9f, 0f, 0f, 0f, 0f, 0.4189f));
        add(m, "b47_bone12", "c244_bone12", ModelPartBuilder.create().uv(722, 421).cuboid(-76.3959f, -3.0565f, -4.0841f, 79, 8, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0f, 0f, 0f, 0f, -1.6406f));
        add(m, "b47_bone12", "c245_bone12", ModelPartBuilder.create().uv(142, 402).cuboid(-48.7035f, -8.1952f, -4.0841f, 56, 17, 1, new Dilation(0f, 0f, -0.5f)), ModelTransform.of(0f, 28f, 6.1f, 0f, 0f, -1.4224f));
        add(m, "b47_bone12", "c246_bone12", ModelPartBuilder.create().uv(516, 471).cuboid(-74.4959f, -1.5565f, -2.0841f, 77, 6, 5, new Dilation(0.05f, -0.25f, 0f)), ModelTransform.of(5.3f, 74.9f, -0.6f, 0f, -0.0175f, -1.5708f));
        add(m, "b47_bone12", "c247_bone12", ModelPartBuilder.create().uv(450, 107).cuboid(-74.4959f, -44.6565f, -2.0841f, 77, 49, 1, new Dilation(0.05f, -0.2f, -0.5f)), ModelTransform.of(0.3f, 74.9f, 2.4f, 0.0524f, -0.0175f, -1.5708f));
        add(m, "b45_bone5", "b48_bone14", ModelPartBuilder.create(), ModelTransform.of(0.9f, 0f, 0f, 0f, 0f, 1.1345f));
        add(m, "b48_bone14", "c248_bone14", ModelPartBuilder.create().uv(0, 439).cuboid(-76.3959f, -3.0565f, -4.0841f, 79, 8, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0f, 0f, 0f, 0f, -1.6406f));
        add(m, "b48_bone14", "c249_bone14", ModelPartBuilder.create().uv(288, 359).cuboid(-36.1027f, -5.8526f, -7.1841f, 56, 21, 1, new Dilation(0f, -0.1f, -0.5f)), ModelTransform.of(12.6f, 41f, 8.2f, 0.0873f, 0f, -1.6406f));
        add(m, "b48_bone14", "c250_bone14", ModelPartBuilder.create().uv(156, 485).cuboid(-70.0959f, -1.5565f, -2.0841f, 73, 6, 5, new Dilation(-0.15f, -0.25f, 0f)), ModelTransform.of(5.3f, 74.9f, -0.6f, 0.0069f, -0.113f, -1.6499f));
        add(m, "b45_bone5", "c237_bone5", ModelPartBuilder.create().uv(374, 421).cuboid(-76.3959f, -3.0565f, -4.0841f, 79, 8, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.9f, 0f, 0f, 0f, 0f, -1.6406f));
        add(m, "b45_bone5", "c238_bone5", ModelPartBuilder.create().uv(152, 285).cuboid(-45.1519f, -5.1578f, -4.0841f, 55, 24, 1, new Dilation(0f, -0.25f, -0.5f)), ModelTransform.of(-3.1f, 31f, 5f, 0f, 0.0175f, -1.2915f));
        add(m, "b45_bone5", "c239_bone5", ModelPartBuilder.create().uv(844, 471).cuboid(-70.0959f, -1.5565f, -2.0841f, 73, 6, 5, new Dilation(-0.15f, -0.25f, 0f)), ModelTransform.of(6.2f, 74.9f, -0.6f, 0f, -0.0524f, -1.4137f));
        add(m, "b45_bone5", "c240_bone5", ModelPartBuilder.create().uv(0, 164).cuboid(-70.0959f, -40.4565f, -2.0841f, 69, 44, 1, new Dilation(-0.15f, 0.2f, -0.5f)), ModelTransform.of(6.2f, 74.9f, 2.4f, -0.0574f, -0.0594f, -1.3437f));
        add(m, "b44_wing3", "c232_wing3", ModelPartBuilder.create().uv(0, 382).cuboid(-11.4993f, -5.3464f, -4.7341f, 123, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "b44_wing3", "c233_wing3", ModelPartBuilder.create().uv(296, 209).cuboid(-15.4993f, 3.6536f, 0.0659f, 127, 37, 1, new Dilation(0f, 0f, -0.5f)), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "b44_wing3", "c234_wing3", ModelPartBuilder.create().uv(808, 209).cuboid(-11.3959f, -16.0565f, 1.9159f, 21, 37, 1, new Dilation(0f, 0f, -0.5f)), ModelTransform.of(-16.5033f, 30.5101f, -4.95f, -0.3512f, -0.3836f, 0.6469f));
        add(m, "b44_wing3", "c235_wing3", ModelPartBuilder.create().uv(330, 455).cuboid(-10.3959f, -3.0565f, -2.0841f, 17, 8, 7, new Dilation(0f, 0f, 0f)), ModelTransform.of(109.9967f, -7.0899f, 3.85f, 0.7026f, -0.793f, -1.2293f));
        add(m, "b44_wing3", "c236_wing3", ModelPartBuilder.create().uv(844, 485).cuboid(-10.3959f, -2.0565f, 0.3159f, 9, 6, 4, new Dilation(-0.15f, -0.25f, -0.2f)), ModelTransform.of(116.0967f, -16.4899f, 10.35f, 0.5003f, -0.3803f, -0.9393f));
        add(m, "b42_left_wing", "c229_left_wing", ModelPartBuilder.create().uv(532, 382).cuboid(-13.0354f, 0.2543f, -2.8941f, 102, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2.6534f, -2.4111f, -4.4989f, 0.5461f, 0.4889f, -0.3867f));
        add(m, "b42_left_wing", "c230_left_wing", ModelPartBuilder.create().uv(90, 471).cuboid(-13.0354f, 1.7543f, -1.3942f, 56, 6, 7, new Dilation(0f, 0f, 0f)), ModelTransform.of(76.6466f, -41.7111f, -42.6989f, 0.6849f, -0.4592f, -1.0024f));
        add(m, "b0_dragon1", "b49_tail", ModelPartBuilder.create(), ModelTransform.of(2f, -41.7476f, 79.5041f, -0.1309f, 0.0046f, 0.0077f));
        add(m, "b49_tail", "b50_bone50", ModelPartBuilder.create(), ModelTransform.of(-2.3699f, 8.9462f, 62.4417f, 0f, 0f, 0f));
        add(m, "b50_bone50", "c251_bone50", ModelPartBuilder.create().uv(376, 285).cuboid(-5.9279f, -23.9647f, 5.0157f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0f, 0f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b50_bone50", "c252_bone50", ModelPartBuilder.create().uv(426, 455).cuboid(-1.9279f, -27.9647f, 7.0157f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0f, 0f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b49_tail", "b51_tail2", ModelPartBuilder.create(), ModelTransform.of(0.865f, 9.1601f, 65.7474f, 0f, 0f, 0f));
        add(m, "b51_tail2", "c253_tail2", ModelPartBuilder.create().uv(432, 285).cuboid(-5.9279f, -23.7902f, 15.0141f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -0.2139f, -3.3057f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b51_tail2", "c254_tail2", ModelPartBuilder.create().uv(458, 455).cuboid(-1.9279f, -27.7902f, 17.0141f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -0.2139f, -3.3057f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b49_tail", "b52_tail3", ModelPartBuilder.create(), ModelTransform.of(0.865f, 10.3346f, 89.7459f, 0f, 0f, 0f));
        add(m, "b52_tail3", "c255_tail3", ModelPartBuilder.create().uv(488, 285).cuboid(-5.9279f, -23.7911f, 25.0147f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.3884f, -27.3042f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b52_tail3", "c256_tail3", ModelPartBuilder.create().uv(490, 455).cuboid(-1.9279f, -27.7911f, 27.0147f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.3884f, -27.3042f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b49_tail", "b53_tail4", ModelPartBuilder.create(), ModelTransform.of(0.865f, 8.6753f, 99.6033f, 0f, 0f, 0f));
        add(m, "b53_tail4", "b54_tail5", ModelPartBuilder.create(), ModelTransform.of(0f, 1.9649f, 5.9829f, 0f, 0f, 0f));
        add(m, "b54_tail5", "b55_tail6", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 10f, 0f, 0f, 0f));
        add(m, "b55_tail6", "b56_tail7", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 14f, 0f, 0f, 0f));
        add(m, "b56_tail7", "b57_tail8", ModelPartBuilder.create(), ModelTransform.of(0f, -0.2093f, 10.0055f, 0f, 0f, 0f));
        add(m, "b57_tail8", "b58_tail9", ModelPartBuilder.create(), ModelTransform.of(0f, -0.0698f, 11.0006f, 0f, 0f, 0f));
        add(m, "b58_tail9", "b59_tail10", ModelPartBuilder.create(), ModelTransform.of(0f, 0.0873f, 9.0008f, 0f, 0f, 0f));
        add(m, "b59_tail10", "b60_tail11", ModelPartBuilder.create(), ModelTransform.of(0f, 0.1396f, 11.0024f, 0f, 0f, 0f));
        add(m, "b60_tail11", "b61_tail12", ModelPartBuilder.create(), ModelTransform.of(0f, 0.2617f, 9.0068f, 0f, 0f, 0f));
        add(m, "b61_tail12", "b62_tail13", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 24f, 0f, 0f, 0f));
        add(m, "b62_tail13", "b63_tail15", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, -1f, 0f, 0f, 0f));
        add(m, "b63_tail15", "b64_tail16", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 12f, 0f, 0f, 0f));
        add(m, "b64_tail16", "b65_tail17", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 12f, 0f, 0f, 0f));
        add(m, "b64_tail16", "c279_tail16", ModelPartBuilder.create().uv(168, 312).cuboid(-5.9279f, -23.0658f, 149.876f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.9034f, -152.1606f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b64_tail16", "c280_tail16", ModelPartBuilder.create().uv(874, 455).cuboid(-1.9279f, -27.0658f, 151.876f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.9034f, -152.1606f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b63_tail15", "c277_tail15", ModelPartBuilder.create().uv(112, 312).cuboid(-5.9279f, -23.0658f, 137.876f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.9034f, -140.1606f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b63_tail15", "c278_tail15", ModelPartBuilder.create().uv(842, 455).cuboid(-1.9279f, -27.0658f, 139.876f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.9034f, -140.1606f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b62_tail13", "b66_tail14", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "b66_tail14", "c281_tail14", ModelPartBuilder.create().uv(224, 312).cuboid(-5.9279f, -23.0658f, 126.876f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.9034f, -141.1606f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b66_tail14", "c282_tail14", ModelPartBuilder.create().uv(906, 455).cuboid(-1.9279f, -27.0658f, 128.876f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.9034f, -141.1606f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b62_tail13", "c275_tail13", ModelPartBuilder.create().uv(56, 312).cuboid(-5.9279f, -23.0658f, 126.876f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.9034f, -141.1606f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b62_tail13", "c276_tail13", ModelPartBuilder.create().uv(810, 455).cuboid(-1.9279f, -27.0658f, 128.876f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.9034f, -141.1606f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b61_tail12", "c273_tail12", ModelPartBuilder.create().uv(0, 312).cuboid(-5.9279f, -23.0658f, 114.876f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.9034f, -117.1606f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b61_tail12", "c274_tail12", ModelPartBuilder.create().uv(778, 455).cuboid(-1.9279f, -27.0658f, 116.876f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.9034f, -117.1606f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b60_tail11", "c271_tail11", ModelPartBuilder.create().uv(936, 285).cuboid(-5.9279f, -23.2752f, 104.8705f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.6417f, -108.1537f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b60_tail11", "c272_tail11", ModelPartBuilder.create().uv(746, 455).cuboid(-1.9279f, -27.2752f, 106.8705f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.6417f, -108.1537f, 0.3927f, -0.0034f, 0.0007f));
    }

    private static void p4(Map<String, ModelPartData> m) {
        add(m, "b59_tail10", "c269_tail10", ModelPartBuilder.create().uv(880, 285).cuboid(-5.9279f, -23.5369f, 94.8637f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.5021f, -97.1513f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b59_tail10", "c270_tail10", ModelPartBuilder.create().uv(714, 455).cuboid(-1.9279f, -27.5369f, 96.8637f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.5021f, -97.1513f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b58_tail9", "c267_tail9", ModelPartBuilder.create().uv(824, 285).cuboid(-5.9279f, -23.6764f, 84.8612f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.4148f, -88.1505f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b58_tail9", "c268_tail9", ModelPartBuilder.create().uv(682, 455).cuboid(-1.9279f, -27.6764f, 86.8612f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.4148f, -88.1505f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b57_tail8", "c265_tail8", ModelPartBuilder.create().uv(768, 285).cuboid(-5.9279f, -23.7637f, 74.8605f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.4847f, -77.1499f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b57_tail8", "c266_tail8", ModelPartBuilder.create().uv(650, 455).cuboid(-1.9279f, -27.7637f, 76.8605f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.4847f, -77.1499f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b56_tail7", "c263_tail7", ModelPartBuilder.create().uv(712, 285).cuboid(-5.9279f, -23.6939f, 64.8599f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.694f, -67.1444f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b56_tail7", "c264_tail7", ModelPartBuilder.create().uv(618, 455).cuboid(-1.9279f, -27.6939f, 66.8599f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.694f, -67.1444f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b55_tail6", "c261_tail6", ModelPartBuilder.create().uv(656, 285).cuboid(-5.9279f, -23.4846f, 54.8544f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.694f, -53.1444f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b55_tail6", "c262_tail6", ModelPartBuilder.create().uv(586, 455).cuboid(-1.9279f, -27.4846f, 56.8544f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.694f, -53.1444f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b54_tail5", "c259_tail5", ModelPartBuilder.create().uv(600, 285).cuboid(-5.9279f, -23.4846f, 44.8544f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.694f, -43.1444f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b54_tail5", "c260_tail5", ModelPartBuilder.create().uv(554, 455).cuboid(-1.9279f, -27.4846f, 46.8544f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, -1.694f, -43.1444f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b53_tail4", "c257_tail4", ModelPartBuilder.create().uv(544, 285).cuboid(-5.9279f, -23.4846f, 34.8544f, 16, 12, 12, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, 0.271f, -37.1616f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b53_tail4", "c258_tail4", ModelPartBuilder.create().uv(522, 455).cuboid(-1.9279f, -27.4846f, 36.8544f, 8, 6, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-3.235f, 0.271f, -37.1616f, 0.3927f, -0.0034f, 0.0007f));
        add(m, "b49_tail", "b67_bone4", ModelPartBuilder.create(), ModelTransform.of(-0.2144f, 1.2939f, 4.5992f, 0.0873f, 0f, 0f));
        add(m, "b67_bone4", "b68_bone3", ModelPartBuilder.create(), ModelTransform.of(0f, 8.1f, 41f, 0.2182f, 0f, 0f));
        add(m, "b68_bone3", "c285_bone3", ModelPartBuilder.create().uv(380, 252).cuboid(-4f, -5.4338f, -7.152f, 8, 14, 14, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -20.8f, -6.2f, -0.1309f, 0f, 0f));
        add(m, "b68_bone3", "c286_bone3", ModelPartBuilder.create().uv(860, 0).cuboid(-12f, -9.4338f, -23.152f, 23, 17, 43, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -13.3f, 0f, -0.0873f, 0f, 0f));
        add(m, "b68_bone3", "c287_bone3", ModelPartBuilder.create().uv(424, 252).cuboid(-4f, -3.4338f, -7.152f, 8, 14, 14, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -21.3f, 11f, -0.0698f, 0f, 0f));
        add(m, "b67_bone4", "c283_bone4", ModelPartBuilder.create().uv(108, 285).cuboid(-4f, -15.4338f, 2.848f, 8, 12, 14, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, -1.9611f, -6.8829f, 0.1309f, 0f, 0f));
        add(m, "b67_bone4", "c284_bone4", ModelPartBuilder.create().uv(0, 107).cuboid(-20f, -15.4337f, -16.152f, 40, 25, 32, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 1.7389f, 5.2171f, 0.1745f, 0f, 0f));
        add(m, "b0_dragon1", "b69_bone29", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "", "b70_Front_leg2", ModelPartBuilder.create(), ModelTransform.of(-38.4f, -21.227f, 18.4041f, 0.87f, -0.0287f, 0.1253f));
        add(m, "", "b71_rearleg3", ModelPartBuilder.create(), ModelTransform.of(-38.2f, -9.227f, 129.4041f, -1.7463f, 0.1031f, -0.0182f));
        add(m, "b71_rearleg3", "b72_rearlegtip3", ModelPartBuilder.create(), ModelTransform.of(0f, 27.0152f, 0.8263f, 2.3562f, 0f, 0f));
        add(m, "b72_rearlegtip3", "b73_leg_2kansetu2", ModelPartBuilder.create(), ModelTransform.of(-1f, 7.4337f, -3.848f, 0.1573f, 0.0517f, 0.0082f));
        add(m, "b73_leg_2kansetu2", "c289_leg_2kansetu2", ModelPartBuilder.create().uv(762, 107).cuboid(-7.0584f, -6.0319f, -10.8054f, 17, 34, 14, new Dilation(0f, 0f, -0.2f)), ModelTransform.of(-2f, -6.7f, 32.3f, 0.2443f, 0f, 0f));
        add(m, "b73_leg_2kansetu2", "c290_leg_2kansetu2", ModelPartBuilder.create().uv(0, 252).cuboid(-6.0288f, -1.3174f, -4.8082f, 15, 20, 13, new Dilation(-0.05f, 0.05f, -0.05f)), ModelTransform.of(-1.9f, 12.7f, 25.5f, -1.3614f, 0f, 0f));
        add(m, "b73_leg_2kansetu2", "c291_leg_2kansetu2", ModelPartBuilder.create().uv(468, 252).cuboid(-3.9288f, -1.3174f, -1.8082f, 11, 20, 8, new Dilation(0f, 0.05f, 0f)), ModelTransform.of(-2.6f, 15.9f, 10f, -1.2583f, 0.0242f, -0.1375f));
        add(m, "b71_rearleg3", "b74_bone16", ModelPartBuilder.create(), ModelTransform.of(-1.1f, 11.1f, 26.2f, 0.0037f, -0.0697f, 0.1919f));
        add(m, "b74_bone16", "b75_bone17", ModelPartBuilder.create(), ModelTransform.of(1.1f, 21.9337f, -4.548f, -2.5855f, -0.0017f, -0.3664f));
        add(m, "b75_bone17", "b76_bone18", ModelPartBuilder.create(), ModelTransform.of(0.6f, 8.1662f, -17.652f, 0.0615f, -0.0688f, -0.2303f));
        add(m, "b76_bone18", "c293_bone18", ModelPartBuilder.create().uv(994, 455).cuboid(-3.9743f, -7.7075f, 0.7543f, 5, 10, 4, new Dilation(-0.15f, -0.2f, -0.1f)), ModelTransform.of(0f, 0f, 0f, -0.4067f, -0.1937f, -0.1926f));
        add(m, "b76_bone18", "c294_bone18", ModelPartBuilder.create().uv(396, 471).cuboid(-3.3743f, -7.7075f, 1.5543f, 4, 10, 2, new Dilation(-0.2f, -0.2f, 0.25f)), ModelTransform.of(-0.4f, -1.4f, 0f, -0.4067f, -0.1937f, -0.1926f));
        add(m, "b76_bone18", "c295_bone18", ModelPartBuilder.create().uv(468, 471).cuboid(-2.6743f, -7.7075f, 2.1543f, 2, 10, 2, new Dilation(0.05f, -0.2f, -0.05f)), ModelTransform.of(-1.1f, -4.9f, 1.3f, -0.3368f, -0.1937f, -0.1926f));
        add(m, "b75_bone17", "b77_bone20", ModelPartBuilder.create(), ModelTransform.of(8.2564f, 4.927f, -14.7258f, 0.0349f, 0f, 0f));
        add(m, "b77_bone20", "c296_bone20", ModelPartBuilder.create().uv(0, 471).cuboid(-3.9743f, -7.7075f, 0.7543f, 5, 10, 4, new Dilation(-0.15f, -0.2f, -0.1f)), ModelTransform.of(0f, 0f, 0f, -0.3023f, -0.1726f, -0.2116f));
        add(m, "b77_bone20", "c297_bone20", ModelPartBuilder.create().uv(408, 471).cuboid(-3.3743f, -7.7075f, 1.5543f, 4, 10, 2, new Dilation(-0.2f, -0.2f, 0.25f)), ModelTransform.of(-0.4f, -1.4f, 0f, -0.3023f, -0.1726f, -0.2116f));
        add(m, "b77_bone20", "c298_bone20", ModelPartBuilder.create().uv(476, 471).cuboid(-2.6743f, -7.7075f, 2.1543f, 2, 10, 2, new Dilation(0.05f, -0.2f, -0.05f)), ModelTransform.of(-1.1f, -4.9f, 0.9f, -0.2325f, -0.1726f, -0.2116f));
        add(m, "b75_bone17", "b78_bone19", ModelPartBuilder.create(), ModelTransform.of(3.7564f, 4.827f, -15.4258f, 0.0006f, -0.0349f, -0.0175f));
        add(m, "b78_bone19", "c299_bone19", ModelPartBuilder.create().uv(18, 471).cuboid(-3.9743f, -7.7075f, 0.7543f, 5, 10, 4, new Dilation(-0.15f, -0.2f, -0.1f)), ModelTransform.of(0f, 0f, 0f, -0.3023f, -0.1726f, -0.3512f));
        add(m, "b78_bone19", "c300_bone19", ModelPartBuilder.create().uv(420, 471).cuboid(-3.3743f, -7.7075f, 1.5543f, 4, 10, 2, new Dilation(-0.2f, -0.2f, 0.25f)), ModelTransform.of(-0.7f, -1.4f, 0f, -0.3023f, -0.1726f, -0.3512f));
        add(m, "b78_bone19", "c301_bone19", ModelPartBuilder.create().uv(484, 471).cuboid(-2.6743f, -7.7075f, 2.1543f, 2, 10, 2, new Dilation(0.05f, -0.2f, -0.05f)), ModelTransform.of(-1.7f, -3.9f, 0.9f, -0.2325f, -0.1726f, -0.3512f));
        add(m, "b74_bone16", "c292_bone16", ModelPartBuilder.create().uv(0, 402).cuboid(-4.9f, -4.4337f, -6.852f, 13, 6, 13, new Dilation(0.05f, 0f, -0.15f)), ModelTransform.of(-2.8f, 1.9337f, 3.452f, 1.8064f, 0f, 0f));
        add(m, "b71_rearleg3", "c288_rearleg3", ModelPartBuilder.create().uv(144, 107).cuboid(-12.3419f, -20.2859f, -14.8019f, 22, 34, 22, new Dilation(0.2f, 0f, -0.2f)), ModelTransform.of(-1f, 11.1489f, -23.5217f, 1.2741f, 0f, 0f));
        add(m, "", "b79_rearleg2", ModelPartBuilder.create(), ModelTransform.of(38.2f, -9.227f, 129.4041f, -1.7463f, -0.1031f, 0.0182f));
        add(m, "b79_rearleg2", "b80_rearlegtip2", ModelPartBuilder.create(), ModelTransform.of(0f, 27.0152f, 0.8263f, 2.3562f, 0f, 0f));
        add(m, "b80_rearlegtip2", "b81_leg_2kansetu3", ModelPartBuilder.create(), ModelTransform.of(1f, 7.4337f, -3.848f, 0.1573f, -0.0517f, -0.0082f));
        add(m, "b81_leg_2kansetu3", "c303_leg_2kansetu3", ModelPartBuilder.create().uv(824, 107).cuboid(-9.9416f, -6.0319f, -10.8054f, 17, 34, 14, new Dilation(0f, 0f, -0.2f)), ModelTransform.of(2f, -6.7f, 32.3f, 0.2443f, 0f, 0f));
        add(m, "b81_leg_2kansetu3", "c304_leg_2kansetu3", ModelPartBuilder.create().uv(56, 252).cuboid(-8.8712f, -1.3174f, -4.8082f, 15, 20, 13, new Dilation(-0.05f, 0.05f, -0.05f)), ModelTransform.of(1.9f, 12.7f, 25.5f, -1.3614f, 0f, 0f));
        add(m, "b81_leg_2kansetu3", "c305_leg_2kansetu3", ModelPartBuilder.create().uv(506, 252).cuboid(-7.0712f, -1.3174f, -1.8082f, 11, 20, 8, new Dilation(0f, 0.05f, 0f)), ModelTransform.of(2.6f, 15.9f, 10f, -1.2583f, -0.0242f, 0.1375f));
        add(m, "b79_rearleg2", "b82_bone21", ModelPartBuilder.create(), ModelTransform.of(1.1f, 11.1f, 26.2f, 0.0037f, 0.0697f, -0.1919f));
        add(m, "b82_bone21", "b83_bone22", ModelPartBuilder.create(), ModelTransform.of(-1.1f, 21.9337f, -4.548f, -2.5855f, 0.0017f, 0.3664f));
        add(m, "b83_bone22", "b84_bone23", ModelPartBuilder.create(), ModelTransform.of(-0.6f, 8.1662f, -17.652f, 0.0615f, 0.0688f, 0.2303f));
        add(m, "b84_bone23", "c307_bone23", ModelPartBuilder.create().uv(36, 471).cuboid(-0.7257f, -7.7075f, 0.7543f, 5, 10, 4, new Dilation(-0.15f, -0.2f, -0.1f)), ModelTransform.of(0f, 0f, 0f, -0.4067f, 0.1937f, 0.1926f));
        add(m, "b84_bone23", "c308_bone23", ModelPartBuilder.create().uv(432, 471).cuboid(-0.2257f, -7.7075f, 1.5543f, 4, 10, 2, new Dilation(-0.2f, -0.2f, 0.25f)), ModelTransform.of(0.4f, -1.4f, 0f, -0.4067f, 0.1937f, 0.1926f));
        add(m, "b84_bone23", "c309_bone23", ModelPartBuilder.create().uv(492, 471).cuboid(0.5743f, -7.7075f, 2.1543f, 2, 10, 2, new Dilation(0.05f, -0.2f, -0.05f)), ModelTransform.of(1.1f, -4.9f, 1.3f, -0.3368f, 0.1937f, 0.1926f));
        add(m, "b83_bone22", "b85_bone24", ModelPartBuilder.create(), ModelTransform.of(-8.2564f, 4.927f, -14.7258f, 0.0349f, 0f, 0f));
        add(m, "b85_bone24", "c310_bone24", ModelPartBuilder.create().uv(54, 471).cuboid(-0.7257f, -7.7075f, 0.7543f, 5, 10, 4, new Dilation(-0.15f, -0.2f, -0.1f)), ModelTransform.of(0f, 0f, 0f, -0.3023f, 0.1726f, 0.2116f));
        add(m, "b85_bone24", "c311_bone24", ModelPartBuilder.create().uv(444, 471).cuboid(-0.2257f, -7.7075f, 1.5543f, 4, 10, 2, new Dilation(-0.2f, -0.2f, 0.25f)), ModelTransform.of(0.4f, -1.4f, 0f, -0.3023f, 0.1726f, 0.2116f));
    }

    private static void p5(Map<String, ModelPartData> m) {
        add(m, "b85_bone24", "c312_bone24", ModelPartBuilder.create().uv(500, 471).cuboid(0.5743f, -7.7075f, 2.1543f, 2, 10, 2, new Dilation(0.05f, -0.2f, -0.05f)), ModelTransform.of(1.1f, -4.9f, 0.9f, -0.2325f, 0.1726f, 0.2116f));
        add(m, "b83_bone22", "b86_bone25", ModelPartBuilder.create(), ModelTransform.of(-3.7564f, 4.827f, -15.4258f, 0.0006f, 0.0349f, 0.0175f));
        add(m, "b86_bone25", "c313_bone25", ModelPartBuilder.create().uv(72, 471).cuboid(-0.7257f, -7.7075f, 0.7543f, 5, 10, 4, new Dilation(-0.15f, -0.2f, -0.1f)), ModelTransform.of(0f, 0f, 0f, -0.3023f, 0.1726f, 0.3512f));
        add(m, "b86_bone25", "c314_bone25", ModelPartBuilder.create().uv(456, 471).cuboid(-0.2257f, -7.7075f, 1.5543f, 4, 10, 2, new Dilation(-0.2f, -0.2f, 0.25f)), ModelTransform.of(0.7f, -1.4f, 0f, -0.3023f, 0.1726f, 0.3512f));
        add(m, "b86_bone25", "c315_bone25", ModelPartBuilder.create().uv(508, 471).cuboid(0.5743f, -7.7075f, 2.1543f, 2, 10, 2, new Dilation(0.05f, -0.2f, -0.05f)), ModelTransform.of(1.7f, -3.9f, 0.9f, -0.2325f, 0.1726f, 0.3512f));
        add(m, "b82_bone21", "c306_bone21", ModelPartBuilder.create().uv(52, 402).cuboid(-8.2f, -4.4337f, -6.852f, 13, 6, 13, new Dilation(0.05f, 0f, -0.15f)), ModelTransform.of(2.8f, 1.9337f, 3.452f, 1.8064f, 0f, 0f));
        add(m, "b79_rearleg2", "c302_rearleg2", ModelPartBuilder.create().uv(232, 107).cuboid(-10.0581f, -20.2859f, -14.8019f, 22, 34, 22, new Dilation(0.2f, 0f, -0.2f)), ModelTransform.of(1f, 11.1489f, -23.5217f, 1.2741f, 0f, 0f));
        add(m, "", "b87_Front_leg3", ModelPartBuilder.create(), ModelTransform.of(38.4f, -21.227f, 18.4041f, 0.87f, 0.0287f, -0.1253f));
        add(m, "", "b88_right_wing", ModelPartBuilder.create(), ModelTransform.of(-29.4f, -41.2612f, 33.7883f, -0.3667f, 0.6591f, -0.2224f));
        add(m, "b88_right_wing", "b89_wing2", ModelPartBuilder.create(), ModelTransform.of(-77.4595f, -22.2198f, -47.1535f, -3.0631f, -0.4401f, -0.9573f));
        add(m, "b89_wing2", "c318_wing2", ModelPartBuilder.create().uv(96, 0).cuboid(-9.6041f, -74.0565f, 1.9159f, 47, 106, 1, new Dilation(0f, 0.25f, -0.5f)), ModelTransform.of(21.8033f, -5.8899f, -10.75f, 0.4115f, 0.4961f, 0.6336f));
        add(m, "b88_right_wing", "b90_wing4", ModelPartBuilder.create(), ModelTransform.of(-77.4595f, -22.2198f, -47.1535f, -3.0631f, -0.4401f, -0.9573f));
        add(m, "b90_wing4", "b91_bone15", ModelPartBuilder.create(), ModelTransform.of(-105.0967f, -1.2899f, 0.15f, 0f, 0f, 0f));
        add(m, "b91_bone15", "b92_bone26", ModelPartBuilder.create(), ModelTransform.of(-0.9f, 0f, 0f, 0f, 0f, -0.7592f));
        add(m, "b92_bone26", "c328_bone26", ModelPartBuilder.create().uv(348, 439).cuboid(-2.6041f, -3.0565f, -4.0841f, 79, 8, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 1.6406f));
        add(m, "b92_bone26", "c329_bone26", ModelPartBuilder.create().uv(468, 485).cuboid(-2.6041f, -1.5565f, -2.0841f, 73, 6, 5, new Dilation(-0.15f, -0.25f, 0f)), ModelTransform.of(-5.3f, 74.9f, -0.6f, 0f, 0.0524f, 1.5184f));
        add(m, "b92_bone26", "c330_bone26", ModelPartBuilder.create().uv(798, 164).cuboid(-2.6041f, -43.5565f, -2.0841f, 73, 42, 1, new Dilation(-0.15f, -0.25f, -0.5f)), ModelTransform.of(-5.3f, 76.9f, 4.5f, 0.1313f, 0.0956f, 1.5242f));
        add(m, "b91_bone15", "b93_bone27", ModelPartBuilder.create(), ModelTransform.of(-0.9f, 0f, 0f, 0f, 0f, -0.4189f));
        add(m, "b93_bone27", "c331_bone27", ModelPartBuilder.create().uv(522, 439).cuboid(-2.6041f, -3.0565f, -4.0841f, 79, 8, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 1.6406f));
        add(m, "b93_bone27", "c332_bone27", ModelPartBuilder.create().uv(256, 402).cuboid(-7.2965f, -8.1952f, -4.0841f, 56, 17, 1, new Dilation(0f, 0f, -0.5f)), ModelTransform.of(0f, 28f, 6.1f, 0f, 0f, 1.4224f));
        add(m, "b93_bone27", "c333_bone27", ModelPartBuilder.create().uv(680, 471).cuboid(-2.6041f, -1.5565f, -2.0841f, 77, 6, 5, new Dilation(0.05f, -0.25f, 0f)), ModelTransform.of(-5.3f, 74.9f, -0.6f, 0f, 0.0175f, 1.5708f));
        add(m, "b93_bone27", "c334_bone27", ModelPartBuilder.create().uv(606, 107).cuboid(-2.6041f, -44.6565f, -2.0841f, 77, 49, 1, new Dilation(0.05f, -0.2f, -0.5f)), ModelTransform.of(-0.3f, 74.9f, 2.4f, 0.0524f, 0.0175f, 1.5708f));
        add(m, "b91_bone15", "b94_bone28", ModelPartBuilder.create(), ModelTransform.of(-0.9f, 0f, 0f, 0f, 0f, -1.1345f));
        add(m, "b94_bone28", "c335_bone28", ModelPartBuilder.create().uv(696, 439).cuboid(-2.6041f, -3.0565f, -4.0841f, 79, 8, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 1.6406f));
        add(m, "b94_bone28", "c336_bone28", ModelPartBuilder.create().uv(402, 359).cuboid(-19.8973f, -5.8526f, -7.1841f, 56, 21, 1, new Dilation(0f, -0.1f, -0.5f)), ModelTransform.of(-12.6f, 41f, 8.2f, 0.0873f, 0f, 1.6406f));
        add(m, "b94_bone28", "c337_bone28", ModelPartBuilder.create().uv(624, 485).cuboid(-2.6041f, -1.5565f, -2.0841f, 73, 6, 5, new Dilation(-0.15f, -0.25f, 0f)), ModelTransform.of(-5.3f, 74.9f, -0.6f, 0.0069f, 0.113f, 1.6499f));
        add(m, "b91_bone15", "c324_bone15", ModelPartBuilder.create().uv(174, 439).cuboid(-2.6041f, -3.0565f, -4.0841f, 79, 8, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.9f, 0f, 0f, 0f, 0f, 1.6406f));
        add(m, "b91_bone15", "c325_bone15", ModelPartBuilder.create().uv(264, 285).cuboid(-9.8481f, -5.1578f, -4.0841f, 55, 24, 1, new Dilation(0f, -0.25f, -0.5f)), ModelTransform.of(3.1f, 31f, 5f, 0f, -0.0175f, 1.2915f));
        add(m, "b91_bone15", "c326_bone15", ModelPartBuilder.create().uv(312, 485).cuboid(-2.6041f, -1.5565f, -2.0841f, 73, 6, 5, new Dilation(-0.15f, -0.25f, 0f)), ModelTransform.of(-6.2f, 74.9f, -0.6f, 0f, 0.0524f, 1.4137f));
        add(m, "b91_bone15", "c327_bone15", ModelPartBuilder.create().uv(140, 164).cuboid(1.3959f, -40.4565f, -2.0841f, 69, 44, 1, new Dilation(-0.15f, 0.2f, -0.5f)), ModelTransform.of(-6.2f, 74.9f, 2.4f, -0.0574f, 0.0594f, 1.3437f));
        add(m, "b90_wing4", "c319_wing4", ModelPartBuilder.create().uv(266, 382).cuboid(-111.5007f, -5.3464f, -4.7341f, 123, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "b90_wing4", "c320_wing4", ModelPartBuilder.create().uv(552, 209).cuboid(-111.5007f, 3.6536f, 0.0659f, 127, 37, 1, new Dilation(0f, 0f, -0.5f)), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "b90_wing4", "c321_wing4", ModelPartBuilder.create().uv(852, 209).cuboid(-9.6041f, -16.0565f, 1.9159f, 21, 37, 1, new Dilation(0f, 0f, -0.5f)), ModelTransform.of(15.7033f, 29.4101f, -4.95f, -0.3512f, 0.3836f, -0.6469f));
        add(m, "b90_wing4", "c322_wing4", ModelPartBuilder.create().uv(378, 455).cuboid(-6.6041f, -3.0565f, -2.0841f, 17, 8, 7, new Dilation(0f, 0f, 0f)), ModelTransform.of(-111.0967f, -6.6899f, 3.85f, 0.4977f, 0.7946f, 1.1858f));
        add(m, "b90_wing4", "c323_wing4", ModelPartBuilder.create().uv(870, 485).cuboid(1.6959f, -2.0565f, 0.3159f, 9, 6, 4, new Dilation(-0.15f, -0.25f, -0.2f)), ModelTransform.of(-116.6967f, -15.7899f, 11.45f, 0.4156f, 0.4906f, 1.0212f));
        add(m, "b88_right_wing", "b95_bone49", ModelPartBuilder.create(), ModelTransform.of(2.6534f, -2.4111f, -4.4989f, 0f, 0f, 0f));
        add(m, "b88_right_wing", "c316_right_wing", ModelPartBuilder.create().uv(756, 382).cuboid(-88.9646f, 0.2543f, -2.8941f, 102, 10, 10, new Dilation(0f, 0f, 0f)), ModelTransform.of(2.6534f, -2.4111f, -4.4989f, 0.5461f, -0.4889f, 0.3867f));
        add(m, "b88_right_wing", "c317_right_wing", ModelPartBuilder.create().uv(216, 471).cuboid(-42.9646f, 1.7543f, -1.3941f, 56, 6, 7, new Dilation(0f, 0f, 0f)), ModelTransform.of(-76.6466f, -41.7111f, -42.6989f, 0.6849f, 0.4592f, 1.0024f));
    }

    private static float sin(float v) { return (float) Math.sin(v); }
    private static float cos(float v) { return (float) Math.cos(v); }

    private static float snap(float x) { return SNAP > 0f ? Math.signum(x) * (float) Math.sqrt(Math.abs(x)) : x; }

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
        boolean sit = s.sitting;
        float death = s.death;
        if (death > 0f) { fly = false; sit = false; amp *= 1f - death; }
        if (fly) sit = false;
        float moving = (fly || sit || death > 0f) ? 0f : amp;
        float alive = 1f - death;
        // ---- cuello, cabeza, mandibula
        for (int i = 0; i < NECK.length; i++) {
            bones[NECK[i]].pitch += sin(t * 0.05f - i * 0.5f) * 0.03f + (fly ? FLY_NECK : 0f) + (breath ? -0.05f : 0f)
                    + sin(2f * f) * 0.03f * moving + (sit ? SIT_NECK / NECK.length : 0f) + DEATH_NECK / NECK.length * death;
            bones[NECK[i]].yaw += yawLook * 0.12f;
        }
        if (HEAD >= 0) {
            bones[HEAD].pitch += pitchLook * 0.5f + sin(t * 0.09f) * 0.02f - (breath ? 0.3f : 0f) + sin(2f * f) * 0.04f * moving
                    + (sit ? -0.1f : 0f) + 0.4f * death;
            bones[HEAD].yaw += yawLook * 0.4f - sin(f * 1.5f) * HEAD_SWAY * moving;
        }
        if (JAW >= 0) {
            bones[JAW].pitch += (breath ? 0.8f : 0.05f + (sin(t * 0.09f) + 1f) * 0.03f) + Math.max(0f, sin(f * 3f)) * JAW_CLACK * moving + 0.5f * death;
        }
        // ---- cola / cuerpo de serpiente
        for (int j = 0; j < TAIL.length; j++) {
            float yaw = (sin(t * 0.06f - j * 0.55f) * (0.05f + 0.01f * j) + cos(f) * 0.05f * amp) * TAIL_AMP * alive;
            yaw += sin(f * 1.5f - j * 0.7f) * WAVE * moving;
            float pit = fly ? sin(t * FLAP_SPEED - j * 0.5f) * 0.05f - (j == 0 ? 0.05f * sin(t * FLAP_SPEED) : 0f) : 0f;
            if (sit) yaw += SIT_COIL;
            pit += DEATH_TAIL * death + sin(f * 1.5f - j * 0.7f + 1.5f) * WAVEP * moving;
            bones[TAIL[j]].yaw += yaw;
            bones[TAIL[j]].pitch += pit;
        }
        float hk = 1f + 1.5f * amp;
        for (int j = 0; j < HAIR.length; j++) {
            bones[HAIR[j]].roll += sin(t * 0.15f + j * 1.7f) * 0.12f * hk;
            bones[HAIR[j]].pitch += cos(t * 0.13f + j) * 0.1f * hk + 0.7f * death;
        }
        // ---- alas
        float fold = fly ? 0f : (sit ? 1f : FOLD);
        float flap = fly ? snap(sin(t * FLAP_SPEED)) : sin(t * 0.1f) * 0.04f;
        float lag = snap(sin(t * FLAP_SPEED - 0.9f));
        for (int w = 0; w < WING.length; w++) {
            float sg = WSIGN[w];
            ModelPart root = bones[WING[w][0]];
            root.roll += -sg * flap * FLAP + sg * FOLD_ROLL * fold - sg * sin(2f * f) * 0.05f * moving + sg * DEATH_WING * death;
            root.yaw += -sg * FOLD_YAW * fold - (fly ? sg * 0.12f * flap : 0f);
            for (int k = 1; k < WING[w].length; k++) {
                ModelPart tip = bones[WING[w][k]];
                tip.yaw += -sg * FOLD_TIP * fold;
                tip.roll += -sg * (fly ? lag * 0.45f : flap * 0.35f) + sg * DEATH_WING * 0.5f * death;
            }
        }
        // ---- patas
        for (int l = 0; l < LEG.length; l++) {
            float a = f + LPHASE[l] * 3.14159f;
            float sgn = (l % 2 == 0) ? 1f : -1f;
            for (int k = 0; k < LEG[l].length; k++) {
                int kk = Math.min(k, 2);
                float dp;
                if (k == 0) dp = sin(a) * LEG_AMP * moving;
                else if (k == 1) dp = Math.max(0f, sin(a + 1f)) * KNEE * moving;
                else dp = -Math.max(0f, sin(a + 1f)) * KNEE * 0.5f * moving;
                if (fly) dp += FLY_LEG[kk];
                if (sit) dp += SIT_LEG[kk];
                dp += sgn * DEATH_LEG[kk] * death;
                bones[LEG[l][k]].pitch += dp;
            }
        }
        // ---- vibracion de huesos (solo esqueleto)
        if (JITTER > 0f) {
            for (int i = 0; i < bones.length; i++) {
                bones[i].pitch += sin(t * 2.7f + i * 1.9f) * JITTER * (1f + moving);
                bones[i].roll += cos(t * 2.3f + i * 1.3f) * JITTER * 0.7f;
            }
        }
        // ---- desplazamiento vertical de todo el modelo (subida al andar, agacharse, flotar al volar, hundirse al morir)
        float dy = -Math.abs(cos(f)) * BOB * moving;
        if (sit) dy += CROUCH;
        if (fly) dy += sin(t * 0.2f) * FLY_BOB;
        dy += DEATH_DY * death;
        for (int i = 0; i < ROOTS.length; i++) roots[i].originY = ROOT_Y[i] + dy;
    }
}
