package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.Top;

public class Manipulate extends Command{
    // The top subsystem being manipulated
    public Top subsystem;

    // Create a new Manipulate command
    // Initiator
    public Manipulate(Top topSubsystem) {
        subsystem = topSubsystem;
    }
    @Override
    public void execute() {    }

    // Command to toggle the right side
    public Command rightCommand = Commands.runOnce(() -> {
        subsystem.toggleRight();
    });

    // Command to toggle the left side
    public Command leftCommand = Commands.runOnce(() -> {
        subsystem.toggleLeft();
    });
}