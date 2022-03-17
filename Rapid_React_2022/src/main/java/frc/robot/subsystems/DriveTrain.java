// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  WPI_TalonSRX leftdrive = new WPI_TalonSRX(Constants.leftdrive); 
  WPI_TalonSRX rightdrive = new WPI_TalonSRX(Constants.rightdrive);


  DifferentialDrive m_piboticsDrive = new DifferentialDrive(leftdrive, rightdrive);

  public DriveTrain() {
    rightdrive.setInverted(true);
  }

  public void Drive(double y, double x, boolean stick) {
    m_piboticsDrive.arcadeDrive(-y, x, stick);
  }

  public void brakeOn(){
    leftdrive.setNeutralMode(NeutralMode.Brake);
    rightdrive.setNeutralMode(NeutralMode.Brake);
  }

  public void brakeOff(){
    leftdrive.setNeutralMode(NeutralMode.Coast);
    rightdrive.setNeutralMode(NeutralMode.Coast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
