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
@TeleOp(name="Custom PID Velocity", group="Linear OpMode")
public class CustomPID_Velocity extends LinearOpMode {
  DcMotorEx motor = null;

  public static double Kp;
  public static double Ki;
  public static double Kd;
  public static int targetVelocity = 0;
  public double previousError = 0;
  public double previousTime = 0;
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
    timer.reset();
      while(opModeIsActive()) {
        double power = PIDControl(motor.getVelocity());
        motor.setPower(power);
        dashboardTelemetry.addData("Velocity", motor.getVelocity());
        dashboardTelemetry.update();
      }

  }

  public double PIDControl(double currentVelocity) {
    double currentTime = timer.milliseconds();
    double currentError = targetVelocity - currentVelocity;
    p = Kp*currentError;
    i += Ki*(currentError * (currentTime-previousTime));
    d = Kd * (currentError - previousError) / (currentTime-previousTime);
    previousTime = currentTime;
    previousError = currentError;
    dashboardTelemetry.addData("Error", currentError);
    dashboardTelemetry.addData("Time", currentTime - previousTime);
    return p+i+d;
  }
}