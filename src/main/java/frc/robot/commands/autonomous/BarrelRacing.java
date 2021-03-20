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
public class BarrelRacing extends SequentialCommandGroup {
  /** Creates a new BarrelRacing. */
  private static final double _WAITTIME = 0.1;
  private static final double StraightSpeed = 0.35;
  private static final double TurnSpeed = 0.4;

  private final DriveSub m_drive;
  
  public BarrelRacing(DriveSub drivetrain) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    m_drive = drivetrain;
    addCommands(
        new DriveDistance(StraightSpeed, 108, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new TurnDegreesGyro(TurnSpeed, 60, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new DriveDistance(StraightSpeed, 34, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new TurnDegreesGyro(TurnSpeed, 180, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new DriveDistance(StraightSpeed, 34, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new TurnDegreesGyro(TurnSpeed, 90, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new DriveDistance(StraightSpeed, 34, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new TurnDegreesGyro(TurnSpeed, 340, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new DriveDistance(StraightSpeed, 127, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new TurnDegreesGyro(TurnSpeed, 40, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new DriveDistance(StraightSpeed, -30, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new TurnDegreesGyro(TurnSpeed, 75, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new DriveDistance(StraightSpeed, 120, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new TurnDegreesGyro(TurnSpeed, 10, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new DriveDistance(StraightSpeed, 60, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new TurnDegreesGyro(TurnSpeed, -270, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new DriveDistance(StraightSpeed, 12, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new TurnDegreesGyro(TurnSpeed, -180, drivetrain).andThen(new WaitCommand(_WAITTIME)),
        new DriveDistance(StraightSpeed, 312, drivetrain).andThen(new WaitCommand(_WAITTIME))
        );
    }
  
    @Override
    public void initialize() {
      m_drive.reset();
    }
  }  




    
