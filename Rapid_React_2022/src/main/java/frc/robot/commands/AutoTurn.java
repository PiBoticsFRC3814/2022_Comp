// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class AutoTurn extends CommandBase {
  /** Creates a new AutoTurn. */
  Double speed;
  Limelight m_limelight;
  DriveTrain m_drivetrain;
  Boolean done;
  int counter = 0;

  public AutoTurn(Double Speed, Limelight LimeLight, DriveTrain drivetrain) {
    // Use addRequirements() here to declare subsystem dependencies.
    speed = Speed;
    m_limelight = LimeLight;
    m_drivetrain = drivetrain;
    addRequirements(m_drivetrain);
    addRequirements(m_limelight);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    done = false;
    counter = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_limelight.isValidTarget())
    {
      counter++;
      done = false;
    }
    else
    {
      m_drivetrain.Drive(0, speed, false);
      done = false;
    }
    if(counter > Constants.autoCount){
      m_drivetrain.Drive(0, 0, false);
      done = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (done){
      done = false;
      m_drivetrain.Drive(0.0,0.0,false);
      counter = 0;
      return true;
    }
    else{
      return false;
    }
  }
}
