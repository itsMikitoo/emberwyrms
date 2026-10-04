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
 * GENERADO por tools/rig_emit.py a partir de un modelo de Blockbench (Skeleton Dragon (Sketchfab)).
 * Geometria y textura convertidas; los movimientos (cuello, cola, alas, patas...) son propios del mod.
 */
public class StormDragonModel extends EntityModel<AshwingRenderState> {
    private final ModelPart[] bones;
    private final ModelPart[] roots;
    private static final float[][] REST = {{-0.0873f, 0f, 0f}, {0f, 0f, 0f}, {0.2618f, 0f, 0f}, {-0.1745f, 0f, 0f}, {0.4363f, 0f, 0f}, {-0.3491f, 0f, 1.5708f}, {0.9599f, 0f, 0f}, {-0.8727f, 0.0873f, 0f}, {-0.3491f, 0f, -1.5708f}, {0.9599f, 0f, 0f}, {-0.8727f, -0.0873f, 0f}, {-0.5236f, 0f, 0f}, {1.5708f, 0f, 0f}, {-0.5236f, 0f, 0f}, {1.5708f, 0f, 0f}, {0.3491f, 0f, 0f}, {-0.7854f, 0f, 0f}, {-1.1345f, 0f, 0f}, {0.3491f, 0f, 0f}, {-0.7854f, 0f, 0f}, {-1.1345f, 0f, 0f}};
    private static final int HEAD = 0, JAW = 1;
    private static final int[] NECK = {2}, TAIL = {3, 4}, HAIR = {};
    private static final int[][] WING = {{5, 6, 7}, {8, 9, 10}};
    private static final float[] WSIGN = {1f, -1f};
    private static final int[][] LEG = {{11, 12}, {13, 14}, {15, 16, 17}, {18, 19, 20}};
    private static final float[] LPHASE = {0f, 1f, 1f, 0f};
    private static final float[] ROOT_Y = {24.0163f};
    private static final float[] SIT_LEG = {0.7f, -1f, 0.5f}, FLY_LEG = {0.8f, 0.6f, 0.3f}, DEATH_LEG = {0.8f, -1.1f, 0.4f};
    private static final float LEG_AMP = 1.1f, KNEE = 0.6f, BOB = 2f, CROUCH = 6f, FLY_BOB = 2f, DEATH_DY = 5f;
    private static final float FLY_NECK = 0.05f, SIT_NECK = -0.2f, DEATH_NECK = 0.9f, SIT_COIL = 0.3f, DEATH_TAIL = -0.4f, DEATH_WING = 1.1f;
    private static final float FLAP_SPEED = 0.32f, SNAP = 1f, JITTER = 0.012f, JAW_CLACK = 0.18f, WAVE = 0.04f, WAVEP = 0f, HEAD_SWAY = 0.2f;
    private static final float FOLD = 0.9f, FOLD_YAW = 0.8f, FOLD_TIP = 1.2f, FOLD_ROLL = 0.3f, FLAP = 0.8f, TAIL_AMP = 1f, LEG_AMP = 1.1f;

    public StormDragonModel(ModelPart root) {
        super(root);
        this.bones = new ModelPart[] {
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n79_neck").getChild("n112_head"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n79_neck").getChild("n112_head").getChild("n126_jaw"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n79_neck"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n164_hium").getChild("n202_tail1"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n164_hium").getChild("n202_tail1").getChild("n215_tail2"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n406_leftWing"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n406_leftWing").getChild("n409_leftRadiusulna2"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n406_leftWing").getChild("n409_leftRadiusulna2").getChild("n415_leftPhanlange1"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n437_rightWing"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n437_rightWing").getChild("n440_rightRadiusulna3"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n437_rightWing").getChild("n440_rightRadiusulna3").getChild("n446_rightPhanlange4"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n164_hium").getChild("n182_leftFemur"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n164_hium").getChild("n182_leftFemur").getChild("n186_leftTibia"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n164_hium").getChild("n340_rightFemur"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n164_hium").getChild("n340_rightFemur").getChild("n344_rightTibia"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n360_leftHumerus"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n360_leftHumerus").getChild("n367_leftRadiusulna"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n360_leftHumerus").getChild("n367_leftRadiusulna").getChild("n372_Foot1"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n383_rightHumerus"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n383_rightHumerus").getChild("n390_rightRadiusulna"),
            root.getChild("n0_x").getChild("n1_all").getChild("n2_body").getChild("n383_rightHumerus").getChild("n390_rightRadiusulna").getChild("n395_Foot2")
        };
        this.roots = new ModelPart[] {
            root.getChild("n0_x")
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
        p6(m);
        p7(m);
        p8(m);
        return TexturedModelData.of(data, 256, 256);
    }

    private static void add(Map<String, ModelPartData> m, String parent, String name, ModelPartBuilder b, ModelTransform t) {
        m.put(name, m.get(parent).addChild(name, b, t));
    }

