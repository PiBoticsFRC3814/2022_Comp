// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.ADIS16470_IMU;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.AutonTest;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.FlyWheelToggle;
import frc.robot.commands.GyroReset;
import frc.robot.commands.PiboticsDrive;
import frc.robot.commands.PistonFire;
import frc.robot.commands.PistonUnfire;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.FiringPin;
import frc.robot.subsystems.FlyWheel;
import frc.robot.subsystems.RecordJoystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */



public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ADIS16470_IMU gyro = new ADIS16470_IMU();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();


  private final DriveTrain m_driveTrain = new DriveTrain();
  private final FiringPin m_firingPin = new FiringPin();
  private final FlyWheel m_flyWheel = new FlyWheel();
  public final RecordJoystick m_recordJoystick = new RecordJoystick();

  Joystick driveStick = new Joystick(Constants.driverStick);
  private final AutonTest m_autoCommand = new AutonTest(m_driveTrain, m_recordJoystick, gyro);



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    m_driveTrain.setDefaultCommand(new PiboticsDrive(() -> driveStick.getY(), () -> driveStick.getX(), () -> driveStick.getZ(), gyro, m_driveTrain, m_recordJoystick));
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton fire = new JoystickButton(driveStick, 1);
    JoystickButton arm = new JoystickButton(driveStick, 2);
    JoystickButton reset = new JoystickButton(driveStick, 3);

    fire.whenPressed(new PistonFire(m_firingPin));
    fire.whenReleased(new PistonUnfire(m_firingPin));

    arm.whenPressed(new FlyWheelToggle(m_flyWheel));

    reset.whenPressed(new GyroReset(gyro));
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