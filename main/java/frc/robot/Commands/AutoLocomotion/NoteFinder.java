package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.LimelightHelpers;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;
import frc.robot.Subsystems.Sensors.LimelightSubsystem;

public class NoteFinder extends CommandBase{
    DriveSubsystem driver;
    LimelightSubsystem lime;
    boolean find = false;

    public NoteFinder(DriveSubsystem driver, LimelightSubsystem lime){
        this.lime = lime;
        this.driver = driver;
        addRequirements(driver,lime);
    }

    @Override
    public void initialize(){
        LimelightHelpers.setPipelineIndex("Python", 2);
    }

    @Override
    public void execute(){
        find = lime.getTargetLime();

        if(!find)
            driver.motorPower(Constants.kNormalSpd, -Constants.kNormalSpd);

    }

    @Override
    public void end(boolean interrupted){
        driver.motorPower(0, 0);
    }

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return find;
    }
}
