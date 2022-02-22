// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Climb extends SubsystemBase {
  /** Creates a new Climb. */
  DoubleSolenoid lf = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.lfExtend, Constants.lfRetract);
  DoubleSolenoid lr = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.lrExtend, Constants.lrRetract);
  DoubleSolenoid rf = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.rfExtend, Constants.rfRetract);
  DoubleSolenoid rr = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.rrExtend, Constants.rrRetract);

  public Climb() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void extendLarge(){
    
  }
}
