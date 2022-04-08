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
    public static final int moveIntakeId = 24;

    //sensor channel
    public static final int stage1Channel = 2;
    public static final int stage2Channel = 1;
    public static final int upChannel = 3;
    public static final int downChannel = 4;


    //motor speeds
    public static final double intakeSpeed = -1.0;
    public static final double stage1Speed = -1.0;
    public static final double stage2Speed = -1.0;
    public static final double moveIntakeSpeed = 0.3;

    //shooter PID
    public static final double kP = 4e-4; //4e-4
    public static final double kI = 1e-6;  //1e-6
    public static final double kD = 1e-2; //1e-2
    public static final double kIz = 0;
    public static final double kFF = 1e-6; 
    public static final double kMaxOutput = 1.0;     
    public static final double kMinOutput = 0.1;
    public static final double targetRPM = 3800;
    public static final double bangRPM = 3800;
    public static final double RPMtolerance = 100;


    //shooter delay
    public static final double shootDelay = 0.5;
      

    //drive train ids
    public static final int leftdrive = 10;
    public static final int rightdrive = 11;

    //joysticks
    public static final int ds = 0;
    public static final int os = 2;

    //LimeLight variables
    public static final double limeAngle = 33.0;  // used in part of distance equations
    public static final double targetHeight = 104.0; //used in part of distance equations
    public static final double limeHeight = 21.5; //used in part of distance equations
    public static final double distanceLowest = 120.0; // used for single limelight shot location
    public static final double distanceFarthest = 130.0; // ued for sincle imelight shot location
    public static final double minimumDistacne = 0.0;  // used for automatic RPM adjustment minimumt to make the ball
    public static final double maximumDistance = 100.0; // used for automatic RPM adjustment maximum to make the ball
 
    //pnuematics 
    public static final int frontExtend = 4; //BIG
    public static final int rearExtend = 7; // Little
    public static final int pivotLeftExtend = 3; //Pivot
    public static final int pivotRightExtend = 0; //extra

    public static final int frontRetract = 2; //big
    public static final int rearRetract = 5; // little
    public static final int pivotLeftRetract = 6; //pivot
    public static final int pivotRightRetract = 1; //extra

    //Autonomous
    public static final double turnSpeed = 0.1;
    public static final double turnAngle = -160; //180
    public static final double forwardSpeed = -0.5;
    public static final double forwardTime = 1.5;
    public static final double reverseSpeed = 0.5;
    public static final double dropTime = 0.25;
    public static final int autoCount = 10;

    //Field
    public static final double hoopDiameter = 48.0;//inches
}
