// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooterSub;

import java.util.Date;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSub;

public class AdjustShooter extends CommandBase {
  private final ShooterSub shooter;
  private Date startTime;
  private boolean complete;
  private double timeToRun;

  /** Creates a new AdjustShooter. */
  public AdjustShooter(ShooterSub subsystem, double time) {
    shooter = subsystem;
    timeToRun = time;    
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = new Date();
    complete = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooter.adjustShooter(.3);
    if ((new Date()).getTime() - startTime.getTime() > timeToRun) {
        complete = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooter.adjustShooter(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return complete;
  }
}
