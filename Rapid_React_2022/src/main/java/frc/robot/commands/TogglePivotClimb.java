// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climb;

public class TogglePivotClimb extends CommandBase {
  /** Creates a new Extendpivotleft. */
  Climb m_pivot;
  public TogglePivotClimb(Climb pivot) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_pivot = pivot;
    addRequirements(m_pivot);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_pivot.pivotState){
      m_pivot.retractPivotLeft();
      m_pivot.retractPivotRight();
      m_pivot.pivotState = false;
    }
    else{
      m_pivot.extendPivotLeft();
      m_pivot.extendPivotRight();
      m_pivot.pivotState = true;
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
