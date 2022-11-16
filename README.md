# Factory Staff Management Application

## Introduction

This application will regulate staffs in a factory. It will keep the profile of every worker, record how many hours they have worked and the number of tasks they completed. The factory manager can update statistics for them, and calculate their wage. Anyone who works as a factory manager or runs a similar business can use this application to help them organize information about their employees.

This project is of interest to me because of a real-life story. My uncle runs a small factory in my hometown, and he does all the staff management work on paper. I find it tiring for him do all his work on paper. For example, he has to do a lot of redundant work like copying information down, it takes him a long time to find a particular information from a huge pile of paper. Also, it is easy for him to make mistakes when calculating each worker’s wage.



##User Stories:
- As a user, I want to be able to **add** workers to my factory
- As a user, I want to be able to **remove** workers from my factory
- As a user, I want to be able to select a worker in my factory and **update statistics** for them, for example, how many hours they have worked and how many tasks they have completed
- As a user, I want to be able to view names of workers in this factory
- As a user, I want to be able to view the profile of each worker
- As a user, I want to be able to select a worker and **calculate the wage** of that worker
- As a user, when I select the quit option from the application menu, I want to be able to save my worker list and each worker's statistics to file.
- As a user, when I start the application, I want to be able to load my worker list and each worker's statisitcs form file.

##Phase 4: Task 2

Mon Mar 28 13:15:09 PDT 2022
worker added to factory


Mon Mar 28 13:15:11 PDT 2022
worker added to factory


Mon Mar 28 13:15:13 PDT 2022
worker added to factory


Mon Mar 28 13:15:16 PDT 2022
Worker removed from factory


Mon Mar 28 13:15:22 PDT 2022
Updated statistics for worker

##Phase 4: Task 3

- I would create an abstract class with methods labels( ), textFields( ), and button( ) and implement these methods when constructing each label, textField, and button.

- Instead of implement the labels( ), textFields( ), and button( ) methods separately in Add, Remove, Update, ShowProfile, Save, Load, BarGraph, Quit class, I would create a Label class, a TextField class, and a Button class that implement all the methods about labels, text fields, and buttons.

- For drawHours(Graphics g) method and drawTasks(Graphics g) method, removeHours(Graphics g) method  and removeTasks(Graphics g) method in BarGraph class, I would change the part they have in common to a helper method and call the helper method when implementing them.

- I would combine Main and GUI as one class since Main does the exactly same thing as GUI does.
