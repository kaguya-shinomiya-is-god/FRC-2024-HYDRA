package frc.robot.Subsystems.ScoreSystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;
import frc.robot.Utils.ShuffleBoardClass;

public class CaptureSubsytem extends SubsystemBase {
  CANSparkMax downMotor;
  VictorSPX upMotor;
  private DigitalInput noteSwitch;
  private boolean load = false;

  public CaptureSubsytem() {
    downMotor = new CANSparkMax(Constants.MOTOR_DOWN_CAPTURE_ID, MotorType.kBrushless);
    upMotor = new VictorSPX(Constants.MOTOR_UP_CAPTURE_ID);
    noteSwitch = new DigitalInput(Constants.NOTE_SWITCH_DIO);
    initMotors();
    initShuffleboard();
  }

  @Override
  public void periodic(){
    load = noteSwitch.get();
    SmartDashboard.putBoolean("note", load);
  }

  public void getNote() {
    downMotor.set((0.3));
    upMotor.set(ControlMode.PercentOutput, (1));
  }

  public void spitNote() {
    downMotor.set(-(0.3));
    upMotor.set(ControlMode.PercentOutput, -(1));
  }

  public void getOff() {
    downMotor.set((0));
    upMotor.set(ControlMode.PercentOutput, (0));
  }

  private void initMotors() {
    downMotor.setInverted(false);
    upMotor.setInverted(false);
  }

  public boolean noteIsOn(){
    return noteSwitch.get();
  }

  private void initShuffleboard() {
    ShuffleBoardClass.getSensors().add("Note Is On?", noteIsOn());
  }

}
