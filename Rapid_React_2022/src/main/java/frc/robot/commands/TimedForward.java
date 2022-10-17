// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveTrain;

public class TimedForward extends CommandBase {
  /** Creates a new TimedForward. */
  private final DriveTrain m_DriveTrain;
  private Double moveTime;
  private Double moveSpeed;
  private Timer autoTimer;
  private Boolean done;


  public TimedForward(DriveTrain drivetrain, Double movetime, Double speed) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveTrain = drivetrain;
    moveTime = movetime;
    moveSpeed = speed;
    autoTimer = new Timer();
    addRequirements(m_DriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    autoTimer.stop();
    autoTimer.reset();
    done = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    autoTimer.start();
    if (autoTimer.get() < moveTime){
      m_DriveTrain.Drive(moveSpeed, 0, false);
    }
    else {
      m_DriveTrain.Drive(0, 0, false);
      done = true;
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (done){
      done = false;
      m_DriveTrain.Drive(0.0,0.0,false);
      return true;
    }
    else{
      return false;
    }
  }
}
