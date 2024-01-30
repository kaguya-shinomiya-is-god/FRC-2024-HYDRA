
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.Joysticks.*;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.ScoreSystem.*;

public class RobotContainer {

  public Joystick driverController = new Joystick(Constants.CONTROLE1_ID);
  public Joystick systemsController = new Joystick(Constants.CONTROLE2_ID);

  private static DriveSubsystem robotDrive = new DriveSubsystem();
  
  //private static AngularPlatSubsystem AngSub = new AngularPlatSubsystem();
  private static CaptureSubsytem capture = new CaptureSubsytem();
  //private static ClimbSubystem EscaladaSub = new ClimbSubystem();
  private static LauncherSubystem shooter = new LauncherSubystem();

  //private static LimelightSubsystem limelightSub = new LimelightSubsystem();
  //private static GyroSubsystem gyro = new GyroSubsystem();
  //private static CameraSubsystem cam = new CameraSubsystem();

  SendableChooser<Command> m_chooser = new SendableChooser<>();
  
  double spd = 0.75;
  
  
  public RobotContainer() {
                                                                                                                                                                                                                                                                                                                                                                 
    configureButtonBindings();
    robotDrive.setDefaultCommand(
      new DefaultDrive(robotDrive, driverController));

  }

  private void configureButtonBindings() {
    // CONFIGURAR O QUE CADA BOTÃO FAZ

    new JoystickButton(systemsController, Constants.BUTTON_A)
      .onTrue(new InstantCommand(() -> capture.getNote()))
      .onFalse(new InstantCommand(() -> capture.getOff()));

    new JoystickButton(systemsController, Constants.BUTTON_X)
      .onTrue(new InstantCommand(() -> shooter.launcherSpeaker()))
      .onFalse(new InstantCommand(() -> shooter.launcherShooterOff()));

    new JoystickButton(systemsController, Constants.BUTTON_B)
      .onTrue(new InstantCommand(() -> shooter.launcherAmp()))
      .onFalse(new InstantCommand(() -> shooter.launcherShooterOff()));


  }

  public Command getAutonomousCommand(){
    return null;
  }

}