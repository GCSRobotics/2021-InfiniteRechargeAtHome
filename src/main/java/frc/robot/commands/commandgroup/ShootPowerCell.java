/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.commandgroup;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class ShootPowerCell extends CommandBase {
  private IndexSub indexSub;
  private ShooterSub shooterSub;

  public ShootPowerCell(ShooterSub shooter, IndexSub index) {
    shooterSub = shooter;
    indexSub = index;
    addRequirements(indexSub);
    addRequirements(shooterSub);
  }
 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSub.runShooter();
    indexSub.indexBall();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSub.stopShooter();
    indexSub.stopIndex();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}