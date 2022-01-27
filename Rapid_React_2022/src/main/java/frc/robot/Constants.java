// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //motor ids
    public static final int intakeId = 20;
    public static final int stage1Id = 21;
    public static final int stage2Id = 22;
    public static final int shooterId = 30;

    //motor speeds
    public static final double intakeSpeed = 1.0;
    public static final double stage1Speed = 1.0;
    public static final double stage2Speed = 1.0;

    //shooter PID
    public static final double kP = 6e-5; 
    public static final double kI = 0;
    public static final double kD = 0; 
    public static final double kIz = 0; 
    public static final double kFF = 0.000015; 
    public static final double kMaxOutput = 1; 
    public static final double kMinOutput = -1;
    public static final double targetRPM = 5700;
    public static final double RPMtolerance = 50;
}
