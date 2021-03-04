// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.groupcommands.ShootPowerCell;
import frc.robot.commands.driveSub.DriveDistance;
import frc.robot.commands.driveSub.TurnDegreesGyro;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.IndexSub;
import frc.robot.subsystems.ShooterSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SlalomPath2 extends SequentialCommandGroup {
  /** Creates a new SlalomPath. */
  private static final double _WAITTIME = 0.1;
  private static final double StraightSpeed = 0.35;
  private static final double TurnSpeed = 0.4;

  /** Creates a new SlalomPath2. */
  public SlalomPath2(DriveSub drivetrain, ShooterSub shooterSub, IndexSub indexSub) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new DriveDistance(StraightSpeed, 40, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, -60, drivetrain).andThen(new WaitCommand(_WAITTIME)), 
      new DriveDistance(StraightSpeed, 85, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, 0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 106, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, 20, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new ShootPowerCell(shooterSub, indexSub, 10.0).withTimeout(3),
      new TurnDegreesGyro(TurnSpeed, 50, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 104, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      // new TurnDegreesGyro(TurnSpeed, 0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      // new DriveDistance(StraightSpeed, 16, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, -90, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 93, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed,  -50, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -126, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed,  0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -104,drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed,  55, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -68, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed,  0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -34, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 1, drivetrain).andThen(new WaitCommand(_WAITTIME))
  
      );
  }
}
