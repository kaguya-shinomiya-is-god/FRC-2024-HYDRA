package frc.robot.Subsystems.ScoreSystem;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubystem extends SubsystemBase{
    
    private Solenoid climbLeftF,climbLeftR;
    
    public ClimbSubystem(){
        climbLeftF = new Solenoid(PneumaticsModuleType.REVPH,
            Constants.SOLENOID_CLIMBING_FOWARD_ID);

        climbLeftR = new Solenoid(PneumaticsModuleType.REVPH, 
            Constants.SOLENOID_CLIMBING_BACK_ID);
    }

    @Override
    public void periodic(){
        SmartDashboard.putBoolean("Climbing Up Valve", climbLeftF.get());
        SmartDashboard.putBoolean("Climbing Down Valve", climbLeftR.get());
    }

    public void getUpClimbing(){
        climbLeftF.set(true);
        climbLeftR.set(false);
    }

    public void getDownClimbing(){
        climbLeftF.set(false);
        climbLeftR.set(true);
    }

    public void climbingOff(){
        climbLeftF.set(false);
        climbLeftR.set(false);
    }
        
    


}
