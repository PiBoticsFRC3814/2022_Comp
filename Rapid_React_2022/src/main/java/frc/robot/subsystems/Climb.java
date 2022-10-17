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
  DoubleSolenoid front = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.frontExtend, Constants.frontRetract);
  DoubleSolenoid rear = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.rearExtend, Constants.rearRetract);
  DoubleSolenoid pivotLeft = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.pivotLeftExtend, Constants.pivotLeftRetract);
  DoubleSolenoid pivotRight = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.pivotRightExtend, Constants.pivotRightRetract);

  public boolean frontState = false;
  public boolean rearState = false;
  public boolean pivotState = true;

  public Climb() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void extendFront()
  {
    front.set(DoubleSolenoid.Value.kForward);
  }

  public void extendRear(){
    rear.set(DoubleSolenoid.Value.kForward);
  }

  public void extendPivotLeft(){
    pivotLeft.set(DoubleSolenoid.Value.kForward);
  }

  public void extendPivotRight(){
    pivotRight.set(DoubleSolenoid.Value.kForward);
  }

  public void retractFront(){
    front.set(DoubleSolenoid.Value.kReverse);
  }

  public void retractRear(){
    rear.set(DoubleSolenoid.Value.kReverse);
  }

  public void retractPivotLeft(){
    pivotLeft.set(DoubleSolenoid.Value.kReverse);
  }

  public void retractPivotRight(){
    pivotRight.set(DoubleSolenoid.Value.kReverse);
  }
}
