package frc.robot.Subsystems.Sensors;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class EncoderTB extends SubsystemBase{
    private Encoder encoder;

    public EncoderTB(){
        encoder = new Encoder(Constants.ENCODER_A_PORT, Constants.ENCODER_B_PORT);
        encoder.setDistancePerPulse(36);
    }

    public void resetEncoder(){
        encoder.reset();
    }

    public double encoderDistance(){
        return encoder.getDistance();
    }
    
}
