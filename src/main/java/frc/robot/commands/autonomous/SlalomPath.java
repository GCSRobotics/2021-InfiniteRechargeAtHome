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
  private static final double _WAITTIME = 0.25;
  private static final double StraightSpeed = 0.4;
  private static final double TurnSpeed = 0.5;
  private DriveSub driveTrain;

  public SlalomPath(DriveSub drivetrain) {
    driveTrain = drivetrain;
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new DriveDistance(StraightSpeed, 35, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, -60, drivetrain).andThen(new WaitCommand(_WAITTIME)), 
      new DriveDistance(StraightSpeed, 85, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, 0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 112, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, 45, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 105, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, 0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 18, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed, -90, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, 87, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed,  -50, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -116, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed,  0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -130, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed,  55, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -80, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new TurnDegreesGyro(TurnSpeed,  0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
      new DriveDistance(StraightSpeed, -34, drivetrain).andThen(new WaitCommand(_WAITTIME))
  
      );
  }

  @Override
  public void initialize() {
    // TODO Auto-generated method stub
    super.initialize();
   // driveTrain.ResetRobot();

  
  }
}
