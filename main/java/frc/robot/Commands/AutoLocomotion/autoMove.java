package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;

public class autoMove extends CommandBase{
    private final DriveSubsystem drive;
    private double fDistance = 0;
    private double momentum = 0;
    private double encoderValue = 0;


    public autoMove(DriveSubsystem subsystem, double x){
        this.drive = subsystem;
        this.fDistance = x;
        addRequirements(subsystem);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){
        encoderValue = drive.getEnconderDistance();
        momentum = fDistance - encoderValue;
        drive.motorPower(Constants.kSlowSpd, Constants.kSlowSpd);

        if(momentum >= 0)
            isFinished();
        
    }

    @Override
    public boolean isFinished(){
        return true;
    }

    @Override
    public void end(boolean interrupted){
        drive.motorPower(0, 0);
        drive.resetEncoder();
    }

}
