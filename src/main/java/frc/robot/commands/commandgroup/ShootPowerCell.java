// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.commandgroup;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.indexSub.RunIndex;
import frc.robot.commands.shooterSub.RunShooter;
import frc.robot.subsystems.IndexSub;
import frc.robot.subsystems.ShooterSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ShootPowerCell extends SequentialCommandGroup {
  /** Creates a new ShootPowerCell. */
  public ShootPowerCell(ShooterSub shooter, IndexSub indexer) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new RunShooter(shooter).withTimeout(.7),
      new RunIndex(indexer).withTimeout(3)
    );
  }
}
