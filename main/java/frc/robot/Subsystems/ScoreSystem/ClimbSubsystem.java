package frc.robot.Subsystems.ScoreSystem;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Utils.ShuffleBoardClass;
import frc.robot.Utils.SystemDriver;

public class ClimbSubsystem extends SubsystemBase{
    private Solenoid sole1; 
    private Solenoid sole2;
    private Compressor comp;
    double pressure = 0;
    private SystemDriver sysdriver;
    private boolean sideL,on = false;

    public ClimbSubsystem(int channel_1, int channel_2){
        this.sole1 = new Solenoid(PneumaticsModuleType.REVPH,channel_1);
        this.sole2 = new Solenoid(PneumaticsModuleType.REVPH, channel_2);
        this.comp = new Compressor(PneumaticsModuleType.REVPH);
        sysdriver = new SystemDriver();

        sole1.set(true);
        sole2.set(true);
        comp.enableAnalog(100, 120);
        initShuffleboard();
    }

    @Override
    public void periodic() {
        pressure = comp.getPressure();
        SmartDashboard.putNumber("Pressure", pressure - (pressure % 12));

        if(sole1.get() || sole2.get()) on = true;
        else on = false; 

        if(sole1.get()) sideL = true;
        if(sole2.get()) sideL = false;
    }

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

    private void initShuffleboard(){
;
        ShuffleBoardClass.getSensors().add("Solenoid 1", sole1.get());
        ShuffleBoardClass.getSensors().add("Solenoid 2", sole2.get());
        ShuffleBoardClass.getSensors().add("AIR STATUS", sysdriver.whichSolenoidActivated(sideL,on));
    }
}
