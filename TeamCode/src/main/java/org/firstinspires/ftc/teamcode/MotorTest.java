package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

//Simple program to test a motor
// 0 = stop, 1 = full power, negative = reverse direction
@Config
@TeleOp(name="Motor Test", group="Linear OpMode")
public class MotorTest extends LinearOpMode {
    public static double MOTOR_POWER = 0;
    FtcDashboard dashboard = FtcDashboard.getInstance();
    Telemetry dashboardTelemetry = dashboard.getTelemetry();
    DcMotorEx motor = null;
    public void runOpMode() {

        motor = hardwareMap.get(DcMotorEx.class, "motor");

        motor.setDirection(DcMotor.Direction.FORWARD);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();

        while (opModeIsActive()) {
            motor.setPower(MOTOR_POWER);
            dashboardTelemetry.addData("Encoder Position", motor.getCurrentPosition());
            dashboardTelemetry.addData("Velocity", motor.getVelocity()  );
            dashboardTelemetry.update();
        }
    }
}
