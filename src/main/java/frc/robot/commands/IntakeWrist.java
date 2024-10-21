// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;

import java.util.function.DoubleSupplier;
import java.util.function.DoubleConsumer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeWrist extends PIDCommand {
  /** Creates a new IntakeWrist. */

  public IntakeWrist(DoubleSupplier sensorVal, DoubleSupplier setpoint,  DoubleConsumer wristSetPosition) {
    super(
        // The controller that the command will use
        new PIDController(1, 1, 1),
        // This should return the measurement
        sensorVal,
        // This should return the setpoint (can also be a constant)
        setpoint, //placeholder value
        // This uses the output
        output -> {
          // Use the output here
          wristSetPosition.accept(output);
        });
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
