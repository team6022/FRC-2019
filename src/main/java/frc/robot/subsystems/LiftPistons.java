package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

/**
 * Add description here
 */
public class LiftPistons extends Subsystem {

	static DoubleSolenoid doubleSolenoid1 = new DoubleSolenoid(RobotMap.BackLiftPistonsForwardChannel, RobotMap.BackLiftPistonsReverseChannel);
	static DoubleSolenoid doubleSolenoid2 = new DoubleSolenoid(RobotMap.FrontLiftPistonsForwardChannel, RobotMap.FrontLiftPistonsReverseChannel);

	public LiftPistons()
	{
		super();
	}

	public void initDefaultCommand()
	{

	}

	public void BackPistonsOut(Joystick Branjoy)
	{
		doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
	}

	public void BackPistonsIn(Joystick Branjoy)
	{
		doubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
	}

	public void FrontPistonsOut(Joystick Branjoy)
	{
		doubleSolenoid2.set(DoubleSolenoid.Value.kForward);
	}

	public void FrontPistonsIn(Joystick Branjoy)
	{
		doubleSolenoid2.set(DoubleSolenoid.Value.kReverse);
	}
}
