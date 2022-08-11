# Optimization-Benchmarks
This is a simple program that shows the performance differences of different styles of coding. A traditional for loop is one of the examples. Did you know that the typical (and easiest to understand) method of writing a for loop is NOT the most efficient? In fact, if you look at the code, you can see that by moving the integer declaration above the loop and using the ++ incrementer in your conditional, speed can actually be increase quite a bit. Obviously its not very important for small data sets, but if your working with large data sets and there is a situation where you absosultely cannot get away from nested for loops, this little trick can help you out.

Source: https://www.infoworld.com/article/2077647/make-java-fast--optimize-.html?page=3
