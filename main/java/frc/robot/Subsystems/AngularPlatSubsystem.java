package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class AngularPlatSubsystem {
    CANSparkMax angMotor;
    double encoderValue;

    public AngularPlatSubsystem(int angMotorID){
        angMotor = new CANSparkMax(angMotorID, MotorType.kBrushless);
    }

    public void encoderUpdate(){
        encoderValue = angMotor.getEncoder().getPosition();
    }
}
