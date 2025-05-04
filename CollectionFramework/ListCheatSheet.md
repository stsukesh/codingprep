
# 🧾 Java `List` Super Duper Cheat Sheet

## 📌 What is a List?
- A `List` is an **ordered**, **index-based**, **dynamic** collection.
- It allows **duplicate elements**.
- Belongs to `java.util` package.
- Interface implemented by: `ArrayList`, `LinkedList`, `Vector`.

---

## ✅ Syntax

```java
import java.util.*;

List<String> list = new ArrayList<>();
```

---

## 🧪 Common Methods with Code & Output

### 1. `add(E e)` — Add Element

```java
list.add("Apple");
list.add("Banana");
list.add("Apple");
System.out.println(list);
```

#### 🔸 Output:
```
[Apple, Banana, Apple]
```

---

### 2. `add(int index, E e)` — Insert at Specific Index

```java
list.add(1, "Orange");
System.out.println(list);
```

#### 🔸 Output:
```
[Apple, Orange, Banana, Apple]
```

---

### 3. `get(int index)` — Access Element

```java
System.out.println(list.get(2));
```

#### 🔸 Output:
```
Banana
```

---

### 4. `set(int index, E element)` — Replace Element

```java
list.set(0, "Mango");
System.out.println(list);
```

#### 🔸 Output:
```
[Mango, Orange, Banana, Apple]
```

---

### 5. `remove(int index)` — Remove by Index

```java
list.remove(1);
System.out.println(list);
```

#### 🔸 Output:
```
[Mango, Banana, Apple]
```

---

### 6. `remove(Object o)` — Remove by Value

```java
list.remove("Apple");
System.out.println(list);
```

#### 🔸 Output:
```
[Mango, Banana]
```

---

### 7. `contains(Object o)` — Check Existence

```java
System.out.println(list.contains("Banana"));
System.out.println(list.contains("Grapes"));
```

#### 🔸 Output:
```
true
false
```

---

### 8. `size()` — Number of Elements

```java
System.out.println(list.size());
```

#### 🔸 Output:
```
2
```

---

### 9. `isEmpty()` — Check if List is Empty

```java
System.out.println(list.isEmpty());
```

#### 🔸 Output:
```
false
```

---

### 10. `clear()` — Remove All Elements

```java
list.clear();
System.out.println(list);
```

#### 🔸 Output:
```
[]
```

---

## 🔁 Traversal Methods

### Using For-each Loop
```java
for (String fruit : list) {
    System.out.println(fruit);
}
```

### Using Index
```java
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
```

### Using Iterator
```java
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

---

## 🧱 Implementations of List

| Class        | Features                                 |
|--------------|-------------------------------------------|
| `ArrayList`  | Fast access, resizable array              |
| `LinkedList` | Fast insert/delete, doubly linked nodes   |
| `Vector`     | Like ArrayList but thread-safe            |
| `Stack`      | Extends Vector, LIFO order                |

---

## 🧠 Quick Tips

- Use `ArrayList` for random access & performance.
- Use `LinkedList` when frequent insert/delete is needed.
- `List` is an interface — code to the interface, not implementation.

---

## 🛑 List vs Set

| Feature         | `List`       | `Set`         |
|------------------|--------------|---------------|
| Duplicates       | ✅ Allowed    | ❌ Not allowed |
| Order maintained | ✅ Yes        | ❌ Not guaranteed (except LinkedHashSet) |
| Index access     | ✅ Yes        | ❌ No          |

---

## 📎 Sample Program (Full)

```java
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Python");
        list.add("Java");

        list.add(1, "C++");
        System.out.println("List: " + list);

        System.out.println("Get index 2: " + list.get(2));

        list.set(0, "JavaSE");
        System.out.println("After set: " + list);

        list.remove("Java");
        System.out.println("After remove: " + list);

        System.out.println("Contains C++? " + list.contains("C++"));
        System.out.println("Size: " + list.size());

        list.clear();
        System.out.println("Final List: " + list);
    }
}
```

### 🔸 Output:
```
List: [Java, C++, Python, Java]
Get index 2: Python
After set: [JavaSE, C++, Python, Java]
After remove: [JavaSE, C++, Python]
Contains C++? true
Size: 3
Final List: []
```

---

## ✅ Conclusion

- `List` is versatile and essential for storing ordered collections.
- Choose the right implementation (`ArrayList`, `LinkedList`, etc.) based on use-case.
- Always prefer coding to interfaces for flexibility.

---

🧠 Happy Learning Java Collections! 🚀
