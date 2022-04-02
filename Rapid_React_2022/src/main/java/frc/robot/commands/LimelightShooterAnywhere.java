// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stage1;
import frc.robot.subsystems.Stage2;
import frc.robot.Constants;
import java.lang.Math;


public class LimelightShooterAnywhere extends CommandBase {
  /** Creates a new LimelightShooterAnywhere. */
  
  Stage1 m_stage1;
  Stage2 m_stage2;
  DriveTrain m_drivetrain;
  Limelight m_limelight;
  Shooter m_shooter;
  double flushAngle = 0.0;
  double shooterSpeed = 0.0;
  double ys;
  boolean isYPos;
  double zs;
  boolean isZPos;

  public LimelightShooterAnywhere(Stage1 s1, Stage2 s2, DriveTrain drive, Limelight limelight, Shooter sh) {
    
    m_stage1 = s1;
    m_stage2 = s2;
    m_drivetrain = drive;
    m_limelight = limelight;
    m_shooter = sh;
    addRequirements(m_stage1);
    addRequirements(m_stage2);
    addRequirements(m_drivetrain);
    addRequirements(m_limelight);
    addRequirements(m_shooter);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    flushAngle = setYawAngle();
    if (m_limelight.yaw > flushAngle + 2)
    {
      ys = 0.3;
      isYPos = false;
    }
    else if (m_limelight.yaw < flushAngle - 2) //-2
    {
      ys = -0.3;
      isYPos = false;
    }
    else
    {
      ys = 0;
      isYPos = true;
    }
    if (m_limelight.z < Constants.maximumDistance && m_limelight.z > Constants.minimumDistacne){
      shooterSpeed = setRPM(); //pretty sure this wont work not sure why it is not erroring.
      m_shooter.setSpeed(shooterSpeed);
       //pretty sure this wont work...
      //turn to flush angle
      //shoot the balls once shooter is up to speed and yaw is close
      isZPos = true;
    }
    else if(m_limelight.z > Constants.maximumDistance)
    {
      zs = 0.4;
      isZPos = false;
      flushAngle = setYawAngle();
    }
    else if (m_limelight.z < Constants.minimumDistacne)
    {
      zs = -0.4;
      isZPos = false;
      flushAngle = setYawAngle();
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

  private double setRPM(){
    double RPM = 0.0;
    RPM = 83.33*m_limelight.z;
    return RPM;
  }
  private double setYawAngle(){
    double Yaw = 0.0;
    Yaw = Math.toDegrees(Math.atan((Constants.hoopDiameter/5)/((Constants.hoopDiameter/2)+(m_limelight.z))));

    return Yaw;
  }

}
