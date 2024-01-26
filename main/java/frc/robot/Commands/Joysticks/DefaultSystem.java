package frc.robot.Commands.Joysticks;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Subsystems.ScoreSystem.AngularPlatSubsystem;
import frc.robot.Subsystems.ScoreSystem.CaptureSubsytem;
import frc.robot.Subsystems.ScoreSystem.ClimbSubystem;
import frc.robot.Subsystems.ScoreSystem.LauncherSubystem;

public class DefaultSystem extends CommandBase{
    private AngularPlatSubsystem angPlat;
    private ClimbSubystem climb;
    private LauncherSubystem launcher;
    private CaptureSubsytem cap;
    private Joystick systemController;

    private double spd;

    public DefaultSystem(AngularPlatSubsystem angularSub, CaptureSubsytem coletaSub,
                         ClimbSubystem escaladaSub, LauncherSubystem lancamentoSub,
                         Joystick joystick2){

    this.angPlat = angularSub;
    this.climb = escaladaSub;
    this.cap = coletaSub;
    this.launcher = lancamentoSub;
    this.systemController = joystick2;

    addRequirements(angPlat, climb, launcher, cap);
    }

    @Override
    public void initialize(){

    }

    @Override
    public void execute(){

        capture(systemController.getRawButton(Constants.BUTTON_A));
        shoot(systemController.getRawButton(Constants.BUTTON_X));
        
    }

    private void capture(boolean button){
        if(button) 
        cap.getNote();

        else cap.getOff();
    }

    private void shoot(boolean button){
        if(button) 
        launcher.launcherShooter();

        else launcher.launcherShooterOff();
    }
}
