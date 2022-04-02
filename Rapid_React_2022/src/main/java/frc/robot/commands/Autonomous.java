// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stage1;
import frc.robot.subsystems.Stage2;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Autonomous extends SequentialCommandGroup {
  /** Creates a new Autonomous. */
  public Autonomous(Intake m_intake, Stage1 m_stage1, Stage2 m_stage2, DriveTrain m_drivetrain, Limelight m_limelight, Shooter m_shooter, ADIS16470_IMU m_gyro) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());

    addCommands(
      new DropIntake(m_drivetrain, Constants.dropTime, Constants.forwardSpeed),
      new DropIntake(m_drivetrain, Constants.dropTime, Constants.reverseSpeed),
      new ParallelDeadlineGroup(new TimedForward(m_drivetrain, Constants.forwardTime, Constants.forwardSpeed), new AutoIntake(m_intake,m_stage1, m_stage2)),
      //new IntakeDrive(m_drivetrain, Constants.forwardTime, Constants.forwardSpeed, m_intake, m_stage1, m_stage2),
      new ParallelDeadlineGroup(new AutoTurn(0.0, Constants.turnAngle, m_limelight, m_drivetrain, m_gyro), new AutoIntake(m_intake, m_stage1, m_stage2), new ShooterOn(m_shooter)),
      new ParallelDeadlineGroup(new DriveLimeLight(m_drivetrain, m_limelight), new AutoIntake(m_intake, m_stage1, m_stage2), new ShooterOn(m_shooter)),
      new ClearAll(m_stage1, m_stage2, m_shooter)
    );
  }
}
