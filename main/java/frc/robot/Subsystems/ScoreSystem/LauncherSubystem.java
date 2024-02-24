package frc.robot.Subsystems.ScoreSystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Utils.ShuffleBoardClass;
import frc.robot.Utils.SystemDriver;


public class LauncherSubystem extends SubsystemBase{

    VictorSPX up1Motor = new VictorSPX(Constants.MOTOR_UP1_LAUNCHER_ID);
    VictorSPX up2Motor = new VictorSPX(Constants.MOTOR_UP2_LAUNCHER_ID);

    VictorSPX medium1Motor = new VictorSPX(Constants.MOTOR_MEDIUM1_LAUCHER_ID);
    VictorSPX medium2Motor = new VictorSPX(Constants.MOTOR_MEDIUM2_LAUCHER_ID);
    VictorSPX medium3Motor = new VictorSPX(Constants.MOTOR_MEDIUM3_LAUCHER_ID);
    VictorSPX medium4Motor = new VictorSPX(Constants.MOTOR_MEDIUM4_LAUCHER_ID);

    //VictorSPX up1Motor = new VictorSPX(Constants.MOTOR_UP1_LAUNCHER_ID);
    CANSparkMax down1Motor = new CANSparkMax(Constants.MOTOR_DOWN1_LAUCHER_ID, MotorType.kBrushed);
    VictorSPX down2Motor = new VictorSPX(Constants.MOTOR_DOWN2_LAUCHER_ID);

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
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Down1Motor", down1Motor.get());
        SmartDashboard.putNumber("Down2Motor", down2Motor.getMotorOutputPercent());
        SmartDashboard.putNumber("Medium1Motor", medium1Motor.getMotorOutputPercent());
        SmartDashboard.putNumber("Medium2Motor", medium2Motor.getMotorOutputPercent());
        SmartDashboard.putNumber("Medium3Motor", medium3Motor.getMotorOutputPercent());
        SmartDashboard.putNumber("Medium4Motor", medium4Motor.getMotorOutputPercent());
        SmartDashboard.putNumber("Up1Motor", up1Motor.getMotorOutputPercent());
        SmartDashboard.putNumber("Up2Motor", up2Motor.getMotorOutputPercent());


    }

    public void launcherSpeaker(){
        launcherDelayed1();
        launcherDelayed2();
        speaker = true;
        on = true;
    }

    public void launcherReturn(){
        up1Motor.set(ControlMode.PercentOutput, -0.6);
        up2Motor.set(ControlMode.PercentOutput, -0.6);
        medium1Motor.set(ControlMode.PercentOutput, -0.6);
        medium2Motor.set(ControlMode.PercentOutput, -0.6);
        medium3Motor.set(ControlMode.PercentOutput, -0.6);
        medium4Motor.set(ControlMode.PercentOutput, -0.6);
        
    }

    public void launcherAmp(){
        up1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/3.5);
        up2Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/3.5);
        medium1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/3.5);
        medium2Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/3.5);
        medium3Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/3.5);
        medium4Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/3.5);
        down1Motor.set(Constants.kShootSpd/3.5);
        down2Motor.set(ControlMode.PercentOutput, Constants.kShootSpd/3.5);
        speaker = false;
        on = true;
    }

    public void launcherShooterOff(){
        up1Motor.set(ControlMode.PercentOutput,0);
        up2Motor.set(ControlMode.PercentOutput,0);
        medium1Motor.set(ControlMode.PercentOutput,0);
        medium2Motor.set(ControlMode.PercentOutput,0);
        medium3Motor.set(ControlMode.PercentOutput, 0);
        medium4Motor.set(ControlMode.PercentOutput,0);
        down1Motor.set(0);
        down2Motor.set(ControlMode.PercentOutput,0);
        on = false;
    }

    public void launcherDelayed1(){
        up1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
        up2Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
        medium1Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
        medium2Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
    }

    public void launcherDelayed2() {
        medium3Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
        medium4Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
        down1Motor.set(Constants.kShootSpd);
        down2Motor.set(ControlMode.PercentOutput, Constants.kShootSpd);
    }

    public void launcherCapSync(){
        down2Motor.set(ControlMode.PercentOutput, 0.5);
        down1Motor.set(0.5);
        on = true;
    }

    private void initShuffleboard(){
        ShuffleBoardClass.getSensors().add("Launcher Status", sysdriver.whichLauncherIsOn(speaker, on));
    }
}