package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

//Simple program to test a motor
// 0 = stop, 1 = full power, negative = reverse direction
@Config
@TeleOp(name="Motor Test", group="Linear OpMode")
public class MotorTest extends LinearOpMode {
    public static double MOTOR_POWER = 0;
    DcMotor motor = null;
    public void runOpMode() {

        motor = hardwareMap.get(DcMotor.class, "motor");

        motor.setDirection(DcMotor.Direction.FORWARD);

        waitForStart();

        while (opModeIsActive()) {
            motor.setPower(MOTOR_POWER);
        }
    }
}
