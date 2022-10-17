// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Stage1;
import frc.robot.subsystems.Stage2;

public class IntakeDrive extends CommandBase {
  /** Creates a new TimedForward. */
  private final DriveTrain m_DriveTrain;
  private final Intake m_intake;
  private final Stage1 m_stage1;
  private final Stage2 m_stage2;
  private Double moveTime;
  private Double moveSpeed;
  private Timer autoTimer;
  private Boolean done, se1, se2;


  public IntakeDrive(DriveTrain drivetrain, Double movetime, Double speed, Intake intake, Stage1 stage1, Stage2 stage2) {
    // Use addRequirements() here to declare subsystem dependencies.
    autoTimer = new Timer();
    m_DriveTrain = drivetrain;
    moveTime = movetime;
    moveSpeed = -speed;
    m_intake = intake;
    m_stage1 = stage1;
    m_stage2 = stage2;
    addRequirements(m_DriveTrain);
    addRequirements(m_intake);
    addRequirements(m_stage1);
    addRequirements(m_stage2);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    autoTimer.stop();
    autoTimer.reset();
    done = false;
    se1 = false;
    se2 = false;
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
      m_intake.IntakeReverse();
    }
    if(!se2){
      m_stage2.Stage2On();
    }
    else{
      m_stage2.Stage2Off();
    }

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
      m_intake.IntakeOff();
      m_stage1.Stage1Off();
      m_stage2.Stage2Off();
      return true;
    }
    else{
      return false;
    }
  }
}
