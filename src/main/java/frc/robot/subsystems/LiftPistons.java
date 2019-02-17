package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * Lift and drops bottom pistons
 */
public class LiftPistons extends Subsystem {

	static DoubleSolenoid DSFront = new DoubleSolenoid(RobotMap.BackLiftPistonsForwardChannel, RobotMap.BackLiftPistonsReverseChannel);
	static DoubleSolenoid DSBack = new DoubleSolenoid(RobotMap.FrontLiftPistonsForwardChannel, RobotMap.FrontLiftPistonsReverseChannel);


	public LiftPistons()
	{
		super();
	}

	public void initDefaultCommand()
	{
	}

	/**
	* FrontPistonsActive toggles the front pistons
	*/
	public void FrontActive(boolean isActive)
	{
		DSFront.set((isActive) ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
		SmartDashboard.putBoolean("FrontLiftPistonsOut", isActive);
	}

	/**
	* FrontPistonsActive toggles the back pistons
	*/
	public void BackActive(boolean isActive)
	{
		DSBack.set((isActive) ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
		SmartDashboard.putBoolean("FrontLiftPistonsOut", isActive);
	}
}
