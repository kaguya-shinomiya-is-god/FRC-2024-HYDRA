package frc.robot.Utils;

import edu.wpi.first.wpilibj.shuffleboard.BuiltInLayouts;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

public class ShuffleBoardClass {

    public static ShuffleboardTab LocomotionTab = Shuffleboard.getTab("Locomotion");
    public static ShuffleboardTab systemsTab = Shuffleboard.getTab("ScoreSystem");

    private static ShuffleboardLayout L_Spd = Shuffleboard.getTab("Locomotion").
                                            getLayout("Motor Speeds", BuiltInLayouts.kGrid). 
                                            withSize(2, 1);
    private static ShuffleboardLayout L_Sensors = Shuffleboard.getTab("Locomotion"). 
                                            getLayout("Sensors Data", BuiltInLayouts.kList);

    public static ShuffleboardLayout getLocomotionSpeeds(){
        return L_Spd;
    }

    public static ShuffleboardLayout getLocomotionSensors(){
        return L_Sensors;
    }
}
