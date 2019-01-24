package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

public class VelcroPistons extends Subsystem {

	static DoubleSolenoid doubleSolenoidLeft = new DoubleSolenoid(RobotMap.VelcroPistonsLeftForwardChannel, RobotMap.VelcroPistonsLeftReverseChannel);

	public VelcroPistons()
	{
		super();
	}

	public void initDefaultCommand()
	{

	}

	public void PistonsOut(Joystick Branjoy)
	{
		doubleSolenoidLeft.set(DoubleSolenoid.Value.kForward);
	}

	public void PistonsIn(Joystick Branjoy)
	{
		doubleSolenoidLeft.set(DoubleSolenoid.Value.kReverse);
	}
}
