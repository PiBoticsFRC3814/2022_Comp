// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Stage1;
import frc.robot.subsystems.Stage2;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class IntakeDrive extends ParallelCommandGroup {
  /** Creates a new IntakeDrive. */
  public IntakeDrive(DriveTrain m_drivetrain, Intake m_intake, Stage1 m_stage1, Stage2 m_stage2, Double m_time, Double m_speed) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new AutoIntake(m_intake, m_stage1, m_stage2),
      new TimedForward(m_drivetrain, m_time, m_speed)
    );
  }
}
