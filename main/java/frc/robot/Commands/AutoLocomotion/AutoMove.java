package frc.robot.Commands.AutoLocomotion;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.Sensors.EncoderTB;

public class AutoMove extends PIDCommand{

    public AutoMove(double setpoint) {
        super(new PIDController(Constants.AUTOMOVE_kP, Constants.AUTOMOVE_kI, Constants.AUTOMOVE_kD), 
        encodingValue, setpoint, (output) -> drive.motorPower(0, output), req);
        this.point = setpoint;
        encoder = new EncoderTB();
    }

    static EncoderTB encoder;
    static DriveSubsystem drive;
    static Subsystem[] req = {drive, encoder};
    private double point = 0;
    
    private static DoubleSupplier encodingValue = () -> encoder.encoderDistance();

    
    @Override
    public void initialize() {
        encoder.resetEncoder();
    }

    @Override
    public void execute() {
        SmartDashboard.putString("STATUS MOVING", "MOVING BY" + point + " cm");
        SmartDashboard.putString("% TO CONCLUDE", (encodingValue.getAsDouble() / point) + " %");
    }

    @Override
    public void end(boolean interrupted) {
        drive.motorPower(0, 0);
        SmartDashboard.putString("STATUS MOVING", "FINISHED");
    }


    @Override
    public boolean isFinished() {
        return getController().atSetpoint();
    }
    
}
