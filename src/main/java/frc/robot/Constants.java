// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    /** The multipler of the speed of the drivetrain. */
    public static double THROTTLE = 1.0;
    
    /** The first port of the left drivetrain motor. */
    public static final int LEFT_MOTOR_PORT_1 = 0;

    /** The second port of the left drivetrain motor. */
    public static final int LEFT_MOTOR_PORT_2 = 1; 

    /** The first port of the right drivetrain motor. */
    public static final int RIGHT_MOTOR_PORT_1 = 3; 

    /** The second port of the right drivetrain motor. */
    public static final int RIGHT_MOTOR_PORT_2 = 4;

    /** The expiration time for the motor's safety. */
    public static final int EXPIRATION_TIME = Integer.MAX_VALUE;

    /** The toggle for motor safety. */
    public static final boolean SAFETY_TOGGLE = false; 

    /** The toggle for reversed movement controls. */
    public static final boolean INVERTED_DRIVE = false; 

    /** Toggles the tank drive on the robot. */
    public static final boolean IS_TANK = false;
    
    /** The deadband for the joysticks to prevent small, irregular movements. */
    public static final double DEADBAND = 0.2; 
}