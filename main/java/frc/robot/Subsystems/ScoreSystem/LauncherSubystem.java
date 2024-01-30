package frc.robot.Subsystems.ScoreSystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class LauncherSubystem extends SubsystemBase{
    VictorSPX downMotor = new VictorSPX(Constants.MOTOR_DOWN_LAUCHER_ID);

    VictorSPX up1Motor = new VictorSPX(Constants.MOTOR_UP1_LAUNCHER_ID);
    VictorSPX up2Motor = new VictorSPX(Constants.MOTOR_UP2_LAUNCHER_ID);

    public LauncherSubystem(){
        initMotors();
    }

    private void initMotors(){
        downMotor.setInverted(false);
        up1Motor.setInverted(true);
        up2Motor.setInverted(true);
        up2Motor.follow(up1Motor);
        downMotor.follow(up1Motor);
    }

    public void launcherSpeaker(){
        up1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
    }

    public void launcherReturn(){
        up1Motor.set(ControlMode.PercentOutput, -Constants.kShootSpd/2);
    }

    public void launcherAmp(){
        up1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/4);
    }

    public void launcherShooterOff(){
        up1Motor.set(ControlMode.PercentOutput, 0);
    }
}
