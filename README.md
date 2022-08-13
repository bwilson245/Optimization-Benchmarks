# Optimizations
This is a simple program that shows the performance differences of different styles of coding.

Some notes and thoughts about this project:

- At one time, I had a test involving an enhanced for loop vs the optimized traditional for loop seen in this project. 
I opted to take it out because results weren't consistent. Most of the time, the enhanced loop was faster, but sometimes 
it wasn't. I decided that the results were inconclusive, so I removed it from the program. However, during those tests it
seems that the speed of the enhanced loop vs the modified traditional loop was not much different, therefore it would 
reason that you could provide decent optimization by using an enhanced for loop where possible as well as increase the 
readability of your code.
    
 
- When I implemented the VariableOptimizations class, I was perplexed because the results were inconsistent. I knew that
couldn't be the case because one method was using the primitives' wrapper class, and from what I knew from the
ObjectInstantiationOptimizations, creating new objects has quite the overhead. The thought occurred to me that I was running
the unOptimized method first and maybe at some point during the optimized method, java was running garbage collection.
I decided to create the add() method instead of utilizing the List's built in add method so that I could call System.gc()
after adding the results of the test to hopefully prevent java from interfering with the test results. Afterwards, the 
results of the tests were as expected, and It actually improved the results of the other tests as well. This of course
begs the question "When should you and when should you not manually call garbage collection?". I feel like this
has created more questions that it answered.
 
    
- The biggest surprise to me is the optimized traditional for loop. It amazes me that the same result can be achieved
in a faster amount of time, just by moving around a few things. It really opens up a can of worms when it comes to 
understanding the JVM.
  

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

Source: https://www.infoworld.com/article/2077647/make-java-fast--optimize-.html?page=3

