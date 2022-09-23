package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PneumaticsSystem extends SubsystemBase {
	private final Solenoid solenoid;

	public PneumaticsSystem() {
		solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.Pneumatics.SOLENOID_1);
		solenoid.close();
		solenoid.set(false);
	}

	public void set(boolean set) {
		solenoid.set(set);
	}
}
