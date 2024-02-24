package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.Sensors.LimelightSubsystem;

public class ATFinder extends Command{
    private LimelightSubsystem lime;
    private DriveSubsystem drive;
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

    }

    @Override
    public void end(boolean interrupted){
        drive.motorPower(0, 0);
    }

    @Override
    public boolean isFinished(){
        return find;
    }
}
