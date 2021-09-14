// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.driveSub.DriveDistance;
import frc.robot.commands.groupcommands.ShootPowerCell;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.IndexSub;
import frc.robot.subsystems.IntakeSub;
import frc.robot.subsystems.ShooterSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ShootandDrive extends SequentialCommandGroup {
  /** Creates a new BarrelRacing. */
  private static final double _WAITTIME = 0.1;
  private static final double StraightSpeed = 0.42;
  private static final double DriveDistance = -36.0;

  public ShootandDrive(DriveSub drivetrain, ShooterSub shooter, IndexSub index, IntakeSub intake) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ShootPowerCell(shooter, index, intake).withTimeout(5),
      new DriveDistance(StraightSpeed, DriveDistance, drivetrain).andThen(new WaitCommand(_WAITTIME))
    );
  }
}
