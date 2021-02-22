package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.autonomous.AutonomousDistance;
import frc.robot.commands.driveSub.DriveWithController;
import frc.robot.subsystems.*;

public class RobotContainer {
    //Drive Subsystem
    public static DriveSub drive = new DriveSub();

    //Intake Subsystem
    public static IntakeSub intake = new IntakeSub();
    public Compressor compressor = new Compressor(1);

    //Index Subsystem
    public static IndexSub indexer = new IndexSub();

    //Shooter Subsystems
    public static ShooterSub shooter = new ShooterSub();

    //Operator Interface
    private static OI oi = new OI();

    //Teleop Command
    public void setTeleopDefaultCommands() {
        drive.setDefaultCommand(new DriveWithController(drive, oi.GetDriverControl()));
    }

    //Autonomous Commands
	public static Command GetAutonomousCommand() {
		return new AutonomousDistance(drive);
	}
}
