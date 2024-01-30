package frc.robot.Subsystems.Sensors;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class NavX extends SubsystemBase{

    private AHRS navX;
    private double zA = 0, xA = 0, yA = 0;

    public NavX(){
        navX = new AHRS(Port.kMXP);
    }

    public double getzAngle() {
        return zA;
    }

    public double getxAngle() {
        return xA;
    }

    public double getyAngle() {
        return yA;
    }

    public void resetGyro(){
        navX.reset();
    }
    
    
}
