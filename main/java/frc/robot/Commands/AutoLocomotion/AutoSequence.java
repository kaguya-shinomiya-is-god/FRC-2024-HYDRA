package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Subsystems.Locomotion.DriveSubsystem;

public class AutoSequence extends SequentialCommandGroup{

    private AutoAngle AA;
    private AutoAngle AA2;
    private AutoMove AM;

    public AutoSequence(DriveSubsystem drive, double ang1, double ang2, double position){
        this.AA = new AutoAngle(drive, ang1);
        this.AA2 = new AutoAngle(drive, ang2);
        this.AM = new AutoMove(drive, position);
        addRequirements(drive);
        addCommands(
            this.AA, this.AM, this.AA2
        );
    }


    
}
