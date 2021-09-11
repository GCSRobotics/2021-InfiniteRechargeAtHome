package frc.robot.commands.driveSub;

import frc.robot.controllers.BaseController;
import frc.robot.subsystems.DriveSub;

import org.photonvision.PhotonCamera;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.controller.PIDController;

import java.text.MessageFormat;

/**
 * An example command that uses an example subsystem.
 */
public class DriveWithController extends CommandBase {
  private final DriveSub driveSub;
  private final BaseController driveController;

  PhotonCamera camera = new PhotonCamera(Constants.VisionCamera_HexTarget);

  PIDController controller = new PIDController(.175, 0, 0.015);

  double m_speed;

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

    // Pipelines are fully configured using the PhotonVision web page (i.e
    // http://10.19.47.92:5800)
    camera.setPipelineIndex(Constants.VisionPipeline_HexTarget);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double forwardSpeed = driveController.GetAxis_LeftY();
   
    double d = 0.70;
    double speedMultiplier = d;
    double rotMultiplier = d;

   
    double rotationSpeed;

    if (driveController.ButtonA.get()) {
      // Automatic Vision Alignment mode
      // System.out.println("A Button Pressed");
      // Query the latest pipeline results from PhotonVision and see if any targets
      // are found
      var result = camera.getLatestResult();
      if (result.hasTargets()) {
        // System.out.println("Has Targets");
        // Rotation speed for the robot is the output of the PID controller using the
        // vision target's yaw as the current position
        // and comparing that to the center point of the robot (Setpoint = 0);
        double yaw = result.getBestTarget().getYaw();

        // Don't let the the maximum output speed of the rotation to be greater than a
        // value passed into the command
        // NOTE: This will require you to add a class property and modify the
        // Constructor found above to accept a
        // max speed parameter. This will be a decimal value (defined as a double). Then
        // in the line below this comment
        // you will use the MathUtil utility class and its clamp() method to cap the
        // rotation speed to be no greater than
        // the max rotation speed class property.
        // For more details and an example read the "Clamping Controller Output" section
        // at the end of this page:
        // https://docs.wpilib.org/en/stable/docs/software/advanced-controls/controllers/pidcontroller.html

        double output = controller.calculate(yaw, 0);
        rotationSpeed = -MathUtil.clamp(output, -m_speed, m_speed);
        
        // rotationSpeed = controller.calculate(result.getBestTarget().getYaw(), 0);
        System.out.println(MessageFormat.format("Yaw: {1}, Rotation Speed {0}", rotationSpeed, yaw));
      } else {
        // If we have no targets, stay still.
        rotationSpeed = 0;
      }
    } else {
      // Manual Driver Mode
      rotationSpeed = driveController.GetAxis_RightX();
    }

    // driveSub.tankDrive(driveController.GetAxis_LeftY() * -.60, driveController.GetAxis_RightY() * -.60);
    if (driveController.ButtonL1.get()) {
      speedMultiplier = 1.0;
    }
    driveSub.arcadeDrive(-forwardSpeed * speedMultiplier , rotationSpeed * rotMultiplier);
    ;
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
