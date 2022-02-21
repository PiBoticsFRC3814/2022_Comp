/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import java.lang.Math;

public class Limelight extends SubsystemBase {
  /**
   * Creates a new Limelight.
   */
  public double yaw, z, target;
  public boolean position = false;
  public boolean light = false;
  public double cameraAngle = 0;
  public static double distanceShort = 0;
  public static double distanceLong = 0;
  public static int closest = 0;


  public Limelight() {
  }

  public void getData(double gyroAngle) {
    cameraAngle = Constants.limeAngle;
    z = (Constants.targetHeight - Constants.limeHeight) / (Math.tan(Math.toRadians(cameraAngle + NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0.0))));
    yaw = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0.0);
    target = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0.0);
  }

  public boolean isValidTarget() {
    if (target == 0.0)
    {
       return false;
    }
   else
    {
      return true;
    }
  }

  public void offLight() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
    light = false;
  }

  public void onLight() {
    NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
    light = true;

  }

  public boolean isInPosition() {
    return position;
  }

  public void displayOutput(double gyro) {
    getData(gyro);
    SmartDashboard.putNumber("Distance", z);
    SmartDashboard.putNumber("Yaw", yaw);
    SmartDashboard.putNumber("Gyro Angle", gyro);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}