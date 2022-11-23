package cache;

import java.security.MessageDigest;

public abstract class Cache {
    protected MessageDigest messageDigest;
    protected byte[] data;
    protected CacheType cacheType;
    public abstract byte[] getCacheData();
    public abstract String getCacheInfo();
    public abstract void saveCache();
    public CacheType getCacheType(){
        return cacheType;
    }
    public String toString(){
        return getCacheInfo();
    }
    public void clearData(){
        data = null;
        messageDigest = null;
        cacheType = null;
    };
}
