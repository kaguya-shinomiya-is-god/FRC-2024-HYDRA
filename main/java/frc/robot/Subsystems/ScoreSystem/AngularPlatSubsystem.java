package frc.robot.Subsystems.ScoreSystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AngularPlatSubsystem extends SubsystemBase {
    CANSparkMax angMotor;
    RelativeEncoder coder;
    double encoderValue; // must be in degrees

    public AngularPlatSubsystem() {
        angMotor = new CANSparkMax(Constants.MOTOR_ANG_ID, MotorType.kBrushless);
        coder = angMotor.getAlternateEncoder(1);
    }

    @Override
    public void periodic() {
        encoderValue = angMotor.getEncoder().getPosition();
        SmartDashboard.putNumber("encode",encoderValue);
    }

    public double encoderValue() {
        return encoderValue;
    }

    public void angleSet(double angle) {
        if (encoderValue() < -2)
            angMotor.set(Math.abs(0.15));
        else
            angMotor.set(0);
    }

    public void bruteSetVerse() {
        angMotor.set(0.15);
    }

    public void bruteSetReverse() {
        angMotor.set(-0.15);
    }

    public void bruteSetOff() {
        angMotor.set(-0.03);
    }

}