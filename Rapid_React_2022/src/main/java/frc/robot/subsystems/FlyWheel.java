// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FlyWheel extends SubsystemBase {
  /** Creates a new FlyWheel. */
  private static WPI_TalonSRX shooter;
  public boolean isArmed = false;
  
  public FlyWheel() {
    shooter = new WPI_TalonSRX(Constants.ShooterMotor);
  }
  
  public void MotorOn() {
    shooter.set(1.0);
  }
  
  public void MotorOff() {
    shooter.set(0.0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
