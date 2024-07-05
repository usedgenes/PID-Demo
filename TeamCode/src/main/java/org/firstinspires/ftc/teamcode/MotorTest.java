package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Config
@TeleOp(name="Basic: Omni Linear OpMode", group="Linear OpMode")
public class MotorTest extends LinearOpMode {
    public static double MOTOR_POWER = 0;
    DcMotor motor = null;
    public void runOpMode() {

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        motor = hardwareMap.get(DcMotor.class, "motor");

        motor.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            motor.setPower(MOTOR_POWER);
        }
    }
}
