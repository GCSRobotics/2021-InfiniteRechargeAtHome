package frc.robot;

import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

public class Constants {
    // Motor Constants
    public final static int IndexMotor = 4;
    public final static int IntakeMotor = 5;
    public final static int leftShooterMotor = 6;
    public final static int rightShooterMotor = 7 ;

    public final static int leftFrontDriveMotor = 10;
    public final static int leftRearDriveMotor = 11;
    public final static int RightFrontDriveMotor = 12;
    public final static int RightRearDriveMotor = 13;

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

    // Wheel Distance Calculations
    public final static double WheelDiameter = 6.00;
    public final static double DriveGearRatio = 1/10.71;  //Tufbox Mini Default Ratio 10.71:1
    public final static double NeoEncoderCountsPerRev = 42;
    public final static double InchesPerMotorRotation = Math.PI * WheelDiameter/DriveGearRatio;    //NeoEncoderCountsPerRev

    public final static int VisionPipeline_HexTarget = 0;
    public final static int VisionPipeline_Powercell = 1;

}

