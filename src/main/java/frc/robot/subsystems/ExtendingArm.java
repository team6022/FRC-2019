package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.*;

/**
 * Add description here
 */
public class ExtendingArm extends Subsystem {

	static Talon LowerArmLeft = new Talon(RobotMap.LowerArmLeft);
	static Talon LowerArmRight = new Talon(RobotMap.LowerArmRight);
	static Talon UpperArmLeft = new Talon(RobotMap.UpperArmLeft);
	static Talon UpperArmRight = new Talon(RobotMap.UpperArmRight);

	static Encoder LowerEncoder =  new Encoder(0, 1, false, Encoder.EncodingType.k4X);

	public ExtendingArm()
	{
		super();
	}

	public void initDefaultCommand()
	{

	}

	public void MoveLowerArm(Joystick Branjoy)
	{
		LowerEncoder.reset();
		LowerArmLeft.set(0.5);
		LowerArmRight.set(0.5);
		System.out.println(LowerEncoder.get());
	}

	public void MoveUpperArm(Joystick Branjoy)
	{
		UpperArmLeft.set(0.5);
		UpperArmRight.set(0.5);
	}
}
