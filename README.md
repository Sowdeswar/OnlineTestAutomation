OnlineTestAutomation

Tools and Languages used for the test automation:
•	Language: Java 
•	Framework: Cucumber
•	Build Tool: Maven
•	Report: Allure Report

List of API as part of the test validation:
1.	Post/Messages - Used to create message 
•	Have used to create messages by hitting the post/messages API call.
•	Have validated whether we can receive the status code as 200
•	And validated whether we can receive the ID attribute in the response and also stored the ID value in a parameter for the Get/ messages and delete/messages call.
2.	Get/Messages - Two Types
•	Query Parameter: We need to pass the from and to message names as a query parameter.
•	Have validated whether we can receive the status code as 200
•	Path Parameter: Have passed the ID as a path parameter request which we get it from the post call.
•	Have validated the status code and the response contains the ID attribute.
3.	Delete/Messages – used to delete the created messages.
•	It is also path parameter where we need to pass the ID as input to delete the entry.

Execution Methods:
•	Have integrated the allure reports into the framework. Run the below command to start the execution of the script.
      mvn clean test allure:report
•	We can see the reports are generated in the target/allure-results/html-reports.
•	Under the index.html file will be available which can be opened in the browsers to view the overall test summary.

[OnlineTestAutomationReadme.docx](https://github.com/user-attachments/files/15984321/OnlineTestAutomationReadme.docx)
