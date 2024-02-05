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
    private double setpoint = 0;
    private double spd = 0;
    private double encoding = 0;

    public AutoMove(DriveSubsystem driver,double setpoint){
        this.driver = driver;
        this.setpoint = setpoint;
        addRequirements(driver);
    }

    @Override
    public void initialize() {
        pid.setSetpoint(setpoint);
        pid.setTolerance(10);
    }

    @Override
    public void execute() {
        encoding = driver.encoder.getDistance();
        SmartDashboard.putNumber("Error", pid.getPositionError());
        SmartDashboard.putNumber("PID", pid.calculate(encoding));
        spd = pid.calculate(encoding);
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
