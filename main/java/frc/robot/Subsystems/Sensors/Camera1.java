package frc.robot.Subsystems.Sensors;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Camera1 extends SubsystemBase{
    UsbCamera camera1;
    NetworkTableEntry cameraSelect;

    public Camera1(){
        camera1 = CameraServer.startAutomaticCapture(0);
        cameraSelect = NetworkTableInstance.getDefault().getTable("").getEntry("CameraSelection");

        cameraSelect.setString(camera1.getName());
    }
}
