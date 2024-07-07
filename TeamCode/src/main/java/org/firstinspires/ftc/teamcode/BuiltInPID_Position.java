package org.firstinspires.ftc.teamcode;

import android.icu.text.Transliterator;

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
@TeleOp(name="Built In PID Position", group="Linear OpMode")
public class BuiltInPID_Position extends LinearOpMode {
    public static int POSITION = 0;
    public static double p;
    DcMotorEx motor = null;
    FtcDashboard dashboard = FtcDashboard.getInstance();
    Telemetry dashboardTelemetry = dashboard.getTelemetry();
    public void runOpMode() {

        motor = hardwareMap.get(DcMotorEx.class, "motor");
        motor.setDirection(DcMotor.Direction.FORWARD);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setTargetPosition(POSITION);
        PIDFCoefficients pidfCoefficients = motor.getPIDFCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION);
        p = pidfCoefficients.p;
        waitForStart();

        while (opModeIsActive()) {
            motor.setPositionPIDFCoefficients(p);
            motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor.setTargetPosition(POSITION);
            motor.setMotorEnable();
            dashboardTelemetry.addData("Encoder value", motor.getCurrentPosition());
            dashboardTelemetry.addData("Velocity", motor.getVelocity());
            dashboardTelemetry.update();
        }
    }
}
