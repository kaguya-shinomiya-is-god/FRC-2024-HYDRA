package frc.robot.Commands.AutoLocomotion;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.Sensors.NavX;

public class AutoAngle extends PIDCommand{
    
    public AutoAngle(PIDController controller, double goal) {

        super(new PIDController(Constants.AUTOANGLE_kP, 
        Constants.AUTOANGLE_kI, Constants.AUTOANGLE_kD), zAng, goal, output -> drive.motorPower(0, output), req);
        this.goal = goal;
        addRequirements(req);
    }

    static DriveSubsystem drive;
    static NavX gyro;
    static Subsystem[] req = {drive, gyro};
    static DoubleSupplier zAng = () -> gyro.getzAngle();
    static DoubleConsumer output;
    static double goal = 0;

    @Override
    public void initialize(){
        gyro.resetGyro();
    }

    @Override
    public void execute(){
        SmartDashboard.putString("STATUS ANGULANTING", "ANGULATING BY" + goal);
        SmartDashboard.putString("% TO CONCLUDE", zAng.getAsDouble()/goal + "%");
    }

    @Override
    public void end(boolean interrupted) {
        drive.motorPower(0, 0);
    }

    @Override
    public boolean isFinished() {
        return getController().atSetpoint();
    }

}
