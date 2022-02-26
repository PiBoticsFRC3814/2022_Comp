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

  public static double ys, zs;
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
      zs = 0.3;
      isZPos = false;
    }
    else if (m_LimeLight.z > Constants.distanceFarthest)
    {
      zs = -0.3;
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
    else
    {
      m_LimeLight.position = false;
    }

    if (!m_LimeLight.isValidTarget())
    {
      timeOut++;
    }
    else if (m_LimeLight.isValidTarget())
    {
      timeOut = 0;
    }

    if (position >= 25)
    {
      m_LimeLight.position = true;
    }
    m_PiboticsDrive.Drive(zs, ys, false);
    SmartDashboard.putNumber("Zs", zs);
    SmartDashboard.putNumber("Ys", ys);
    SmartDashboard.putNumber("Counter", timeOut);
    SmartDashboard.putNumber("pos", position);
    m_LimeLight.displayOutput();
}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (timeOut <= 100 || !m_LimeLight.position)
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