# Comprehensive Guide to ArrayList in Java

## Table of Contents
1. [Introduction to ArrayList](#introduction-to-arraylist)
2. [Creating an ArrayList](#creating-an-arraylist)
3. [Basic ArrayList Operations](#basic-arraylist-operations)
4. [ArrayList Methods in Detail](#arraylist-methods-in-detail)
5. [ArrayList vs Array](#arraylist-vs-array)
6. [ArrayList vs LinkedList](#arraylist-vs-linkedlist)
7. [ArrayList Edge Cases](#arraylist-edge-cases)
8. [Performance Considerations](#performance-considerations)
9. [Common ArrayList Patterns](#common-arraylist-patterns)
10. [Practical Examples](#practical-examples)
11. [Summary](#summary)

## Introduction to ArrayList

ArrayList is one of the most commonly used collection classes in Java, part of the Java Collections Framework. It provides a resizable array implementation of the List interface, offering dynamic sizing capabilities that traditional arrays lack.

### Key Features of ArrayList

- **Dynamic Sizing**: Automatically resizes when elements are added or removed
- **Random Access**: Provides O(1) time complexity for get and set operations
- **Ordered Collection**: Maintains insertion order of elements
- **Allows Duplicates**: Can store duplicate elements
- **Null Elements**: Can store null values
- **Not Synchronized**: Not thread-safe by default

### Internal Working

Behind the scenes, an ArrayList works with a regular array:

1. When you create an ArrayList, Java initializes an internal array with a default capacity (typically 10)
2. As elements are added, the ArrayList checks if there's enough space
3. If the internal array is full, a new, larger array is created (typically 1.5x the current size)
4. All elements from the old array are copied to the new one
5. The old array is discarded for garbage collection

## Creating an ArrayList

### Basic Initialization

There are several ways to create an ArrayList:

```java
// Create an empty ArrayList with default capacity
ArrayList<String> list1 = new ArrayList<>();

// Create an ArrayList with specified initial capacity
ArrayList<Integer> list2 = new ArrayList<>(20);

// Create an ArrayList from another collection
ArrayList<Double> list3 = new ArrayList<>(anotherCollection);

// Using the diamond operator (Java 7+)
ArrayList<String> list4 = new ArrayList<>();
```

### With Initial Values (Java 9+)

```java
// Using List.of (Java 9+)
ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange"));

// Using Arrays.asList
ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
```

### Type Parameters

ArrayList uses generics to specify the type of elements:

```java
ArrayList<String> stringList = new ArrayList<>();    // Stores only String objects
ArrayList<Integer> intList = new ArrayList<>();      // Stores only Integer objects
ArrayList<CustomClass> customList = new ArrayList<>(); // Stores only CustomClass objects
```

## Basic ArrayList Operations

### Adding Elements

```java
ArrayList<String> fruits = new ArrayList<>();

// Add elements to the end
fruits.add("Apple");        // [Apple]
fruits.add("Banana");       // [Apple, Banana]

// Add at specific index
fruits.add(1, "Orange");    // [Apple, Orange, Banana]

// Add multiple elements at once
fruits.addAll(Arrays.asList("Mango", "Grapes"));  // [Apple, Orange, Banana, Mango, Grapes]

// Add collection at specific index
fruits.addAll(2, Arrays.asList("Pear", "Cherry")); // [Apple, Orange, Pear, Cherry, Banana, Mango, Grapes]
```

### Accessing Elements

```java
ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange", "Mango"));

// Get element at specific index
String firstFruit = fruits.get(0);    // "Apple"
String thirdFruit = fruits.get(2);    // "Orange"

// Get first and last elements
String first = fruits.get(0);             // "Apple"
String last = fruits.get(fruits.size()-1); // "Mango"
```

### Updating Elements

```java
ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange"));

// Update element at index
fruits.set(1, "Pear");    // Changes "Banana" to "Pear" -> [Apple, Pear, Orange]
```

### Removing Elements

```java
ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange", "Mango", "Apple"));

// Remove by index
fruits.remove(0);         // Removes "Apple" -> [Banana, Orange, Mango, Apple]

// Remove by object
fruits.remove("Orange");  // Removes "Orange" -> [Banana, Mango, Apple]

// Remove all occurrences
fruits.removeAll(List.of("Apple")); // Removes all "Apple" -> [Banana, Mango]

// Clear entire ArrayList
fruits.clear();           // Removes all elements -> []
```

### Searching

```java
ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange", "Mango", "Apple"));

// Check if element exists
boolean hasOrange = fruits.contains("Orange");    // true
boolean hasGrape = fruits.contains("Grape");      // false

// Find index of element (first occurrence)
int firstAppleIndex = fruits.indexOf("Apple");    // 0

// Find index of element (last occurrence)
int lastAppleIndex = fruits.lastIndexOf("Apple"); // 4

// Check if list is empty
boolean isEmpty = fruits.isEmpty();               // false
```

## ArrayList Methods in Detail

### Size and Capacity

```java
ArrayList<String> list = new ArrayList<>();

// Get current size (number of elements)
int size = list.size();    // 0

// Ensure capacity (optional optimization)
list.ensureCapacity(100);  // Ensures internal array can hold at least 100 elements

// Trim to size (reduce memory usage)
list.add("Element");
list.trimToSize();         // Trims internal array to current size
```

### Bulk Operations

```java
ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange", "Mango"));
ArrayList<String> citrus = new ArrayList<>(List.of("Orange", "Lemon"));

// Check if list contains all elements from another collection
boolean containsAll = fruits.containsAll(citrus);    // true

// Add all elements from another collection
fruits.addAll(citrus);    // [Apple, Banana, Orange, Mango, Orange, Lemon]

// Remove all elements that exist in another collection
fruits.removeAll(citrus); // [Apple, Banana, Mango]

// Retain only elements that exist in another collection
ArrayList<String> fruits2 = new ArrayList<>(List.of("Apple", "Banana", "Orange", "Mango"));
fruits2.retainAll(citrus); // [Orange]
```

### Sublist Operations

```java
ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange", "Mango", "Grapes"));

// Get a sublist (view of the original list)
List<String> subList = fruits.subList(1, 4);  // [Banana, Orange, Mango]

// Modifying the sublist affects the original list
subList.clear();
// fruits is now [Apple, Grapes]
```

### List to Array Conversion

```java
ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange"));

// Convert to Object array
Object[] objectArray = fruits.toArray();

// Convert to typed array
String[] stringArray = fruits.toArray(new String[0]);
// Or in Java 11+
String[] stringArray2 = fruits.toArray(String[]::new);
```

### Iteration Methods

```java
ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange"));

// Traditional for loop
for (int i = 0; i < fruits.size(); i++) {
    System.out.println(fruits.get(i));
}

// Enhanced for loop
for (String fruit : fruits) {
    System.out.println(fruit);
}

// Iterator
Iterator<String> iterator = fruits.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}

// ListIterator (can move both forward and backward)
ListIterator<String> listIterator = fruits.listIterator();
while (listIterator.hasNext()) {
    System.out.println(listIterator.next());
}

// Java 8 forEach with lambda
fruits.forEach(fruit -> System.out.println(fruit));

// Java 8 stream API
fruits.stream().forEach(System.out::println);
```

## ArrayList vs Array

| Feature | ArrayList | Array |
|---------|-----------|-------|
| **Size** | Dynamic (resizable) | Fixed (immutable) |
| **Type** | Can only store objects | Can store primitives and objects |
| **Performance** | Overhead due to dynamic resizing | Slightly faster |
| **Methods** | Rich set of utility methods | Limited operations |
| **Generics** | Supports generics | Supports array of specific type |
| **Nulls** | Can store null values | Can store null for object arrays |
| **Memory** | More memory overhead | More memory efficient |

### When to use ArrayList:
- When you need dynamic sizing
- When you need frequent insertions and deletions
- When you need collection utility methods

### When to use Array:
- When size is fixed and known
- When performance is critical
- When dealing with primitive types directly
- When memory footprint is critical

## ArrayList vs LinkedList

| Feature | ArrayList | LinkedList |
|---------|-----------|------------|
| **Internal Structure** | Dynamic array | Doubly linked list |
| **Random Access** | O(1) - Constant time | O(n) - Linear time |
| **Insertion/Deletion at Start/Middle** | O(n) - Linear time | O(1) - Constant time |
| **Insertion/Deletion at End** | Amortized O(1) | O(1) - Constant time |
| **Memory Usage** | Less overhead | More overhead (pointers) |
| **Iteration** | More efficient | Less efficient |

### When to choose ArrayList:
- Frequent random access operations
- Mostly appending elements
- Size change frequency is moderate
- Memory efficiency is important

### When to choose LinkedList:
- Frequent insertions/deletions at beginning/middle
- Rarely need random access
- Implementing stacks or queues
- Size changes very frequently

## ArrayList Edge Cases

### Empty ArrayList

```java
ArrayList<String> emptyList = new ArrayList<>();

// Get size
int size = emptyList.size();    // 0

// Check if empty
boolean isEmpty = emptyList.isEmpty();  // true

// Access element (will throw IndexOutOfBoundsException)
try {
    String element = emptyList.get(0);
} catch (IndexOutOfBoundsException e) {
    System.out.println("Cannot access elements of an empty list");
}

// Remove element (will return false)
boolean removed = emptyList.remove("something");  // false
```

### Null Elements

```java
ArrayList<String> list = new ArrayList<>();
list.add(null);
list.add("Apple");
list.add(null);  // [null, Apple, null]

// Check for null
boolean containsNull = list.contains(null);  // true

// Remove null
list.remove(null);  // Removes first null -> [Apple, null]

// Be careful with methods that might use equals()
for (String item : list) {
    // This could cause NullPointerException if not careful
    if (item != null && item.equals("Apple")) {
        System.out.println("Found Apple");
    }
}
```

### Index Out of Bounds

```java
ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana"));

try {
    // This will throw IndexOutOfBoundsException
    String fruit = fruits.get(2);
} catch (IndexOutOfBoundsException e) {
    System.out.println("Index out of bounds");
}

try {
    // This will throw IndexOutOfBoundsException
    fruits.add(5, "Orange");
} catch (IndexOutOfBoundsException e) {
    System.out.println("Cannot add at index 5 when size is 2");
}
```

### Concurrent Modification

```java
ArrayList<String> fruits = new ArrayList<>(List.of("Apple", "Banana", "Orange"));

// This will throw ConcurrentModificationException
try {
    for (String fruit : fruits) {
        if (fruit.equals("Banana")) {
            fruits.remove(fruit);  // Modifying while iterating
        }
    }
} catch (ConcurrentModificationException e) {
    System.out.println("Cannot modify list during iteration");
}

// Correct ways to remove during iteration:

// 1. Using Iterator
Iterator<String> iterator = fruits.iterator();
while (iterator.hasNext()) {
    String fruit = iterator.next();
    if (fruit.equals("Banana")) {
        iterator.remove();  // Safe removal
    }
}

// 2. Using removeIf (Java 8+)
fruits.removeIf(fruit -> fruit.equals("Banana"));

// 3. Using temporary collection
ArrayList<String> toRemove = new ArrayList<>();
for (String fruit : fruits) {
    if (fruit.equals("Banana")) {
        toRemove.add(fruit);
    }
}
fruits.removeAll(toRemove);
```

### Thread Safety Issues

```java
// ArrayList is not thread-safe
ArrayList<String> sharedList = new ArrayList<>();

// If multiple threads access and modify the list simultaneously, 
// inconsistent state can occur

// Solutions:

// 1. Synchronize externally
synchronized (sharedList) {
    sharedList.add("element");
}

// 2. Use Collections.synchronizedList
List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());

// 3. Use CopyOnWriteArrayList for specific use cases
CopyOnWriteArrayList<String> threadSafeList = new CopyOnWriteArrayList<>();
```

## Performance Considerations

### Time Complexity

| Operation | ArrayList | Explanation |
|-----------|-----------|-------------|
| add(E) | O(1) amortized | Usually constant time; O(n) when resizing |
| add(int, E) | O(n) | Shifts elements right of insertion point |
| get(int) | O(1) | Direct index access |
| remove(int) | O(n) | Shifts elements left to fill gap |
| remove(Object) | O(n) | Searches for element first |
| contains(Object) | O(n) | Linear search |
| size() | O(1) | Direct field access |
| clear() | O(n) | Nulls out all elements |
| isEmpty() | O(1) | Checks if size is 0 |

### Memory Usage

ArrayList has some memory overhead compared to arrays:
- Object header (16 bytes)
- Internal array reference (8 bytes)
- Size and other fields (16 bytes)
- The array itself (4*capacity or 8*capacity bytes depending on data type)
- Unutilized array capacity

### Initial Capacity

```java
// Setting initial capacity can improve performance if size is known
ArrayList<Integer> list = new ArrayList<>(10000);

// Without proper capacity, multiple resizing operations will occur
ArrayList<Integer> inefficientList = new ArrayList<>();
for (int i = 0; i < 10000; i++) {
    inefficientList.add(i);  // Multiple internal resizings will happen
}
```

### Trimming to Size

```java
ArrayList<String> list = new ArrayList<>(1000);
list.add("just one element");

// The internal array still has capacity of 1000
// Trim to reduce memory footprint
list.trimToSize();  // Now internal array has capacity of 1
```

## Common ArrayList Patterns

### Filtering Elements

```java
ArrayList<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

// Using Java 8+ Stream API
List<Integer> evenNumbers = numbers.stream()
    .filter(n -> n % 2 == 0)
    .collect(Collectors.toList());
// evenNumbers: [2, 4, 6, 8, 10]

// Traditional approach
ArrayList<Integer> oddNumbers = new ArrayList<>();
for (Integer num : numbers) {
    if (num % 2 != 0) {
        oddNumbers.add(num);
    }
}
// oddNumbers: [1, 3, 5, 7, 9]
```

### Transforming Elements

```java
ArrayList<String> names = new ArrayList<>(List.of("Alice", "Bob", "Charlie"));

// Using Stream API
List<String> upperCaseNames = names.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
// upperCaseNames: [ALICE, BOB, CHARLIE]

// Traditional approach
ArrayList<Integer> nameLengths = new ArrayList<>();
for (String name : names) {
    nameLengths.add(name.length());
}
// nameLengths: [5, 3, 7]
```

### Finding Elements

```java
ArrayList<Person> people = new ArrayList<>();
people.add(new Person("Alice", 30));
people.add(new Person("Bob", 25));
people.add(new Person("Charlie", 35));

// Using Stream API
Person youngest = people.stream()
    .min(Comparator.comparing(Person::getAge))
    .orElse(null);
// youngest: Person{name=Bob, age=25}

// Traditional approach
Person oldest = null;
int maxAge = Integer.MIN_VALUE;
for (Person person : people) {
    if (person.getAge() > maxAge) {
        maxAge = person.getAge();
        oldest = person;
    }
}
// oldest: Person{name=Charlie, age=35}
```

### Sorting

```java
ArrayList<String> fruits = new ArrayList<>(List.of("Orange", "Apple", "Banana", "Kiwi"));

// Natural order
Collections.sort(fruits);
// fruits: [Apple, Banana, Kiwi, Orange]

// Custom order using Comparator
Collections.sort(fruits, (a, b) -> Integer.compare(a.length(), b.length()));
// fruits: [Kiwi, Apple, Orange, Banana]

// Using List.sort() (Java 8+)
fruits.sort(Comparator.reverseOrder());
// fruits: [Orange, Kiwi, Banana, Apple]

// Sorting objects
ArrayList<Person> people = new ArrayList<>();
people.add(new Person("Alice", 30));
people.add(new Person("Bob", 25));
people.add(new Person("Charlie", 35));

people.sort(Comparator.comparing(Person::getAge));
// people: [Person{name=Bob, age=25}, Person{name=Alice, age=30}, Person{name=Charlie, age=35}]
```

### Removing Duplicates

```java
ArrayList<String> withDuplicates = new ArrayList<>(
    List.of("Apple", "Banana", "Apple", "Orange", "Banana")
);

// Using LinkedHashSet to preserve order
ArrayList<String> noDuplicates = new ArrayList<>(
    new LinkedHashSet<>(withDuplicates)
);
// noDuplicates: [Apple, Banana, Orange]

// Using Stream API
List<String> uniqueList = withDuplicates.stream()
    .distinct()
    .collect(Collectors.toList());
// uniqueList: [Apple, Banana, Orange]
```

## Practical Examples

### Example 1: Simple To-Do List

```java
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }
    
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removed = tasks.remove(index);
            System.out.println("Removed task: " + removed);
        } else {
            System.out.println("Invalid task number");
        }
    }
    
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list");
            return;
        }
        
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
    
    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Add task");
            System.out.println("2. Remove task");
            System.out.println("3. Display tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    addTask(task);
                    break;
                case 2:
                    System.out.print("Enter task number to remove: ");
                    int index = scanner.nextInt() - 1;
                    removeTask(index);
                    break;
                case 3:
                    displayTasks();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    public static void main(String[] args) {
        ToDoList todoList = new ToDoList();
        todoList.run();
    }
}
```

### Example 2: Student Database

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

class Student {
    private String id;
    private String name;
    private double gpa;
    
    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    
    public String getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    
    public void setGpa(double gpa) { this.gpa = gpa; }
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}

public class StudentDatabase {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully");
    }
    
    public Student findStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    
    public void updateGpa(String id, double newGpa) {
        Student student = findStudent(id);
        if (student != null) {
            student.setGpa(newGpa);
            System.out.println("GPA updated successfully");
        } else {
            System.out.println("Student not found");
        }
    }
    
    public void removeStudent(String id) {
        Student student = findStudent(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student removed successfully");
        } else {
            System.out.println("Student not found");
        }
    }
    
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in database");
            return;
        }
        
        System.out.println("Student List:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
    
    public void displayTopStudents(int n) {
        if (students.isEmpty()) {
            System.out.println("No students in database");
            return;
        }
        
        // Create a copy to avoid modifying original list
        ArrayList<Student> sortedStudents = new ArrayList<>(students);
        sortedStudents.sort(Comparator.comparing(Student::getGpa).reversed());
        
        System.out.println("Top " + Math.min(n, sortedStudents.size()) + " students:");
        for (int i = 0; i < Math.min(n, sortedStudents.size()); i++) {
            System.out.println((i+1) + ". " + sortedStudents.get(i));
        }
    }
    
    public void run() {
        boolean running = true;
        while (running) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Find Student");
            System.out.println("3. Update GPA");
            System.out.println("4. Remove Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Display Top Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter GPA: ");
                    double gpa = scanner.nextDouble();
                    addStudent(new Student(id, name, gpa));
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    Student foundStudent = findStudent(scanner.nextLine());
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter ID: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new GPA: ");
                    double newGpa = scanner.nextDouble();
                    updateGpa(updateId, newGpa);
                    break;
                case 4:
                    System.out.print("Enter ID: ");
                    removeStudent(scanner.nextLine());
                    break;
                case 5:
                    displayAllStudents();
                    break;
                case 6:
                    System.out.print("How many top students to display? ");
                    displayTopStudents(scanner.nextInt());
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    
    public static void main(String[] args) {
        StudentDatabase database = new StudentDatabase();
        database.run();
    }
}
```

### Example 3: Shopping Cart Implementation

```java
import java.util.ArrayList;
import java.util.Iterator;

class Product {
    private String name;
    private double price;
    private int quantity;
    
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    public void setQuantity(int quantity) { this.quantity = quantity; }
    
    public double getTotalPrice() {
        return price * quantity;
    }
    
    @Override
    public String toString() {
        return name + " - $" + price + " x " + quantity + " = $" + getTotalPrice();
    }
}

public class ShoppingCart {
    private ArrayList<Product> items = new ArrayList<>();
    
    public void addProduct(Product product) {
        // Check if product already exists
        for (Product item : items) {
            if (item.getName().equals(product.getName())) {
                // Increase quantity instead of adding duplicate
                item.setQuantity(item.getQuantity() + product.getQuantity());
                return;
            }
        }
        // Add new product
        items.add(product);
    }
    
    public void removeProduct(String productName) {
        Iterator<Product> iterator = items.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equalsIgnoreCase(productName)) {
                iterator.remove();
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }
    
    public void updateQuantity(String productName, int newQuantity) {
        for (Product product : items) {
            if (product.getName().equalsIgnoreCase(productName)) {
                if (newQuantity <= 0) {
                    removeProduct(productName);
                } else {
                    product.setQuantity(newQuantity);
                }
                return;
            }
        }
        System.out.println("Product not found: " + productName);
    }
    
    public double calculateTotal() {
        double total = 0;
        for (Product product : items) {
            total += product.getTotalPrice();
        }
        return total;
    }
    
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty");
            return;
        }
        
        System.out.println("Shopping Cart:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i+1) + ". " + items.get(i));
        }
        System.out.println("Total: $" + calculateTotal());
    }
    
    public void clearCart() {
        items.clear();
        System.out.println("Cart cleared");
    }
    
    public static void main(String[] args) {
        // Example usage
        ShoppingCart cart = new ShoppingCart();
        
        // Add products
        cart.addProduct(new Product("Laptop", 999.99, 1));
        cart.addProduct(new Product("Mouse", 24.99, 2));
        cart.addProduct(new Product("Keyboard", 59.99, 1));
        
        // Display initial cart
        System.out.println("Initial cart:");
        cart.displayCart();
        
        // Update quantity
        cart.updateQuantity("Mouse", 3);
        
        // Add more of existing product
        cart.addProduct(new Product("Laptop", 999.99, 1));
        
        // Display updated cart
        System.out.println("\nAfter updates:");
        cart.displayCart();
        
        // Remove a product
        cart.removeProduct("Keyboard");
        
        // Display final cart
        System.out.println("\nAfter removal:");
        cart.displayCart();
        
        // Clear cart
        cart.clearCart();
        cart.displayCart();
    }
}
```

## Summary

ArrayList is a versatile and widely-used data structure in Java that offers dynamic resizing capabilities with efficient random access. It's an implementation of the List interface which stores elements in an ordered sequence.

### Key Takeaways

1. **Dynamic Array**: ArrayList provides the functionality of dynamic arrays which grow and shrink as needed.

2. **Performance**: 
   - Provides O(1) time complexity for random access operations