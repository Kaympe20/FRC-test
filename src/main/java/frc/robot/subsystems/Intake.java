// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private CANSparkMax intakeRoller = new CANSparkMax(2, MotorType.kBrushless);
  private DigitalInput beamBreak = new DigitalInput(0);
  private PIDController wristPID = new PIDController(1, 1, 0);


  public Intake() {
    wristPID.enable();
  }
  public void extendWrist(){
    
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
