package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import frc.robot.Constants;


public class LauncherSubystem {
    VictorSPX downMotor = new VictorSPX(Constants.MOTOR_DOWN_LAUCHER_ID);

    VictorSPX up1Motor = new VictorSPX(Constants.MOTOR_UP1_LAUNCHER_ID);
    VictorSPX up2Motor = new VictorSPX(Constants.MOTOR_UP2_LAUNCHER_ID);

    public LauncherSubystem(){
        initMotors();
    }

    private void initMotors(){
        downMotor.setInverted(false);
        up1Motor.setInverted(true);
        up2Motor.setInverted(false);
        up2Motor.follow(up1Motor);
    }
}
