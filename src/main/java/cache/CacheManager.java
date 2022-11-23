package cache;

import lombok.Getter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class CacheManager {

    public static final String cachePath;

    private static HashMap<String, Writer> cacheWriter = new HashMap<>();

    static{
        cachePath = ""; // load from properties
    }

    public static Writer getCacheWriter(String path) throws IOException {
        if (cacheWriter.containsKey(path)){
            return cacheWriter.get(path);
        }else{
            File f = new File(path);
            if (!f.exists()){f.createNewFile();}
            PrintWriter pw = new PrintWriter(new FileOutputStream(f, true), true, StandardCharsets.UTF_8);
            cacheWriter.put(path, pw);
            return pw;
        }
    }

    public static void saveCache(Cache cache){
        cache.saveCache();
    }

    public static Cache getCache(String identify){
        return null;
    }

    public static void exitLastDayWriter(){

    }
}
