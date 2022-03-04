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
    public static final int intakeId = 23;
    public static final int stage1Id = 21;
    public static final int stage2Id = 22;
    public static final int shooterId = 20;

    //sensor channel
    public static final int stage1Channel = 0;
    public static final int stage2Channel = 1;

    //motor speeds
    public static final double intakeSpeed = -1.0;
    public static final double stage1Speed = -1.0;
    public static final double stage2Speed = -1.0;

    //shooter PID
    public static final double kP = 2e-4; 
    public static final double kI = 1e-7;
    public static final double kD = 0; 
    public static final double kIz = 0; 
    public static final double kFF = 0.00014; 
    public static final double kMaxOutput = 1.0; 
    public static final double kMinOutput = 0.1;
    public static final double targetRPM = 2000;
    public static final double RPMtolerance = 50;

    //shooter delay
    public static final double shootDelay = 0.2;
      

    //drive train ids
    public static final int lf = 10;
    public static final int rf = 11;
    public static final int lr = 12;
    public static final int rr = 13;

    //joysticks
    public static final int ds = 0;
    public static final int os = 2;

    //LimeLight variables
    public static final double limeAngle = 58.0;
    public static final double targetHeight = 104.0;
    public static final double limeHeight = 21.5;
    public static final double distanceLowest = 84.0;
    public static final double distanceFarthest = 90.0;

    //pnuematics 
    public static final int frontExtend = 2;
    public static final int rearExtend = 5;
    public static final int pivotLeftExtend = 6;
    public static final int pivotRightExtend = 0;

    public static final int frontRetract = 4;
    public static final int rearRetract = 7 ;
    public static final int pivotLeftRetract = 3;
    public static final int pivotRightRetract = 1;
}
