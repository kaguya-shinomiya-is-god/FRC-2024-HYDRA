
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.*;
import frc.robot.Commands.AutoLocomotion.ATFinder;
import frc.robot.Commands.Joysticks.DefaultDrive;
import frc.robot.Commands.Joysticks.DefaultSystem;
import frc.robot.Subsystems.*;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.ScoreSystem.AngularPlatSubsystem;
import frc.robot.Subsystems.ScoreSystem.CaptureSubsytem;
import frc.robot.Subsystems.ScoreSystem.ClimbSubystem;
import frc.robot.Subsystems.ScoreSystem.LauncherSubystem;
import frc.robot.Subsystems.Sensors.CameraSubsystem;
import frc.robot.Subsystems.Sensors.LimelightSubsystem;

public class RobotContainer {

  public Joystick driverController = new Joystick(Constants.CONTROLE1_ID);
  public Joystick systemsController = new Joystick(Constants.CONTROLE2_ID);

  private static DriveSubsystem robotDrive = new DriveSubsystem();
  
  private static AngularPlatSubsystem AngSub = new AngularPlatSubsystem();
  private static CaptureSubsytem ColetaSub = new CaptureSubsytem();
  private static ClimbSubystem EscaladaSub = new ClimbSubystem();
  private static LauncherSubystem LancamentoSub = new LauncherSubystem();

  private static LimelightSubsystem limelightSub = new LimelightSubsystem();
  private static CameraSubsystem cam = new CameraSubsystem();

  SendableChooser<Command> m_chooser = new SendableChooser<>();
  
  double spd = 0.75;

  
  public RobotContainer() {
                                                                                                                                                                                                                                                                                                                                                                 
    configureButtonBindings();

    robotDrive.setDefaultCommand(Commands.parallel(
      new DefaultDrive(robotDrive, driverController),
      new DefaultSystem (AngSub, ColetaSub, EscaladaSub, LancamentoSub, systemsController)));

  }

  private void configureButtonBindings() {
    // CONFIGURAR O QUE CADA BOTÃO FAZ
  }

  public Command getAutonomousCommand(){
    return new ATFinder(limelightSub, robotDrive);
  }
}