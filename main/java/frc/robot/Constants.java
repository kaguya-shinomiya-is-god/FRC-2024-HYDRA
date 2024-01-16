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
    public static final int MOTOR_RIGHT_ID = 2;
    public static final int MOTOR_LEFT_ID = 4;
    public static final int MOTOR_RIGHT2_ID = 1;
    public static final int MOTOR_LEFT2_ID = 3;
    public static final int MOTOR_ANG_ID = -1;
    public static final int MOTOR_DOWN_LAUCHER_ID = -1;
    public static final int MOTOR_UP1_LAUNCHER_ID = -1;
    public static final int MOTOR_UP2_LAUNCHER_ID = -1;
    public static final int SOLENOID_CLIMBING_FOWARD_ID = 15;
    public static final int SOLENOID_CLIMBING_BACK_ID = 8;

    public static final int CONTROLE1_ID = 0;
    public static final int CONTROLE2_ID = 1;
    public static final int STICK_X = 0;
    public static final int STICK_Y = 1;
    public static final int RIGHT_STICK_X = 4;
    public static final int RIGHT_STICK_y = 5;
    public static final int LT = 2;
    public static final int RT = 3;
    public static final int RB = 6;
    public static final int LB = 5;
    public static final int BUTTON_A = 1;
    public static final int BUTTON_B = 2;
    public static final int BUTTON_X = 3;
    public static final int BUTTON_Y = 4;
    public static final int AXIS_LT = 2;
    public static final int AXIS_RT = 3;

    public static final double kFastSpd = 1;
    public static final double kNormalSpd = 0.5;
    public static final double kSlowSpd = 0.25;
}