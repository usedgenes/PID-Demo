This repository is a clone of the 2024 FTC SDK. It is meant to be an easy way for you to compare how a motor runs without PID, with the built in PID controller, and with a custom PID controller. 

Materials: Control Hub, Motor, an 8mm REX hub, a U-channel of any length, and some screws.

FTC Dashboard will be utilized to make tuning the PID coefficients easier.

How to connect to have wireless connection to Control Hub:
    Install Android Studios and check if platform tools is installed in the Sdk manager
    In Android Studios, go to File, Settings, then Plugins, and install ADB WiFi by Yury Polek
    Turn on the Control Hub, and connect to it with your computer through WiFi
    Connect the Control Hub with USB to your computer
    Click on the ADB WiFi tab on the far right of your Android Studios
    Click the connect button
    Unplug your Control Hub, and it should now be connected wirelessly!
    To connect in the future, just go to the ADB WiFi tab and click connect again

How to install FTC Dashboard:
    Follow all the instructions in the Basic section of both Installation and Usage: https://acmerobotics.github.io/ftc-dashboard/gettingstarted

Other steps:
    Install the FTC Driver Station app on any phone
    Go to the Configure Robot tab and create a new hardware map, mapping the 0th motor port to a 
5203 GoBilda motor and call it "motor"
Name the hardware map "motorTest"