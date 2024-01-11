package frc.robot.Subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngularPlatSubsystem extends SubsystemBase{
    CANSparkMax angMotor;
    double encoderValue; //must be in degrees

    public AngularPlatSubsystem(){
        angMotor = new CANSparkMax(Constants.MOTOR_ANG_ID, MotorType.kBrushless);
    }

    @Override
  public void periodic() {
        encoderValue  = angMotor.getEncoder().getPosition();
  }

    public double encoderValue(){
        return encoderValue;
    }

    public void angleSet(double angle){
        if(Math.abs(encoderValue) < angle) angMotor.set(Math.copySign(1, encoderValue));
        else angMotor.set(0);
    }
}
