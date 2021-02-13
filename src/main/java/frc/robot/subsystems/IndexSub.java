package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IndexSub extends SubsystemBase {
    private static final WPI_VictorSPX indexMotor = new WPI_VictorSPX(Constants.IndexMotor);
    private final ColorSensorV3 colorSensor = new ColorSensorV3(Constants.i2cPort);
    private final ColorMatch colorMatcher = new ColorMatch();
    
    public IndexSub () {
        addChild("IndexMotor", indexMotor);
        colorMatcher.addColorMatch(Constants.YellowTarget);    
    }

    @Override
    public void periodic() {
        Color detectedColor = colorSensor.getColor();
        ColorMatchResult match = colorMatcher.matchColor(detectedColor);
        if(match != null){
            System.out.println("color: " + match.color);
        }
        if (match != null && match.color == Constants.YellowTarget) {
            indexBall();
        } else {
            stopIndex();
        }
  
    }
    
    //Index motor backward speed
    public void indexBall(){
        indexMotor.set(-.33);
    }
    
    //Index motor backward speed
    public void reverseIndex(){
        indexMotor.set(.3);
    }

    public void stopIndex(){
        indexMotor.set(0);
    }
}
