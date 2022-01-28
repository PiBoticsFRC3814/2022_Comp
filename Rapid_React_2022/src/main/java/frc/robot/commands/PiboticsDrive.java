// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class PiboticsDrive extends CommandBase {
  /** Creates a new PiboticsDrive. */
  DriveTrain m_piboticsDrive;
  private Joystick driverStick;

  
  
  public PiboticsDrive(DriveTrain pb, Joystick ds) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_piboticsDrive = pb;
    driverStick = ds;
    
    addRequirements(m_piboticsDrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_piboticsDrive.Drive(driverStick.getY(), driverStick.getZ(), true);
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
