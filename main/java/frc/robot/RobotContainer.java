
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Commands.*;
import frc.robot.Commands.AutoLocomotion.*;
import frc.robot.Commands.Joysticks.*;
import frc.robot.Subsystems.*;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.ScoreSystem.*;
import frc.robot.Subsystems.Sensors.*;

public class RobotContainer {

  public Joystick driverController = new Joystick(Constants.CONTROLE1_ID);
  public Joystick systemsController = new Joystick(Constants.CONTROLE2_ID);

  private static DriveSubsystem robotDrive = new DriveSubsystem();
  
  private static AngularPlatSubsystem AngSub = new AngularPlatSubsystem();
  private static CaptureSubsytem ColetaSub = new CaptureSubsytem();
  private static ClimbSubystem EscaladaSub = new ClimbSubystem();
  private static LauncherSubystem LancamentoSub = new LauncherSubystem();

  private static LimelightSubsystem limelightSub = new LimelightSubsystem();
  private static GyroSubsystem gyro = new GyroSubsystem();
  private static EncoderSubsytem encoder = new EncoderSubsytem();
  private static CameraSubsystem cam = new CameraSubsystem();

  SendableChooser<Command> m_chooser = new SendableChooser<>();
  
  double spd = 0.75;
  
  
  public RobotContainer() {
                                                                                                                                                                                                                                                                                                                                                                 
    configureButtonBindings();
    robotDrive.setDefaultCommand(Commands.parallel(
      new DefaultDrive(robotDrive, driverController),
      new DefaultSystem(AngSub, ColetaSub, EscaladaSub, LancamentoSub, systemsController),
      new CameraServer(cam)
      ));

  }

  private void configureButtonBindings() {
    // CONFIGURAR O QUE CADA BOTÃO FAZ
  }

  public Command getAutonomousCommand(){
    return new SetToAngle(robotDrive, gyro, 45);
  }

}