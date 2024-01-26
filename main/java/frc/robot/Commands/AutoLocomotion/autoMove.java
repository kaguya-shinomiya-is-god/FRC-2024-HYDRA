package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.Sensors.EncoderSubsytem;

public class autoMove extends CommandBase{
    private final DriveSubsystem drive;
    private final EncoderSubsytem encoder;
    private double fDistance = 0;
    private double remain = 0;
    private double encoderValue = 0;


    public autoMove(DriveSubsystem subsystem, EncoderSubsytem encodersub, double x){
        this.drive = subsystem;
        this.encoder = encodersub;
        this.fDistance = x;
        addRequirements(subsystem);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){
        //encoderValue = encoder.getEnconderDistance();
        remain = fDistance - encoderValue;
        drive.motorPower(Constants.kSlowSpd, Constants.kSlowSpd);

        if(remain >= 0)
            isFinished();
        
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted){
        drive.motorPower(0, 0);
        //encoder.resetEncoder();
    }

}
