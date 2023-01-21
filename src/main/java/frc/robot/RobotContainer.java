// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.JoystickConstants;
import frc.robot.commands.AutoIntake;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.DriveForwardTimed;
import frc.robot.commands.DriveWithJoystickCommand;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.ShootBall;
import frc.robot.commands.SimpleAuto;
//import frc.robot.commands.SimpleAutoTwo;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Drivetrain declare
  private final DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private final DriveWithJoystickCommand driveWithJoystickCommand = new DriveWithJoystickCommand(drivetrainSubsystem);
  private final DriveForwardTimed driveForwardTimed = new DriveForwardTimed(drivetrainSubsystem);

  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ShootBall shootBall = new ShootBall(shooterSubsystem);
  private final AutoShoot autoShoot = new AutoShoot(shooterSubsystem);

  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final IntakeBall intakeBall = new IntakeBall(intakeSubsystem);
  private final AutoIntake autoIntake = new AutoIntake(intakeSubsystem);

  private final SimpleAuto simpleAuto = new SimpleAuto(drivetrainSubsystem, intakeSubsystem, shooterSubsystem);
  // private final SimpleAutoTwo simpleAutoTwo = new
  // SimpleAutoTwo(drivetrainSubsystem, shooterSubsystem, intakeSubsystem);

  public static Joystick joystick = new Joystick(0);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    drivetrainSubsystem.setDefaultCommand(driveForwardTimed);
    driveWithJoystickCommand.addRequirements(drivetrainSubsystem);
    driveForwardTimed.addRequirements(drivetrainSubsystem);

    intakeSubsystem.setDefaultCommand(intakeBall);
    shootBall.addRequirements(shooterSubsystem);
    autoShoot.addRequirements(shooterSubsystem);
    intakeBall.addRequirements(intakeSubsystem);
    autoIntake.addRequirements(intakeSubsystem);

    // camera?

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */

  private void configureButtonBindings() {
    // create button and bind it to the command
    JoystickButton shootButton = new JoystickButton(joystick, JoystickConstants.joystickShooterButton);
    shootButton.whileHeld(new ShootBall(shooterSubsystem));

    JoystickButton intakeButton = new JoystickButton(joystick, JoystickConstants.joystickIntakeButton);
    intakeButton.whileHeld(intakeBall);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Drive forward timed will run in autonomous
    return simpleAuto;
  }
}
