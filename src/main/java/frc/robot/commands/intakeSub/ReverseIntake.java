package frc.robot.commands.intakeSub;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSub;

public class ReverseIntake extends CommandBase {
    private final IntakeSub intakeSub;

    /**
     * Creates a new RunIntake.
      */
    public ReverseIntake(IntakeSub subsystem ) {
      intakeSub = subsystem;
  
      // Use addRequirements() here to declare subsystem dependencies.
    }
  
    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }
  
    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
      intakeSub.reverseIntake();
    }
  
    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
      intakeSub.stopIntake();
    }
  
    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
      return false;
    }
  
}
