// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {

  CANSparkMax m_shooter = new CANSparkMax(ShooterConstants.m_shooterDevice, MotorType.kBrushless);

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {

    // Reset Shooter and Storage motors
    m_shooter.restoreFactoryDefaults();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // setting up the first needed method - shoot
  public void shootBall(double speed) {
    m_shooter.set(speed);
  }

  // next method needed is stop
  public void stopShooter() {
    m_shooter.stopMotor();
  }

}
