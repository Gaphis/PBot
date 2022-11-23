import cache.Cache;
import cache.ChatLogCache;
import cache.ImageCache;
import cache.ObjectCache;

public class Test {
    public static void main(String[] args) {
        Cache cache = new ImageCache("123", new byte[0]);
        System.out.println(cache.getCacheInfo());
        cache = new ChatLogCache("team|1:1:1|123", "asb");
        System.out.println(cache.getCacheInfo());
        cache = new ObjectCache("asb", new byte[0]);
        System.out.println(cache.getCacheInfo());
    }
}