// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous.searcha;

import frc.robot.commands.driveSub.DriveDistance;
import frc.robot.commands.driveSub.TurnDegreesGyro;
import frc.robot.subsystems.DriveSub;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class RedRouteA extends SequentialCommandGroup {

    private static final double _WAITTIME = 0.1;
    private static final double StraightSpeed = 0.75;
    private static final double TurnSpeed = 0.7;

    /** Creates a new BouncePath. */
    public RedRouteA(DriveSub drivetrain) {
        // Add your commands in the addCommands() call, e.g.
        // addCommands(new FooCommand(), new BarCommand());

        addCommands(new TurnDegreesGyro(TurnSpeed, -90, drivetrain).andThen(new WaitCommand(_WAITTIME)),
                new DriveDistance(StraightSpeed, 30, drivetrain).andThen(new WaitCommand(_WAITTIME)),
                new TurnDegreesGyro(TurnSpeed, -117, drivetrain).andThen(new WaitCommand(_WAITTIME)),
                new DriveDistance(StraightSpeed, 67, drivetrain).andThen(new WaitCommand(_WAITTIME)),
                new TurnDegreesGyro(TurnSpeed, -34, drivetrain).andThen(new WaitCommand(_WAITTIME)),
                new DriveDistance(StraightSpeed, 110, drivetrain).andThen(new WaitCommand(_WAITTIME)),
                new TurnDegreesGyro(TurnSpeed, 0, drivetrain).andThen(new WaitCommand(_WAITTIME)),
                new DriveDistance(StraightSpeed, 192, drivetrain).andThen(new WaitCommand(_WAITTIME))
        );
    }
}