    private static void p0(Map<String, ModelPartData> m) {
        add(m, "", "n0_x", ModelPartBuilder.create(), ModelTransform.of(0f, 24.0163f, 0f, 0f, 0f, 0f));
        add(m, "n0_x", "n1_all", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "n1_all", "n2_body", ModelPartBuilder.create(), ModelTransform.of(0f, -17f, -4f, 0f, 0f, 0f));
        add(m, "n2_body", "n3_body", ModelPartBuilder.create().uv(204, 54).cuboid(0f, -19f, -4f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n4_body", ModelPartBuilder.create().uv(216, 54).cuboid(0f, -19.75f, 0.5f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n5_body", ModelPartBuilder.create().uv(228, 54).cuboid(0f, -19.5f, 4.75f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n6_body", ModelPartBuilder.create().uv(240, 54).cuboid(0f, -18.25f, -8.25f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n7_body", ModelPartBuilder.create().uv(0, 59).cuboid(-0.25f, -18.75f, 9.25f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n8_body", ModelPartBuilder.create().uv(12, 59).cuboid(-0.5f, -18.75f, 13.25f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n9_body", ModelPartBuilder.create().uv(24, 59).cuboid(-0.5f, -18.75f, 17.75f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n10_body", ModelPartBuilder.create().uv(36, 59).cuboid(0f, -18f, -11.75f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n11_body", ModelPartBuilder.create().uv(48, 59).cuboid(-3f, -19f, -4f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n12_body", ModelPartBuilder.create().uv(60, 59).cuboid(-3f, -19.75f, 0.5f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n13_body", ModelPartBuilder.create().uv(72, 59).cuboid(-3f, -19.5f, 4.75f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n14_body", ModelPartBuilder.create().uv(84, 59).cuboid(-3f, -18.25f, -8.25f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n15_body", ModelPartBuilder.create().uv(96, 59).cuboid(-2.75f, -18.75f, 9.25f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n16_body", ModelPartBuilder.create().uv(108, 59).cuboid(-2.5f, -18.75f, 13.25f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n17_body", ModelPartBuilder.create().uv(120, 59).cuboid(-2.5f, -18.75f, 17.75f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n18_body", ModelPartBuilder.create().uv(132, 59).cuboid(-3f, -18f, -11.75f, 3, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n19_body", ModelPartBuilder.create().uv(0, 41).cuboid(-1.5f, -19.75f, -5f, 3, 4, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n20_body", ModelPartBuilder.create().uv(12, 41).cuboid(-1.5f, -20.5f, -0.5f, 3, 4, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n21_body", ModelPartBuilder.create().uv(24, 41).cuboid(-1.5f, -20.25f, 3.75f, 3, 4, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n22_body", ModelPartBuilder.create().uv(36, 41).cuboid(-1.5f, -19f, -9.25f, 3, 4, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n23_body", ModelPartBuilder.create().uv(48, 41).cuboid(-1.5f, -19.5f, 8.25f, 3, 4, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n24_body", ModelPartBuilder.create().uv(60, 41).cuboid(-1.5f, -19.5f, 12.25f, 3, 4, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n25_body", ModelPartBuilder.create().uv(72, 41).cuboid(-1.5f, -19.5f, 16.75f, 3, 4, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n26_body", ModelPartBuilder.create().uv(84, 41).cuboid(-1.5f, -18.75f, -12.75f, 3, 4, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n27_body", ModelPartBuilder.create().uv(164, 59).cuboid(-1f, -18.75f, -2.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n28_body", ModelPartBuilder.create().uv(172, 59).cuboid(-1f, -19.5f, 2f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n29_body", ModelPartBuilder.create().uv(180, 59).cuboid(-1f, -19.25f, 6.25f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n30_body", ModelPartBuilder.create().uv(188, 59).cuboid(-1f, -18f, -6.75f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n31_body", ModelPartBuilder.create().uv(196, 59).cuboid(-1f, -18.5f, 10.75f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n32_body", ModelPartBuilder.create().uv(204, 59).cuboid(-1f, -18.5f, 14.75f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n33_body", ModelPartBuilder.create().uv(212, 59).cuboid(-0.8f, -18.3f, 19.95f, 2, 2, 2, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n34_body", ModelPartBuilder.create().uv(220, 59).cuboid(-1f, -17.75f, -10.25f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n35_body", ModelPartBuilder.create().uv(62, 33).cuboid(-0.5f, -23.25f, -4.5f, 1, 5, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n36_body", ModelPartBuilder.create().uv(70, 33).cuboid(-0.5f, -24f, 0f, 1, 5, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n37_body", ModelPartBuilder.create().uv(78, 33).cuboid(-0.5f, -23.75f, 4.25f, 1, 5, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n38_body", ModelPartBuilder.create().uv(86, 33).cuboid(-0.5f, -22.5f, -8.75f, 1, 5, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n39_body", ModelPartBuilder.create().uv(138, 54).cuboid(-0.5f, -22.5f, 9f, 1, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n40_body", ModelPartBuilder.create().uv(144, 54).cuboid(-0.5f, -22f, 13f, 1, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n41_body", ModelPartBuilder.create().uv(150, 54).cuboid(-0.5f, -21.5f, 17.5f, 1, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n42_body", ModelPartBuilder.create().uv(156, 54).cuboid(-0.5f, -21f, -12f, 1, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n43_rib1", ModelPartBuilder.create(), ModelTransform.of(2.25f, 0.75f, -3.25f, 0f, -0.6109f, 0.6981f));
        add(m, "n43_rib1", "n44_rib1", ModelPartBuilder.create().uv(0, 77).cuboid(1.05f, -16.95f, -7.95f, 7, 1, 1, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(-2.25f, 16.25f, 7.25f, 0f, 0f, 0f));
        add(m, "n43_rib1", "n45_ribbone1", ModelPartBuilder.create(), ModelTransform.of(6f, -0.25f, 0f, 0f, -0.1745f, 1.1345f));
        add(m, "n45_ribbone1", "n46_ribbone1", ModelPartBuilder.create().uv(160, 77).cuboid(8.25f, -17f, -7.75f, 6, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-8.25f, 16.5f, 7.25f, 0f, 0f, 0f));
        add(m, "n2_body", "n47_rib7", ModelPartBuilder.create(), ModelTransform.of(-2.25f, 0.75f, -3.25f, 0f, 0.6109f, -0.6981f));
        add(m, "n47_rib7", "n48_rib7", ModelPartBuilder.create().uv(16, 77).cuboid(-8.45f, -16.95f, -7.95f, 7, 1, 1, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(2.25f, 16.25f, 7.25f, 0f, 0f, 0f));
        add(m, "n47_rib7", "n49_ribbone5", ModelPartBuilder.create(), ModelTransform.of(-6f, -0.25f, 0f, 0f, 0.1745f, -1.1345f));
        add(m, "n49_ribbone5", "n50_ribbone5", ModelPartBuilder.create().uv(174, 77).cuboid(-14.25f, -17f, -7.75f, 6, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(8.25f, 16.5f, 7.25f, 0f, 0f, 0f));
        add(m, "n2_body", "n51_rib2", ModelPartBuilder.create(), ModelTransform.of(2f, 0f, 0.25f, 0f, -0.5585f, 0.6109f));
        add(m, "n51_rib2", "n52_rib2", ModelPartBuilder.create().uv(214, 74).cuboid(0.8f, -17.7f, -4.45f, 8, 1, 1, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(-2f, 17f, 3.75f, 0f, 0f, 0f));
        add(m, "n51_rib2", "n53_ribbone2", ModelPartBuilder.create(), ModelTransform.of(6.75f, 0f, 0f, 0f, -0.2618f, 1.309f));
        add(m, "n53_ribbone2", "n54_ribbone2", ModelPartBuilder.create().uv(32, 77).cuboid(8.75f, -17.5f, -4.25f, 7, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-8.75f, 17f, 3.75f, 0f, 0f, 0f));
        add(m, "n2_body", "n55_rib8", ModelPartBuilder.create(), ModelTransform.of(-2f, 0f, 0.25f, 0f, 0.5585f, -0.6109f));
        add(m, "n55_rib8", "n56_rib8", ModelPartBuilder.create().uv(232, 74).cuboid(-9.2f, -17.7f, -4.45f, 8, 1, 1, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(2f, 17f, 3.75f, 0f, 0f, 0f));
        add(m, "n55_rib8", "n57_ribbone6", ModelPartBuilder.create(), ModelTransform.of(-6.75f, 0f, 0f, 0f, 0.2618f, -1.309f));
        add(m, "n57_ribbone6", "n58_ribbone6", ModelPartBuilder.create().uv(48, 77).cuboid(-15.75f, -17.5f, -4.25f, 7, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(8.75f, 17f, 3.75f, 0f, 0f, 0f));
        add(m, "n2_body", "n59_rib3", ModelPartBuilder.create(), ModelTransform.of(1.75f, 0.25f, 4.5f, 0.0873f, -0.5236f, 0.6981f));
    }

    private static void p1(Map<String, ModelPartData> m) {
        add(m, "n59_rib3", "n60_rib3", ModelPartBuilder.create().uv(64, 77).cuboid(0.55f, -17.45f, -0.2f, 7, 1, 1, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(-1.75f, 16.75f, -0.5f, 0f, 0f, 0f));
        add(m, "n59_rib3", "n61_ribbone3", ModelPartBuilder.create(), ModelTransform.of(5.75f, -0.25f, 0f, 0f, -0.1745f, 1.309f));
        add(m, "n61_ribbone3", "n62_ribbone3", ModelPartBuilder.create().uv(188, 77).cuboid(7.5f, -17.5f, 0f, 6, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-7.5f, 17f, -0.5f, 0f, 0f, 0f));
        add(m, "n2_body", "n63_rib9", ModelPartBuilder.create(), ModelTransform.of(-1.75f, 0.25f, 4.5f, 0.0873f, 0.5236f, -0.6981f));
        add(m, "n63_rib9", "n64_rib9", ModelPartBuilder.create().uv(80, 77).cuboid(-7.95f, -17.45f, -0.2f, 7, 1, 1, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(1.75f, 16.75f, -0.5f, 0f, 0f, 0f));
        add(m, "n63_rib9", "n65_ribbone7", ModelPartBuilder.create(), ModelTransform.of(-5.75f, -0.25f, 0f, 0f, 0.1745f, -1.309f));
        add(m, "n65_ribbone7", "n66_ribbone7", ModelPartBuilder.create().uv(202, 77).cuboid(-13.5f, -17.5f, 0f, 6, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(7.5f, 17f, -0.5f, 0f, 0f, 0f));
        add(m, "n2_body", "n67_rib5", ModelPartBuilder.create(), ModelTransform.of(0.75f, -0.25f, 8.25f, 0.0873f, -0.5236f, 0.6981f));
        add(m, "n67_rib5", "n68_rib5", ModelPartBuilder.create().uv(96, 77).cuboid(-0.45f, -17.95f, 3.55f, 7, 1, 1, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(-0.75f, 17.25f, -4.25f, 0f, 0f, 0f));
        add(m, "n67_rib5", "n69_ribbone4", ModelPartBuilder.create(), ModelTransform.of(5.75f, -0.25f, 0f, 0f, -0.1745f, 1.309f));
        add(m, "n69_ribbone4", "n70_ribbone4", ModelPartBuilder.create().uv(76, 79).cuboid(6.5f, -18f, 3.75f, 4, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6.5f, 17.5f, -4.25f, 0f, 0f, 0f));
        add(m, "n2_body", "n71_rib10", ModelPartBuilder.create(), ModelTransform.of(-0.75f, -0.25f, 8.25f, 0.0873f, 0.5236f, -0.6981f));
        add(m, "n71_rib10", "n72_rib10", ModelPartBuilder.create().uv(112, 77).cuboid(-6.95f, -17.95f, 3.55f, 7, 1, 1, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(0.75f, 17.25f, -4.25f, 0f, 0f, 0f));
        add(m, "n71_rib10", "n73_ribbone8", ModelPartBuilder.create(), ModelTransform.of(-5.75f, -0.25f, 0f, 0f, 0.1745f, -1.309f));
        add(m, "n73_ribbone8", "n74_ribbone8", ModelPartBuilder.create().uv(86, 79).cuboid(-10.5f, -18f, 3.75f, 4, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6.5f, 17.5f, -4.25f, 0f, 0f, 0f));
        add(m, "n2_body", "n75_rib4", ModelPartBuilder.create(), ModelTransform.of(1.75f, 1f, -6.25f, 0.0873f, -0.4363f, 0.6981f));
        add(m, "n75_rib4", "n76_rib4", ModelPartBuilder.create().uv(128, 77).cuboid(-1.45f, -16.7f, -10.95f, 7, 1, 1, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(-1.75f, 16f, 10.25f, 0f, 0f, 0f));
        add(m, "n2_body", "n77_rib6", ModelPartBuilder.create(), ModelTransform.of(-1.75f, 1f, -6.25f, 0.0873f, 0.4363f, -0.6981f));
        add(m, "n77_rib6", "n78_rib6", ModelPartBuilder.create().uv(144, 77).cuboid(-5.95f, -16.7f, -10.95f, 7, 1, 1, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(1.75f, 16f, 10.25f, 0f, 0f, 0f));
        add(m, "n2_body", "n79_neck", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, -8.25f, 0.2618f, 0f, 0f));
        add(m, "n79_neck", "n80_neck", ModelPartBuilder.create().uv(162, 54).cuboid(-0.5f, -20f, -15.25f, 1, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n81_neck", ModelPartBuilder.create().uv(168, 54).cuboid(-0.5f, -20.5f, -19.25f, 1, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n82_neck", ModelPartBuilder.create().uv(174, 54).cuboid(-0.5f, -20.25f, -23.25f, 1, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n83_neck", ModelPartBuilder.create().uv(180, 54).cuboid(-0.5f, -19.75f, -27.25f, 1, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n84_neck", ModelPartBuilder.create().uv(236, 41).cuboid(-1.5f, -18.5f, -16.5f, 3, 3, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n85_neck", ModelPartBuilder.create().uv(0, 48).cuboid(-1.5f, -18.75f, -20.5f, 3, 3, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n86_neck", ModelPartBuilder.create().uv(12, 48).cuboid(-1.5f, -18.75f, -24.5f, 3, 3, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n87_neck", ModelPartBuilder.create().uv(24, 48).cuboid(-1.5f, -18.25f, -28.5f, 3, 3, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n88_neck", ModelPartBuilder.create().uv(228, 59).cuboid(-1f, -18f, -14f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n89_neck", ModelPartBuilder.create().uv(236, 59).cuboid(-1f, -18.25f, -18f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n90_neck", ModelPartBuilder.create().uv(244, 59).cuboid(-1f, -18.25f, -22f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n91_neck", ModelPartBuilder.create().uv(0, 63).cuboid(-1f, -18f, -26f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 12.25f, 0f, 0f, 0f));
        add(m, "n79_neck", "n92_vertebrae1", ModelPartBuilder.create(), ModelTransform.of(0f, -1f, -2.75f, 0f, -0.5236f, 0.2618f));
        add(m, "n92_vertebrae1", "n93_vertebrae1", ModelPartBuilder.create().uv(198, 67).cuboid(0.75f, -18f, -16.25f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 18f, 15f, 0f, 0f, 0f));
        add(m, "n92_vertebrae1", "n94_vertebrae1", ModelPartBuilder.create().uv(208, 67).cuboid(-1.556f, -18.2415f, -19.6817f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 18f, 15f, 0f, 0f, 0f));
        add(m, "n92_vertebrae1", "n95_vertebrae1", ModelPartBuilder.create().uv(218, 67).cuboid(-3.806f, -18.2415f, -23.1458f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 18f, 15f, 0f, 0f, 0f));
        add(m, "n92_vertebrae1", "n96_vertebrae1", ModelPartBuilder.create().uv(228, 67).cuboid(-6.194f, -17.7585f, -26.6747f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 18f, 15f, 0f, 0f, 0f));
        add(m, "n79_neck", "n97_vertebrae2", ModelPartBuilder.create(), ModelTransform.of(0f, -1f, -2.75f, 0f, 0.5236f, -0.2618f));
        add(m, "n97_vertebrae2", "n98_vertebrae2", ModelPartBuilder.create().uv(238, 67).cuboid(-3.75f, -18f, -16.25f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 18f, 15f, 0f, 0f, 0f));
        add(m, "n97_vertebrae2", "n99_vertebrae2", ModelPartBuilder.create().uv(0, 71).cuboid(-1.444f, -18.2415f, -19.6817f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 18f, 15f, 0f, 0f, 0f));
        add(m, "n97_vertebrae2", "n100_vertebrae2", ModelPartBuilder.create().uv(10, 71).cuboid(0.806f, -18.2415f, -23.1458f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 18f, 15f, 0f, 0f, 0f));
        add(m, "n97_vertebrae2", "n101_vertebrae2", ModelPartBuilder.create().uv(20, 71).cuboid(3.194f, -17.7585f, -26.6747f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 18f, 15f, 0f, 0f, 0f));
        add(m, "n79_neck", "n102_cervialribs2", ModelPartBuilder.create(), ModelTransform.of(0.5f, -0.5f, -3.75f, 0f, -0.8727f, 0.8727f));
        add(m, "n102_cervialribs2", "n103_cervialribs2", ModelPartBuilder.create().uv(216, 77).cuboid(1.25f, -17.5f, -17.25f, 6, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.5f, 17.5f, 16f, 0f, 0f, 0f));
        add(m, "n102_cervialribs2", "n104_cervialribs2", ModelPartBuilder.create().uv(230, 77).cuboid(-1.9373f, -17.6607f, -19.6744f, 6, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.5f, 17.5f, 16f, 0f, 0f, 0f));
        add(m, "n102_cervialribs2", "n105_cervialribs2", ModelPartBuilder.create().uv(28, 79).cuboid(-5.0015f, -17.6607f, -22.2456f, 5, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.5f, 17.5f, 16f, 0f, 0f, 0f));
        add(m, "n102_cervialribs2", "n106_cervialribs2", ModelPartBuilder.create().uv(96, 79).cuboid(-7.8194f, -17.3393f, -25.1102f, 4, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.5f, 17.5f, 16f, 0f, 0f, 0f));
        add(m, "n79_neck", "n107_cervialribs3", ModelPartBuilder.create(), ModelTransform.of(-0.5f, -0.5f, -3.75f, 0f, 0.8727f, -0.8727f));
        add(m, "n107_cervialribs3", "n108_cervialribs3", ModelPartBuilder.create().uv(0, 79).cuboid(-7.25f, -17.5f, -17.25f, 6, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.5f, 17.5f, 16f, 0f, 0f, 0f));
        add(m, "n107_cervialribs3", "n109_cervialribs3", ModelPartBuilder.create().uv(14, 79).cuboid(-4.0627f, -17.6607f, -19.6744f, 6, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.5f, 17.5f, 16f, 0f, 0f, 0f));
        add(m, "n107_cervialribs3", "n110_cervialribs3", ModelPartBuilder.create().uv(40, 79).cuboid(0.0015f, -17.6607f, -22.2456f, 5, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.5f, 17.5f, 16f, 0f, 0f, 0f));
        add(m, "n107_cervialribs3", "n111_cervialribs3", ModelPartBuilder.create().uv(106, 79).cuboid(3.8194f, -17.3393f, -25.1102f, 4, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.5f, 17.5f, 16f, 0f, 0f, 0f));
        add(m, "n79_neck", "n112_head", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, -19f, -0.0873f, 0f, 0f));
        add(m, "n112_head", "n113_head", ModelPartBuilder.create().uv(166, 41).cuboid(-2f, -20f, -31f, 4, 3, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 31.25f, 0f, 0f, 0f));
        add(m, "n112_head", "n114_head", ModelPartBuilder.create().uv(150, 41).cuboid(-1.5f, -20.75f, -34.4f, 3, 1, 5, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 31.25f, 0f, 0f, 0f));
        add(m, "n112_head", "n115_head", ModelPartBuilder.create().uv(70, 71).cuboid(-1f, -17f, -42f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 31.25f, 0f, 0f, 0f));
        add(m, "n112_head", "n116_head", ModelPartBuilder.create().uv(188, 48).cuboid(1.45f, -21f, -34f, 2, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 31.25f, 0f, 0f, 0f));
        add(m, "n112_head", "n117_head", ModelPartBuilder.create().uv(200, 48).cuboid(-3.45f, -21f, -34f, 2, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 31.25f, 0f, 0f, 0f));
        add(m, "n112_head", "n118_head", ModelPartBuilder.create().uv(180, 41).cuboid(2.75f, -16.75f, -33f, 2, 1, 5, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 31.25f, 0f, 0f, 0f));
        add(m, "n112_head", "n119_head", ModelPartBuilder.create().uv(194, 41).cuboid(-4.75f, -16.75f, -33f, 2, 1, 5, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 31.25f, 0f, 0f, 0f));
    }

    private static void p2(Map<String, ModelPartData> m) {
        add(m, "n112_head", "n120_head", ModelPartBuilder.create().uv(22, 67).cuboid(2.25f, -20.25f, -34f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 31.25f, 0f, 0f, 0f));
        add(m, "n112_head", "n121_head", ModelPartBuilder.create().uv(26, 67).cuboid(-3.25f, -20.25f, -34f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17f, 31.25f, 0f, 0f, 0f));
        add(m, "n112_head", "n122_upperbone1", ModelPartBuilder.create(), ModelTransform.of(0f, -0.6743f, -5.9924f, 0.0873f, 0f, 0f));
        add(m, "n122_upperbone1", "n123_upperbone1", ModelPartBuilder.create().uv(212, 48).cuboid(-1f, -18.25f, -40.25f, 2, 2, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.6743f, 37.2424f, 0f, 0f, 0f));
        add(m, "n112_head", "n124_upperbone4", ModelPartBuilder.create(), ModelTransform.of(0f, -2.4243f, -3.4924f, 0.6109f, 0f, 0f));
        add(m, "n124_upperbone4", "n125_upperbone4", ModelPartBuilder.create().uv(132, 41).cuboid(-2f, -20.35f, -38.65f, 4, 1, 5, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 19.4243f, 34.7424f, 0f, 0f, 0f));
        add(m, "n112_head", "n126_jaw", ModelPartBuilder.create(), ModelTransform.of(0f, 1.3257f, 1.0076f, 0f, 0f, 0f));
        add(m, "n126_jaw", "n127_jaw", ModelPartBuilder.create().uv(190, 54).cuboid(-2.5f, -16.25f, -30.75f, 5, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 15.6743f, 30.2424f, 0f, 0f, 0f));
        add(m, "n126_jaw", "n128_jaw", ModelPartBuilder.create().uv(78, 71).cuboid(-1f, -13.25f, -40.75f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 15.6743f, 30.2424f, 0f, 0f, 0f));
        add(m, "n126_jaw", "n129_jaw", ModelPartBuilder.create().uv(222, 48).cuboid(1.25f, -15.75f, -32.25f, 2, 2, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 15.6743f, 30.2424f, 0f, 0f, 0f));
        add(m, "n126_jaw", "n130_jaw", ModelPartBuilder.create().uv(232, 48).cuboid(-3.25f, -15.75f, -32.25f, 2, 2, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 15.6743f, 30.2424f, 0f, 0f, 0f));
        add(m, "n126_jaw", "n131_jawbone1", ModelPartBuilder.create(), ModelTransform.of(2.5f, 2.25f, -3f, 0.0873f, 0.3491f, 0f));
        add(m, "n131_jawbone1", "n132_jawbone1", ModelPartBuilder.create().uv(88, 21).cuboid(2f, -13.75f, -40.25f, 1, 1, 9, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2.5f, 13.4243f, 33.2424f, 0f, 0f, 0f));
        add(m, "n131_jawbone1", "n133_jawbone1", ModelPartBuilder.create().uv(166, 33).cuboid(2.749f, -14.75f, -41f, 1, 1, 6, new Dilation(-0.4995f, 0f, 0f)), ModelTransform.of(-2.5f, 13.4243f, 33.2424f, 0f, 0f, 0f));
        add(m, "n126_jaw", "n134_jawbone4", ModelPartBuilder.create(), ModelTransform.of(-2.5f, 2.25f, -3f, 0.0873f, -0.3491f, 0f));
        add(m, "n134_jawbone4", "n135_jawbone4", ModelPartBuilder.create().uv(108, 21).cuboid(-3f, -13.75f, -40.25f, 1, 1, 9, new Dilation(0f, 0f, 0f)), ModelTransform.of(2.5f, 13.4243f, 33.2424f, 0f, 0f, 0f));
        add(m, "n134_jawbone4", "n136_jawbone4", ModelPartBuilder.create().uv(180, 33).cuboid(-2.751f, -14.75f, -41f, 1, 1, 6, new Dilation(-0.4995f, 0f, 0f)), ModelTransform.of(2.5f, 13.4243f, 33.2424f, 0f, 0f, 0f));
        add(m, "n126_jaw", "n137_jawbone2", ModelPartBuilder.create(), ModelTransform.of(2.25f, 1.25f, -0.75f, 0.5236f, 0.0873f, 0f));
        add(m, "n126_jaw", "n138_jawbone3", ModelPartBuilder.create(), ModelTransform.of(2f, 2.35f, -4.75f, 0.6458f, 0.2618f, 0f));
        add(m, "n138_jawbone3", "n139_jawbone3", ModelPartBuilder.create().uv(182, 71).cuboid(1.5f, -12.9f, -33.75f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2f, 13.3243f, 34.9924f, 0f, 0f, 0f));
        add(m, "n126_jaw", "n140_jawbone5", ModelPartBuilder.create(), ModelTransform.of(-2f, 2.35f, -4.75f, 0.6458f, -0.2618f, 0f));
        add(m, "n140_jawbone5", "n141_jawbone5", ModelPartBuilder.create().uv(188, 71).cuboid(-2.5f, -12.9f, -33.75f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(2f, 13.3243f, 34.9924f, 0f, 0f, 0f));
        add(m, "n112_head", "n142_upperbone3", ModelPartBuilder.create(), ModelTransform.of(2.25f, 0.0757f, -1.9924f, -0.0873f, 0.3491f, 0f));
        add(m, "n142_upperbone3", "n143_upperbone3", ModelPartBuilder.create().uv(8, 21).cuboid(3.449f, -16f, -42.25f, 1, 2, 9, new Dilation(-0.4995f, 0f, 0f)), ModelTransform.of(-2.25f, 16.9243f, 33.2424f, 0f, 0f, 0f));
        add(m, "n142_upperbone3", "n144_upperbone3", ModelPartBuilder.create().uv(128, 21).cuboid(1.95f, -17.75f, -40.25f, 2, 2, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2.25f, 16.9243f, 33.2424f, 0f, 0f, 0f));
        add(m, "n142_upperbone3", "n145_upperbone3", ModelPartBuilder.create().uv(160, 48).cuboid(-1.5f, -18.25f, -31f, 4, 2, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2.25f, 16.9243f, 33.2424f, 0f, 0f, 0f));
        add(m, "n112_head", "n146_upperbone6", ModelPartBuilder.create(), ModelTransform.of(-2.25f, 0.0757f, -1.9924f, -0.0873f, -0.3491f, 0f));
        add(m, "n146_upperbone6", "n147_upperbone6", ModelPartBuilder.create().uv(28, 21).cuboid(-3.451f, -16f, -42.25f, 1, 2, 9, new Dilation(-0.4995f, 0f, 0f)), ModelTransform.of(2.25f, 16.9243f, 33.2424f, 0f, 0f, 0f));
        add(m, "n146_upperbone6", "n148_upperbone6", ModelPartBuilder.create().uv(148, 21).cuboid(-3.95f, -17.75f, -40.25f, 2, 2, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(2.25f, 16.9243f, 33.2424f, 0f, 0f, 0f));
        add(m, "n146_upperbone6", "n149_upperbone6", ModelPartBuilder.create().uv(174, 48).cuboid(-2.5f, -18.25f, -31f, 4, 2, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(2.25f, 16.9243f, 33.2424f, 0f, 0f, 0f));
        add(m, "n112_head", "n150_upperbone2", ModelPartBuilder.create(), ModelTransform.of(1.75f, -3.1743f, -1.7424f, 0.5236f, 0.1745f, 0f));
        add(m, "n150_upperbone2", "n151_upperbone2", ModelPartBuilder.create().uv(134, 33).cuboid(1.4178f, -20.9564f, -39.2285f, 2, 1, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n150_upperbone2", "n152_upperbone2", ModelPartBuilder.create().uv(230, 21).cuboid(1.5f, -19.15f, -30.75f, 2, 1, 7, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n150_upperbone2", "n153_upperbone2", ModelPartBuilder.create().uv(8, 63).cuboid(2.5f, -18.15f, -30f, 1, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n150_upperbone2", "n154_upperbone2", ModelPartBuilder.create().uv(120, 48).cuboid(0.5f, -19.25f, -31.5f, 2, 4, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n150_upperbone2", "n155_upperbone2", ModelPartBuilder.create().uv(144, 59).cuboid(1.1395f, -22.5114f, -42.7207f, 2, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n150_upperbone2", "n156_upperbone2", ModelPartBuilder.create().uv(208, 41).cuboid(0.9f, -17.5f, -34.5f, 3, 2, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n112_head", "n157_upperbone5", ModelPartBuilder.create(), ModelTransform.of(-1.75f, -3.1743f, -1.7424f, 0.5236f, -0.1745f, 0f));
        add(m, "n157_upperbone5", "n158_upperbone5", ModelPartBuilder.create().uv(150, 33).cuboid(-3.4178f, -20.9564f, -39.2285f, 2, 1, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n157_upperbone5", "n159_upperbone5", ModelPartBuilder.create().uv(0, 33).cuboid(-3.5f, -19.15f, -30.75f, 2, 1, 7, new Dilation(0f, 0f, 0f)), ModelTransform.of(1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n157_upperbone5", "n160_upperbone5", ModelPartBuilder.create().uv(16, 63).cuboid(-3.5f, -18.15f, -30f, 1, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n157_upperbone5", "n161_upperbone5", ModelPartBuilder.create().uv(128, 48).cuboid(-2.5f, -19.25f, -31.5f, 2, 4, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n157_upperbone5", "n162_upperbone5", ModelPartBuilder.create().uv(154, 59).cuboid(-3.1395f, -22.5114f, -42.7207f, 2, 1, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n157_upperbone5", "n163_upperbone5", ModelPartBuilder.create().uv(222, 41).cuboid(-3.9f, -17.5f, -34.5f, 3, 2, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(1.75f, 20.1743f, 32.9924f, 0f, 0f, 0f));
        add(m, "n2_body", "n164_hium", ModelPartBuilder.create(), ModelTransform.of(1f, -1f, 22f, -0.2618f, 0f, 0f));
        add(m, "n164_hium", "n165_hium", ModelPartBuilder.create().uv(48, 21).cuboid(3f, -19.75f, 13f, 2, 3, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1f, 18f, -18f, 0f, 0f, 0f));
        add(m, "n164_hium", "n166_hium", ModelPartBuilder.create().uv(96, 41).cuboid(-0.5f, -10f, 13.75f, 1, 2, 5, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1f, 18f, -18f, 0f, 0f, 0f));
        add(m, "n164_hium", "n167_hium", ModelPartBuilder.create().uv(16, 67).cuboid(-0.5f, -13f, 24f, 1, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1f, 18f, -18f, 0f, 0f, 0f));
        add(m, "n164_hium", "n168_hium", ModelPartBuilder.create().uv(194, 33).cuboid(3.5f, -20.75f, 14f, 1, 1, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1f, 18f, -18f, 0f, 0f, 0f));
        add(m, "n164_hium", "n169_hium", ModelPartBuilder.create().uv(208, 33).cuboid(-4.5f, -20.75f, 14f, 1, 1, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1f, 18f, -18f, 0f, 0f, 0f));
        add(m, "n164_hium", "n170_hium", ModelPartBuilder.create().uv(68, 21).cuboid(-5f, -19.75f, 13f, 2, 3, 8, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1f, 18f, -18f, 0f, 0f, 0f));
        add(m, "n164_hium", "n171_hip3", ModelPartBuilder.create(), ModelTransform.of(1f, 3f, 0f, 0f, 0f, -0.2618f));
        add(m, "n171_hip3", "n172_hip3", ModelPartBuilder.create().uv(136, 48).cuboid(5f, -17.75f, 20f, 1, 3, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2f, 15f, -18f, 0f, 0f, 0f));
        add(m, "n171_hip3", "n173_hip3", ModelPartBuilder.create().uv(242, 48).cuboid(4.05f, -17.75f, 11.25f, 2, 2, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2f, 15f, -18f, 0f, 0f, 0f));
        add(m, "n171_hip3", "n174_hip3", ModelPartBuilder.create().uv(34, 33).cuboid(4.5f, -19f, 14f, 1, 2, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2f, 15f, -18f, 0f, 0f, 0f));
        add(m, "n164_hium", "n175_pubis1", ModelPartBuilder.create(), ModelTransform.of(-2.75f, 1.9f, -0.75f, -0.1745f, 0f, 0.4363f));
        add(m, "n175_pubis1", "n176_pubis1", ModelPartBuilder.create().uv(108, 41).cuboid(1f, -19.25f, 13f, 2, 3, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(1.75f, 16.1f, -17.25f, 0f, 0f, 0f));
        add(m, "n175_pubis1", "n177_pubis1", ModelPartBuilder.create().uv(194, 71).cuboid(2.25f, -17.75f, 16.75f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(1.75f, 16.1f, -17.25f, 0f, 0f, 0f));
        add(m, "n175_pubis1", "n178_pubis1", ModelPartBuilder.create().uv(198, 21).cuboid(2.2f, -17.15f, 16.2f, 2, 7, 2, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(1.75f, 16.1f, -17.25f, 0f, 0f, 0f));
        add(m, "n164_hium", "n179_ischium1", ModelPartBuilder.create(), ModelTransform.of(1.25f, 1.4f, 4f, 0.6109f, 0f, 0.4363f));
    }

    private static void p3(Map<String, ModelPartData> m) {
        add(m, "n179_ischium1", "n180_ischium1", ModelPartBuilder.create().uv(0, 54).cuboid(2.5f, -17.75f, 18.25f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2.25f, 16.6f, -22f, 0f, 0f, 0f));
        add(m, "n179_ischium1", "n181_ischium1", ModelPartBuilder.create().uv(110, 33).cuboid(2f, -17.35f, 21.25f, 1, 7, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2.25f, 16.6f, -22f, 0f, 0f, 0f));
        add(m, "n164_hium", "n182_leftFemur", ModelPartBuilder.create(), ModelTransform.of(5f, 1.5f, 1f, -0.5236f, 0f, 0f));
        add(m, "n182_leftFemur", "n183_leftFemur", ModelPartBuilder.create().uv(10, 54).cuboid(4.75f, -17.5f, 17.5f, 2, 2, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 16.5f, -19f, 0f, 0f, 0f));
        add(m, "n182_leftFemur", "n184_leftFemur", ModelPartBuilder.create().uv(24, 63).cuboid(5.3f, -8.45f, 17.8f, 2, 2, 2, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(-6f, 16.5f, -19f, 0f, 0f, 0f));
        add(m, "n182_leftFemur", "n185_leftFemur", ModelPartBuilder.create().uv(168, 21).cuboid(5.5f, -16.25f, 18f, 2, 8, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 16.5f, -19f, 0f, 0f, 0f));
        add(m, "n182_leftFemur", "n186_leftTibia", ModelPartBuilder.create(), ModelTransform.of(0f, 10f, 0.25f, 1.5708f, 0f, 0f));
        add(m, "n186_leftTibia", "n187_leftTibia", ModelPartBuilder.create().uv(32, 63).cuboid(6f, -7.75f, 18.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 6.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n186_leftTibia", "n188_leftTibia", ModelPartBuilder.create().uv(40, 63).cuboid(5.75f, 2.25f, 18.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 6.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n186_leftTibia", "n189_leftTibia", ModelPartBuilder.create().uv(214, 21).cuboid(6.1f, -5.9f, 18.85f, 1, 8, 1, new Dilation(0.15f, 0.15f, 0.15f)), ModelTransform.of(-6f, 6.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n186_leftTibia", "n190_leftTibia", ModelPartBuilder.create().uv(218, 21).cuboid(7.25f, -5.75f, 18.25f, 1, 8, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 6.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n186_leftTibia", "n191_Foot3", ModelPartBuilder.create(), ModelTransform.of(0f, 11f, 0f, -2.3562f, 0f, 0f));
        add(m, "n191_Foot3", "n192_Foot3", ModelPartBuilder.create().uv(60, 48).cuboid(5.25f, 3.25f, 18.5f, 3, 4, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n191_Foot3", "n193_Foot3", ModelPartBuilder.create().uv(138, 74).cuboid(8f, 8.25f, 19f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n191_Foot3", "n194_Foot3", ModelPartBuilder.create().uv(142, 74).cuboid(4.5f, 8.25f, 19f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n191_Foot3", "n195_Foot3", ModelPartBuilder.create().uv(146, 74).cuboid(6.25f, 9f, 19f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n191_Foot3", "n196_Foot3", ModelPartBuilder.create().uv(30, 67).cuboid(7.75f, 5.25f, 18.75f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n191_Foot3", "n197_Foot3", ModelPartBuilder.create().uv(34, 67).cuboid(4.75f, 5.25f, 18.75f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n191_Foot3", "n198_Foot3", ModelPartBuilder.create().uv(38, 67).cuboid(6.25f, 6f, 18.75f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n191_Foot3", "n199_Foot3", ModelPartBuilder.create().uv(156, 79).cuboid(8f, 9.75f, 19.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n191_Foot3", "n200_Foot3", ModelPartBuilder.create().uv(160, 79).cuboid(4.5f, 9.75f, 19.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n191_Foot3", "n201_Foot3", ModelPartBuilder.create().uv(164, 79).cuboid(6.25f, 10.5f, 19.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n164_hium", "n202_tail1", ModelPartBuilder.create(), ModelTransform.of(-1f, -1f, 4.25f, -0.1745f, 0f, 0f));
        add(m, "n202_tail1", "n203_tail1", ModelPartBuilder.create().uv(48, 63).cuboid(-0.8f, -19.3f, 22.95f, 2, 2, 2, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n204_tail1", ModelPartBuilder.create().uv(56, 63).cuboid(-0.8f, -19.05f, 25.95f, 2, 2, 2, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n205_tail1", ModelPartBuilder.create().uv(64, 63).cuboid(-0.8f, -18.8f, 29.2f, 2, 2, 2, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n206_tail1", ModelPartBuilder.create().uv(72, 63).cuboid(-0.8f, -18.55f, 32.2f, 2, 2, 2, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n207_tail1", ModelPartBuilder.create().uv(80, 63).cuboid(-0.8f, -18.55f, 35.2f, 2, 2, 2, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n208_tail1", ModelPartBuilder.create().uv(88, 63).cuboid(-0.8f, -18.05f, 38.2f, 2, 2, 2, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n209_tail1", ModelPartBuilder.create().uv(90, 54).cuboid(-1f, -20f, 21.25f, 2, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n210_tail1", ModelPartBuilder.create().uv(98, 54).cuboid(-1f, -20f, 24.25f, 2, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n211_tail1", ModelPartBuilder.create().uv(106, 54).cuboid(-1f, -19.5f, 27.5f, 2, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n212_tail1", ModelPartBuilder.create().uv(114, 54).cuboid(-1f, -19.25f, 30.5f, 2, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n213_tail1", ModelPartBuilder.create().uv(122, 54).cuboid(-1f, -19.25f, 33.5f, 2, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n214_tail1", ModelPartBuilder.create().uv(130, 54).cuboid(-1f, -18.75f, 36.5f, 2, 3, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 19f, -22.25f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n215_tail2", ModelPartBuilder.create(), ModelTransform.of(0f, 1.75f, 18.25f, 0.4363f, 0f, 0f));
        add(m, "n215_tail2", "n216_tail2", ModelPartBuilder.create().uv(168, 79).cuboid(-0.6f, -17.85f, 41.4f, 1, 1, 1, new Dilation(0.1f, 0.1f, 0.1f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n217_tail2", ModelPartBuilder.create().uv(172, 79).cuboid(-0.6f, -17.8215f, 44.4412f, 1, 1, 1, new Dilation(0.1f, 0.1f, 0.1f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n218_tail2", ModelPartBuilder.create().uv(176, 79).cuboid(-0.6f, -17.8215f, 47.4412f, 1, 1, 1, new Dilation(0.1f, 0.1f, 0.1f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n219_tail2", ModelPartBuilder.create().uv(180, 79).cuboid(-0.6f, -17.8215f, 50.4412f, 1, 1, 1, new Dilation(0.1f, 0.1f, 0.1f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n220_tail2", ModelPartBuilder.create().uv(184, 79).cuboid(-0.6f, -17.8215f, 53.4412f, 1, 1, 1, new Dilation(0.1f, 0.1f, 0.1f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n221_tail2", ModelPartBuilder.create().uv(188, 79).cuboid(-0.6f, -17.8215f, 56.4412f, 1, 1, 1, new Dilation(0.1f, 0.1f, 0.1f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n222_tail2", ModelPartBuilder.create().uv(192, 79).cuboid(-0.6f, -17.8215f, 59.4412f, 1, 1, 1, new Dilation(0.1f, 0.1f, 0.1f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n223_tail2", ModelPartBuilder.create().uv(96, 63).cuboid(-1f, -18.25f, 39.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n224_tail2", ModelPartBuilder.create().uv(104, 63).cuboid(-1f, -18.2215f, 42.5412f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n225_tail2", ModelPartBuilder.create().uv(112, 63).cuboid(-1f, -18.2215f, 45.5412f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n226_tail2", ModelPartBuilder.create().uv(120, 63).cuboid(-1f, -18.2215f, 48.5412f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n227_tail2", ModelPartBuilder.create().uv(128, 63).cuboid(-1f, -18.2215f, 51.5412f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n228_tail2", ModelPartBuilder.create().uv(136, 63).cuboid(-1f, -18.2215f, 54.5412f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n229_tail2", ModelPartBuilder.create().uv(144, 63).cuboid(-1f, -18.2215f, 57.5412f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.25f, -40.5f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n230_tailbone3", ModelPartBuilder.create(), ModelTransform.of(0f, 1.25f, -0.5f, 0.6981f, 0f, 0f));
        add(m, "n230_tailbone3", "n231_tailbone3", ModelPartBuilder.create().uv(150, 74).cuboid(-0.5f, -16.5f, 40f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n232_tailbone3", ModelPartBuilder.create().uv(154, 74).cuboid(-0.5f, -14.5233f, 42.3114f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n233_tailbone3", ModelPartBuilder.create().uv(158, 74).cuboid(-0.5f, -12.5949f, 44.8595f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n234_tailbone3", ModelPartBuilder.create().uv(162, 74).cuboid(-0.5f, -10.9165f, 47.1576f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n235_tailbone3", ModelPartBuilder.create().uv(166, 74).cuboid(-0.5f, -9.2382f, 49.4558f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n236_tailbone3", ModelPartBuilder.create().uv(170, 74).cuboid(-0.5f, -7.5598f, 51.7539f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n237_tailbone3", ModelPartBuilder.create().uv(174, 74).cuboid(-0.5f, -5.8815f, 54.0521f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n238_tailbone3", ModelPartBuilder.create().uv(200, 71).cuboid(-0.5f, -18f, 41f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n239_tailbone3", ModelPartBuilder.create().uv(206, 71).cuboid(-0.5f, -16.0233f, 43.3114f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
    }

    private static void p4(Map<String, ModelPartData> m) {
        add(m, "n230_tailbone3", "n240_tailbone3", ModelPartBuilder.create().uv(212, 71).cuboid(-0.5f, -14.0949f, 45.6095f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n241_tailbone3", ModelPartBuilder.create().uv(218, 71).cuboid(-0.5f, -12.1665f, 47.9076f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n242_tailbone3", ModelPartBuilder.create().uv(224, 71).cuboid(-0.5f, -9.9882f, 50.2058f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n243_tailbone3", ModelPartBuilder.create().uv(230, 71).cuboid(-0.5f, -8.0598f, 52.2539f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n230_tailbone3", "n244_tailbone3", ModelPartBuilder.create().uv(236, 71).cuboid(-0.5f, -5.8815f, 54.5521f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -40f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n245_tailbone4", ModelPartBuilder.create(), ModelTransform.of(-0.25f, 0f, 0.25f, 0f, -0.5236f, -0.2618f));
        add(m, "n245_tailbone4", "n246_tailbone4", ModelPartBuilder.create().uv(242, 71).cuboid(0.25f, -17.25f, 39.25f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n245_tailbone4", "n247_tailbone4", ModelPartBuilder.create().uv(248, 71).cuboid(1.7642f, -17.2224f, 41.8875f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n245_tailbone4", "n248_tailbone4", ModelPartBuilder.create().uv(0, 74).cuboid(3.2642f, -17.2224f, 44.4856f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n245_tailbone4", "n249_tailbone4", ModelPartBuilder.create().uv(6, 74).cuboid(4.7642f, -17.2224f, 47.0836f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n245_tailbone4", "n250_tailbone4", ModelPartBuilder.create().uv(12, 74).cuboid(6.2642f, -17.2224f, 49.6817f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n245_tailbone4", "n251_tailbone4", ModelPartBuilder.create().uv(18, 74).cuboid(7.7642f, -17.2224f, 52.2798f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n245_tailbone4", "n252_tailbone4", ModelPartBuilder.create().uv(24, 74).cuboid(9.2642f, -17.2224f, 54.8779f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n253_tailbone8", ModelPartBuilder.create(), ModelTransform.of(0.25f, 0f, 0.25f, 0f, 0.5236f, 0.2618f));
        add(m, "n253_tailbone8", "n254_tailbone8", ModelPartBuilder.create().uv(30, 74).cuboid(-1.25f, -17.25f, 39.25f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n253_tailbone8", "n255_tailbone8", ModelPartBuilder.create().uv(36, 74).cuboid(-2.7642f, -17.2224f, 41.8875f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n253_tailbone8", "n256_tailbone8", ModelPartBuilder.create().uv(42, 74).cuboid(-4.2642f, -17.2224f, 44.4856f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n253_tailbone8", "n257_tailbone8", ModelPartBuilder.create().uv(48, 74).cuboid(-5.7642f, -17.2224f, 47.0836f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n253_tailbone8", "n258_tailbone8", ModelPartBuilder.create().uv(54, 74).cuboid(-7.2642f, -17.2224f, 49.6817f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n253_tailbone8", "n259_tailbone8", ModelPartBuilder.create().uv(60, 74).cuboid(-8.7642f, -17.2224f, 52.2798f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n253_tailbone8", "n260_tailbone8", ModelPartBuilder.create().uv(66, 74).cuboid(-10.2642f, -17.2224f, 54.8779f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -40.75f, 0f, 0f, 0f));
        add(m, "n215_tail2", "n261_tail3", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 20.9f, 0.4363f, 0f, 0f));
        add(m, "n261_tail3", "n262_tail3", ModelPartBuilder.create().uv(196, 79).cuboid(-0.5f, -17.7f, 63.05f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n263_tail3", ModelPartBuilder.create().uv(200, 79).cuboid(-0.5f, -17.7f, 66.45f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n264_tail3", ModelPartBuilder.create().uv(204, 79).cuboid(-0.5f, -17.7f, 69.7f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n265_tail3", ModelPartBuilder.create().uv(208, 79).cuboid(-0.3f, -17.5f, 72.9f, 1, 1, 1, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n266_tail3", ModelPartBuilder.create().uv(212, 79).cuboid(-0.3f, -17.5f, 75.65f, 1, 1, 1, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n267_tail3", ModelPartBuilder.create().uv(216, 79).cuboid(-0.3f, -17.5f, 78.4f, 1, 1, 1, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n268_tail3", ModelPartBuilder.create().uv(220, 79).cuboid(-0.3f, -17.5f, 81.15f, 1, 1, 1, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n269_tail3", ModelPartBuilder.create().uv(20, 54).cuboid(-0.8f, -18.05f, 60.6f, 2, 2, 3, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n270_tail3", ModelPartBuilder.create().uv(30, 54).cuboid(-0.8f, -18.05f, 64f, 2, 2, 3, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n271_tail3", ModelPartBuilder.create().uv(40, 54).cuboid(-0.8f, -18.05f, 67.25f, 2, 2, 3, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n272_tail3", ModelPartBuilder.create().uv(72, 74).cuboid(-0.6f, -17.85f, 70.7f, 1, 1, 2, new Dilation(0.1f, 0.1f, 0.1f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n273_tail3", ModelPartBuilder.create().uv(78, 74).cuboid(-0.6f, -17.85f, 73.45f, 1, 1, 2, new Dilation(0.1f, 0.1f, 0.1f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n274_tail3", ModelPartBuilder.create().uv(84, 74).cuboid(-0.6f, -17.85f, 76.2f, 1, 1, 2, new Dilation(0.1f, 0.1f, 0.1f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n275_tail3", ModelPartBuilder.create().uv(90, 74).cuboid(-0.6f, -17.85f, 78.95f, 1, 1, 2, new Dilation(0.1f, 0.1f, 0.1f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n276_tail3", ModelPartBuilder.create().uv(50, 54).cuboid(-0.8f, -18.05f, 60.6f, 2, 2, 3, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(0f, 17.25f, -61.4f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n277_tailbone5", ModelPartBuilder.create(), ModelTransform.of(0f, 1.25f, -0.5f, 0.6981f, 0f, 0f));
        add(m, "n277_tailbone5", "n278_tailbone5", ModelPartBuilder.create().uv(224, 79).cuboid(-0.5f, -16.15f, 61.6f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n277_tailbone5", "n279_tailbone5", ModelPartBuilder.create().uv(228, 79).cuboid(-0.5f, -13.9645f, 64.2046f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n277_tailbone5", "n280_tailbone5", ModelPartBuilder.create().uv(232, 79).cuboid(-0.5f, -11.8755f, 66.6942f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n277_tailbone5", "n281_tailbone5", ModelPartBuilder.create().uv(236, 79).cuboid(-0.5f, -16.15f, 61.6f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n277_tailbone5", "n282_tailbone5", ModelPartBuilder.create().uv(240, 79).cuboid(-0.5f, -17.45f, 62.3f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n277_tailbone5", "n283_tailbone5", ModelPartBuilder.create().uv(244, 79).cuboid(-0.5f, -15.2645f, 64.9045f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n277_tailbone5", "n284_tailbone5", ModelPartBuilder.create().uv(248, 79).cuboid(-0.5f, -13.1755f, 67.3942f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n277_tailbone5", "n285_tailbone5", ModelPartBuilder.create().uv(252, 79).cuboid(-0.5f, -11.0864f, 69.8838f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n277_tailbone5", "n286_tailbone5", ModelPartBuilder.create().uv(0, 81).cuboid(-0.5f, -9.3187f, 71.9905f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n277_tailbone5", "n287_tailbone5", ModelPartBuilder.create().uv(4, 81).cuboid(-0.5f, -7.5511f, 74.0971f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n277_tailbone5", "n288_tailbone5", ModelPartBuilder.create().uv(8, 81).cuboid(-0.5f, -5.7834f, 76.2037f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n277_tailbone5", "n289_tailbone5", ModelPartBuilder.create().uv(12, 81).cuboid(-0.5f, -17.45f, 62.3f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 16f, -60.9f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n290_tailbone6", ModelPartBuilder.create(), ModelTransform.of(-0.25f, 0f, 0.25f, 0f, -0.5236f, -0.2618f));
        add(m, "n290_tailbone6", "n291_tailbone6", ModelPartBuilder.create().uv(16, 81).cuboid(0.25f, -17.5f, 61f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -61.65f, 0f, 0f, 0f));
        add(m, "n290_tailbone6", "n292_tailbone6", ModelPartBuilder.create().uv(20, 81).cuboid(1.95f, -17.5f, 63.9445f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -61.65f, 0f, 0f, 0f));
        add(m, "n290_tailbone6", "n293_tailbone6", ModelPartBuilder.create().uv(24, 81).cuboid(3.575f, -17.5f, 66.7591f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -61.65f, 0f, 0f, 0f));
        add(m, "n290_tailbone6", "n294_tailbone6", ModelPartBuilder.create().uv(28, 81).cuboid(4.95f, -17.5f, 69.5736f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -61.65f, 0f, 0f, 0f));
        add(m, "n290_tailbone6", "n295_tailbone6", ModelPartBuilder.create().uv(32, 81).cuboid(0.25f, -17.5f, 61f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 17.25f, -61.65f, 0f, 0f, 0f));
        add(m, "n261_tail3", "n296_tailbone9", ModelPartBuilder.create(), ModelTransform.of(0.25f, 0f, 0.25f, 0f, 0.5236f, 0.2618f));
        add(m, "n296_tailbone9", "n297_tailbone9", ModelPartBuilder.create().uv(36, 81).cuboid(-1.25f, -17.5f, 61f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -61.65f, 0f, 0f, 0f));
        add(m, "n296_tailbone9", "n298_tailbone9", ModelPartBuilder.create().uv(40, 81).cuboid(-2.95f, -17.5f, 63.9445f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -61.65f, 0f, 0f, 0f));
        add(m, "n296_tailbone9", "n299_tailbone9", ModelPartBuilder.create().uv(44, 81).cuboid(-4.575f, -17.5f, 66.7591f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -61.65f, 0f, 0f, 0f));
    }

    private static void p5(Map<String, ModelPartData> m) {
        add(m, "n296_tailbone9", "n300_tailbone9", ModelPartBuilder.create().uv(48, 81).cuboid(-5.95f, -17.5f, 69.5736f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -61.65f, 0f, 0f, 0f));
        add(m, "n296_tailbone9", "n301_tailbone9", ModelPartBuilder.create().uv(52, 81).cuboid(-1.25f, -17.5f, 61f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 17.25f, -61.65f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n302_tailbone1", ModelPartBuilder.create(), ModelTransform.of(0f, 1.25f, -0.5f, 0.6981f, 0f, 0f));
        add(m, "n302_tailbone1", "n303_tailbone1", ModelPartBuilder.create().uv(152, 48).cuboid(-0.5f, -17.5f, 21.25f, 1, 5, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n302_tailbone1", "n304_tailbone1", ModelPartBuilder.create().uv(156, 48).cuboid(-0.5f, -15.35f, 23.5f, 1, 5, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n302_tailbone1", "n305_tailbone1", ModelPartBuilder.create().uv(96, 74).cuboid(-0.5f, -19.75f, 22.75f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n302_tailbone1", "n306_tailbone1", ModelPartBuilder.create().uv(102, 74).cuboid(-0.5f, -17.8216f, 25.0481f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n302_tailbone1", "n307_tailbone1", ModelPartBuilder.create().uv(108, 74).cuboid(-0.5f, -15.3496f, 27.2164f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n302_tailbone1", "n308_tailbone1", ModelPartBuilder.create().uv(114, 74).cuboid(-0.5f, -13.2297f, 29.3538f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n302_tailbone1", "n309_tailbone1", ModelPartBuilder.create().uv(120, 74).cuboid(-0.5f, -11.3013f, 31.652f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n302_tailbone1", "n310_tailbone1", ModelPartBuilder.create().uv(126, 74).cuboid(-0.5f, -8.9899f, 33.6287f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n302_tailbone1", "n311_tailbone1", ModelPartBuilder.create().uv(186, 54).cuboid(-0.5f, -12.8928f, 25.734f, 1, 4, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n302_tailbone1", "n312_tailbone1", ModelPartBuilder.create().uv(42, 67).cuboid(-0.5f, -10.7471f, 28.066f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n302_tailbone1", "n313_tailbone1", ModelPartBuilder.create().uv(46, 67).cuboid(-0.5f, -8.8187f, 30.3642f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n302_tailbone1", "n314_tailbone1", ModelPartBuilder.create().uv(50, 67).cuboid(-0.5f, -7.2574f, 32.5909f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 17.75f, -21.75f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n315_tailbone2", ModelPartBuilder.create(), ModelTransform.of(-0.25f, 0f, 0.25f, 0f, -0.5236f, -0.2618f));
        add(m, "n315_tailbone2", "n316_tailbone2", ModelPartBuilder.create().uv(86, 71).cuboid(0.25f, -19f, 21f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n315_tailbone2", "n317_tailbone2", ModelPartBuilder.create().uv(94, 71).cuboid(1.5f, -19f, 23.7141f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n315_tailbone2", "n318_tailbone2", ModelPartBuilder.create().uv(102, 71).cuboid(3.0129f, -18.517f, 26.5934f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n315_tailbone2", "n319_tailbone2", ModelPartBuilder.create().uv(110, 71).cuboid(4.4569f, -18.2756f, 29.2238f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n315_tailbone2", "n320_tailbone2", ModelPartBuilder.create().uv(118, 71).cuboid(5.9569f, -18.2756f, 31.8219f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n315_tailbone2", "n321_tailbone2", ModelPartBuilder.create().uv(126, 71).cuboid(7.3448f, -17.7926f, 34.4847f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n202_tail1", "n322_tailbone7", ModelPartBuilder.create(), ModelTransform.of(0.25f, 0f, 0.25f, 0f, 0.5236f, 0.2618f));
        add(m, "n322_tailbone7", "n323_tailbone7", ModelPartBuilder.create().uv(134, 71).cuboid(-2.25f, -19f, 21f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n322_tailbone7", "n324_tailbone7", ModelPartBuilder.create().uv(142, 71).cuboid(-3.5f, -19f, 23.7141f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n322_tailbone7", "n325_tailbone7", ModelPartBuilder.create().uv(150, 71).cuboid(-5.0129f, -18.517f, 26.5934f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n322_tailbone7", "n326_tailbone7", ModelPartBuilder.create().uv(158, 71).cuboid(-6.4569f, -18.2756f, 29.2238f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n322_tailbone7", "n327_tailbone7", ModelPartBuilder.create().uv(166, 71).cuboid(-7.9569f, -18.2756f, 31.8219f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n322_tailbone7", "n328_tailbone7", ModelPartBuilder.create().uv(174, 71).cuboid(-9.3448f, -17.7926f, 34.4847f, 2, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-0.25f, 19f, -22.5f, 0f, 0f, 0f));
        add(m, "n164_hium", "n329_hip2", ModelPartBuilder.create(), ModelTransform.of(-3f, 3f, 0f, 0f, 0f, 0.2618f));
        add(m, "n329_hip2", "n330_hip2", ModelPartBuilder.create().uv(144, 48).cuboid(-6f, -17.75f, 20f, 1, 3, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(2f, 15f, -18f, 0f, 0f, 0f));
        add(m, "n329_hip2", "n331_hip2", ModelPartBuilder.create().uv(60, 54).cuboid(-6.05f, -17.75f, 11.25f, 2, 2, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(2f, 15f, -18f, 0f, 0f, 0f));
        add(m, "n329_hip2", "n332_hip2", ModelPartBuilder.create().uv(48, 33).cuboid(-5.5f, -19f, 14f, 1, 2, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(2f, 15f, -18f, 0f, 0f, 0f));
        add(m, "n164_hium", "n333_pubis2", ModelPartBuilder.create(), ModelTransform.of(0.75f, 1.9f, -0.75f, -0.1745f, 0f, -0.4363f));
        add(m, "n333_pubis2", "n334_pubis2", ModelPartBuilder.create().uv(120, 41).cuboid(-3f, -19.25f, 13f, 2, 3, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1.75f, 16.1f, -17.25f, 0f, 0f, 0f));
        add(m, "n333_pubis2", "n335_pubis2", ModelPartBuilder.create().uv(132, 74).cuboid(-3.25f, -18f, 16.75f, 1, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1.75f, 16.1f, -17.25f, 0f, 0f, 0f));
        add(m, "n333_pubis2", "n336_pubis2", ModelPartBuilder.create().uv(206, 21).cuboid(-3.8f, -17.15f, 16.2f, 2, 7, 2, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(-1.75f, 16.1f, -17.25f, 0f, 0f, 0f));
        add(m, "n164_hium", "n337_ischium2", ModelPartBuilder.create(), ModelTransform.of(-3.25f, 1.4f, 4f, 0.6109f, 0f, -0.4363f));
        add(m, "n337_ischium2", "n338_ischium2", ModelPartBuilder.create().uv(70, 54).cuboid(-3.5f, -17.75f, 18.25f, 1, 1, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(2.25f, 16.6f, -22f, 0f, 0f, 0f));
        add(m, "n337_ischium2", "n339_ischium2", ModelPartBuilder.create().uv(114, 33).cuboid(-3f, -17.35f, 21.25f, 1, 7, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(2.25f, 16.6f, -22f, 0f, 0f, 0f));
        add(m, "n164_hium", "n340_rightFemur", ModelPartBuilder.create(), ModelTransform.of(-7f, 1.5f, 1f, -0.5236f, 0f, 0f));
        add(m, "n340_rightFemur", "n341_rightFemur", ModelPartBuilder.create().uv(80, 54).cuboid(-6.75f, -17.5f, 17.5f, 2, 2, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 16.5f, -19f, 0f, 0f, 0f));
        add(m, "n340_rightFemur", "n342_rightFemur", ModelPartBuilder.create().uv(152, 63).cuboid(-7.7f, -8.45f, 17.8f, 2, 2, 2, new Dilation(0.2f, 0.2f, 0.2f)), ModelTransform.of(6f, 16.5f, -19f, 0f, 0f, 0f));
        add(m, "n340_rightFemur", "n343_rightFemur", ModelPartBuilder.create().uv(176, 21).cuboid(-7.5f, -16.25f, 18f, 2, 8, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 16.5f, -19f, 0f, 0f, 0f));
        add(m, "n340_rightFemur", "n344_rightTibia", ModelPartBuilder.create(), ModelTransform.of(0f, 10f, 0.25f, 1.5708f, 0f, 0f));
        add(m, "n344_rightTibia", "n345_rightTibia", ModelPartBuilder.create().uv(160, 63).cuboid(-8f, -7.75f, 18.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 6.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n344_rightTibia", "n346_rightTibia", ModelPartBuilder.create().uv(168, 63).cuboid(-7.75f, 2.25f, 18.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 6.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n344_rightTibia", "n347_rightTibia", ModelPartBuilder.create().uv(222, 21).cuboid(-7.4f, -5.9f, 18.85f, 1, 8, 1, new Dilation(0.15f, 0.15f, 0.15f)), ModelTransform.of(6f, 6.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n344_rightTibia", "n348_rightTibia", ModelPartBuilder.create().uv(226, 21).cuboid(-8.25f, -5.75f, 18.25f, 1, 8, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 6.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n344_rightTibia", "n349_Foot4", ModelPartBuilder.create(), ModelTransform.of(0f, 11f, 0f, -2.3562f, 0f, 0f));
        add(m, "n349_Foot4", "n350_Foot4", ModelPartBuilder.create().uv(70, 48).cuboid(-8.25f, 3.25f, 18.5f, 3, 4, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n349_Foot4", "n351_Foot4", ModelPartBuilder.create().uv(178, 74).cuboid(-9f, 8.25f, 19f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n349_Foot4", "n352_Foot4", ModelPartBuilder.create().uv(182, 74).cuboid(-5.5f, 8.25f, 19f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n349_Foot4", "n353_Foot4", ModelPartBuilder.create().uv(186, 74).cuboid(-7.25f, 9f, 19f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n349_Foot4", "n354_Foot4", ModelPartBuilder.create().uv(54, 67).cuboid(-8.75f, 5.25f, 18.75f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n349_Foot4", "n355_Foot4", ModelPartBuilder.create().uv(58, 67).cuboid(-5.75f, 5.25f, 18.75f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n349_Foot4", "n356_Foot4", ModelPartBuilder.create().uv(62, 67).cuboid(-7.25f, 6f, 18.75f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n349_Foot4", "n357_Foot4", ModelPartBuilder.create().uv(56, 81).cuboid(-9f, 9.75f, 19.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n349_Foot4", "n358_Foot4", ModelPartBuilder.create().uv(60, 81).cuboid(-5.5f, 9.75f, 19.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, -4.5f, -19.25f, 0f, 0f, 0f));
        add(m, "n349_Foot4", "n359_Foot4", ModelPartBuilder.create().uv(64, 81).cuboid(-7.25f, 10.5f, 19.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, -4.5f, -19.25f, 0f, 0f, 0f));
    }

    private static void p6(Map<String, ModelPartData> m) {
        add(m, "n2_body", "n360_leftHumerus", ModelPartBuilder.create(), ModelTransform.of(6f, 0.5f, -6f, 0.3491f, 0f, 0f));
        add(m, "n360_leftHumerus", "n361_leftHumerus", ModelPartBuilder.create().uv(176, 63).cuboid(4.75f, -17.5f, -11.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 16.5f, 10f, 0f, 0f, 0f));
        add(m, "n360_leftHumerus", "n362_leftHumerus", ModelPartBuilder.create().uv(184, 63).cuboid(5.25f, -10.75f, -10.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 16.5f, 10f, 0f, 0f, 0f));
        add(m, "n360_leftHumerus", "n363_leftHumerus", ModelPartBuilder.create().uv(94, 33).cuboid(5.45f, -16.05f, -10.8f, 2, 6, 2, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(-6f, 16.5f, 10f, 0f, 0f, 0f));
        add(m, "n360_leftHumerus", "n364_scapula1", ModelPartBuilder.create(), ModelTransform.of(-3.75f, -2.5f, 4f, 0f, 0.8727f, 0.6981f));
        add(m, "n364_scapula1", "n365_scapula1", ModelPartBuilder.create().uv(90, 67).cuboid(1.25f, -19.75f, -7f, 7, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2.25f, 19f, 6f, 0f, 0f, 0f));
        add(m, "n364_scapula1", "n366_scapula1", ModelPartBuilder.create().uv(30, 71).cuboid(0.25f, -19.25f, -6f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2.25f, 19f, 6f, 0f, 0f, 0f));
        add(m, "n360_leftHumerus", "n367_leftRadiusulna", ModelPartBuilder.create(), ModelTransform.of(0f, 8f, 0.25f, -0.7854f, 0f, 0f));
        add(m, "n367_leftRadiusulna", "n368_leftRadiusulna", ModelPartBuilder.create().uv(192, 63).cuboid(6f, -9.75f, -10.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 8.5f, 9.75f, 0f, 0f, 0f));
        add(m, "n367_leftRadiusulna", "n369_leftRadiusulna", ModelPartBuilder.create().uv(200, 63).cuboid(5.75f, -2.25f, -11f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 8.5f, 9.75f, 0f, 0f, 0f));
        add(m, "n367_leftRadiusulna", "n370_leftRadiusulna", ModelPartBuilder.create().uv(118, 33).cuboid(5.65f, -8.25f, -10.25f, 1, 7, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 8.5f, 9.75f, 0f, 0f, 0f));
        add(m, "n367_leftRadiusulna", "n371_leftRadiusulna", ModelPartBuilder.create().uv(122, 33).cuboid(6.9f, -8.25f, -10.75f, 1, 7, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 8.5f, 9.75f, 0f, 0f, 0f));
        add(m, "n367_leftRadiusulna", "n372_Foot1", ModelPartBuilder.create(), ModelTransform.of(0f, 8.5f, 0f, -1.1345f, 0f, 0f));
        add(m, "n372_Foot1", "n373_Foot1", ModelPartBuilder.create().uv(80, 48).cuboid(5.25f, -1.25f, -10.5f, 3, 4, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n372_Foot1", "n374_Foot1", ModelPartBuilder.create().uv(190, 74).cuboid(8f, 3f, -10f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n372_Foot1", "n375_Foot1", ModelPartBuilder.create().uv(194, 74).cuboid(4.75f, 2.75f, -10f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n372_Foot1", "n376_Foot1", ModelPartBuilder.create().uv(198, 74).cuboid(6.55f, 3.75f, -10f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n372_Foot1", "n377_Foot1", ModelPartBuilder.create().uv(66, 67).cuboid(7.75f, 0.75f, -10.25f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n372_Foot1", "n378_Foot1", ModelPartBuilder.create().uv(70, 67).cuboid(5f, 0.5f, -10.25f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n372_Foot1", "n379_Foot1", ModelPartBuilder.create().uv(74, 67).cuboid(6.4f, 1.5f, -10.25f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n372_Foot1", "n380_Foot1", ModelPartBuilder.create().uv(68, 81).cuboid(8f, 4.5f, -9.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n372_Foot1", "n381_Foot1", ModelPartBuilder.create().uv(72, 81).cuboid(4.75f, 4.25f, -9.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n372_Foot1", "n382_Foot1", ModelPartBuilder.create().uv(76, 81).cuboid(6.55f, 5.25f, -9.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n2_body", "n383_rightHumerus", ModelPartBuilder.create(), ModelTransform.of(-6f, 0.5f, -6f, 0.3491f, 0f, 0f));
        add(m, "n383_rightHumerus", "n384_rightHumerus", ModelPartBuilder.create().uv(208, 63).cuboid(-6.75f, -17.5f, -11.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 16.5f, 10f, 0f, 0f, 0f));
        add(m, "n383_rightHumerus", "n385_rightHumerus", ModelPartBuilder.create().uv(216, 63).cuboid(-7.25f, -10.75f, -10.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 16.5f, 10f, 0f, 0f, 0f));
        add(m, "n383_rightHumerus", "n386_rightHumerus", ModelPartBuilder.create().uv(102, 33).cuboid(-7.05f, -16.05f, -10.8f, 2, 6, 2, new Dilation(-0.2f, -0.2f, -0.2f)), ModelTransform.of(6f, 16.5f, 10f, 0f, 0f, 0f));
        add(m, "n383_rightHumerus", "n387_scapula4", ModelPartBuilder.create(), ModelTransform.of(3.75f, -2.5f, 4f, 0f, -0.8727f, -0.6981f));
        add(m, "n387_scapula4", "n388_scapula4", ModelPartBuilder.create().uv(108, 67).cuboid(-8.25f, -19.75f, -7f, 7, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(2.25f, 19f, 6f, 0f, 0f, 0f));
        add(m, "n387_scapula4", "n389_scapula4", ModelPartBuilder.create().uv(40, 71).cuboid(-3.25f, -19.25f, -6f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(2.25f, 19f, 6f, 0f, 0f, 0f));
        add(m, "n383_rightHumerus", "n390_rightRadiusulna", ModelPartBuilder.create(), ModelTransform.of(0f, 8f, 0.25f, -0.7854f, 0f, 0f));
        add(m, "n390_rightRadiusulna", "n391_rightRadiusulna", ModelPartBuilder.create().uv(224, 63).cuboid(-8f, -9.75f, -10.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 8.5f, 9.75f, 0f, 0f, 0f));
        add(m, "n390_rightRadiusulna", "n392_rightRadiusulna", ModelPartBuilder.create().uv(232, 63).cuboid(-7.75f, -2.25f, -11f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 8.5f, 9.75f, 0f, 0f, 0f));
        add(m, "n390_rightRadiusulna", "n393_rightRadiusulna", ModelPartBuilder.create().uv(126, 33).cuboid(-6.65f, -8.25f, -10.25f, 1, 7, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 8.5f, 9.75f, 0f, 0f, 0f));
        add(m, "n390_rightRadiusulna", "n394_rightRadiusulna", ModelPartBuilder.create().uv(130, 33).cuboid(-7.9f, -8.25f, -10.75f, 1, 7, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 8.5f, 9.75f, 0f, 0f, 0f));
        add(m, "n390_rightRadiusulna", "n395_Foot2", ModelPartBuilder.create(), ModelTransform.of(0f, 8.5f, 0f, -1.1345f, 0f, 0f));
        add(m, "n395_Foot2", "n396_Foot2", ModelPartBuilder.create().uv(90, 48).cuboid(-8.25f, -1.25f, -10.5f, 3, 4, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n395_Foot2", "n397_Foot2", ModelPartBuilder.create().uv(202, 74).cuboid(-9f, 3f, -10f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n395_Foot2", "n398_Foot2", ModelPartBuilder.create().uv(206, 74).cuboid(-5.75f, 2.75f, -10f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n395_Foot2", "n399_Foot2", ModelPartBuilder.create().uv(210, 74).cuboid(-7.55f, 3.75f, -10f, 1, 2, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n395_Foot2", "n400_Foot2", ModelPartBuilder.create().uv(78, 67).cuboid(-8.75f, 0.75f, -10.25f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n395_Foot2", "n401_Foot2", ModelPartBuilder.create().uv(82, 67).cuboid(-6f, 0.5f, -10.25f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n395_Foot2", "n402_Foot2", ModelPartBuilder.create().uv(86, 67).cuboid(-7.4f, 1.5f, -10.25f, 1, 3, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n395_Foot2", "n403_Foot2", ModelPartBuilder.create().uv(80, 81).cuboid(-9f, 4.5f, -9.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n395_Foot2", "n404_Foot2", ModelPartBuilder.create().uv(84, 81).cuboid(-5.75f, 4.25f, -9.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n395_Foot2", "n405_Foot2", ModelPartBuilder.create().uv(88, 81).cuboid(-7.55f, 5.25f, -9.5f, 1, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(6f, 0f, 9.75f, 0f, 0f, 0f));
        add(m, "n2_body", "n406_leftWing", ModelPartBuilder.create(), ModelTransform.of(5.5f, -3.5f, 0f, -0.3491f, 0f, 1.5708f));
        add(m, "n406_leftWing", "n407_leftWing", ModelPartBuilder.create().uv(100, 48).cuboid(4.25f, -22.5f, -5.5f, 2, 3, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(-5.5f, 20.5f, 4f, 0f, 0f, 0f));
        add(m, "n406_leftWing", "n408_leftWing", ModelPartBuilder.create().uv(232, 0).cuboid(3.25f, -32.5f, -5f, 2, 12, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-5.5f, 20.5f, 4f, 0f, 0f, 0f));
        add(m, "n406_leftWing", "n409_leftRadiusulna2", ModelPartBuilder.create(), ModelTransform.of(-1.5f, -11.5f, -0.25f, 0.9599f, 0f, 0f));
        add(m, "n409_leftRadiusulna2", "n410_leftRadiusulna2", ModelPartBuilder.create().uv(136, 0).cuboid(4.14f, -40.01f, -4.26f, 1, 9, 5, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(-4f, 32f, 4.25f, 0f, 0f, 0f));
        add(m, "n409_leftRadiusulna2", "n411_leftRadiusulna2", ModelPartBuilder.create().uv(240, 63).cuboid(4f, -33.25f, -5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-4f, 32f, 4.25f, 0f, 0f, 0f));
        add(m, "n409_leftRadiusulna2", "n412_leftRadiusulna2", ModelPartBuilder.create().uv(248, 63).cuboid(3.75f, -48.75f, -5.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-4f, 32f, 4.25f, 0f, 0f, 0f));
        add(m, "n409_leftRadiusulna2", "n413_leftRadiusulna2", ModelPartBuilder.create().uv(104, 0).cuboid(3.65f, -47.75f, -4.25f, 1, 15, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-4f, 32f, 4.25f, 0f, 0f, 0f));
        add(m, "n409_leftRadiusulna2", "n414_leftRadiusulna2", ModelPartBuilder.create().uv(108, 0).cuboid(4.9f, -47.75f, -5.25f, 1, 15, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-4f, 32f, 4.25f, 0f, 0f, 0f));
        add(m, "n409_leftRadiusulna2", "n415_leftPhanlange1", ModelPartBuilder.create(), ModelTransform.of(1f, -16.5f, 0.25f, -0.8727f, 0.0873f, 0f));
        add(m, "n415_leftPhanlange1", "n416_leftPhanlange1", ModelPartBuilder.create().uv(112, 0).cuboid(4.65f, -63.25f, -4.5f, 1, 15, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-5f, 48.5f, 4f, 0f, 0f, 0f));
        add(m, "n415_leftPhanlange1", "n417_leftPhanlange1", ModelPartBuilder.create().uv(56, 0).cuboid(5.0889f, -64.28f, -3.4932f, 1, 13, 3, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(-5f, 48.5f, 4f, 0f, 0f, 0f));
        add(m, "n415_leftPhanlange1", "n418_leftPhanlange2", ModelPartBuilder.create(), ModelTransform.of(-0.75f, 1f, 0f, -0.4363f, 0f, 0f));
        add(m, "n418_leftPhanlange2", "n419_leftPhanlange2", ModelPartBuilder.create().uv(40, 0).cuboid(3.9f, -66.25f, -4.5f, 1, 19, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-4.25f, 47.5f, 4f, 0f, 0f, 0f));
    }

    private static void p7(Map<String, ModelPartData> m) {
        add(m, "n418_leftPhanlange2", "n420_leftPhanlange2", ModelPartBuilder.create().uv(36, 48).cuboid(3.4f, -49.25f, -7.75f, 2, 2, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(-4.25f, 47.5f, 4f, 0f, 0f, 0f));
        add(m, "n418_leftPhanlange2", "n421_leftPhanlange2", ModelPartBuilder.create().uv(64, 0).cuboid(4.39f, -66.26f, -3.51f, 1, 13, 3, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(-4.25f, 47.5f, 4f, 0f, 0f, 0f));
        add(m, "n418_leftPhanlange2", "n422_bone2", ModelPartBuilder.create(), ModelTransform.of(0f, -19f, 0f, -0.3491f, 0f, 0f));
        add(m, "n422_bone2", "n423_bone2", ModelPartBuilder.create().uv(44, 0).cuboid(3.9f, -85.25f, -4.5f, 1, 19, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-4.25f, 66.5f, 4f, 0f, 0f, 0f));
        add(m, "n422_bone2", "n424_bone2", ModelPartBuilder.create().uv(0, 0).cuboid(4.14f, -83.26f, -3.51f, 1, 17, 4, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(-4.25f, 66.5f, 4f, 0f, 0f, 0f));
        add(m, "n422_bone2", "n425_bone2", ModelPartBuilder.create().uv(148, 0).cuboid(4.14f, -71.26f, -0.26f, 1, 9, 5, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(-4.25f, 66.5f, 4f, 0f, 0f, 0f));
        add(m, "n415_leftPhanlange1", "n426_leftPhanlange3", ModelPartBuilder.create(), ModelTransform.of(-0.75f, 1.25f, 0f, -1.0472f, 0f, 0f));
        add(m, "n426_leftPhanlange3", "n427_leftPhanlange3", ModelPartBuilder.create().uv(248, 0).cuboid(3.9f, -60f, -4.5f, 1, 13, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-4.25f, 47.25f, 4f, 0f, 0f, 0f));
        add(m, "n426_leftPhanlange3", "n428_leftPhanlange3", ModelPartBuilder.create().uv(222, 33).cuboid(3.9f, -46.75f, -13.5f, 1, 1, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(-4.25f, 47.25f, 4f, 0f, 0f, 0f));
        add(m, "n426_leftPhanlange3", "n429_leftPhanlange3", ModelPartBuilder.create().uv(72, 0).cuboid(4.39f, -62.26f, -3.51f, 1, 13, 3, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(-4.25f, 47.25f, 4f, 0f, 0f, 0f));
        add(m, "n426_leftPhanlange3", "n430_leftPhanlange3", ModelPartBuilder.create().uv(160, 0).cuboid(4.14f, -58.76f, -0.51f, 1, 9, 5, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(-4.25f, 47.25f, 4f, 0f, 0f, 0f));
        add(m, "n426_leftPhanlange3", "n431_bone3", ModelPartBuilder.create(), ModelTransform.of(0f, -13f, 0f, -0.3491f, 0f, 0f));
        add(m, "n431_bone3", "n432_bone3", ModelPartBuilder.create().uv(0, 21).cuboid(3.9f, -71f, -4.5f, 1, 11, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-4.25f, 60.25f, 4f, 0f, 0f, 0f));
        add(m, "n415_leftPhanlange1", "n433_bone1", ModelPartBuilder.create(), ModelTransform.of(0f, -15f, 0f, -0.1745f, 0f, 0f));
        add(m, "n433_bone1", "n434_bone1", ModelPartBuilder.create().uv(116, 0).cuboid(4.65f, -78.25f, -4.5f, 1, 15, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-5f, 63.5f, 4f, 0f, 0f, 0f));
        add(m, "n433_bone1", "n435_bone1", ModelPartBuilder.create().uv(172, 0).cuboid(5.14f, -67.76f, -0.76f, 1, 9, 5, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(-5f, 63.5f, 4f, 0f, 0f, 0f));
        add(m, "n433_bone1", "n436_bone1", ModelPartBuilder.create().uv(10, 0).cuboid(5.14f, -77.76f, -4.01f, 1, 17, 4, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(-5f, 63.5f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n437_rightWing", ModelPartBuilder.create(), ModelTransform.of(-5.5f, -3.5f, 0f, -0.3491f, 0f, -1.5708f));
        add(m, "n437_rightWing", "n438_rightWing", ModelPartBuilder.create().uv(110, 48).cuboid(-6.25f, -22.5f, -5.5f, 2, 3, 3, new Dilation(0f, 0f, 0f)), ModelTransform.of(5.5f, 20.5f, 4f, 0f, 0f, 0f));
        add(m, "n437_rightWing", "n439_rightWing", ModelPartBuilder.create().uv(240, 0).cuboid(-5.25f, -32.5f, -5f, 2, 12, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(5.5f, 20.5f, 4f, 0f, 0f, 0f));
        add(m, "n437_rightWing", "n440_rightRadiusulna3", ModelPartBuilder.create(), ModelTransform.of(1.5f, -11.5f, -0.25f, 0.9599f, 0f, 0f));
        add(m, "n440_rightRadiusulna3", "n441_rightRadiusulna3", ModelPartBuilder.create().uv(184, 0).cuboid(-4.86f, -40.01f, -4.26f, 1, 9, 5, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(4f, 32f, 4.25f, 0f, 0f, 0f));
        add(m, "n440_rightRadiusulna3", "n442_rightRadiusulna3", ModelPartBuilder.create().uv(0, 67).cuboid(-6f, -33.25f, -5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(4f, 32f, 4.25f, 0f, 0f, 0f));
        add(m, "n440_rightRadiusulna3", "n443_rightRadiusulna3", ModelPartBuilder.create().uv(8, 67).cuboid(-5.75f, -48.75f, -5.5f, 2, 2, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(4f, 32f, 4.25f, 0f, 0f, 0f));
        add(m, "n440_rightRadiusulna3", "n444_rightRadiusulna3", ModelPartBuilder.create().uv(120, 0).cuboid(-4.65f, -47.75f, -4.25f, 1, 15, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(4f, 32f, 4.25f, 0f, 0f, 0f));
        add(m, "n440_rightRadiusulna3", "n445_rightRadiusulna3", ModelPartBuilder.create().uv(124, 0).cuboid(-5.9f, -47.75f, -5.25f, 1, 15, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(4f, 32f, 4.25f, 0f, 0f, 0f));
        add(m, "n440_rightRadiusulna3", "n446_rightPhanlange4", ModelPartBuilder.create(), ModelTransform.of(-1f, -16.5f, 0.25f, -0.8727f, -0.0873f, 0f));
        add(m, "n446_rightPhanlange4", "n447_rightPhanlange4", ModelPartBuilder.create().uv(128, 0).cuboid(-5.65f, -63.25f, -4.5f, 1, 15, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(5f, 48.5f, 4f, 0f, 0f, 0f));
        add(m, "n446_rightPhanlange4", "n448_rightPhanlange4", ModelPartBuilder.create().uv(80, 0).cuboid(-5.1089f, -64.28f, -3.4932f, 1, 13, 3, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(5f, 48.5f, 4f, 0f, 0f, 0f));
        add(m, "n446_rightPhanlange4", "n449_rightPhanlange5", ModelPartBuilder.create(), ModelTransform.of(0.75f, 1f, 0f, -0.4363f, 0f, 0f));
        add(m, "n449_rightPhanlange5", "n450_rightPhanlange5", ModelPartBuilder.create().uv(48, 0).cuboid(-4.9f, -66.25f, -4.5f, 1, 19, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(4.25f, 47.5f, 4f, 0f, 0f, 0f));
        add(m, "n449_rightPhanlange5", "n451_rightPhanlange5", ModelPartBuilder.create().uv(48, 48).cuboid(-5.4f, -49.25f, -7.75f, 2, 2, 4, new Dilation(0f, 0f, 0f)), ModelTransform.of(4.25f, 47.5f, 4f, 0f, 0f, 0f));
        add(m, "n449_rightPhanlange5", "n452_rightPhanlange5", ModelPartBuilder.create().uv(88, 0).cuboid(-4.41f, -66.26f, -3.51f, 1, 13, 3, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(4.25f, 47.5f, 4f, 0f, 0f, 0f));
        add(m, "n449_rightPhanlange5", "n453_bone4", ModelPartBuilder.create(), ModelTransform.of(0f, -19f, 0f, -0.3491f, 0f, 0f));
        add(m, "n453_bone4", "n454_bone4", ModelPartBuilder.create().uv(52, 0).cuboid(-4.9f, -85.25f, -4.5f, 1, 19, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(4.25f, 66.5f, 4f, 0f, 0f, 0f));
        add(m, "n453_bone4", "n455_bone4", ModelPartBuilder.create().uv(20, 0).cuboid(-4.16f, -83.26f, -3.51f, 1, 17, 4, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(4.25f, 66.5f, 4f, 0f, 0f, 0f));
        add(m, "n453_bone4", "n456_bone4", ModelPartBuilder.create().uv(196, 0).cuboid(-4.16f, -71.26f, 0.49f, 1, 9, 5, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(4.25f, 66.5f, 4f, 0f, 0f, 0f));
        add(m, "n446_rightPhanlange4", "n457_rightPhanlange6", ModelPartBuilder.create(), ModelTransform.of(0.75f, 1.25f, 0f, -1.0472f, 0f, 0f));
        add(m, "n457_rightPhanlange6", "n458_rightPhanlange6", ModelPartBuilder.create().uv(252, 0).cuboid(-4.9f, -60f, -4.5f, 1, 13, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(4.25f, 47.25f, 4f, 0f, 0f, 0f));
        add(m, "n457_rightPhanlange6", "n459_rightPhanlange6", ModelPartBuilder.create().uv(236, 33).cuboid(-4.9f, -46.75f, -13.5f, 1, 1, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(4.25f, 47.25f, 4f, 0f, 0f, 0f));
        add(m, "n457_rightPhanlange6", "n460_rightPhanlange6", ModelPartBuilder.create().uv(96, 0).cuboid(-4.41f, -62.26f, -3.51f, 1, 13, 3, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(4.25f, 47.25f, 4f, 0f, 0f, 0f));
        add(m, "n457_rightPhanlange6", "n461_rightPhanlange6", ModelPartBuilder.create().uv(208, 0).cuboid(-4.16f, -59.26f, -0.51f, 1, 9, 5, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(4.25f, 47.25f, 4f, 0f, 0f, 0f));
        add(m, "n457_rightPhanlange6", "n462_bone5", ModelPartBuilder.create(), ModelTransform.of(0f, -13f, 0f, -0.3491f, 0f, 0f));
        add(m, "n462_bone5", "n463_bone5", ModelPartBuilder.create().uv(4, 21).cuboid(-4.9f, -71f, -4.5f, 1, 11, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(4.25f, 60.25f, 4f, 0f, 0f, 0f));
        add(m, "n446_rightPhanlange4", "n464_bone6", ModelPartBuilder.create(), ModelTransform.of(0f, -15f, 0f, -0.1745f, 0f, 0f));
        add(m, "n464_bone6", "n465_bone6", ModelPartBuilder.create().uv(132, 0).cuboid(-5.65f, -78.25f, -4.5f, 1, 15, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(5f, 63.5f, 4f, 0f, 0f, 0f));
        add(m, "n464_bone6", "n466_bone6", ModelPartBuilder.create().uv(220, 0).cuboid(-5.16f, -70.26f, -0.01f, 1, 9, 5, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(5f, 63.5f, 4f, 0f, 0f, 0f));
        add(m, "n464_bone6", "n467_bone6", ModelPartBuilder.create().uv(30, 0).cuboid(-5.16f, -77.76f, -4.01f, 1, 17, 4, new Dilation(-0.49f, 0.01f, 0.01f)), ModelTransform.of(5f, 63.5f, 4f, 0f, 0f, 0f));
        add(m, "n2_body", "n468_sternum", ModelPartBuilder.create(), ModelTransform.of(0f, 6.5f, -6f, -0.4363f, 0f, 0f));
        add(m, "n468_sternum", "n469_sternum", ModelPartBuilder.create().uv(18, 33).cuboid(-1f, -11.5f, -12f, 2, 2, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 10.5f, 10f, 0f, 0f, 0f));
        add(m, "n468_sternum", "n470_sternum", ModelPartBuilder.create().uv(184, 21).cuboid(-0.5f, -11f, -9f, 1, 3, 6, new Dilation(0f, 0f, 0f)), ModelTransform.of(0f, 10.5f, 10f, 0f, 0f, 0f));
        add(m, "n468_sternum", "n471_clavicle1", ModelPartBuilder.create(), ModelTransform.of(1f, 0f, 0f, 0f, 0f, -0.6109f));
        add(m, "n471_clavicle1", "n472_clavicle1", ModelPartBuilder.create().uv(126, 67).cuboid(0f, -11.25f, -11f, 7, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1f, 10.5f, 10f, 0f, 0f, 0f));
        add(m, "n471_clavicle1", "n473_clavicle1", ModelPartBuilder.create().uv(52, 79).cuboid(-0.5f, -10.5f, -5.5f, 5, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1f, 10.5f, 10f, 0f, 0f, 0f));
        add(m, "n471_clavicle1", "n474_clavicle1", ModelPartBuilder.create().uv(116, 79).cuboid(-0.5f, -10.75f, -3.5f, 4, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1f, 10.5f, 10f, 0f, 0f, 0f));
        add(m, "n471_clavicle1", "n475_clavicle1", ModelPartBuilder.create().uv(126, 79).cuboid(0.25f, -11.75f, -1.5f, 4, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(-1f, 10.5f, 10f, 0f, 0f, 0f));
        add(m, "n468_sternum", "n476_clavicle2", ModelPartBuilder.create(), ModelTransform.of(-1f, 0f, 0f, 0f, 0f, 0.6109f));
        add(m, "n476_clavicle2", "n477_clavicle2", ModelPartBuilder.create().uv(144, 67).cuboid(-7f, -11.25f, -11f, 7, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(1f, 10.5f, 10f, 0f, 0f, 0f));
        add(m, "n476_clavicle2", "n478_clavicle2", ModelPartBuilder.create().uv(64, 79).cuboid(-4.5f, -10.5f, -5.5f, 5, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(1f, 10.5f, 10f, 0f, 0f, 0f));
        add(m, "n476_clavicle2", "n479_clavicle2", ModelPartBuilder.create().uv(136, 79).cuboid(-3.5f, -10.75f, -3.5f, 4, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(1f, 10.5f, 10f, 0f, 0f, 0f));
    }

    private static void p8(Map<String, ModelPartData> m) {
        add(m, "n476_clavicle2", "n480_clavicle2", ModelPartBuilder.create().uv(146, 79).cuboid(-4.25f, -11.75f, -1.5f, 4, 1, 1, new Dilation(0f, 0f, 0f)), ModelTransform.of(1f, 10.5f, 10f, 0f, 0f, 0f));
        add(m, "n2_body", "n481_scapula2", ModelPartBuilder.create(), ModelTransform.of(2.25f, -5f, 5f, -0.2618f, 0.9599f, 0.8727f));
        add(m, "n481_scapula2", "n482_scapula2", ModelPartBuilder.create().uv(162, 67).cuboid(1.25f, -22.75f, 0f, 7, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2.25f, 22f, -1f, 0f, 0f, 0f));
        add(m, "n481_scapula2", "n483_scapula2", ModelPartBuilder.create().uv(50, 71).cuboid(0.25f, -22.25f, 1f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(-2.25f, 22f, -1f, 0f, 0f, 0f));
        add(m, "n2_body", "n484_scapula3", ModelPartBuilder.create(), ModelTransform.of(-2.25f, -5f, 5f, -0.2618f, -0.9599f, -0.8727f));
        add(m, "n484_scapula3", "n485_scapula3", ModelPartBuilder.create().uv(180, 67).cuboid(-8.25f, -22.75f, 0f, 7, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(2.25f, 22f, -1f, 0f, 0f, 0f));
        add(m, "n484_scapula3", "n486_scapula3", ModelPartBuilder.create().uv(60, 71).cuboid(-3.25f, -22.25f, 1f, 3, 1, 2, new Dilation(0f, 0f, 0f)), ModelTransform.of(2.25f, 22f, -1f, 0f, 0f, 0f));
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
