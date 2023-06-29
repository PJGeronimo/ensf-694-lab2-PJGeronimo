# ensf-694-lab2-PJGeronimo

The code is found in src/iterativeSearch.java. Execution screenshots can be found in the PDF submitted in the D2L dropbox.

Q2: Run times for both linear and interpolation algorithms are printed in each run. Generally, the linear algorithm is faster, because the input arrays are relatively small, and are not sorted in the linear algorithm.

Q3: The improved version of the linear search algorithm implemented another iteration variable, j, used to iterate through the array in reverse order at the same time as the normal iteration takes place. This did result in a decrease in run time. The logic behind the improvement is to allow the for loop to iterate and check two values in the array at the same time, theoretically resulting in a lower run time.