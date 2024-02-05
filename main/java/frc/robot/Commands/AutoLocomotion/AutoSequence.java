package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoSequence extends SequentialCommandGroup{

    private AutoAngle AA;
    private AutoMove AM;

    public AutoSequence(AutoAngle AA, AutoMove AM){
        this.AA = AA;
        this.AM = AM;
        addCommands(
            AA, AM
        );
    }


    
}
