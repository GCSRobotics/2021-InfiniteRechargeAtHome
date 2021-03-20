// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import frc.robot.commands.driveSub.DriveDistance;
import frc.robot.commands.driveSub.TurnDegreesGyro;
import frc.robot.subsystems.DriveSub;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;


// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BouncePath extends SequentialCommandGroup {

  private final DriveSub m_drive;

  private static final double _WAITTIME = 0.2;
  private static final double StraightSpeed = 0.4;
  private static final double TurnSpeed = 0.4;


  /** Creates a new BouncePath. */
  public BouncePath(DriveSub drivetrain) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    m_drive = drivetrain;
  
    addCommands(
      new DriveDistance(StraightSpeed, 28, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      //new DriveDistance(0.5, -30, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      //Turn toward first marker
      new TurnDegreesGyro(TurnSpeed, -75, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 44, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      // Turn and hit marker
      new TurnDegreesGyro(TurnSpeed, -123, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -168, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      //Turn toward second marker
      new TurnDegreesGyro(TurnSpeed, -80, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 139, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      //Turn and hit second marker
      //new TurnDegreesGyro(0.5, -123, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, -90, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      //back
      new DriveDistance(StraightSpeed, -118, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, 0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      //drive forward
      new DriveDistance(StraightSpeed, 90, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, -90, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      //hit the third marker
      new DriveDistance(StraightSpeed, 115, drivetrain).andThen(new WaitCommand(_WAITTIME)), 
      new TurnDegreesGyro(TurnSpeed, -140, drivetrain).andThen(new WaitCommand(_WAITTIME)),

      new DriveDistance(StraightSpeed, -80, drivetrain),
      new TurnDegreesGyro(TurnSpeed, -180, drivetrain).andThen(new WaitCommand(_WAITTIME))

    );
  }

}
