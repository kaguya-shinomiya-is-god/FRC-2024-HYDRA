

package frc.robot.Subsystems.ScoreSystem;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class CaptureSubsytem extends SubsystemBase {
  CANSparkMax downMotor, upMotor;
  
  
  public CaptureSubsytem() {
    downMotor = new CANSparkMax(Constants.MOTOR_DOWN_CAPTURE_ID, MotorType.kBrushless);
    upMotor= new CANSparkMax(Constants.MOTOR_UP_CAPTURE_ID, MotorType.kBrushless);
    initMotors();
   
}

public void getNote(){
  upMotor.set(Constants.kNormalSpd);
}

public void getOff(){
  upMotor.set(0);
}

private void initMotors (){
downMotor.setInverted(false);
upMotor.setInverted(false);
upMotor.follow(downMotor);

}


}
