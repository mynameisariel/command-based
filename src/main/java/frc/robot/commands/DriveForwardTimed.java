// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveForwardTimedConstants;
import frc.robot.subsystems.DrivetrainSubsystem;

public class DriveForwardTimed extends CommandBase {
  private final DrivetrainSubsystem drivetrainSubsystem;
  private boolean finish = false;
  Timer timer;

  /** Creates a new DriveForwardTimed. */
  public DriveForwardTimed(DrivetrainSubsystem dt) {
    drivetrainSubsystem = dt;
    // this.drivetrainSubsystem = drivetrainSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrainSubsystem);

    // initializing timer inside constructor
    timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer.reset();
    timer.start();
    while (timer.get() < DriveForwardTimedConstants.driveForwardTime) {
      drivetrainSubsystem.driveForward(DriveForwardTimedConstants.autonomousSpeed, 0);
    }
    finish = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.stop(); // uses the stop method we created
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish; // will end when it returns true!
  }
}
