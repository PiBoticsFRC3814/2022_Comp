// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stage1;
import frc.robot.subsystems.Stage2;

public class AutoFire extends CommandBase {
  /** Creates a new AutoFire. */
  Shooter m_shooter;
  Stage1 m_stage1;
  Stage2 m_stage2;
  double velocity = 0.0;
  
  public AutoFire(Stage1 s1, Stage2 s2, Shooter sh) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shooter = sh;
    m_stage1 = s1;
    m_stage2 = s2;
    addRequirements(m_stage1);
    addRequirements(m_stage2);
    addRequirements(m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    velocity = m_shooter.getSpeed();
    if((velocity > Constants.targetRPM - Constants.RPMtolerance) && (velocity < Constants.targetRPM + Constants.RPMtolerance))
    {
      m_stage2.Stage2On();
      m_stage1.Stage1On();
    }
    else
    {
      m_stage1.Stage1Off();    //Check if intake doesn't work
      m_stage2.Stage2Off();
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
