// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous.searchb;

import org.photonvision.PhotonCamera;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSub;

public class FindPowerCellB extends CommandBase {
    PhotonCamera camera = new PhotonCamera(Constants.VisionCamera_Powercell);
    DriveSub Drivetrain;
    boolean TargetsFound = false;

    /** Creates a new FindPowerCellA. */
    public FindPowerCellB(DriveSub drivetrain) {
        Drivetrain = drivetrain;
        addRequirements(Drivetrain);
        // Use addRequirements() here to declare subsystem dependencies.
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        camera.setPipelineIndex(Constants.VisionPipeline_Powercell);

    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        var result = camera.getLatestResult();
        if (result.hasTargets()) {
            TargetsFound = true;
            double yaw = result.getBestTarget().getYaw();
            if (yaw < 0) {
                CommandScheduler.getInstance().schedule(new RedRouteB(Drivetrain));
            } else {
                CommandScheduler.getInstance().schedule(new BlueRouteB(Drivetrain));
            }
        } else {
            // Do something when no powercell is found
            TargetsFound = true;
        }
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return TargetsFound;
    }
}
