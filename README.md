This repository is a clone of the 2024 FTC SDK. It is meant to be an easy way for you to compare how a motor runs without PID, with the built in PID controller, and with a custom PID controller. 

Materials: Control Hub, motor, motor encoder wire, an 8mm REX hub, a U-channel of any length, and 
some screws. You 
also need a phone with the FTC driver station app installed.

FTC Dashboard will be utilized to make tuning the PID coefficients easier.

How to connect to have wireless connection to Control Hub:
    Install Android Studios and check if platform tools is installed in the Sdk manager
    In Android Studios, go to File, Settings, then Plugins, and install ADB WiFi by Yury Polek
    Turn on the Control Hub, and connect to it with your computer through WiFi
    Connect the Control Hub with USB to your computer
    Click on the ADB WiFi tab on the far right of your Android Studios
    Click the connect button
    Unplug your Control Hub, and it should now be connected wirelessly!
    Note: You may have to do this everytime you restart Android Studios unfortunately

How to install FTC Dashboard:
    Follow all the instructions in the Basic section of both Installation and Usage: https://acmerobotics.github.io/ftc-dashboard/gettingstarted

Configuring your driver station:
    Open the driver station app
    Go to the Configure Robot tab and create a new hardware map, mapping the 0th motor port to a 
5203 GoBilda motor and call it "motor"
    Name the hardware map "motorTest"

To use FTC Dashboard: 
    Go to http://192.168.43.1:8080/dash
    Select Enable/Disable Dashboard in the TeleOp list in the Driver Station App
    Select the OpMode you want in the OpMode list towards the left of the website