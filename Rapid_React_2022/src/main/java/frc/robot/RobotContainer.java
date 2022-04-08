// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.SPI.Port;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj.ADIS16448_IMU;
import edu.wpi.first.wpilibj.ADIS16470_IMU;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  //public ADXRS450_Gyro m_gyro = new ADXRS450_Gyro(Port.kOnboardCS0);

  public ADIS16470_IMU m_gyro = new ADIS16470_IMU();

  public final DriveTrain m_piboticsdrive = new DriveTrain();

  public final Intake m_intake = new Intake();

  public static final Shooter m_shooter = new Shooter();

  public final Stage1 m_stage1 = new Stage1();

  public final Stage2 m_stage2 = new Stage2();

  public final MoveIntake m_moveIntake = new MoveIntake();

  public final Limelight m_limelight = new Limelight();

  public final Climb m_climb = new Climb();

  public final Joystick driveStick = new Joystick(Constants.ds);

  public final Joystick opStick = new Joystick(Constants.os);

  private final CommandBase m_autoCommand = new Autonomous(m_intake, m_stage1, m_stage2, m_piboticsdrive, m_limelight, m_shooter, m_gyro, m_moveIntake);



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    m_piboticsdrive.setDefaultCommand(new PiboticsDrive(m_piboticsdrive, driveStick));
    m_limelight.setDefaultCommand(new GetLimelight(m_limelight));
    m_stage1.setDefaultCommand(new GetSensor1(m_stage1));
    m_stage2.setDefaultCommand(new GetSensor2(m_stage2));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //JoystickButton autoFire = new JoystickButton(opStick, 6);
    JoystickButton autoIntake = new JoystickButton(opStick, 5);
    JoystickButton outTake = new JoystickButton(opStick, 7);
    JoystickButton clearShooter = new JoystickButton(opStick, 8);
    JoystickButton limelight = new JoystickButton(opStick, 9);
    JoystickButton toggleFrontClimb = new JoystickButton(opStick, 4);
    JoystickButton toggleRearClimb = new JoystickButton(opStick, 2);
    JoystickButton togglePivotClimb = new JoystickButton(opStick, 1);
    //JoystickButton ToggleLimelight = new JoystickButton(opStick, 10);
    JoystickButton shooterToggle = new JoystickButton(opStick, 3);
    POVButton upPOV = new POVButton(opStick, 0);
    POVButton downPOV = new POVButton(opStick, 180);

    upPOV.whenPressed(new IntakeUp(m_moveIntake));
    upPOV.whenReleased(new IntakeStop(m_moveIntake));

    downPOV.whenPressed(new IntakeDown(m_moveIntake));
    downPOV.whenReleased(new IntakeStop(m_moveIntake));

    shooterToggle.whenPressed(new ShooterOn(m_shooter));
    shooterToggle.whenReleased(new ShooterOff(m_shooter));

    //autoFire.whenPressed(new AutoFire(m_stage1, m_stage2, m_shooter));
    //autoFire.whenReleased(new ShooterOff(m_shooter));
    //autoFire.whenReleased(new Stage1Off(m_stage1));
    //autoFire.whenReleased(new Stage2Off(m_stage2));

    clearShooter.whenPressed(new ClearAll(m_stage1, m_stage2, m_shooter));
    clearShooter.whenReleased(new ShooterOff(m_shooter));
    clearShooter.whenReleased(new Stage1Off(m_stage1));
    clearShooter.whenReleased(new Stage2Off(m_stage2));

    autoIntake.whenPressed(new AutoIntake(m_intake, m_stage1, m_stage2));
    autoIntake.whenReleased(new IntakeOff(m_intake));
    autoIntake.whenReleased(new Stage1Off(m_stage1));
    autoIntake.whenReleased(new Stage2Off(m_stage2));

    outTake.whenPressed(new Stage1Reverse(m_stage1));
    outTake.whenPressed(new IntakeReverse(m_intake));
    outTake.whenReleased(new Stage1Off(m_stage1));
    outTake.whenReleased(new IntakeOff(m_intake));

    limelight.whenPressed(new DriveLimeLight(m_piboticsdrive, m_limelight));
    limelight.whenPressed(new ShooterOn(m_shooter));
    limelight.whenReleased(new BrakeOff(m_piboticsdrive));
    limelight.whenReleased(new GetLimelight(m_limelight));

    toggleFrontClimb.whenPressed(new ToggleFrontClimb(m_climb));
    toggleRearClimb.whenPressed(new ToggleRearClimb(m_climb));
    togglePivotClimb.whenPressed(new TogglePivotClimb(m_climb));

    //ToggleLimelight.whenPressed(new ToggleLimelight(m_limelight));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
