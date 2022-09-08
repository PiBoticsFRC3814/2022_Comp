// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

import frc.robot.Constants;

public class FiringPin extends SubsystemBase {
  /** Creates a new FiringPin. */
  public static DoubleSolenoid fire;

  public FiringPin() {
    fire = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.fire1, Constants.fire2);
  }

  public void FiringPinForward(){
    fire.set(DoubleSolenoid.Value.kForward);
  }
  
  public void FiringPinBackward(){
    fire.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
