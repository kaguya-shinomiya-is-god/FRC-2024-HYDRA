package frc.robot.Commands.AutoLocomotion;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Sensors.CameraSubsystem;

public class CameraServer extends CommandBase {
  private final CameraSubsystem m_subsystem;

  
  public CameraServer(CameraSubsystem subsystem) {
    m_subsystem = subsystem;
    addRequirements(subsystem);
  }
 
  @Override
  public void initialize() {
    m_subsystem.m_visionThread.setDaemon(true);
    m_subsystem.m_visionThread.start();
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
