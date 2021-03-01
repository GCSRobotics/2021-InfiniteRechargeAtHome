// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.driveSub;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.subsystems.DriveSub;

public class DriveDistance extends CommandBase {
  private final DriveSub m_drive;
  private final double m_distance;
  private final double m_speed;
  private final PIDController m_pidController = new PIDController(3.5, 0, 0.0008);

  /**
   * Creates a new DriveDistance. This command will drive your your robot for a
   * desired distance at a desired speed.
   *
   * @param speed  The speed at which the robot will drive
   * @param inches The number of inches the robot will drive
   * @param drive  The drivetrain subsystem on which this command will run
   */
  public DriveDistance(double speed, double inches, DriveSub drive) {
    m_distance = inches;
    m_speed = speed;
    m_drive = drive;
    addRequirements(drive);
    SmartDashboard.putNumber("Setpoint", m_distance);
    SmartDashboard.putNumber("Kp", m_pidController.getP());
    SmartDashboard.putNumber("Kd", m_pidController.getD());
  }

  // Called once when the scheduler loads the command.
  @Override
  public void initialize() {
    m_drive.arcadeDrive(0, 0);
    m_drive.resetEncoders();

    // Add a tolerence to the PID loop to allow the "atSetpoint()" method to
    // function within a range of values. Read the 'Specifying and Checking
    // Tolerance' section on this page for more details //
    // https://docs.wpilib.org/en/stable/docs/software/advanced-controls/controllers/pidcontroller.html
    m_pidController.setTolerance(1.5, 3);
    SmartDashboard.putNumber("Setpoint", m_distance);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Drive Straight Running");
    SmartDashboard.putNumber("Current Position ", m_drive.getAverageDistanceInch());
    SmartDashboard.putNumber("Current Left Position ", m_drive.getLeftDistanceInch());
    SmartDashboard.putNumber("Current Right Position ", m_drive.getRightDistanceInch());

    // Use the MathUtil.Clamp() function to ensure the that motor speed (i.e.
    // 'output' below) variable never goes outside the +/- range of the m_Speed
    // variable passed into the command.
    // (-m_Speed <= output <= m_Speed). See the "Clamping Controller Output" section
    // of the following page
    // https://docs.wpilib.org/en/stable/docs/software/advanced-controls/controllers/pidcontroller.html
    double output = m_pidController.calculate(m_drive.getAverageDistanceInch(), m_distance);
    double outputC = MathUtil.clamp(output, -m_speed, m_speed);
    SmartDashboard.putNumber("PID Output Clamping", outputC);
    SmartDashboard.putNumber("PID Output", output);
    m_drive.tankDrive(outputC, outputC);

  }

  @Override
  public void end(boolean interrupted) {
    m_drive.arcadeDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    // Compare distance travelled from start to desired distance
    SmartDashboard.putBoolean("Drive Staight is finished", m_pidController.atSetpoint());
    return m_pidController.atSetpoint();// Math.abs(m_drive.getAverageDistanceInch()) >= m_distance*2;
  }
}
