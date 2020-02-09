/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Feeder extends SubsystemBase {
  
  private final WPI_TalonSRX m1_Talon;
  private final WPI_TalonSRX m2_Talon;

  private final SpeedControllerGroup m_FeedControl_Motors;

  public Feeder() 
  {
    m1_Talon = new WPI_TalonSRX(Constants.FD_MOTOR_1_PORT);
    m2_Talon = new WPI_TalonSRX(Constants.FD_MOTOR_2_PORT);

    m_FeedControl_Motors = new SpeedControllerGroup(m1_Talon, m2_Talon);
  }

  public void ArcadeDrive(double i_speed)
  {
    m_FeedControl_Motors.set(i_speed * Constants.FD_SPEED_MULTIPLIER);
  }

  public void Stop()
  {
    m_FeedControl_Motors.set(0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
