package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSub extends SubsystemBase{
    
    private final WPI_TalonSRX leftShooter = new WPI_TalonSRX(Constants.leftShooterMotor);
    private final WPI_TalonSRX rightShooter = new WPI_TalonSRX(Constants.rightShooterMotor);
  private final WPI_VictorSPX shooterAdjustment = new WPI_VictorSPX(Constants.shooterAdjustment);
    public ShooterSub() {
        this.leftShooter.configFactoryDefault();
        this.rightShooter.configFactoryDefault();
        this.leftShooter.setInverted(false);
        this.rightShooter.setInverted(true);
    }

    public void runShooter() {
        this.leftShooter.set(ControlMode.PercentOutput, .6);
        this.rightShooter.set(ControlMode.PercentOutput, .6);
    }

    public void stopShooter() {
        this.leftShooter.set(0);
        this.rightShooter.set(0);
    }
    public void adjustShooter() {
        this.shooterAdjustment.set(ControlMode.PercentOutput, .25);
    }
    public void stopShooterAdjustment(){
        this.shooterAdjustment.set(0);
    }
}

