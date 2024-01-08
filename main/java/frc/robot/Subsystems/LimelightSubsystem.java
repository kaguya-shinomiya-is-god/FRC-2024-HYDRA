package frc.robot.Subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightSubsystem {
    NetworkTable lime = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = lime.getEntry("tx");
    NetworkTableEntry ty = lime.getEntry("ty");
    NetworkTableEntry ta = lime.getEntry("ta");

    private double x = tx.getDouble(0.0);
    private double y = ty.getDouble(0.0);
    private double a = ta.getDouble(0.0);

    public LimelightSubsystem(){
    }

    public double getLimeXValue(){
        return x;
    }

    public double getLimeYValue(){
        return y;
    }

    public double getLimeAreaValue(){
        return a;
    }
        
}
