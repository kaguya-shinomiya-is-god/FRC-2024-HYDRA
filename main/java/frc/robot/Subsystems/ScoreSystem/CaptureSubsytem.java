package frc.robot.Subsystems.ScoreSystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class CaptureSubsytem extends SubsystemBase {
  CANSparkMax downMotor;
  VictorSPX upMotor;
  
  
  public CaptureSubsytem() {
    downMotor = new CANSparkMax(Constants.MOTOR_DOWN_CAPTURE_ID, MotorType.kBrushless);
    upMotor= new VictorSPX(Constants.MOTOR_UP_CAPTURE_ID);
    initMotors();
  }

public void getNote(){
  downMotor.set((0.3));
  upMotor.set(ControlMode.PercentOutput, (1));
}

public void spitNote(){
  downMotor.set(-(0.3));
  upMotor.set(ControlMode.PercentOutput, -(1));
}

public void getOff(){
  downMotor.set((0));
  upMotor.set(ControlMode.PercentOutput, (0));
}

private void initMotors (){
downMotor.setInverted(false);
upMotor.setInverted(true);
}



}
