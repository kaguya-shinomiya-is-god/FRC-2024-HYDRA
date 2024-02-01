package frc.robot;

public final class Constants {
    public static final int MOTOR_RIGHT_ID = 2;
    public static final int MOTOR_LEFT_ID = 4;
    public static final int MOTOR_RIGHT2_ID = 1;
    public static final int MOTOR_LEFT2_ID = 3;

    //Error in `/usr/local/frc/JRE/bin/java': free(): invalid next size (fast): 0xa97e6ac0

    public static final int MOTOR_ANG_ID = -1;


    public static final int MOTOR_DOWN_LAUCHER_ID = 7;
    public static final int MOTOR_UP1_LAUNCHER_ID = 8;
    public static final int MOTOR_UP2_LAUNCHER_ID = 9;


    public static final int MOTOR_DOWN_CAPTURE_ID = 10;
    public static final int MOTOR_UP_CAPTURE_ID = 5;

    public static final int SOLENOID_CLIMBING_FOWARD_ID = 15;
    public static final int SOLENOID_CLIMBING_BACK_ID = 8;

    public static final int CONTROLE1_ID = 0;
    public static final int CONTROLE2_ID = 1;

    public static final int ENCODER_A_PORT = 0;
    public static final int ENCODER_B_PORT = 1;
    
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

    public static final int STICK_X = 0;
    public static final int STICK_Y = 1;
    public static final int RIGHT_STICK_X = 4;
    public static final int RIGHT_STICK_y = 5;

    public static final double kFastSpd = 1;
    public static final double kNormalSpd = 0.5;
    public static final double kSlowSpd = 0.25;
    public static final double kShootSpd = 0.8;


    public static final double AUTOANGLE_kP = 0;
    public static final double AUTOANGLE_kI = 0;
    public static final double AUTOANGLE_kD = 0;

    public static final double AUTOMOVE_kP = 0.002;
    public static final double AUTOMOVE_kI = 0.0000001;
    public static final double AUTOMOVE_kD = 0.0001;

    public static final double WHEELS_CIRCUNFERENCE = 47.87;
    public static final double CHASSIS_WIDTH = 82.75;
    public static final double CHASSIS_HEIGHT = 77.5;
    public static final double CHASSIS_DIAGONAL = Math.sqrt(Math.pow(CHASSIS_WIDTH,2)+
                                                            Math.pow(CHASSIS_HEIGHT,2));
    public static final double CHASSIS_CIRCUNFERENCE = CHASSIS_DIAGONAL * Math.PI;
    public static final double CHASSIS_COMPLETE_ROTATION = CHASSIS_CIRCUNFERENCE / WHEELS_CIRCUNFERENCE;
       
}