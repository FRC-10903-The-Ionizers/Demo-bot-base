// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
//import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import frc.robot.Constants;

/* Subsystem designed for controlling the bottom driving motors*/
public class DriveTrain extends SubsystemBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})

    // Initialize our motors by referencing their ports. 
    private final Spark left1 = new Spark(Constants.LEFT_MOTOR_PORT_1);
    private final Spark right1 = new Spark(Constants.RIGHT_MOTOR_PORT_1);
    private final Spark left2 = new Spark(Constants.LEFT_MOTOR_PORT_2);
    private final Spark right2 = new Spark(Constants.RIGHT_MOTOR_PORT_2);

    // Package our motors into MotorControllerGroups to be added to a DifferentialDrive. We should eventually change this as it is depricated.
    private final MotorControllerGroup leftMotors = new MotorControllerGroup(left1, left2);
    private final MotorControllerGroup rightMotors = new MotorControllerGroup(right1, right2);
    private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotors, rightMotors);

    private double gearMultiplier = 0.4;

    /** 
     * Constructor for the DriveTrain subsystem. 
     * This is where we set up the motors and their properties.
     */
    public DriveTrain() {
        // Set the safety toggle and expiration on the motors + drivetrain.
        setupMotors(new Spark[]{left1, left2, right1, right2});
    }

    /** 
     * Use the tank drive mechanic to maneuver the robot's drivetrain. 

     * @param movementSpeedLeft - The movement speed of the left set of motors. 
     * @param movementSpeedRight - The movement speed of the right set of motors. 
     */
    public void tankDrive(double movementSpeedLeft, double movementSpeedRight) {
        leftMotors.set(movementSpeedLeft * Constants.LEFT_MULTIPLER * gearMultiplier);
        rightMotors.set(movementSpeedRight * Constants.RIGHT_MULTIPLER * gearMultiplier);
    }

    public void downshift() {
        gearMultiplier = gearMultiplier-0.1;
        if (gearMultiplier < 0) {
            gearMultiplier = 0;
        }
    }

    public void upshift() {
        gearMultiplier = gearMultiplier+0.1;
        if (gearMultiplier > 1) {
            gearMultiplier = 1;
        }
    }

    /**
     * Toggles the safety and sets the expiration for all of the motor objects.

     * @param motors - An array of the motors to edit the properties of. 
     */
    public void setupMotors(Spark[] motors) {
        for (Spark motor : motors) {
            motor.setSafetyEnabled(Constants.SAFETY_TOGGLE);
            motor.setExpiration(Constants.EXPIRATION_TIME);
        }

        diffDrive.setSafetyEnabled(Constants.SAFETY_TOGGLE);
        diffDrive.setExpiration(Constants.EXPIRATION_TIME);
    }
    /** 
     * Add each of the calculations from our encoders and gyroscopes to our dashboard. 
     */
    @Override
    public void periodic() {
        SmartDashboard.putNumber("Driving Throttle", Constants.THROTTLE);
        SmartDashboard.putNumber("Time Total:", DriverStation.getMatchTime());  
    }
}

