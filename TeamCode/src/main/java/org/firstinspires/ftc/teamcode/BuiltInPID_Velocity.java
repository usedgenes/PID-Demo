package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//Simple program to test a motor
// 0 = stop, 1 = full power, negative = reverse direction
@Config
@TeleOp(name="Built In PID Velocity", group="Linear OpMode")
public class BuiltInPID_Velocity extends LinearOpMode {
    public static double VELOCITY = 0;
    public static double Kp;
    public static double Ki;
    public static double Kd;
    public static double Kf;
    DcMotorEx motor = null;
    FtcDashboard dashboard = FtcDashboard.getInstance();
    Telemetry dashboardTelemetry = dashboard.getTelemetry();
    public void runOpMode() {

        motor = hardwareMap.get(DcMotorEx.class, "motor");

        motor.setDirection(DcMotor.Direction.FORWARD);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        PIDFCoefficients pidfCoefficients =
                motor.getPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER);
        Kp = pidfCoefficients.p;
        Ki = pidfCoefficients.i;
        Kd = pidfCoefficients.d;
        Kf = pidfCoefficients.f;
        waitForStart();

        while (opModeIsActive()) {
            motor.setVelocity(VELOCITY);
            motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.setVelocityPIDFCoefficients(Kp, Ki, Kd, Kf);
            dashboardTelemetry.addData("Encoder value", motor.getCurrentPosition());
            dashboardTelemetry.addData("Velocity", motor.getVelocity());
            dashboardTelemetry.update();
        }
    }
}
