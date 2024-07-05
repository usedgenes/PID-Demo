package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDCoefficients;

//Simple program to test a motor
// 0 = stop, 1 = full power, negative = reverse direction
@Config
@TeleOp(name="Built In PID Velocity", group="Linear OpMode")
public class BuiltInPID_Velocity extends LinearOpMode {
    public static double VELOCITY = 0;
    public static double Kp;
    public static double Ki;
    public static double Kd;
    DcMotorEx motor = null;
    public void runOpMode() {

        motor = hardwareMap.get(DcMotorEx.class, "motor");

        motor.setDirection(DcMotor.Direction.FORWARD);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        PIDCoefficients pidCoefficients = motor.getPIDCoefficients(motor.getMode());
        Kp = pidCoefficients.p;
        Ki = pidCoefficients.i;
        Kd = pidCoefficients.d;

        waitForStart();

        while (opModeIsActive()) {
            motor.setVelocity(VELOCITY);
            motor.setPIDCoefficients(DcMotor.RunMode.RUN_TO_POSITION, new PIDCoefficients(Kp, Ki,
                    Kd));
            telemetry.addData("Encoder value", motor.getCurrentPosition());
            telemetry.update();
        }
    }
}
