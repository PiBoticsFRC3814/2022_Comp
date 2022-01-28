// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  WPI_TalonSRX lf = new WPI_TalonSRX(Constants.lf); 
  WPI_TalonSRX lr = new WPI_TalonSRX(Constants.lr);
  WPI_TalonSRX rf = new WPI_TalonSRX(Constants.rf);
  WPI_TalonSRX rr = new WPI_TalonSRX(Constants.rr);

  MotorControllerGroup leftdrive = new MotorControllerGroup(lf, lr);
  MotorControllerGroup rightdrive = new MotorControllerGroup(rf, rr);

  DifferentialDrive m_piboticsDrive = new DifferentialDrive(leftdrive, rightdrive);

  public DriveTrain() {
    rightdrive.setInverted(true);
  }

  public void Drive(double y, double x, boolean stick) {
    m_piboticsDrive.arcadeDrive(-y, x, stick);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
