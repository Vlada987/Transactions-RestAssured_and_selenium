Purpose of this test is to make Paypal order, check order before and after approval.
Tools used: Rest assured, Selenium, TestNG, Jackson, Extent report.

1. First part is to succsesfully Authenticate the client vai OAUTH2 and getting the token.
2. Creating complex payload in pojo classes and pass it to create Order.
3. Test the presence of the created order and veryfing data which was previosly send as body.
4. Using selenium in headless mode log in to presonal sandbox account get ammount 
and later get redirected url upon succsesfull approval
5. And at the end getting the same order and veryfing status affter approval.
6. Extent report create html doc. upon every test run

The whole test is conected al data passing from test to test dynamicly,
for every test Hard TestNG assertion has been used.


