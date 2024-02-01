package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;

public class AutoMove extends CommandBase{

    DriveSubsystem driver;
    private PIDController pid = new PIDController(Constants.AUTOMOVE_kP, Constants.AUTOMOVE_kI, Constants.AUTOMOVE_kD);
    private Encoder encoder;
    private double setpoint = 0;
    private double spd = 0;

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
        spd = pid.calculate(encoder.getDistance());
        driver.motorPower(spd,spd);
    }

    @Override
    public void end(boolean interrupted) {
        driver.motorPower(0, 0);
    }

    @Override
    public boolean isFinished() {
        return pid.atSetpoint();
    }

    
}
