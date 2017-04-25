package study_android1.lampstudio.com.studyandroid_1.volley.untils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by VS9 X64Bit on 25/04/2017.
 */

public class LruBitmapCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {
    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    public LruBitmapCache(int maxSize) {
        super(maxSize);
    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }
    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight() / 1024;
    }
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url, bitmap);
    }
    public LruBitmapCache() {
        this(getDefaultLruCacheSize());
    }
    public static int getDefaultLruCacheSize() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 8;

        return cacheSize;
    }
}
