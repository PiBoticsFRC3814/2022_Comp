// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.MoveIntake;

public class IntakeUp extends CommandBase {
  /** Creates a new ToggleIntake. */
  MoveIntake m_moveIntake = new MoveIntake();
  public IntakeUp(MoveIntake moveIntake) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_moveIntake = moveIntake;
    addRequirements(m_moveIntake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    //if((Math.abs(m_moveIntake.MotorAmps())) < 150.0)
    //{
      m_moveIntake.UpIntake();
    //}
    //else{
      //m_moveIntake.StopIntake();
    //}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(m_moveIntake.MotorAmps()) > 150.0)
    {
      return false;
    }
    else{
      return false;
    }
  }
}
