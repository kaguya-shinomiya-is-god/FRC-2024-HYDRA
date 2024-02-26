package frc.robot.Commands.AutoLocomotion;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.ScoreSystem.CaptureSubsytem;

public class NoteCollector extends Command{
    CaptureSubsytem cap;
    Timer tim = new Timer();
    DoubleSupplier timValue = (() -> tim.get());

    public NoteCollector(CaptureSubsytem cap){
        this.cap = cap;
    }

    @Override
    public void initialize(){
        cap.getNote();
        tim.start();
    }

    @Override
    public void end(boolean interrupted) {
        cap.getOff();
        tim.stop();
        tim.reset();
    }

    public DoubleSupplier sup(){
        return timValue;
    }

    @Override
    public boolean isFinished() {
        return (tim.get() > 5);
    }
    

}
