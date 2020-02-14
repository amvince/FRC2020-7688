/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.kauailabs.navx.frc.AHRS;

public class Gyro extends SubsystemBase {
  /**
   * Creates a new Gyro.
   */
  private static AHRS m_ahrs = new AHRS(I2C.Port.kOnboard);

  public float pitch = m_ahrs.getPitch();
  public float roll = m_ahrs.getRoll();
  public float yaw = m_ahrs.getYaw();
  public double angle = m_ahrs.getAngle();

  public Gyro() {

  }

  public void Update() {
    pitch = m_ahrs.getPitch();
    roll = m_ahrs.getRoll();
    yaw = m_ahrs.getYaw();
    angle = m_ahrs.getAngle() % 360;
  }

  public void Print() {
    System.out.println("Pitch: " + pitch);
    System.out.println("Roll: " + roll);
    System.out.println("Yaw: " + yaw);
    System.out.println("Angle: " + angle);
  }

  public void resetYaw() {
    m_ahrs.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
