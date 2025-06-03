// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

/** Handler for most events involving driving and chassis-motor manipulation. */
public class Driving extends Command {
    // Initialize our variables for controlling drivetrain.
    private DriveTrain driveTrain;

    // Initialize variables for left and right motor speed
    private double left;
    private double right;

    /**
     * Initialize our driving commands through our DriveTrain subsystem.

     * @param driveTrain The instance of the DriveTrain which is in line with the controller. 
     */
    public Driving(DriveTrain driveTrain) {
        this.driveTrain = driveTrain; 
        addRequirements(this.driveTrain); 
    }

    /** 
     * Find controller positions and drive at that speed. This is run every time the command is scheduled, which is in a loop.
     */
    @Override 
    public void execute() {
        // Get the current position of the joystick axis.
        left = RobotContainer.driverControl.getLeftY() * Constants.THROTTLE;
        right = RobotContainer.driverControl.getRightY() * Constants.THROTTLE;

        left = deadband(left); // Apply deadband to left motor speed.
        right = deadband(right); // Apply deadband to right motor speed.

        // Runs each set of motors based on their calculated power levels. 
        driveTrain.tankDrive(left, right);
    }

    /**
     * Checks if the displacement of each axis is sufficient enough for movement.

     * @param speeds - An array of speeds to compare to the deadband constant.
     */
    public double deadband(double speed) { 
        if (Math.abs(speed) < Constants.DEADBAND) {
            speed = 0.0;
        }
        return speed;
    }
}
