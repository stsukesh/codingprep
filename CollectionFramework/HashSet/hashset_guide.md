 # HashSet in Java Collections Framework

## Table of Contents
1. [Introduction](#introduction)
2. [Understanding HashSet](#understanding-hashset)
3. [HashSet Implementation](#hashset-implementation)
4. [Creating and Using HashSet](#creating-and-using-hashset)
5. [Important Methods](#important-methods)
6. [Performance Characteristics](#performance-characteristics)
7. [HashSet vs Other Collections](#hashset-vs-other-collections)
8. [Common Use Cases](#common-use-cases)
9. [Edge Cases and Pitfalls](#edge-cases-and-pitfalls)
10. [Advanced Usage](#advanced-usage)
11. [Best Practices](#best-practices)
12. [Practice Exercises](#practice-exercises)

## Introduction

HashSet is one of the most popular implementations of the Set interface in Java Collections Framework. It stores a collection of unique elements with no guaranteed ordering. The HashSet class implements the Set interface, backed by a hash table (actually a HashMap instance).

The key features of HashSet include:
- No duplicate elements
- At most one null element
- No guaranteed iteration order
- O(1) time complexity for basic operations (add, remove, contains)

## Understanding HashSet

### What is a Set?

Before diving into HashSet, let's understand what a Set is:

- A Set is a collection that cannot contain duplicate elements
- It models the mathematical set abstraction
- The Java Collections Framework provides several Set implementations with different characteristics

### HashSet Hierarchy

```
java.lang.Object
└── java.util.AbstractCollection<E>
    └── java.util.AbstractSet<E>
        └── java.util.HashSet<E>
```

HashSet implements:
- Set interface
- Cloneable interface
- Serializable interface

## HashSet Implementation

HashSet is implemented using a HashMap internally. When you add an element to a HashSet:

1. The element is used as a key in the backing HashMap
2. A dummy value (constant object) is associated with each key
3. The element's hash code is used to determine where to store it in memory
4. When checking for existence, the hash code is used first, then equals() for confirmation

```java
// Simplified internal representation
public class HashSet<E> {
    private transient HashMap<E, Object> map;
    private static final Object PRESENT = new Object();
    
    // When you add an element
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }
    
    // When you check if element exists
    public boolean contains(Object o) {
        return map.containsKey(o);
    }
}
```

## Creating and Using HashSet

### Creating a HashSet

There are several constructors available for creating a HashSet:

```java
// Default constructor - creates an empty HashSet with default initial capacity (16) and load factor (0.75)
HashSet<String> set1 = new HashSet<>();

// Creates a HashSet with specified initial capacity and default load factor (0.75)
HashSet<Integer> set2 = new HashSet<>(32);

// Creates a HashSet with specified initial capacity and load factor
HashSet<Double> set3 = new HashSet<>(20, 0.8f);

// Creates a HashSet containing elements from the collection
HashSet<String> set4 = new HashSet<>(Arrays.asList("apple", "banana", "orange"));
```

### Basic Operations

```java
import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        // Creating a HashSet
        HashSet<String> fruits = new HashSet<>();
        
        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Apple");  // Duplicate element - will be ignored
        
        System.out.println("Fruits set: " + fruits);
        
        // Checking if an element exists
        boolean containsApple = fruits.contains("Apple");
        System.out.println("Contains Apple? " + containsApple);
        
        // Removing an element
        fruits.remove("Banana");
        System.out.println("After removing Banana: " + fruits);
        
        // Size of the set
        System.out.println("Size of the set: " + fruits.size());
        
        // Iterating through the set
        System.out.println("Iterating through the set:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        
        // Clearing the set
        fruits.clear();
        System.out.println("After clearing: " + fruits);
        System.out.println("Is the set empty? " + fruits.isEmpty());
    }
}
```

**Output:**
```
Fruits set: [Apple, Orange, Banana]
Contains Apple? true
After removing Banana: [Apple, Orange]
Size of the set: 2
Iterating through the set:
Apple
Orange
After clearing: []
Is the set empty? true
```

Note: The order of elements in the output might be different on your system due to the unordered nature of HashSet.

## Important Methods

| Method | Description | Time Complexity |
|--------|-------------|-----------------|
| `add(E e)` | Adds the specified element to the set if it's not already present | O(1) |
| `remove(Object o)` | Removes the specified element from the set if it's present | O(1) |
| `contains(Object o)` | Returns true if this set contains the specified element | O(1) |
| `size()` | Returns the number of elements in the set | O(1) |
| `isEmpty()` | Returns true if this set contains no elements | O(1) |
| `clear()` | Removes all elements from the set | O(n) |
| `iterator()` | Returns an iterator over the elements in the set | O(1) |
| `addAll(Collection<? extends E> c)` | Adds all elements in the specified collection to this set | O(n) |
| `removeAll(Collection<?> c)` | Removes all elements in this set that are also in the specified collection | O(n) |
| `retainAll(Collection<?> c)` | Retains only the elements in this set that are also in the specified collection | O(n) |
| `toArray()` | Returns an array containing all elements in the set | O(n) |
| `clone()` | Returns a shallow copy of this HashSet instance | O(n) |

## Performance Characteristics

HashSet generally provides constant-time performance (O(1)) for the basic operations (add, remove, contains), assuming the hash function disperses the elements properly among the buckets.

- **Space Complexity**: O(n) where n is the number of elements
- **Load Factor**: Determines how full the HashSet can be before it's resized
  - Default value is 0.75
  - Lower load factor decreases collision probability but increases space usage
  - Higher load factor optimizes space but increases collision probability
- **Initial Capacity**: The initial size of the backing HashMap
  - Default value is 16
  - Should be set to expected size when known, to avoid resizing operations

## HashSet vs Other Collections

### HashSet vs TreeSet

| Feature | HashSet | TreeSet |
|---------|---------|---------|
| Implementation | Hash table (HashMap) | Red-Black Tree |
| Order | No guaranteed order | Sorted order |
| Performance (add/remove/contains) | O(1) | O(log n) |
| Null elements | Allows one null | Doesn't allow null (Java 7+) |
| Use when | Fast access is priority | Order is important |

### HashSet vs LinkedHashSet

| Feature | HashSet | LinkedHashSet |
|---------|---------|---------------|
| Implementation | Hash table | Hash table + Linked list |
| Order | No guaranteed order | Insertion order |
| Performance | Slightly better | Slightly slower due to maintaining links |
| Use when | Order doesn't matter | Need insertion order preserved |

### HashSet vs ArrayList

| Feature | HashSet | ArrayList |
|---------|---------|-----------|
| Duplicates | No duplicates | Allows duplicates |
| Order | No guaranteed order | Insertion order |
| Access by index | Not supported | Supported |
| Performance of contains | O(1) | O(n) |
| Use when | Need uniqueness, fast lookups | Need ordered list with duplicates |

## Common Use Cases

1. **Removing duplicates**: When you need a collection of unique elements
   ```java
   // Remove duplicates from a list
   List<Integer> numbersList = Arrays.asList(1, 2, 3, 2, 1, 4, 5, 4);
   HashSet<Integer> uniqueNumbers = new HashSet<>(numbersList);
   System.out.println(uniqueNumbers);  // Output: [1, 2, 3, 4, 5]
   ```

2. **Membership testing**: When you need to quickly check if an element exists
   ```java
   HashSet<String> validUsers = new HashSet<>(Arrays.asList("user1", "user2", "admin"));
   String user = "user1";
   if (validUsers.contains(user)) {
       System.out.println("Valid user");
   } else {
       System.out.println("Invalid user");
   }
   ```

3. **Set operations**: Union, intersection, difference
   ```java
   HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
   HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
   
   // Union (all elements from both sets)
   HashSet<Integer> union = new HashSet<>(set1);
   union.addAll(set2);
   System.out.println("Union: " + union);  // [1, 2, 3, 4, 5, 6]
   
   // Intersection (elements common to both sets)
   HashSet<Integer> intersection = new HashSet<>(set1);
   intersection.retainAll(set2);
   System.out.println("Intersection: " + intersection);  // [3, 4]
   
   // Difference (elements in set1 but not in set2)
   HashSet<Integer> difference = new HashSet<>(set1);
   difference.removeAll(set2);
   System.out.println("Difference: " + difference);  // [1, 2]
   ```

4. **Eliminating duplicates in database queries or data processing pipelines**
   ```java
   // Simulating database records
   List<User> allUsers = fetchUsersFromDatabase();
   
   // Extract unique user IDs
   HashSet<Integer> uniqueUserIds = new HashSet<>();
   for (User user : allUsers) {
       uniqueUserIds.add(user.getId());
   }
   
   System.out.println("Number of unique users: " + uniqueUserIds.size());
   ```

## Edge Cases and Pitfalls

### 1. Null Elements

HashSet allows at most one null element, which distinguishes it from some other Set implementations:

```java
HashSet<String> set = new HashSet<>();
set.add(null);
set.add(null);  // Second null is ignored
System.out.println(set.size());  // Output: 1
System.out.println(set.contains(null));  // Output: true
```

### 2. Hash Collisions

When two different objects produce the same hash code, a collision occurs. HashSet handles this by using the equals() method to distinguish between objects with the same hash code:

```java
class BadHash {
    private int id;
    
    public BadHash(int id) {
        this.id = id;
    }
    
    @Override
    public int hashCode() {
        return 1;  // Very bad hash function - all objects return same hash
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BadHash badHash = (BadHash) o;
        return id == badHash.id;
    }
    
    @Override
    public String toString() {
        return "BadHash{id=" + id + "}";
    }
}

public class HashCollisionDemo {
    public static void main(String[] args) {
        HashSet<BadHash> set = new HashSet<>();
        set.add(new BadHash(1));
        set.add(new BadHash(2));
        set.add(new BadHash(3));
        
        System.out.println("Size: " + set.size());  // Output: 3
        System.out.println("Elements: " + set);     // All three elements despite same hash
        
        // Performance degrades to O(n) for objects with same hash code
    }
}
```

### 3. Mutable Objects as Elements

Using mutable objects as elements in a HashSet can cause elements to "disappear" if they're modified after being added:

```java
import java.util.HashSet;
import java.util.Objects;

class MutablePoint {
    private int x, y;
    
    public MutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MutablePoint that = (MutablePoint) o;
        return x == that.x && y == that.y;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
    
    @Override
    public String toString() {
        return "Point(" + x + "," + y + ")";
    }
}

public class MutableElementDemo {
    public static void main(String[] args) {
        HashSet<MutablePoint> pointSet = new HashSet<>();
        
        MutablePoint p1 = new MutablePoint(1, 1);
        pointSet.add(p1);
        System.out.println("Set contains: " + pointSet);
        System.out.println("Contains p1? " + pointSet.contains(p1));  // true
        
        // Modify the point after adding it to the set
        p1.setX(2);
        
        System.out.println("Set after modification: " + pointSet);
        System.out.println("Contains p1? " + pointSet.contains(p1));  // false
        
        // The object is now in the wrong hash bucket and effectively "lost" within the set
    }
}
```

### 4. Custom Objects Without Proper equals() and hashCode()

When using custom objects in a HashSet, you must properly override equals() and hashCode() methods:

```java
class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Incorrect: No equals() and hashCode() overridden
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

class PersonWithEquals {
    private String name;
    private int age;
    
    public PersonWithEquals(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    // Correct: Both equals() and hashCode() implemented
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonWithEquals that = (PersonWithEquals) o;
        return age == that.age && Objects.equals(name, that.name);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class EqualsHashcodeDemo {
    public static void main(String[] args) {
        // Without proper equals() and hashCode()
        HashSet<Person> peopleSet = new HashSet<>();
        peopleSet.add(new Person("John", 30));
        peopleSet.add(new Person("John", 30));  // Should be duplicate, but it's not detected
        System.out.println("Set size (incorrect implementation): " + peopleSet.size());  // Output: 2
        
        // With proper equals() and hashCode()
        HashSet<PersonWithEquals> peopleSetCorrect = new HashSet<>();
        peopleSetCorrect.add(new PersonWithEquals("John", 30));
        peopleSetCorrect.add(new PersonWithEquals("John", 30));  // Duplicate detected
        System.out.println("Set size (correct implementation): " + peopleSetCorrect.size());  // Output: 1
    }
}
```

## Advanced Usage

### 1. Using HashSet with Streams (Java 8+)

```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class HashSetStreamsDemo {
    public static void main(String[] args) {
        // Create a HashSet from a stream
        Set<String> names = Arrays.asList("John", "Mary", "Bob", "John", "Alice")
                                 .stream()
                                 .filter(name -> name.length() > 3)
                                 .collect(Collectors.toSet());  // Returns a HashSet
        
        System.out.println(names);  // [Mary, John, Alice]
        
        // Find elements starting with 'A'
        boolean hasNameWithA = names.stream()
                                   .anyMatch(name -> name.startsWith("A"));
        
        System.out.println("Has name starting with A: " + hasNameWithA);  // true
        
        // Transform set elements
        Set<Integer> nameLengths = names.stream()
                                       .map(String::length)
                                       .collect(Collectors.toSet());
        
        System.out.println("Name lengths: " + nameLengths);  // [4, 5]
    }
}
```

### 2. HashSet with Custom Comparator (via TreeSet)

When you need both uniqueness and ordering, you can convert a HashSet to a TreeSet:

```java
import java.util.*;

public class HashSetOrderingDemo {
    public static void main(String[] args) {
        // Create a HashSet
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("zebra");
        hashSet.add("apple");
        hashSet.add("banana");
        hashSet.add("cat");
        
        System.out.println("HashSet (unordered): " + hashSet);
        
        // Convert to TreeSet for natural ordering
        TreeSet<String> naturalOrdered = new TreeSet<>(hashSet);
        System.out.println("Natural ordering: " + naturalOrdered);
        
        // Convert to TreeSet with custom ordering (reverse)
        TreeSet<String> reverseOrdered = new TreeSet<>(Comparator.reverseOrder());
        reverseOrdered.addAll(hashSet);
        System.out.println("Reverse ordering: " + reverseOrdered);
        
        // Convert to TreeSet with custom comparator (by length)
        TreeSet<String> lengthOrdered = new TreeSet<>(Comparator.comparing(String::length));
        lengthOrdered.addAll(hashSet);
        System.out.println("Ordered by length: " + lengthOrdered);
    }
}
```

### 3. Thread-Safety with Collections.synchronizedSet()

HashSet is not thread-safe. For multi-threaded environments, use synchronizedSet:

```java
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ThreadSafeHashSetDemo {
    public static void main(String[] args) {
        // Create a synchronized set
        Set<String> synchronizedSet = Collections.synchronizedSet(new HashSet<>());
        
        // Must synchronize when iterating
        synchronized (synchronizedSet) {
            for (String item : synchronizedSet) {
                System.out.println(item);
            }
        }
    }
}
```

### 4. Using LinkedHashSet for Predictable Iteration Order

```java
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PredictableOrderDemo {
    public static void main(String[] args) {
        // Regular HashSet - no guaranteed order
        Set<String> hashSet = new HashSet<>();
        hashSet.add("C");
        hashSet.add("A");
        hashSet.add("B");
        System.out.println("HashSet (unordered): " + hashSet); // Order unpredictable
        
        // LinkedHashSet - maintains insertion order
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("C");
        linkedHashSet.add("A");
        linkedHashSet.add("B");
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet); // [C, A, B]
    }
}
```

## Best Practices

1. **Choose the right initial capacity**: If you know the expected size, initialize with that capacity to avoid resizing:
   ```java
   HashSet<String> set = new HashSet<>(1000); // For ~1000 elements
   ```

2. **Immutable keys**: Use immutable objects as elements in your HashSet to avoid the "lost element" problem:
   ```java
   // Good: Using immutable String objects
   HashSet<String> goodSet = new HashSet<>();
   
   // Bad: Using mutable objects without care
   HashSet<StringBuilder> riskySet = new HashSet<>();
   ```

3. **Always override both equals() and hashCode()**: When using custom objects in a HashSet, always implement both methods and ensure they are consistent:
   ```java
   @Override
   public boolean equals(Object o) {
       // implementation
   }
   
   @Override
   public int hashCode() {
       // implementation
   }
   ```

4. **Use factory methods**: In Java 9+, use Set.of() for small immutable sets:
   ```java
   // Java 9+
   Set<String> colors = Set.of("Red", "Green", "Blue");
   ```

5. **Consider alternatives**: Use LinkedHashSet when order matters, TreeSet when sorted order is needed, and EnumSet for enum constants:
   ```java
   // For enum values
   enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }
   EnumSet<Day> weekend = EnumSet.of(Day.SATURDAY, Day.SUNDAY);
   ```

6. **Avoid iterating and modifying**: Don't modify a HashSet while iterating through it, use an Iterator's remove() method instead:
   ```java
   Iterator<String> iterator = set.iterator();
   while (iterator.hasNext()) {
       String element = iterator.next();
       if (shouldRemove(element)) {
           iterator.remove(); // Safe way to remove during iteration
       }
   }
   ```

## Practice Exercises

### Exercise 1: Finding Unique Words

Write a program that counts the number of unique words in a text file:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class UniqueWordsCounter {
    public static void main(String[] args) {
        Set<String> uniqueWords = new HashSet<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader("sample.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split by whitespace and punctuation
                String[] words = line.toLowerCase().split("[\\s\\p{Punct}]+");
                
                for (String word : words) {
                    if (!word.isEmpty()) {
                        uniqueWords.add(word);
                    }
                }
            }
            
            System.out.println("Number of unique words: " + uniqueWords.size());
            System.out.println("Unique words: " + uniqueWords);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Exercise 2: Implementing a Custom HashSet

Implement a simple version of HashSet with basic functionality:

```java
import java.util.LinkedList;

public class SimpleHashSet<E> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    
    private LinkedList<E>[] buckets;
    private int size;
    private float loadFactor;
    private int threshold;
    
    @SuppressWarnings("unchecked")
    public SimpleHashSet() {
        this.buckets = new LinkedList[DEFAULT_CAPACITY];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.threshold = (int) (DEFAULT_CAPACITY * loadFactor);
        this.size = 0;
    }
    
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        
        int bucketIndex = getBucketIndex(element);
        
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
        }
        
        // Check if element already exists
        if (buckets[bucketIndex].contains(element)) {
            return false;
        }
        
        // Add element to bucket
        buckets[bucketIndex].add(element);
        size++;
        
        // Check if resizing is needed
        if (size > threshold) {
            resize();
        }
        
        return true;
    }
    
    public boolean contains(E element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        
        int bucketIndex = getBucketIndex(element);
        
        if (buckets[bucketIndex] == null) {
            return false;
        }
        
        return buckets[bucketIndex].contains(element);
    }
    
    public boolean remove(E element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        
        int bucketIndex = getBucketIndex(element);
        
        if (buckets[bucketIndex] == null) {
            return false;
        }
        
        boolean removed = buckets[bucketIndex].remove(element);
        if (removed) {
            size--;
        }
        
        return removed;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    private int getBucketIndex(E element) {
        // Get positive hash code
        int hashCode = element.hashCode();
        hashCode = hashCode < 0 ? -hashCode : hashCode;
        
        // Map hashCode to bucket index
        return hashCode % buckets.length;
    }
    
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = buckets.length * 2;
        LinkedList<E>[] oldBuckets = buckets;
        
        // Create new buckets array
        buckets = new LinkedList[newCapacity];
        threshold = (int) (newCapacity * loadFactor);
        size = 0;
        
        // Rehash all elements
        for (LinkedList<E> bucket : oldBuckets) {
            if (bucket != null) {
                for (E element : bucket) {
                    add(element);
                }
            }
        }
    }
    
    // Unit test
    public static void main(String[] args) {
        SimpleHashSet<String> set = new SimpleHashSet<>();
        
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Apple"); // Duplicate
        
        System.out.println("Size: " + set.size()); // Should be 3
        System.out.println("Contains Apple? " + set.contains("Apple")); // Should be true
        System.out.println("Contains Grape? " + set.contains("Grape")); // Should be false
        
        set.remove("Apple");
        System.out.println("After removing Apple, size: " + set.size()); // Should be 2
        System.out.println("Contains Apple? " + set.contains("Apple")); // Should be false
    }
}
```

### Exercise 3: Find the First Recurring Character

Write a function that finds the first recurring character in a string using HashSet:

```java
import java.util.HashSet;
import java.util.Set;

public class RecurringCharacter {
    public static Character findFirstRecurring(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        
        Set<Character> seen = new HashSet<>();
        
        for (char c : str.toCharArray()) {
            if (seen.contains(c)) {
                return c;
            }
            seen.add(c);
        }
        
        return null; // No recurring character
    }
    
    public static void main(String[] args) {
        String[] testStrings = {
            "ABCA",       // Should return 'A'
            "BCABA",      // Should return 'B'
            "ABC",        // Should return null
            "ABBA",       // Should return 'B'
            "ABCDEFA"     // Should return 'A'
        };
        
        for (String test : testStrings) {
            Character result = findFirstRecurring(test);
            System.out.println("First recurring character in '" + test + "': " + 
                              (result != null ? result : "None"));
        }
    }
}
```

### Exercise 4: Implementing a Custom Cache using HashSet

```java
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, V> cache;
    private final Set<K> recentlyUsed;
    private final LinkedHashSet<K> keyOrder; // To maintain usage order
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.recentlyUsed = new HashSet<>();
        this.keyOrder = new LinkedHashSet<>();
    }
    
    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        
        // Mark as recently used
        updateUsage(key);
        return cache.get(key);
    }
    
    public void put(K key, V value) {
        // If key already exists, update value
        if (cache.containsKey(key)) {
            cache.put(key, value);
            updateUsage(key);
            return;
        }
        
        // If cache is full, remove least recently used item
        if (cache.size() >= capacity) {
            K leastUsed = null;
            for (K k : keyOrder) {
                if (!recentlyUsed.contains(k)) {
                    leastUsed = k;
                    break;
                }
            }
            
            // If all are recently used, remove the oldest
            if (leastUsed == null && !keyOrder.isEmpty()) {
                leastUsed = keyOrder.iterator().next();
            }
            
            if (leastUsed != null) {
                keyOrder.remove(leastUsed);
                cache.remove(leastUsed);
            }
        }
        