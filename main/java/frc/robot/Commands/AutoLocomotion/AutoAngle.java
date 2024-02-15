package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;

public class AutoAngle extends CommandBase {
    private PIDController pid = new PIDController(Constants.AUTOANGLE_kP,
            Constants.AUTOANGLE_kI, Constants.AUTOANGLE_kD);
    private DriveSubsystem drive;
    private double setpoint = 0;
    private double spd = 0;
    private double angle = 0;
    double power[] = { 0, 0 };

    public AutoAngle(DriveSubsystem drive, double setpoint) {
        this.drive = drive;
        this.setpoint = setpoint;
    }

    @Override
    public void initialize() {
        pid.setSetpoint(setpoint);
        pid.setTolerance(10);
    }

    @Override
    public void execute() {
        angle = drive.gyro.getAngle();
        spd = pid.calculate(angle);
        SmartDashboard.putNumber("Angle", angle);
        SmartDashboard.putNumber("PID", spd);
        SmartDashboard.putNumber("Error", pid.getPositionError());
        SmartDashboard.putNumber("I Value", pid.getI());
        SmartDashboard.putNumber("P Value", pid.getP());
        SmartDashboard.putNumber("D Value", pid.getD());
        SmartDashboard.putString("Command Stts", "Angle Executing");
        power[0] = spd;
        power[1] = -spd;
        drive.setPower(power);
    }

    @Override
    public void end(boolean interrupted) {
        drive.motorPower(0, 0);
        drive.gyro.reset();
    }

    @Override
    public boolean isFinished() {
        return pid.atSetpoint();
    }

}
