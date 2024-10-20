package TCS_CodeVita2k24;

/*WaterResourceMarks: 200
Problem Description

Salva is attempting to mitigate water scarcity by installing borewells in regions that have not experienced rainfall for several years. Despite the prolonged drought, the region, consisting of hills and valleys, had ample rainfall in the past. Salva believes that underground water sources still exist in these areas, and by identifying and drilling at these locations, he hopes to mitigate the water shortage.

To determine the optimal borewell locations, Salva has gathered surface data for the region. The goal is to identify the best place for borewells based on the characteristics of the valleys. During rainfall, water accumulates in the valleys and seeps into the ground, making valleys with a wider span more likely to contain underground water.

In the context of this region, a valley is the space between peaks, and a peak is defined as the highest point in the surrounding region - a local maximum in mathematical terms.

Salva's collected surface data is represented by a 2D map given by the equation,

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@4404a6b:image1.png

where Y represents the height of the surface from the measuring level at a distance x from the measuring point. The measuring point is the origin, (0,0), and measurements are taken towards the positive x-axis. The region under consideration has a length of 2pi. For clarity, consider 2*pi as 6.2831.

From the provided data, the task is to identify the widest valley. The widest valley is characterized by the maximum horizontal distance between its corresponding peaks or maximas. The output should indicate the count of the valley from the left. If there are multiple valleys with the same width, the leftmost one should be reported. The result should be presented with an accuracy of up to four decimal places.

Constraints

2 <= N <= 25

0 <= Elements of array A and B <= 15

Elements of array A will be unique

Input

First line contains 'n' where n is an integer represent number of element in the arrays.

Second line contains 'n' space separated integers representing elements of array A

Third line contains 'n' space separated integers representing elements of array B

Output

Single integer denoting which valley is suitable to lay the bore counting from the Start. Local maxima should be accurate upto four decimal places.

Time Limit (secs)

1

Examples

Input

2

1 2

2 3

Output

2

Explanation

The equation formed by the Arrays are

y = sin(x + 2) + sin(2x + 3)

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@4404a6b:image2.png

The first valley is in between the peak A and B, the second valley is between the peak B and C. The second valley is the widest. So, the output is 2

Example 2

input

3

1 2 3

1 1 1

output

1

Explanation

The equation formed by lines are

y = sin(x + 1) + sin(2x + 1) + sin(3x + 1)

It represents the surface below. And thus the output 1.

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@4404a6b:image3.png

The first valley is in between the peak A and B, the second valley is between the peak B and C, the third valley is between C and D. The first valley is the widest.*/
public class TCSmock1que5 {


}
