package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;

public class ShooterSub extends SubsystemBase {
    private String area = "green";
    private final WPI_TalonSRX leftShooter = new WPI_TalonSRX(Constants.leftShooterMotor);
    private final WPI_TalonSRX rightShooter = new WPI_TalonSRX(Constants.rightShooterMotor);
    private final WPI_VictorSPX shooterAdjustment = new WPI_VictorSPX(Constants.shooterAdjustment);
    // private final Encoder tiltEncoder = new Encoder(Constants.ShooterEncoderA, Constants.ShooterEncoderB);
    // private final PIDController pidController = new PIDController(0.07, 0, .005);
    // private double ShooterPositionDegree = 0;

    public ShooterSub() {
        this.leftShooter.configFactoryDefault();
        this.rightShooter.configFactoryDefault();
        this.leftShooter.setInverted(false);
        this.rightShooter.setInverted(true);
        // tiltEncoder.setDistancePerPulse(Constants.ShooterWheelDegreesPerPulse);
        // tiltEncoder.reset();
        // tiltEncoder.setReverseDirection(true);
        // addChild("Tilt Encoder", tiltEncoder);
        // addChild("Tilt PID", pidController);
    }

    // @Override
    // public void periodic() {
    //     double output = pidController.calculate(tiltEncoder.getDistance(), ShooterPositionDegree); 

    //     double outputC = MathUtil.clamp(output, -0.5, 0.5);
    //     adjustShooter(outputC);
    // }

    // public void setShooterPosition(double degrees) {
    //     ShooterPositionDegree = degrees;
    // }

    public void adjustShooter(double speed) 
    {
        this.shooterAdjustment.set(ControlMode.PercentOutput, speed);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void runShooter() {
        this.leftShooter.set(ControlMode.PercentOutput, .6);
        this.rightShooter.set(ControlMode.PercentOutput, .6);
    }

    public void runShooter(double speed) {
        this.leftShooter.set(ControlMode.PercentOutput, speed);
        this.rightShooter.set(ControlMode.PercentOutput, speed);
    }

    public void stopShooter() {
        this.leftShooter.set(0);
        this.rightShooter.set(0);
    }

}
