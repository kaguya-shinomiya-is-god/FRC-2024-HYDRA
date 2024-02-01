
package frc.robot;

import edu.wpi.first.hal.SimDevice;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.simulation.EncoderSim;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.AutoLocomotion.AutoMove;
import frc.robot.Commands.Joysticks.*;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.ScoreSystem.*;

public class RobotContainer {

  public Joystick driverController = new Joystick(Constants.CONTROLE1_ID);
  public Joystick systemsController = new Joystick(Constants.CONTROLE2_ID);

  private static DriveSubsystem robotDrive = new DriveSubsystem();
  
  private static AngularPlatSubsystem AngSub = new AngularPlatSubsystem();
  private static CaptureSubsytem capture = new CaptureSubsytem();
  //private static ClimbSubystem EscaladaSub = new ClimbSubystem();
  private static LauncherSubystem shooter = new LauncherSubystem();
  private static Encoder encoder = new Encoder(Constants.ENCODER_A_PORT, Constants.ENCODER_B_PORT);

  // SIM DEVICES

  //private static LimelightSubsystem limelightSub = new LimelightSubsystem();
  //private static CameraSubsystem cam = new CameraSubsystem();

  SendableChooser<Command> m_chooser = new SendableChooser<>();
  
  double spd = 0.75;
  
  
  public RobotContainer() {                                                                                                                                                                                                                                                                                                                                                           
    configureButtonBindings();
    robotDrive.setDefaultCommand(new DefaultDrive(robotDrive, driverController));
    encoder.setSamplesToAverage(5);
    encoder.setDistancePerPulse((47.87 / 2048));

  }

  private void configureButtonBindings() {

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
    return new AutoMove(robotDrive, encoder, 100);
  }

}