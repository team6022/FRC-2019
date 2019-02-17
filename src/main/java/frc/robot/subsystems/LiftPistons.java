package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * Add description here
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


	public void FrontPistonsActive(boolean isActive)
	{
		if (isActive) {
			DSFront.set(DoubleSolenoid.Value.kForward);
		} else {
			DSFront.set(DoubleSolenoid.Value.kReverse);
		}
		SmartDashboard.putBoolean("FrontLiftPistonsOut", isActive);
	}

	public void BackPistonsActive(boolean isActive)
	{
		if (isActive) {
			DSBack.set(DoubleSolenoid.Value.kForward);
		} else {
			DSBack.set(DoubleSolenoid.Value.kReverse);
		}
		SmartDashboard.putBoolean("FrontLiftPistonsOut", isActive);
	}
}
