package frc.robot.Subsystems.ScoreSystem;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class ClimbSubsystem {
    private Solenoid sole1; 
    private Solenoid sole2;
    private Compressor comp;

    public ClimbSubsystem(int channel_1, int channel_2){
        this.sole1 = new Solenoid(PneumaticsModuleType.REVPH,channel_1);
        this.sole2 = new Solenoid(PneumaticsModuleType.REVPH, channel_2);
        this.comp = new Compressor(PneumaticsModuleType.REVPH);

        sole1.set(true);
        sole2.set(true);
        comp.enableAnalog(100, 120);
    }

    @Ove

    public void goUP(){
        sole1.set(true);
        sole2.set(false);
    }

    public void goDOWN(){
        sole1.set(false);
        sole2.set(true);
    }

    public void closeDoors(){
        sole1.set(true);
        sole2.set(true);
    }
}
