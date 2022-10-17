// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Stage2 extends SubsystemBase {

  WPI_TalonSRX Stage2 = new WPI_TalonSRX(Constants.stage2Id);
  DigitalInput limit2 = new DigitalInput(Constants.stage2Channel);
  /** Creates a new Stage2. */
  public Stage2() {
    Stage2.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void Stage2On(){
    Stage2.set(ControlMode.PercentOutput, Constants.stage2Speed);
  }
  public void Stage2Off(){
    Stage2.set(ControlMode.PercentOutput, 0.0);
  }
  public void Stage2Reverse(){
    Stage2.set(ControlMode.PercentOutput, -Constants.stage2Speed);
  }
  public boolean getSensorState(){
    return limit2.get();
  }
}
