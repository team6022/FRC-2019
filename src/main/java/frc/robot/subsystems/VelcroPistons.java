package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;


/**
 * Controls the front velcro pistons
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

	/**
	 * Toggles the front velcro pistons for 1 second
	 * (probably don't run this since it sleeps the entire thread and the robot freezes)
	 */
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

	/**
	 * Activates the front velcro pistons
	 *
	 * @param isActive bool - should pistions be extended or not
	 */
	public void Active(boolean isActive)
	{
		doubleSolenoid.set((isActive)
			? DoubleSolenoid.Value.kForward
			: DoubleSolenoid.Value.kReverse);
		SmartDashboard.putBoolean("VelcroPistonsOut", isActive);
	}
}
