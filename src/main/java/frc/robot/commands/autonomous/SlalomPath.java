// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.driveSub.DriveDistance;
import frc.robot.commands.driveSub.TurnDegreesGyro;
import frc.robot.subsystems.DriveSub;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SlalomPath extends SequentialCommandGroup {
  /** Creates a new SlalomPath. */
  private static final double _WAITTIME = 0.2;
  private static final double StraightSpeed = 0.4;
  private static final double TurnSpeed = 0.45;

  public SlalomPath(DriveSub drivetrain) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new DriveDistance(StraightSpeed, 40, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, -58, drivetrain).andThen(new WaitCommand(_WAITTIME)), 
      new DriveDistance(StraightSpeed, 82, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, 0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 116, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, 53, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 104, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, 0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 23, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, -90, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 92, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed,  -51, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -126, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed,  0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -122,drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed,  55, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -68, drivetrain).andThen(new WaitCommand(_WAITTIME))
      
  
      );
  }

}
