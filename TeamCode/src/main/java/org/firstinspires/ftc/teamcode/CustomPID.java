package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

@Config
@TeleOp(name="Custom PID", group="Linear OpMode")
public class CustomPID extends LinearOpMode {
  DcMotorEx motor = null;

  public static double integralSum = 0;
  public static double Kp;
  public static double Ki;
  public static double Kd;
  public static int targetVelocity = 0;
  public double previousTime;
  public double previousError;
  public double p;
  public double i;
  public double d;

  ElapsedTime timer = new ElapsedTime();

  @Override
  public void runOpMode() throws InterruptedException {
    motor = hardwareMap.get(DcMotorEx.class, "motor");
    motor.setDirection(DcMotor.Direction.FORWARD);
    motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    waitForStart();
    previousTime = timer.time();
      while(opModeIsActive()) {
        double power = PIDControl(timer.time(), motor.getVelocity());
        motor.setPower(power);
        telemetry.addData("Velocity", motor.getVelocity());
        telemetry.update();
      }

  }

  public double PIDControl(double currentTime, double currentVelocity) {
    double currentError = targetVelocity - currentVelocity;
    p = Kp * currentError;
    i = i + Ki * (currentError * (currentTime - previousTime));
    d = Kd * (currentError - previousError) / (currentTime - previousTime);
    previousError = currentError;
    previousTime = currentTime;
    telemetry.addData("P", p);
    telemetry.addData("I", i);
    telemetry.addData("D", d);
    return p+i+d;
  }
}