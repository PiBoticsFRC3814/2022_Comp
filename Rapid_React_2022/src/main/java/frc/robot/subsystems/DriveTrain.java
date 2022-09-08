// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase {
  private static final WPI_TalonSRX lf = new WPI_TalonSRX(Constants.lf);
  private static final WPI_TalonSRX lr = new WPI_TalonSRX(Constants.lr);
  private static final WPI_TalonSRX rf = new WPI_TalonSRX(Constants.rf);
  private static final WPI_TalonSRX rr = new WPI_TalonSRX(Constants.rr);
  double value;
  
  private static final MecanumDrive piboticsdrive = new MecanumDrive(lf, lr, rf, rr);

  public DriveTrain() {
    lf.setInverted(false);
    lr.setInverted(false);
    rf.setInverted(true);
    rr.setInverted(true);
  }

  public double applyDeadband(double value, double deadband) {
    if (Math.abs(value) > deadband) {
      if (value > 0.0) {
        return (value - deadband) / (1.0 - deadband);
      } else {
        return (value + deadband) / (1.0 - deadband);
      }
    } else {
      return 0.0;
    }
  }
  
  public void Drive(double y, double x, double z, double gyro, double deadband) {
    piboticsdrive.driveCartesian(-applyDeadband(x, deadband), applyDeadband(y, deadband), applyDeadband(z, deadband), gyro);
  }

  public void Brake(){
    lf.setNeutralMode(NeutralMode.Brake);
    lr.setNeutralMode(NeutralMode.Brake);
    rf.setNeutralMode(NeutralMode.Brake);
    rr.setNeutralMode(NeutralMode.Brake);
  }

  public void Coast(){
    lf.setNeutralMode(NeutralMode.Coast);
    lr.setNeutralMode(NeutralMode.Coast);
    rf.setNeutralMode(NeutralMode.Coast);
    rr.setNeutralMode(NeutralMode.Coast);
  }

  @Override
  public void periodic(){
    //Method called once per scheduler run
  }
}