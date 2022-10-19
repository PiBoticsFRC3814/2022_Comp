// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MoveIntake;

public class ToggleIntakePivot extends CommandBase {
  /** Creates a new ToggleIntakePivot. */
  MoveIntake m_moveIntake = new MoveIntake();
  int limitSwitchSelect;
  public ToggleIntakePivot( MoveIntake moveIntake ) {
    m_moveIntake = moveIntake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements( m_moveIntake );
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    limitSwitchSelect = m_moveIntake.IntakePivotState();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if( limitSwitchSelect == 1 ){
      do{
        m_moveIntake.UpIntake();
      } while(m_moveIntake.IntakePivotState() != -1);
    }

    if( limitSwitchSelect != 1 ){
      do{
        m_moveIntake.DownIntake();
      }while(m_moveIntake.IntakePivotState() != 1);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    m_moveIntake.StopIntake();
    return true;
  }
}
