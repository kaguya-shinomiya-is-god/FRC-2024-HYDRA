package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

public class AngularPlatSubsystem {
    CANSparkMax angMotor;
    double encoderValue; //must be in degrees

    public AngularPlatSubsystem(){
        angMotor = new CANSparkMax(Constants.MOTOR_ANG_ID, MotorType.kBrushless);
    }

    public void encoderUpdate(){
        encoderValue = angMotor.getEncoder().getPosition();
    }

    public void angleSet(double angle){
        if(Math.abs(encoderValue) < angle) angMotor.set(Math.copySign(1, encoderValue));
        else angMotor.set(0);
    }
}
