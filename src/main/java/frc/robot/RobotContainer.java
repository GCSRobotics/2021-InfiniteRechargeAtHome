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
    // Drive Subsystem
    public static DriveSub drive = new DriveSub();
    // Intake Subsystem
    public static IntakeSub intake = new IntakeSub();
    // Index Subsystem
    public static IndexSub indexer = new IndexSub();
    // Shooter Subsystems
    public static ShooterSub shooter = new ShooterSub();
    //Climber Subsystem
    public static ClimberSub Climber = new ClimberSub();
    // Operator Interface
    private static OI oi = new OI();

    public RobotContainer() {
        
    }

    // Teleop Command
    public void setTeleopDefaultCommands() {
        drive.setDefaultCommand(new DriveWithController(drive, oi.GetDriverControl()));
    }

    // Autonomous Commands
    public static Command GetAutonomousCommand() {
        double WaitTime = 0.1;
        double StraightSpeed = 0.75;
        double TurnSpeed = 0.7;

        // return new AutonomousDistance(drive);

        // return new SequentialCommandGroup(
        //     new DriveDistance(StraightSpeed, 150, drive),
        //     new WaitCommand(WaitTime), 
        //     new FindPowerCellA(drive));

        // return new SequentialCommandGroup(
        //     new DriveDistance(StraightSpeed, 162, drive),
        //     new WaitCommand(WaitTime), 
        //     new TurnDegreesGyro(TurnSpeed, -90, drive),
        //     new WaitCommand(WaitTime), 
        //     new FindPowerCellB(drive));

        // return new BarrelRacing(drive);

         //return new BouncePath(drive);

        //return new SlalomPath(drive);

        return new AutonomousDistance(drive);

    }
}
