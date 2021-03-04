/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.indexSub.RunIndex;
import frc.robot.commands.intakeSub.*;
import frc.robot.commands.shooterSub.RunShooter;
import frc.robot.controllers.BaseController;
import frc.robot.controllers.ControllerType;

/**
 * Add your docs here.
 */
public class OI {
    private BaseController DriverControl;
    private BaseController OperatorControl;
  
    public OI() {
      ControllerInit(ControllerType.XBox, ControllerType.XBox);
    }
  
    public OI(ControllerType driveType, ControllerType operatorType) {
      ControllerInit(driveType, operatorType);
    }
  
    private void ControllerInit(ControllerType driveCtrlType, ControllerType operateCtrlType) {
      DriverControl = BaseController.CreateInstance(driveCtrlType, Constants.DriveJoystick);
      OperatorControl = BaseController.CreateInstance(operateCtrlType, Constants.OperatorJoystick);
      ButtonActionInit();
    }
  
    private void ButtonActionInit() {
      // Driver buttons.
      // DriverControl.ButtonY.whileHeld(new OpenClimber(RobotContainer.Climber));
      // DriverControl.ButtonX.whileHeld(new Climb(RobotContainer.Climber));
      DriverControl.ButtonY.whenPressed(new ExtendIntake(RobotContainer.intake));
      DriverControl.ButtonA.whenPressed(new RetractIntake(RobotContainer.intake));
      DriverControl.ButtonX.whileHeld(new RunIndex(RobotContainer.indexer));

      //DriverControl.ButtonB.whileHeld(new AdjustShooter(RobotContainer.shooter));

      DriverControl.ButtonL1.whileHeld(new RunShooter(RobotContainer.shooter));
      DriverControl.ButtonR1.whileHeld(new RunIntake(RobotContainer.intake));

//      DriverControl.ButtonR2.whileHeld(new ReverseIntake(RobotContainer.intake));

      // Operator buttons.
      // OperatorControl.ButtonA.whileHeld(new AutoCenterStart(RobotContainer.Drive, 120, RobotContainer.ShooterLeft, RobotContainer.ShooterRight, RobotContainer.Indexer));
      // OperatorControl.ButtonY.whileHeld(new StartShooter(RobotContainer.Shooter));
      // OperatorControl.ButtonR1.whileHeld(new RunIntake(RobotContainer.intake));
      // OperatorControl.ButtonL1.whileHeld(new ReverseIntake(RobotContainer.intake));
      // OperatorControl.ButtonB.whileHeld(new RunIndex(RobotContainer.Indexer));
      // OperatorControl.ButtonX.whileHeld(new ReverseIndex(RobotContainer.Indexer));
      // OperatorControl.ButtonX.whenPressed(new DriveStraight(RobotContainer.Drive, 120.0));
    }

    public BaseController GetDriverControl() {
      return DriverControl;
    }
  
    public BaseController GetOperatorControl() {
      return OperatorControl;

    }
  }
    
  
  
  
  