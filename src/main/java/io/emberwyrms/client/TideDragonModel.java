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
 * GENERADO por tools/rig_emit.py a partir de un modelo de Blockbench (Serpent Blue Dragon (Sketchfab)).
 * Geometria y textura convertidas; los movimientos (cuello, cola, alas, patas...) son propios del mod.
 */
public class TideDragonModel extends EntityModel<AshwingRenderState> {
    private final ModelPart[] bones;
    private static final float[][] REST = {{0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}, {0f, 0f, 0f}};
    private static final int HEAD = 0, JAW = -1;
    private static final int[] NECK = {}, TAIL = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, HAIR = {};
    private static final int[][] WING = {};
    private static final float[] WSIGN = {};
    private static final int[][] LEG = {};
    private static final float[] LPHASE = {};
    private static final float FOLD = 0.9f, FOLD_YAW = 0.8f, FOLD_TIP = 1.2f, FOLD_ROLL = 0.3f, FLAP = 0.75f, TAIL_AMP = 2.2f, LEG_AMP = 0.6f;

    public TideDragonModel(ModelPart root) {
        super(root);
        this.bones = new ModelPart[] {
            root.getChild("n0_x").getChild("n1_Head"),
            root.getChild("n0_x").getChild("n51_Corpo").getChild("slice113_Corpo"),
            root.getChild("n0_x").getChild("n51_Corpo").getChild("slice113_Corpo").getChild("slice114_Corpo"),
            root.getChild("n0_x").getChild("n51_Corpo").getChild("slice113_Corpo").getChild("slice114_Corpo").getChild("slice115_Corpo"),
            root.getChild("n0_x").getChild("n51_Corpo").getChild("slice113_Corpo").getChild("slice114_Corpo").getChild("slice115_Corpo").getChild("slice116_Corpo"),
            root.getChild("n0_x").getChild("n51_Corpo").getChild("slice113_Corpo").getChild("slice114_Corpo").getChild("slice115_Corpo").getChild("slice116_Corpo").getChild("slice117_Corpo"),
            root.getChild("n0_x").getChild("n51_Corpo").getChild("slice113_Corpo").getChild("slice114_Corpo").getChild("slice115_Corpo").getChild("slice116_Corpo").getChild("slice117_Corpo").getChild("slice118_Corpo"),
            root.getChild("n0_x").getChild("n51_Corpo").getChild("slice113_Corpo").getChild("slice114_Corpo").getChild("slice115_Corpo").getChild("slice116_Corpo").getChild("slice117_Corpo").getChild("slice118_Corpo").getChild("slice119_Corpo"),
            root.getChild("n0_x").getChild("n51_Corpo").getChild("slice113_Corpo").getChild("slice114_Corpo").getChild("slice115_Corpo").getChild("slice116_Corpo").getChild("slice117_Corpo").getChild("slice118_Corpo").getChild("slice119_Corpo").getChild("slice120_Corpo"),
            root.getChild("n0_x").getChild("n51_Corpo").getChild("slice113_Corpo").getChild("slice114_Corpo").getChild("slice115_Corpo").getChild("slice116_Corpo").getChild("slice117_Corpo").getChild("slice118_Corpo").getChild("slice119_Corpo").getChild("slice120_Corpo").getChild("slice121_Corpo"),
            root.getChild("n0_x").getChild("n51_Corpo").getChild("slice113_Corpo").getChild("slice114_Corpo").getChild("slice115_Corpo").getChild("slice116_Corpo").getChild("slice117_Corpo").getChild("slice118_Corpo").getChild("slice119_Corpo").getChild("slice120_Corpo").getChild("slice121_Corpo").getChild("slice122_Corpo")
        };
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = new ModelData();
        Map<String, ModelPartData> m = new HashMap<>();
        m.put("", data.getRoot());
        p0(m);
        p1(m);
        p2(m);
        return TexturedModelData.of(data, 256, 256);
    }

    private static void add(Map<String, ModelPartData> m, String parent, String name, ModelPartBuilder b, ModelTransform t) {
        m.put(name, m.get(parent).addChild(name, b, t));
    }

