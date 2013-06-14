Calculator-Metamedia
====================
Write a program to solve the following problem

Your program must accept a file name as the single command-line parameter.
The file will contain 7-bit ASCII text and each line may consist of an operation, followed by acolon, followed by
a comma-separated list of numbers. For each line, perform the specified operation on the associated numbers and print
(to stdout) the operation followed by the result. The operations are SUM, MIN, MAX and AVERAGE, to determine the sum,
minimum, maximum and average respectively. Your program should handle errors, including malformed input, appropriately.
Please provide the source code, automated tests, any additional data (e.g. buildscripts) or information
(e.g. assumptions you've made, known bugs, etc) that you think we would need to fairly judge your submission.
Sample execution:

        SUM: 1, 2, 3
        MIN: 4, 3, 2, 40
        AVERAGE: 2, 2
        SUM: 6
        MIN: 2

Requirements
-----
* JDK 1.6
* Ant 1.8.2

Build
-----

        # build project
        ./ant
        # run tests
        ./ant test
