// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.groupcommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.shooterSub.AdjustShooter;
import frc.robot.subsystems.IndexSub;
import frc.robot.subsystems.IntakeSub;
import frc.robot.subsystems.ShooterSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AdjustAndShoot extends SequentialCommandGroup {
  private double shooterSpeed;

  /** Creates a new AdjustAndShoot. */
  public AdjustAndShoot(ShooterSub shooter, IndexSub indexer, IntakeSub intake, String shootFrom) {
    shooterSpeed = 0.6;
    double tiltTime = 0;
    switch (shootFrom) {
      case "red":
          if (shooter.getArea() != shootFrom) {
            tiltTime = 80;
            shooter.setArea(shootFrom);
          }
        break;
      case "blue":
      if (shooter.getArea() != shootFrom) {
        tiltTime = 420;
        shooter.setArea(shootFrom);
      }
        break;
      case "yellow":
      if (shooter.getArea() != shootFrom) {
        tiltTime = 500;
        shooter.setArea(shootFrom);
      }
        break;
      case "green":
//           tiltTime = 1000;
        break;

      default:
        break;
    }
  // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new AdjustShooter(shooter, tiltTime),
      new ShootPowerCell(shooter, indexer, intake, shooterSpeed).withTimeout(5)
    );
  }
}
