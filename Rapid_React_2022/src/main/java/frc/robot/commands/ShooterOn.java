// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Shooter;

public class ShooterOn extends CommandBase {
  /** Creates a new ShooterOn. */
  Shooter m_shooter;
  public ShooterOn(Shooter sh) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_shooter = sh;
    addRequirements(m_shooter);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    DriverStation.reportError("INIT SHOOTER", false);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooter.setSpeed(Constants.targetRPM);
    DriverStation.reportError("EXECUTE SHOOTER", false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriverStation.reportError("END SHOOTER", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    DriverStation.reportError("FALSE SHOOTER", false);
    return false;
  }
}
