package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSub extends SubsystemBase {
    private CANSparkMax leftFrontMotor = new CANSparkMax(10, MotorType.kBrushless);
    private CANSparkMax leftRearMotor = new CANSparkMax(11, MotorType.kBrushless);
    private CANSparkMax rightFrontMotor = new CANSparkMax(12, MotorType.kBrushless);
    private CANSparkMax rightRearMotor = new CANSparkMax(13, MotorType.kBrushless);
    private CANEncoder leftFrontEncoder = leftFrontMotor.getEncoder();
    private CANEncoder leftRearEncoder = leftRearMotor.getEncoder();
    private CANEncoder rightFrontEncoder = rightFrontMotor.getEncoder();
    private CANEncoder rightRearEncoder = rightRearMotor.getEncoder();
  
    private final SpeedControllerGroup speedControllerGroupLeft = 
        new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
    private final SpeedControllerGroup speedControllerGroupRight = 
        new SpeedControllerGroup(rightFrontMotor, rightRearMotor);

    private final DifferentialDrive robotDrive =
        new  DifferentialDrive(speedControllerGroupLeft, speedControllerGroupRight);

    public DriveSub() {
        // addChild("LeftFront",leftFrontMotor);
        // addChild("LeftRear", leftRearMotor);
        // addChild("RightFront", rightFrontMotor);
        // addChild("RightRear", rightRearMotor);
        // addChild("ControllerLeft", speedControllerGroupLeft);
        // addChild("ControllerRight", speedControllerGroupRight);
    
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

    @Override
    public void periodic() {
      // This method will be called once per scheduler run
    }
  
    public void stop() {
      robotDrive.arcadeDrive(0, 0);
    }
    
}
