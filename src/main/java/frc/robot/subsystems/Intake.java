// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.DutyCycleEncoder;

import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. */

  //Wrist
  private CANSparkMax intakeMotor = new CANSparkMax(0, CANSparkMax.MotorType.kBrushless);
  private DutyCycleEncoder intakeEncoder = new DutyCycleEncoder(0);
  //Encoder measures 30 degrees at full extension
  private void extendWrist() {
    while (intakeEncoder.get() < 30) {
      intakeMotor.set(1);
    }
  }
  private void retractWrist() {
    while (intakeEncoder.get() > 0) {
      intakeMotor.set(-1);
    }
  }

  //Roller
  private TalonFX rollerMotor = new TalonFX(1);
  private DigitalInput noteSensor = new DigitalInput(1);
  private void engageRoller() {
    rollerMotor.set(1);
  }
  private void disengageRoller() {
    rollerMotor.set(0);
  }

  public Intake() {}
  
  public void engageIntake() {
    this.extendWrist();
    this.engageRoller();

  }
  public void disengageIntake() {
    this.retractWrist();
    this.disengageRoller();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (noteSensor.get()) {
      this.disengageIntake();
    }
  }
}
