package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSub extends SubsystemBase{
    
    private final WPI_TalonSRX leftShooter = new WPI_TalonSRX(Constants.leftShooterMotor);
    private final WPI_TalonSRX rightShooter = new WPI_TalonSRX(Constants.rightShooterMotor);
  
    public ShooterSub() {
        this.leftShooter.configFactoryDefault();
        this.rightShooter.configFactoryDefault();
        this.leftShooter.setInverted(true);
        this.rightShooter.setInverted(false);
    }

    public void runShooter() {
        this.leftShooter.set(ControlMode.PercentOutput, 1);
        this.rightShooter.set(ControlMode.PercentOutput, 1);
    }

    public void stopShooter() {
        this.leftShooter.set(0);
        this.rightShooter.set(0);
    }
}
