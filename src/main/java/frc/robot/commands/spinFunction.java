/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.colourWheel;

public class spinFunction extends CommandBase {
  /**
   * Creates a new spinFunction.
   */
  private final colourWheel m_wheel;
  private final NetworkTableInstance inst = NetworkTableInstance.getDefault();
  private final NetworkTable table = inst.getTable("SmartDashboard");
  
  public spinFunction(colourWheel wheel) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_wheel = wheel;
    addRequirements(wheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Read network table for wheel
    // conditional command based on network table command.
    String cmd = table.getEntry("wheel_function").getString("default");
    //String cmd = SmartDashboard.getString("wheel_function","spin");
  
    System.out.println(table.getKeys());
    System.out.println(table.getEntry("wheel_function"));
    System.out.println(cmd);
    switch(cmd) {
      case "red":
        new FindColour(m_wheel, "Red").schedule();
        break;
      case "blue":
        new FindColour(m_wheel, "Blue").schedule();
        break;
      case "green":
        new FindColour(m_wheel, "Green").schedule();
        break;
      case "yellow":
        new FindColour(m_wheel, "Yellow").schedule();
        break;
      case "spin":
      default:
        new spinCounter(m_wheel).schedule();
        System.out.println("Starting Spin");
        break;
    }

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
