# scheduler

## Project Pitch


Our objective is to build a simple study application with various different features, of which some involve stretch goals. In the simplest form of the app, we want to build a scheduler that takes inputs from the user of events they have during the day as well as times for waking up and sleeping and outputs their schedule in a list form. The next prototype would take the list and output it in a calendar format, similar to the one on Google Calendar. Some further goals we want to achieve, if time allows, include creating different “types” of categories that our events would fall into and having a drop-down menu where we can select and filter out the events of our chosen “type”, implementing different study techniques and creating a study schedule for the user depending on when they’re busy and which study technique they chose, as well as asking the user to input what they hope to achieve during a study session and afterward how much they completed, and displaying this information to the user. We will be using Android Studio to develop our mobile app, which will mainly be written in Java. We may also utilize JavaScript for frontend implementation. One member has an Android device that we will hopefully be able to test on and, if not, we plan to use online Android emulators.

## Learning goals and milestones:

**1. Set-up and Familiarizing ourselves with app development environment:**

Mobile app development and Android Studio were new territories for all of us, so we spent some time installing the right packages, following online tutorials to help us obtain the basic understanding of how everything works.

There are a lot of different files within a blank project template so we had to navigate them to determine which ones we needed to edit or new files we needed to create in order to create the layout and effects we desired. 

**2. Implementing our goal/what we were able to do**

There were two main file types we worked with to design our UI layout and code the functions we desired: **xml** files for working with the layout and **java** files for writing different functions such as coding what a button would do when clicked.

We aimed for a very simple layout. We had two pages, one for the main events page that would display the date and the list of events occuring on that date below. The second page is the create events page. Essentially, when the user clicks on the small purple plus button from the main page, the app takes you to the second page with a textbox and date picker box. The app asks for the user to input the event name and choose a specific date from the date picker. Once all information has been inputted, the user can click the save button which takes you back to the main events screen. 

Something we were still in the process of implementing consisted of the function that creates the list of dates and events and displays it to the user. We used a HashMap to store our data with the keys being the dates and each value a list (type string) of all events that occured during that specific time. Our function orderEvent() would take in as a parameter an event and specified date from the user and check whether that date already exists in the HashMap. If it did, we would just add the event to the list (value) corresponding to the date (key). Otherwise, we would create a new key and value (list). 

We also wrote up a simple toString method that would output the date and list of events occuring on that date (~cue live demo).

**3. Github Usage and Experience**

It was a pretty smooth experience using github. We didn't have any merge conflicts and were in constant communication whilst working next to each other. I'd say it was super helpful getting to constantly ask each other questions and notify each other when we made pushes to our github repo.

**4. Next steps**

If we had more time, We would like to make the UI/layout look a bit cleaner and maybe a bit more aesthetic! Our next goal in the series of ones we set was to make our UI look more like the "daily view" in google calendar. Some other features included creating a reccomended study schedule based on unfilled time in your schedule depending on which study technique the user picks!