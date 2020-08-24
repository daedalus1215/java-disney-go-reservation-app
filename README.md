# Scraper/Notifier
#### Objective
To be able to scrap specific websites and gather information specific to the need.

This started out as a Disney Reservation project. So we could get reservations easily. 
Disney restaurants fill up and drop so often, that it seemed like it was taking forever 
to get the right reservation to fit our schedule. So this was setup to hit their site. It worked. 
Eventually we did not need it. But when we did, we built a react/express/mongo app to build up
reservations this app could use to hit the days/reservations with the details. But Disney changed 
something and HtmlUnit seemed to have limitations when trying to handle Disney's COVID changes. So then
I brought in selenium, hoping this would work. It did, for a bit, but there is now some difficulty getting
it exact. In the meantime... we got our reservations.

Now Fuzz wants something similar. To notify him when the wood he wants drops below a price. So I gut 
most of the old stuff, brought in checkstyle, maven bundling (like shade). Everything seems to work.

### Intent
Eventually to go back and get the app to work fully with Disney's site. But in the meantime, will focus
on just the price for some hard wood. 

#### How to run project
1. Copy `src/main/java/config/app.properties.dist` and paste to `src/main/java/config/app.properties` (to be able to run the .jar, when we are ready for production).  
1. Make the necessary tweaks
1. copy `src/main/java/config/app.properties.dist` to `src/main/resources/app.properties` (to be able to run the project).
