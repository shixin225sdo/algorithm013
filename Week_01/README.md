学习笔记
========
![image](https://github.com/shixin225sdo/algorithm013/blob/master/Week_01/image/01.png)
![image](https://github.com/shixin225sdo/algorithm013/blob/master/Week_01/image/02.png)


PriorityQueue的源码学习
-----------------------
1.由注释可以看出，优先级队列与普通队列的不同之处在于内部依据元素的比较器进行了排序。

2.元素必须实现比较器或可自然排序，元素不支持null

3.该队列是一个无界队列，可知底层数组要动态扩容

4.该队列没有实现线程安全，线程安全可用PriorityBlockingQueue。

#成员变量解析
* transient Object[] queue;底层使用数组方式实现队列
* int size = 0;队列的元素个数
* Comparator<? super E> comparator;用以排序元素的比较器，为null则使用元素的自然排序方式
* modCount;java集合类里基本都有该变量，用以记录底层存储的修改次数，防止迭代过程中数组结构被修改导致迭代错误

#构造函数解析
* 构造函数主要为填充初始化容量及指定比较器。
* 构造函数中也可接收其他集合类，用以转换为优先级队列；该集合的元素必须可比较，否则会跑出类型转换异常；SortedSet和PriorityQueue若作为构造函数参数，则保留他们的比较器。

#主要方法
* add方法添加元素，其实还是调用的offer；
* offer方法插入元素，首先比较Array长度，不够的话扩容，扩容后添加元素到数组实现的小顶堆中，其中用到的就是自定义的比较器或者元素自我实现的比较器。
* element()和peek()，获取不删除首元素，即为优先级最小元素，方法失败时前者抛出异常，后者返回null。因为内部实现为小顶堆，直接返回0号索引元素。
* remove()和poll()，获取并删除首元素，当方法失败时前者抛出异常，后者返回null，删除后需要调整堆的结构。
