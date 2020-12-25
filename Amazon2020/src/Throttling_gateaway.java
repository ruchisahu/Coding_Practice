/*
 * Throttling Gateway

On Amazon Prime Day, non-critical requests for a transaction system are routed through a throttling gateway to ensure that the network is not choked by non-essential requests.

The gateway has the following limits:
The number of transactions in any given second cannot exceed 3. The number of transactions in any given 10 second period cannot exceed 20. A ten-second period includes all requests arriving from any time max(1, T-9) to T (inclusive of both) for any valid time T. The number of transactions in any given minute cannot exceed 60. Similar to above, 1 minute is from max(1, T-59) to T.
Any request that exceeds any of the above limits will be dropped by the gateway. Given the times at which different requests arrive sorted ascending, write an algorithm to find how many requests will be dropped.

Input
The input to the function/method consists of two arguments:
num, an integer representing the number of requests;
requestTime, a list of integers representing the times of various requests.

Output
Return an integer representing the total number of dropped requests.

Constraints
1 <= num <= 10^6
1 <= requestTime[i] <= 10^9
0 <= i< num

Note
Even if a request is dropped it is still considered for future calculations. Although, if a request is to be dropped due to multiple violations, it is still counted only once.

Example
Input:
num = 27
requestTime = [1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7,7,7,7, 11, 11, 11, 11]

Output:
7

Explanation:
Request 1 - Not Dropped.
Request 1 - Not Dropped.
Request 1 - Not Dropped.
Request 1 - Dropped. At most 3 requests are allowed in one second. No request will be dropped till 6 as all comes at an allowed rate of 3 requests per second and the 10-second clause is also not violated.
Request 7 - Not Dropped. The total number of requests has reached 20 now.
Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
Request 7 - Dropped. At most 20 requests are allowed in ten seconds.
Request 7 - Dropped. At most 20 requests are allowed in ten seconds. Note that the 1-second limit is also violated here.
Request 11 - Not Dropped. The 10-second window has now become 2 to 11. Hence the total number of requests in this window is 20 now.
Request 11 - Dropped. At most 20 requests are allowed in ten seconds.
Request 11 - Dropped. At most 20 requests are allowed in ten seconds.
Request 11 - Dropped. At most 20 requests are allowed in ten seconds. Also, at most 3 requests are allowed per second. Hence, a total of 7 requests are dropped.
 */
public class Throttling_gateaway {

}
