package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.ScoreSystem.LimelightSubsystem;

public class ATFinder extends CommandBase{
    private LimelightSubsystem lime;
    private DriveSubsystem drive;
    private boolean lSide = false;
    private boolean find = false;

    public ATFinder(LimelightSubsystem limeSub, DriveSubsystem driveSub){
        this.lime = limeSub;
        this.drive = driveSub;

        addRequirements(lime,drive);
    }

    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        find = lime.getTargetLime();

        if(!find)
            drive.motorPower(Constants.kNormalSpd, -Constants.kNormalSpd);
        else 
            isFinished();

    }

    @Override
    public void end(boolean interrupted){
         
    }

    @Override
    public boolean isFinished(){
        drive.motorPower(0, 0);
        return true;
    }
}
