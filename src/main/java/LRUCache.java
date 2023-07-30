import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {

        Cache cache = new Cache(3);
        System.out.println(cache);
        cache.put("a", "apple");
        System.out.println(cache);

        cache.put("b", "banana");
        System.out.println(cache);

        cache.put("c", "car");
        System.out.println(cache);

        cache.put("d", "dad");
        System.out.println(cache);

        cache.get("b");
        System.out.println(cache);

        cache.put("e", "elephant");
        System.out.println(cache);

        cache.get("a");
        System.out.println(cache);

    }


}

class Cache {
    private final Map<String, LinkedListNode> storage = new HashMap<>();
    private final Integer limitSize;
    private LinkedListNode listHead = null;
    private LinkedListNode listTail = null;

    public Cache(Integer limitSize) {
        this.limitSize = limitSize;
    }

    public void put(String key, String value) {
        removeKey(key);

        if (storage.size() >= limitSize && listTail != null) {
            removeKey(listTail.key);
        }
        LinkedListNode newItem = new LinkedListNode(key, value);
        insertAtFrontOfLinkedList(newItem);
        storage.put(key, newItem);
    }

    public String get(String key) {
        LinkedListNode item = storage.get(key);
        if (item == null) return null;
        if (item != listHead) {
            removeFromLinkedList(item);
            insertAtFrontOfLinkedList(item);
        }
        return item.value;
    }

    private void removeFromLinkedList(LinkedListNode item) {
        if (item == null) return;
        if (item.prev != null) item.prev.next = item.next;
        if (item.next != null) item.next.prev = item.prev;
        if (item == listHead) listHead = item.next;
        if (item == listTail) listTail = item.prev;
    }

    private void insertAtFrontOfLinkedList(LinkedListNode item) {
        if (listHead == null) {
            listHead = item;
            listTail = item;
        } else {
            listHead.prev = item;
            item.next = listHead;
            listHead = item;
            listHead.prev = null;
        }
    }

    private void removeKey(String key) {
        LinkedListNode item = storage.get(key);
        removeFromLinkedList(item);
        storage.remove(key);
    }

    @Override
    public String toString() {
        return "Cache" + storage;
    }
}

class LinkedListNode {
    LinkedListNode next = null;
    LinkedListNode prev = null;
    String key;
    String value;

    public LinkedListNode(String key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "LinkedListNode{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
