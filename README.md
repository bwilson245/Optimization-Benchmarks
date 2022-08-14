# Optimizations
This is a simple program that shows the performance differences of different styles of coding.

Some notes and thoughts about this project:

- ContainsMethodTest
  - This tests the speed of the build in contains method in the List, Set, Queue, and Stack collections. The collection
  type is build in the background before execution. There are 2 versions for every method. One version has a target
  value of the collections size - 1 and the other has a target value of 1. As suspected, the results of the methods with
  the low-end target value are all about the same (within 3000ish nanoseconds). Also, as suspected, the Set is almost always
  the fastest one of the 4. With the high-end target value, as expected, the Set is also the fastest one every time
  , although it is much slower than the low-end target contains. Unexpectedly, the other 3 results all have very similar 
  times. This leads me to believe that the contains method for List, Queue, and Stack all start at the left most
  element in their search (bottom for the stack).
  

- BinarySearchOptimizations
  - This test the effectiveness of a binary search vs an iterative approach on a sorted array. I think this one is 
  fairly self-explanatory. As expected, the binary search is drastically faster.


- BinaryTreeOptimizations
  - I did my best to implement optimizations for a balanced binary tree. First, I implemented methods for testing the
  processing time of a recursive and iterative search and each had a depth-first implementation and a breadth-first implementation
  for a total of 4 different search patterns. Then I had the idea to test the memory usage of each method. I started by
  calculating the memory in the same methods I used to calculate time, however that caused the results of the process
  speeds to be opposite of expected. I realized that the extra calls to record the memory usage were slowing down the
  methods enough to give "false" readings. The solution I decided on was to duplicate all the methods and remove the methods
  to measure process time and replace them with methods to measure memory usage. This required double the amount of method
  calls, however, it separated the processes to achieve more accurate results. The problems with it is that there is a
  certain amount of overhead involved in the actual memory measurement process. I've yet to figure out how to eliminate it
  ,and I'm not entirely sure its avoidable. I'm also unsure about the recursive breadth-first search due to the nature of
  the heap. I'm fairly confident that under the hood it's just a binary search algorithm. For now, the results of that test
  can't be trusted. I'll update this readme if I manage to find a solution.
  

- ConcurrencyOptimizations
  - This tests the effectiveness of a iterative approach vs concurrency. I think this one is also fairly self-explanatory.
  As expected, concurrency is drastically faster.


- ObjectInstantiationOptimizations
  - This tests the effectiveness of declaring your variable outside a loop as opposed to inside a loop. The average times
  are actually quite eye-opening to the little things you can do to make a big difference. According to the test results,
  reusing an object outside a loop for every iteration is much faster than declaring and instantiating inside the loop.


- VariableInstantiationOptimizations
  - This tests the effect of using a primitive's Wrapper class vs using the primitive itself. The results were fairly
  surprising to me, although expected. Creating an instance of a wrapper class is more costly than creating a primitive.
  Interestingly, the creation of the double and float (both primitive and wrapper) are somewhat longer that the other 3.
  



Source: https://www.infoworld.com/article/2077647/make-java-fast--optimize-.html?page=3

