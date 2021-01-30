package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSub extends SubsystemBase {
    private static final WPI_VictorSPX IntakeMotor = new WPI_VictorSPX(Constants.IntakeMotor);
    private static final DoubleSolenoid solenoid = new DoubleSolenoid(Constants.IntakeExtendChannel, Constants.IntakeRetractChannel);

    /**
     * Creates a new IntakeSub.
     */
    public IntakeSub() {
        addChild("IntakeMotor", IntakeMotor);
        addChild("solenoid", solenoid);
    }

    public void stopIntake() {
        IntakeMotor.set(0);
    }
     
    public void runIntake(){
        IntakeMotor.set(-.5);
    }
     
    public void reverseIntake(){
        IntakeMotor.set(.4);
    }
    
    public void extendIntake() {
        solenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void retractIntake() {
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }
}
