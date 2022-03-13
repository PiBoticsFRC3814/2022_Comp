/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Limelight;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DriveLimeLight extends CommandBase {
  /**
   * Creates a new LimeLight.
/** */
  Limelight m_LimeLight;
  DriveTrain m_PiboticsDrive;

  public static double ys, zs, x, t;
  public static int timeOut = 0;
  public static int position = 0;

  public static Boolean isYPos = false;
  public static Boolean isZPos = false;

  public DriveLimeLight(DriveTrain piboticsdrive, Limelight LimeLight) {
    m_PiboticsDrive = piboticsdrive;
    m_LimeLight = LimeLight;
    addRequirements(m_PiboticsDrive);
    addRequirements(m_LimeLight);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_LimeLight.position = false;
    position = 0;
    timeOut = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_LimeLight.onLight();
    SmartDashboard.putBoolean("Target Acquired", m_LimeLight.isValidTarget());

    if (m_LimeLight.yaw > 2)
    {
      ys = 0.3;
      isYPos = false;
    }
    else if (m_LimeLight.yaw < -2)
    {
      ys = -0.3;
      isYPos = false;
    }
    else
    {
      ys = 0;
      isYPos = true;
    }
    if (m_LimeLight.z < Constants.distanceLowest)
    {
      x = m_LimeLight.z;
      t = (Constants.distanceFarthest + Constants.distanceLowest) / 2;
      zs = ((x - t) / 20) - 0.2;
      if (zs < -0.5) {
        zs = -0.5;
      }
      isZPos = false;
    }
    else if (m_LimeLight.z > Constants.distanceFarthest)
    {
      x = m_LimeLight.z;
      t = (Constants.distanceFarthest + Constants.distanceLowest) / 2;
      zs = ((x - t) / 20) + 0.2;
      if (zs > 0.5) {
        zs = 0.5;
      }
      isZPos = false;
    }
    else
    {
      zs = 0;
      isZPos = true;
    }

    if (isYPos && isZPos)
    {
      position++;
    }

    if (!m_LimeLight.isValidTarget())
    {
      timeOut++;
    }
    else if (m_LimeLight.isValidTarget())
    {
      timeOut = 0;
    }

    if (position >= 60)
    {
      m_LimeLight.position = true;
    }
    m_PiboticsDrive.Drive(-zs, ys, false);
    SmartDashboard.putNumber("Zs", zs);
    SmartDashboard.putNumber("Ys", ys);
    SmartDashboard.putNumber("Counter", timeOut);
    SmartDashboard.putNumber("pos", position);
    SmartDashboard.putBoolean("ypos", isYPos);
    SmartDashboard.putBoolean("zpos", isZPos);
    SmartDashboard.putBoolean("POS", m_LimeLight.position);
    m_LimeLight.displayOutput();
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (!m_LimeLight.position)
    {
      return false;
    }
    else
    {
      m_PiboticsDrive.Drive(0, 0, false);
      m_LimeLight.offLight();
      isYPos = false;
      isZPos = false;
      return true;
    }
  }
}