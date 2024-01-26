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
  setMotors(1);
}

public void spitNote(){
  setMotors(-1);
}

public void getOff(){
  setMotors(0);
}

private void initMotors (){
downMotor.setInverted(false);
upMotor.setInverted(true);
}

private void setMotors(double x){
  downMotor.set((0.3 * x));
  upMotor.set(ControlMode.PercentOutput, (1 * x));
}



}
