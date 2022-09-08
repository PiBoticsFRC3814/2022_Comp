// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.io.IOException;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.ADIS16470_IMU;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.RecordJoystick;

public class PiboticsDrive extends CommandBase {
  /** Creates a new PiboticsDrive. */
  DriveTrain m_driveTrain;
  private final RecordJoystick m_recordjoystick;
  DoubleSupplier m_x, m_y, m_z;
  ADIS16470_IMU m_gyro;
  
  public PiboticsDrive(DoubleSupplier dx, DoubleSupplier dy, DoubleSupplier dz, ADIS16470_IMU dgyro, DriveTrain drive, RecordJoystick recordStick) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveTrain = drive;
    m_x = dx;
    m_y = dy;
    m_z = dz;
    m_gyro = dgyro;
    m_recordjoystick = recordStick;

    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.Drive(m_y.getAsDouble(), m_x.getAsDouble(), m_z.getAsDouble(), -m_gyro.getAngle(), 0.2);
    SmartDashboard.putNumber("Gyro ADIS", m_gyro.getAngle());
    try {
      m_recordjoystick.WriteCSV(m_x.getAsDouble(), m_y.getAsDouble(), m_z.getAsDouble());
    } catch (IOException e) {
      DriverStation.reportWarning("Can't Find csv", false);
      DriverStation.reportWarning(e.toString(), false);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
