package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.autonomous.AutonomousDistance;
import frc.robot.commands.autonomous.BarrelRacing;
import frc.robot.commands.autonomous.BouncePath;
import frc.robot.commands.autonomous.SlalomPath;
import frc.robot.commands.autonomous.searcha.FindPowerCellA;
import frc.robot.commands.autonomous.searchb.FindPowerCellB;
import frc.robot.commands.driveSub.DriveDistance;
import frc.robot.commands.driveSub.DriveWithController;
import frc.robot.commands.driveSub.TurnDegreesGyro;
import frc.robot.subsystems.*;

public class RobotContainer {
    //Drive Subsystem
    public static DriveSub drive = new DriveSub();
    //Intake Subsystem
    public static IntakeSub intake = new IntakeSub();
    //Index Subsystem
    public static IndexSub indexer = new IndexSub();
    //Shooter Subsystems
    public static ShooterSub shooter = new ShooterSub();
    //Operator Interface
    private static OI oi = new OI();

    public RobotContainer() {
        // Configure the smart dashboard
        SmartDashboard.putString("Autonomous Routine", Constants.AutoRoutines.AutonomousDistance);
        SmartDashboard.putString("Autonomous Routine", Constants.AutoRoutines.GalaticSearch_PathA);
        SmartDashboard.putString("Autonomous Routine", Constants.AutoRoutines.GalaticSearch_PathB);
        SmartDashboard.putString("Autonomous Routine", Constants.AutoRoutines.BarrelRacing);
        SmartDashboard.putString("Autonomous Routine", Constants.AutoRoutines.BouncePath);
        SmartDashboard.putString("Autonomous Routine", Constants.AutoRoutines.SlalomPath);
    }

    //Teleop Command
    public void setTeleopDefaultCommands() {
        drive.setDefaultCommand(new DriveWithController(drive, oi.GetDriverControl()));
    }

    //Autonomous Commands
	public static Command GetAutonomousCommand() {
        // Get the auto routine setting from the dashboard.
        String autoRoutine = SmartDashboard.getString("Autonomous Routine", Constants.AutoRoutines.AutonomousDistance);

        double WaitTime = 0.1;
        double StraightSpeed = 0.75;
        double TurnSpeed = 0.7;
        Command autoCommand;
        switch (autoRoutine) {
            case Constants.AutoRoutines.AutonomousDistance:
                autoCommand = new AutonomousDistance(drive);
                break;
            case Constants.AutoRoutines.GalaticSearch_PathA:
                //Drive to a specific location then find the powercell 
                //  then drive path based on where powercell is
                autoCommand = new SequentialCommandGroup(
                    new DriveDistance(StraightSpeed, 150, drive),
                    new WaitCommand(WaitTime), 
                    new FindPowerCellA(drive)
                );
                break;
            case Constants.AutoRoutines.GalaticSearch_PathB:
                //Drive to a specific location then find the powercell 
                //  then drive path based on where powercell is
                autoCommand = new SequentialCommandGroup(
                    new DriveDistance(StraightSpeed, 162, drive),
                    new WaitCommand(WaitTime),
                    new TurnDegreesGyro(TurnSpeed, -90, drive),
                    new WaitCommand(WaitTime), 
                    new FindPowerCellB(drive)
                );
                break;
            case Constants.AutoRoutines.BarrelRacing:
                autoCommand = new BarrelRacing(drive);
                break;
            case Constants.AutoRoutines.BouncePath:
                autoCommand = new BouncePath(drive);
                break;
            case Constants.AutoRoutines.SlalomPath:
                autoCommand = new SlalomPath(drive);
                break;
            default:
                autoCommand = new AutonomousDistance(drive);
                break;
        }
        return autoCommand;	
    }
}
