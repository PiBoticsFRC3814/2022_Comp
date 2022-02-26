// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Stage2;

public class GetSensor2 extends CommandBase {
  /** Creates a new GetSensor1. */
  Stage2 m_stage2 = new Stage2();
  public GetSensor2(Stage2 s2) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_stage2 = s2;
    addRequirements(m_stage2);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putBoolean("Rear Ball", m_stage2.getSensorState());
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
