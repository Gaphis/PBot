package cache;

import lombok.Getter;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ChatLogCache extends Cache{

    private String type;
    private String time;
    private String user;
    @Getter
    private String content;

    public ChatLogCache(String str, String log){
        content = log;
        parseChatInfo(str);
        cacheType = CacheType.ChatLog;
    }

    private void parseChatInfo(String str){
        String[] tmp = str.split("\\|", 4);
        type = tmp[0];
        time = tmp[1];
        user = tmp[2];
    }

    @Override
    public byte[] getCacheData() {
        return content.getBytes();
    }

    @Override
    public String getCacheInfo() {
        return cacheType.toString() + "/" + type + "|" + time + "|" + user;
    }

    @Override
    public void saveCache() {
        String path = CacheManager.cachePath;
        if (type.equals("msg")){
            path = path + "/msg/" + time + "/" + user;
        }else{
            path = path + "/team/" + type + "/" + time;
        }
        try {
            CacheManager.getCacheWriter(path).write(user + "|" + content);
        }catch (IOException e){}
    }

    @Override
    public void clearData(){
        super.clearData();
        type = null;
        time = null;
        user = null;
        content = null;
    }
}
