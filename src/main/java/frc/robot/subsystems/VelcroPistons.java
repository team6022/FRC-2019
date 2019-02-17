package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;

/**
 * Add description here
 */
public class VelcroPistons extends Subsystem {

	static DoubleSolenoid doubleSolenoid = new DoubleSolenoid(RobotMap.VelcroPistonsForwardChannel, RobotMap.VelcroPistonsReverseChannel);

	public VelcroPistons()
	{
		super();
	}

	public void initDefaultCommand()
	{
	}

	public void Toggle()
	{
		Active(true);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Active(false);
	}

	public void Active(boolean isActive)
	{
		doubleSolenoid.set((isActive) ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
		SmartDashboard.putBoolean("VelcroPistonsOut", true);
	}
}