    private static void p0(Map<String, ModelPartData> m) {
        add(m, "", "n0_x", ModelPartBuilder.create(), ModelTransform.of(0f, 26.8932f, 0f, 0f, 0f, 0f));
        add(m, "n0_x", "n1_Head", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "n1_Head", "n2_Focinho", ModelPartBuilder.create().uv(224, 74).cuboid(-2.9f, -1f, -17.1f, 6, 2, 7, new Dilation(-0.1f, 0.15f, 0.15f)), ModelTransform.of(0f, -19f, -27f, 0.2618f, 0f, 0f));
        add(m, "n1_Head", "n3_Cabeça", ModelPartBuilder.create().uv(0, 90).cuboid(-2.7f, -1.3268f, -16.8886f, 5, 2, 7, new Dilation(0.2f, -0.15f, 0.05f)), ModelTransform.of(0f, -19f, -27f, 0.5236f, 0f, 0f));
        add(m, "n1_Head", "n4_Cabeça", ModelPartBuilder.create().uv(0, 0).cuboid(-2.8287f, -7.9f, 0.48f, 1, 15, 14, new Dilation(-0.4995f, -0.1f, 0f)), ModelTransform.of(0f, -19f, -27f, 0.2669f, -0.1938f, -0.0526f));
        add(m, "n1_Head", "n5_Cabeça", ModelPartBuilder.create().uv(30, 0).cuboid(2.8998f, -7.9f, 0.3452f, 1, 15, 14, new Dilation(-0.4995f, -0.1f, 0f)), ModelTransform.of(0f, -19f, -27f, 0.2665f, 0.1854f, 0.0503f));
        add(m, "n1_Head", "n6_Focinho_cima", ModelPartBuilder.create().uv(60, 90).cuboid(-1.7f, -1.9f, -17.1f, 3, 1, 7, new Dilation(0.2f, 0f, 0.15f)), ModelTransform.of(0f, -19f, -27f, 0.2618f, 0f, 0f));
        add(m, "n1_Head", "n7_Sombrancelha", ModelPartBuilder.create().uv(50, 107).cuboid(-0.15f, -1.1067f, -2.9037f, 1, 2, 3, new Dilation(-0.35f, -0.1f, 0.05f)), ModelTransform.of(-3.0611f, -20.2608f, -34.0209f, 0.5585f, 0f, -0.1745f));
        add(m, "n1_Head", "n8_Sombrancelha", ModelPartBuilder.create().uv(58, 107).cuboid(-0.25f, -1.0558f, -2.8973f, 1, 2, 3, new Dilation(-0.25f, -0.15f, 0.05f)), ModelTransform.of(3.05f, -20.2164f, -34.0003f, 0.5585f, 0f, 0.2618f));
        add(m, "n1_Head", "n9_Cabeça", ModelPartBuilder.create().uv(66, 107).cuboid(-0.25f, -1.0499f, -0.2454f, 1, 2, 3, new Dilation(-0.25f, -0.1f, 0.1f)), ModelTransform.of(3.05f, -20.2164f, -34.0003f, 0.2967f, 0f, 0.2618f));
        add(m, "n1_Head", "n10_Cabeça", ModelPartBuilder.create().uv(74, 107).cuboid(-0.15f, -1.1008f, -0.2389f, 1, 2, 3, new Dilation(-0.35f, -0.05f, 0.1f)), ModelTransform.of(-3.0611f, -20.2608f, -34.0209f, 0.2967f, 0f, -0.1745f));
        add(m, "n1_Head", "n11_Cabeça", ModelPartBuilder.create().uv(24, 90).cuboid(0.7341f, -3.4315f, -0.7157f, 2, 2, 7, new Dilation(0.05f, 0f, -0.15f)), ModelTransform.of(0f, -19f, -27f, 0.8029f, -0.0121f, -0.0126f));
        add(m, "n1_Head", "n12_Cabeça", ModelPartBuilder.create().uv(42, 90).cuboid(-2.8342f, -3.4315f, -0.5499f, 2, 2, 7, new Dilation(0.05f, 0f, -0.15f)), ModelTransform.of(0f, -19f, -27f, 0.8029f, 0.0121f, 0.0126f));
        add(m, "n1_Head", "n13_Bigode_frente", ModelPartBuilder.create().uv(194, 107).cuboid(0.7f, -13.9703f, -11.2477f, 1, 1, 2, new Dilation(-0.15f, -0.25f, 0f)), ModelTransform.of(0f, -19f, -27f, 1.1694f, 0f, 0f));
        add(m, "n1_Head", "n14_Cabeça", ModelPartBuilder.create().uv(200, 107).cuboid(-1.4f, -13.9703f, -11.2477f, 1, 1, 2, new Dilation(-0.15f, -0.25f, 0f)), ModelTransform.of(0f, -19f, -27f, 1.1694f, 0f, 0f));
        add(m, "n1_Head", "n15_Cabeça", ModelPartBuilder.create().uv(206, 107).cuboid(-1.4f, -16.8003f, -7.9638f, 1, 1, 2, new Dilation(-0.15f, -0.25f, 0f)), ModelTransform.of(0f, -19f, -27f, 1.501f, 0f, 0f));
        add(m, "n1_Head", "n16_Cabeça", ModelPartBuilder.create().uv(212, 107).cuboid(0.7f, -16.8003f, -7.9638f, 1, 1, 2, new Dilation(-0.15f, -0.25f, 0f)), ModelTransform.of(0f, -19f, -27f, 1.501f, 0f, 0f));
        add(m, "n1_Head", "n17_Cabeça", ModelPartBuilder.create().uv(82, 107).cuboid(-1.4f, -0.2833f, -2.531f, 1, 1, 3, new Dilation(-0.15f, -0.25f, -0.1f)), ModelTransform.of(0f, -12.1f, -44f, 1.885f, 0f, 0f));
        add(m, "n1_Head", "n18_Cabeça", ModelPartBuilder.create().uv(90, 107).cuboid(0.7f, -0.2833f, -2.531f, 1, 1, 3, new Dilation(-0.15f, -0.25f, -0.1f)), ModelTransform.of(0f, -12.1f, -44f, 1.885f, 0f, 0f));
        add(m, "n1_Head", "n19_Cabeça", ModelPartBuilder.create().uv(98, 107).cuboid(-1.4f, 0.1464f, -1.7809f, 1, 1, 3, new Dilation(-0.15f, -0.25f, -0.1f)), ModelTransform.of(0f, -9f, -43.6f, 1.7017f, 0f, 0f));
        add(m, "n1_Head", "n20_Cabeça", ModelPartBuilder.create().uv(106, 107).cuboid(0.7f, 0.1464f, -1.7809f, 1, 1, 3, new Dilation(-0.15f, -0.25f, -0.1f)), ModelTransform.of(0f, -9f, -43.6f, 1.7017f, 0f, 0f));
        add(m, "n1_Head", "n21_Cabeça", ModelPartBuilder.create().uv(114, 107).cuboid(-1.3f, -18.6762f, -9.8438f, 1, 1, 3, new Dilation(-0.25f, -0.35f, -0.1f)), ModelTransform.of(0f, -19f, -27f, 1.8326f, 0f, 0f));
        add(m, "n1_Head", "n22_Cabeça", ModelPartBuilder.create().uv(122, 107).cuboid(0.8f, -18.6762f, -9.8438f, 1, 1, 3, new Dilation(-0.25f, -0.35f, -0.1f)), ModelTransform.of(0f, -19f, -27f, 1.8326f, 0f, 0f));
        add(m, "n1_Head", "n23_Cabeça", ModelPartBuilder.create().uv(130, 107).cuboid(-1.2f, 0.2486f, -2.6496f, 1, 1, 3, new Dilation(-0.35f, -0.45f, -0.1f)), ModelTransform.of(0f, -4.5f, -42.5f, 2.3998f, 0f, 0f));
        add(m, "n1_Head", "n24_Cabeça", ModelPartBuilder.create().uv(138, 107).cuboid(0.9f, 0.2486f, -2.6496f, 1, 1, 3, new Dilation(-0.35f, -0.45f, -0.1f)), ModelTransform.of(0f, -4.5f, -42.5f, 2.3998f, 0f, 0f));
        add(m, "n1_Head", "n25_Bigode_baixo", ModelPartBuilder.create().uv(148, 52).cuboid(-0.001f, 3.2f, -16.3f, 1, 5, 12, new Dilation(-0.4995f, 0.2f, -0.1f)), ModelTransform.of(0f, -19f, -27f, 0.2618f, 0f, 0f));
        add(m, "n1_Head", "n26_Chifres", ModelPartBuilder.create().uv(118, 99).cuboid(-0.6471f, -3.5213f, -3.4043f, 1, 1, 6, new Dilation(-0.05f, 0.2f, -0.1f)), ModelTransform.of(0f, -19f, -27f, 1.9714f, -0.0891f, -2.292f));
        add(m, "n1_Head", "n27_Chifres", ModelPartBuilder.create().uv(132, 99).cuboid(-0.6471f, -3.7811f, -4.2484f, 1, 1, 6, new Dilation(-0.05f, 0.2f, -0.1f)), ModelTransform.of(0f, -19f, -27f, 2.3031f, -0.0891f, -2.292f));
        add(m, "n1_Head", "n28_Chifres", ModelPartBuilder.create().uv(80, 90).cuboid(-0.6471f, -4.1892f, -6.2368f, 1, 1, 7, new Dilation(-0.05f, 0.2f, -0.2f)), ModelTransform.of(0f, -19f, -27f, 2.5125f, -0.0891f, -2.292f));
        add(m, "n1_Head", "n29_Chifres", ModelPartBuilder.create().uv(96, 90).cuboid(-0.6471f, -4.6708f, -8.1683f, 1, 1, 7, new Dilation(-0.05f, 0.2f, -0.2f)), ModelTransform.of(0f, -19f, -27f, 2.6347f, -0.0891f, -2.292f));
        add(m, "n1_Head", "n30_Chifres", ModelPartBuilder.create().uv(112, 90).cuboid(-0.5471f, -4.5708f, -10.8683f, 1, 1, 7, new Dilation(-0.15f, 0.1f, -0.2f)), ModelTransform.of(0f, -19f, -27f, 2.6347f, -0.0891f, -2.292f));
        add(m, "n1_Head", "n31_Chifres", ModelPartBuilder.create().uv(128, 90).cuboid(-0.4471f, -4.4708f, -13.6683f, 1, 1, 7, new Dilation(-0.25f, 0f, -0.2f)), ModelTransform.of(0f, -19f, -27f, 2.6347f, -0.0891f, -2.292f));
        add(m, "n1_Head", "n32_Cabeça", ModelPartBuilder.create().uv(146, 99).cuboid(-1.7806f, -3.4486f, -3.5541f, 1, 1, 6, new Dilation(-0.05f, 0.2f, -0.1f)), ModelTransform.of(0f, -19f, -27f, 2.0577f, -0.1046f, 1.9526f));
        add(m, "n1_Head", "n33_Cabeça", ModelPartBuilder.create().uv(160, 99).cuboid(-1.7806f, -3.7611f, -4.4137f, 1, 1, 6, new Dilation(-0.05f, 0.2f, -0.1f)), ModelTransform.of(0f, -19f, -27f, 2.3893f, -0.1046f, 1.9526f));
        add(m, "n1_Head", "n34_Cabeça", ModelPartBuilder.create().uv(144, 90).cuboid(-1.7806f, -4.204f, -6.4027f, 1, 1, 7, new Dilation(-0.05f, 0.2f, -0.2f)), ModelTransform.of(0f, -19f, -27f, 2.5987f, -0.1046f, 1.9526f));
        add(m, "n1_Head", "n35_Cabeça", ModelPartBuilder.create().uv(160, 90).cuboid(-1.7806f, -4.7058f, -8.3311f, 1, 1, 7, new Dilation(-0.05f, 0.2f, -0.2f)), ModelTransform.of(0f, -19f, -27f, 2.7209f, -0.1046f, 1.9526f));
        add(m, "n1_Head", "n36_Cabeça", ModelPartBuilder.create().uv(176, 90).cuboid(-1.6806f, -4.6058f, -11.0311f, 1, 1, 7, new Dilation(-0.15f, 0.1f, -0.2f)), ModelTransform.of(0f, -19f, -27f, 2.7209f, -0.1046f, 1.9526f));
        add(m, "n1_Head", "n37_Cabeça", ModelPartBuilder.create().uv(192, 90).cuboid(-1.5806f, -4.5058f, -13.8311f, 1, 1, 7, new Dilation(-0.25f, 0f, -0.2f)), ModelTransform.of(0f, -19f, -27f, 2.7209f, -0.1046f, 1.9526f));
        add(m, "n1_Head", "n38_Cabeça", ModelPartBuilder.create().uv(48, 99).cuboid(-2.6531f, -2.0003f, 6.2647f, 1, 2, 6, new Dilation(0.25f, -0.15f, -0.15f)), ModelTransform.of(0f, -19f, -27f, 1.0298f, 0.009f, 0.015f));
        add(m, "n1_Head", "n39_Cabeça", ModelPartBuilder.create().uv(208, 90).cuboid(1.1531f, -2.0003f, 6.0989f, 2, 2, 6, new Dilation(-0.25f, -0.15f, -0.15f)), ModelTransform.of(0f, -19f, -27f, 1.0298f, -0.009f, -0.015f));
        add(m, "n1_Head", "n40_Bigode_baixo", ModelPartBuilder.create().uv(174, 52).cuboid(-2.651f, 3.2f, -9.3f, 1, 5, 12, new Dilation(-0.4995f, 0.2f, -0.1f)), ModelTransform.of(0f, -19f, -27f, 0.2618f, 0f, 0f));
        add(m, "n1_Head", "n41_Bigode_baixo", ModelPartBuilder.create().uv(200, 52).cuboid(2.749f, 3.2f, -9.3f, 1, 5, 12, new Dilation(-0.4995f, 0.2f, -0.1f)), ModelTransform.of(0f, -19f, -27f, 0.2618f, 0f, 0f));
        add(m, "n1_Head", "n42_Cabeça", ModelPartBuilder.create().uv(174, 99).cuboid(-2.7309f, -0.5106f, 10.7202f, 1, 1, 6, new Dilation(0.2f, 0.2f, -0.15f)), ModelTransform.of(0f, -19f, -27f, 1.152f, 0.0071f, 0.0159f));
        add(m, "n1_Head", "n43_Cabeça", ModelPartBuilder.create().uv(188, 99).cuboid(1.2309f, -0.5106f, 10.5544f, 1, 1, 6, new Dilation(0.2f, 0.2f, -0.15f)), ModelTransform.of(0f, -19f, -27f, 1.152f, -0.0071f, -0.0159f));
        add(m, "n1_Head", "n44_Dentes", ModelPartBuilder.create().uv(14, 107).cuboid(-0.001f, -0.55f, -2.65f, 1, 2, 5, new Dilation(-0.4995f, -0.25f, 0.15f)), ModelTransform.of(2.5668f, -13.5224f, -40.2648f, 0.5318f, -0.0044f, -0.0194f));
        add(m, "n1_Head", "n45_Dentes", ModelPartBuilder.create().uv(26, 107).cuboid(-0.101f, -0.65f, -2.65f, 1, 2, 5, new Dilation(-0.4995f, -0.25f, 0.15f)), ModelTransform.of(-2.4305f, -13.6331f, -39.9841f, 0.5318f, 0.01f, -0.0095f));
        add(m, "n1_Head", "n46_Dentes", ModelPartBuilder.create().uv(224, 90).cuboid(2.799f, 1.3f, -16.9f, 1, 1, 7, new Dilation(-0.4995f, 0.15f, 0.05f)), ModelTransform.of(0f, -19f, -27f, 0.2618f, 0f, 0f));
        add(m, "n1_Head", "n47_Dentes", ModelPartBuilder.create().uv(240, 90).cuboid(0.499f, -0.65f, -6.05f, 1, 1, 7, new Dilation(-0.4995f, 0.15f, 0.05f)), ModelTransform.of(-2.6299f, -12.6528f, -43.1539f, 1.6034f, -1.3089f, -1.6045f));
        add(m, "n1_Head", "n48_Dentes", ModelPartBuilder.create().uv(38, 107).cuboid(16.4845f, -3.707f, -1.7143f, 1, 2, 5, new Dilation(-0.4995f, -0.25f, 0.15f)), ModelTransform.of(0f, -19f, -27f, 1.6518f, 0.967f, 1.6527f));
        add(m, "n1_Head", "n49_Dentes", ModelPartBuilder.create().uv(0, 99).cuboid(-2.801f, 1.3f, -16.9f, 1, 1, 7, new Dilation(-0.4995f, 0.15f, 0.05f)), ModelTransform.of(0f, -19f, -27f, 0.2618f, 0f, 0f));
        add(m, "n1_Head", "n50_Cabeça", ModelPartBuilder.create().uv(0, 74).cuboid(-2.9f, -3.2f, -9.9f, 6, 6, 10, new Dilation(-0.1f, 0.2f, -0.1f)), ModelTransform.of(0f, -19f, -27f, 0.2618f, 0f, 0f));
        add(m, "n0_x", "n51_Corpo", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 0f, 0f, 0f, 0f));
        add(m, "n51_Corpo", "slice113_Corpo", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, -11f, 0f, 0f, 0f));
        add(m, "slice113_Corpo", "slice114_Corpo", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 8.3856f, 0f, 0f, 0f));
        add(m, "slice114_Corpo", "slice115_Corpo", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 8.3856f, 0f, 0f, 0f));
        add(m, "slice115_Corpo", "slice116_Corpo", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 8.3856f, 0f, 0f, 0f));
        add(m, "slice116_Corpo", "slice117_Corpo", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 8.3856f, 0f, 0f, 0f));
        add(m, "slice117_Corpo", "slice118_Corpo", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 8.3856f, 0f, 0f, 0f));
        add(m, "slice118_Corpo", "slice119_Corpo", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 8.3856f, 0f, 0f, 0f));
        add(m, "slice119_Corpo", "slice120_Corpo", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 8.3856f, 0f, 0f, 0f));
    }

    private static void p1(Map<String, ModelPartData> m) {
        add(m, "slice120_Corpo", "slice121_Corpo", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 8.3856f, 0f, 0f, 0f));
        add(m, "slice121_Corpo", "slice122_Corpo", ModelPartBuilder.create(), ModelTransform.of(0f, 0f, 8.3856f, 0f, 0f, 0f));
        add(m, "slice122_Corpo", "n106_Corpo", ModelPartBuilder.create().uv(0, 52).cuboid(-0.084f, -3.1745f, -1.2902f, 4, 5, 17, new Dilation(0f, -0.2f, 0.05f)), ModelTransform.of(1.9302f, -16.5348f, 8.3856f, -0.1575f, 0.5877f, -0.0878f));
        add(m, "slice121_Corpo", "n56_Corpo", ModelPartBuilder.create().uv(188, 29).cuboid(0.2f, -4.7884f, -1.2369f, 4, 5, 17, new Dilation(0.2f, 0.2f, 0.05f)), ModelTransform.of(-2.4f, -17.4987f, 0.1499f, -0.1343f, 0.2249f, -0.0301f));
        add(m, "slice120_Corpo", "n86_Corpo", ModelPartBuilder.create().uv(144, 74).cuboid(-2.3797f, 1.6648f, -8.9914f, 3, 3, 9, new Dilation(0f, -0.25f, 0.15f)), ModelTransform.of(12.061f, -11.2085f, 2.063f, -0.6498f, 0.2368f, 0.1128f));
        add(m, "slice120_Corpo", "n87_Braços", ModelPartBuilder.create().uv(230, 99).cuboid(-1.4638f, 0.416f, -2.745f, 2, 2, 5, new Dilation(0.1f, 0.05f, -0.2f)), ModelTransform.of(12.061f, -11.2085f, 2.063f, 0.2446f, 0.3535f, 0.099f));
        add(m, "slice120_Corpo", "n88_Braços", ModelPartBuilder.create().uv(30, 114).cuboid(-0.2614f, 1.3479f, 0.9396f, 1, 1, 2, new Dilation(-0.25f, 0.1f, 0f)), ModelTransform.of(12.061f, -11.2085f, 2.063f, 0.3883f, 0.889f, 0.3365f));
        add(m, "slice120_Corpo", "n89_Braços", ModelPartBuilder.create().uv(170, 107).cuboid(0.2362f, 0.816f, 1.855f, 1, 2, 2, new Dilation(-0.25f, -0.15f, 0f)), ModelTransform.of(12.061f, -11.2085f, 2.063f, 0.2446f, 0.3535f, 0.099f));
        add(m, "slice120_Corpo", "n90_Braços", ModelPartBuilder.create().uv(36, 114).cuboid(0.4852f, 3.0445f, 2.4474f, 1, 1, 2, new Dilation(-0.4995f, -0.2f, -0.1f)), ModelTransform.of(12.061f, -11.2085f, 2.063f, 0.6897f, 0.3535f, 0.099f));
        add(m, "slice120_Corpo", "n91_Braços", ModelPartBuilder.create().uv(42, 114).cuboid(-0.6638f, 1.116f, 1.855f, 1, 1, 2, new Dilation(-0.25f, 0.2f, 0f)), ModelTransform.of(12.061f, -11.2085f, 2.063f, 0.2446f, 0.3535f, 0.099f));
        add(m, "slice120_Corpo", "n92_Braços", ModelPartBuilder.create().uv(176, 107).cuboid(-1.4638f, 0.816f, 1.855f, 1, 2, 2, new Dilation(-0.25f, -0.15f, 0f)), ModelTransform.of(12.061f, -11.2085f, 2.063f, 0.2446f, 0.3535f, 0.099f));
        add(m, "slice120_Corpo", "n93_Braços", ModelPartBuilder.create().uv(48, 114).cuboid(-0.4148f, 3.3445f, 2.4474f, 1, 1, 2, new Dilation(-0.4995f, -0.35f, -0.1f)), ModelTransform.of(12.061f, -11.2085f, 2.063f, 0.6897f, 0.3535f, 0.099f));
        add(m, "slice120_Corpo", "n94_Braços", ModelPartBuilder.create().uv(54, 114).cuboid(-1.2148f, 3.0445f, 2.4474f, 1, 1, 2, new Dilation(-0.4995f, -0.2f, -0.1f)), ModelTransform.of(12.061f, -11.2085f, 2.063f, 0.6897f, 0.3535f, 0.099f));
        add(m, "slice119_Corpo", "n55_Corpo", ModelPartBuilder.create().uv(0, 29).cuboid(-2.4f, -3.5f, -0.9f, 5, 6, 17, new Dilation(-0.1f, 0f, 0.05f)), ModelTransform.of(0f, -17f, 0.6866f, 0.1309f, 0f, 0f));
        add(m, "slice119_Corpo", "n95_Corpo", ModelPartBuilder.create().uv(60, 74).cuboid(-3.077f, -2.8395f, -17.7494f, 5, 5, 9, new Dilation(0.1f, 0.1f, 0.15f)), ModelTransform.of(-8.7582f, -11.9646f, 3.3903f, -0.1573f, -0.2479f, -0.0464f));
        add(m, "slice119_Corpo", "n96_Corpo", ModelPartBuilder.create().uv(116, 74).cuboid(-2.777f, -4.3989f, -8.7184f, 5, 3, 9, new Dilation(-0.2f, 0.05f, 0.15f)), ModelTransform.of(-8.7582f, -11.9646f, 3.3903f, 0.2441f, -0.2479f, -0.0464f));
        add(m, "slice119_Corpo", "n97_Corpo", ModelPartBuilder.create().uv(168, 74).cuboid(-2.2893f, -2.5551f, -2.5346f, 3, 3, 9, new Dilation(0f, -0.25f, 0.15f)), ModelTransform.of(-8.7582f, -11.9646f, 3.3903f, -0.7064f, -0.2663f, 0.1136f));
        add(m, "slice119_Corpo", "n98_Braços", ModelPartBuilder.create().uv(0, 107).cuboid(-2.277f, 2.8239f, 4.5384f, 2, 2, 5, new Dilation(0.1f, 0.05f, -0.2f)), ModelTransform.of(-8.7582f, -11.9646f, 3.3903f, 0.1961f, -0.1504f, 0.0939f));
        add(m, "slice119_Corpo", "n99_Braços", ModelPartBuilder.create().uv(60, 114).cuboid(-4.8131f, 3.8105f, 6.6601f, 1, 1, 2, new Dilation(-0.25f, 0.1f, 0f)), ModelTransform.of(-8.7582f, -11.9646f, 3.3903f, 0.2136f, 0.4014f, 0.228f));
        add(m, "slice119_Corpo", "n100_Braços", ModelPartBuilder.create().uv(182, 107).cuboid(-0.577f, 3.2239f, 9.1384f, 1, 2, 2, new Dilation(-0.25f, -0.15f, 0f)), ModelTransform.of(-8.7582f, -11.9646f, 3.3903f, 0.1961f, -0.1504f, 0.0939f));
        add(m, "slice119_Corpo", "n101_Braços", ModelPartBuilder.create().uv(66, 114).cuboid(-0.328f, 8.3534f, 7.9846f, 1, 1, 2, new Dilation(-0.4995f, -0.2f, -0.1f)), ModelTransform.of(-8.7582f, -11.9646f, 3.3903f, 0.6412f, -0.1504f, 0.0939f));
        add(m, "slice119_Corpo", "n102_Braços", ModelPartBuilder.create().uv(72, 114).cuboid(-1.477f, 3.5239f, 9.1384f, 1, 1, 2, new Dilation(-0.25f, 0.2f, 0f)), ModelTransform.of(-8.7582f, -11.9646f, 3.3903f, 0.1961f, -0.1504f, 0.0939f));
        add(m, "slice119_Corpo", "n103_Braços", ModelPartBuilder.create().uv(188, 107).cuboid(-2.277f, 3.2239f, 9.1384f, 1, 2, 2, new Dilation(-0.25f, -0.15f, 0f)), ModelTransform.of(-8.7582f, -11.9646f, 3.3903f, 0.1961f, -0.1504f, 0.0939f));
        add(m, "slice119_Corpo", "n104_Braços", ModelPartBuilder.create().uv(78, 114).cuboid(-1.228f, 8.6534f, 7.9846f, 1, 1, 2, new Dilation(-0.4995f, -0.35f, -0.1f)), ModelTransform.of(-8.7582f, -11.9646f, 3.3903f, 0.6412f, -0.1504f, 0.0939f));
        add(m, "slice119_Corpo", "n105_Braços", ModelPartBuilder.create().uv(84, 114).cuboid(-2.028f, 8.3534f, 7.9846f, 1, 1, 2, new Dilation(-0.4995f, -0.2f, -0.1f)), ModelTransform.of(-8.7582f, -11.9646f, 3.3903f, 0.6412f, -0.1504f, 0.0939f));
        add(m, "slice119_Corpo", "n110_Corpo", ModelPartBuilder.create().uv(42, 52).cuboid(-0.001f, -1.1f, -0.9f, 1, 5, 17, new Dilation(-0.4995f, 0.2f, 0.05f)), ModelTransform.of(0f, -23.6f, 0.6866f, 0.1309f, 0f, 0f));
        add(m, "slice117_Corpo", "n54_Corpo", ModelPartBuilder.create().uv(198, 0).cuboid(-2.6f, -4f, -0.7f, 5, 6, 17, new Dilation(0.1f, 0.2f, 0.05f)), ModelTransform.of(0f, -14f, 0.4578f, 0.1745f, 0f, 0f));
        add(m, "slice117_Corpo", "n84_Corpo", ModelPartBuilder.create().uv(32, 74).cuboid(-0.3943f, -3.1125f, 0.8301f, 5, 5, 9, new Dilation(0.1f, 0.1f, 0.15f)), ModelTransform.of(2.8418f, -14.6916f, 2.7241f, -0.1806f, 0.2577f, -0.0465f));
        add(m, "slice117_Corpo", "n85_Corpo", ModelPartBuilder.create().uv(88, 74).cuboid(-0.0943f, 2.6094f, 8.4907f, 5, 3, 9, new Dilation(-0.2f, 0.05f, 0.15f)), ModelTransform.of(2.8418f, -14.6916f, 2.7241f, 0.2209f, 0.2577f, -0.0465f));
        add(m, "slice117_Corpo", "n109_Corpo", ModelPartBuilder.create().uv(116, 29).cuboid(-0.001f, -1.6f, -0.7f, 1, 6, 17, new Dilation(-0.4995f, -0.1f, 0.05f)), ModelTransform.of(0f, -20.6f, 0.4578f, 0.1745f, 0f, 0f));
        add(m, "slice115_Corpo", "n53_Corpo", ModelPartBuilder.create().uv(106, 0).cuboid(-2.9f, -1.7f, -2.95f, 6, 7, 17, new Dilation(-0.1f, 0f, 0.05f)), ModelTransform.of(0f, -14.5f, 2.6789f, 0.1309f, 0f, 0f));
        add(m, "slice115_Corpo", "n65_Braços", ModelPartBuilder.create().uv(224, 107).cuboid(-1.0751f, -0.3382f, -0.1053f, 1, 1, 2, new Dilation(-0.4995f, -0.2f, -0.1f)), ModelTransform.of(-9.4567f, -7.9335f, 6.5324f, 0.4102f, -0.2618f, 0f));
        add(m, "slice115_Corpo", "n66_Braços", ModelPartBuilder.create().uv(230, 107).cuboid(-0.2751f, -0.0382f, -0.1053f, 1, 1, 2, new Dilation(-0.4995f, -0.35f, -0.1f)), ModelTransform.of(-9.4567f, -7.9335f, 6.5324f, 0.4102f, -0.2618f, 0f));
        add(m, "slice115_Corpo", "n67_Braços", ModelPartBuilder.create().uv(236, 107).cuboid(0.6249f, -0.3382f, -0.1053f, 1, 1, 2, new Dilation(-0.4995f, -0.2f, -0.1f)), ModelTransform.of(-9.4567f, -7.9335f, 6.5324f, 0.4102f, -0.2618f, 0f));
        add(m, "slice115_Corpo", "n68_Braços", ModelPartBuilder.create().uv(242, 107).cuboid(-0.25f, -0.3058f, -1.8031f, 1, 1, 2, new Dilation(-0.25f, 0.1f, 0f)), ModelTransform.of(-7.5708f, -8.2692f, 5.5669f, -0.0349f, 0.3054f, 0f));
        add(m, "slice115_Corpo", "n69_Braços", ModelPartBuilder.create().uv(248, 107).cuboid(-0.001f, 0.2058f, -0.1561f, 1, 1, 2, new Dilation(-0.4995f, -0.15f, -0.1f)), ModelTransform.of(-7.5708f, -8.2692f, 5.5669f, 0.4102f, 0.3054f, 0f));
        add(m, "slice115_Corpo", "n108_Corpo", ModelPartBuilder.create().uv(80, 29).cuboid(-0.3f, 0.7f, -2.95f, 1, 6, 17, new Dilation(-0.2f, 0.2f, 0.05f)), ModelTransform.of(0f, -21.1f, 2.6789f, 0.1309f, 0f, 0f));
        add(m, "slice114_Corpo", "n57_Braços", ModelPartBuilder.create().uv(192, 74).cuboid(-1.7f, -4.0317f, -8.1624f, 3, 5, 5, new Dilation(0.2f, -0.1f, 0.05f)), ModelTransform.of(-6.2779f, -11.7683f, 2.1885f, 0f, -0.2618f, 0f));
        add(m, "slice114_Corpo", "n58_Braços", ModelPartBuilder.create().uv(16, 99).cuboid(-1.7f, -2.9317f, -3.0624f, 3, 3, 5, new Dilation(0.2f, 0.25f, -0.2f)), ModelTransform.of(-6.2779f, -11.7683f, 2.1885f, 0f, -0.2618f, 0f));
        add(m, "slice114_Corpo", "n59_Braços", ModelPartBuilder.create().uv(62, 99).cuboid(-1.2f, -2.8164f, -0.004f, 2, 3, 5, new Dilation(0.2f, 0.05f, -0.2f)), ModelTransform.of(-6.2779f, -11.7683f, 2.1885f, -0.4189f, -0.2618f, 0f));
        add(m, "slice114_Corpo", "n60_Braços", ModelPartBuilder.create().uv(76, 99).cuboid(-1.1f, -3.4245f, 3.1642f, 2, 3, 5, new Dilation(0.1f, -0.15f, -0.2f)), ModelTransform.of(-6.2779f, -11.7683f, 2.1885f, -0.6458f, -0.2618f, 0f));
        add(m, "slice114_Corpo", "n61_Braços", ModelPartBuilder.create().uv(202, 99).cuboid(-0.8412f, 1.3673f, 2.0732f, 2, 2, 5, new Dilation(0.1f, 0.05f, -0.2f)), ModelTransform.of(-7.7305f, -11.1366f, 6.6097f, -0.0349f, -0.2618f, 0f));
        add(m, "slice114_Corpo", "n62_Braços", ModelPartBuilder.create().uv(146, 107).cuboid(-0.8412f, 1.7673f, 6.6732f, 1, 2, 2, new Dilation(-0.25f, -0.15f, 0f)), ModelTransform.of(-7.7305f, -11.1366f, 6.6097f, -0.0349f, -0.2618f, 0f));
        add(m, "slice114_Corpo", "n63_Braços", ModelPartBuilder.create().uv(218, 107).cuboid(-0.0412f, 2.0673f, 6.6732f, 1, 1, 2, new Dilation(-0.25f, 0.2f, 0f)), ModelTransform.of(-7.7305f, -11.1366f, 6.6097f, -0.0349f, -0.2618f, 0f));
        add(m, "slice114_Corpo", "n64_Braços", ModelPartBuilder.create().uv(152, 107).cuboid(0.8588f, 1.7673f, 6.6732f, 1, 2, 2, new Dilation(-0.25f, -0.15f, 0f)), ModelTransform.of(-7.7305f, -11.1366f, 6.6097f, -0.0349f, -0.2618f, 0f));
        add(m, "slice114_Corpo", "n70_Braços", ModelPartBuilder.create().uv(208, 74).cuboid(-1.3319f, -5.0984f, -12.4846f, 3, 5, 5, new Dilation(0.2f, -0.1f, 0.05f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, 0f, 0.3665f, 0f));
        add(m, "slice114_Corpo", "n71_Braços", ModelPartBuilder.create().uv(32, 99).cuboid(-1.3319f, -3.9984f, -7.3846f, 3, 3, 5, new Dilation(0.2f, 0.25f, -0.2f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, 0f, 0.3665f, 0f));
        add(m, "slice114_Corpo", "n72_Braços", ModelPartBuilder.create().uv(90, 99).cuboid(-0.8319f, -2.0328f, -4.3864f, 2, 3, 5, new Dilation(0.2f, 0.05f, -0.2f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, -0.4189f, 0.3665f, 0f));
        add(m, "slice114_Corpo", "n73_Braços", ModelPartBuilder.create().uv(104, 99).cuboid(-0.7319f, -1.6752f, -0.9296f, 2, 3, 5, new Dilation(0.1f, -0.15f, -0.2f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, -0.6458f, 0.3665f, 0f));
        add(m, "slice114_Corpo", "n74_Braços", ModelPartBuilder.create().uv(216, 99).cuboid(-0.7319f, 0.9213f, 2.382f, 2, 2, 5, new Dilation(0.1f, 0.05f, -0.2f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, -0.0349f, 0.3665f, 0f));
        add(m, "slice114_Corpo", "n75_Braços", ModelPartBuilder.create().uv(158, 107).cuboid(-0.7319f, 1.3213f, 6.982f, 1, 2, 2, new Dilation(-0.25f, -0.15f, 0f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, -0.0349f, 0.3665f, 0f));
        add(m, "slice114_Corpo", "n76_Braços", ModelPartBuilder.create().uv(0, 114).cuboid(0.0681f, 1.6213f, 6.982f, 1, 1, 2, new Dilation(-0.25f, 0.2f, 0f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, -0.0349f, 0.3665f, 0f));
        add(m, "slice114_Corpo", "n77_Braços", ModelPartBuilder.create().uv(164, 107).cuboid(0.9681f, 1.3213f, 6.982f, 1, 2, 2, new Dilation(-0.25f, -0.15f, 0f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, -0.0349f, 0.3665f, 0f));
        add(m, "slice114_Corpo", "n78_Braços", ModelPartBuilder.create().uv(6, 114).cuboid(-0.4829f, 5.7078f, 6.8574f, 1, 1, 2, new Dilation(-0.4995f, -0.2f, -0.1f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, 0.4102f, 0.3665f, 0f));
        add(m, "slice114_Corpo", "n79_Braços", ModelPartBuilder.create().uv(12, 114).cuboid(0.3171f, 6.0078f, 6.8574f, 1, 1, 2, new Dilation(-0.4995f, -0.35f, -0.1f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, 0.4102f, 0.3665f, 0f));
        add(m, "slice114_Corpo", "n80_Braços", ModelPartBuilder.create().uv(18, 114).cuboid(1.2171f, 5.7078f, 6.8574f, 1, 1, 2, new Dilation(-0.4995f, -0.2f, -0.1f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, 0.4102f, 0.3665f, 0f));
        add(m, "slice114_Corpo", "n81_Braços", ModelPartBuilder.create().uv(24, 114).cuboid(-2.3877f, 1.8674f, 5.6604f, 1, 1, 2, new Dilation(-0.25f, 0.1f, 0f)), ModelTransform.of(7.7479f, -10.7016f, 6.3683f, -0.0349f, 0.9338f, 0f));
        add(m, "slice113_Corpo", "n52_Corpo", ModelPartBuilder.create().uv(60, 0).cuboid(-2.9f, -4f, -0.1f, 6, 7, 17, new Dilation(-0.1f, 0f, 0.05f)), ModelTransform.of(0f, -14f, 1f, -0.1309f, 0f, 0f));
        add(m, "slice113_Corpo", "n82_Corpo", ModelPartBuilder.create().uv(78, 52).cuboid(-0.4f, 3f, -16.1f, 1, 3, 17, new Dilation(-0.1f, 0.05f, -0.25f)), ModelTransform.of(0f, -14f, 0f, -0.1745f, 0f, 0f));
        add(m, "slice113_Corpo", "n83_Corpo", ModelPartBuilder.create().uv(114, 52).cuboid(-0.001f, 6f, -16.1f, 1, 4, 16, new Dilation(-0.4995f, -0.25f, 0.2f)), ModelTransform.of(0f, -14f, 0f, -0.1745f, 0f, 0f));
    }

    private static void p2(Map<String, ModelPartData> m) {
        add(m, "slice113_Corpo", "n107_Corpo", ModelPartBuilder.create().uv(44, 29).cuboid(-0.3f, -1.6f, -0.1f, 1, 6, 17, new Dilation(-0.2f, 0.2f, 0.05f)), ModelTransform.of(0f, -20.6f, 1f, -0.1309f, 0f, 0f));
        add(m, "slice113_Corpo", "n111_Corpo", ModelPartBuilder.create().uv(152, 29).cuboid(-0.3f, -1.6f, -16.1f, 1, 6, 17, new Dilation(-0.2f, 0.2f, 0.05f)), ModelTransform.of(0f, -20.6f, 1f, -0.1309f, 0f, 0f));
        add(m, "slice113_Corpo", "n112_Corpo", ModelPartBuilder.create().uv(152, 0).cuboid(-2.8f, -4.1f, -16.1f, 6, 7, 17, new Dilation(-0.2f, 0.1f, 0.05f)), ModelTransform.of(0f, -14f, 0f, -0.1745f, 0f, 0f));
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
