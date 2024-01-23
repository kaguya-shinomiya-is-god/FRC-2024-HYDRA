package frc.robot.Subsystems.Sensors;

import edu.wpi.first.wpilibj.Encoder;
import frc.robot.Constants;

public class EncoderSubsytem {
    Encoder encoder;
    

    public EncoderSubsytem(){
        encoder = new Encoder(Constants.ENCODER_A_PORT, Constants.ENCODER_B_PORT);
        encoder.reset();
    }

    public double getEnconderDistance(){
        return encoder.getDistance();
    }
    
    public void resetEncoder(){
        encoder.reset();
    }
}
