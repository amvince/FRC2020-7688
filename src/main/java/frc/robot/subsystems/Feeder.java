/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import frc.robot.subsystems._PneumaticsClass;

public class Feeder extends SubsystemBase {
  
  private final WPI_VictorSPX m1_Talon;
  private final WPI_VictorSPX m2_Talon;

  private final SpeedControllerGroup m_FeedControl_Motors;

  private final _PneumaticsClass m_pneumatics = new _PneumaticsClass();

  public Feeder() 
  {
    m1_Talon = new WPI_VictorSPX(Constants.FD_MOTOR_1_PORT);
    m2_Talon = new WPI_VictorSPX(Constants.FD_MOTOR_2_PORT);

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

  public void RaiseTruck()
  {
    m_pneumatics.Arm_Solenoid_Extend();
  }

  public void LowerTruck()
  {
    m_pneumatics.Arm_Solenoid_Retract();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
