package frc.robot.Commands.Joysticks;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Utils.Driver;

public class DefaultDrive extends CommandBase {
  private final DriveSubsystem s_drive;
  private Joystick driverController;
  private double left_stickX, left_stickY,right_stickX,right_stickY, lt, rt, spd=1;
  private int pov;

  public DefaultDrive(DriveSubsystem subsystem,Joystick driverController) {
    s_drive = subsystem;
    addRequirements(s_drive);
    this.driverController = driverController;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute(){
    boolean a = driverController.getRawButton(Constants.BUTTON_A);
    boolean b = driverController.getRawButton(Constants.BUTTON_B);
    boolean x = driverController.getRawButton(Constants.BUTTON_X);
    buttonSe(a, b, x);

    this.left_stickX = driverController.getRawAxis(Constants.STICK_X);
    this.left_stickY = driverController.getRawAxis(Constants.STICK_Y);
    this.lt = driverController.getRawAxis(Constants.LT);
    this.rt = driverController.getRawAxis(Constants.RT);
    this.right_stickX = driverController.getRawAxis(Constants.RIGHT_STICK_X);
    this.right_stickY = driverController.getRawAxis(Constants.RIGHT_STICK_y);
    this.pov = driverController.getPOV();

    if(pov == -1)
      s_drive.defaultDrive(left_stickX, left_stickY,right_stickX,right_stickY, lt, rt,spd);
    else 
      s_drive.setPower(Driver.povCalc(pov,spd));
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false; 
  }

  private void buttonSe(boolean a, boolean b, boolean x){
    this.spd = x ? 1 : a ? 0.5 : b ? 0.25 : spd;
  }

  
}
