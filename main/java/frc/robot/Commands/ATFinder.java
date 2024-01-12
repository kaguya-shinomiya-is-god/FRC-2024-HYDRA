package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.DriveSubsystem;
import frc.robot.Subsystems.LimelightSubsystem;

public class ATFinder extends CommandBase{
    private LimelightSubsystem lime;
    private DriveSubsystem drive;
    private boolean find = false;

    public ATFinder(LimelightSubsystem limeSub, DriveSubsystem driveSub){
        this.lime = limeSub;
        this.drive = driveSub;
    }

    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        find = lime.getTargetLime();

        if(!find){
            drive.motorPower(Constants.kNormalSpd, -Constants.kNormalSpd);
        }
        else {
            drive.motorPower(0, 0);
            isFinished();
        }
    }

    @Override
    public boolean isFinished(){
        return true;
    }
}
