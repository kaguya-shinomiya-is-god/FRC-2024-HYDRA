// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

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
import frc.robot.Subsystems.*;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.Sensors.LimelightSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public Joystick driverController = new Joystick(Constants.CONTROLE1_ID);
  public Joystick systemsController = new Joystick(Constants.CONTROLE2_ID);
  private static DriveSubsystem robotDrive = new DriveSubsystem();
  private static LimelightSubsystem limelight = new LimelightSubsystem();
  //private static CameraSubsystem cam = new CameraSubsystem();
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  JoystickButton lb = new JoystickButton(driverController, 5);
  double spd = 0.75;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure                                                                                                                                                                                                                                                                                                                                                               the button bindings
    configureButtonBindings();
    robotDrive.setDefaultCommand(new DefaultDrive(robotDrive, driverController));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link Joystick}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // CONFIGURAR O QUE CADA BOTÃO FAZ

    // .whenPressed() para o comando só ser executado com o botão pressionado
    // .whenActive() para o comando continuar executando mesmo após soltar o botão
    // TAMBÉM TEM O .while(Active,etc...) TESTAR
  }

  public Command getAutonomousCommand(){
    return new ATFinder(limelight, robotDrive);
  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   * 
   * @return the command to run in autonomous
   */
  // public Command getAutonomousCommand() {
  //   // An ExampleCommand will run in autonomous
  // }
}