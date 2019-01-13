package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.*;

public class VelcroPistons extends Subsystem {

	static DoubleSolenoid doubleSolenoid = new DoubleSolenoid(0, 1);

	public double ExpotentialY;
	public double ExpotentialX = 1;

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
