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
    private double movementSpeed;
    private double rotationalSpeed;

    // Initialize our speed variables for controlling motor speeds.
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
     * Apply the displacement of the controller sticks and apply it to our drivetrain.
     */
    @Override 
    public void execute() {
        // Get the current position of the joystick axis.
        // TODO: switch to XboxController. 
        left = RobotContainer.driverControl.getLeftY() * Constants.THROTTLE;
        right = RobotContainer.driverControl.getRightY() * Constants.THROTTLE;

        // Runs each set of motors based on their calculated power levels. 
        driveTrain.tankDrive(left, right);
    }

    /**
     * Checks if the displacement of each axis is sufficient enough for movement.

     * @param speeds - An array of speeds to compare to the deadband constant.
     */
    public double[] deadband(double[] speeds) { 
        for (int i = 0; i < speeds.length; i++) {
            if (Math.abs(speeds[i]) < Constants.DEADBAND) {
                speeds[i] = 0.0;
            }
        }

        return speeds;
    }
}
