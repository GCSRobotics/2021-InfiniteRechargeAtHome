// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.driveSub;

import frc.robot.subsystems.DriveSub;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpiutil.math.MathUtil;

public class TurnDegreesGyro extends CommandBase {
  private final DriveSub m_Drive;
  private final double m_Degrees;
  private final double m_Speed;
  private final PIDController m_pidController = new PIDController(0.4, 0, 0.053);

  /**
   * Creates a new TurnDegrees. This command will turn your robot for a desired rotation (in
   * degrees) and rotational speed.
   *
   * @param speed The speed which the robot will drive. Negative is in reverse.
   * @param degrees Degrees to turn. Leverages gyro to compare distance.
   * @param drive The drive subsystem on which this command will run
   */
  public TurnDegreesGyro(double speed, double degrees, DriveSub drive) {
    m_Degrees = degrees;
    m_Speed = speed;
    m_Drive = drive;
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Set motors to stop, read encoder values for starting point
    //m_Drive.arcadeDrive(0, 0);
    m_pidController.setSetpoint(m_Degrees);
    m_Drive.reset();
   m_pidController.setTolerance(0.25); 


  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    double output = m_pidController.calculate(m_Drive.getGyroAngle());
    double outputC = MathUtil.clamp(output, -m_Speed, m_Speed);

    
    // if(outputC < 0.1)
    // {
    //   outputC = 0.1;
    // }
    m_Drive.arcadeDrive(0, outputC);

    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_Drive.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

   // double gyroAngle = m_Drive.getGyroAngle();
    //return gyroAngle >= m_Degrees;

    return m_pidController.atSetpoint();

  }
    
}
  
