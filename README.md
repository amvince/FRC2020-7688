# FRC2020-7688
Personal GitHub Repo For Testing

## TODO
1. Create a Joystick Map for the driveres
2. Test & "shift" the colour code so whichever colour is picked actually stops in lign with the sensros.

## Insturctions for Dashboard
### Install
1. Copy FRCDashboard folder to Desktop
2. Copy the FRCLaunch.bat file to the desktop.
3. Edit FRCLaunch.bat file so the line "cd C:\Users\your_name\Dekstop\FRCDashboard" replaces user_name with your user name.

You need to make sure Node.js has been completely installed on the computer in question.
If, when starting FRCLaunch.bat it gives an error regarding electron, you will probably have to remove the "electron" folder from within \FRCDashboard\node_modules and from the command prompt in the FRCDashboard folder type "npm install"

### Run
1. Start up FRC Driver station first. Wait for it to connect completely.
2. Close the stock dashboard, then run FRCLaunch.bat - this should work, if it fails, navigate to the FRCDashbaord folder and type "npm start"
You may need to reload CTRL-R to get the camera to work. If the camera does not seem to connect, open a browser window and navigate to http://10.76.88.2:1181/?action=stream Make this window small, and put it to the bottom left of the screen.
