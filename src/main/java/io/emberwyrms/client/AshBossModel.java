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
 * GENERADO por tools/rig_emit.py a partir de un modelo de Blockbench (The Warrior (Sketchfab)).
 * Geometria y textura convertidas; los movimientos (cuello, cola, alas, patas...) son propios del mod.
 */
public class AshBossModel extends EntityModel<AshwingRenderState> {
    private final ModelPart[] bones;
    private static final float[][] REST = {{0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0.516f, 0.0649f, 0.2376f}, {0.516f, -0.0649f, -0.2376f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}};
    private static final int HEAD = 0, JAW = -1;
    private static final int[] NECK = {1}, TAIL = {2, 3}, HAIR = {};
    private static final int[][] WING = {{4}, {5}};
    private static final float[] WSIGN = {-1f, 1f};
    private static final int[][] LEG = {{6}, {7}, {8}, {9}};
    private static final float[] LPHASE = {0f, 1f, 1f, 0f};
    private static final float FOLD = 0.9f, FOLD_YAW = 0.8f, FOLD_TIP = 1.2f, FOLD_ROLL = 0.3f, FLAP = 0.75f, TAIL_AMP = 1f, LEG_AMP = 0.6f;

    public AshBossModel(ModelPart root) {
        super(root);
        this.bones = new ModelPart[] {
            root.getChild("n0_x").getChild("n1_THE_WARRIOR").getChild("n2_Body").getChild("n21_bone8").getChild("n25_bone9"),
            root.getChild("n0_x").getChild("n1_THE_WARRIOR").getChild("n2_Body").getChild("n21_bone8"),
            root.getChild("n0_x").getChild("n1_THE_WARRIOR").getChild("n210_bone7"),
            root.getChild("n0_x").getChild("n1_THE_WARRIOR").getChild("n210_bone7").getChild("n268_Tail"),
            root.getChild("n0_x").getChild("n1_THE_WARRIOR").getChild("n2_Body").getChild("n95_Wing_left"),
            root.getChild("n0_x").getChild("n1_THE_WARRIOR").getChild("n2_Body").getChild("n108_Wing_right"),
            root.getChild("n0_x").getChild("n1_THE_WARRIOR").getChild("n2_Body").getChild("n58_Leg"),
            root.getChild("n0_x").getChild("n1_THE_WARRIOR").getChild("n2_Body").getChild("n173_Leg2"),
            root.getChild("n0_x").getChild("n1_THE_WARRIOR").getChild("n2_Body").getChild("n121_Leg3"),
            root.getChild("n0_x").getChild("n1_THE_WARRIOR").getChild("n2_Body").getChild("n147_Leg4")
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
        return TexturedModelData.of(data, 1024, 1024);
    }

    private static void add(Map<String, ModelPartData> m, String parent, String name, ModelPartBuilder b, ModelTransform t) {
        m.put(name, m.get(parent).addChild(name, b, t));
    }

    private static void p0(Map<String, ModelPartData> m) {
        add(m, "", "n0_x", ModelPartBuilder.create(), ModelTransform.of(0f, 23.9124f, 0f, 0f, 0f, 0f));
        add(m, "n0_x", "n1_THE_WARRIOR", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "n1_THE_WARRIOR", "n2_Body", ModelPartBuilder.create(), ModelTransform.of(0f, -68.4f, 115.2f, 0f, 0f, 0f));
        add(m, "n2_Body", "n3_cube", ModelPartBuilder.create().uv(168, 0).cuboid(-34.5946f, -81.5443f, -1.2355f, 69, 27, 116, new Dilation(0.0946f, 0.0907f, 0.0694f)), ModelTransform.of(0f, 68.4f, -115.2f, 0f, 0f, 0f));
        add(m, "n2_Body", "n4_cube", ModelPartBuilder.create().uv(562, 158).cuboid(-32.1235f, -54.3629f, 2.471f, 65, 4, 105, new Dilation(0.2413f, -0.1467f, 0.0096f)), ModelTransform.of(0f, 68.4f, -115.2f, 0f, 0f, 0f));
        add(m, "n2_Body", "n5_cube", ModelPartBuilder.create().uv(116, 589).cuboid(-29.6525f, -66.7181f, -18.5328f, 62, 19, 36, new Dilation(-0.112f, -0.2336f, -0.085f)), ModelTransform.of(0f, 68.4f, -115.2f, -0.4363f, 0f, 0f));
        add(m, "n2_Body", "n6_cube", ModelPartBuilder.create().uv(0, 527).cuboid(-23.4749f, -59.305f, 33.359f, 51, 19, 43, new Dilation(-0.1718f, -0.2336f, 0.1216f)), ModelTransform.of(0f, 68.4f, -115.2f, 0f, 0f, 0f));
        add(m, "n2_Body", "n7_cube", ModelPartBuilder.create().uv(124, 699).cuboid(-14.8262f, -59.305f, 76.6022f, 32, 15, 32, new Dilation(0.0618f, -0.0869f, 0.0618f)), ModelTransform.of(0f, 68.4f, -115.2f, 0f, 0f, 0f));
        add(m, "n2_Body", "n8_cube", ModelPartBuilder.create().uv(616, 589).cuboid(-21.0038f, -17.2973f, 34.5946f, 46, 17, 36, new Dilation(-0.1429f, 0.1486f, -0.085f)), ModelTransform.of(0f, 34.3965f, -113.872f, 0.0873f, 0f, 0f));
        add(m, "n2_Body", "n9_cube", ModelPartBuilder.create().uv(448, 589).cuboid(-22.2394f, -18.5328f, 70.4246f, 48, 17, 36, new Dilation(0.0926f, 0.1486f, -0.085f)), ModelTransform.of(0f, 34.3965f, -113.872f, 0.0873f, 0f, 0f));
        add(m, "n2_Body", "n10_cube", ModelPartBuilder.create().uv(538, 0).cuboid(-33.359f, -84.0154f, 0f, 67, 2, 112, new Dilation(-0.141f, 0.2355f, 0.2162f)), ModelTransform.of(0f, 68.4f, -115.2f, 0f, 0f, 0f));
        add(m, "n2_Body", "n11_cube", ModelPartBuilder.create().uv(220, 158).cuboid(-32.1235f, -86.4864f, 1.2355f, 64, 2, 107, new Dilation(0.1235f, 0.2355f, 0.2451f)), ModelTransform.of(0f, 68.4f, -115.2f, 0f, 0f, 0f));
        add(m, "n2_Body", "n12_cube", ModelPartBuilder.create().uv(216, 268).cuboid(-30.888f, -88.9574f, 2.471f, 62, 2, 103, new Dilation(-0.112f, 0.2355f, -0.2259f)), ModelTransform.of(0f, 68.4f, -115.2f, 0f, 0f, 0f));
        add(m, "n2_Body", "n13_cube", ModelPartBuilder.create().uv(784, 527).cuboid(-12.3552f, -97.6061f, 30.888f, 25, 9, 51, new Dilation(-0.1448f, -0.1757f, -0.1718f)), ModelTransform.of(0f, 68.4f, -115.2f, 0f, 0f, 0f));
        add(m, "n2_Body", "n14_cube", ModelPartBuilder.create().uv(312, 589).cuboid(-11.1197f, -119.8454f, 16.0618f, 22, 9, 46, new Dilation(0.1197f, -0.1757f, -0.1429f)), ModelTransform.of(0f, 78.3705f, -114.5719f, -0.1745f, 0f, 0f));
        add(m, "n2_Body", "n15_cube", ModelPartBuilder.create().uv(0, 647).cuboid(-9.8842f, -128.4941f, 21.0038f, 20, 9, 43, new Dilation(-0.1158f, -0.1757f, 0.1216f)), ModelTransform.of(0f, 78.3705f, -114.5719f, -0.1745f, 0f, 0f));
        add(m, "n2_Body", "n16_cube", ModelPartBuilder.create().uv(612, 647).cuboid(-8.6486f, -137.1427f, 27.1814f, 17, 9, 41, new Dilation(0.1486f, -0.1757f, -0.1139f)), ModelTransform.of(0f, 78.3705f, -114.5719f, -0.1745f, 0f, 0f));
        add(m, "n2_Body", "n17_cube", ModelPartBuilder.create().uv(920, 747).cuboid(-7.4131f, -145.7914f, 30.888f, 15, 9, 32, new Dilation(-0.0869f, -0.1757f, 0.0618f)), ModelTransform.of(0f, 78.3705f, -114.5719f, -0.1745f, 0f, 0f));
        add(m, "n2_Body", "n18_cube", ModelPartBuilder.create().uv(530, 790).cuboid(-6.1776f, -154.44f, 37.0656f, 12, 9, 28, new Dilation(0.1776f, -0.1757f, 0.2085f)), ModelTransform.of(0f, 78.3705f, -114.5719f, -0.1745f, 0f, 0f));
        add(m, "n2_Body", "n19_cube", ModelPartBuilder.create().uv(484, 894).cuboid(-6.1776f, -163.0886f, 48.1853f, 12, 9, 14, new Dilation(0.1776f, -0.1757f, -0.2046f)), ModelTransform.of(0f, 78.3705f, -114.5719f, -0.1745f, 0f, 0f));
        add(m, "n2_Body", "n20_cube", ModelPartBuilder.create().uv(832, 894).cuboid(-4.9421f, -96.3706f, 96.3706f, 10, 10, 10, new Dilation(-0.0579f, -0.0579f, -0.0579f)), ModelTransform.of(0f, 68.4f, -115.2f, 0f, 0f, 0f));
        add(m, "n2_Body", "n21_bone8", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, -115.6f, 0f, 0f, 0f));
        add(m, "n21_bone8", "n22_Neck", ModelPartBuilder.create(), ModelTransform.of(0f, 68.4f, 0.4f, 0f, 0f, 0f));
        add(m, "n22_Neck", "n23_cube", ModelPartBuilder.create().uv(774, 268).cuboid(-16.0618f, -30.888f, -44.4787f, 32, 32, 51, new Dilation(0.0618f, 0.0618f, -0.1718f)), ModelTransform.of(0f, -55.5984f, -1.2355f, -0.2618f, 0f, 0f));
        add(m, "n22_Neck", "n24_cube", ModelPartBuilder.create().uv(644, 376).cuboid(-14.8262f, -33.359f, -88.9574f, 30, 33, 44, new Dilation(-0.1738f, 0.1795f, 0.2394f)), ModelTransform.of(0f, -64.3514f, 12.4723f, 0.0436f, 0f, 0f));
        add(m, "n21_bone8", "n25_bone9", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 115.6f, 0f, 0f, 0f));
        add(m, "n25_bone9", "n26_Head", ModelPartBuilder.create(), ModelTransform.of(0f, -14.224f, -183.983f, 0.0436f, 0f, 0f));
        add(m, "n26_Head", "n27_cube", ModelPartBuilder.create().uv(0, 459).cuboid(-12.2564f, 91.9227f, -128.6918f, 25, 31, 37, new Dilation(-0.2436f, -0.1796f, -0.1155f)), ModelTransform.of(0f, -115.0093f, 90.8088f, 0f, 0f, 0f));
        add(m, "n26_Head", "n28_cube", ModelPartBuilder.create().uv(514, 459).cuboid(26.0448f, 99.5829f, -128.6918f, 12, 26, 37, new Dilation(0.1282f, 0.0224f, -0.1155f)), ModelTransform.of(-6.1241f, -115.0093f, 94.0219f, 0f, 0.1309f, 0f));
        add(m, "n26_Head", "n29_cube", ModelPartBuilder.create().uv(156, 863).cuboid(27.5768f, 111.8393f, -147.0763f, 11, 12, 18, new Dilation(-0.1378f, 0.1282f, 0.1923f)), ModelTransform.of(-8.1732f, -130.8502f, 78.4573f, 0.1309f, 0.1309f, 0f));
        add(m, "n26_Head", "n30_cube", ModelPartBuilder.create().uv(562, 863).cuboid(29.1089f, 111.8393f, -165.4608f, 9, 11, 18, new Dilation(0.0961f, -0.1378f, 0.1923f)), ModelTransform.of(2.6092f, -142.1596f, 67.9168f, 0.2202f, 0.2174f, 0.0117f));
        add(m, "n26_Head", "n31_cube", ModelPartBuilder.create().uv(616, 863).cuboid(-38.3011f, 111.8393f, -165.4608f, 9, 11, 18, new Dilation(0.0961f, -0.1378f, 0.1923f)), ModelTransform.of(-2.6092f, -142.1596f, 67.9168f, 0.2202f, -0.2174f, -0.0117f));
        add(m, "n26_Head", "n32_cube", ModelPartBuilder.create().uv(214, 863).cuboid(-38.3011f, 111.8393f, -147.0763f, 11, 12, 18, new Dilation(-0.1378f, 0.1282f, 0.1923f)), ModelTransform.of(8.1732f, -130.8502f, 78.4573f, 0.1309f, -0.1309f, 0f));
        add(m, "n26_Head", "n33_cube", ModelPartBuilder.create().uv(612, 459).cuboid(-38.3011f, 99.5829f, -128.6918f, 12, 26, 37, new Dilation(0.1282f, 0.0224f, -0.1155f)), ModelTransform.of(6.1241f, -115.0093f, 94.0219f, 0f, -0.1309f, 0f));
        add(m, "n26_Head", "n34_cube", ModelPartBuilder.create().uv(452, 699).cuboid(-12.2564f, 94.9868f, -108.7752f, 25, 26, 21, new Dilation(-0.2436f, 0.0224f, 0.2243f)), ModelTransform.of(0f, -126.0509f, 38.6554f, 0.1309f, 0f, 0f));
        add(m, "n26_Head", "n35_cube", ModelPartBuilder.create().uv(544, 699).cuboid(-24.5127f, 88.8586f, -140.9481f, 14, 21, 26, new Dilation(-0.1058f, 0.2243f, 0.0224f)), ModelTransform.of(18.3845f, -126.7171f, 38.363f, 0.2182f, 0f, 0f));
        add(m, "n26_Head", "n36_cube", ModelPartBuilder.create().uv(330, 376).cuboid(25.9459f, -181.6214f, -88.9574f, 9, 9, 70, new Dilation(-0.1757f, -0.1757f, 0.2123f)), ModelTransform.of(0f, 168.2707f, 58.6853f, -0.0903f, 0.2608f, -0.0233f));
        add(m, "n26_Head", "n37_cube", ModelPartBuilder.create().uv(0, 376).cuboid(2.9611f, -5.841f, -4.3237f, 9, 9, 74, new Dilation(-0.1757f, -0.1757f, 0.0656f)), ModelTransform.of(0f, -17.0573f, -3.0907f, 0.3155f, 0.2494f, 0.0804f));
        add(m, "n26_Head", "n38_cube", ModelPartBuilder.create().uv(166, 376).cuboid(-11.6097f, -5.841f, -3.0882f, 9, 9, 73, new Dilation(-0.1757f, -0.1757f, -0.0522f)), ModelTransform.of(0f, -17.0573f, -3.0907f, 0.3155f, -0.2494f, -0.0804f));
        add(m, "n26_Head", "n39_cube", ModelPartBuilder.create().uv(0, 158).cuboid(4.1218f, -9.5739f, -14.8331f, 9, 9, 101, new Dilation(-0.1757f, -0.1757f, 0.1563f)), ModelTransform.of(0f, -17.0573f, -3.0907f, 0.5387f, 0.2261f, 0.1332f));
        add(m, "n26_Head", "n40_cube", ModelPartBuilder.create().uv(0, 268).cuboid(-12.7704f, -9.5739f, -12.3621f, 9, 9, 99, new Dilation(-0.1757f, -0.1757f, -0.0792f)), ModelTransform.of(0f, -17.0573f, -3.0907f, 0.5387f, -0.2261f, -0.1332f));
        add(m, "n26_Head", "n41_cube", ModelPartBuilder.create().uv(488, 376).cuboid(-34.5946f, -181.6214f, -87.7219f, 9, 9, 69, new Dilation(-0.1757f, -0.1757f, 0.0946f)), ModelTransform.of(0f, 168.2707f, 58.6853f, -0.0903f, -0.2608f, 0.0233f));
        add(m, "n26_Head", "n42_cube", ModelPartBuilder.create().uv(252, 699).cuboid(-12.7704f, -13.2805f, -25.9528f, 9, 6, 41, new Dilation(-0.1757f, 0.0888f, -0.1139f)), ModelTransform.of(0f, -17.0573f, -3.0907f, 0.2769f, -0.2261f, -0.1332f));
        add(m, "n26_Head", "n43_cube", ModelPartBuilder.create().uv(352, 699).cuboid(4.1218f, -13.2805f, -25.9528f, 9, 6, 41, new Dilation(-0.1757f, 0.0888f, -0.1139f)), ModelTransform.of(0f, -17.0573f, -3.0907f, 0.2769f, 0.2261f, 0.1332f));
        add(m, "n26_Head", "n44_Jaw", ModelPartBuilder.create(), ModelTransform.of(2.6092f, 7.5428f, -15.2423f, -0.1745f, 0f, 0f));
        add(m, "n44_Jaw", "n45_cube", ModelPartBuilder.create().uv(96, 894).cuboid(-12.2564f, -96.5188f, -107.2431f, 25, 9, 17, new Dilation(-0.2436f, 0.0961f, -0.0738f)), ModelTransform.of(-2.6092f, 76.2176f, 101.0438f, 0.3491f, 0f, 0f));
        add(m, "n44_Jaw", "n46_cube", ModelPartBuilder.create().uv(0, 699).cuboid(-12.2564f, -122.5636f, -128.6918f, 25, 11, 37, new Dilation(-0.2436f, -0.1378f, -0.1155f)), ModelTransform.of(-2.6092f, 65.1761f, 153.1973f, 0.48f, 0f, 0f));
        add(m, "n44_Jaw", "n47_cube", ModelPartBuilder.create().uv(492, 863).cuboid(-24.5127f, -85.7945f, -136.352f, 14, 8, 21, new Dilation(-0.1058f, -0.1699f, 0.2243f)), ModelTransform.of(15.7753f, 76.8838f, 100.7515f, 0.2618f, 0f, 0f));
        add(m, "n44_Jaw", "n48_cube", ModelPartBuilder.create().uv(444, 747).cuboid(-39.5366f, -139.2184f, -115.101f, 11, 19, 24, new Dilation(0.0104f, -0.1348f, 0.2069f)), ModelTransform.of(3.5149f, 65.1761f, 156.4103f, 0.4835f, -0.116f, -0.0607f));
        add(m, "n44_Jaw", "n49_cube", ModelPartBuilder.create().uv(514, 747).cuboid(28.5158f, -139.2184f, -115.101f, 11, 19, 24, new Dilation(0.0104f, -0.1348f, 0.2069f)), ModelTransform.of(-8.7333f, 65.1761f, 156.4103f, 0.4835f, 0.116f, 0.0607f));
        add(m, "n44_Jaw", "n50_Left_jaw", ModelPartBuilder.create(), ModelTransform.of(-5.2184f, 10.5126f, 9.7914f, 0f, 0f, 0f));
        add(m, "n50_Left_jaw", "n51_cube", ModelPartBuilder.create().uv(670, 863).cuboid(-19.6934f, 0.5975f, -59.5093f, 9, 11, 18, new Dilation(0.0961f, -0.1378f, 0.1923f)), ModelTransform.of(0f, 0f, 0f, 0.2701f, -0.1979f, -0.0914f));
        add(m, "n50_Left_jaw", "n52_cube", ModelPartBuilder.create().uv(272, 863).cuboid(-15.9619f, -4.5619f, -43.5117f, 11, 12, 18, new Dilation(-0.1378f, 0.1282f, 0.1923f)), ModelTransform.of(0f, 0f, 0f, 0.3526f, -0.116f, -0.0607f));
        add(m, "n50_Left_jaw", "n53_cube", ModelPartBuilder.create().uv(126, 647).cuboid(-15.9619f, -9.4395f, -25.9166f, 12, 14, 37, new Dilation(0.1282f, -0.1058f, -0.1155f)), ModelTransform.of(0f, 0f, 0f, 0.4835f, -0.116f, -0.0607f));
        add(m, "n44_Jaw", "n54_Right_jaw", ModelPartBuilder.create(), ModelTransform.of(0f, 10.5126f, 9.7914f, 0f, 0f, 0f));
        add(m, "n54_Right_jaw", "n55_cube", ModelPartBuilder.create().uv(224, 647).cuboid(3.7055f, -9.4395f, -25.9166f, 12, 14, 37, new Dilation(0.1282f, -0.1058f, -0.1155f)), ModelTransform.of(0f, 0f, 0f, 0.4835f, 0.116f, 0.0607f));
        add(m, "n54_Right_jaw", "n56_cube", ModelPartBuilder.create().uv(330, 863).cuboid(5.2376f, -4.5619f, -43.5117f, 11, 12, 18, new Dilation(-0.1378f, 0.1282f, 0.1923f)), ModelTransform.of(0f, 0f, 0f, 0.3526f, 0.116f, 0.0607f));
        add(m, "n54_Right_jaw", "n57_cube", ModelPartBuilder.create().uv(724, 863).cuboid(10.5012f, 0.5975f, -59.5093f, 9, 11, 18, new Dilation(0.0961f, -0.1378f, 0.1923f)), ModelTransform.of(0f, 0f, 0f, 0.2701f, 0.1979f, 0.0914f));
        add(m, "n2_Body", "n58_Leg", ModelPartBuilder.create(), ModelTransform.of(46.9498f, -4.4f, -93.2f, 0f, 0f, 0f));
        add(m, "n58_Leg", "n59_cube", ModelPartBuilder.create().uv(728, 647).cuboid(32.3212f, -94.2702f, -44.4417f, 22, 27, 23, new Dilation(-0.2263f, -0.0328f, -0.0529f)), ModelTransform.of(-46.9498f, 72.8f, -22f, -0.6981f, 0f, 0f));
    }

    private static void p1(Map<String, ModelPartData> m) {
        add(m, "n58_Leg", "n60_cube", ModelPartBuilder.create().uv(238, 790).cuboid(33.6679f, -111.7775f, -43.0949f, 18, 18, 20, new Dilation(-0.2463f, -0.2463f, 0.1004f)), ModelTransform.of(-46.9498f, 72.8f, -22f, -0.6981f, 0f, 0f));
        add(m, "n58_Leg", "n61_cube", ModelPartBuilder.create().uv(778, 863).cuboid(36.3614f, -123.8979f, -40.4015f, 12, 12, 16, new Dilation(0.0602f, 0.0602f, 0.0803f)), ModelTransform.of(-46.9498f, 72.8f, -22f, -0.6981f, 0f, 0f));
        add(m, "n58_Leg", "n62_bone", ModelPartBuilder.create(), ModelTransform.of(2.817f, 55.7745f, -12.8324f, 0f, 0f, 0f));
        add(m, "n62_bone", "n63_cube", ModelPartBuilder.create().uv(836, 829).cuboid(-11.7869f, -49.7667f, -1.3097f, 13, 18, 14, new Dilation(0.0483f, 0.1676f, 0.2031f)), ModelTransform.of(2.4216f, 18.7957f, -18.7094f, -0.48f, 0f, 0f));
        add(m, "n62_bone", "n64_cube", ModelPartBuilder.create().uv(0, 829).cuboid(-13.0965f, -68.1019f, -1.3097f, 16, 18, 16, new Dilation(-0.1421f, 0.1676f, -0.1421f)), ModelTransform.of(2.4216f, 18.7957f, -18.7094f, -0.48f, 0f, 0f));
        add(m, "n62_bone", "n65_cube", ModelPartBuilder.create().uv(322, 942).cuboid(-1.3097f, -40.5992f, 5.2386f, 3, 10, 3, new Dilation(-0.1903f, 0.2386f, -0.1903f)), ModelTransform.of(-2.817f, 14.4062f, -9.1676f, -0.48f, 0f, 0f));
        add(m, "n62_bone", "n66_cube", ModelPartBuilder.create().uv(40, 922).cuboid(-1.3097f, -40.5992f, 7.8579f, 3, 16, 3, new Dilation(-0.1903f, -0.1421f, -0.1903f)), ModelTransform.of(-2.817f, 2.8621f, -17.6778f, -0.8727f, 0f, 0f));
        add(m, "n62_bone", "n67_cube", ModelPartBuilder.create().uv(234, 956).cuboid(-1.3097f, -40.5992f, 7.8579f, 3, 5, 3, new Dilation(-0.1903f, 0.1193f, -0.1903f)), ModelTransform.of(-2.817f, 14.4062f, -9.1676f, -0.48f, 0f, 0f));
        add(m, "n62_bone", "n68_cube", ModelPartBuilder.create().uv(722, 942).cuboid(-1.3097f, -40.5992f, 5.2386f, 3, 1, 8, new Dilation(-0.1903f, 0.1548f, -0.071f)), ModelTransform.of(-2.817f, 13.5944f, -9.6011f, -0.48f, 0f, 0f));
        add(m, "n62_bone", "n69_cube", ModelPartBuilder.create().uv(246, 956).cuboid(-1.3097f, -40.5992f, 7.8579f, 3, 5, 3, new Dilation(-0.1903f, 0.1193f, -0.1903f)), ModelTransform.of(-2.817f, 0f, 0f, -0.48f, 0f, 0f));
        add(m, "n62_bone", "n70_cube", ModelPartBuilder.create().uv(744, 942).cuboid(-1.3097f, -40.5992f, 5.2386f, 3, 1, 8, new Dilation(-0.1903f, 0.1548f, -0.071f)), ModelTransform.of(-2.817f, -0.8117f, -0.4335f, -0.48f, 0f, 0f));
        add(m, "n62_bone", "n71_cube", ModelPartBuilder.create().uv(334, 942).cuboid(-1.3097f, -40.5992f, 5.2386f, 3, 10, 3, new Dilation(-0.1903f, 0.2386f, -0.1903f)), ModelTransform.of(-2.817f, 0f, 0f, -0.48f, 0f, 0f));
        add(m, "n62_bone", "n72_cube", ModelPartBuilder.create().uv(52, 922).cuboid(-1.3097f, -40.5992f, 7.8579f, 3, 16, 3, new Dilation(-0.1903f, -0.1421f, -0.1903f)), ModelTransform.of(-2.817f, -11.544f, -8.5103f, -0.8727f, 0f, 0f));
        add(m, "n62_bone", "n73_cube", ModelPartBuilder.create().uv(180, 894).cuboid(-7.2031f, -40.5992f, 23.5737f, 14, 14, 12, new Dilation(0.2031f, 0.2031f, -0.1066f)), ModelTransform.of(-2.817f, 0f, 0f, 0.3054f, 0f, 0f));
        add(m, "n62_bone", "n74_cube", ModelPartBuilder.create().uv(128, 829).cuboid(-7.8579f, -72.0308f, 36.0154f, 16, 20, 14, new Dilation(-0.1421f, -0.1776f, 0.2031f)), ModelTransform.of(-2.817f, 17.0255f, -9.1676f, 0.3054f, 0f, 0f));
        add(m, "n62_bone", "n75_cube", ModelPartBuilder.create().uv(0, 790).cuboid(-13.0965f, -73.3405f, 34.7058f, 5, 22, 17, new Dilation(0.1193f, 0.132f, 0.0127f)), ModelTransform.of(-2.817f, 17.0255f, -9.1676f, 0.3054f, 0f, 0f));
        add(m, "n58_Leg", "n76_Foot", ModelPartBuilder.create(), ModelTransform.of(-0.5282f, 49.4543f, -12.6166f, 0f, 0f, 0f));
        add(m, "n76_Foot", "n77_cube", ModelPartBuilder.create().uv(388, 863).cuboid(-5.2386f, -27.5027f, -1.3097f, 13, 17, 13, new Dilation(0.0483f, 0.0127f, 0.0483f)), ModelTransform.of(-0.7815f, 23.2546f, -12.5946f, -0.3054f, 0f, 0f));
        add(m, "n76_Foot", "n78_cube", ModelPartBuilder.create().uv(520, 922).cuboid(-0.6548f, -5.2386f, -10.4772f, 4, 5, 9, new Dilation(-0.0355f, 0.1193f, 0.0838f)), ModelTransform.of(-0.7815f, 23.3457f, -9.3834f, 0f, 0f, 0f));
        add(m, "n76_Foot", "n79_cube", ModelPartBuilder.create().uv(130, 942).cuboid(-0.6548f, -5.2386f, -20.9544f, 4, 5, 8, new Dilation(-0.0355f, 0.1193f, -0.071f)), ModelTransform.of(-0.7815f, 33.0015f, -11.0127f, -0.829f, 0f, 0f));
        add(m, "n76_Foot", "n80_cube", ModelPartBuilder.create().uv(88, 922).cuboid(-3.2741f, -2.6193f, -19.6448f, 5, 13, 4, new Dilation(0.1193f, 0.0483f, -0.0355f)), ModelTransform.of(1.183f, 25.6f, -10.6896f, -0.829f, 0f, 0f));
        add(m, "n76_Foot", "n81_cube", ModelPartBuilder.create().uv(810, 942).cuboid(-3.2741f, -2.6193f, -19.6448f, 5, 5, 4, new Dilation(0.1193f, 0.1193f, -0.0355f)), ModelTransform.of(1.183f, 20.814f, -12.0412f, 0f, 0f, 0f));
        add(m, "n76_Foot", "n82_cube", ModelPartBuilder.create().uv(828, 942).cuboid(-2.6193f, -5.151f, -22.3026f, 5, 5, 4, new Dilation(0.1193f, 0.1193f, -0.0355f)), ModelTransform.of(4.4571f, 23.3457f, -8.0737f, 0f, -0.6545f, 0f));
        add(m, "n76_Foot", "n83_cube", ModelPartBuilder.create().uv(106, 922).cuboid(-2.6193f, -0.1333f, -18.8652f, 5, 13, 4, new Dilation(0.1193f, 0.0483f, -0.0355f)), ModelTransform.of(4.4571f, 23.3457f, -8.0737f, -0.829f, -0.6545f, 0f));
        add(m, "n76_Foot", "n84_cube", ModelPartBuilder.create().uv(154, 942).cuboid(-1.9645f, 2.486f, -14.9362f, 4, 5, 8, new Dilation(-0.0355f, 0.1193f, -0.071f)), ModelTransform.of(4.4571f, 23.3457f, -8.0737f, -0.829f, -0.6545f, 0f));
        add(m, "n76_Foot", "n85_cube", ModelPartBuilder.create().uv(546, 922).cuboid(-1.9645f, -5.2386f, -10.4772f, 4, 5, 9, new Dilation(-0.0355f, 0.1193f, 0.0838f)), ModelTransform.of(4.4571f, 23.3457f, -8.0737f, 0f, -0.6545f, 0f));
        add(m, "n76_Foot", "n86_cube", ModelPartBuilder.create().uv(846, 942).cuboid(-2.6193f, -5.151f, -22.3026f, 5, 5, 4, new Dilation(0.1193f, 0.1193f, -0.0355f)), ModelTransform.of(-3.4008f, 23.3457f, -8.0737f, 0f, 0.6545f, 0f));
        add(m, "n76_Foot", "n87_cube", ModelPartBuilder.create().uv(124, 922).cuboid(-2.6193f, -0.1333f, -18.8652f, 5, 13, 4, new Dilation(0.1193f, 0.0483f, -0.0355f)), ModelTransform.of(-3.4008f, 23.3457f, -8.0737f, -0.829f, 0.6545f, 0f));
        add(m, "n76_Foot", "n88_cube", ModelPartBuilder.create().uv(178, 942).cuboid(-1.9645f, 2.486f, -14.9362f, 4, 5, 8, new Dilation(-0.0355f, 0.1193f, -0.071f)), ModelTransform.of(-3.4008f, 23.3457f, -8.0737f, -0.829f, 0.6545f, 0f));
        add(m, "n76_Foot", "n89_cube", ModelPartBuilder.create().uv(572, 922).cuboid(-1.9645f, -5.2386f, -10.4772f, 4, 5, 9, new Dilation(-0.0355f, 0.1193f, 0.0838f)), ModelTransform.of(-3.4008f, 23.3457f, -8.0737f, 0f, 0.6545f, 0f));
        add(m, "n76_Foot", "n90_cube", ModelPartBuilder.create().uv(864, 942).cuboid(-3.2741f, -2.6193f, 15.7158f, 5, 5, 4, new Dilation(0.1193f, 0.1193f, -0.0355f)), ModelTransform.of(1.183f, 20.814f, 3.7517f, 0f, 0f, 0f));
        add(m, "n76_Foot", "n91_cube", ModelPartBuilder.create().uv(142, 922).cuboid(-3.2741f, -2.6193f, 15.7158f, 5, 13, 4, new Dilation(0.1193f, 0.0483f, -0.0355f)), ModelTransform.of(1.183f, 25.6f, 2.4f, 0.829f, 0f, 0f));
        add(m, "n76_Foot", "n92_cube", ModelPartBuilder.create().uv(202, 942).cuboid(-0.6548f, -5.2386f, 13.0965f, 4, 5, 8, new Dilation(-0.0355f, 0.1193f, -0.071f)), ModelTransform.of(-0.7815f, 33.0015f, 2.7232f, 0.829f, 0f, 0f));
        add(m, "n76_Foot", "n93_cube", ModelPartBuilder.create().uv(598, 922).cuboid(-0.6548f, -5.2386f, 1.3097f, 4, 5, 9, new Dilation(-0.0355f, 0.1193f, 0.0838f)), ModelTransform.of(-0.7815f, 23.3457f, 1.0938f, 0f, 0f, 0f));
        add(m, "n76_Foot", "n94_cube", ModelPartBuilder.create().uv(536, 894).cuboid(-5.2386f, -10.4772f, -1.3097f, 13, 10, 13, new Dilation(0.0483f, 0.2386f, 0.0483f)), ModelTransform.of(-0.7815f, 23.3457f, -9.3834f, 0f, 0f, 0f));
        add(m, "n2_Body", "n95_Wing_left", ModelPartBuilder.create(), ModelTransform.of(-33.359f, -35.5197f, -59.0054f, 0.516f, 0.0649f, 0.2376f));
        add(m, "n95_Wing_left", "n96_cube", ModelPartBuilder.create().uv(0, 0).cuboid(23.4749f, -286.6406f, 16.0618f, 21, 137, 21, new Dilation(0.0019f, 0.0714f, 0.0019f)), ModelTransform.of(23.2022f, 68.5103f, -62.0193f, -1.1586f, 0.8359f, -1.622f));
        add(m, "n95_Wing_left", "n97_cube", ModelPartBuilder.create().uv(322, 647).cuboid(23.4749f, -138.3782f, 16.0618f, 21, 30, 21, new Dilation(0.0019f, -0.1738f, 0.0019f)), ModelTransform.of(23.2022f, 68.5103f, -62.0193f, -1.1586f, 0.8359f, -1.622f));
        add(m, "n95_Wing_left", "n98_cube", ModelPartBuilder.create().uv(710, 459).cuboid(54.3629f, -138.3782f, 16.0618f, 21, 42, 21, new Dilation(0.0019f, 0.0038f, 0.0019f)), ModelTransform.of(23.2022f, 68.5103f, -62.0193f, -1.2893f, 0.2582f, -1.862f));
        add(m, "n95_Wing_left", "n99_cube", ModelPartBuilder.create().uv(644, 527).cuboid(61.776f, -177.9149f, 16.0618f, 14, 40, 21, new Dilation(-0.2046f, -0.2317f, 0.0019f)), ModelTransform.of(23.2022f, 68.5103f, -62.0193f, -1.2893f, 0.2582f, -1.862f));
        add(m, "n95_Wing_left", "n100_cube", ModelPartBuilder.create().uv(720, 829).cuboid(61.776f, -138.3782f, 18.5328f, 14, 17, 15, new Dilation(-0.2046f, 0.1486f, -0.0869f)), ModelTransform.of(23.2022f, 68.5103f, -62.0193f, -1.2987f, -0.0358f, -1.9456f));
        add(m, "n95_Wing_left", "n101_cube", ModelPartBuilder.create().uv(792, 376).cuboid(59.305f, -192.7411f, 18.5328f, 16, 54, 15, new Dilation(0.0309f, 0.1814f, -0.0869f)), ModelTransform.of(23.2022f, 68.5103f, -62.0193f, -1.2987f, -0.0358f, -1.9456f));
        add(m, "n95_Wing_left", "n102_cube", ModelPartBuilder.create().uv(624, 699).cuboid(63.0115f, -229.8067f, 21.0038f, 12, 37, 10, new Dilation(0.1776f, 0.0328f, -0.0579f)), ModelTransform.of(23.2022f, 68.5103f, -62.0193f, -1.2987f, -0.0358f, -1.9456f));
        add(m, "n95_Wing_left", "n103_cube", ModelPartBuilder.create().uv(584, 747).cuboid(54.3629f, -96.3706f, 16.0618f, 21, 21, 21, new Dilation(0.0019f, 0.0019f, 0.0019f)), ModelTransform.of(23.2022f, 68.5103f, -62.0193f, -1.2987f, -0.0358f, -1.9456f));
        add(m, "n95_Wing_left", "n104_cube", ModelPartBuilder.create().uv(668, 747).cuboid(54.3629f, -121.081f, 16.0618f, 21, 21, 21, new Dilation(0.0019f, 0.0019f, 0.0019f)), ModelTransform.of(23.2022f, 68.5103f, -62.0193f, -1.2987f, -0.0358f, -1.9456f));
        add(m, "n95_Wing_left", "n105_cube", ModelPartBuilder.create().uv(276, 747).cuboid(23.4749f, -308.88f, 16.0618f, 21, 22, 21, new Dilation(0.0019f, 0.1197f, 0.0019f)), ModelTransform.of(23.2022f, 68.5103f, -62.0193f, -1.1586f, 0.8359f, -1.622f));
        add(m, "n95_Wing_left", "n106_cube", ModelPartBuilder.create().uv(712, 699).cuboid(44.4787f, -308.88f, 16.0618f, 48, 22, 21, new Dilation(0.0926f, 0.1197f, 0.0019f)), ModelTransform.of(0.6335f, 126.0492f, 87.2261f, -0.5403f, 1.2522f, -0.9282f));
        add(m, "n95_Wing_left", "n107_cube", ModelPartBuilder.create().uv(850, 699).cuboid(44.4787f, -308.88f, 16.0618f, 48, 22, 21, new Dilation(0.0926f, 0.1197f, 0.0019f)), ModelTransform.of(27.4404f, 48.9597f, -101.2376f, -1.2582f, 0.5087f, -1.7795f));
        add(m, "n2_Body", "n108_Wing_right", ModelPartBuilder.create(), ModelTransform.of(33.359f, -36.7197f, -68.6054f, 0.516f, -0.0649f, -0.2376f));
        add(m, "n108_Wing_right", "n109_cube", ModelPartBuilder.create().uv(84, 0).cuboid(-44.4787f, -286.6406f, 16.0618f, 21, 137, 21, new Dilation(0.0019f, 0.0714f, 0.0019f)), ModelTransform.of(-22.8613f, 74.2608f, -54.2466f, -1.1586f, -0.8359f, 1.622f));
        add(m, "n108_Wing_right", "n110_cube", ModelPartBuilder.create().uv(360, 747).cuboid(-44.4787f, -308.88f, 16.0618f, 21, 22, 21, new Dilation(0.0019f, 0.1197f, 0.0019f)), ModelTransform.of(-22.8613f, 74.2608f, -54.2466f, -1.1586f, -0.8359f, 1.622f));
        add(m, "n108_Wing_right", "n111_cube", ModelPartBuilder.create().uv(0, 747).cuboid(-92.664f, -308.88f, 16.0618f, 48, 22, 21, new Dilation(0.0926f, 0.1197f, 0.0019f)), ModelTransform.of(-0.2926f, 131.7997f, 94.9989f, -0.5403f, -1.2522f, 0.9282f));
        add(m, "n108_Wing_right", "n112_cube", ModelPartBuilder.create().uv(138, 747).cuboid(-92.664f, -308.88f, 16.0618f, 48, 22, 21, new Dilation(0.0926f, 0.1197f, 0.0019f)), ModelTransform.of(-27.0994f, 54.7102f, -93.4649f, -1.2582f, -0.5087f, 1.7795f));
        add(m, "n108_Wing_right", "n113_cube", ModelPartBuilder.create().uv(406, 647).cuboid(-44.4787f, -138.3782f, 16.0618f, 21, 30, 21, new Dilation(0.0019f, -0.1738f, 0.0019f)), ModelTransform.of(-22.8613f, 74.2608f, -54.2466f, -1.1586f, -0.8359f, 1.622f));
        add(m, "n108_Wing_right", "n114_cube", ModelPartBuilder.create().uv(794, 459).cuboid(-75.3667f, -138.3782f, 16.0618f, 21, 42, 21, new Dilation(0.0019f, 0.0038f, 0.0019f)), ModelTransform.of(-22.8613f, 74.2608f, -54.2466f, -1.2893f, -0.2582f, 1.862f));
        add(m, "n108_Wing_right", "n115_cube", ModelPartBuilder.create().uv(714, 527).cuboid(-75.3667f, -177.9149f, 16.0618f, 14, 40, 21, new Dilation(-0.2046f, -0.2317f, 0.0019f)), ModelTransform.of(-22.8613f, 74.2608f, -54.2466f, -1.2893f, -0.2582f, 1.862f));
        add(m, "n108_Wing_right", "n116_cube", ModelPartBuilder.create().uv(752, 747).cuboid(-75.3667f, -96.3706f, 16.0618f, 21, 21, 21, new Dilation(0.0019f, 0.0019f, 0.0019f)), ModelTransform.of(-22.8613f, 74.2608f, -54.2466f, -1.2987f, 0.0358f, 1.9456f));
        add(m, "n108_Wing_right", "n117_cube", ModelPartBuilder.create().uv(778, 829).cuboid(-75.3667f, -138.3782f, 18.5328f, 14, 17, 15, new Dilation(-0.2046f, 0.1486f, -0.0869f)), ModelTransform.of(-22.8613f, 74.2608f, -54.2466f, -1.2987f, 0.0358f, 1.9456f));
        add(m, "n108_Wing_right", "n118_cube", ModelPartBuilder.create().uv(836, 747).cuboid(-75.3667f, -121.081f, 16.0618f, 21, 21, 21, new Dilation(0.0019f, 0.0019f, 0.0019f)), ModelTransform.of(-22.8613f, 74.2608f, -54.2466f, -1.2987f, 0.0358f, 1.9456f));
        add(m, "n108_Wing_right", "n119_cube", ModelPartBuilder.create().uv(854, 376).cuboid(-75.3667f, -192.7411f, 18.5328f, 16, 54, 15, new Dilation(0.0309f, 0.1814f, -0.0869f)), ModelTransform.of(-22.8613f, 74.2608f, -54.2466f, -1.2987f, 0.0358f, 1.9456f));
    }

    private static void p2(Map<String, ModelPartData> m) {
        add(m, "n108_Wing_right", "n120_cube", ModelPartBuilder.create().uv(668, 699).cuboid(-75.3667f, -229.8067f, 21.0038f, 12, 37, 10, new Dilation(0.1776f, 0.0328f, -0.0579f)), ModelTransform.of(-22.8613f, 74.2608f, -54.2466f, -1.2987f, 0.0358f, 1.9456f));
        add(m, "n2_Body", "n121_Leg3", ModelPartBuilder.create(), ModelTransform.of(-30.1498f, 0.8f, -13.5677f, 0f, 0f, 0f));
        add(m, "n121_Leg3", "n122_bone3", ModelPartBuilder.create(), ModelTransform.of(-16.8f, 51.5382f, -222.7133f, 0f, 0f, 0f));
        add(m, "n122_bone3", "n123_cube", ModelPartBuilder.create().uv(944, 829).cuboid(-1.2355f, -46.9498f, -12.3552f, 12, 17, 14, new Dilation(0.1776f, 0.1486f, -0.2046f)), ModelTransform.of(-4.9421f, 16.5317f, 254.6933f, 0.5672f, 0f, 0f));
        add(m, "n122_bone3", "n124_cube", ModelPartBuilder.create().uv(480, 829).cuboid(-2.471f, -63.0115f, -2.471f, 15, 17, 15, new Dilation(-0.0869f, 0.1486f, -0.0869f)), ModelTransform.of(-4.9421f, 17.7318f, 252.3992f, 0.7418f, 0f, 0f));
        add(m, "n122_bone3", "n125_cube", ModelPartBuilder.create().uv(284, 894).cuboid(-6.7954f, -33.359f, -32.1235f, 14, 14, 11, new Dilation(-0.2046f, -0.2046f, 0.0598f)), ModelTransform.of(0f, 0f, 234.7488f, -0.3054f, 0f, 0f));
        add(m, "n122_bone3", "n126_cube", ModelPartBuilder.create().uv(248, 829).cuboid(-7.4131f, -64.247f, -47.5675f, 15, 19, 14, new Dilation(-0.0869f, -0.2336f, -0.2046f)), ModelTransform.of(0f, 16.0618f, 243.3974f, -0.3054f, 0f, 0f));
        add(m, "n122_bone3", "n127_cube", ModelPartBuilder.create().uv(610, 790).cuboid(7.4131f, -65.4826f, -48.803f, 5, 21, 16, new Dilation(-0.029f, 0.0019f, 0.0309f)), ModelTransform.of(0f, 16.0618f, 243.3974f, -0.3054f, 0f, 0f));
        add(m, "n121_Leg3", "n128_Foot3", ModelPartBuilder.create(), ModelTransform.of(-17.4178f, 45.7267f, 9.1164f, 0f, 0f, 0f));
        add(m, "n128_Foot3", "n129_cube", ModelPartBuilder.create().uv(890, 863).cuboid(-7.4131f, -25.9459f, -11.1197f, 12, 16, 12, new Dilation(0.1776f, 0.0309f, 0.1776f)), ModelTransform.of(1.8533f, 21.7874f, 14.5972f, 0.3054f, 0f, 0f));
        add(m, "n128_Foot3", "n130_cube", ModelPartBuilder.create().uv(640, 894).cuboid(-7.4131f, -9.8842f, -1.2355f, 12, 10, 12, new Dilation(0.1776f, -0.0579f, 0.1776f)), ModelTransform.of(1.8533f, 21.8733f, 1.6836f, 0f, 0f, 0f));
        add(m, "n128_Foot3", "n131_cube", ModelPartBuilder.create().uv(624, 922).cuboid(-3.0888f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(1.8533f, 21.8733f, 1.6836f, 0f, 0f, 0f));
        add(m, "n128_Foot3", "n132_cube", ModelPartBuilder.create().uv(370, 942).cuboid(-3.0888f, -4.9421f, -19.7683f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(1.8533f, 30.9825f, 0.1465f, -0.829f, 0f, 0f));
        add(m, "n128_Foot3", "n133_cube", ModelPartBuilder.create().uv(882, 942).cuboid(-1.8533f, -2.471f, -18.5328f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(0f, 19.4849f, -0.8238f, 0f, 0f, 0f));
        add(m, "n128_Foot3", "n134_cube", ModelPartBuilder.create().uv(650, 922).cuboid(-1.8533f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(4.3243f, 21.8733f, 2.9191f, 0f, -0.6545f, 0f));
        add(m, "n128_Foot3", "n135_cube", ModelPartBuilder.create().uv(232, 922).cuboid(-1.8533f, -2.471f, -18.5328f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(0f, 24f, 0.4513f, -0.829f, 0f, 0f));
        add(m, "n128_Foot3", "n136_cube", ModelPartBuilder.create().uv(392, 942).cuboid(-1.8533f, 2.3453f, -14.0908f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(4.3243f, 21.8733f, 2.9191f, -0.829f, -0.6545f, 0f));
        add(m, "n128_Foot3", "n137_cube", ModelPartBuilder.create().uv(250, 922).cuboid(-2.471f, -0.1258f, -17.7973f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(4.3243f, 21.8733f, 2.9191f, -0.829f, -0.6545f, 0f));
        add(m, "n128_Foot3", "n138_cube", ModelPartBuilder.create().uv(900, 942).cuboid(-2.471f, -4.8595f, -21.0402f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(4.3243f, 21.8733f, 2.9191f, 0f, -0.6545f, 0f));
        add(m, "n128_Foot3", "n139_cube", ModelPartBuilder.create().uv(918, 942).cuboid(-2.471f, -4.8595f, -21.0402f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(-3.0888f, 21.8733f, 2.9191f, 0f, 0.6545f, 0f));
        add(m, "n128_Foot3", "n140_cube", ModelPartBuilder.create().uv(268, 922).cuboid(-2.471f, -0.1258f, -17.7973f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(-3.0888f, 21.8733f, 2.9191f, -0.829f, 0.6545f, 0f));
        add(m, "n128_Foot3", "n141_cube", ModelPartBuilder.create().uv(414, 942).cuboid(-1.8533f, 2.3453f, -14.0908f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(-3.0888f, 21.8733f, 2.9191f, -0.829f, 0.6545f, 0f));
        add(m, "n128_Foot3", "n142_cube", ModelPartBuilder.create().uv(676, 922).cuboid(-1.8533f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(-3.0888f, 21.8733f, 2.9191f, 0f, 0.6545f, 0f));
        add(m, "n128_Foot3", "n143_cube", ModelPartBuilder.create().uv(702, 922).cuboid(-3.0888f, -4.9421f, 1.2355f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(1.8533f, 21.8733f, 11.5678f, 0f, 0f, 0f));
        add(m, "n128_Foot3", "n144_cube", ModelPartBuilder.create().uv(436, 942).cuboid(-3.0888f, -4.9421f, 12.3552f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(1.8533f, 30.9825f, 13.1049f, 0.829f, 0f, 0f));
        add(m, "n128_Foot3", "n145_cube", ModelPartBuilder.create().uv(936, 942).cuboid(-1.8533f, -2.471f, 14.8262f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(0f, 19.4849f, 14.0751f, 0f, 0f, 0f));
        add(m, "n128_Foot3", "n146_cube", ModelPartBuilder.create().uv(286, 922).cuboid(-1.8533f, -2.471f, 14.8262f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(0f, 24f, 12.8f, 0.829f, 0f, 0f));
        add(m, "n2_Body", "n147_Leg4", ModelPartBuilder.create(), ModelTransform.of(34.5498f, 0.8f, -14.7677f, 0f, 0f, 0f));
        add(m, "n147_Leg4", "n148_bone4", ModelPartBuilder.create(), ModelTransform.of(12.4f, 51.5382f, -221.5133f, 0f, 0f, 0f));
        add(m, "n148_bone4", "n149_cube", ModelPartBuilder.create().uv(0, 863).cuboid(-11.1197f, -46.9498f, -12.3552f, 12, 17, 14, new Dilation(0.1776f, 0.1486f, -0.2046f)), ModelTransform.of(4.9421f, 16.5317f, 254.6933f, 0.5672f, 0f, 0f));
        add(m, "n148_bone4", "n150_cube", ModelPartBuilder.create().uv(540, 829).cuboid(-12.3552f, -63.0115f, -2.471f, 15, 17, 15, new Dilation(-0.0869f, 0.1486f, -0.0869f)), ModelTransform.of(4.9421f, 17.7318f, 252.3992f, 0.7418f, 0f, 0f));
        add(m, "n148_bone4", "n151_cube", ModelPartBuilder.create().uv(334, 894).cuboid(-6.7954f, -33.359f, -32.1235f, 14, 14, 11, new Dilation(-0.2046f, -0.2046f, 0.0598f)), ModelTransform.of(0f, 0f, 234.7488f, -0.3054f, 0f, 0f));
        add(m, "n148_bone4", "n152_cube", ModelPartBuilder.create().uv(306, 829).cuboid(-7.4131f, -64.247f, -47.5675f, 15, 19, 14, new Dilation(-0.0869f, -0.2336f, -0.2046f)), ModelTransform.of(0f, 16.0618f, 243.3974f, -0.3054f, 0f, 0f));
        add(m, "n148_bone4", "n153_cube", ModelPartBuilder.create().uv(652, 790).cuboid(-12.3552f, -65.4826f, -48.803f, 5, 21, 16, new Dilation(-0.029f, 0.0019f, 0.0309f)), ModelTransform.of(0f, 16.0618f, 243.3974f, -0.3054f, 0f, 0f));
        add(m, "n147_Leg4", "n154_Foot4", ModelPartBuilder.create(), ModelTransform.of(13.0178f, 43.3267f, 13.1164f, 0f, 0f, 0f));
        add(m, "n154_Foot4", "n155_cube", ModelPartBuilder.create().uv(938, 863).cuboid(-4.9421f, -25.9459f, -11.1197f, 12, 16, 12, new Dilation(0.1776f, 0.0309f, 0.1776f)), ModelTransform.of(-1.8533f, 24.1874f, 11.7972f, 0.3054f, 0f, 0f));
        add(m, "n154_Foot4", "n156_cube", ModelPartBuilder.create().uv(688, 894).cuboid(-4.9421f, -9.8842f, -1.2355f, 12, 10, 12, new Dilation(0.1776f, -0.0579f, 0.1776f)), ModelTransform.of(-1.8533f, 24.2733f, -1.1164f, 0f, 0f, 0f));
        add(m, "n154_Foot4", "n157_cube", ModelPartBuilder.create().uv(728, 922).cuboid(-0.6178f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(-1.8533f, 24.2733f, -1.1164f, 0f, 0f, 0f));
        add(m, "n154_Foot4", "n158_cube", ModelPartBuilder.create().uv(458, 942).cuboid(-0.6178f, -4.9421f, -19.7683f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(-1.8533f, 33.3825f, -2.6535f, -0.829f, 0f, 0f));
        add(m, "n154_Foot4", "n159_cube", ModelPartBuilder.create().uv(954, 942).cuboid(-3.0888f, -2.471f, -18.5328f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(0f, 21.8849f, -3.6238f, 0f, 0f, 0f));
        add(m, "n154_Foot4", "n160_cube", ModelPartBuilder.create().uv(754, 922).cuboid(-1.8533f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(-4.3243f, 24.2733f, 0.1191f, 0f, 0.6545f, 0f));
        add(m, "n154_Foot4", "n161_cube", ModelPartBuilder.create().uv(304, 922).cuboid(-3.0888f, -2.471f, -18.5328f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(0f, 26.4f, -2.3487f, -0.829f, 0f, 0f));
        add(m, "n154_Foot4", "n162_cube", ModelPartBuilder.create().uv(480, 942).cuboid(-1.8533f, 2.3453f, -14.0908f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(-4.3243f, 24.2733f, 0.1191f, -0.829f, 0.6545f, 0f));
        add(m, "n154_Foot4", "n163_cube", ModelPartBuilder.create().uv(322, 922).cuboid(-2.471f, -0.1258f, -17.7973f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(-4.3243f, 24.2733f, 0.1191f, -0.829f, 0.6545f, 0f));
        add(m, "n154_Foot4", "n164_cube", ModelPartBuilder.create().uv(972, 942).cuboid(-2.471f, -4.8595f, -21.0402f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(-4.3243f, 24.2733f, 0.1191f, 0f, 0.6545f, 0f));
        add(m, "n154_Foot4", "n165_cube", ModelPartBuilder.create().uv(990, 942).cuboid(-2.471f, -4.8595f, -21.0402f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(3.0888f, 24.2733f, 0.1191f, 0f, -0.6545f, 0f));
        add(m, "n154_Foot4", "n166_cube", ModelPartBuilder.create().uv(340, 922).cuboid(-2.471f, -0.1258f, -17.7973f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(3.0888f, 24.2733f, 0.1191f, -0.829f, -0.6545f, 0f));
        add(m, "n154_Foot4", "n167_cube", ModelPartBuilder.create().uv(502, 942).cuboid(-1.8533f, 2.3453f, -14.0908f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(3.0888f, 24.2733f, 0.1191f, -0.829f, -0.6545f, 0f));
        add(m, "n154_Foot4", "n168_cube", ModelPartBuilder.create().uv(780, 922).cuboid(-1.8533f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(3.0888f, 24.2733f, 0.1191f, 0f, -0.6545f, 0f));
        add(m, "n154_Foot4", "n169_cube", ModelPartBuilder.create().uv(806, 922).cuboid(-0.6178f, -4.9421f, 1.2355f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(-1.8533f, 24.2733f, 8.7678f, 0f, 0f, 0f));
        add(m, "n154_Foot4", "n170_cube", ModelPartBuilder.create().uv(524, 942).cuboid(-0.6178f, -4.9421f, 12.3552f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(-1.8533f, 33.3825f, 10.3049f, 0.829f, 0f, 0f));
        add(m, "n154_Foot4", "n171_cube", ModelPartBuilder.create().uv(0, 956).cuboid(-3.0888f, -2.471f, 14.8262f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(0f, 21.8849f, 11.2751f, 0f, 0f, 0f));
        add(m, "n154_Foot4", "n172_cube", ModelPartBuilder.create().uv(358, 922).cuboid(-3.0888f, -2.471f, 14.8262f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(0f, 26.4f, 10f, 0.829f, 0f, 0f));
        add(m, "n2_Body", "n173_Leg2", ModelPartBuilder.create(), ModelTransform.of(-46.9498f, -3.6f, -93.2f, 0f, 0f, 0f));
        add(m, "n173_Leg2", "n174_cube", ModelPartBuilder.create().uv(314, 790).cuboid(-51.1752f, -111.7775f, -43.0949f, 18, 18, 20, new Dilation(-0.2463f, -0.2463f, 0.1004f)), ModelTransform.of(46.9498f, 72f, -22f, -0.6981f, 0f, 0f));
        add(m, "n173_Leg2", "n175_cube", ModelPartBuilder.create().uv(834, 863).cuboid(-48.4818f, -123.8979f, -40.4015f, 12, 12, 16, new Dilation(0.0602f, 0.0602f, 0.0803f)), ModelTransform.of(46.9498f, 72f, -22f, -0.6981f, 0f, 0f));
        add(m, "n173_Leg2", "n176_cube", ModelPartBuilder.create().uv(818, 647).cuboid(-53.8687f, -94.2702f, -44.4417f, 22, 27, 23, new Dilation(-0.2263f, -0.0328f, -0.0529f)), ModelTransform.of(46.9498f, 72f, -22f, -0.6981f, 0f, 0f));
        add(m, "n173_Leg2", "n177_bone2", ModelPartBuilder.create(), ModelTransform.of(-2.817f, 54.9745f, -12.8324f, 0f, 0f, 0f));
        add(m, "n177_bone2", "n178_cube", ModelPartBuilder.create().uv(890, 829).cuboid(-1.3097f, -49.7667f, -1.3097f, 13, 18, 14, new Dilation(0.0483f, 0.1676f, 0.2031f)), ModelTransform.of(-2.4216f, 18.7957f, -18.7094f, -0.48f, 0f, 0f));
        add(m, "n177_bone2", "n179_cube", ModelPartBuilder.create().uv(64, 829).cuboid(-2.6193f, -68.1019f, -1.3097f, 16, 18, 16, new Dilation(-0.1421f, 0.1676f, -0.1421f)), ModelTransform.of(-2.4216f, 18.7957f, -18.7094f, -0.48f, 0f, 0f));
    }

    private static void p3(Map<String, ModelPartData> m) {
        add(m, "n177_bone2", "n180_cube", ModelPartBuilder.create().uv(346, 942).cuboid(-1.3097f, -40.5992f, 5.2386f, 3, 10, 3, new Dilation(-0.1903f, 0.2386f, -0.1903f)), ModelTransform.of(2.817f, 14.4062f, -9.1676f, -0.48f, 0f, 0f));
        add(m, "n177_bone2", "n181_cube", ModelPartBuilder.create().uv(258, 956).cuboid(-1.3097f, -40.5992f, 7.8579f, 3, 5, 3, new Dilation(-0.1903f, 0.1193f, -0.1903f)), ModelTransform.of(2.817f, 14.4062f, -9.1676f, -0.48f, 0f, 0f));
        add(m, "n177_bone2", "n182_cube", ModelPartBuilder.create().uv(766, 942).cuboid(-1.3097f, -40.5992f, 5.2386f, 3, 1, 8, new Dilation(-0.1903f, 0.1548f, -0.071f)), ModelTransform.of(2.817f, 13.5944f, -9.6011f, -0.48f, 0f, 0f));
        add(m, "n177_bone2", "n183_cube", ModelPartBuilder.create().uv(64, 922).cuboid(-1.3097f, -40.5992f, 7.8579f, 3, 16, 3, new Dilation(-0.1903f, -0.1421f, -0.1903f)), ModelTransform.of(2.817f, 2.8621f, -17.6778f, -0.8727f, 0f, 0f));
        add(m, "n177_bone2", "n184_cube", ModelPartBuilder.create().uv(76, 922).cuboid(-1.3097f, -40.5992f, 7.8579f, 3, 16, 3, new Dilation(-0.1903f, -0.1421f, -0.1903f)), ModelTransform.of(2.817f, -11.544f, -8.5103f, -0.8727f, 0f, 0f));
        add(m, "n177_bone2", "n185_cube", ModelPartBuilder.create().uv(358, 942).cuboid(-1.3097f, -40.5992f, 5.2386f, 3, 10, 3, new Dilation(-0.1903f, 0.2386f, -0.1903f)), ModelTransform.of(2.817f, 0f, 0f, -0.48f, 0f, 0f));
        add(m, "n177_bone2", "n186_cube", ModelPartBuilder.create().uv(788, 942).cuboid(-1.3097f, -40.5992f, 5.2386f, 3, 1, 8, new Dilation(-0.1903f, 0.1548f, -0.071f)), ModelTransform.of(2.817f, -0.8117f, -0.4335f, -0.48f, 0f, 0f));
        add(m, "n177_bone2", "n187_cube", ModelPartBuilder.create().uv(270, 956).cuboid(-1.3097f, -40.5992f, 7.8579f, 3, 5, 3, new Dilation(-0.1903f, 0.1193f, -0.1903f)), ModelTransform.of(2.817f, 0f, 0f, -0.48f, 0f, 0f));
        add(m, "n177_bone2", "n188_cube", ModelPartBuilder.create().uv(232, 894).cuboid(-7.2031f, -40.5992f, 23.5737f, 14, 14, 12, new Dilation(0.2031f, 0.2031f, -0.1066f)), ModelTransform.of(2.817f, 0f, 0f, 0.3054f, 0f, 0f));
        add(m, "n177_bone2", "n189_cube", ModelPartBuilder.create().uv(188, 829).cuboid(-7.8579f, -72.0308f, 36.0154f, 16, 20, 14, new Dilation(-0.1421f, -0.1776f, 0.2031f)), ModelTransform.of(2.817f, 17.0255f, -9.1676f, 0.3054f, 0f, 0f));
        add(m, "n177_bone2", "n190_cube", ModelPartBuilder.create().uv(44, 790).cuboid(7.8579f, -73.3405f, 34.7058f, 5, 22, 17, new Dilation(0.1193f, 0.132f, 0.0127f)), ModelTransform.of(2.817f, 17.0255f, -9.1676f, 0.3054f, 0f, 0f));
        add(m, "n173_Leg2", "n191_Foot2", ModelPartBuilder.create(), ModelTransform.of(0.9282f, 46.6543f, -12.6166f, 0f, 0f, 0f));
        add(m, "n191_Foot2", "n192_cube", ModelPartBuilder.create().uv(440, 863).cuboid(-7.8579f, -27.5027f, -1.3097f, 13, 17, 13, new Dilation(0.0483f, 0.0127f, 0.0483f)), ModelTransform.of(0.3815f, 25.2546f, -12.5946f, -0.3054f, 0f, 0f));
        add(m, "n191_Foot2", "n193_cube", ModelPartBuilder.create().uv(588, 894).cuboid(-7.8579f, -10.4772f, -1.3097f, 13, 10, 13, new Dilation(0.0483f, 0.2386f, 0.0483f)), ModelTransform.of(0.3815f, 25.3457f, -9.3834f, 0f, 0f, 0f));
        add(m, "n191_Foot2", "n194_cube", ModelPartBuilder.create().uv(832, 922).cuboid(-3.2741f, -5.2386f, -10.4772f, 4, 5, 9, new Dilation(-0.0355f, 0.1193f, 0.0838f)), ModelTransform.of(0.3815f, 25.3457f, -9.3834f, 0f, 0f, 0f));
        add(m, "n191_Foot2", "n195_cube", ModelPartBuilder.create().uv(226, 942).cuboid(-3.2741f, -5.2386f, -20.9544f, 4, 5, 8, new Dilation(-0.0355f, 0.1193f, -0.071f)), ModelTransform.of(0.3815f, 35.0015f, -11.0127f, -0.829f, 0f, 0f));
        add(m, "n191_Foot2", "n196_cube", ModelPartBuilder.create().uv(18, 956).cuboid(-1.9645f, -2.6193f, -19.6448f, 5, 5, 4, new Dilation(0.1193f, 0.1193f, -0.0355f)), ModelTransform.of(-1.583f, 22.814f, -12.0412f, 0f, 0f, 0f));
        add(m, "n191_Foot2", "n197_cube", ModelPartBuilder.create().uv(858, 922).cuboid(-1.9645f, -5.2386f, -10.4772f, 4, 5, 9, new Dilation(-0.0355f, 0.1193f, 0.0838f)), ModelTransform.of(3.0008f, 25.3457f, -8.0737f, 0f, -0.6545f, 0f));
        add(m, "n191_Foot2", "n198_cube", ModelPartBuilder.create().uv(160, 922).cuboid(-1.9645f, -2.6193f, -19.6448f, 5, 13, 4, new Dilation(0.1193f, 0.0483f, -0.0355f)), ModelTransform.of(-1.583f, 27.6f, -10.6896f, -0.829f, 0f, 0f));
        add(m, "n191_Foot2", "n199_cube", ModelPartBuilder.create().uv(250, 942).cuboid(-1.9645f, 2.486f, -14.9362f, 4, 5, 8, new Dilation(-0.0355f, 0.1193f, -0.071f)), ModelTransform.of(3.0008f, 25.3457f, -8.0737f, -0.829f, -0.6545f, 0f));
        add(m, "n191_Foot2", "n200_cube", ModelPartBuilder.create().uv(178, 922).cuboid(-2.6193f, -0.1333f, -18.8652f, 5, 13, 4, new Dilation(0.1193f, 0.0483f, -0.0355f)), ModelTransform.of(3.0008f, 25.3457f, -8.0737f, -0.829f, -0.6545f, 0f));
        add(m, "n191_Foot2", "n201_cube", ModelPartBuilder.create().uv(36, 956).cuboid(-2.6193f, -5.151f, -22.3026f, 5, 5, 4, new Dilation(0.1193f, 0.1193f, -0.0355f)), ModelTransform.of(3.0008f, 25.3457f, -8.0737f, 0f, -0.6545f, 0f));
        add(m, "n191_Foot2", "n202_cube", ModelPartBuilder.create().uv(54, 956).cuboid(-2.6193f, -5.151f, -22.3026f, 5, 5, 4, new Dilation(0.1193f, 0.1193f, -0.0355f)), ModelTransform.of(-4.8571f, 25.3457f, -8.0737f, 0f, 0.6545f, 0f));
        add(m, "n191_Foot2", "n203_cube", ModelPartBuilder.create().uv(196, 922).cuboid(-2.6193f, -0.1333f, -18.8652f, 5, 13, 4, new Dilation(0.1193f, 0.0483f, -0.0355f)), ModelTransform.of(-4.8571f, 25.3457f, -8.0737f, -0.829f, 0.6545f, 0f));
        add(m, "n191_Foot2", "n204_cube", ModelPartBuilder.create().uv(274, 942).cuboid(-1.9645f, 2.486f, -14.9362f, 4, 5, 8, new Dilation(-0.0355f, 0.1193f, -0.071f)), ModelTransform.of(-4.8571f, 25.3457f, -8.0737f, -0.829f, 0.6545f, 0f));
        add(m, "n191_Foot2", "n205_cube", ModelPartBuilder.create().uv(884, 922).cuboid(-1.9645f, -5.2386f, -10.4772f, 4, 5, 9, new Dilation(-0.0355f, 0.1193f, 0.0838f)), ModelTransform.of(-4.8571f, 25.3457f, -8.0737f, 0f, 0.6545f, 0f));
        add(m, "n191_Foot2", "n206_cube", ModelPartBuilder.create().uv(910, 922).cuboid(-3.2741f, -5.2386f, 1.3097f, 4, 5, 9, new Dilation(-0.0355f, 0.1193f, 0.0838f)), ModelTransform.of(0.3815f, 25.3457f, 1.0938f, 0f, 0f, 0f));
        add(m, "n191_Foot2", "n207_cube", ModelPartBuilder.create().uv(298, 942).cuboid(-3.2741f, -5.2386f, 13.0965f, 4, 5, 8, new Dilation(-0.0355f, 0.1193f, -0.071f)), ModelTransform.of(0.3815f, 35.0015f, 2.7232f, 0.829f, 0f, 0f));
        add(m, "n191_Foot2", "n208_cube", ModelPartBuilder.create().uv(72, 956).cuboid(-1.9645f, -2.6193f, 15.7158f, 5, 5, 4, new Dilation(0.1193f, 0.1193f, -0.0355f)), ModelTransform.of(-1.583f, 22.814f, 3.7517f, 0f, 0f, 0f));
        add(m, "n191_Foot2", "n209_cube", ModelPartBuilder.create().uv(214, 922).cuboid(-1.9645f, -2.6193f, 15.7158f, 5, 13, 4, new Dilation(0.1193f, 0.0483f, -0.0355f)), ModelTransform.of(-1.583f, 27.6f, 2.4f, 0.829f, 0f, 0f));
        add(m, "n1_THE_WARRIOR", "n210_bone7", ModelPartBuilder.create(), ModelTransform.of(-25.9459f, -67.2f, 114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n211_cube", ModelPartBuilder.create().uv(546, 268).cuboid(-17.2973f, -76.6022f, 114.9034f, 35, 22, 79, new Dilation(-0.2027f, 0.1197f, 0.0366f)), ModelTransform.of(25.9459f, 67.2f, -114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n212_cube", ModelPartBuilder.create().uv(780, 589).cuboid(-11.1197f, -59.305f, 108.7258f, 26, 12, 40, new Dilation(-0.027f, 0.1776f, -0.2317f)), ModelTransform.of(25.9459f, 67.2f, -114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n213_cube", ModelPartBuilder.create().uv(490, 647).cuboid(-8.6486f, -59.305f, 148.2624f, 21, 10, 40, new Dilation(0.0019f, -0.0579f, -0.2317f)), ModelTransform.of(25.9459f, 67.2f, -114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n214_cube", ModelPartBuilder.create().uv(88, 790).cuboid(-32.1235f, -81.5443f, 114.9034f, 64, 27, 11, new Dilation(0.1235f, 0.0907f, 0.0598f)), ModelTransform.of(25.9459f, 67.2f, -114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n215_cube", ModelPartBuilder.create().uv(390, 790).cuboid(-29.6525f, -80.3088f, 126.023f, 59, 26, 11, new Dilation(0.1525f, -0.027f, 0.0598f)), ModelTransform.of(25.9459f, 67.2f, -114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n216_cube", ModelPartBuilder.create().uv(778, 790).cuboid(-24.7104f, -79.0733f, 137.1427f, 49, 25, 11, new Dilation(0.2104f, -0.1448f, 0.0598f)), ModelTransform.of(25.9459f, 67.2f, -114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n217_cube", ModelPartBuilder.create().uv(898, 790).cuboid(-21.0038f, -77.8378f, 148.2624f, 42, 23, 11, new Dilation(0.0038f, 0.2374f, 0.0598f)), ModelTransform.of(25.9459f, 67.2f, -114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n218_cube", ModelPartBuilder.create().uv(872, 894).cuboid(-4.9421f, -91.4285f, 113.6678f, 10, 10, 10, new Dilation(-0.0579f, -0.0579f, -0.0579f)), ModelTransform.of(25.9459f, 67.2f, -114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n219_cube", ModelPartBuilder.create().uv(912, 894).cuboid(-4.9421f, -88.9574f, 135.9072f, 10, 10, 10, new Dilation(-0.0579f, -0.0579f, -0.0579f)), ModelTransform.of(25.9459f, 67.2f, -114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n220_cube", ModelPartBuilder.create().uv(952, 894).cuboid(-4.9421f, -86.4864f, 158.1466f, 10, 10, 10, new Dilation(-0.0579f, -0.0579f, -0.0579f)), ModelTransform.of(25.9459f, 67.2f, -114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n221_cube", ModelPartBuilder.create().uv(0, 922).cuboid(-4.9421f, -86.4864f, 180.3859f, 10, 10, 10, new Dilation(-0.0579f, -0.0579f, -0.0579f)), ModelTransform.of(25.9459f, 67.2f, -114.6701f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n222_cube", ModelPartBuilder.create().uv(52, 863).cuboid(-11.1197f, -46.9498f, -12.3552f, 12, 17, 14, new Dilation(0.1776f, 0.1486f, -0.2046f)), ModelTransform.of(60.5405f, 67.67f, 95.5445f, 0.5672f, 0f, 0f));
        add(m, "n210_bone7", "n223_cube", ModelPartBuilder.create().uv(600, 829).cuboid(-12.3552f, -63.0115f, -2.471f, 15, 17, 15, new Dilation(-0.0869f, 0.1486f, -0.0869f)), ModelTransform.of(60.5405f, 68.87f, 93.2504f, 0.7418f, 0f, 0f));
        add(m, "n210_bone7", "n224_cube", ModelPartBuilder.create().uv(384, 894).cuboid(-6.7954f, -33.359f, -32.1235f, 14, 14, 11, new Dilation(-0.2046f, -0.2046f, 0.0598f)), ModelTransform.of(55.5984f, 51.1382f, 75.6f, -0.3054f, 0f, 0f));
        add(m, "n210_bone7", "n225_cube", ModelPartBuilder.create().uv(364, 829).cuboid(-7.4131f, -64.247f, -47.5675f, 15, 19, 14, new Dilation(-0.0869f, -0.2336f, -0.2046f)), ModelTransform.of(55.5984f, 67.2f, 84.2486f, -0.3054f, 0f, 0f));
        add(m, "n210_bone7", "n226_cube", ModelPartBuilder.create().uv(694, 790).cuboid(-12.3552f, -65.4826f, -48.803f, 5, 21, 16, new Dilation(-0.029f, 0.0019f, 0.0309f)), ModelTransform.of(55.5984f, 67.2f, 84.2486f, -0.3054f, 0f, 0f));
        add(m, "n210_bone7", "n227_cube", ModelPartBuilder.create().uv(0, 894).cuboid(-4.9421f, -25.9459f, -11.1197f, 12, 16, 12, new Dilation(0.1776f, 0.0309f, 0.1776f)), ModelTransform.of(54.3629f, 67.1141f, 87.278f, 0.3054f, 0f, 0f));
        add(m, "n210_bone7", "n228_cube", ModelPartBuilder.create().uv(736, 894).cuboid(-4.9421f, -9.8842f, -1.2355f, 12, 10, 12, new Dilation(0.1776f, -0.0579f, 0.1776f)), ModelTransform.of(54.3629f, 67.2f, 74.3645f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n229_cube", ModelPartBuilder.create().uv(936, 922).cuboid(-0.6178f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(54.3629f, 67.2f, 74.3645f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n230_cube", ModelPartBuilder.create().uv(546, 942).cuboid(-0.6178f, -4.9421f, -19.7683f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(54.3629f, 76.3092f, 72.8274f, -0.829f, 0f, 0f));
        add(m, "n210_bone7", "n231_cube", ModelPartBuilder.create().uv(90, 956).cuboid(-3.0888f, -2.471f, -18.5328f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(56.2162f, 64.8116f, 71.8571f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n232_cube", ModelPartBuilder.create().uv(962, 922).cuboid(-1.8533f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(51.8918f, 67.2f, 75.6f, 0f, 0.6545f, 0f));
        add(m, "n210_bone7", "n233_cube", ModelPartBuilder.create().uv(376, 922).cuboid(-3.0888f, -2.471f, -18.5328f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(56.2162f, 69.3267f, 73.1322f, -0.829f, 0f, 0f));
        add(m, "n210_bone7", "n234_cube", ModelPartBuilder.create().uv(568, 942).cuboid(-1.8533f, 2.3453f, -14.0908f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(51.8918f, 67.2f, 75.6f, -0.829f, 0.6545f, 0f));
        add(m, "n210_bone7", "n235_cube", ModelPartBuilder.create().uv(394, 922).cuboid(-2.471f, -0.1258f, -17.7973f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(51.8918f, 67.2f, 75.6f, -0.829f, 0.6545f, 0f));
        add(m, "n210_bone7", "n236_cube", ModelPartBuilder.create().uv(108, 956).cuboid(-2.471f, -4.8595f, -21.0402f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(51.8918f, 67.2f, 75.6f, 0f, 0.6545f, 0f));
        add(m, "n210_bone7", "n237_cube", ModelPartBuilder.create().uv(126, 956).cuboid(-2.471f, -4.8595f, -21.0402f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(59.305f, 67.2f, 75.6f, 0f, -0.6545f, 0f));
        add(m, "n210_bone7", "n238_cube", ModelPartBuilder.create().uv(412, 922).cuboid(-2.471f, -0.1258f, -17.7973f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(59.305f, 67.2f, 75.6f, -0.829f, -0.6545f, 0f));
        add(m, "n210_bone7", "n239_cube", ModelPartBuilder.create().uv(590, 942).cuboid(-1.8533f, 2.3453f, -14.0908f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(59.305f, 67.2f, 75.6f, -0.829f, -0.6545f, 0f));
    }

    private static void p4(Map<String, ModelPartData> m) {
        add(m, "n210_bone7", "n240_cube", ModelPartBuilder.create().uv(988, 922).cuboid(-1.8533f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(59.305f, 67.2f, 75.6f, 0f, -0.6545f, 0f));
        add(m, "n210_bone7", "n241_cube", ModelPartBuilder.create().uv(0, 942).cuboid(-0.6178f, -4.9421f, 1.2355f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(54.3629f, 67.2f, 84.2486f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n242_cube", ModelPartBuilder.create().uv(612, 942).cuboid(-0.6178f, -4.9421f, 12.3552f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(54.3629f, 76.3092f, 85.7857f, 0.829f, 0f, 0f));
        add(m, "n210_bone7", "n243_cube", ModelPartBuilder.create().uv(144, 956).cuboid(-3.0888f, -2.471f, 14.8262f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(56.2162f, 64.8116f, 86.756f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n244_cube", ModelPartBuilder.create().uv(430, 922).cuboid(-3.0888f, -2.471f, 14.8262f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(56.2162f, 69.3267f, 85.4809f, 0.829f, 0f, 0f));
        add(m, "n210_bone7", "n245_cube", ModelPartBuilder.create().uv(104, 863).cuboid(-1.2355f, -46.9498f, -12.3552f, 12, 17, 14, new Dilation(0.1776f, 0.1486f, -0.2046f)), ModelTransform.of(-8.6486f, 67.67f, 95.5445f, 0.5672f, 0f, 0f));
        add(m, "n210_bone7", "n246_cube", ModelPartBuilder.create().uv(660, 829).cuboid(-2.471f, -63.0115f, -2.471f, 15, 17, 15, new Dilation(-0.0869f, 0.1486f, -0.0869f)), ModelTransform.of(-8.6486f, 68.87f, 93.2504f, 0.7418f, 0f, 0f));
        add(m, "n210_bone7", "n247_cube", ModelPartBuilder.create().uv(434, 894).cuboid(-6.7954f, -33.359f, -32.1235f, 14, 14, 11, new Dilation(-0.2046f, -0.2046f, 0.0598f)), ModelTransform.of(-3.7066f, 51.1382f, 75.6f, -0.3054f, 0f, 0f));
        add(m, "n210_bone7", "n248_cube", ModelPartBuilder.create().uv(422, 829).cuboid(-7.4131f, -64.247f, -47.5675f, 15, 19, 14, new Dilation(-0.0869f, -0.2336f, -0.2046f)), ModelTransform.of(-3.7066f, 67.2f, 84.2486f, -0.3054f, 0f, 0f));
        add(m, "n210_bone7", "n249_cube", ModelPartBuilder.create().uv(736, 790).cuboid(7.4131f, -65.4826f, -48.803f, 5, 21, 16, new Dilation(-0.029f, 0.0019f, 0.0309f)), ModelTransform.of(-3.7066f, 67.2f, 84.2486f, -0.3054f, 0f, 0f));
        add(m, "n210_bone7", "n250_cube", ModelPartBuilder.create().uv(48, 894).cuboid(-7.4131f, -25.9459f, -11.1197f, 12, 16, 12, new Dilation(0.1776f, 0.0309f, 0.1776f)), ModelTransform.of(-2.471f, 67.1141f, 87.278f, 0.3054f, 0f, 0f));
        add(m, "n210_bone7", "n251_cube", ModelPartBuilder.create().uv(784, 894).cuboid(-7.4131f, -9.8842f, -1.2355f, 12, 10, 12, new Dilation(0.1776f, -0.0579f, 0.1776f)), ModelTransform.of(-2.471f, 67.2f, 74.3645f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n252_cube", ModelPartBuilder.create().uv(26, 942).cuboid(-3.0888f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(-2.471f, 67.2f, 74.3645f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n253_cube", ModelPartBuilder.create().uv(634, 942).cuboid(-3.0888f, -4.9421f, -19.7683f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(-2.471f, 76.3092f, 72.8274f, -0.829f, 0f, 0f));
        add(m, "n210_bone7", "n254_cube", ModelPartBuilder.create().uv(162, 956).cuboid(-1.8533f, -2.471f, -18.5328f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(-4.3243f, 64.8116f, 71.8571f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n255_cube", ModelPartBuilder.create().uv(52, 942).cuboid(-1.8533f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(0f, 67.2f, 75.6f, 0f, -0.6545f, 0f));
        add(m, "n210_bone7", "n256_cube", ModelPartBuilder.create().uv(448, 922).cuboid(-1.8533f, -2.471f, -18.5328f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(-4.3243f, 69.3267f, 73.1322f, -0.829f, 0f, 0f));
        add(m, "n210_bone7", "n257_cube", ModelPartBuilder.create().uv(656, 942).cuboid(-1.8533f, 2.3453f, -14.0908f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(0f, 67.2f, 75.6f, -0.829f, -0.6545f, 0f));
        add(m, "n210_bone7", "n258_cube", ModelPartBuilder.create().uv(466, 922).cuboid(-2.471f, -0.1258f, -17.7973f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(0f, 67.2f, 75.6f, -0.829f, -0.6545f, 0f));
        add(m, "n210_bone7", "n259_cube", ModelPartBuilder.create().uv(180, 956).cuboid(-2.471f, -4.8595f, -21.0402f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(0f, 67.2f, 75.6f, 0f, -0.6545f, 0f));
        add(m, "n210_bone7", "n260_cube", ModelPartBuilder.create().uv(198, 956).cuboid(-2.471f, -4.8595f, -21.0402f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(-7.4131f, 67.2f, 75.6f, 0f, 0.6545f, 0f));
        add(m, "n210_bone7", "n261_cube", ModelPartBuilder.create().uv(484, 922).cuboid(-2.471f, -0.1258f, -17.7973f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(-7.4131f, 67.2f, 75.6f, -0.829f, 0.6545f, 0f));
        add(m, "n210_bone7", "n262_cube", ModelPartBuilder.create().uv(678, 942).cuboid(-1.8533f, 2.3453f, -14.0908f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(-7.4131f, 67.2f, 75.6f, -0.829f, 0.6545f, 0f));
        add(m, "n210_bone7", "n263_cube", ModelPartBuilder.create().uv(78, 942).cuboid(-1.8533f, -4.9421f, -9.8842f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(-7.4131f, 67.2f, 75.6f, 0f, 0.6545f, 0f));
        add(m, "n210_bone7", "n264_cube", ModelPartBuilder.create().uv(104, 942).cuboid(-3.0888f, -4.9421f, 1.2355f, 4, 5, 9, new Dilation(-0.1467f, -0.029f, -0.1757f)), ModelTransform.of(-2.471f, 67.2f, 84.2486f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n265_cube", ModelPartBuilder.create().uv(700, 942).cuboid(-3.0888f, -4.9421f, 12.3552f, 4, 5, 7, new Dilation(-0.1467f, -0.029f, 0.2066f)), ModelTransform.of(-2.471f, 76.3092f, 85.7857f, 0.829f, 0f, 0f));
        add(m, "n210_bone7", "n266_cube", ModelPartBuilder.create().uv(216, 956).cuboid(-1.8533f, -2.471f, 14.8262f, 5, 5, 4, new Dilation(-0.029f, -0.029f, -0.1467f)), ModelTransform.of(-4.3243f, 64.8116f, 86.756f, 0f, 0f, 0f));
        add(m, "n210_bone7", "n267_cube", ModelPartBuilder.create().uv(502, 922).cuboid(-1.8533f, -2.471f, 14.8262f, 5, 12, 4, new Dilation(-0.029f, 0.1776f, -0.1467f)), ModelTransform.of(-4.3243f, 69.3267f, 85.4809f, 0.829f, 0f, 0f));
        add(m, "n210_bone7", "n268_Tail", ModelPartBuilder.create(), ModelTransform.of(25.9459f, 1.6f, 79.2355f, 0f, 0f, 0f));
        add(m, "n268_Tail", "n269_cube", ModelPartBuilder.create().uv(124, 459).cuboid(-9.8842f, -75.3667f, 1.2355f, 20, 20, 46, new Dilation(-0.1158f, -0.1158f, -0.1429f)), ModelTransform.of(0f, 65.6f, -2.4f, 0f, 0f, 0f));
        add(m, "n268_Tail", "n270_cube", ModelPartBuilder.create().uv(256, 459).cuboid(-9.8842f, -75.3667f, 46.9498f, 20, 20, 46, new Dilation(-0.1158f, -0.1158f, -0.1429f)), ModelTransform.of(0f, 69.4804f, 2.6244f, 0.0873f, 0f, 0f));
        add(m, "n268_Tail", "n271_cube", ModelPartBuilder.create().uv(388, 459).cuboid(-8.6486f, -74.1312f, 92.664f, 17, 17, 46, new Dilation(0.1486f, 0.1486f, -0.1429f)), ModelTransform.of(16.2411f, 76.9156f, 8.1845f, 0.1772f, -0.1719f, -0.0306f));
        add(m, "n268_Tail", "n272_cube", ModelPartBuilder.create().uv(188, 527).cuboid(-7.4131f, -72.8957f, 92.664f, 15, 15, 46, new Dilation(-0.0869f, -0.0869f, -0.1429f)), ModelTransform.of(17.9633f, 78.9256f, 63.699f, 0.3137f, -0.3006f, -0.0547f));
        add(m, "n268_Tail", "n273_cube", ModelPartBuilder.create().uv(310, 527).cuboid(-7.4131f, -72.8957f, 138.3782f, 15, 15, 46, new Dilation(-0.0869f, -0.0869f, -0.1429f)), ModelTransform.of(32.5798f, 87.7994f, 77.1003f, 0.4167f, -0.4249f, -0.0989f));
        add(m, "n268_Tail", "n274_cube", ModelPartBuilder.create().uv(0, 589).cuboid(-6.1776f, -71.6602f, 184.0925f, 12, 12, 46, new Dilation(0.1776f, 0.1776f, -0.1429f)), ModelTransform.of(50.1865f, 98.249f, 97.3985f, 0.5328f, -0.5438f, -0.1607f));
        add(m, "n268_Tail", "n275_cube", ModelPartBuilder.create().uv(432, 527).cuboid(-13.5907f, -72.8957f, 216.216f, 7, 15, 46, new Dilation(0.2066f, -0.0869f, -0.1429f)), ModelTransform.of(50.1865f, 98.249f, 97.3985f, 0.5328f, -0.5438f, -0.1607f));
        add(m, "n268_Tail", "n276_cube", ModelPartBuilder.create().uv(538, 527).cuboid(6.1776f, -72.8957f, 216.216f, 7, 15, 46, new Dilation(0.2066f, -0.0869f, -0.1429f)), ModelTransform.of(50.1865f, 98.249f, 97.3985f, 0.5328f, -0.5438f, -0.1607f));
        add(m, "n1_THE_WARRIOR", "n277_Leg5", ModelPartBuilder.create(), ModelTransform.of(29.6525f, 0f, 189.0346f, 0f, 0f, 0f));
        add(m, "n277_Leg5", "n278_bone5", ModelPartBuilder.create(), ModelTransform.of(0f, -16.0618f, -233.5133f, 0f, 0f, 0f));
        add(m, "n277_Leg5", "n279_Foot5", ModelPartBuilder.create(), ModelTransform.of(0.6178f, 2.1267f, 11.1164f, 0f, 0f, 0f));
        add(m, "n1_THE_WARRIOR", "n280_Leg6", ModelPartBuilder.create(), ModelTransform.of(-29.6525f, 0f, 189.0346f, 0f, 0f, 0f));
        add(m, "n280_Leg6", "n281_bone6", ModelPartBuilder.create(), ModelTransform.of(0f, -16.0618f, -233.5133f, 0f, 0f, 0f));
        add(m, "n280_Leg6", "n282_Foot6", ModelPartBuilder.create(), ModelTransform.of(-0.6178f, 2.1267f, 11.1164f, 0f, 0f, 0f));
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
