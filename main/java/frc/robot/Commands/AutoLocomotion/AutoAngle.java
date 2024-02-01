package frc.robot.Commands.AutoLocomotion;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;

public class AutoAngle extends CommandBase{
    private PIDController pid = new PIDController(Constants.AUTOANGLE_kP, 
        Constants.AUTOANGLE_kI, Constants.AUTOANGLE_kD);
    private AHRS ahrs;
    private DriveSubsystem drive;
    private double setpoint = 0;

    public AutoAngle(DriveSubsystem drive, AHRS ahrs, double setpoint){
        this.drive = drive;
        this.ahrs = ahrs;
        this.setpoint = setpoint;
    }

    @Override
    public void initialize(){
        pid.setSetpoint(setpoint);
        ahrs.reset();
    }

    @Override
    public void execute(){
        drive.motorPower(0,pid.calculate(ahrs.getAngle()));
    }

    @Override
    public void end(boolean interrupted){
        drive.motorPower(0,0);
    }

    @Override
    public boolean isFinished(){
        return pid.atSetpoint();
    }

    
}
