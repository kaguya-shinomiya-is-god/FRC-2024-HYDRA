
package frc.robot;
import java.util.Set;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.AutoLocomotion.ATFinder;
import frc.robot.Commands.AutoLocomotion.AutoSequence;
import frc.robot.Commands.Joysticks.*;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.ScoreSystem.*;
import frc.robot.Subsystems.Sensors.Camera1;
import frc.robot.Subsystems.Sensors.LimelightSubsystem;

public class RobotContainer {

  public Joystick driverController = new Joystick(Constants.CONTROLE1_ID);
  public Joystick systemsController = new Joystick(Constants.CONTROLE2_ID);

  DriveSubsystem robotDrive = new DriveSubsystem();
  
  //private static AngularPlatSubsystem AngSub = new AngularPlatSubsystem();
  CaptureSubsytem capture = new CaptureSubsytem();
  ClimbSubsystem climb = new ClimbSubsystem(8,15);
  LauncherSubystem shooter = new LauncherSubystem();

  private AutoSequence autoSequence = new AutoSequence(robotDrive, 90, 180, 500);

  // SIM DEVICES

  private static LimelightSubsystem lime = new LimelightSubsystem();
  private static Camera1 cam = new Camera1();

  SendableChooser<Command> m_chooser = new SendableChooser<>();
  
  double spd = 0.75;
  
  
  public RobotContainer() {                                                                                                                                                                                                                                                                                                                                                           
    configureButtonBindings();
    robotDrive.setDefaultCommand(Commands.parallel(new DefaultDrive(robotDrive, driverController)));
    robotDrive.encoder.setSamplesToAverage(5);
    robotDrive.encoder.setDistancePerPulse((47.87 / 2048));
  }

  private void configureButtonBindings() {

    new JoystickButton(systemsController, Constants.BUTTON_A)
      .onTrue(getCaptureCommand())
      .onFalse(new InstantCommand(() -> capture.getOff()));

    new JoystickButton(systemsController, Constants.BUTTON_X)
      .onTrue(new InstantCommand(() -> shooter.launcherSpeaker()))
      .onFalse(new InstantCommand(() -> shooter.launcherShooterOff()));

    new JoystickButton(systemsController, Constants.BUTTON_B)
      .onTrue(new InstantCommand(() -> shooter.launcherAmp()))
      .onFalse(new InstantCommand(() -> shooter.launcherShooterOff()));

    new JoystickButton(systemsController, Constants.RB)
      .onTrue(new InstantCommand(() -> climb.goUP()))
      .onFalse(new InstantCommand(() -> climb.closeDoors()));

    new JoystickButton(systemsController, Constants.LB)
      .onTrue(new InstantCommand(() -> climb.goDOWN()))
      .onFalse(new InstantCommand(() -> climb.closeDoors()));


  }

  public Command getAutonomousCommand(){
    robotDrive.encoder.reset();
    robotDrive.gyro.reset();
    return autoCommand();
  }

  private ParallelCommandGroup getCaptureCommand(){
    return new ParallelCommandGroup(new InstantCommand(() -> capture.getNote()),
                                      new InstantCommand(() -> shooter.launcherCapSync()));
  }

  private Command autoCommand(){
    return new SequentialCommandGroup(new ATFinder(lime, robotDrive));
  }

}