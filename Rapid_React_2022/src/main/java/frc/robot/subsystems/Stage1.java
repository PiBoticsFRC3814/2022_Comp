// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Stage1 extends SubsystemBase {
  /** Creates a new Stage1. */
  TalonSRX stage1 = new TalonSRX(Constants.stage1Id);
  DigitalInput limit = new DigitalInput(Constants.stage1Channel);
  public Stage1() {
    stage1.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void Stage1On(){
    stage1.set(ControlMode.PercentOutput, Constants.stage1Speed);
  }
  public void Stage1Off(){
    stage1.set(ControlMode.PercentOutput, 0.0);
  }
  public void Stage1Reverse(){
    stage1.set(ControlMode.PercentOutput, -Constants.stage1Speed);
  }
  public boolean getSensorState(){
    return limit.get();
  }
}
