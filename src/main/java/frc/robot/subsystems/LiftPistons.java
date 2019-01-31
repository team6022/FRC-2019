package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

public class LiftPistons extends Subsystem {

	static DoubleSolenoid doubleSolenoid = new DoubleSolenoid(RobotMap.VelcroPistonsLeftForwardChannel, RobotMap.VelcroPistonsLeftReverseChannel);

	public LiftPistons()
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
