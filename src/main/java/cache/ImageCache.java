package cache;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ImageCache extends Cache{
    private String md5;
    public ImageCache(String key, byte[] data){
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(key.getBytes());
            md5 = new BigInteger(1, messageDigest.digest()).toString(16);
        }catch (NoSuchAlgorithmException ignored){
            messageDigest = null;
            md5 = "";
        }finally {
            this.data = data;
            this.cacheType = CacheType.Image;
        }
    }

    @Override
    public byte[] getCacheData() {
        return data;
    }

    @Override
    public String getCacheInfo() {
        return getCacheType().toString() + "/" + md5;
    }

    @Override
    public void saveCache() {

    }

    @Override
    public void clearData(){
        super.clearData();
        md5 = null;
    }
}
