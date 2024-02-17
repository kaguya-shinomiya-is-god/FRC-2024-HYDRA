package frc.robot.Subsystems.ScoreSystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Utils.ShuffleBoardClass;
import frc.robot.Utils.SystemDriver;


public class LauncherSubystem extends SubsystemBase{

    VictorSPX down1Motor = new VictorSPX(Constants.MOTOR_DOWN1_LAUCHER_ID);
    VictorSPX down2Motor = new VictorSPX(Constants.MOTOR_DOWN2_LAUCHER_ID);

    VictorSPX medium1Motor = new VictorSPX(Constants.MOTOR_MEDIUM1_LAUCHER_ID);
    VictorSPX medium2Motor = new VictorSPX(Constants.MOTOR_MEDIUM2_LAUCHER_ID);
    VictorSPX medium3Motor = new VictorSPX(Constants.MOTOR_MEDIUM3_LAUCHER_ID);
    VictorSPX medium4Motor = new VictorSPX(Constants.MOTOR_MEDIUM4_LAUCHER_ID);

    //VictorSPX up1Motor = new VictorSPX(Constants.MOTOR_UP1_LAUNCHER_ID);
    CANSparkMax up1Motor = new CANSparkMax(Constants.MOTOR_UP1_LAUNCHER_ID, MotorType.kBrushless);
    VictorSPX up2Motor = new VictorSPX(Constants.MOTOR_UP2_LAUNCHER_ID);

    private SystemDriver sysdriver = new SystemDriver();

    private boolean speaker, on;

    public LauncherSubystem(){
        initMotors();
        initShuffleboard();
    }

    private void initMotors(){
        down1Motor.setInverted(true);
        down2Motor.setInverted(true);
        up1Motor.setInverted(true);
        medium1Motor.setInverted(true);
        medium3Motor.setInverted(true);

        down2Motor.follow(down1Motor);
        medium2Motor.follow(medium1Motor);
        medium4Motor.follow(medium3Motor);
    }

    @Override
    public void periodic(){
        up1Motor.set(up2Motor.getMotorOutputPercent());
    }

    public void launcherSpeaker(){
        up2Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
        medium1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
        medium3Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
        down1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
        speaker = true;
        on = true;
    }

    public void launcherReturn(){
        up2Motor.set(ControlMode.PercentOutput, -Constants.kShootSpd/2);
        
    }

    public void launcherAmp(){
        up2Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/4);
        medium1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/4);
        medium3Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/4);
        down1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/4);
        speaker = false;
        on = true;
    }

    public void launcherShooterOff(){
        up2Motor.set(ControlMode.PercentOutput, 0);
        medium1Motor.set(ControlMode.PercentOutput, 0);
        medium3Motor.set(ControlMode.PercentOutput, 0);
        down1Motor.set(ControlMode.PercentOutput, 0);
        on = false;
    }

    public void launcherCapSync(){
        medium3Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/3);
        down1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/3);
        on = true;
    }

    private void initShuffleboard(){
        ShuffleBoardClass.getSensors().add("Launcher Status", sysdriver.whichLauncherIsOn(speaker, on));
    }
}
