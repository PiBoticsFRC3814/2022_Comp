// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class MoveIntake extends SubsystemBase {
  /** Creates a new MoveIntake. */
  TalonSRX moveIntake = new TalonSRX(Constants.moveIntakeId);
  //DigitalInput upLimit = new DigitalInput(Constants.upChannel);
  //DigitalInput downLimit = new DigitalInput(Constants.downChannel);

  public MoveIntake() {
    
  }

  public double MotorAmps()
  {
    return moveIntake.getSupplyCurrent();
  }

  public void UpIntake(){
    /*if(!upLimit.get())
    {
      moveIntake.set(ControlMode.PercentOutput, Constants.moveIntakeSpeed);
    }
    else
    {
      StopIntake();
    }*/

    moveIntake.set(ControlMode.PercentOutput, -Constants.moveIntakeSpeed-0.1);
    moveIntake.set(ControlMode.PercentOutput, -Constants.moveIntakeSpeed-0.1);
    moveIntake.set(ControlMode.PercentOutput, -Constants.moveIntakeSpeed);
  }

  public void DownIntake()
  {
    /*if(!downLimit.get())
    {
      moveIntake.set(ControlMode.PercentOutput, -Constants.moveIntakeSpeed);
    }
    else
    {
      StopIntake();
    }*/

    moveIntake.set(ControlMode.PercentOutput, Constants.moveIntakeSpeed-0.1);
  }

  public void StopIntake()
  {
    moveIntake.set(ControlMode.PercentOutput, 0.0);
  }

  //public boolean getUpIntakeState()
  //{
  //  return upLimit.get();
  //}

  //public boolean getDownIntakeState()
  //{
  // return downLimit.get();
  //}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
