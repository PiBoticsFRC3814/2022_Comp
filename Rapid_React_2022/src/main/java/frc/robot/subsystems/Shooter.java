// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.*;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  CANSparkMax shooter = new CANSparkMax(Constants.shooterId, MotorType.kBrushless);
  SparkMaxPIDController velocityPID;
  RelativeEncoder encoder;

  public Shooter() {
    velocityPID = shooter.getPIDController();
    encoder = shooter.getEncoder();

    shooter.setIdleMode(CANSparkMax.IdleMode.kCoast);
    shooter.setInverted(true);

    velocityPID.setP(Constants.kP);
    velocityPID.setI(Constants.kI);
    velocityPID.setD(Constants.kD);
    velocityPID.setIZone(Constants.kIz);
    velocityPID.setFF(Constants.kFF);
    velocityPID.setOutputRange(Constants.kMinOutput, Constants.kMaxOutput);
  }

  public double getSpeed(){
    return encoder.getVelocity();
  }

  public void setSpeed(double speed){
    velocityPID.setReference(speed, ControlType.kVelocity);
  }
  public void stop(){
    shooter.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
