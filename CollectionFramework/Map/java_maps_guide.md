# Understanding Maps and HashMaps in Java Collections Framework

## Table of Contents
1. [Introduction to Maps](#introduction-to-maps)
2. [The Map Interface](#the-map-interface)
3. [HashMap Implementation](#hashmap-implementation)
4. [HashMap Internal Working](#hashmap-internal-working)
5. [Common Map Operations](#common-map-operations)
6. [Performance Considerations](#performance-considerations)
7. [HashMap vs Other Map Implementations](#hashmap-vs-other-map-implementations)
8. [Common Pitfalls and Edge Cases](#common-pitfalls-and-edge-cases)
9. [Practical Examples](#practical-examples)
10. [Advanced Topics](#advanced-topics)
11. [Interview Questions](#interview-questions)

---

## Introduction to Maps

Maps are one of the fundamental data structures in Java's Collections Framework. Unlike Lists and Sets that store individual elements, Maps store **key-value pairs**, making them ideal for scenarios where you need to look up values based on a specific key.

### Key Features of Maps:
- Store elements as key-value pairs
- Keys must be unique
- Allow efficient lookups by key
- Do not preserve insertion order (by default)
- Not directly part of the Collection interface hierarchy

![Map Interface Hierarchy](https://www.javaguides.net/2018/08/hierarchy-of-map-interface-in-java.html)

> **Note**: Maps are not directly part of the Collection interface but are considered part of the Java Collections Framework.

---

## The Map Interface

The `Map` interface is the root interface for all map implementations in Java. It defines the essential operations that all map implementations must provide.

### Key Methods in the Map Interface:

```java
// Basic Operations
V put(K key, V value)           // Associates value with key, returns previous value
V get(Object key)               // Returns value associated with key, or null if not found
V remove(Object key)            // Removes key-value mapping, returns previous value
boolean containsKey(Object key) // Checks if map contains specified key
boolean containsValue(Object value) // Checks if map contains specified value
int size()                      // Returns number of key-value mappings
boolean isEmpty()               // Checks if map is empty
void clear()                    // Removes all mappings

// Bulk Operations
void putAll(Map<? extends K, ? extends V> m) // Copies all mappings from specified map
Set<K> keySet()                // Returns Set view of keys
Collection<V> values()         // Returns Collection view of values
Set<Map.Entry<K, V>> entrySet() // Returns Set view of key-value mappings

// Default Methods (Java 8+)
V getOrDefault(Object key, V defaultValue) // Returns value or default if key not found
void forEach(BiConsumer<? super K, ? super V> action) // Performs action for each entry
V putIfAbsent(K key, V value)  // Adds mapping only if key not present
```

> **Note**: Understanding these core methods is crucial for effectively working with all Map implementations.

### The Map.Entry Interface

The `Map.Entry` interface represents a key-value pair within a Map:

```java
public interface Entry<K, V> {
    K getKey();     // Returns the key
    V getValue();   // Returns the value
    V setValue(V value); // Replaces value with specified value
    // equals() and hashCode() methods
}
```

> **Pro tip**: The entrySet() method provides a powerful way to iterate through a Map's contents.

---

## HashMap Implementation

`HashMap` is the most commonly used implementation of the Map interface. It provides constant-time performance for basic operations (get and put) under the assumption of good hash functions.

### Key Characteristics:

- Uses a hash table implementation
- Permits null keys and null values
- Does not guarantee ordering of map entries
- Not synchronized (not thread-safe)
- Initial capacity and load factor affect performance

### Basic Usage:

```java
// Creating a HashMap
Map<String, Integer> ages = new HashMap<>();

// Adding elements
ages.put("John", 25);
ages.put("Jane", 30);
ages.put("Adam", 28);

// Accessing elements
Integer johnsAge = ages.get("John"); // Returns 25
Integer unknownAge = ages.get("Unknown"); // Returns null

// Checking existence
boolean hasJohn = ages.containsKey("John"); // true
boolean hasAge35 = ages.containsValue(35); // false

// Size
int size = ages.size(); // 3

// Iterating
for (Map.Entry<String, Integer> entry : ages.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}

// Output (order may vary):
// John: 25
// Jane: 30
// Adam: 28
```

> **Note**: Since HashMap doesn't maintain ordering, the iteration order may differ each time you run the program.

---

## HashMap Internal Working

Understanding how HashMap works internally will help you use it more effectively and avoid common pitfalls.

### Key Concepts:

1. **Hash Function**: Converts keys into array indices
2. **Buckets**: Array slots that can hold multiple entries
3. **Collision Resolution**: Handling when different keys hash to the same bucket

### Internal Structure (Java 8+):

```
+-----------------------------------------+
| Bucket 0 | -> Entry -> Entry            |
+-----------------------------------------+
| Bucket 1 | -> Entry                     |
+-----------------------------------------+
| Bucket 2 | -> null                      |
+-----------------------------------------+
| Bucket 3 | -> Entry -> Entry -> Entry   |
+-----------------------------------------+
...
```

### The Hashing Process:

1. When you `put(key, value)`:
   - HashMap calculates `hashCode()` of the key
   - Applies a hash function to determine the bucket index
   - Places the entry in that bucket
   - If a collision occurs (another key hashes to same bucket):
     - In Java 7: Entries form a linked list
     - In Java 8+: Entries form a linked list, which converts to a balanced tree if the list gets too long (> 8 entries)

2. When you `get(key)`:
   - HashMap calculates the hashCode to find the right bucket
   - Traverses entries in that bucket to find the matching key using `equals()`

> **Important**: For HashMap to work correctly, classes used as keys must properly implement `hashCode()` and `equals()` methods.

### Load Factor and Rehashing:

- **Load Factor**: Measure of how full the HashMap is allowed to get before capacity is increased
  - Default is 0.75 (75% full)
- **Rehashing**: Process of recreating the internal data structure with more buckets
  - Triggered when (number of entries) > (capacity * load factor)
  - Doubles the number of buckets and rehashes all existing entries

```java
// Specifying initial capacity and load factor
Map<String, Integer> customMap = new HashMap<>(16, 0.75f);
```

> **Pro tip**: Choose initial capacity wisely if you know approximately how many elements you'll store to minimize rehashing operations.

---

## Common Map Operations

Let's explore more operations with practical examples:

### Adding and Updating Elements

```java
Map<String, Double> prices = new HashMap<>();

// Adding elements
prices.put("Apple", 1.99);
prices.put("Banana", 0.99);

// Updating elements (overwrites existing value)
prices.put("Apple", 2.49);

// Add only if key doesn't exist
prices.putIfAbsent("Apple", 1.79); // Won't change Apple's price
prices.putIfAbsent("Orange", 2.99); // Will add Orange

System.out.println(prices);
// Output: {Apple=2.49, Orange=2.99, Banana=0.99}
```

### Removing Elements

```java
Map<Integer, String> students = new HashMap<>();
students.put(101, "Alice");
students.put(102, "Bob");
students.put(103, "Charlie");

// Remove by key
String removed = students.remove(102);
System.out.println("Removed: " + removed); // Output: Removed: Bob

// Remove by key-value pair (only removes if both match)
boolean wasRemoved = students.remove(103, "David");
System.out.println("Was removed: " + wasRemoved); // Output: Was removed: false

wasRemoved = students.remove(103, "Charlie");
System.out.println("Was removed: " + wasRemoved); // Output: Was removed: true

System.out.println(students); // Output: {101=Alice}
```

### Iteration Techniques

```java
Map<String, Integer> population = new HashMap<>();
population.put("New York", 8400000);
population.put("Los Angeles", 3900000);
population.put("Chicago", 2700000);

// Method 1: Using entrySet (most efficient)
for (Map.Entry<String, Integer> entry : population.entrySet()) {
    System.out.println(entry.getKey() + " has " + entry.getValue() + " people");
}

// Method 2: Using keySet
for (String city : population.keySet()) {
    System.out.println(city + " has " + population.get(city) + " people");
}

// Method 3: Using forEach (Java 8+)
population.forEach((city, pop) -> 
    System.out.println(city + " has " + pop + " people"));

/* Sample output:
New York has 8400000 people
Los Angeles has 3900000 people
Chicago has 2700000 people
*/
```

> **Performance Tip**: Using entrySet() for iteration is more efficient than keySet() with get() because it avoids additional lookups.

### Bulk Operations

```java
Map<String, Integer> map1 = new HashMap<>();
map1.put("A", 1);
map1.put("B", 2);

Map<String, Integer> map2 = new HashMap<>();
map2.put("B", 3);
map2.put("C", 4);

// Copy all entries from map2 to map1 (overwrites existing keys)
map1.putAll(map2);
System.out.println(map1); // Output: {A=1, B=3, C=4}

// Clear all entries
map1.clear();
System.out.println("Size after clear: " + map1.size()); // Output: Size after clear: 0
```

---

## Performance Considerations

### Time Complexity

| Operation | Average Case | Worst Case (Poor hash distribution) |
|-----------|-------------|------------------------------------|
| get()     | O(1)        | O(n)                               |
| put()     | O(1)        | O(n)                               |
| remove()  | O(1)        | O(n)                               |
| containsKey() | O(1)    | O(n)                               |
| containsValue() | O(n)  | O(n)                               |

> **Note**: The worst-case scenario occurs when there are many hash collisions, forcing HashMap to degrade to linear search through a linked list or tree.

### Memory Usage

HashMap maintains an array of buckets, with each bucket potentially containing multiple entries. The memory footprint includes:

- Internal array of buckets 
- Entry objects (key, value, hash code, and references)
- Overhead for linked lists or trees in buckets

For large collections, the memory overhead can be significant, especially after rehashing operations.

### Optimizing HashMap Performance

1. **Provide Good Initial Capacity**: If you know approximately how many elements you'll store, set the initial capacity to avoid rehashing.

    ```java
    // If expecting ~1000 elements, set initial capacity higher than 1000/0.75
    Map<String, Data> dataMap = new HashMap<>(1350);
    ```

2. **Use Good Hash Functions**: Ensure your key classes implement `hashCode()` properly:
   - Should generate well-distributed values
   - Equal objects must have equal hash codes
   - Hash code should remain consistent

3. **Choose Appropriate Keys**: Immutable objects make better keys as their hash codes won't change.

4. **Consider Alternatives**: For special cases, consider other Map implementations like `LinkedHashMap` or `TreeMap`.

---

## HashMap vs Other Map Implementations

Java provides several Map implementations, each with different characteristics:

### HashMap vs LinkedHashMap

**LinkedHashMap** maintains insertion order or access order by using a doubly-linked list.

```java
Map<String, Integer> linkedMap = new LinkedHashMap<>();
linkedMap.put("C", 3);
linkedMap.put("A", 1);
linkedMap.put("B", 2);

// Iteration preserves insertion order
for (String key : linkedMap.keySet()) {
    System.out.print(key + " "); // Output: C A B
}
```

**When to use LinkedHashMap**:
- When insertion order matters
- For implementing LRU caches (with access-order constructor)

### HashMap vs TreeMap

**TreeMap** keeps entries sorted by key using a Red-Black tree implementation:

```java
Map<String, Integer> treeMap = new TreeMap<>();
treeMap.put("C", 3);
treeMap.put("A", 1);
treeMap.put("B", 2);

// Iteration gives sorted order
for (String key : treeMap.keySet()) {
    System.out.print(key + " "); // Output: A B C
}
```

**When to use TreeMap**:
- When keys need to be sorted
- When you need range view operations (headMap, tailMap, subMap)

### HashMap vs Hashtable

**Hashtable** is a legacy class with synchronized methods:

```java
Map<String, Integer> hashtable = new Hashtable<>();
// All operations are thread-safe
hashtable.put("A", 1);
```

**When to use Hashtable**:
- Legacy code integration
- For simple thread-safety (though ConcurrentHashMap is generally better)

> **Note**: Hashtable doesn't allow null keys or values, unlike HashMap.

### Performance Comparison

| Map Type      | get/put | Iteration | Memory Usage | Thread-Safe |
|---------------|---------|-----------|--------------|-------------|
| HashMap       | O(1)    | No order  | Lower        | No          |
| LinkedHashMap | O(1)    | Ordered   | Higher       | No          |
| TreeMap       | O(log n)| Sorted    | Higher       | No          |
| Hashtable     | O(1)    | No order  | Similar      | Yes         |

---

## Common Pitfalls and Edge Cases

### Null Keys and Values

- HashMap allows one null key and multiple null values
- TreeMap doesn't allow null keys (throws NullPointerException)
- Hashtable doesn't allow null keys or values

```java
Map<String, Integer> map = new HashMap<>();
map.put(null, 0);       // Works fine
map.put("nullValue", null); // Also works fine

// Using null with TreeMap
Map<String, Integer> treeMap = new TreeMap<>();
// treeMap.put(null, 0); // Throws NullPointerException
```

### Mutable Keys

Using mutable objects as keys can break HashMap if the hash code changes after insertion:

```java
Map<List<Integer>, String> badMap = new HashMap<>();
List<Integer> key = new ArrayList<>();
key.add(1);

badMap.put(key, "Original");
System.out.println(badMap.get(key)); // Output: Original

// Modifying the key after insertion
key.add(2);
System.out.println(badMap.get(key)); // Output: null (can't find it anymore)
```

> **Best Practice**: Always use immutable objects as Map keys (String, Integer, etc.) or ensure your key objects don't change after being added to a Map.

### Equals and HashCode Contract

For custom key classes, you must properly implement both `equals()` and `hashCode()` methods:

```java
class Employee {
    private int id;
    private String name;
    
    // Constructor, getters, setters...
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
```

> **Critical Rule**: If two objects are equal according to `equals()`, they MUST have the same `hashCode()` value.

### Concurrent Modification

Modifying a HashMap while iterating can cause ConcurrentModificationException:

```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 95);
scores.put("Bob", 80);
scores.put("Charlie", 85);

// WRONG: Will throw ConcurrentModificationException
for (String name : scores.keySet()) {
    if (scores.get(name) < 90) {
        scores.remove(name); // Modifying during iteration
    }
}

// CORRECT: Use Iterator's remove method
Iterator<Map.Entry<String, Integer>> iter = scores.entrySet().iterator();
while (iter.hasNext()) {
    Map.Entry<String, Integer> entry = iter.next();
    if (entry.getValue() < 90) {
        iter.remove(); // Safe way to remove during iteration
    }
}

// ALTERNATIVE: Create a collection of keys to remove
List<String> keysToRemove = new ArrayList<>();
for (Map.Entry<String, Integer> entry : scores.entrySet()) {
    if (entry.getValue() < 90) {
        keysToRemove.add(entry.getKey());
    }
}
keysToRemove.forEach(scores::remove);
```

---

## Practical Examples

### Example 1: Word Frequency Counter

```java
public class WordFrequencyCounter {
    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> frequencies = new HashMap<>();
        String[] words = text.split("\\s+");
        
        for (String word : words) {
            // Clean the word
            word = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
            if (word.isEmpty()) continue;
            
            // Update frequency using getOrDefault
            frequencies.put(word, frequencies.getOrDefault(word, 0) + 1);
        }
        
        return frequencies;
    }
    
    public static void main(String[] args) {
        String text = "To be or not to be, that is the question";
        Map<String, Integer> frequencies = countWords(text);
        
        System.out.println("Word frequencies:");
        frequencies.forEach((word, count) -> 
            System.out.println(word + ": " + count));
    }
}

/* Output:
Word frequencies:
question: 1
the: 1
that: 1
is: 1
or: 1
not: 1
be: 2
to: 2
*/
```

### Example 2: Building a Cache with LinkedHashMap

```java
public class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;
    
    public SimpleLRUCache(int capacity) {
        // Access-order constructor with load factor 0.75
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // Remove oldest entry when size exceeds capacity
        return size() > capacity;
    }
    
    public static void main(String[] args) {
        SimpleLRUCache<Integer, String> cache = new SimpleLRUCache<>(3);
        
        cache.put(1, "One");
        cache.put(2, "Two");
        cache.put(3, "Three");
        
        System.out.println("Cache contents: " + cache);
        
        // Access an existing entry
        cache.get(1);
        
        // Add a new entry, should evict the least recently used (2)
        cache.put(4, "Four");
        
        System.out.println("Cache after access and new entry: " + cache);
    }
}

/* Output:
Cache contents: {1=One, 2=Two, 3=Three}
Cache after access and new entry: {3=Three, 1=One, 4=Four}
*/
```

### Example 3: Group By Operation

```java
public class StudentGrouping {
    static class Student {
        private String name;
        private String grade;
        
        public Student(String name, String grade) {
            this.name = name;
            this.grade = grade;
        }
        
        public String getName() { return name; }
        public String getGrade() { return grade; }
        
        @Override
        public String toString() {
            return name;
        }
    }
    
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", "A"),
            new Student("Bob", "B"),
            new Student("Charlie", "A"),
            new Student("David", "C"),
            new Student("Eve", "B")
        );
        
        // Group students by grade
        Map<String, List<Student>> groupedByGrade = new HashMap<>();
        
        for (Student student : students) {
            String grade = student.getGrade();
            
            if (!groupedByGrade.containsKey(grade)) {
                groupedByGrade.put(grade, new ArrayList<>());
            }
            
            groupedByGrade.get(grade).add(student);
        }
        
        // Print groups
        groupedByGrade.forEach((grade, studentList) -> 
            System.out.println("Grade " + grade + ": " + studentList));
        
        // Java 8+ Stream-based grouping
        Map<String, List<Student>> streamGrouped = students.stream()
            .collect(Collectors.groupingBy(Student::getGrade));
            
        System.out.println("\nUsing Stream API:");
        streamGrouped.forEach((grade, studentList) -> 
            System.out.println("Grade " + grade + ": " + studentList));
    }
}

/* Output:
Grade A: [Alice, Charlie]
Grade B: [Bob, Eve]
Grade C: [David]

Using Stream API:
Grade A: [Alice, Charlie]
Grade B: [Bob, Eve]
Grade C: [David]
*/
```

---

## Advanced Topics

### ConcurrentHashMap for Thread Safety

The `ConcurrentHashMap` class provides thread-safe operations with good concurrency:

```java
Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();

// Can be safely used by multiple threads
concurrentMap.put("key1", 1);
concurrentMap.putIfAbsent("key2", 2);

// Atomic operations
concurrentMap.compute("key1", (key, oldValue) -> 
    (oldValue == null) ? 1 : oldValue + 1);
    
// Bulk operations with parallelism threshold
concurrentMap.forEach(2, (key, value) -> 
    System.out.println(key + ": " + value));
```

Key differences from synchronized maps:
- Fine-grained locking (segment/bucket level)
- Non-blocking reads
- Atomic compound actions
- Higher concurrency

### EnumMap for Enum Keys

For maps with enum keys, `EnumMap` offers better performance and memory usage:

```java
enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

EnumMap<Day, String> schedule = new EnumMap<>(Day.class);
schedule.put(Day.MONDAY, "Work");
schedule.put(Day.SATURDAY, "Relax");

System.out.println(schedule.get(Day.MONDAY)); // Output: Work
```

Benefits:
- More efficient than HashMap for enum keys
- Maintains natural order of enum constants
- Cannot contain null keys

### WeakHashMap for Automatic Cleanup

`WeakHashMap` holds weak references to keys, allowing them to be garbage collected:

```java
Map<Object, String> weakMap = new WeakHashMap<>();
Object key = new Object();
weakMap.put(key, "Value");

System.out.println("Before: " + weakMap.size()); // Output: Before: 1

key = null; // Remove strong reference to key
System.gc(); // Request garbage collection

// After GC runs, entry may be removed
System.out.println("After: " + weakMap.size()); // Output: After: 0 (if GC ran)
```

Use cases:
- Implementing caches that don't prevent garbage collection
- Storing metadata about objects without preventing their cleanup

### Java 8+ Map Enhancements

Java 8 introduced several helpful methods to the Map interface:

```java
Map<String, Integer> scores = new HashMap<>();
scores.put("Alice", 95);
scores.put("Bob", 80);

// getOrDefault - get value or default if key not present
int charlieScore = scores.getOrDefault("Charlie", 0); // Returns 0

// putIfAbsent - only put if key not present
scores.putIfAbsent("Bob", 90); // Won't change Bob's score
scores.putIfAbsent("Charlie", 85); // Adds Charlie

// compute - compute a new value (can be based on old value)
scores.compute("Alice", (key, oldValue) -> oldValue + 5); // Alice now has 100

// computeIfPresent - only compute if key exists
scores.computeIfPresent("David", (key, oldValue) -> oldValue + 10); // No effect

// computeIfAbsent - only compute if key doesn't exist
scores.computeIfAbsent("David", key -> 70); // David added with 70

// replace - replace value for key
scores.replace("Bob", 85); // Updates Bob's score

// remove with value - only remove if value matches
scores.remove("Charlie", 90); // No effect, Charlie has 85
scores.remove("Charlie", 85); // Removes Charlie

// merge - combine current and new value
scores.merge("Bob", 5, (oldVal, newVal) -> oldVal + newVal); // Bob now has 90

System.out.println(scores); // {Bob=90, Alice=100, David=70}
```

These methods provide atomic operations that can simplify code and improve thread safety.

---

## Interview Questions

Here are some common interview questions about Map and HashMap:

### 1. What is the difference between HashMap and Hashtable?

**Answer**: 
- HashMap is not synchronized (not thread-safe), while Hashtable is synchronized
- HashMap allows one null key and multiple null values, Hashtable doesn't allow any null keys or values
- HashMap is generally faster because it's not synchronized
- HashMap is part of the Collections Framework introduced in Java 1.2, while Hashtable is a legacy class

### 2. What happens if you use a mutable object as a key in HashMap?

**Answer**: Using mutable objects as keys in a HashMap can break the map's functionality if the key's state (and thus hashCode) changes after insertion. The HashMap may not be able to find the entry again because it will look in a different bucket. This is why immutable objects like String, Integer, etc. are recommended as keys.

### 3. What is the time complexity of HashMap operations?

**Answer**: 
- get(), put(), remove(), containsKey(): O(1) average case, O(n) worst case
- containsValue(): O(n) in all cases
- The worst case occurs when many keys hash to the same bucket, creating a long linked list or tree.

### 4. How does HashMap handle collisions?

**Answer**: HashMap uses chaining to handle collisions:
- In Java 7 and earlier: Creates a linked list of entries in the same bucket
- In Java 8+: Uses a linked list for buckets with few entries, but converts to a balanced tree (Red-Black Tree) when a bucket contains 8 or more entries, improving worst-case lookup from O(n) to O(log n)

### 5. How does HashMap resize itself?

**Answer**: 
1. HashMap has a load factor (default 0.75)
2. When (number of entries) > (capacity * load factor), it triggers a resize
3. A new larger array is created (typically 2x the size)
4. All existing entries are rehashed into the new array
5. This is a costly operation, so setting an appropriate initial capacity is helpful for known dataset sizes

### 6. What is the difference between HashMap and TreeMap?

**Answer**:
- HashMap is implemented as a hash table, while TreeMap uses a Red-Black tree
- HashMap has O(1) average-case complexity for most operations, TreeMap has O(log n)
- TreeMap maintains keys in sorted order, HashMap has no guaranteed order
- TreeMap doesn't allow null keys (but allows null values), HashMap allows one null key

### 7. What happens if you don't override equals() and hashCode() for custom keys?

**Answer**: If you don't override equals() and hashCode() for custom key classes:
- The default Object.equals() will check for reference equality, not content equality
- The default Object.hashCode() will use the object's memory address
- Two "equal" objects may have different hash codes, breaking the HashMap contract
- The HashMap will treat equal objects as distinct keys, causing unexpected behavior

### 8. How would you implement a thread-safe HashMap?

**Answer**: Several options:
1. Use ConcurrentHashMap (most efficient for multiple thread access)
2. Use Collections.synchronizedMap(new HashMap<>()) to get a synchronized wrapper
3. Use Hashtable (though it's considered legacy code)

```java
// Option 1: ConcurrentHashMap (preferred)
Map<String, Integer> map1 = new ConcurrentHashMap<>();

// Option 2: Synchronized wrapper
Map<String, Integer> map2 = Collections.synchronizedMap(new HashMap<>());

// Option 3: Hashtable (legacy)
Map<String, Integer> map3 = new Hashtable<>();
```

---

I hope this comprehensive guide helps you understand Maps and HashMaps in Java! Remember that practice is key to mastering these concepts, so try implementing examples and solving problems that use these data structures.