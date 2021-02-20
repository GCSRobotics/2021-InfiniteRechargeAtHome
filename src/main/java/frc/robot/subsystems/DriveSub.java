package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.SPI;

public class DriveSub extends SubsystemBase {
  private CANSparkMax leftFrontMotor = new CANSparkMax(10, MotorType.kBrushless);
  private CANSparkMax leftRearMotor = new CANSparkMax(11, MotorType.kBrushless);
  private CANSparkMax rightFrontMotor = new CANSparkMax(12, MotorType.kBrushless);
  private CANSparkMax rightRearMotor = new CANSparkMax(13, MotorType.kBrushless);
  private CANEncoder leftFrontEncoder = leftFrontMotor.getEncoder();
  private CANEncoder leftRearEncoder = leftRearMotor.getEncoder();
  private CANEncoder rightFrontEncoder = rightFrontMotor.getEncoder();
  private CANEncoder rightRearEncoder = rightRearMotor.getEncoder();



  private final SpeedControllerGroup speedControllerGroupLeft = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
  private final SpeedControllerGroup speedControllerGroupRight = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);

  private final DifferentialDrive robotDrive = new DifferentialDrive(speedControllerGroupLeft,
      speedControllerGroupRight);

  private final ADXRS450_Gyro gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS1);

  public DriveSub() {
    // Use inches as unit for encoder distances
    leftFrontEncoder.setPositionConversionFactor(Constants.NeoDistancePerPulse);
    rightFrontEncoder.setPositionConversionFactor(Constants.NeoDistancePerPulse);
    leftRearEncoder.setPositionConversionFactor(Constants.NeoDistancePerPulse);
    rightRearEncoder.setPositionConversionFactor(Constants.NeoDistancePerPulse);

    gyro.calibrate();
    resetEncoders();
  }

  public void reset() {
    resetEncoders();
  }

  public void arcadeDrive(Joystick joy) {
    double speed = joy.getY() * .01;
    robotDrive.arcadeDrive(speed, joy.getRawAxis(4), true);
  }

  public void arcadeDrive(double speedAxis, double rotationAxis) {
    robotDrive.arcadeDrive(speedAxis, rotationAxis, true);
  }

  public void arcadeDrive(double speedAxis, double rotationAxis, boolean squared) {
    robotDrive.arcadeDrive(speedAxis, rotationAxis, squared);
  }

  public void tankDrive(double leftSpeed, double rightSpeed){
    robotDrive.tankDrive(leftSpeed, rightSpeed);
  }

  public void tankDrive(double leftSpeed, double rightSpeed, boolean squared){
    robotDrive.tankDrive(leftSpeed, rightSpeed, squared);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop() {
    robotDrive.arcadeDrive(0, 0);
  }

  public void resetEncoders() {
    leftFrontEncoder.setPosition(0.0);
    rightFrontEncoder.setPosition(0.0);
  }

  public double getLeftDistanceInch() {
    return leftFrontEncoder.getPosition();
  }

  public double getRightDistanceInch() {
    return rightFrontEncoder.getPosition();
  }

  public double getAverageDistanceInch() {
    return (getLeftDistanceInch());// + getRightDistanceInch()) / 2.0;
  }

  // There are two outputs from the gyro that we need to create Get methods for
  public double getGyroAngle() {
    return gyro.getAngle();
  }

  public double getGyroRate() {
    return gyro.getRate();
  }

}
