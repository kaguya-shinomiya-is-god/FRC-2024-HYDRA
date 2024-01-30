package frc.robot.Commands.AutoLocomotion;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;

public class AutoMove extends PIDCommand{

    static Encoder encoder;
    static DriveSubsystem drive;
    static PIDController pid = new PIDController(Constants.AUTOMOVE_kP, Constants.AUTOMOVE_kI, Constants.AUTOMOVE_kD);
    private double point = 0;

    public AutoMove(double setpoint, DriveSubsystem driver, Encoder encoder) {
        super(pid, 
        () -> encoder.getDistance(), 
        () -> setpoint, 
        (output) -> drive.motorPower(0, output), 
        driver);
        addRequirements(driver);
        this.point = setpoint;
        AutoMove.encoder = encoder;
        AutoMove.drive = driver;
        encoder.reset();
    }

    @Override
    public void execute() {
        SmartDashboard.putString("STATUS MOVING", "MOVING BY" + point + " cm");
        SmartDashboard.putNumber("ENCODER DISTANCE", encoder.getDistance());
        SmartDashboard.putString("% TO CONCLUDE", ((encoder.getDistance() / point) + " %"));
        SmartDashboard.putNumber("PID CONTROLLER", pid.calculate(encoder.get(),point));
    }

    @Override
    public void end(boolean interrupted) {
        drive.motorPower(0, 0);
        SmartDashboard.putString("STATUS MOVING", "FINISHED");
    }


    @Override
    public boolean isFinished() {
        return pid.atSetpoint();
    }
    
}
