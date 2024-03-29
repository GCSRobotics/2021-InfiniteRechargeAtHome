// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import frc.robot.commands.driveSub.DriveDistance;
import frc.robot.commands.driveSub.TurnDegreesGyro;
import frc.robot.subsystems.DriveSub;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class AutonomousDistance extends SequentialCommandGroup {

  DriveSub m_drive;

  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a
   * specified distance, turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutonomousDistance(DriveSub drivetrain) {
    m_drive = drivetrain;

    double driveSpeed = 0.40;
    double turnSpeed = 0.45;

    double waitTime = 0.2;
    addCommands(
       // new DriveDistance(driveSpeed, 36, drivetrain).andThen(new WaitCommand(waitTime))
   // new TurnDegreesGyro(turnSpeed, 180, drivetrain).andThen(new WaitCommand(waitTime))
    // new DriveDistance(driveSpeed, -40, drivetrain).andThen(new WaitCommand(waitTime))
    
    // new DriveDistance(driveSpeed, 40, drivetrain).andThen(new WaitCommand(waitTime))
    // new TurnDegreesGyro(turnSpeed, 180, drivetrain).andThen(new WaitCommand(waitTime))
    // new DriveDistance(driveSpeed, 40, drivetrain)
    

     new DriveDistance(driveSpeed, -20, drivetrain)
    // new TurnDegreesGyro(turnSpeed, -90, drivetrain).andThen(new WaitCommand(waitTime)),
    // new DriveDistance(driveSpeed, 40, drivetrain).andThen(new WaitCommand(waitTime)),
    // new TurnDegreesGyro(turnSpeed, -180, drivetrain).andThen(new WaitCommand(waitTime)),
    // new DriveDistance(driveSpeed, 48, drivetrain).andThen(new WaitCommand(waitTime)),
    // new TurnDegreesGyro(turnSpeed, -270, drivetrain).andThen(new WaitCommand(waitTime)),
    // new DriveDistance(driveSpeed, 40, drivetrain).andThen(new WaitCommand(waitTime)),
    // new TurnDegreesGyro(turnSpeed, -360, drivetrain)
     

    );
  }
}
