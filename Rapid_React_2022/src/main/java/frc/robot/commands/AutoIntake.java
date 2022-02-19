// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Stage1;
import frc.robot.subsystems.Stage2;

public class AutoIntake extends CommandBase {
  /** Creates a new AutoIntake. */
  Intake m_intake;
  Stage1 m_stage1;
  Stage2 m_stage2;
  boolean se1, se2, finish;
  public AutoIntake(Intake intake, Stage1 s1, Stage2 s2) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_intake = intake;
    m_stage1 = s1;
    m_stage2 = s2;
    addRequirements(m_intake);
    addRequirements(m_stage1);
    addRequirements(m_stage2);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    se1 = false;
    se2 = false;
    finish = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    se1 = !m_stage1.getSensorState();
    se2 = !m_stage2.getSensorState();

    if((!se1)||(!se2)){
      m_stage1.Stage1On();
      m_intake.IntakeOn();
    }
    else{
      m_stage2.Stage2Off();
      m_stage1.Stage1Off();
      m_intake.IntakeOff();
      finish = true;
    }
    if(!se2){
      m_stage2.Stage2On();
    }
    else{
      m_stage2.Stage2Off();
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
