/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants;




public class Drivetrain extends SubsystemBase 
{
  /**
   * Creates a new Drivetrain.
   */

  private final WPI_VictorSPX l_b_Speedcontroller;
  private final WPI_VictorSPX l_f_SpeedController;
  private final SpeedControllerGroup l_ControllerGroup;
  
  private final WPI_VictorSPX r_b_SpeedController;
  private final WPI_VictorSPX r_f_SpeedController;
  private final SpeedControllerGroup r_ControllerGroup;

  private final DifferentialDrive m_Drive;

  public Drivetrain() 
  {
    l_b_Speedcontroller = new WPI_VictorSPX(Constants.DT_MOTOR_L_B_PORT);
    l_f_SpeedController = new WPI_VictorSPX(Constants.DT_MOTOR_L_F_PORT);
    l_ControllerGroup = new SpeedControllerGroup(l_b_Speedcontroller, l_f_SpeedController);


    r_b_SpeedController = new WPI_VictorSPX(Constants.DT_MOTOR_R_B_PORT);
    r_f_SpeedController = new WPI_VictorSPX(Constants.DT_MOTOR_R_F_PORT);
    r_ControllerGroup = new SpeedControllerGroup(r_b_SpeedController, r_f_SpeedController);

    m_Drive = new DifferentialDrive(l_ControllerGroup, r_ControllerGroup);
  }


  public void DT_ArcadeDrive(double i_Speed, double i_Rotation)
  {
    m_Drive.arcadeDrive(i_Speed * Constants.DT_SPEED_MULTIPLIER * -1, // * -1 because Y Axis is inverted by default
                        i_Rotation * Constants.DT_ROTATION_MULTIPLIER);
  }

  public void DT_Stop()
  {
    m_Drive.arcadeDrive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
