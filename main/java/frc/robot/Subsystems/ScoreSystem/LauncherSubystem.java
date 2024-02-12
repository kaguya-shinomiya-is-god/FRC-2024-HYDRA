package frc.robot.Subsystems.ScoreSystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Utils.ShuffleBoardClass;
import frc.robot.Utils.SystemDriver;


public class LauncherSubystem extends SubsystemBase{
    VictorSPX downMotor = new VictorSPX(Constants.MOTOR_DOWN_LAUCHER_ID);

    VictorSPX up1Motor = new VictorSPX(Constants.MOTOR_UP1_LAUNCHER_ID);
    VictorSPX up2Motor = new VictorSPX(Constants.MOTOR_UP2_LAUNCHER_ID);

    private SystemDriver sysdriver = new SystemDriver();

    private boolean speaker, on;

    public LauncherSubystem(){
        initMotors();
        initShuffleboard();
    }

    private void initMotors(){
        downMotor.setInverted(false);
        up1Motor.setInverted(true);
        up2Motor.setInverted(true);
        up2Motor.follow(up1Motor);
        downMotor.follow(up1Motor);
    }

    @Override
    public void periodic(){

    }

    public void launcherSpeaker(){
        up1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
        speaker = true;
        on = true;
    }

    public void launcherReturn(){
        up1Motor.set(ControlMode.PercentOutput, -Constants.kShootSpd/2);
        
    }

    public void launcherAmp(){
        up1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/4);
        speaker = false;
        on = true;
    }

    public void launcherShooterOff(){
        up1Motor.set(ControlMode.PercentOutput, 0);
        on = false;
    }

    private void initShuffleboard(){
        ShuffleBoardClass.getSensors().add("Launcher Status", sysdriver.whichLauncherIsOn(speaker, on));
    }
}
