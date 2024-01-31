package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;

public class AutoMove extends CommandBase{

    DriveSubsystem driver;
    private PIDController pid = new PIDController(Constants.AUTOMOVE_kP, 
    Constants.AUTOMOVE_kI, Constants.AUTOMOVE_kD);
    Encoder encoder;
    private double setpoint = 0;

    public AutoMove(DriveSubsystem driver, Encoder encoder, double setpoint){
        encoder.reset();
        this.driver = driver;
        this.encoder = encoder;
        this.setpoint = setpoint;
        addRequirements(driver);
    }

    @Override
    public void initialize() {
        pid.setSetpoint(setpoint);
    }

    @Override
    public void execute() {
        SmartDashboard.putNumber("Error", pid.getPositionError());
        SmartDashboard.putNumber("PID", pid.calculate(encoder.getDistance()));
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return pid.atSetpoint();
    }

    
}
