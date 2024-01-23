package frc.robot.Subsystems.Sensors;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
    private AHRS gyro;
    private double zAngle, yAngle, xAngle;

    public GyroSubsystem(){
        gyro = new AHRS(Port.kMXP);
        zAngle = 0;
        yAngle = 0;
        xAngle = 0;
    }

    @Override
    public void periodic(){
        zAngle = gyro.getAngle();
    }

    public double getZAngle(){
        return zAngle;
    }

    

}
