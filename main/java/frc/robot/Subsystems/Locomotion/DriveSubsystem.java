// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems.Locomotion;

import java.util.Map;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Utils.Driver;
import frc.robot.Utils.ShuffleBoardClass;
import edu.wpi.first.wpilibj.SPI;

public class DriveSubsystem extends SubsystemBase {
  private VictorSPX motor_right = new VictorSPX(Constants.MOTOR_RIGHT_ID);
  private VictorSPX motor_right2 = new VictorSPX(Constants.MOTOR_RIGHT2_ID);
  private VictorSPX motor_left = new VictorSPX(Constants.MOTOR_LEFT_ID);
  private VictorSPX motor_left2 = new VictorSPX(Constants.MOTOR_LEFT2_ID);

  private AnalogInput ultrasonic = new AnalogInput(0);
  private double ultrasonicRange = 0;

  public AHRS gyro = new AHRS(Port.kMXP);
  
  public Encoder encoder = new Encoder(Constants.ENCODER_A_PORT, Constants.ENCODER_B_PORT);

  public AHRS navx = new AHRS(SPI.Port.kMXP);
  private Driver m_Driver;
  private Timer timer = new Timer();
  double powers[] = {0,0};
  public int secondaryIndex = 0;
  public int index = 0;
  
  /** Creates a new DriveTrain. */
  public DriveSubsystem() {
    init_motors();
    gyro.reset();
    encoder.reset();
    initShuffleBoard();
  }

  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    ultrasonicRange = (ultrasonic.getValue() * (5/RobotController.getVoltage5V()))/8;
    SmartDashboard.putNumber("Motor Left", powers[0]);
    SmartDashboard.putNumber("Motor Right", powers[1]);
    SmartDashboard.putNumber("Angle", gyro.getAngle());
    SmartDashboard.putNumber("Encoder", encoder.getDistance());

  }

  @Override
  public void simulationPeriodic() {
  }
 
  public void defaultDrive(double leftStickX, double leftStickY,double rightStickX,double rightStickY, double lt, double rt,double spd){
    m_Driver = new Driver(leftStickX, leftStickY,rightStickX,rightStickY, lt, rt);
    powers = m_Driver.drive();
    powers[0] *= spd;
    powers[1] *= spd;
    powers[0] = minMethod(powers[0],spd);
    powers[1] = minMethod(powers[1],spd);
    setPower(powers);
  }

  public double minMethod(double a, double b) {
    if (Math.abs(a) > b){
      a = Math.copySign(b, a);
    }
    else if (Math.abs(a) < 0.04){
      return 0;
    }  
    return a;
  }

  public void motorPower(double mL, double mR){
    double[] motorVector = {mL,mR};
    setPower(motorVector);
  }
  
  public void setPower(double powers[]){
    if(powers[0] == 0 && powers[1] == 0){
      timer.reset();
    }
    double t1 = timer.get()*2;
    t1 = (t1>=1) ? 1: t1;    
    this.motor_left.set(ControlMode.PercentOutput,powers[0]);
    this.motor_left2.set(ControlMode.PercentOutput, powers[0]);
    this.motor_right.set(ControlMode.PercentOutput,powers[1]);
    this.motor_right2.set(ControlMode.PercentOutput,powers[1]);
  }

  private void init_motors(){
    // this.motor_right2.follow(motor_right);
    // this.motor_left2.follow(motor_left);
    this.motor_left.setInverted(false);
    this.motor_left2.setInverted(false);
    this.motor_right.setInverted(true);
    this.motor_right2.setInverted(true);
    this.motor_right.configNeutralDeadband(0.04);
    this.motor_left.configNeutralDeadband(0.04);
    this.motor_left.setNeutralMode(NeutralMode.Brake);
    this.motor_right.setNeutralMode(NeutralMode.Brake);
    this.motor_left2.setNeutralMode(NeutralMode.Brake);
    this.motor_right2.setNeutralMode(NeutralMode.Brake);
  }

  public void initShuffleBoard(){

    ShuffleBoardClass.LocomotionTab.
                      add("LM", powers[0]).
                      withWidget(BuiltInWidgets.kDial).
                      withProperties(Map.of("min", -1, "max", 1));
    
    ShuffleBoardClass.LocomotionTab.
                      add("RM", powers[1]). 
                      withWidget(BuiltInWidgets.kDial). 
                      withProperties(Map.of("min", -1, "max", 1));

    ShuffleBoardClass.LocomotionTab.
                      add("Angle", gyro.getAngle()).
                      withWidget(BuiltInWidgets.kGyro);

    ShuffleBoardClass.LocomotionTab.
                      add("Encoder", encoder).
                      withWidget(BuiltInWidgets.kEncoder);
    
                    
  }

  public double getUltrasonicDistance(){
    return ultrasonicRange;
  }
 
  
}