// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.shooterSub;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSub;


public class AdjustShooter extends CommandBase {
  private final ShooterSub m_ShooterSub; 
  /** Creates a new AdjustShooter. */
  public AdjustShooter(ShooterSub shooter) {
    m_ShooterSub = shooter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ShooterSub);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ShooterSub.adjustShooter();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ShooterSub.stopShooterAdjustment();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}