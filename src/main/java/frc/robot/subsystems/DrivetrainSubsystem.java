// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

// Imports
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.JoystickConstants;

public class DrivetrainSubsystem extends SubsystemBase {

  // All the initializations happening
  CANSparkMax leftFrontMotor = new CANSparkMax(Constants.DriveTrainConstants.leftFrontCANID,
      CANSparkMaxLowLevel.MotorType.kBrushless); // The CANID numerical values are just taken from the "Constants" file
  CANSparkMax leftBackMotor = new CANSparkMax(Constants.DriveTrainConstants.leftBackCANID,
      CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightFrontMotor = new CANSparkMax(Constants.DriveTrainConstants.rightFrontCANID,
      CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightBackMotor = new CANSparkMax(Constants.DriveTrainConstants.rightBackCANID,
      CANSparkMaxLowLevel.MotorType.kBrushless);

  RelativeEncoder leftEncoder = leftFrontMotor.getEncoder();
  RelativeEncoder rightEncoder = rightFrontMotor.getEncoder();

  MotorControllerGroup leftControllerGroup = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
  MotorControllerGroup rightControllerGroup = new MotorControllerGroup(rightFrontMotor, rightBackMotor);

  DifferentialDrive differentialDrive = new DifferentialDrive(leftControllerGroup, rightControllerGroup); // Setting up
                                                                                                          // differential
                                                                                                          // drive

  /** Creates a new ExampleSubsystem. */
  public DrivetrainSubsystem() {
    // Constructor Class (has the same name as the subsystem) - this is where all
    // the commands to reset hardware would go - restoring factory defaults, setting
    // inversions, etc

    leftFrontMotor.restoreFactoryDefaults();
    leftBackMotor.restoreFactoryDefaults();
    rightFrontMotor.restoreFactoryDefaults();
    rightBackMotor.restoreFactoryDefaults();

    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);

    leftBackMotor.follow(leftFrontMotor); // Just combining left motors and right motors
    rightBackMotor.follow(rightFrontMotor);

    rightControllerGroup.setInverted(true);
    leftControllerGroup.setInverted(false);
  }

  // Descriptive action - takes two double variables (fwd and rot) as the
  // parameters, so the command knows that differential drive (arcadeDrive) will
  // need these two variables
  public void arcadeDrive(double fwd, double rot) {
    differentialDrive.arcadeDrive(fwd, rot);
  }

  // methods the substystem will be doing - lifecycle
  public void driveWithJoystickCommand(Joystick controller, double speed) {
    differentialDrive.arcadeDrive(controller.getRawAxis(JoystickConstants.joystickXAxis) * speed,
        controller.getRawAxis(JoystickConstants.joystickYAxis) * speed);
  }

  public void driveForward(double fwd, double rot) {
    differentialDrive.arcadeDrive(fwd, rot);
  }

  public void stop() {
    differentialDrive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

/**
 * @Override
 *           public void simulationPeriodic() {
 *           // This method will be called once per scheduler run during
 *           simulation
 *           }
 */