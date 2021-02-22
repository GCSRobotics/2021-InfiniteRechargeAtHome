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

    addCommands(new DriveDistance(0.5, 60, drivetrain).andThen(new WaitCommand(0.25))
    // new DriveDistance(0.5, -30, drivetrain).andThen(new WaitCommand(0.25))
    // new TurnDegreesEncoder(0.6, 180, drivetrain).andThen(new WaitCommand(0.25)),
    // new DriveDistance(0.5, 30, drivetrain).andThen(new WaitCommand(0.25))
    // new TurnDegreesGyro(0.5, 180, drivetrain).andThen(new WaitCommand(0.25))
    // new DriveDistance(0.5, 30, drivetrain)
    );
  }

  @Override
  public void initialize() {
    m_drive.reset();
  }

}