

package frc.robot.Subsystems.ScoreSystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class CaptureSubsytem extends SubsystemBase {
  CANSparkMax upMotor;
  VictorSPX upMotor2;
  
  public CaptureSubsytem() {
    upMotor= new CANSparkMax(Constants.MOTOR_UP_CAPTURE_ID, MotorType.kBrushless);
    upMotor2 = new VictorSPX(Constants.MOTOR_UP_CAPTURE_2_ID);
    initMotors();
}

public void getNote(){
    upMotor.set(Constants.kNormalSpd);
    upMotor2.set(ControlMode.PercentOutput, Constants.kNormalSpd);

}
public void getOff(){
  upMotor.set(0);
  upMotor2.set(ControlMode.PercentOutput, 0);
}

private void initMotors (){
upMotor.setInverted(false);
upMotor2.setInverted(false);




}
}
