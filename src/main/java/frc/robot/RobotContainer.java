package frc.robot;

import frc.robot.commands.driveSub.DriveWithController;
import frc.robot.subsystems.*;

public class RobotContainer {
    //Drive Subsystem
    public static DriveSub drive = new DriveSub();

    //Operator Interface
    private static OI oi = new OI();

    public void setTeleopDefaultCommands() {
        drive.setDefaultCommand(new DriveWithController(drive, oi.GetDriverControl()));
    }
}
