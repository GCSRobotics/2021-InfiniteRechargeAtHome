/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.indexSub.ReverseIndex;
import frc.robot.commands.indexSub.RunIndex;
import frc.robot.commands.intakeSub.*;
import frc.robot.commands.groupcommands.*;
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

      // Operator buttons.
      OperatorControl.ButtonA.whenPressed(new AdjustAndShoot(RobotContainer.shooter, RobotContainer.indexer, RobotContainer.intake, "green").withTimeout(5));
      OperatorControl.ButtonY.whenPressed(new AdjustAndShoot(RobotContainer.shooter, RobotContainer.indexer, RobotContainer.intake, "yellow").withTimeout(5));
      OperatorControl.ButtonX.whenPressed(new AdjustAndShoot(RobotContainer.shooter, RobotContainer.indexer, RobotContainer.intake, "blue").withTimeout(5));
      OperatorControl.ButtonB.whenPressed(new AdjustAndShoot(RobotContainer.shooter, RobotContainer.indexer, RobotContainer.intake, "red").withTimeout(5));
      OperatorControl.ButtonOptionL.whileHeld(new RunIndex(RobotContainer.indexer));
      OperatorControl.ButtonOptionR.whileHeld(new ReverseIndex(RobotContainer.indexer));
      // OperatorControl.ButtonA.whenPressed(new ShootPowerCell(RobotContainer.shooter, RobotContainer.indexer, RobotContainer.intake, -140, 0.6).withTimeout(5));
      // OperatorControl.ButtonY.whenPressed(new ShootPowerCell(RobotContainer.shooter, RobotContainer.indexer, RobotContainer.intake, -230, 0.6).withTimeout(5));
      // OperatorControl.ButtonX.whenPressed(new ShootPowerCell(RobotContainer.shooter, RobotContainer.indexer, RobotContainer.intake, -310, 0.6).withTimeout(5));
      // OperatorControl.ButtonB.whenPressed(new ShootPowerCell(RobotContainer.shooter, RobotContainer.indexer, RobotContainer.intake, -310, 0.6).withTimeout(5));
      OperatorControl.ButtonR1.whileHeld(new ReverseIntake(RobotContainer.intake));
      OperatorControl.ButtonL1.whileHeld(new RunIntake(RobotContainer.intake));
    }

    public BaseController GetDriverControl() {
      return DriverControl;
    }
  
    public BaseController GetOperatorControl() {
      return OperatorControl;
    }
  }
    
  
  
  
  