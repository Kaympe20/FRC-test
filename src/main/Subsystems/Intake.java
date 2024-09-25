// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package Intake;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
  private CANSparkMax intakeWrist = new CANSparkMax(1, MotorType.kBrushless);
  private CANSparkMax intakeRoller = new CANSparkMax(2, MotorType.kBrushless);
  private DigitalInput beamBreak = new DigitalInput(0);
  private AnalogEncoder wristEncoder = new AnalogEncoder(0);
  private PIDController pid = new PIDController(kP, kI, kD);


  public Intake() {

  }
  public void intakeIn(){
    //intake motor in

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
