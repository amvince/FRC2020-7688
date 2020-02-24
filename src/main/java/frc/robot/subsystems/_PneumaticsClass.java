/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class _PneumaticsClass extends SubsystemBase {
  /**
   * Creates a new PneumaticsClass.
   */

  private static Compressor m_compressor = new Compressor(Constants.PN_COMPRESSOR_PORT);
  private static DoubleSolenoid m_feeder_double_solenoid = new DoubleSolenoid(Constants.PN_FEEDER_DOUBLESOLENOID_F, Constants.PN_FEEDER_DOUBLESOLENOID_B);

  public _PneumaticsClass() {

  }

  public void Arm_Solenoid_Extend()
  {
    m_feeder_double_solenoid.set(DoubleSolenoid.Value.kReverse);
  }

  public void Arm_Solenoid_Retract()
  {
    m_feeder_double_solenoid.set(DoubleSolenoid.Value.kForward);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
