package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Top extends SubsystemBase{
    // Define the motors
    private final Spark left = new Spark(Constants.LEFT_TOP_MOTOR);
    private final Spark right = new Spark(Constants.RIGHT_TOP_MOTOR);

    // Create vars to keep track of state for motors
    private boolean leftToggle = false;
    private boolean rightToggle = false;
    
    // Toggle the left side
    public void toggleLeft() {
        leftToggle = !leftToggle;
    }

    // Toggle the right side
    public void toggleRight() {
        rightToggle = !rightToggle;
    }

    // Periodicly set the motors to the correct speed
    public void periodic() {
        if (leftToggle) {
            left.set(Constants.TOP_THROTTLE);
        }
        else {
            left.set(0);
        }
        if (rightToggle) {
            right.set(Constants.TOP_THROTTLE);
        }
        else {
            right.set(0);
        }
    }

}
