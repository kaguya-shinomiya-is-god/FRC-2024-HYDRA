package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;

public class TriangleATTracker extends CommandBase{
    private final DriveSubsystem drive;
    private double xDistance = 0;
    private double hip = 0;

    public TriangleATTracker(DriveSubsystem subsystem){
        drive = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize(){}

    @Override
    public void execute(){}

    @Override
    public boolean isFinished(){
        return true;
    }

    @Override
    public void end(boolean interrupted){

    }

}
