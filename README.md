# ```ArrayList<T>```
### 1) 类的包名
#### ```java.util```
### 2) 类的构造方法
#### a) ```ArrayList<T>()```
**初始化一个空的ArrayList, 初始空间为10**
*Constructs an empty list with an initial capacity of ten.*
``` java
ArrayList<String> list = new arrayList<String>();
```
#### b) ```ArrayList<T>(int initialCapacity)```
**用指定的初始空间初始化一个空的ArrayList**
*Constructs an empty list with the specified initial capacity.*
``` java
ArrayList<String> list = new ArrayList<String>(255);
```
#### c) ```ArrayList(Collection<? extends E> c)```
**用另外一个Collection类初始化一个ArrayList**
*Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.*
``` java
Collection<String> list1 = new ArrayList<String>();
ArrayList<String> list2 = new ArrayList<String>(list1);
```

### 3) 类的常量

### 4) 类的方法
#### a) ```boolean add(E e)```
**向ArrayList末尾添加元素**
*Appends the specified element to the end of this list.*
``` java
ArrayList<String> list = new ArrayList<String>();
list.add("Benzolamps");
list.add("Studio");
list.add("Studio");
		
System.out.println(list);
```
**运行结果**
```
[Benzolamps, Studio, Studio]
```
**说明**
*ArrayList存储不唯一，有序的对象，可存在重复的元素*

#### b) ```boolean add(int index, E element)```
**将元素插入到ArrayList的指定位置, 后面的元素后移**
*Inserts the specified element at the specified position in this list.*
``` java
list.add(2, "Hello World");

System.out.println(list);
```
**运行结果**
```
[Benzolamps, Studio, Hello World, Studio]
```

#### c) ```boolean addAll(Collection<? extends E> c)```
**将另外一个Collection的对象元素加到末尾**
*Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's Iterator.*
```java
Collection<String> temp = new HashSet<String>();
temp.add("Hello");
temp.add("World");

list.addAll(temp);

System.out.println(list);
```
**运行结果**
```
[Benzolamps, Studio, Studio, Hello, World]
```

#### d) ```boolean addAll(Collection<? extends E> c)```
**将另外一个Collection的对象元素添加到指定位置, 后面的元素后移**
*Inserts all of the elements in the specified collection into this list, starting at the specified position.*
```java
list.addAll(2, temp);
```
**运行结果**
```
[Benzolamps, Studio, Hello, World, Studio]
```

#### e) ```void clear()```
**清空ArrayList**
*Removes all of the elements from this list.*
```java
list.clear();
```
**运行结果**
```
[]
```

#### f) ```Object clone()```
**拷贝ArrayList**
*Returns a shallow copy of this ArrayList instance.*
```java
Object obj = list.clone();

System.out.println(obj);
```
**运行结果**
```
[Benzolamps, Studio, Studio]
```
**说明**
*ArrayList的拷贝是浅拷贝 (**```shallow copy```**), 拷贝后的对象仍然是一个ArrayList的对象, 里面的元素是之前ArrayList中元素的副本*

#### g) ```boolean contains(Object o)```
**判断指定元素是否存在于ArrayList中**
*Returns true if this list contains the specified element.*
```java
boolean result = list.contains("Studio");

System.out.println(result);
```
**运行结果**
```
true
```
**说明**
*调用了元素类中的**```equals()```**方法*

#### h) ```void ensureCapacity(int minCapacity)```
**对ArrayList进行扩容**
*Increases the capacity of this ArrayList instance, if necessary, to ensure that it can hold at least the number of elements specified by the minimum capacity argument.*
```java
list.encureCapicity(255);
```
**说明**
*不知道用在什么场合```???```*

#### i) ```void forEach(Consumer<? super E> action)```
**对ArrayList进行遍历, 并执行action对象中的accept()方法**
```java
list.forEach(new Consumer<String>() {
	@Override
	public void accept(String str) {
		System.out.println(str.toUpperCase());
	}
});
```
**执行结果**
```
BENZOLAMPS
STUDIO
STUDIO
```
**说明**
*action对象实现了Consumer接口，forEach()方法通过调用action对象的**```accept()```**方法来实现遍历*

















