package frc.robot.Commands.AutoLocomotion;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Utils.SystemDriver;

public class AutoAngleEncoder extends CommandBase {
    private PIDController pid = new PIDController(Constants.AUTOANGLE_kP,
            Constants.AUTOANGLE_kI, Constants.AUTOANGLE_kD);
    private DriveSubsystem drive;
    private double setpoint = 0;
    private double spd = 0;
    private double angle = 0;
    private SystemDriver sysdriver = new SystemDriver();

    public AutoAngleEncoder(DriveSubsystem drive, double setpoint) {
        this.drive = drive;
        this.setpoint = sysdriver.angleForRotation(setpoint);
    }

    @Override
    public void initialize() {
        pid.setSetpoint(setpoint);
        drive.encoder.setDistancePerPulse(47.87 / 2048);
    }

    @Override
    public void execute() {
        drive.secondaryIndex++;
        angle = drive.encoder.getDistance();
        spd = pid.calculate(angle);
        SmartDashboard.putNumber("Angle", angle);
        SmartDashboard.putNumber("PID", spd);
        SmartDashboard.putNumber("Setpoint", setpoint);
        SmartDashboard.putNumber("Angle Index", drive.secondaryIndex);
        drive.motorPower(spd, -spd);
    }

    @Override
    public void end(boolean interrupted) {
        drive.motorPower(0, 0);
    }

    @Override
    public boolean isFinished() {
        return pid.atSetpoint();
    }

}
