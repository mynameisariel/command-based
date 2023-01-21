// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */

public final class Constants {

    public static final class DriveTrainConstants {
        public static final int leftFrontCANID = 1;
        public static final int leftBackCANID = 2;
        public static final int rightFrontCANID = 3;
        public static final int rightBackCANID = 4;
    }

    public static final class JoystickConstants {
        public static final int joystickXAxis = 1;
        public static final int joystickYAxis = 0;
        public static final int joystickShooterButton = 1;
        public static final int joystickIntakeButton = 3;
    }

    public static final class DriveForwardTimedConstants {
        public static final double driveForwardTime = 5.0;
        public static final double autonomousSpeed = 0.3;
    }

    public static final class ShooterConstants {
        public static final int m_shooterDevice = 2;
        public static final double shooterSpeed = 0.5;
        public static final double autoShootTime = 2.0;
    }

    public static final class IntakeConstants {
        public static final int m_storageDevice = 1;
        public static final double intakeSpeed = 0.5;
        public static final double intakeTime = 2.0;
    }

}
