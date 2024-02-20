package frc.robot.Commands.AutoLocomotion;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Subsystems.ScoreSystem.CaptureSubsytem;

public class NoteCollector extends CommandBase{
    CaptureSubsytem cap;

    public NoteCollector(CaptureSubsytem cSubsytem){
        this.cap = cSubsytem;
        addRequirements(cSubsytem);
    }


    @Override
    public void execute() {
        cap.getNote();
    }

    @Override
    public void end(boolean interrupted) {
        cap.getOff();
    }
    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return cap.noteIsOn();
    }

    
}
