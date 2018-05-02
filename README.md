# MakeChange

MakeChange is a Java project that aims to display the least amount of coins needed to make change for any given monetary amount. This project was created in Eclipse and you will find the entire Eclipse project in this repository.

## Getting Started

You can import this project directly into Eclipse by navigating to Eclipse->File->Import->Git and entering this repositories URI. Once you have the project imported you should be able to just Run the project and view the reults in the Eclipse console. 

If you are not using Eclipse, the src folder of this repository contains all the Java files needed (Main, ChangeHandler, and Coin). Setup the files/package however you prefer and run the driver class 'Main' as an alternative to running within Eclipse.

### Prerequisites

This is a Java project so you will need to be able to execute Java files on your machine in order to successfully run MakeChange.  As stated before I used Eclipse to create, develop, and test this project so I recommend importing this project direcly into Eclipse.

```
Get Eclipse from: https://www.eclipse.org/downloads/
```

## Built With

* Java
* Eclipse IDE


## Authors

* **Alexander Sears**

## Screenshots of what to expect
* Here you can see the console output of the makeChange() method making change using the 'standard' US coins: Quarter, Dime, Nickel, and Penny.
![Screenshot of normal coins in use](../master/screenshots/grab_1.png)
* And here you can see the console output of the makeChange() method making change using the 'standard' US coins alongside the 'extra' coins created by the user. You can use any amount of coins with any value and the makeChange() method will run perfectly fine.
![Screenshot of user-generated coins in use](../master/screenshots/grab_2.png)
