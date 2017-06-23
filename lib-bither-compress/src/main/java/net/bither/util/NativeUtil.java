package net.bither.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;

import java.io.ByteArrayOutputStream;

import static android.media.CamcorderProfile.QUALITY_720P;

public class NativeUtil {

    public final static int QUALITY_320P = 320;//480, 320
    public final static int QUALITY_360P = 360;//640, 360
    public final static int QUALITY_480P = 480;//640, 480
    public final static int QUALITY_720P = 720;//1280, 720
    public final static int QUALITY_1080P = 1080;//1920, 1080
    public final static int QUALITY_2K = 1440;//2560, 1440
    public final static int QUALITY_4K = 2160;//3840, 2160

    public final static int QUALITY_DEFAULT = QUALITY_720P;
    public final static int SIZE_1KB = 1024;
    public final static int size_1MB = SIZE_1KB * 1024;


    public static void compressBitmap(Bitmap bitmap, String filePath) {
        compressBitmap(bitmap, filePath, size_1MB, QUALITY_DEFAULT);
    }

    public static void compressBitmap(Bitmap bitmap, String filePath, int maxByte, int quality) {
        int w = bitmap.getWidth();
        int h = bitmap.getHeight();
        float ratio = getRatioSize(w, h, quality);

        int resultW = Math.round(w / ratio);
        int resultH = Math.round(h / ratio);

        Bitmap result = Bitmap.createBitmap(resultW, resultH, Config.ARGB_8888);
        Canvas canvas = new Canvas(result);
        Rect rect = new Rect(0, 0, resultW, resultH);
        canvas.drawBitmap(bitmap, null, rect, null);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int options = 80;//100不压缩品质
        result.compress(Bitmap.CompressFormat.JPEG, options, baos);
        while (baos.toByteArray().length > maxByte) {
            baos.reset();
            result.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        NativeUtil.saveBitmap(result, options, filePath, true);
        if (!result.isRecycled()) {
            result.recycle();
            result = null;
        }
    }


    /**
     * 计算缩放比例
     */
    private static float getRatioSize(int w, int h, int qualityH) {
        float ratio;
        if (w > h) {
            ratio = h * 100.00f / qualityH / 100f;
        } else {
            ratio = w * 100.00f / qualityH / 100f;
        }
        if (ratio <= 0) ratio = 1;
        return ratio;
    }

    /**
     * 调用native方法
     */
    private static void saveBitmap(Bitmap bitmap, int quality, String fileName, boolean optimize) {
        compressBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), quality, fileName.getBytes(), optimize);
    }

    /**
     * 调用底层 bitherlibjni.c中的方法
     */
    private static native String compressBitmap(Bitmap bit, int w, int h, int quality, byte[] fileNameBytes, boolean optimize);

    /**
     * 加载lib下两个so文件
     */
    static {
        System.loadLibrary("jpegbither");
        System.loadLibrary("bitherjni");
    }
}
