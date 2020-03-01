/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class AutonomousForward extends CommandBase {
  private final Drivetrain m_drivetrain;
  double m_desiredPercentVbus = 0.0;
	double m_startTime = 0.0;
  double m_desiredTime;
  
  /**
   * Creates a new AutonomousForward.
   */
  
  public AutonomousForward(Drivetrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_desiredTime = 2;
    m_drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_startTime = Timer.getFPGATimestamp();
    System.out.println("Start Time: "+m_startTime);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivetrain.DT_ArcadeDrive(-0.5, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.DT_Stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double elapsed_time = Timer.getFPGATimestamp() - m_startTime;
    System.out.println("Elapsed Time: "+elapsed_time);
    return (elapsed_time > m_desiredTime);
  }
}
