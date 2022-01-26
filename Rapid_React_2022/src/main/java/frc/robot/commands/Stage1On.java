// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Stage1;

public class Stage1On extends CommandBase {
  /** Creates a new Stage1On. */
  Stage1 m_stage1;
  public Stage1On(Stage1 s1) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_stage1 = s1;
    addRequirements(m_stage1);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_stage1.Stage1On();
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
