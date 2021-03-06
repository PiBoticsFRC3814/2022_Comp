// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class ToggleRearClimb extends CommandBase {
  /** Creates a new Extendclimb. */
  Climb m_rearclimb;
  public ToggleRearClimb(Climb rearclimb) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_rearclimb = rearclimb;
    addRequirements(m_rearclimb);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_rearclimb.rearState){
      m_rearclimb.retractRear();
      m_rearclimb.rearState = false;
    }
    else{
      m_rearclimb.extendRear();
      m_rearclimb.rearState = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
