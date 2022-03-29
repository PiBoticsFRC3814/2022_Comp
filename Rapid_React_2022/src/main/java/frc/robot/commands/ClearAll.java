// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stage1;
import frc.robot.subsystems.Stage2;

public class ClearAll extends CommandBase {
  /** Creates a new AutoFire. */
  Shooter m_shooter;
  Stage1 m_stage1;
  Stage2 m_stage2;
  double velocity = 0.0;
  int counter = 0;
  int blankignore = 0;
  boolean se1, se2, finish;

  Timer timer = new Timer();
  
  public ClearAll(Stage1 s1, Stage2 s2, Shooter sh) {
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
  public void initialize() {
    counter = 0;
    se1 = false;
    se2 = false;
    finish = false;
    timer.stop();
    timer.reset();
    m_shooter.setSpeed(Constants.targetRPM);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    se1 = !m_stage1.getSensorState();
    se2 = !m_stage2.getSensorState();
    velocity = m_shooter.getSpeed();
    if((velocity > Constants.targetRPM - Constants.RPMtolerance) && (velocity < Constants.targetRPM + Constants.RPMtolerance))
    {
      counter++;
    }
    if(counter > 10)
    {
      m_stage1.Stage1On();
      m_stage2.Stage2On();
    }
    if(!se1 && !se2)
    {
      timer.start();
    }
    if((!se1 && !se2) && (timer.get() > Constants.shootDelay * 2.0)){
      m_stage1.Stage1Off();
      m_stage2.Stage2Off();
      m_shooter.stop();
      finish = true;
    }  
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return finish;
  }
}
