package lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

    private int cacheSize;

    public LRUCache(int size){
        //设置为按access排序
        super((int)(size*0.75),0.75f,true);
        cacheSize = size;
    }

    /**
     * 每次put进去的时候，都会检查这个size
     * 如果超出size。移除lru最后的元素
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size()>cacheSize;
    }
}
