package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;

public class SetToAngle extends CommandBase{
    private double angle,dAngle,updatedAngle = 0;
    private double angleSpd = 0;
    private DriveSubsystem driver;

    public SetToAngle(DriveSubsystem subsystem, double toAngle){
        this.driver = subsystem;
        this.angle = toAngle;
        addRequirements(driver);
    }

    @Override
    public void initialize(){
        dAngle = angle;
        driver.navx.reset();
    }

    @Override
    public void execute(){
        updatedAngle = driver.navx.getAngle();
        angleSpd = (dAngle/360)*4;

        if(Math.abs(angleSpd) > Constants.kNormalSpd) 
        Math.copySign(Constants.kNormalSpd, angleSpd);

        driver.motorPower(angleSpd,-angleSpd);
        dAngle = angle - updatedAngle;

        if(Math.abs(dAngle) <= 5) 
        isFinished();
    }

    @Override
    public void end(boolean interrupted){
        driver.motorPower(0,0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
