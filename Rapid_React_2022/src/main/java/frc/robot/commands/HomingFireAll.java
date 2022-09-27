// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Stage1;
import frc.robot.subsystems.Stage2;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class HomingFireAll extends SequentialCommandGroup {
  /** Creates a new HomingFireAll. */
  public HomingFireAll(Intake m_intake, Stage1 m_stage1, Stage2 m_stage2, DriveTrain m_drivetrain, Limelight m_limelight, Shooter m_shooter) {
    
    addCommands(
      new ParallelDeadlineGroup(new DriveLimeLight(m_drivetrain, m_limelight), new ShooterOn(m_shooter)),
      new ClearAll(m_stage1, m_stage2, m_shooter)
    );
  }
}
