package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

public class VelcroPistons extends Subsystem {

	static DoubleSolenoid doubleSolenoidLeft = new DoubleSolenoid(RobotMap.VelcroPistonsLeftForwardChannel, RobotMap.VelcroPistonsLeftReverseChannel);
	static DoubleSolenoid doubleSolenoidRight = new DoubleSolenoid(RobotMap.VelcroPistonsRightForwardChannel, RobotMap.VelcroPistonsRightReverseChannel);

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
		doubleSolenoidRight.set(DoubleSolenoid.Value.kForward);
	}

	public void PistonsIn(Joystick Branjoy)
	{
		doubleSolenoidLeft.set(DoubleSolenoid.Value.kReverse);
		doubleSolenoidRight.set(DoubleSolenoid.Value.kReverse);
	}
}
