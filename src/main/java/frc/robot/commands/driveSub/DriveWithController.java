package frc.robot.commands.driveSub;

import frc.robot.controllers.BaseController;
import frc.robot.subsystems.DriveSub;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * An example command that uses an example subsystem.
 */
public class DriveWithController extends CommandBase {
  private final DriveSub driveSub;
  private final BaseController driveController;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveWithController(DriveSub subsystem, BaseController controller) {
    driveSub = subsystem;
    driveController = controller;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSub.arcadeDrive(driveController.GetAxis_LeftY(), driveController.GetAxis_RightX());;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

