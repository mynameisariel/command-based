// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.RobotContainer;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class DriveWithJoystickCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DrivetrainSubsystem drivetrainSubsystem; // creating a DrivetrainSubsystem called drivetrainsubsystem

  /**
   * @param subsystem The subsystem used by this command.
   */
  public DriveWithJoystickCommand(DrivetrainSubsystem drivetrainSubsystem) { // Making sure this commands uses the drivetrainsubsystem
    this.drivetrainSubsystem = drivetrainSubsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // Debug code
    System.out.println("Starting joystick drive command.");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Here is where the action of the command is coded - gets the two double variables needed and runs arcade drive 
    //double forwardSpeed = RobotContainer.joystick.getX();
    //double turningSpeed = RobotContainer.joystick.getY(); //gets the joystick from the robot container where the joystick is originally initialized
    drivetrainSubsystem.driveWithJoystickCommand(RobotContainer.joystick, 0.5);
    //drivetrainSubsystem.driveWithJoystickCommand(RobotContainer.joystick, 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() { 
    return false;
    // Return false because this should be running the whole time (drive with joystick) 
    // Exception for when the command is interrupted and another command needs to use the subsystem
  }
}
