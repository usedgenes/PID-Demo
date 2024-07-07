package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Config
@TeleOp(name="Custom PID Position", group="Linear OpMode")
public class CustomPID_Position extends LinearOpMode {
  DcMotorEx motor = null;

  public static double integralSum = 0;
  public static double Kp;
  public static double Ki;
  public static double Kd;
  public static int targetPosition = 0;
  public double previousError;
  public double p;
  public double i;
  public double d;

  FtcDashboard dashboard = FtcDashboard.getInstance();
  Telemetry dashboardTelemetry = dashboard.getTelemetry();
  ElapsedTime timer = new ElapsedTime();

  @Override
  public void runOpMode() throws InterruptedException {
    motor = hardwareMap.get(DcMotorEx.class, "motor");
    motor.setDirection(DcMotor.Direction.FORWARD);
    motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    waitForStart();
      while(opModeIsActive()) {
        while(motor.getCurrentPosition() != targetPosition) {
          double power = PIDControl(timer.time(), motor.getVelocity());
          motor.setPower(power);
          dashboardTelemetry.addData("Velocity", motor.getVelocity());
          dashboardTelemetry.update();
          timer.reset();
        }
      }

  }

  public double PIDControl(double currentTime, double currentVelocity) {
    double currentError = targetPosition - currentVelocity;
    p = Kp * currentError;
    i = i + Ki * (currentError * currentTime);
    d = Kd * (currentError - previousError) /currentTime;
    previousError = currentError;
    dashboardTelemetry.addData("Error", currentError);
    dashboardTelemetry.addData("Time", currentTime);
    return p+i+d;
  }
}