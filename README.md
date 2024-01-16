Multiplication Table Memorization Tool
Description
This project aims to assist elementary school children in memorizing the multiplication table through an interactive graphical user interface (GUI). 
The key features expected in this assignment are outlined below:

User Authentication: Upon opening the game, users will be prompted to log in. The program should support both parent and multiple child users. The parent user will function as an administrator (admin) with the ability to make various adjustments.

Customizable Practice Mode: The default practice mode will involve N random multiplication questions of the form axb (where a ranges from 1 to 10, b ranges from 1 to 10). The parent user should be able to define exercises by adjusting the ranges of a, b, and the number of questions (N).

Real-time Exercise Tracking: When a child initiates an exercise, a visible timer should be displayed. The system should log details such as which child started which exercise, the time taken to complete the exercise, the multiplication questions posed, the time taken to answer each question, and whether each question was answered correctly.

Scoring System: The system should generate speed and accuracy scores from the exercise results. These scores should be added to the log, communicated to the child, and stored in a "high scores" table for that specific exercise.

Reporting Interface: A reporting screen should be available to parents, displaying comprehensive logs. Bonus points will be awarded for graphical representations in the reports. Reports should be saved as a text file with tab-separated sections for easy opening in Excel.

Serialization for Data Storage: All program settings, user profiles, defined exercises, etc., should be stored in a file using serialization.

Usage
Login: Open the game and log in with your credentials. Parent users have administrative privileges.

Customize Exercises: Parent users can customize exercises by adjusting the ranges of multiplication factors and the number of questions.

Real-time Tracking: The system tracks exercise details in real-time, including timing, questions, and correctness.

Scoring: Speed and accuracy scores are generated and stored for each exercise.

Reports: Access a reporting screen to view logs. Reports can be saved as text files for further analysis.

Serialization: All program data is stored efficiently using serialization for easy retrieval.
