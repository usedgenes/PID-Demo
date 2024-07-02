public class DefaultPID {
  DCMotorEx motor;

  double integralSum = 0;
  double Kp;
  double Ki;
  double Kd;

  ElapsedTime timer = new ElapsedTime();
  @Override
  public void runOpMode() throws InterruptedException {
    // Creates a PIDFController with gains kP, kI, kD, and kF
    PIDFController pidf = new PIDFController(kP, kI, kD, kF);

        /*
         
Here are the constructors for the other controllers*/
    PIDController pid = new PIDController(kP, kI, kD);
    PDController pd = new PDController(kP, kD);
    PController p = new PController(kP);}

  public double PIDControl(double reference, double state) {
    double error = reference - state;
  }
}