# Web-Visual-Login
Demonstrate login via web page popup using visual transactions

This is an example website with two popups:
1- Login, using username and password
2- Once login is successful, Chrome will typically ask to save the password

The mechanism of visual analysis and transactions finds the popups, enters the username and password to the relevant fields and clicks login. Post login we validate we're logged in and dismiss the popup.

Check out Perfecto's visual analysis functions for more details: http://developers.perfectomobile.com/display/PD/Visual+Analysis+Functions

Project structure:
It's a testNG project, main file is in "TestWebVisualLogin.java". It get the driver defined in testNG.xml (Chrome 56 on Win 10 machine) from utils.java and orchestrates the loging etc. VisualHandle.java does the text Edit-Set for the login window. 
PerfectoUtils.java brings on ocrTextClick. 
