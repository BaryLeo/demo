package lru;

public class Test {
    public static void main(String[] args) {
        LRUCache<Integer,Integer> lruCache = new LRUCache<>(3);

        for (int i = 0;i<5;i++){
            lruCache.put(i,i);
        }

    }
}
