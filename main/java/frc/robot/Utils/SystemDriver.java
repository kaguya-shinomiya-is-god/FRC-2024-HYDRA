package frc.robot.Utils;

import frc.robot.Constants;

public class SystemDriver {
    
    public static double auxiliarMotorSpdAdjust(double spd){
        if(spd < 1) return spd += 0.25;
        else return spd -= 1;
    }

    public double angleForRotation(double angle_in_degrees){
        double rotations = (angle_in_degrees/360) * Constants.CHASSIS_CIRCUNFERENCE;
        return rotations;
    }

    public String whichSolenoidActivated(boolean left, boolean on){
        if(on){
            if(left)
                return "AIR INPUT";

            return "AIR OUTPUT";
        }
        return "AIR CLOSED";
        
    }

    public String whichLauncherIsOn(boolean speaker, boolean on){
        if(on){
            if(speaker)
                return "SPEAKER OUTPUT";
            return "AMP OUTPUT";
        }
        return "LAUNCHER OFF";
    }
}
