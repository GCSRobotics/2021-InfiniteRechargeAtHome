package frc.robot;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

public class Constants {
    // Motor Constants
    public final static int IndexMotor = 4;
    public final static int IntakeMotor = 5;

    // Controller 
    public final static int DriveJoystick = 0;
    public final static int OperatorJoystick = 1;
    
    // Intake 
    public final static int PCM = 1;  // CAN position
    public final static int IntakeExtendChannel = 0;
    public final static int IntakeRetractChannel = 1;

    // Index
    public final static Color YellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
    public final static I2C.Port i2cPort = I2C.Port.kOnboard;

}
