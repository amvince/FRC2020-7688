/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.colourWheel;

public class spinRetract extends CommandBase {
  /**
   * Creates a new spinRetract.
   */
  private final colourWheel m_wheel;
  public spinRetract(colourWheel wheel) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_wheel = wheel;
    addRequirements(wheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_wheel.retract();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_wheel.stop();
    CommandScheduler.getInstance().cancelAll();
    
  }
  

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
