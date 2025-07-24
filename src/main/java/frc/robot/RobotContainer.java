// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.Driving;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.Manipulate;
import frc.robot.subsystems.Top;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // The robot's subsystems and commands are defined here...

    // Initialize our joystick for manipulation and controller for drivetrain.
    // public static final Joystick manipulatorControl = new Joystick(0);
    public static final XboxController driverControl = new XboxController(0);
    public static final CommandXboxController topControl = new CommandXboxController(0);

    // Create new subsystems for the robot to pull from.
    private static DriveTrain driveTrain = new DriveTrain(); 
    private final Manipulate manipulate = new Manipulate(new Top());
    public Driving driver = new Driving(driveTrain);

    /** 
     * The container for the robot. Contains subsystems, OI devices, and commands. 
     */
    public RobotContainer() {

        
        // Bindings
        topControl.leftBumper().onChange(manipulate.left);

        
        topControl.rightBumper().onChange(manipulate.right);
        topControl.a().onChange(manipulate.servoLoad);
        topControl.x().onChange(manipulate.servo);
        
        topControl.povDown().onTrue(driver.downshiftCommand);
        topControl.povUp().onTrue(driver.upshiftCommand);
        
        // Add a new Driving command to the drivetrain.
        driveTrain.setDefaultCommand(driver);
        
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {}

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // An ExampleCommand will run in autonomous
        return null;
    }
}
