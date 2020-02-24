/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorSensorV3;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class colourWheel extends SubsystemBase {
  /**
   * Creates a new colourWheel.
   */
  private final Talon wheel = new Talon(Constants.CW_WHEEL);
  private final DoubleSolenoid ds = new DoubleSolenoid(Constants.PN_COLOURWHEEL_DOUBlESOLENOID_F,
      Constants.PN_COLOURWHEEL_DOUBLESOLENOID_R);
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private Color detectedColor;
  public String motorState="Stopped";
  private final ColorMatch m_colorMatcher = new ColorMatch();
  private final Color kBlueTarget = Constants.kBLUE;
  private final Color kGreenTarget = Constants.kGREEN;
  private final Color kRedTarget = Constants.kRED;
  private final Color kYellowTarget = Constants.kYELLOW;
  private ColorMatchResult match;

  private final NetworkTableInstance inst = NetworkTableInstance.getDefault();
  private final NetworkTable table = inst.getTable("SmartDashboard");


  public colourWheel() {
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);
  }

  public void clockwise() {
    wheel.set(0.3);
    motorState = "Clockwise";
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    this.detectedColor = m_colorSensor.getColor();
    table.getEntry("wheel_colour").setString(colourMatch());
  }
  public void stop() {
    wheel.set(0);
    motorState = "Stopped";
  }

  public void deploy() {
    table.getEntry("wheel_deployed").setBoolean(true);
    ds.set(DoubleSolenoid.Value.kForward);
    
  }
  public void retract() {
    table.getEntry("wheel_deployed").setBoolean(false);
    ds.set(DoubleSolenoid.Value.kReverse);
  }

  public double confidence() {
    final ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
    return match.confidence;
  }

  public boolean confident() {
    return (this.confidence()>0.90);
  }
  public String colourMatch() {
    String colourString;
    detectedColor = m_colorSensor.getColor();
    match = m_colorMatcher.matchClosestColor(detectedColor);
    if (match.color == kBlueTarget) {
      colourString = "Blue";
    } else if (match.color == kRedTarget) {
      colourString = "Red";
    } else if (match.color == kGreenTarget) {
      colourString = "Green";
    } else if (match.color == kYellowTarget) {
      colourString = "Yellow";
    } else {
      colourString = "Unknown";
    }
    return colourString;
  }

}
