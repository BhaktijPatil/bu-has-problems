package destiny.bu.problems;

/*
Design a HashMap without using any built-in hash table libraries.

Implement the MyHashMap class:

MyHashMap() initializes the object with an empty map.
void put(int key, int value) inserts a (key, value) pair into the HashMap. If the key already exists in the map, update the corresponding value.
int get(int key) returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.


Example 1:

Input
["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
[[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
Output
[null, null, null, 1, -1, null, 1, null, -1]

Explanation
MyHashMap myHashMap = new MyHashMap();
myHashMap.put(1, 1); // The map is now [[1,1]]
myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
myHashMap.get(1);    // return 1, The map is now [[1,1], [2,2]]
myHashMap.get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
myHashMap.get(2);    // return -1 (i.e., not found), The map is now [[1,1]]


Constraints:

0 <= key, value <= 106
At most 104 calls will be made to put, get, and remove.

 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);

 */

import java.util.ArrayList;
import java.util.List;

public class CustomHashMapImplementation {

    List<CustomKeyValuePair> customHashMap;

    public CustomHashMapImplementation() {
        this.customHashMap = new ArrayList<>();
    }

    public void put(int key, int value) {
        customHashMap.stream()
                .filter(customKeyValuePair -> key == customKeyValuePair.getKey())
                .findFirst().ifPresentOrElse(
                        customKeyValuePair -> customKeyValuePair.setValue(value),
                        () -> customHashMap.add(new CustomKeyValuePair(key, value)));
    }

    public int get(int key) {
        return customHashMap.stream()
                .filter(customKeyValuePair -> key == customKeyValuePair.getKey())
                .findFirst()
                .map(CustomKeyValuePair::getValue)
                .orElse(-1);
    }

    public void remove(int key) {
        customHashMap.removeIf(customKeyValuePair -> customKeyValuePair.getKey() == key);
    }

    public static class CustomKeyValuePair {
        private final int key;
        private int value;

        public CustomKeyValuePair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}

// Notes - Not very performant
