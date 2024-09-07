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

An image of an example setup for the motor is located in this repository, though there are many 
ways you can secure a motor in place.

For manual tuning:
    1. Set I and D coefficients to zero
    2. Increase the P coefficient until the motor output has consistent and stable oscillations
    3. Increase the D coefficient until there is no overshoot
    4. If the motor is unable to reach the desired position, increase the I coefficient until it 
does.

Coefficients to get started for Custom PID Velocity:
P - 0.0005
I - 0.00001
D - 0.001

What tuning the PID using FTC Dashboard looks like:   
![PID Tuning](https://github.com/usedgenes/PID-Demo/blob/main/Tuning/Screenshot%20(30).png)
