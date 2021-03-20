package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSub extends SubsystemBase {
    private static final WPI_VictorSPX IntakeMotor = new WPI_VictorSPX(Constants.IntakeMotor);
    private static final DoubleSolenoid solenoid = new DoubleSolenoid(Constants.PCM, Constants.IntakeExtendChannel, Constants.IntakeRetractChannel);

    /**
     * Creates a new IntakeSub.
     */
    public IntakeSub() {
        addChild("IntakeMotor", IntakeMotor);
        addChild("solenoid", solenoid);
        solenoid.set(DoubleSolenoid.Value.kReverse);
    }

    public void stopIntake() {
        IntakeMotor.set(0);
    }
     
    public void runIntake(){
        if (DoubleSolenoid.Value.kForward == solenoid.get()) {
            IntakeMotor.set(-.5);
        }
    }
     
    public void reverseIntake(){
        IntakeMotor.set(.4);
    }
    
    public void extendIntake() {
        if (DoubleSolenoid.Value.kReverse == solenoid.get()) {
            solenoid.toggle();
        }
    }

    public void retractIntake() {
        if (DoubleSolenoid.Value.kForward == solenoid.get()) {
            solenoid.toggle();
        }
    }
}
