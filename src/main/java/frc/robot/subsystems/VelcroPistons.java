package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

public class VelcroPistons extends Subsystem {

	static DoubleSolenoid doubleSolenoid = new DoubleSolenoid(RobotMap.VelcroPistonsForwardChannel, RobotMap.VelcroPistonsReverseChannel);

	public VelcroPistons()
	{
		super();
	}

	public void initDefaultCommand()
	{

	}

	public void PistonOut(Joystick Branjoy)
	{
		doubleSolenoid.set(DoubleSolenoid.Value.kForward);
	}

	public void PistonIn(Joystick Branjoy)
	{
		doubleSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
}
