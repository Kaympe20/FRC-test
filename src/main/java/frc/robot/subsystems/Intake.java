// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.IntakeWrist;
import com.revrobotics.CANSparkMax;

public class Intake extends SubsystemBase {

  private double wristSetpoint = 0;
  private double rollerSetpoint = 0;
  private DutyCycleEncoder encoder = new DutyCycleEncoder(0);
  private CANSparkMax wrist = new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);

  public void setWristSetpoint(double setpoint) {
    this.wristSetpoint = setpoint;
  }
  public double getWristSetpoint() {
    return wristSetpoint;
  }

  public void setRollerSetpoint(double setpoint) {
    this.rollerSetpoint = setpoint;
  }
  public double getRollerSetpoint() {
    return rollerSetpoint;
  }

  public Intake() {
    //initialize IntakeWrist Command
    new IntakeWrist(encoder::getDistance, this::getWristSetpoint, wrist::set).schedule();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
