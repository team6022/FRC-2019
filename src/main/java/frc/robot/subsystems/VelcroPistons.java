package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

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

	public void PistonsOut(Joystick Branjoy)
	{
		doubleSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void PistonsIn(Joystick Branjoy)
	{
		doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
}
