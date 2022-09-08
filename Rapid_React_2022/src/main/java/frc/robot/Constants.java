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
    //Solenoid ID
    public static final int fire1 = 0;
    public static final int fire2 = 1;
    public static final int pcm = 1;
    //Talon IDs
    public static final int lf = 10;
    public static final int lr = 12;
    public static final int rf = 11;
    public static final int rr = 13;
    public static final int ShooterMotor = 20;
    //Deadzone
    public static final double deadzoneX = 0.2;
    public static final double deadzoneY = 0.2;
    public static final double deadzoneZ = 0.2;
    //Joystick IDs
    public static final int driverStick = 0;

}
